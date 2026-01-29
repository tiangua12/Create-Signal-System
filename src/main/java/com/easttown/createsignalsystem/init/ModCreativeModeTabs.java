package com.easttown.createsignalsystem.init;

import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.easttown.createsignalsystem.init.ModBlocks;
import com.easttown.createsignalsystem.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<
            CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateSignalSystemMod.MOD_ID);

    public static final RegistryObject<
            CreativeModeTab> TRACK_SIGNAL_DISPLAY_TAB = CREATIVE_MODE_TABS.register("track_signal_display_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.create_signal_system"))
                    .icon(() -> new ItemStack(ModBlocks.SIGNAL_STATE_DISPLAY.get()))
                    .displayItems((parameters, output) -> {
                        // 添加所有mod物品到这里
                        output.accept(ModBlocks.SIGNAL_STATE_DISPLAY.get());
                  //      output.accept(ModBlocks.DISTANT_SIGNAL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}