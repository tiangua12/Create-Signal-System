package com.easttown.createsignalsystem.edgepoint;

import com.simibubi.create.content.trains.graph.DimensionPalette;
import com.simibubi.create.content.trains.graph.EdgePointType;
import com.simibubi.create.content.trains.graph.TrackGraph;
import com.simibubi.create.content.trains.signal.SingleBlockEntityEdgePoint;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;

/**
 * 标记点EdgePoint示例
 * 这是一个简单的轨道标记点，可以附加标签信息
 * 主要用于演示如何创建新的EdgePoint类型
 */
public class MarkerEdgePoint extends SingleBlockEntityEdgePoint {

    private String label = "";

    public MarkerEdgePoint() {
        // 默认构造函数
    }

    public MarkerEdgePoint(String label) {
        this.label = label != null ? label : "";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label != null ? label : "";
    }

    @Override
    public boolean canMerge() {
        // 标记点不允许合并
        return false;
    }

    @Override
    public boolean canCoexistWith(EdgePointType<?> otherType, boolean front) {
        // 标记点可以与任何其他类型的EdgePoint共存
        return true;
    }

    @Override
    public void invalidate(LevelAccessor level) {
        // 调用父类方法处理方块实体失效
        super.invalidate(level);
        // 可以在这里添加自定义的清理逻辑
    }

    @Override
    public void blockEntityAdded(BlockEntity blockEntity, boolean front) {
        // 调用父类方法记录方块实体位置
        super.blockEntityAdded(blockEntity, front);
        // 可以在这里初始化标记点的状态
    }

    @Override
    public void blockEntityRemoved(BlockPos blockEntityPos, boolean front) {
        // 调用父类方法从图中移除
        super.blockEntityRemoved(blockEntityPos, front);
        // 可以在这里清理资源
    }

    @Override
    public void tick(TrackGraph graph, boolean preTrains) {
        // 每个tick执行的操作
        // 例如：检查标签变化或触发事件
    }

    @Override
    public void read(CompoundTag nbt, boolean migration, DimensionPalette dimensions) {
        super.read(nbt, migration, dimensions);
        if (migration) {
            return;
        }
        if (nbt.contains("Label", Tag.TAG_STRING)) {
            label = nbt.getString("Label");
        }
    }

    @Override
    public void write(CompoundTag nbt, DimensionPalette dimensions) {
        super.write(nbt, dimensions);
        if (!label.isEmpty()) {
            nbt.putString("Label", label);
        }
    }

    @Override
    public void read(FriendlyByteBuf buffer, DimensionPalette dimensions) {
        super.read(buffer, dimensions);
        label = buffer.readUtf(256); // 读取标签
    }

    @Override
    public void write(FriendlyByteBuf buffer, DimensionPalette dimensions) {
        super.write(buffer, dimensions);
        buffer.writeUtf(label, 256); // 写入标签
    }

    @Override
    public String toString() {
        return String.format("MarkerEdgePoint{id=%s, label='%s', position=%.2f}",
            getId(), label, position);
    }
}