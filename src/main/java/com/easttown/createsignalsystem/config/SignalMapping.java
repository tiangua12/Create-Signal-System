package com.easttown.createsignalsystem.config;

import net.minecraft.nbt.CompoundTag;

/**
 * 红石信号到进路槽位的映射配置
 */
public class SignalMapping {
    private int redstoneSignal; // 红石信号强度 (1-15)
    private int targetSlotId; // 目标进路槽位ID (1-7)

    public SignalMapping(int redstoneSignal, int targetSlotId) {
        this.redstoneSignal = redstoneSignal;
        this.targetSlotId = targetSlotId;
    }

    public int getRedstoneSignal() {
        return redstoneSignal;
    }

    public void setRedstoneSignal(int redstoneSignal) {
        this.redstoneSignal = redstoneSignal;
    }

    public int getTargetSlotId() {
        return targetSlotId;
    }

    public void setTargetSlotId(int targetSlotId) {
        this.targetSlotId = targetSlotId;
    }

    // NBT序列化
    public CompoundTag serialize() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("RedstoneSignal", redstoneSignal);
        tag.putInt("TargetSlotId", targetSlotId);
        return tag;
    }

    public static SignalMapping deserialize(CompoundTag tag) {
        return new SignalMapping(
            tag.getInt("RedstoneSignal"),
            tag.getInt("TargetSlotId")
        );
    }

    @Override
    public String toString() {
        return String.format("SignalMapping{红石信号=%d -> 进路槽位=%d}", redstoneSignal, targetSlotId);
    }
}