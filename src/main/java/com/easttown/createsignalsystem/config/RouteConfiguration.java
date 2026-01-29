package com.easttown.createsignalsystem.config;

import com.simibubi.create.content.trains.entity.TravellingPoint;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * 进路配置类 - 存储在信号机方块实体的NBT中
 * 每个进路有4个道岔配置槽位，进路总数从6个增加到7个（槽位1-7）
 */
public class RouteConfiguration {
    private int slotId; // 槽位ID (1-7)，对应红石信号选择
    private String displayNumber; // 显示编号（可自定义，如"1"、"10"、"A1"等）
    private String displayName; // 显示名称
    private TurnAction[] turnActions = new TurnAction[4]; // 4个道岔配置槽位
    private boolean defaultStraight = true; // 默认直行

    public RouteConfiguration() {
        this(0);
    }

    public RouteConfiguration(int slotId) {
        this.slotId = slotId;
        this.displayNumber = String.valueOf(slotId);
        this.displayName = "进路 " + slotId;
        for (int i = 0; i < turnActions.length; i++) {
            turnActions[i] = new TurnAction(i + 1); // 默认直行
        }
    }

    // 获取和设置方法
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TurnAction[] getTurnActions() {
        return turnActions;
    }

    public TurnAction getTurnAction(int index) {
        if (index >= 0 && index < turnActions.length) {
            return turnActions[index];
        }
        return null;
    }

    public void setTurnAction(int index, TurnAction action) {
        if (index >= 0 && index < turnActions.length) {
            turnActions[index] = action;
        }
    }

    public boolean isDefaultStraight() {
        // 动态检查：如果有任何非直行的转向配置，就不是默认直行
        if (turnActions == null) {
            return true;
        }
        for (TurnAction action : turnActions) {
            if (action != null && action.getDirection() != TravellingPoint.SteerDirection.NONE) {
                return false;
            }
        }
        return true;
    }

    public void setDefaultStraight(boolean defaultStraight) {
        this.defaultStraight = defaultStraight;
    }

    // NBT序列化方法
    public CompoundTag serialize() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("SlotId", slotId);
        tag.putString("DisplayNumber", displayNumber);
        tag.putString("DisplayName", displayName);
        tag.putBoolean("DefaultStraight", defaultStraight);

        ListTag actionsTag = new ListTag();
        for (int i = 0; i < turnActions.length; i++) {
            if (turnActions[i] != null) {
                CompoundTag actionTag = turnActions[i].serialize();
                actionTag.putInt("Index", i); // 存储索引用于反序列化
                actionsTag.add(actionTag);
            }
        }
        tag.put("TurnActions", actionsTag);
        return tag;
    }

    public static RouteConfiguration deserialize(CompoundTag tag) {
        RouteConfiguration config = new RouteConfiguration();
        config.slotId = tag.getInt("SlotId");
        config.displayNumber = tag.getString("DisplayNumber");
        config.displayName = tag.getString("DisplayName");
        if (tag.contains("DefaultStraight")) {
            config.defaultStraight = tag.getBoolean("DefaultStraight");
        }

        if (tag.contains("TurnActions")) {
            ListTag actionsTag = tag.getList("TurnActions", Tag.TAG_COMPOUND);
            for (int i = 0; i < actionsTag.size(); i++) {
                CompoundTag actionTag = actionsTag.getCompound(i);
                int index = actionTag.getInt("Index");
                if (index >= 0 && index < config.turnActions.length) {
                    config.turnActions[index] = TurnAction.deserialize(actionTag);
                }
            }
        }
        return config;
    }

    /**
     * 创建默认的进路配置（向后兼容性）
     */
    public static RouteConfiguration createDefaultRoute(int routeId) {
        RouteConfiguration config = new RouteConfiguration(routeId);

        // 根据现有的硬编码逻辑设置默认值
        if (routeId == 1) {
            // 进路1：直行
            for (int i = 0; i < 4; i++) {
                config.turnActions[i] = new TurnAction(i + 1, TravellingPoint.SteerDirection.NONE);
            }
        } else if (routeId == 2) {
            // 进路2：第一个岔道左转，之后直行
            config.turnActions[0] = new TurnAction(1, TravellingPoint.SteerDirection.LEFT);
            for (int i = 1; i < 4; i++) {
                config.turnActions[i] = new TurnAction(i + 1, TravellingPoint.SteerDirection.NONE);
            }
        } else if (routeId == 3) {
            // 进路3：两个岔道都左转，之后直行
            config.turnActions[0] = new TurnAction(1, TravellingPoint.SteerDirection.LEFT);
            config.turnActions[1] = new TurnAction(2, TravellingPoint.SteerDirection.LEFT);
            for (int i = 2; i < 4; i++) {
                config.turnActions[i] = new TurnAction(i + 1, TravellingPoint.SteerDirection.NONE);
            }
        } else if (routeId == 4) {
            // 进路4：第一个岔道右转，之后直行
            config.turnActions[0] = new TurnAction(1, TravellingPoint.SteerDirection.RIGHT);
            for (int i = 1; i < 4; i++) {
                config.turnActions[i] = new TurnAction(i + 1, TravellingPoint.SteerDirection.NONE);
            }
        } else if (routeId == 5) {
            // 进路5：两个岔道都右转，之后直行
            config.turnActions[0] = new TurnAction(1, TravellingPoint.SteerDirection.RIGHT);
            config.turnActions[1] = new TurnAction(2, TravellingPoint.SteerDirection.RIGHT);
            for (int i = 2; i < 4; i++) {
                config.turnActions[i] = new TurnAction(i + 1, TravellingPoint.SteerDirection.NONE);
            }
        } else {
            // 进路6,7：默认直行
            for (int i = 0; i < 4; i++) {
                config.turnActions[i] = new TurnAction(i + 1, TravellingPoint.SteerDirection.NONE);
            }
        }

        return config;
    }
}


