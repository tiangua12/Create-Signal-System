package com.easttown.createsignalsystem.block.entity;

import com.easttown.createsignalsystem.init.ModBlockEntities;
import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.easttown.createsignalsystem.util.ModLogger;
import com.simibubi.create.content.trains.graph.EdgePointType;
import javax.annotation.Nullable;
import com.simibubi.create.content.trains.signal.SignalBoundary;
import com.simibubi.create.content.trains.signal.SignalBlockEntity;
import com.simibubi.create.content.trains.signal.SignalEdgeGroup;
import com.simibubi.create.content.trains.signal.TrackEdgePoint;
import com.simibubi.create.content.trains.track.TrackTargetingBehaviour;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.*;
import com.simibubi.create.content.trains.graph.TrackGraph;
import com.simibubi.create.content.trains.graph.TrackNode;
import com.simibubi.create.content.trains.graph.TrackEdge;
import com.simibubi.create.content.trains.graph.TrackNodeLocation;
import com.simibubi.create.content.trains.entity.TravellingPoint;
import com.simibubi.create.foundation.utility.Couple;
import com.simibubi.create.foundation.utility.Pair;

public class SignalStateDisplayBlockEntity extends SignalBlockEntity {

    // 四显示信号状态枚举
    public enum FourAspectSignalState {
        RED("红色"),
        YELLOW("黄色"),
        GREEN_YELLOW("绿黄"),
        GREEN("绿色"),
        INVALID("无效");

        private final String displayName;

        FourAspectSignalState(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    // 基础信号字段（继承自SignalBlockEntity）
    // edgePoint、state、lastReportedPower 已从父类继承

    // 日志记录器
    private final ModLogger logger = ModLogger.getLogger();

    // 四显示信号数据
    private final UUID[] signalGroupIds = new UUID[4]; // 4个信号组ID (0:当前, 1-3:前方)
    private final boolean[] occupancyStates = new boolean[4]; // 对应信号组的占用状态
    private FourAspectSignalState fourAspectState = FourAspectSignalState.INVALID;

    // 红石控制
    private int lastRedstoneSignal = 0;
    private int currentRoute = 1; // 当前进路 (1-6)
    private boolean forceRed = false; // 强制红灯标志 (红石信号7-15)
    private boolean localLastReportedPower = false; // 本地红石输出状态跟踪

    // 边界ID用于显示 (可选)
    private final String[] boundaryIds = new String[4];

    // TravellingPoint移动统计
    private int travelCallCount = 0; // travel()调用次数
    private double totalTravelDistance = 0.0; // 累计移动总距离
    private double lastTravelDistance = 0.0; // 上次移动距离

    // 性能优化：减少寻路调用频率
    private int tickCounter = 0;
    private static final int PATHFINDING_INTERVAL = 20; // 每20个tick（1秒）执行一次寻路
    private SignalBoundary lastCheckedBoundary = null; // 上次检查的信号边界，用于检测变化

    // 占用状态去抖动：防止信号快速闪烁
    private final int[] occupancyDebounceCounters = new int[4]; // 每个信号组的去抖动计数器
    private static final int DEBOUNCE_THRESHOLD = 4; // 需要连续4个tick（0.2秒）的相同状态才认为有效

    // 构造函数
    public SignalStateDisplayBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        // 父类已初始化state为INVALID，lastReportedPower为false
        // 初始化数组
        Arrays.fill(boundaryIds, "");
    }

    public SignalStateDisplayBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.SIGNAL_STATE_DISPLAY.get(), pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        // 调用父类方法以添加edgePoint行为
        super.addBehaviours(behaviours);
    }

    @Nullable
    public SignalBoundary getSignal() {
        return edgePoint.getEdgePoint();
    }

    @Override
    public void tick() {
        super.tick();
        if (level.isClientSide)
            return;

        // 1. 更新红石信号和进路选择
        updateRedstoneSignal();

        // 2. 获取当前信号边界
        SignalBoundary currentBoundary = getSignal();
        if (currentBoundary == null) {
            enterState(SignalBlockEntity.SignalState.INVALID);
            resetDetectionData();
            lastCheckedBoundary = null;
            return;
        }

        // 3. 更新当前信号组ID（索引0）
        updateCurrentSignalGroupId(currentBoundary);

        // 4. 条件性执行寻路：每PATHFINDING_INTERVAL个tick或信号边界变化时执行
        tickCounter++;
        boolean shouldFindGroups = false;

        // 检查是否需要重新寻路
        if (tickCounter >= PATHFINDING_INTERVAL) {
            shouldFindGroups = true;
            tickCounter = 0; // 重置计数器
        } else if (lastCheckedBoundary == null || !lastCheckedBoundary.id.equals(currentBoundary.id)) {
            // 信号边界发生变化（新连接或重新连接）
            shouldFindGroups = true;
        }

        if (shouldFindGroups) {
            // 使用TravellingPoint寻路收集前方信号组ID（索引1-3）
            findForwardSignalGroups(currentBoundary);
            lastCheckedBoundary = currentBoundary;
        }

        // 5. 更新所有信号组的占用状态（每次tick都检查，因为占用状态可能随时变化）
        updateOccupancyStates();

        // 调试：显示信号组ID和占用状态
        logger.debug("[{}] 信号组ID状态: [0]={}, [1]={}, [2]={}, [3]={}",
                worldPosition, signalGroupIds[0], signalGroupIds[1], signalGroupIds[
                2], signalGroupIds[3]);
        logger.debug("[{}] 占用状态: [0]={}, [1]={}, [2]={}, [3]={}",
                worldPosition, occupancyStates[0], occupancyStates[1], occupancyStates[
                2], occupancyStates[3]);

        // 6. 计算四显示信号状态
        fourAspectState = calculateFourAspectSignal();
        logger.debug("[{}] 计算四显示信号状态: {}", worldPosition, fourAspectState);

        // 7. 转换为原始信号状态并更新
        SignalBlockEntity.SignalState newState = convertToSignalState(fourAspectState);
        logger.debug("[{}] 转换为基础信号状态: {}", worldPosition, newState);
        // 只有当状态实际变化时才调用enterState，避免不必要的更新
        if (newState != getState()) {
            enterState(newState);
        }

        // 8. 更新红石信号输出（红灯时输出信号）
        updateRedstoneOutput();

        // 9. 标记数据已更新
        setChanged();
    }

    // 更新红石信号和进路选择
    private void updateRedstoneSignal() {
        int redstoneSignal = level.getBestNeighborSignal(worldPosition);
        if (redstoneSignal != lastRedstoneSignal) {
            lastRedstoneSignal = redstoneSignal;
            // 红石信号1-6：选择进路
            if (redstoneSignal >= 1 && redstoneSignal <= 6) {
                currentRoute = redstoneSignal;
                forceRed = false;
            } else if (redstoneSignal == 0) {
                // 无信号时保持当前进路，清除强制红灯
                forceRed = false;
            } else {
                // 信号强度7-15：强制红灯
                forceRed = true;
                // 进路保持原值，不改变
            }
            setChanged();
        }
    }

    @Override
    public boolean getReportedPower() {
        // 红石信号强度7-15：强制红灯
        if (forceRed) {
            return true;
        }
        // 红石信号强度1-6：不强制红灯（仅用于进路选择）
        if (lastRedstoneSignal >= 1 && lastRedstoneSignal <= 6) {
            return false;
        }
        // 其他情况：使用父类逻辑（红石信号强度0或>15的情况）
        return super.getReportedPower();
    }

    // 重置检测数据
    private void resetDetectionData() {
        Arrays.fill(signalGroupIds, null);
        Arrays.fill(occupancyStates, false);
        Arrays.fill(boundaryIds, "");
        Arrays.fill(occupancyDebounceCounters, 0); // 重置去抖动计数器
        fourAspectState = FourAspectSignalState.INVALID;
        lastCheckedBoundary = null; // 重置上次检查的边界
    }

    // 更新当前信号组ID（索引0）
    private void updateCurrentSignalGroupId(SignalBoundary boundary) {
        if (boundary == null) {
            signalGroupIds[0] = null;
            boundaryIds[0] = "";
            return;
        }

        // 确定当前方块在边界的哪一侧
        boolean isFirstSide = boundary.blockEntities.getFirst().containsKey(worldPosition);
        boolean isSecondSide = boundary.blockEntities.getSecond().containsKey(worldPosition);

        if (!isFirstSide && !isSecondSide) {
            logger.warn("方块不在边界{}的任何一侧！位置: {}", boundary.id, worldPosition);
            signalGroupIds[0] = null;
            boundaryIds[0] = boundary.id.toString();
            return;
        }

        boolean primary = isFirstSide; // 在第一侧为true，在第二侧为false
        logger.debug("updateCurrentSignalGroupId: 边界={}, 在第一侧={}, 在第二侧={}, primary={}",
                boundary.id, isFirstSide, isSecondSide, primary);

        // 获取该侧的信号组ID（使用Couple的正确访问方式）
        UUID groupId = primary ? boundary.groups.getFirst() : boundary.groups.getSecond();
        signalGroupIds[0] = groupId;
        boundaryIds[0] = boundary.id.toString();

        logger.debug("当前信号组ID[0]: {}, 边界groups: first={}, second={}",
                groupId, boundary.groups.getFirst(), boundary.groups.getSecond());
    }

    // 使用TravellingPoint寻路收集前方信号组ID（索引1-3）
    private void findForwardSignalGroups(SignalBoundary currentBoundary) {
        logger.debug("[{}] === findForwardSignalGroups 开始 ===", worldPosition);
        logger.debug("[{}] 当前边界ID: {}", worldPosition, currentBoundary.id);

        // 清空前方的槽位（1-3）
        for (int i = 1; i < 4; i++) {
            signalGroupIds[i] = null;
            boundaryIds[i] = "";
        }

        // 获取当前边界所在的轨道图和位置
        Couple<TrackNodeLocation> nodeLocations = currentBoundary.edgeLocation;
        if (nodeLocations == null) {
            logger.debug("[{}] ✗ 边界没有节点位置信息", worldPosition);
            return;
        }
        logger.debug("[{}] 边界节点位置: {} -> {}", worldPosition, nodeLocations.getFirst(), nodeLocations.getSecond());

        // 查找包含当前边界的轨道图
        TrackGraph graph = findContainingGraph(nodeLocations);
        if (graph == null) {
            logger.debug("[{}] ✗ 找不到包含边界的轨道图", worldPosition);
            return;
        }
        logger.debug("[{}] ✓ 找到轨道图，ID: {}", worldPosition, graph.id);

        // 输出轨道图详细信息
        Set<TrackNodeLocation> allNodeLocations = graph.getNodes();
        logger.debug("[{}] 轨道图规模: 节点数={}", worldPosition, allNodeLocations.size());

        // 计算边数和输出节点连接情况（最多前10个节点，避免日志过多）
        int totalConnections = 0;
        int nodeIndex = 0;
        List<TrackNode> nodeList = new ArrayList<>();

        for (TrackNodeLocation location : allNodeLocations) {
            TrackNode node = graph.locateNode(location);
            if (node == null) continue;
            nodeList.add(node);

            if (nodeIndex < 10) {
                int connections = graph.getConnectionsFrom(node).size();
                totalConnections += connections;
                logger.debug("[{}]   节点{}: 位置={}, 连接数={}",
                        worldPosition, nodeIndex, location, connections);
                nodeIndex++;
            }
        }

        // 估计边数：总连接数除以2（因为每条边被两个节点记录）
        int estimatedEdges = totalConnections / 2;
        logger.debug("[{}]   估计边数: {} (基于{}个节点的连接统计)", worldPosition, estimatedEdges, Math.min(nodeList.size(), 10));
        if (allNodeLocations.size() > 10) {
            logger.debug("[{}]   ... 还有{}个节点未显示", worldPosition, allNodeLocations.size() - 10);
        }

        // 检查当前边界连接的节点是否在轨道图中
        TrackNode nodeA = graph.locateNode(nodeLocations.getFirst());
        TrackNode nodeB = graph.locateNode(nodeLocations.getSecond());
        if (nodeA == null || nodeB == null) {
            logger.debug("[{}] ✗ 无法定位节点: nodeA={}, nodeB={}", worldPosition, nodeA != null, nodeB != null);
            logger.debug("[{}]   可用节点位置:", worldPosition);
            for (TrackNode node : nodeList) {
                logger.debug("[{}]     - {}", worldPosition, node.getLocation());
            }
            return;
        }
        logger.debug("[{}] ✓ 定位到节点: nodeA={}, nodeB={}", worldPosition, nodeA.getLocation(), nodeB.getLocation());

        // 确定前进方向（信号点标记的方向）
        boolean isFirstSide = currentBoundary.blockEntities.getFirst().containsKey(worldPosition);
        boolean isSecondSide = currentBoundary.blockEntities.getSecond().containsKey(worldPosition);

        if (!isFirstSide && !isSecondSide) {
            logger.error("方块不在边界{}的任何一侧！无法确定前进方向", currentBoundary.id);
            return;
        }

        // 方块在哪一侧，primary就为true/false
        // 如果方块在第一侧，primary=true；如果在第二侧，primary=false
        boolean primary = isFirstSide;
        logger.debug("方块位置: {}, 在第一侧: {}, 在第二侧: {}, primary: {}",
                worldPosition, isFirstSide, isSecondSide, primary);

        // 保存节点位置用于比较
        TrackNodeLocation nodeALocation = nodeLocations.getFirst();
        TrackNodeLocation nodeBLocation = nodeLocations.getSecond();

        // 创建TravellingPoint，从当前边界开始
        // 位置设置为0（在边界处开始）
        TrackNode startNode = primary ? nodeA : nodeB;
        TrackNode endNode = primary ? nodeB : nodeA;
        TrackNodeLocation startLocation = primary ? nodeALocation : nodeBLocation;
        TrackNodeLocation endLocation = primary ? nodeBLocation : nodeALocation;

        // 查找连接这两个节点的边（简化逻辑）
        TrackEdge startEdge = null;
        boolean edgeBackwards = false; // 边方向：false=从startNode到endNode，true=从endNode到startNode

        // 尝试从startNode查找
        for (Map.Entry<
                TrackNode, TrackEdge> entry : graph.getConnectionsFrom(startNode).entrySet()) {
            TrackNode targetNode = entry.getKey();
            if (targetNode.getLocation().equals(endLocation)) {
                startEdge = entry.getValue();
                edgeBackwards = false; // 正向边
                logger.debug("✓ 找到边: 从 {} 到 {}", startNode.getLocation(), targetNode.getLocation());
                break;
            }
        }

        // 如果没找到，尝试从endNode查找（反向边）
        if (startEdge == null) {
            for (Map.Entry<
                    TrackNode, TrackEdge> entry : graph.getConnectionsFrom(endNode).entrySet()) {
                TrackNode targetNode = entry.getKey();
                if (targetNode.getLocation().equals(startLocation)) {
                    startEdge = entry.getValue();
                    edgeBackwards = true; // 反向边
                    logger.debug("✓ 找到反向边: 从 {} 到 {}", endNode.getLocation(), targetNode.getLocation());
                    break;
                }
            }
        }

        if (startEdge == null) {
            logger.error("找不到连接节点{}和{}的边", startLocation, endLocation);
            return;
        }

        // 获取边界在边上的精确位置
        double boundaryLocationOnEdge = currentBoundary.getLocationOn(startEdge);
        double edgeLength = startEdge.getLength();
        double boundaryPositionPercent = edgeLength > 0 ? (boundaryLocationOnEdge / edgeLength * 100.0) : 0.0;

        logger.debug("边界在边上的位置: {}米 (占总长的{}%)",
                String.format("%.2f", boundaryLocationOnEdge), String.format("%.1f", boundaryPositionPercent));
        logger.debug("边总长度: {}米, 边方向: {}",
                String.format("%.2f", edgeLength), edgeBackwards ? "反向 (从endNode到startNode)" : "正向 (从startNode到endNode)");
        logger.debug("边界两侧信号组ID: 第一侧={}, 第二侧={}",
                currentBoundary.groups.getFirst(), currentBoundary.groups.getSecond());

        // 创建TravellingPoint，位置设置为0（在边界处）
        // 根据边方向调整参数
        TrackNode actualStartNode = edgeBackwards ? endNode : startNode;
        TrackNode actualEndNode = edgeBackwards ? startNode : endNode;

        // 轨道边信息（使用已获取的长度）
        logger.debug("轨道边信息: 长度={}m, 节点={} -> {}",
                String.format("%.2f", edgeLength), actualStartNode.getLocation(), actualEndNode.getLocation());

        // 检查节点连接情况
        int startConnections = graph.getConnectionsFrom(actualStartNode).size();
        int endConnections = graph.getConnectionsFrom(actualEndNode).size();
        logger.debug("节点连接数: startNode有{}条边, endNode有{}条边",
                startConnections, endConnections);

        // 计算TravellingPoint的精确起始位置（考虑边方向和边界位置）
        double startPosition;
        if (edgeBackwards) {
            // 反向边：从actualStartNode（原始node2）到边界的位置 = 边总长 - 边界位置
            startPosition = edgeLength - boundaryLocationOnEdge;
            logger.debug("反向边调整: 边界位置={}m, 边总长={}m, 调整后起始位置={}m",
                    String.format("%.2f", boundaryLocationOnEdge), String.format("%.2f", edgeLength), String.format("%.2f", startPosition));
        } else {
            // 正向边：从actualStartNode（原始node1）到边界的位置 = 边界位置
            startPosition = boundaryLocationOnEdge;
            logger.debug("正向边: 边界位置={}m 即为起始位置", String.format("%.2f", boundaryLocationOnEdge));
        }

        // 验证起始位置在有效范围内
        if (startPosition < 0 || startPosition > edgeLength) {
            logger.error("⚠️ 计算出的起始位置 {} 超出边范围 [0, {}]，强制调整为边界位置",
                    String.format("%.2f", startPosition), String.format("%.2f", edgeLength));
            startPosition = Math.max(0, Math.min(startPosition, edgeLength));
        }

        // 当信号节点很近时，确保起始位置不为0也不等于边长度，避免TravellingPoint无法移动
        // 使用相对偏移（边长的1%），但不超过1米，不小于1毫米
        final double MIN_RELATIVE_OFFSET = 0.01; // 1% of edge length
        final double MIN_ABSOLUTE_OFFSET = 0.001; // 1毫米
        final double MAX_ABSOLUTE_OFFSET = 1.0; // 1米

        if (startPosition == 0) {
            double offset = Math.max(edgeLength * MIN_RELATIVE_OFFSET, MIN_ABSOLUTE_OFFSET);
            offset = Math.min(offset, MAX_ABSOLUTE_OFFSET);
            offset = Math.min(offset, edgeLength * 0.5); // 不超过边长的一半
            startPosition = offset;
            logger.debug("[{}]   起始位置为0，调整为 {}m (边长的{:.1f}%) 以避免移动问题",
                    worldPosition, String.format("%.6f", startPosition), (startPosition / edgeLength) * 100);
        } else if (startPosition == edgeLength) {
            double offset = Math.max(edgeLength * MIN_RELATIVE_OFFSET, MIN_ABSOLUTE_OFFSET);
            offset = Math.min(offset, MAX_ABSOLUTE_OFFSET);
            offset = Math.min(offset, edgeLength * 0.5); // 不超过边长的一半
            startPosition = edgeLength - offset;
            logger.debug("[{}]   起始位置在边末端，调整为 {}m (边长的{:.1f}%) 以避免移动问题",
                    worldPosition, String.format("%.6f", startPosition), (offset / edgeLength) * 100);
        } else if (startPosition < 0.001 || startPosition > edgeLength - 0.001) {
            // 如果位置非常接近0或边长度，也进行调整
            double safeMargin = Math.max(edgeLength * 0.01, 0.001);
            safeMargin = Math.min(safeMargin, 0.1);
            if (startPosition < safeMargin) {
                startPosition = safeMargin;
                logger.debug("[{}]   起始位置接近0 ({}m)，调整为 {}m",
                        worldPosition, String.format("%.6f", startPosition - safeMargin), String.format("%.6f", startPosition));
            } else if (startPosition > edgeLength - safeMargin) {
                startPosition = edgeLength - safeMargin;
                logger.debug("[{}]   起始位置接近边末端 (距离末端{}m)，调整为 {}m",
                        worldPosition, String.format("%.6f", edgeLength - startPosition), String.format("%.6f", startPosition));
            }
        }

        logger.debug("[{}] 创建TravellingPoint详细参数:", worldPosition);
        logger.debug("[{}]   startNode: {} (位置: {})",
                worldPosition, actualStartNode.getLocation(), actualStartNode.getLocation().getLocation());
        logger.debug("[{}]   endNode: {} (位置: {})",
                worldPosition, actualEndNode.getLocation(), actualEndNode.getLocation().getLocation());
        logger.debug("[{}]   edge: {} (长度: {}m)", worldPosition, startEdge, String.format("%.2f", edgeLength));
        logger.debug("[{}]   position: {}m (在边上的位置)", worldPosition, String.format("%.2f", startPosition));
        logger.debug("[{}]   edgeBackwards: {}", worldPosition, edgeBackwards);
        logger.debug("[{}]   边界位置: {}m, 边方向: {}, 边界信号组: 第一侧={}, 第二侧={}",
                worldPosition, String.format("%.2f", boundaryLocationOnEdge), edgeBackwards ? "反向" : "正向",
                currentBoundary.groups.getFirst(), currentBoundary.groups.getSecond());

        // 创建TravellingPoint，位置设置为边界处的精确位置
        TravellingPoint travellingPoint = new TravellingPoint(actualStartNode, actualEndNode, startEdge, startPosition, edgeBackwards);

        // 收集信号组ID（最多3个，对应索引1-3）
        // 使用数组容器以便在lambda中修改
        int[] collectedCountContainer = new int[]{0};
        Set<UUID> collectedIds = new HashSet<>();
        if (signalGroupIds[0] != null) {
            collectedIds.add(signalGroupIds[0]); // 避免重复收集当前组
        }

        // 循环检测和限制
        Set<UUID> visitedBoundaryIds = new HashSet<>();
        visitedBoundaryIds.add(currentBoundary.id); // 添加当前边界，避免重复处理
        final double MAX_TRAVEL_DISTANCE = 5000.0; // 最大移动距离5000米（5公里），足够大型环形铁路
        final int MAX_BOUNDARY_VISITS = 30; // 最多访问30个不同的边界（包括信号边界和其他边界）
        final double[] furthestDistance = new double[]{0.0}; // 记录最远距离

        logger.debug("[{}] 循环检测设置: 最大移动距离={}米, 最大边界访问数={}",
                worldPosition, MAX_TRAVEL_DISTANCE, MAX_BOUNDARY_VISITS);

        // 创建信号边界监听器
        TravellingPoint.IEdgePointListener signalListener = (distance, pair) -> {
            TrackEdgePoint edgePoint = pair.getFirst();
            Couple<TrackNode> nodes = pair.getSecond();

            // 更新最远距离（所有类型的边界点都检查）
            furthestDistance[0] = Math.max(furthestDistance[0], distance);

            // 检查是否超过最大移动距离（防止无限循环）
            if (distance > MAX_TRAVEL_DISTANCE) {
                logger.warn("[{}] ⚠️ 已达到最大移动距离限制 ({}米)，停止前进以防止无限循环", worldPosition, MAX_TRAVEL_DISTANCE);
                return true;
            }

            // 只处理信号边界
            if (!(edgePoint instanceof SignalBoundary boundary)) {
                logger.debug("[{}] 监听器: 遇到非信号边界: {}", worldPosition, edgePoint.getClass().getSimpleName());
                return false;
            }

            logger.debug("[{}] 监听器: 遇到信号边界 {} 在距离 {}m", worldPosition, boundary.id, String.format("%.2f", distance));
            logger.debug("[{}]   边界连接的节点: {} -> {}", worldPosition, nodes.getFirst().getLocation(), nodes.getSecond().getLocation());

            // 调试：输出边界方向信息
            if (boundary.edgeLocation != null) {
                logger.debug("[{}]    边界edgeLocation: {} -> {}", worldPosition,
                        boundary.edgeLocation.getFirst(), boundary.edgeLocation.getSecond());
                // 比较nodes和edgeLocation的顺序
                boolean nodesMatchEdgeLocation = nodes.getFirst().getLocation().equals(boundary.edgeLocation.getFirst()) &&
                        nodes.getSecond().getLocation().equals(boundary.edgeLocation.getSecond());
                boolean nodesReversed = nodes.getFirst().getLocation().equals(boundary.edgeLocation.getSecond()) &&
                        nodes.getSecond().getLocation().equals(boundary.edgeLocation.getFirst());
                logger.debug("[{}]    节点顺序匹配: {}, 节点顺序反转: {}", worldPosition,
                        nodesMatchEdgeLocation, nodesReversed);
                if (!nodesMatchEdgeLocation && !nodesReversed) {
                    logger.warn("[{}]    ⚠️ 节点顺序既不匹配也不反转！可能存在不一致", worldPosition);
                    logger.warn("[{}]    nodes: {} -> {}", worldPosition,
                            nodes.getFirst().getLocation(), nodes.getSecond().getLocation());
                    logger.warn("[{}]    edgeLocation: {} -> {}", worldPosition,
                            boundary.edgeLocation.getFirst(), boundary.edgeLocation.getSecond());
                }
            }

            // 调试：输出前进方向信息
            logger.debug("[{}]   前进方向(actual): {} -> {}", worldPosition, actualStartNode.getLocation(), actualEndNode.getLocation());
            logger.debug("[{}]   当前边方向(nodes): {} -> {}", worldPosition, nodes.getFirst().getLocation(), nodes.getSecond().getLocation());

            // 跳过当前边界
            if (boundary.id.equals(currentBoundary.id)) {
                logger.debug("[{}]   跳过当前边界", worldPosition);
                return false;
            }

            // ====== 循环检测和限制 ======
            // 注意：距离检查已在监听器开头执行，这里只进行边界相关的循环检测

            // 检查是否已访问过此边界（循环检测）
            if (visitedBoundaryIds.contains(boundary.id)) {
                logger.warn("[{}] ⚠️ 检测到循环：边界 {} 已被访问过，停止前进", worldPosition, boundary.id);
                logger.warn("[{}] ⚠️ 已访问边界数: {}, 最远移动距离: {}米",
                        worldPosition, visitedBoundaryIds.size(), String.format("%.2f", furthestDistance[
                        0]));
                return true;
            }

            // 记录此边界已访问
            visitedBoundaryIds.add(boundary.id);
            logger.debug("[{}]   记录边界已访问，当前已访问边界数: {}", worldPosition, visitedBoundaryIds.size());

            // 检查是否超过最大边界访问数
            if (visitedBoundaryIds.size() > MAX_BOUNDARY_VISITS) {
                logger.warn("[{}] ⚠️ 已达到最大边界访问数限制 ({}个)，停止前进", worldPosition, MAX_BOUNDARY_VISITS);
                return true;
            }
            // ====== 循环检测结束 ======

            // 对于前进方向上的其他信号边界，获取信号组ID
            // 记录边界两侧的信号组ID用于调试
            UUID firstSideGroupId = boundary.groups.getFirst();
            UUID secondSideGroupId = boundary.groups.getSecond();
            logger.debug("[{}]   边界{}信号组ID: 第一侧={}, 第二侧={}",
                    worldPosition, boundary.id, firstSideGroupId, secondSideGroupId);

            // 根据前进方向选择正确的信号组ID
            UUID groupId = null;
            boolean usedFallback = false;
            String sideChosen = "未知";

            if (boundary.edgeLocation != null) {
                // 调试：比较actualStartNode与nodes的关系
                boolean matchesFirst = actualStartNode.getLocation().equals(nodes.getFirst().getLocation());
                boolean matchesSecond = actualStartNode.getLocation().equals(nodes.getSecond().getLocation());
                logger.debug("[{}]   节点匹配: actualStartNode匹配nodes.first={}, nodes.second={}",
                        worldPosition, matchesFirst, matchesSecond);

                // 关键修复：使用nodes.getFirst()作为参考节点，而不是actualStartNode
                // 因为TravellingPoint在移动过程中，actualStartNode可能不是当前边的起点
                // nodes.getFirst()是监听器收到的当前边的起点（经过forward ? nodes : nodes.swap()调整）
                TrackNode referenceNode = nodes.getFirst();
                logger.debug("[{}]   使用参考节点: {} (nodes.getFirst())", worldPosition, referenceNode.getLocation());

                // 确定referenceNode是否是primary侧（edgeLocation.getSecond()）
                boolean isPrimary = boundary.edgeLocation.getSecond().equals(referenceNode.getLocation());
                groupId = isPrimary ? firstSideGroupId : secondSideGroupId;
                sideChosen = isPrimary ? "第一" : "第二";
                logger.debug("[{}]   方向判断: referenceNode={}, edgeLocation.second={}, isPrimary={}, 选择{}侧组ID",
                        worldPosition, referenceNode.getLocation(), boundary.edgeLocation.getSecond(),
                        isPrimary, sideChosen);

                // 检查选择的组ID是否有效，如果无效则尝试另一侧
                if (groupId == null || collectedIds.contains(groupId)) {
                    UUID fallbackGroupId = isPrimary ? secondSideGroupId : firstSideGroupId;
                    String fallbackSide = isPrimary ? "第二" : "第一";
                    logger.debug("[{}]    ⚠️ 原选择{}侧组ID无效(null={}, 已收集={})，尝试{}侧组ID: {}",
                            worldPosition, sideChosen, groupId == null, groupId != null && collectedIds.contains(groupId),
                            fallbackSide, fallbackGroupId);

                    if (fallbackGroupId != null && !collectedIds.contains(fallbackGroupId)) {
                        groupId = fallbackGroupId;
                        sideChosen = fallbackSide;
                        usedFallback = true;
                        logger.debug("[{}]    ✅ 回退成功，使用{}侧组ID", worldPosition, sideChosen);
                    } else {
                        logger.debug("[{}]    ⚠️ 回退组ID也无效，保持原选择", worldPosition);
                    }
                }
            } else {
                // 边界没有edgeLocation信息，使用第一侧作为默认
                groupId = firstSideGroupId;
                sideChosen = "第一";
                logger.debug("[{}]   边界没有edgeLocation，使用第一侧组ID作为默认", worldPosition);
            }

            if (groupId != null && !collectedIds.contains(groupId)) {
                // 存入下一个可用槽位（索引1-3）
                int slotIndex = collectedCountContainer[0] + 1;
                signalGroupIds[slotIndex] = groupId;
                boundaryIds[slotIndex] = boundary.id.toString();
                collectedIds.add(groupId);
                collectedCountContainer[0]++;

                logger.debug("[{}]   成功收集信号组ID: {} ({}侧{}) 存入槽位 {}",
                        worldPosition, groupId, sideChosen, usedFallback ? "，回退" : "", slotIndex);

                // 如果收集了3个信号组，返回true停止前进
                if (collectedCountContainer[0] >= 3) {
                    logger.debug("[{}]   已收集3个信号组，停止前进", worldPosition);
                    return true;
                }
            } else if (groupId == null) {
                logger.debug("[{}]   信号组ID为null，跳过", worldPosition);
            } else if (collectedIds.contains(groupId)) {
                logger.debug("[{}]   信号组ID已收集过，跳过 ({}侧)", worldPosition, sideChosen);
            }

            return false;
        };

        // 使用TravellingPoint前进，直到收集3个信号组或到达轨道尽头
        // 使用Double.MAX_VALUE让TravellingPoint一直前进，直到监听器返回true或自然停止
        // 注意：TravellingPoint内部有visited集合避免重复访问同一条边，可以处理环形铁路
        logger.debug("[{}] 轨道图信息: 节点数={}, 边数≈{}",
                worldPosition, graph.getNodes().size(), estimateEdgeCount(graph));
        // 创建自定义轨道选择器（总是选择第一个可用连接，比随机选择更确定）
        TravellingPoint.ITrackSelector deterministicSelector = (g, pair) -> {
            boolean forward = pair.getFirst();
            List<Map.Entry<TrackNode, TrackEdge>> validTargets = pair.getSecond();
            if (validTargets.isEmpty()) {
                return null;
            }
            // 总是选择第一个可用连接
            return validTargets.get(0);
        };

        logger.debug("[{}] 开始TravellingPoint.travel()，最大距离: {}，使用确定性选择器", worldPosition, Double.MAX_VALUE);
        double actualDistance = travellingPoint.travel(graph, Double.MAX_VALUE, deterministicSelector, signalListener);
        logger.debug("[{}] TravellingPoint.travel()完成，实际移动距离: {}m", worldPosition, String.format("%.2f", actualDistance));
        logger.debug("[{}] 监听器收集统计: {}个信号组", worldPosition, collectedCountContainer[
        0]);
        logger.debug("[{}] 循环检测结果: 最远移动距离={}米, 已访问边界数={}",
                worldPosition, String.format("%.2f", furthestDistance[
                0]), visitedBoundaryIds.size() - 1); // 减去当前边界

        // 检查移动距离是否为0，如果是，给出明确的轨道结构诊断
        if (actualDistance == 0.0) {
            logger.warn("[{}] ⚠️ TravellingPoint移动距离为0！这意味着轨道结构有限。", worldPosition);
            logger.warn("[{}] ⚠️ 当前轨道: {} -> {} (长度: {}m)",
                    worldPosition, actualStartNode.getLocation(), actualEndNode.getLocation(), String.format("%.2f", edgeLength));
            logger.warn("[{}] ⚠️ 节点连接数: startNode有{}条边, endNode有{}条边",
                    worldPosition, startConnections, endConnections);
            logger.warn("[{}] ⚠️ 轨道图规模: 节点数={}, 边数≈{}",
                    worldPosition, graph.getNodes().size(), estimateEdgeCount(graph));
            logger.warn("[{}] ⚠️ 解决方案: 在现有轨道前方至少延伸3段轨道，每段放置一个信号机", worldPosition);
        }

        // 更新移动统计
        travelCallCount++;
        lastTravelDistance = actualDistance;
        totalTravelDistance += actualDistance;

        // 输出调试日志
        // logger.debug(String.format(
        // "[%s] TravellingPoint移动统计 - 调用次数: %d, 本次移动: %.2f米, 累计移动: %.2f米, 收集到信号组: %d个",
        // worldPosition.toString(), travelCallCount, lastTravelDistance, totalTravelDistance,
        // collectedCountContainer[0]
        // ));

        logger.debug("[{}] === findForwardSignalGroups 结束 ===", worldPosition);
    }

    // 查找包含指定节点位置的轨道图
    @Nullable
    private TrackGraph findContainingGraph(Couple<TrackNodeLocation> nodeLocations) {
        for (TrackGraph graph : Create.RAILWAYS.trackNetworks.values()) {
            TrackNode node1 = graph.locateNode(nodeLocations.getFirst());
            TrackNode node2 = graph.locateNode(nodeLocations.getSecond());
            if (node1 != null && node2 != null) {
                return graph;
            }
        }
        return null;
    }

    // 更新所有信号组的占用状态
    private void updateOccupancyStates() {
        for (int i = 0; i < 4; i++) {
            if (signalGroupIds[i] == null) {
                // 无信号组ID，视为占用
                occupancyStates[i] = true;
                continue;
            }

            // 直接检测占用状态
            occupancyStates[i] = isSignalGroupOccupied(signalGroupIds[i]);
        }
    }

    // 检查信号组是否占用（包括强制红灯）
    private boolean isSignalGroupOccupied(UUID groupId) {
        SignalEdgeGroup group = Create.RAILWAYS.signalEdgeGroups.get(groupId);
        if (group == null) {
            return false;
        }

        // 1. 检查信号组是否有列车占用（传入null，预约也会被视为占用）
        boolean occupiedByTrain = group.isOccupiedUnless((SignalBoundary) null);
        if (occupiedByTrain) {
            return true;
        }

        // 2. 检查信号组中是否有任何信号边界被强制设为红灯
        // 遍历所有轨道图的所有信号边界
        for (TrackGraph graph : Create.RAILWAYS.trackNetworks.values()) {
            for (SignalBoundary boundary : graph.getPoints(EdgePointType.SIGNAL)) {
                // 检查这个边界是否属于目标信号组，并确定在哪一侧
                UUID group1 = boundary.groups.get(true);
                UUID group2 = boundary.groups.get(false);

                boolean isGroup1 = group1 != null && group1.equals(groupId);
                boolean isGroup2 = group2 != null && group2.equals(groupId);

                if (isGroup1 || isGroup2) {
                    // 只检查目标组所在侧的强制红灯状态
                    // 如果组在primary侧（true），检查isForcedRed(true)
                    // 如果组在secondary侧（false），检查isForcedRed(false)
                    boolean forcedRed = (isGroup1 && boundary.isForcedRed(true)) ||
                                       (isGroup2 && boundary.isForcedRed(false));

                    if (forcedRed) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // 计算四显示信号状态
    private FourAspectSignalState calculateFourAspectSignal() {
        // 强制红灯优先级最高（红石信号7-15）
        if (forceRed) {
            return FourAspectSignalState.RED;
        }

        // 检查0-3组占用状态，第一个被占用的组决定信号
        for (int i = 0; i < 4; i++) {
            if (occupancyStates[i]) {
                switch (i) {
                    case 0:
                        return FourAspectSignalState.RED; // 第0组占用 → 红灯
                    case 1:
                        return FourAspectSignalState.YELLOW; // 第1组占用 → 黄灯
                    case 2:
                        return FourAspectSignalState.GREEN_YELLOW; // 第2组占用 → 绿黄灯
                    case 3:
                        return FourAspectSignalState.GREEN; // 第3组占用 → 绿灯
                    default:
                        return FourAspectSignalState.INVALID;
                }
            }
        }
        // 所有区间都空闲 → 绿灯
        return FourAspectSignalState.GREEN;
    }

    // 将四显示状态转换为原始信号状态
    private SignalBlockEntity.SignalState convertToSignalState(FourAspectSignalState fourAspectState) {
        switch (fourAspectState) {
            case RED:
                return SignalBlockEntity.SignalState.RED;
            case YELLOW:
                return SignalBlockEntity.SignalState.YELLOW;
            case GREEN_YELLOW: // 绿黄灯暂时用黄灯表示
            case GREEN:
                return SignalBlockEntity.SignalState.GREEN;
            default:
                return SignalBlockEntity.SignalState.INVALID;
        }
    }

    // 更新红石信号输出（红灯时输出信号）
    private void updateRedstoneOutput() {
        boolean powered = getState() == SignalBlockEntity.SignalState.RED;
        if (powered != localLastReportedPower) {
            localLastReportedPower = powered;
            level.updateNeighborsAt(worldPosition, getBlockState().getBlock());
        }
    }

    @Override
    protected void write(CompoundTag tag, boolean clientPacket) {
        super.write(tag, clientPacket);
        // 父类已写入state和lastReportedPower
        // 四显示信号机扩展数据
        tag.putInt("CurrentRoute", currentRoute);
        tag.putBoolean("ForceRed", forceRed);
        tag.putBoolean("LocalLastReportedPower", localLastReportedPower);
        tag.putString("FourAspectState", fourAspectState.name());

        // 存储占用状态数组
        for (int i = 0; i < occupancyStates.length; i++) {
            tag.putBoolean("Occupancy" + i, occupancyStates[i]);
        }

        // 存储边界ID数组
        for (int i = 0; i < boundaryIds.length; i++) {
            tag.putString("BoundaryId" + i, boundaryIds[i] != null ? boundaryIds[i] : "");
        }

        tag.putInt("LastRedstoneSignal", lastRedstoneSignal);

        // 存储信号组ID数组（多个槽位）
        for (int i = 0; i < signalGroupIds.length; i++) {
            if (signalGroupIds[i] != null) {
                tag.putUUID("SignalGroupId" + i, signalGroupIds[i]);
            }
        }

        // 存储TravellingPoint移动统计
        tag.putInt("TravelCallCount", travelCallCount);
        tag.putDouble("TotalTravelDistance", totalTravelDistance);
        tag.putDouble("LastTravelDistance", lastTravelDistance);
    }

    @Override
    protected void read(CompoundTag tag, boolean clientPacket) {
        super.read(tag, clientPacket);
        // 父类已读取state和lastReportedPower
        // 四显示信号机扩展数据
        if (tag.contains("CurrentRoute")) {
            currentRoute = tag.getInt("CurrentRoute");
        }
        if (tag.contains("ForceRed")) {
            forceRed = tag.getBoolean("ForceRed");
        }
        if (tag.contains("LocalLastReportedPower")) {
            localLastReportedPower = tag.getBoolean("LocalLastReportedPower");
        }
        if (tag.contains("FourAspectState")) {
            try {
                fourAspectState = FourAspectSignalState.valueOf(tag.getString("FourAspectState"));
            } catch (IllegalArgumentException e) {
                fourAspectState = FourAspectSignalState.INVALID;
            }
        }

        // 读取占用状态数组
        for (int i = 0; i < occupancyStates.length; i++) {
            if (tag.contains("Occupancy" + i)) {
                occupancyStates[i] = tag.getBoolean("Occupancy" + i);
            }
        }

        // 读取边界ID数组
        for (int i = 0; i < boundaryIds.length; i++) {
            if (tag.contains("BoundaryId" + i)) {
                String idStr = tag.getString("BoundaryId" + i);
                boundaryIds[i] = idStr;
            } else {
                boundaryIds[i] = "";
            }
        }

        if (tag.contains("LastRedstoneSignal")) {
            lastRedstoneSignal = tag.getInt("LastRedstoneSignal");
        }

        // 读取信号组ID数组（多个槽位）
        // 先初始化数组（确保不为null）
        if (signalGroupIds == null) {
            // 数组是final的，但这里确保安全性
        }

        // 读取新的数组格式
        for (int i = 0; i < signalGroupIds.length; i++) {
            if (tag.contains("SignalGroupId" + i)) {
                signalGroupIds[i] = tag.getUUID("SignalGroupId" + i);
            } else {
                signalGroupIds[i] = null;
            }
        }

        // 向后兼容：如果存在旧的SelectedSignalGroupId，且第一个槽位为空，则将其放入第一个槽位
        // if (tag.contains("SelectedSignalGroupId")) {
            // try {
                // UUID oldId = tag.getUUID("SelectedSignalGroupId");
                // if (signalGroupIds[0] == null && oldId != null) {
                    // signalGroupIds[0] = oldId;
                    // setChanged(); // 标记需要保存新格式
                // }
            // } catch (Exception e) {
                // // 无效的UUID格式，跳过
                // logger.debug("无效的SelectedSignalGroupId格式，跳过迁移");
            // }
        // }

        // 读取TravellingPoint移动统计（可选，旧版本可能没有这些字段）
        if (tag.contains("TravelCallCount")) {
            travelCallCount = tag.getInt("TravelCallCount");
        }
        if (tag.contains("TotalTravelDistance")) {
            totalTravelDistance = tag.getDouble("TotalTravelDistance");
        }
        if (tag.contains("LastTravelDistance")) {
            lastTravelDistance = tag.getDouble("LastTravelDistance");
        }
    }

    // 获取红石功率输出状态
    public boolean isPowered() {
        return getState() == SignalBlockEntity.SignalState.RED;
    }

    // 获取四显示信号状态
    public FourAspectSignalState getFourAspectState() {
        return fourAspectState;
    }

    // 获取当前进路
    public int getCurrentRoute() {
        return currentRoute;
    }

    // 获取强制红灯状态
    public boolean isForceRed() {
        return forceRed;
    }

    // UUID验证辅助方法
    private static boolean isValidUUID(String uuidStr) {
        if (uuidStr == null || uuidStr.isEmpty()) {
            return false;
        }
        try {
            UUID.fromString(uuidStr);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // 信号组扫描器功能方法 - 支持多个槽位
    /**
     * 将信号组ID填入前方信号组的第一个可用槽位（索引1-3） 逻辑：从第1个槽位开始检查（索引0是当前信号组），如果为空则填入，否则继续检查下一个
     * 如果所有前方槽位都已满（非null），则拒绝填充
     *
     * @param groupId 要填充的信号组ID
     * @return 成功填充的槽位索引（1-3），失败返回-1（重复或槽位已满）
     */
    public int addSignalGroupId(UUID groupId) {
        // 检查是否已存在相同的ID，避免重复（包括当前信号组）
        for (int i = 0; i < signalGroupIds.length; i++) {
            if (groupId.equals(signalGroupIds[i])) {
                return -1; // 已存在相同ID
            }
        }

        // 查找第一个空槽位（从索引1开始，索引0是当前信号组）
        for (int i = 1; i < signalGroupIds.length; i++) {
            if (signalGroupIds[i] == null) {
                signalGroupIds[i] = groupId;
                setChanged(); // 标记方块实体已更改，需要保存
                return i; // 返回填充的槽位索引
            }
        }

        // 所有前方槽位都已满
        return -1;
    }

    /**
     * 获取指定槽位的信号组ID
     *
     * @param index 槽位索引（0-3）
     * @return 信号组ID，如果槽位为空则返回null
     */
    public UUID getSignalGroupId(int index) {
        if (index >= 0 && index < signalGroupIds.length) {
            return signalGroupIds[index];
        }
        return null;
    }

    /**
     * 获取指定槽位的占用状态
     *
     * @param index 槽位索引（0-3）
     * @return 占用状态
     */
    public boolean getOccupancyState(int index) {
        if (index >= 0 && index < occupancyStates.length) {
            return occupancyStates[index];
        }
        return false;
    }

    /**
     * 获取指定槽位的边界ID
     *
     * @param index 槽位索引（0-3）
     * @return 边界ID字符串
     */
    public String getBoundaryId(int index) {
        if (index >= 0 && index < boundaryIds.length) {
            return boundaryIds[index] != null ? boundaryIds[index] : "";
        }
        return "";
    }

    /** 获取最后红石信号强度 */
    public int getLastRedstoneSignal() {
        return lastRedstoneSignal;
    }

    /** 获取信号组ID数组的副本 */
    public UUID[] getSignalGroupIds() {
        return signalGroupIds.clone();
    }

    /** 获取占用状态数组的副本 */
    public boolean[] getOccupancyStates() {
        return occupancyStates.clone();
    }

    /** 获取边界ID数组的副本 */
    public String[] getBoundaryIds() {
        return boundaryIds.clone();
    }

    /**
     * 获取基础信号状态（来自SignalBlockEntity.SignalState） SignalBlockEntity.SignalState是Create模组中信号方块的信号状态枚举，
     * 包含RED（红灯）、YELLOW（黄灯）、GREEN（绿灯）、INVALID（无效）等状态。 我们的四显示信号状态需要转换为这些基础状态用于显示和红石输出。
     */
    public SignalBlockEntity.SignalState getBaseSignalState() {
        return getState();
    }

    /** 获取TravellingPoint调用次数 */
    public int getTravelCallCount() {
        return travelCallCount;
    }

    /** 获取累计移动总距离（米） */
    public double getTotalTravelDistance() {
        return totalTravelDistance;
    }

    /** 获取上次移动距离（米） */
    public double getLastTravelDistance() {
        return lastTravelDistance;
    }

    /** 估算轨道图的边数 */
    private int estimateEdgeCount(TrackGraph graph) {
        if (graph == null) return 0;
        Set<TrackNodeLocation> locations = graph.getNodes();
        int totalConnections = 0;
        int countedNodes = 0;

        for (TrackNodeLocation location : locations) {
            TrackNode node = graph.locateNode(location);
            if (node == null) continue;
            totalConnections += graph.getConnectionsFrom(node).size();
            countedNodes++;
            if (countedNodes >= 20) break; // 最多检查20个节点
        }

        if (countedNodes == 0) return 0;
        // 平均连接数乘以节点数除以2
        double avgConnections = (double) totalConnections / countedNodes;
        int estimatedEdges = (int) Math.round(avgConnections * locations.size() / 2.0);
        return Math.max(estimatedEdges, 0);
    }
}