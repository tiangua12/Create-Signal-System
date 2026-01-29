package com.easttown.createsignalsystem.block.entity;

import com.easttown.createsignalsystem.edgepoint.DistantSignalEdgePoint;
import com.easttown.createsignalsystem.init.ModEdgePointTypes;
import com.easttown.createsignalsystem.init.ModBlockEntities;
import com.easttown.createsignalsystem.util.SignalSearchUtil;
import com.simibubi.create.content.contraptions.ITransformableBlockEntity;
import com.simibubi.create.content.contraptions.StructureTransform;
import com.simibubi.create.content.trains.graph.EdgePointType;
import com.simibubi.create.content.trains.graph.TrackGraph;
import com.simibubi.create.content.trains.signal.SignalBlockEntity;
import com.simibubi.create.content.trains.signal.SignalBlockEntity.SignalState;
import com.simibubi.create.content.trains.signal.SignalBoundary;
import com.simibubi.create.content.trains.track.TrackTargetingBehaviour;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.utility.NBTHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * 预告信号方块实体
 * 显示前方下一个不同信号组的状态
 */
public class DistantSignalBlockEntity extends SmartBlockEntity implements ITransformableBlockEntity {

    // EdgePoint类型（在ModEdgePointTypes中注册）
    public static EdgePointType<DistantSignalEdgePoint> DISTANT_SIGNAL_TYPE = ModEdgePointTypes.DISTANT_SIGNAL;

    public TrackTargetingBehaviour<DistantSignalEdgePoint> edgePoint;

    private SignalState displayState;
    private boolean lastReportedPower;

    // 缓存的信号组ID
    private UUID ownGroupIdCache;
    private UUID targetGroupIdCache;

    public DistantSignalBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.displayState = SignalState.INVALID;
        this.lastReportedPower = false;
        this.ownGroupIdCache = null;
        this.targetGroupIdCache = null;
    }

    public DistantSignalBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntities.DISTANT_SIGNAL.get(), pos, state);
    }

    @Override
    protected void write(CompoundTag tag, boolean clientPacket) {
        super.write(tag, clientPacket);
        NBTHelper.writeEnum(tag, "DisplayState", displayState);
        tag.putBoolean("Power", lastReportedPower);
        if (ownGroupIdCache != null) {
            tag.putUUID("OwnGroupIdCache", ownGroupIdCache);
        }
        if (targetGroupIdCache != null) {
            tag.putUUID("TargetGroupIdCache", targetGroupIdCache);
        }
    }

    @Override
    protected void read(CompoundTag tag, boolean clientPacket) {
        super.read(tag, clientPacket);
        displayState = NBTHelper.readEnum(tag, "DisplayState", SignalState.class);
        lastReportedPower = tag.getBoolean("Power");
        if (tag.contains("OwnGroupIdCache")) {
            ownGroupIdCache = tag.getUUID("OwnGroupIdCache");
        } else {
            ownGroupIdCache = null;
        }
        if (tag.contains("TargetGroupIdCache")) {
            targetGroupIdCache = tag.getUUID("TargetGroupIdCache");
        } else {
            targetGroupIdCache = null;
        }
        invalidateRenderBoundingBox();
    }

    @Nullable
    public DistantSignalEdgePoint getDistantSignal() {
        return edgePoint.getEdgePoint();
    }

    public boolean isPowered() {
        return displayState == SignalState.RED;
    }

    public SignalState getDisplayState() {
        return displayState;
    }

    public SignalState getState() {
        return displayState;
    }

    public boolean getReportedPower() {
        return lastReportedPower;
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        // 使用自定义的EdgePoint类型（已在ModEdgePointTypes中注册）
        edgePoint = new TrackTargetingBehaviour<>(this, DISTANT_SIGNAL_TYPE);
        behaviours.add(edgePoint);
    }

    @Override
    public void tick() {
        super.tick();
        if (level.isClientSide) {
            return;
        }

        DistantSignalEdgePoint distantSignal = getDistantSignal();
        if (distantSignal == null) {
            enterState(SignalState.INVALID);
            return;
        }

        // 注意：DistantSignalEdgePoint现在通过updateCacheData()方法直接更新缓存数据
        // 这里不再需要调用updateOwnGroupId()和updateDisplayState()
        // 显示状态已经在updateCacheData()中更新

        // 处理红石信号
        BlockState blockState = getBlockState();
        blockState.getOptionalValue(com.easttown.createsignalsystem.block.DistantSignalBlock.POWERED)
            .ifPresent(powered -> {
                if (lastReportedPower == powered) {
                    return;
                }
                lastReportedPower = powered;
                notifyUpdate();
            });
    }

    /**
     * 更新自身信号组ID
     * 从关联的SignalBoundary获取（如果有）
     */
    private void updateOwnGroupId() {
        DistantSignalEdgePoint distantSignal = getDistantSignal();
        if (distantSignal == null) {
            ownGroupIdCache = null;
            return;
        }

        UUID newOwnGroupId = distantSignal.getOwnGroupId();
        // 如果已经缓存，使用缓存
        if (ownGroupIdCache != null && newOwnGroupId != null &&
            ownGroupIdCache.equals(newOwnGroupId)) {
            return;
        }

        ownGroupIdCache = newOwnGroupId;
        setChanged();
    }

    /**
     * 更新显示状态
     */
    private void updateDisplayState(DistantSignalEdgePoint distantSignal) {
        SignalState newState = distantSignal.getDisplayState();

        // 如果状态没有变化，不更新
        if (this.displayState == newState) {
            return;
        }

        enterState(newState);
    }

    public void enterState(SignalState state) {
        if (this.displayState == state) {
            return;
        }
        this.displayState = state;
        notifyUpdate();
    }

    @Override
    protected AABB createRenderBoundingBox() {
        if (edgePoint == null) {
            return new AABB(worldPosition);
        }
        return new AABB(worldPosition, edgePoint.getGlobalPosition()).inflate(2);
    }

    @Override
    public void transform(StructureTransform transform) {
        edgePoint.transform(transform);
    }

    /**
     * 获取当前显示状态（用于渲染）
     */
    public SignalState getStateForRenderer() {
        return displayState;
    }

    /**
     * 更新缓存数据（由DistantSignalEdgePoint调用）
     */
    public void updateCacheData(@Nullable UUID ownGroupId, @Nullable UUID targetGroupId) {
        boolean changed = false;

        // 更新自身组ID缓存
        if (ownGroupIdCache == null ? ownGroupId != null : !ownGroupIdCache.equals(ownGroupId)) {
            ownGroupIdCache = ownGroupId;
            changed = true;
        }

        // 更新目标组ID缓存
        if (targetGroupIdCache == null ? targetGroupId != null : !targetGroupIdCache.equals(targetGroupId)) {
            targetGroupIdCache = targetGroupId;
            changed = true;
        }

        if (changed) {
            // 重新计算显示状态
            updateDisplayStateFromCache();
            setChanged();
        }
    }

    /**
     * 从缓存数据计算显示状态
     */
    private void updateDisplayStateFromCache() {
        if (targetGroupIdCache == null) {
            enterState(SignalState.INVALID);
            return;
        }

        // 从全局信号组管理器中获取目标组的状态
        com.simibubi.create.content.trains.signal.SignalEdgeGroup targetGroup =
            com.simibubi.create.Create.RAILWAYS.signalEdgeGroups.get(targetGroupIdCache);

        if (targetGroup == null) {
            enterState(SignalState.INVALID);
            return;
        }

        // 根据目标组的状态决定显示状态
        SignalState newState = !targetGroup.trains.isEmpty() ? SignalState.RED : SignalState.GREEN;
        enterState(newState);
    }
}