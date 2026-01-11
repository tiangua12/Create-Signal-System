package com.easttown.createsignalsystem.init;

import com.easttown.createsignalsystem.CreateSignalSystemMod;
import com.simibubi.create.content.trains.graph.EdgePointType;
import com.simibubi.create.content.trains.track.TrackTargetingBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateSignalSystemMod.MOD_ID);

    // 信号状态控制器
  /*  public static final RegistryObject<Item> SIGNAL_STATE_CONTROLLER = ITEMS.register("signal_state_controller",
            () -> new SignalStateControllerItem(new Item.Properties()
                    .stacksTo(1)
                    .durability(100)));
*/
    /**
     * 注册方块物品（供ModBlocks调用）
     */
    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ITEMS.register(name, () -> new TrackTargetingBlockItem(block.get(),
            new Item.Properties(),
            EdgePointType.SIGNAL));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}