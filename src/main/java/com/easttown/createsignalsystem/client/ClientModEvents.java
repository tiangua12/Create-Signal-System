package com.easttown.createsignalsystem.client;

import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.easttown.createsignalsystem.init.ModBlockEntities;
import com.simibubi.create.content.trains.signal.SignalRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 客户端事件处理器
 * 负责注册客户端相关的渲染器和模型
 */
@Mod.EventBusSubscriber(modid = CreateSignalSystemMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    /**
     * 注册方块实体渲染器
     */
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // 注册信号状态显示器的渲染器
        // 使用Create模组的SignalRenderer来渲染信号机和轨道点
        BlockEntityRenderers.register(
                ModBlockEntities.SIGNAL_STATE_DISPLAY.get(),
                SignalRenderer::new
        );

        CreateSignalSystemMod.LOGGER.info("注册信号状态显示器渲染器成功");
    }
}