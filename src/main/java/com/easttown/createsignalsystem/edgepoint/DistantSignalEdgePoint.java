package com.easttown.createsignalsystem.edgepoint;

import com.easttown.createsignalsystem.util.SignalSearchUtil;
import com.easttown.createsignalsystem.block.entity.DistantSignalBlockEntity;
import com.simibubi.create.Create;
import com.simibubi.create.content.trains.graph.DimensionPalette;
import com.simibubi.create.content.trains.graph.EdgePointType;
import com.simibubi.create.content.trains.graph.TrackGraph;
import com.simibubi.create.content.trains.graph.TrackNode;
import com.simibubi.create.content.trains.graph.TrackEdge;
import com.simibubi.create.content.trains.entity.TravellingPoint;
import com.simibubi.create.content.trains.signal.SingleBlockEntityEdgePoint;
import com.simibubi.create.content.trains.signal.TrackEdgePoint;
import com.simibubi.create.content.trains.signal.SignalBoundary;
import com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState;
import com.simibubi.create.content.trains.signal.SignalEdgeGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * 预告信号点（Distant Signal Edge Point）
 * 实时搜索前方第一个不同的信号组，显示其状态
 */
public class DistantSignalEdgePoint extends SingleBlockEntityEdgePoint {

    /**
     * 搜索结果容器
     */
    public static class SearchResult {
        @Nullable
        public final UUID ownGroupId;
        @Nullable
        public final UUID targetGroupId;
        @Nullable
        public final SignalState displayState;

        public SearchResult(@Nullable UUID ownGroupId, @Nullable UUID targetGroupId, @Nullable SignalState displayState) {
            this.ownGroupId = ownGroupId;
            this.targetGroupId = targetGroupId;
            this.displayState = displayState;
        }

        public boolean isValid() {
            return ownGroupId != null && targetGroupId != null && displayState != null && displayState != SignalState.INVALID;
        }
    }

    // 显示状态（基于前方信号组的状态）
    private SignalState displayState;

    // 目标信号组ID（前方第一个不同的信号组）
    @Nullable
    private UUID targetGroupId;

    // 自身信号组ID（从同一位置的SignalBoundary获取）
    @Nullable
    private UUID ownGroupId;

    // 最后更新时间戳（防止过于频繁更新）
    private long lastUpdateTick;

    // 缓存的SignalBoundary（避免重复搜索）
    @Nullable
    private SignalBoundary cachedSignalBoundary;

    // 关联的方块实体引用
    @Nullable
    private BlockEntity blockEntityRef;

    public DistantSignalEdgePoint() {
        this.displayState = SignalState.INVALID;
        this.targetGroupId = null;
        this.ownGroupId = null;
        this.lastUpdateTick = 0;
        this.cachedSignalBoundary = null;
        this.blockEntityRef = null;
    }

    public SignalState getDisplayState() {
        return displayState;
    }

    @Nullable
    public UUID getTargetGroupId() {
        return targetGroupId;
    }

    @Nullable
    public UUID getOwnGroupId() {
        return ownGroupId;
    }

    @Override
    public boolean canMerge() {
        // 预告信号点不允许合并
        return false;
    }

    @Override
    public boolean canCoexistWith(EdgePointType<?> otherType, boolean front) {
        // 可以与任何其他类型的EdgePoint共存
        return true;
    }

    @Override
    public void invalidate(LevelAccessor level) {
        super.invalidate(level);
        // 清理状态
        displayState = SignalState.INVALID;
        targetGroupId = null;
        ownGroupId = null;
        cachedSignalBoundary = null;
        blockEntityRef = null;
    }

    @Override
    public void blockEntityAdded(BlockEntity blockEntity, boolean front) {
        super.blockEntityAdded(blockEntity, front);
        // 保存方块实体引用
        this.blockEntityRef = blockEntity;
        // 重置状态
        displayState = SignalState.INVALID;
        targetGroupId = null;
        ownGroupId = null;
        cachedSignalBoundary = null;
        lastUpdateTick = 0;
    }

    @Override
    public void tick(TrackGraph graph, boolean preTrains) {
        super.tick(graph, preTrains);

        if (!preTrains) {
            // 在列车移动后更新状态
            return;
        }

        // 每10个tick更新一次（避免过于频繁）
        // 使用系统时间模拟tick（因为无法直接获取游戏时间）
        long currentTick = System.currentTimeMillis() / 50; // 模拟20tick/秒
        if (currentTick - lastUpdateTick < 10) {
            return;
        }

        // 更新自身信号组ID
        updateOwnGroupId(graph);

        // 搜索前方第一个不同的信号组
        updateTargetSignalGroup(graph);

        // 更新显示状态
        updateDisplayState();

        // 将数据更新到方块实体中
        if (blockEntityRef instanceof DistantSignalBlockEntity distantSignalBlockEntity) {
            distantSignalBlockEntity.updateCacheData(ownGroupId, targetGroupId);
        }

        lastUpdateTick = currentTick;
    }

    /**
     * 更新自身信号组ID
     * 查找同一位置的SignalBoundary，获取其信号组ID
     */
    private void updateOwnGroupId(TrackGraph graph) {
        // 查找同一轨道边上的SignalBoundary
        SignalBoundary signalBoundary = findSignalBoundaryOnSameEdge(graph);
        if (signalBoundary == null) {
            ownGroupId = null;
            return;
        }

        // 确定预告信号在边界的哪一侧
        TrackNode node = graph.locateNode(edgeLocation.getSecond());
        if (node == null) {
            ownGroupId = null;
            return;
        }
        boolean isPrimary = signalBoundary.isPrimary(node);
        ownGroupId = isPrimary ? signalBoundary.groups.getFirst() : signalBoundary.groups.getSecond();
    }

    /**
     * 查找同一轨道边上的SignalBoundary
     */
    @Nullable
    private SignalBoundary findSignalBoundaryOnSameEdge(TrackGraph graph) {
        // 缓存查找结果，避免重复搜索
        if (cachedSignalBoundary != null) {
            return cachedSignalBoundary;
        }

        // 使用TravellingPoint向两个方向移动一小段距离，查找最近的SignalBoundary
        // 预告信号应该就在信号边界附近（0.2米内）
        try {
            // 获取当前边的起点和终点节点
            TrackNode node1 = graph.locateNode(edgeLocation.getFirst());
            TrackNode node2 = graph.locateNode(edgeLocation.getSecond());
            if (node1 == null || node2 == null) {
                return null;
            }

            // 查找连接两个节点的边
            TrackEdge edge = null;
            boolean backwards = false;

            // 查找从node1到node2的边
            for (var entry : graph.getConnectionsFrom(node1).entrySet()) {
                if (entry.getKey().equals(node2)) {
                    edge = entry.getValue();
                    backwards = false;
                    break;
                }
            }

            // 如果没找到，查找反向边
            if (edge == null) {
                for (var entry : graph.getConnectionsFrom(node2).entrySet()) {
                    if (entry.getKey().equals(node1)) {
                        edge = entry.getValue();
                        backwards = true;
                        break;
                    }
                }
            }

            if (edge == null) {
                return null;
            }

            // 创建监听器，查找最近的SignalBoundary
            SignalBoundary[] foundBoundary = new SignalBoundary[]{null};

            TravellingPoint.IEdgePointListener signalListener = (distance, pair) -> {
                TrackEdgePoint edgePoint = pair.getFirst();

                // 只处理SignalBoundary
                if (!(edgePoint instanceof SignalBoundary boundary)) {
                    return false;
                }

                // 找到信号边界
                foundBoundary[0] = boundary;
                return true; // 停止搜索
            };

            // 确定起始位置
            TrackNode startNode = backwards ? node2 : node1;
            TrackNode endNode = backwards ? node1 : node2;
            double startPosition = backwards ? (edge.getLength() - position) : position;

            // 向前搜索0.2米
            TravellingPoint forwardPoint = new TravellingPoint(startNode, endNode, edge, startPosition, backwards);
            TravellingPoint.ITrackSelector straightSelector = forwardPoint.steer(TravellingPoint.SteerDirection.NONE, new net.minecraft.world.phys.Vec3(0, 1, 0));
            forwardPoint.travel(graph, 0.2, straightSelector, signalListener);

            if (foundBoundary[0] != null) {
                cachedSignalBoundary = foundBoundary[0];
                return cachedSignalBoundary;
            }

            // 向后搜索0.2米（如果需要）
            if (startPosition > 0.1) {
                // 稍微向后移动开始搜索
                double backwardStartPos = Math.max(0.001, startPosition - 0.05);
                TravellingPoint backwardPoint = new TravellingPoint(startNode, endNode, edge, backwardStartPos, backwards);
                backwardPoint.travel(graph, 0.2, straightSelector, signalListener);

                if (foundBoundary[0] != null) {
                    cachedSignalBoundary = foundBoundary[0];
                    return cachedSignalBoundary;
                }
            }

        } catch (Exception e) {
            // 出错时回退到简单遍历（只检查同一轨道边）
            for (SignalBoundary boundary : graph.getPoints(EdgePointType.SIGNAL)) {
                if (boundary.edgeLocation != null &&
                    ((boundary.edgeLocation.getFirst().equals(edgeLocation.getFirst()) &&
                      boundary.edgeLocation.getSecond().equals(edgeLocation.getSecond())) ||
                     (boundary.edgeLocation.getFirst().equals(edgeLocation.getSecond()) &&
                      boundary.edgeLocation.getSecond().equals(edgeLocation.getFirst())))) {
                    double distance = Math.abs(boundary.position - position);
                    if (distance < 0.2) {
                        cachedSignalBoundary = boundary;
                        return cachedSignalBoundary;
                    }
                }
            }
        }

        return null;
    }

    /**
     * 更新目标信号组（前方第一个不同的信号组）
     */
    private void updateTargetSignalGroup(TrackGraph graph) {
        // 如果没有自身信号组ID，无法进行比较
        if (ownGroupId == null) {
            targetGroupId = null;
            return;
        }

        // 查找同一位置的SignalBoundary（用于搜索起点）
        SignalBoundary startBoundary = findSignalBoundaryOnSameEdge(graph);
        if (startBoundary == null) {
            targetGroupId = null;
            return;
        }

        // 使用现有工具方法搜索前方最多2个信号组
        List<UUID> foundGroups = SignalSearchUtil.searchForwardSignalGroups(
                startBoundary,
                blockEntityPos,
                2, // 最多寻找2个信号组
                null // 使用默认直行选择器
        );

        // 过滤掉与自身相同的信号组，取第一个不同的
        for (UUID groupId : foundGroups) {
            if (groupId != null && !groupId.equals(ownGroupId)) {
                targetGroupId = groupId;
                return;
            }
        }

        // 没有找到不同的信号组
        targetGroupId = null;
    }

    /**
     * 更新显示状态（基于目标信号组的状态）
     */
    private void updateDisplayState() {
        if (targetGroupId == null) {
            displayState = SignalState.INVALID;
            return;
        }

        // 从全局信号组管理器中获取目标组的状态
        SignalEdgeGroup targetGroup = Create.RAILWAYS.signalEdgeGroups.get(targetGroupId);
        if (targetGroup == null) {
            displayState = SignalState.INVALID;
            return;
        }

        // 根据目标组的状态决定显示状态
        if (!targetGroup.trains.isEmpty()) {
            displayState = SignalState.RED;
        } else {
            // 如果目标组空闲，检查其链式信号
            // 这里简化处理：空闲时显示绿色
            // 实际可能需要检查链式信号状态
            displayState = SignalState.GREEN;
        }
    }

    @Override
    public void read(CompoundTag nbt, boolean migration, DimensionPalette dimensions) {
        super.read(nbt, migration, dimensions);
        if (migration) {
            return;
        }

        if (nbt.contains("DisplayState", Tag.TAG_STRING)) {
            try {
                displayState = SignalState.valueOf(nbt.getString("DisplayState"));
            } catch (IllegalArgumentException e) {
                displayState = SignalState.INVALID;
            }
        } else {
            displayState = SignalState.INVALID;
        }

        if (nbt.contains("TargetGroupId", Tag.TAG_INT_ARRAY)) {
            targetGroupId = nbt.getUUID("TargetGroupId");
        } else {
            targetGroupId = null;
        }

        if (nbt.contains("OwnGroupId", Tag.TAG_INT_ARRAY)) {
            ownGroupId = nbt.getUUID("OwnGroupId");
        } else {
            ownGroupId = null;
        }

        lastUpdateTick = nbt.getLong("LastUpdateTick");
    }

    @Override
    public void write(CompoundTag nbt, DimensionPalette dimensions) {
        super.write(nbt, dimensions);

        nbt.putString("DisplayState", displayState.name());

        if (targetGroupId != null) {
            nbt.putUUID("TargetGroupId", targetGroupId);
        }

        if (ownGroupId != null) {
            nbt.putUUID("OwnGroupId", ownGroupId);
        }

        nbt.putLong("LastUpdateTick", lastUpdateTick);
    }

    @Override
    public void read(FriendlyByteBuf buffer, DimensionPalette dimensions) {
        super.read(buffer, dimensions);

        displayState = SignalState.values()[buffer.readByte()];

        if (buffer.readBoolean()) {
            targetGroupId = buffer.readUUID();
        } else {
            targetGroupId = null;
        }

        if (buffer.readBoolean()) {
            ownGroupId = buffer.readUUID();
        } else {
            ownGroupId = null;
        }

        lastUpdateTick = buffer.readLong();
    }

    @Override
    public void write(FriendlyByteBuf buffer, DimensionPalette dimensions) {
        super.write(buffer, dimensions);

        buffer.writeByte((byte) displayState.ordinal());

        buffer.writeBoolean(targetGroupId != null);
        if (targetGroupId != null) {
            buffer.writeUUID(targetGroupId);
        }

        buffer.writeBoolean(ownGroupId != null);
        if (ownGroupId != null) {
            buffer.writeUUID(ownGroupId);
        }

        buffer.writeLong(lastUpdateTick);
    }

    @Override
    public String toString() {
        return String.format("DistantSignalEdgePoint{id=%s, state=%s, targetGroup=%s, ownGroup=%s}",
            getId(), displayState, targetGroupId, ownGroupId);
    }
}