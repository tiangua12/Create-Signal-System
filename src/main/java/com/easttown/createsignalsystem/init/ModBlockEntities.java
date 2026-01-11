package com.easttown.createsignalsystem.init;

import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.easttown.createsignalsystem.block.entity.SignalStateDisplayBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CreateSignalSystemMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<SignalStateDisplayBlockEntity>> SIGNAL_STATE_DISPLAY =
            BLOCK_ENTITIES.register("signal_state_display",
                    () -> BlockEntityType.Builder.of(SignalStateDisplayBlockEntity::new,
                            ModBlocks.SIGNAL_STATE_DISPLAY.get()).build(null));

    public static void register(com.easttown.createsignalsystem.CreateSignalSystemMod mod) {
        // 注册在Mod主类中完成
    }
}