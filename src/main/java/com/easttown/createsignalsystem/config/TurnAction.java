package com.easttown.createsignalsystem.config;

import com.simibubi.create.content.trains.entity.TravellingPoint;
import net.minecraft.nbt.CompoundTag;

/**
 * 转向动作类 - 使用三格滑条控制左转/前进/右转
 */
public class TurnAction {
    private int junctionIndex; // 第几个岔道 (1, 2, 3, 4)
    private TravellingPoint.SteerDirection direction; // 转向方向 (LEFT, RIGHT, NONE)
    private double distanceThreshold; // 距离阈值（可选高级参数）
    private double speedLimit; // 速度限制（可选高级参数，实际影响旅行点速度）

    public TurnAction() {
        this(1, TravellingPoint.SteerDirection.NONE);
    }

    public TurnAction(int junctionIndex) {
        this(junctionIndex, TravellingPoint.SteerDirection.NONE);
    }

    public TurnAction(int junctionIndex, TravellingPoint.SteerDirection direction) {
        this(junctionIndex, direction, 0.0, 0.0);
    }

    public TurnAction(int junctionIndex, TravellingPoint.SteerDirection direction, double distanceThreshold, double speedLimit) {
        this.junctionIndex = junctionIndex;
        this.direction = direction;
        this.distanceThreshold = distanceThreshold;
        this.speedLimit = speedLimit;
    }

    public int getJunctionIndex() {
        return junctionIndex;
    }

    public void setJunctionIndex(int junctionIndex) {
        this.junctionIndex = junctionIndex;
    }

    public TravellingPoint.SteerDirection getDirection() {
        return direction;
    }

    public void setDirection(TravellingPoint.SteerDirection direction) {
        this.direction = direction;
    }

    public double getDistanceThreshold() {
        return distanceThreshold;
    }

    public void setDistanceThreshold(double distanceThreshold) {
        this.distanceThreshold = distanceThreshold;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(double speedLimit) {
        this.speedLimit = speedLimit;
    }

    // NBT序列化方法
    public CompoundTag serialize() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("JunctionIndex", junctionIndex);
        tag.putString("Direction", direction.name());
        tag.putDouble("DistanceThreshold", distanceThreshold);
        tag.putDouble("SpeedLimit", speedLimit);
        return tag;
    }

    public static TurnAction deserialize(CompoundTag tag) {
        TurnAction action = new TurnAction();
        action.junctionIndex = tag.getInt("JunctionIndex");

        try {
            action.direction = TravellingPoint.SteerDirection.valueOf(tag.getString("Direction"));
        } catch (IllegalArgumentException e) {
            action.direction = TravellingPoint.SteerDirection.NONE;
        }

        if (tag.contains("DistanceThreshold")) {
            action.distanceThreshold = tag.getDouble("DistanceThreshold");
        }
        if (tag.contains("SpeedLimit")) {
            action.speedLimit = tag.getDouble("SpeedLimit");
        }
        return action;
    }

    @Override
    public String toString() {
        return String.format("TurnAction{岔道%d, 方向=%s, 距离阈值=%.1f, 速度限制=%.1f}",
                junctionIndex, direction, distanceThreshold, speedLimit);
    }
}