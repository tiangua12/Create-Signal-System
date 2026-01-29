package com.easttown.createsignalsystem;

import com.easttown.createsignalsystem.config.ModConfiguration;
import com.easttown.createsignalsystem.init.ModBlocks;
import com.easttown.createsignalsystem.init.ModBlockEntities;
import com.easttown.createsignalsystem.init.ModCreativeModeTabs;
import com.easttown.createsignalsystem.init.ModItems;
import com.easttown.createsignalsystem.network.ConfigureRoutePacket;
import com.easttown.createsignalsystem.network.NetworkHandler;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CreateSignalSystemMod.MOD_ID)
public class CreateSignalSystemMod {
    public static final String MOD_ID = "create_signal_system";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CreateSignalSystemMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 注册配置
        ModConfiguration.register();

        // 注册创造模式物品栏
        ModItems.register(modEventBus);
        // 注册方块和物品
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        // 注册方块实体
        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);

        // 注册CommonSetup事件
        modEventBus.addListener(this::onCommonSetup);

        // 初始化
        LOGGER.info("Create: Signal System mod initialized");
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // 注册网络包
            NetworkHandler.registerPackets();
            LOGGER.info("已注册进路配置数据包");
            LOGGER.info("Create: Signal System mod common setup complete");
        });
    }
}