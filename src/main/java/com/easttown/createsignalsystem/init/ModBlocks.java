package com.easttown.createsignalsystem.init;

import com.easttown.createsignalsystem.RailwaySignalMonitorMod;
import com.easttown.createsignalsystem.block.SignalStateDisplayBlock;
import com.simibubi.create.content.trains.graph.EdgePointType;
import com.simibubi.create.content.trains.track.TrackTargetingBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.easttown.createsignalsystem.init.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RailwaySignalMonitorMod.MOD_ID);

    // 信号状态显示器方块
    public static final RegistryObject<Block> SIGNAL_STATE_DISPLAY = registerBlock("signal_state_display",
            () -> new SignalStateDisplayBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(2.0f, 6.0f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion() // 允许光线透过
            ));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        // 调用ModItems中的注册方法
        return ModItems.registerBlockItem(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        // ITEMS注册现在在ModItems中处理
    }
}