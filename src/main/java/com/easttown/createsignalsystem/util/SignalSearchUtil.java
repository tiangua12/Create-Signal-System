package com.easttown.createsignalsystem.util;

import com.simibubi.create.Create;
import com.simibubi.create.content.trains.entity.TravellingPoint;
import com.simibubi.create.content.trains.entity.TravellingPoint.SteerDirection;
import com.simibubi.create.content.trains.graph.TrackGraph;
import com.simibubi.create.content.trains.graph.TrackNode;
import com.simibubi.create.content.trains.graph.TrackEdge;
import com.simibubi.create.content.trains.graph.TrackNodeLocation;
import com.simibubi.create.content.trains.signal.SignalBoundary;
import com.simibubi.create.foundation.utility.Couple;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.*;

/**
 * 信号搜索工具类
 * 提供信号组搜索相关的通用方法
 */
public class SignalSearchUtil {

    // 默认搜索参数
    public static final double DEFAULT_MAX_TRAVEL_DISTANCE = 999999999.0; // 最大移动距离5000米（5公里）
    public static final int DEFAULT_MAX_BOUNDARY_VISITS = 30; // 最多访问30个不同的边界

    /**
     * 核心搜索方法 - 使用已经创建好的TravellingPoint进行搜索
     *
     * @param travellingPoint 已创建好的TravellingPoint实例
     * @param graph 轨道图
     * @param startBoundaryId 起始边界的ID（用于跳过）
     * @param maxGroupsToFind 要寻找的最大信号组数量
     * @param routeSelector 进路选择器（可为null，使用默认直行）
     * @return 找到的信号组ID列表，按距离从近到远排序
     */
    public static List<UUID> searchForwardSignalGroups(
            TravellingPoint travellingPoint,
            TrackGraph graph,
            UUID startBoundaryId,
            int maxGroupsToFind,
            @Nullable TravellingPoint.ITrackSelector routeSelector) {

        if (travellingPoint == null || graph == null || startBoundaryId == null || maxGroupsToFind <= 0) {
            return Collections.emptyList();
        }

        List<UUID> result = new ArrayList<>();

        try {
            // 创建监听器收集信号组
            Set<UUID> visitedBoundaryIds = new HashSet<>();
            visitedBoundaryIds.add(startBoundaryId);
            Set<UUID> collectedIds = new HashSet<>();

            TravellingPoint.IEdgePointListener signalListener = (distance, pair) -> {
                // 只处理信号边界
                if (!(pair.getFirst() instanceof SignalBoundary boundary)) {
                    return false;
                }

                // 跳过起始边界
                if (boundary.id.equals(startBoundaryId)) {
                    return false;
                }

                // 循环检测
                if (visitedBoundaryIds.contains(boundary.id)) {
                    return true;
                }
                visitedBoundaryIds.add(boundary.id);

                // 检查边界访问限制
                if (visitedBoundaryIds.size() > DEFAULT_MAX_BOUNDARY_VISITS) {
                    return true;
                }

                // 检查距离限制
                if (distance > DEFAULT_MAX_TRAVEL_DISTANCE) {
                    return true;
                }

                // 选择信号组ID
                TrackNode referenceNode = pair.getSecond().getFirst();
                UUID groupId = selectSignalGroupId(boundary, referenceNode, collectedIds);

                if (groupId != null && !collectedIds.contains(groupId)) {
                    result.add(groupId);
                    collectedIds.add(groupId);

                    // 如果达到最大数量，停止前进
                    if (result.size() >= maxGroupsToFind) {
                        return true;
                    }
                }

                return false;
            };

            // 使用进路选择器（如果为null则使用默认直行）
            TravellingPoint.ITrackSelector finalRouteSelector = routeSelector != null
                    ? routeSelector
                    : travellingPoint.steer(TravellingPoint.SteerDirection.NONE, new net.minecraft.world.phys.Vec3(0, 1, 0));

            // 开始移动
            travellingPoint.travel(graph, Double.MAX_VALUE, finalRouteSelector, signalListener);

        } catch (Exception e) {
            SimpleLogger.error("[{}] 搜索前方信号组时发生异常", startBoundaryId, e);
        }

        return result;
    }

    /**
     * 便捷搜索方法 - 自动创建TravellingPoint并进行搜索
     * 适用于简单场景，内部会创建TravellingPoint
     *
     * @param startBoundary 起始信号边界
     * @param blockPos 信号机方块位置（用于确定前进方向）
     * @param maxGroupsToFind 要寻找的最大信号组数量
     * @param routeSelector 进路选择器（可为null，使用默认直行）
     * @return 找到的信号组ID列表，按距离从近到远排序
     */
    public static List<UUID> searchForwardSignalGroups(
            SignalBoundary startBoundary,
            BlockPos blockPos,
            int maxGroupsToFind,
            @Nullable TravellingPoint.ITrackSelector routeSelector) {

        if (startBoundary == null || blockPos == null || maxGroupsToFind <= 0) {
            return Collections.emptyList();
        }

        try {
            // 1. 获取轨道图
            TrackGraph graph = findContainingGraph(startBoundary.edgeLocation);
            if (graph == null) {
                return Collections.emptyList();
            }

            // 2. 确定前进方向
            Boolean side = determineSignalBoundarySide(startBoundary, blockPos);
            if (side == null) {
                return Collections.emptyList();
            }
            boolean primary = side;

            // 3. 获取起始和结束节点
            TrackNode[] nodes = determineStartEndNodes(startBoundary, startBoundary.edgeLocation, primary, graph);
            if (nodes == null) {
                return Collections.emptyList();
            }
            TrackNode startNode = nodes[0];
            TrackNode endNode = nodes[1];

            // 4. 查找连接边
            TrackEdge startEdge = findEdgeBetweenNodes(graph, startNode, endNode);
            if (startEdge == null) {
                return Collections.emptyList();
            }

            // 5. 计算起始位置
            double startPosition = calculateStartPosition(startBoundary, startEdge, false);

            // 6. 创建TravellingPoint
            TravellingPoint travellingPoint = new TravellingPoint(startNode, endNode, startEdge, startPosition, false);

            // 7. 调用核心搜索方法
            return searchForwardSignalGroups(travellingPoint, graph, startBoundary.id, maxGroupsToFind, routeSelector);

        } catch (Exception e) {
            SimpleLogger.error("[{}] 搜索前方信号组时发生异常", blockPos, e);
            return Collections.emptyList();
        }
    }

    /**
     * 查找包含指定节点位置的轨道图
     */
    @Nullable
    public static TrackGraph findContainingGraph(Couple<TrackNodeLocation> nodeLocations) {
        for (TrackGraph graph : Create.RAILWAYS.trackNetworks.values()) {
            TrackNode node1 = graph.locateNode(nodeLocations.getFirst());
            TrackNode node2 = graph.locateNode(nodeLocations.getSecond());
            if (node1 != null && node2 != null) {
                return graph;
            }
        }
        return null;
    }

    /**
     * 在轨道图中查找连接两个指定节点的边
     */
    @Nullable
    public static TrackEdge findEdgeBetweenNodes(TrackGraph graph, TrackNode startNode, TrackNode endNode) {
        // 查找从startNode到endNode的边
        for (var entry : graph.getConnectionsFrom(startNode).entrySet()) {
            if (entry.getKey().equals(endNode)) {
                return entry.getValue();
            }
        }

        // 查找从endNode到startNode的边（反向）
        for (var entry : graph.getConnectionsFrom(endNode).entrySet()) {
            if (entry.getKey().equals(startNode)) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * 确定当前方块在信号边界的哪一侧
     */
    @Nullable
    public static Boolean determineSignalBoundarySide(SignalBoundary boundary, BlockPos worldPosition) {
        boolean isFirstSide = boundary.blockEntities.getFirst().containsKey(worldPosition);
        boolean isSecondSide = boundary.blockEntities.getSecond().containsKey(worldPosition);

        if (!isFirstSide && !isSecondSide) {
            return null;
        }

        return isFirstSide; // true表示第一侧，false表示第二侧
    }

    /**
     * 根据信号边界和前进方向确定起始节点和结束节点
     */
    @Nullable
    public static TrackNode[] determineStartEndNodes(SignalBoundary boundary, Couple<TrackNodeLocation> nodeLocations,
                                                     boolean primary, TrackGraph graph) {
        TrackNode nodeA = graph.locateNode(nodeLocations.getFirst());
        TrackNode nodeB = graph.locateNode(nodeLocations.getSecond());

        if (nodeA == null || nodeB == null) {
            return null;
        }

        TrackNode startNode = primary ? nodeA : nodeB;
        TrackNode endNode = primary ? nodeB : nodeA;

        return new TrackNode[]{startNode, endNode};
    }

    /**
     * 计算TravellingPoint的起始位置，考虑边界位置和边方向
     */
    public static double calculateStartPosition(SignalBoundary boundary, TrackEdge edge, boolean edgeBackwards) {
        double boundaryLocationOnEdge = boundary.getLocationOn(edge);
        double edgeLength = edge.getLength();

        // 计算起始位置
        double startPosition;
        if (edgeBackwards) {
            // 反向边：从actualStartNode（原始node2）到边界的位置 = 边总长 - 边界位置
            startPosition = edgeLength - boundaryLocationOnEdge;
        } else {
            // 正向边：从actualStartNode（原始node1）到边界的位置 = 边界位置
            startPosition = boundaryLocationOnEdge;
        }

        // 验证起始位置在有效范围内
        if (startPosition < 0 || startPosition > edgeLength) {
            startPosition = Math.max(0, Math.min(startPosition, edgeLength));
        }

        return adjustStartPositionForEdgeProximity(startPosition, edgeLength);
    }

    /**
     * 调整起始位置，避免位置在边端点处导致移动问题
     */
    public static double adjustStartPositionForEdgeProximity(double startPosition, double edgeLength) {
        final double MIN_RELATIVE_OFFSET = 0.01; // 边长的1%
        final double MIN_ABSOLUTE_OFFSET = 0.001; // 1毫米
        final double MAX_ABSOLUTE_OFFSET = 1.0; // 1米

        if (startPosition == 0) {
            double offset = Math.max(edgeLength * MIN_RELATIVE_OFFSET, MIN_ABSOLUTE_OFFSET);
            offset = Math.min(offset, MAX_ABSOLUTE_OFFSET);
            offset = Math.min(offset, edgeLength * 0.5); // 不超过边长的一半
            return offset;
        } else if (startPosition == edgeLength) {
            double offset = Math.max(edgeLength * MIN_RELATIVE_OFFSET, MIN_ABSOLUTE_OFFSET);
            offset = Math.min(offset, MAX_ABSOLUTE_OFFSET);
            offset = Math.min(offset, edgeLength * 0.5); // 不超过边长的一半
            return edgeLength - offset;
        } else if (startPosition < 0.001 || startPosition > edgeLength - 0.001) {
            // 如果位置非常接近0或边长度，也进行调整
            double safeMargin = Math.max(edgeLength * 0.01, 0.001);
            safeMargin = Math.min(safeMargin, 0.1);
            if (startPosition < safeMargin) {
                return safeMargin;
            } else if (startPosition > edgeLength - safeMargin) {
                return edgeLength - safeMargin;
            }
        }

        return startPosition;
    }

    /**
     * 根据前进方向选择正确的信号组ID
     */
    @Nullable
    public static UUID selectSignalGroupId(SignalBoundary boundary, TrackNode referenceNode,
                                           Set<UUID> collectedIds) {
        UUID firstSideGroupId = boundary.groups.getFirst();
        UUID secondSideGroupId = boundary.groups.getSecond();

        if (boundary.edgeLocation != null) {
            // 确定referenceNode是否是primary侧（edgeLocation.getSecond()）
            boolean isPrimary = boundary.edgeLocation.getSecond().equals(referenceNode.getLocation());
            UUID groupId = isPrimary ? firstSideGroupId : secondSideGroupId;

            // 检查选择的组ID是否有效，如果无效则尝试另一侧
            if (groupId == null || collectedIds.contains(groupId)) {
                UUID fallbackGroupId = isPrimary ? secondSideGroupId : firstSideGroupId;
                if (fallbackGroupId != null && !collectedIds.contains(fallbackGroupId)) {
                    return fallbackGroupId;
                }
            }

            return groupId;
        } else {
            // 边界没有edgeLocation信息，使用第一侧作为默认
            return firstSideGroupId;
        }
    }

    // ====================================================================
    // 转向选择器工具方法（提供常用的转向模式）
    // ====================================================================

    /**
     * 创建直行选择器
     * 这是一个通用的基础工具方法
     *
     * @param travellingPoint TravellingPoint实例（用于创建选择器）
     * @return 直行选择器
     */
    public static TravellingPoint.ITrackSelector createStraightSelector(TravellingPoint travellingPoint) {
        return travellingPoint.steer(SteerDirection.NONE, new Vec3(0, 1, 0));
    }

    /**
     * 创建左转选择器
     * 这是一个通用的基础工具方法
     *
     * @param travellingPoint TravellingPoint实例（用于创建选择器）
     * @return 左转选择器
     */
    public static TravellingPoint.ITrackSelector createLeftSelector(TravellingPoint travellingPoint) {
        return travellingPoint.steer(SteerDirection.LEFT, new Vec3(0, 1, 0));
    }

    /**
     * 创建右转选择器
     * 这是一个通用的基础工具方法
     *
     * @param travellingPoint TravellingPoint实例（用于创建选择器）
     * @return 右转选择器
     */
    public static TravellingPoint.ITrackSelector createRightSelector(TravellingPoint travellingPoint) {
        return travellingPoint.steer(SteerDirection.RIGHT, new Vec3(0, 1, 0));
    }


}