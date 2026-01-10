package com.easttown.createsignalsystem.block;

import com.easttown.createsignalsystem.init.ModBlockEntities;
import com.easttown.createsignalsystem.block.entity.SignalStateDisplayBlockEntity;
import com.easttown.createsignalsystem.init.ModItems;
import com.simibubi.create.content.trains.signal.SignalBlock;
import com.simibubi.create.content.trains.signal.SignalBlockEntity;
import com.simibubi.create.content.trains.signal.SignalBoundary;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class SignalStateDisplayBlock extends SignalBlock {
    public SignalStateDisplayBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SignalStateDisplayBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        // 使用父类的ticker实现，我们的BlockEntity继承自SignalBlockEntity，因此兼容
        return super.getTicker(level, state, type);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        // 检查玩家手中的物品是否是信号状态控制器
        ItemStack itemInHand = player.getItemInHand(hand);
   /*     if (itemInHand.getItem() == ModItems.SIGNAL_STATE_CONTROLLER.get()) {
            // 如果是控制器，让物品处理右键事件
            return InteractionResult.PASS;
        }
*/
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SignalStateDisplayBlockEntity display) {
            // 显示四显示信号状态
            SignalStateDisplayBlockEntity.FourAspectSignalState fourAspectState = display.getFourAspectState();
            String fourAspectStateName = fourAspectState.name();
            String localizedFourAspectState = getLocalizedFourAspectStateName(fourAspectState);

            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "四显示信号状态: " + localizedFourAspectState + " (" + fourAspectStateName + ")"
            ), false);

            // 显示基础信号状态（兼容）
            SignalBlockEntity.SignalState baseState = display.getState();
            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "基础信号状态: " + baseState.name()
            ), false);

            // 显示当前进路和强制红灯状态
            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "当前进路: " + display.getCurrentRoute() + (display.isForceRed() ? " (强制红灯)" : "")
            ), false);

            // 如果连接了信号边界，显示更多信息
            SignalBoundary boundary = display.getSignal();
            if (boundary != null) {
                player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                        "已连接到信号边界"
                ), false);
            } else {
                player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                        "未连接到任何信号"
                ), false);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        // 禁用扳手切换信号类型的功能，保持为普通模式
        // 不执行任何操作，直接返回SUCCESS
        return InteractionResult.SUCCESS;
    }

    @Override
    public int getAnalogOutputSignal(BlockState pState, Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SignalStateDisplayBlockEntity display) {
            SignalStateDisplayBlockEntity.FourAspectSignalState state = display.getFourAspectState();
            switch (state) {
                case RED: return 15;
                case YELLOW: return 14;
                case GREEN_YELLOW: return 13;
                case GREEN: return 12;
                case INVALID: return 0;
                default: return 0;
            }
        }
        return 0;
    }

    private String getLocalizedStateName(SignalBlockEntity.SignalState state) {
        // 使用语言文件中的本地化字符串
        // 实际实现中应该使用翻译键
        switch (state) {
            case RED: return "Red";
            case YELLOW: return "Yellow";
            case GREEN: return "Green";
            case INVALID: return "Invalid";
            default: return "Unknown";
        }
    }

    private String getLocalizedFourAspectStateName(SignalStateDisplayBlockEntity.FourAspectSignalState state) {
        // 使用语言文件中的本地化字符串
        // 实际实现中应该使用翻译键
        switch (state) {
            case RED: return "红灯";
            case YELLOW: return "黄灯";
            case GREEN_YELLOW: return "绿黄灯";
            case GREEN: return "绿灯";
            case INVALID: return "无效";
            default: return "未知";
        }
    }
}