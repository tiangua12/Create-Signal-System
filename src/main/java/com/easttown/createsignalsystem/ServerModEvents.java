package com.easttown.createsignalsystem;

import com.easttown.createsignalsystem.system.SignalStateManager;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 服务器端事件处理器
 *
 * 负责：
 * 1. 服务器tick时更新信号状态管理器
 * 2. 世界加载/卸载时清理资源
 */
@Mod.EventBusSubscriber(modid = CreateSignalSystemMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerModEvents {

    /**
     * 服务器tick事件（每tick执行）
     */
    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        // 更新所有已加载世界的信号状态
        event.getServer().getAllLevels().forEach(level -> {
            if (level instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel) level;
                SignalStateManager manager = SignalStateManager.get(serverLevel);
                if (manager != null) {
                    manager.tick(serverLevel);
                }
            }
        });
    }

    /**
     * 世界卸载事件（清理资源）
     */
    @SubscribeEvent
    public static void onWorldUnload(LevelEvent.Unload event) {
        // 如果服务器关闭，清理客户端实例
        if (event.getLevel().isClientSide()) {
            // 客户端实例清理（如果需要）
        }
    }
}