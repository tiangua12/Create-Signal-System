package com.easttown.createsignalsystem;

import com.easttown.createsignalsystem.config.ModConfiguration;
import com.easttown.createsignalsystem.init.ModBlocks;
import com.easttown.createsignalsystem.init.ModBlockEntities;
import com.easttown.createsignalsystem.init.ModCreativeModeTabs;
import com.easttown.createsignalsystem.init.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
        // 初始化
        LOGGER.info("Create: Signal System mod initialized");
    }
}