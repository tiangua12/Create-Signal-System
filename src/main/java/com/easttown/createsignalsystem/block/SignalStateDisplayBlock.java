package com.easttown.createsignalsystem.block;

import com.easttown.createsignalsystem.init.ModBlockEntities;
import com.easttown.createsignalsystem.block.entity.SignalStateDisplayBlockEntity;
import com.easttown.createsignalsystem.client.gui.screen.RouteConfigScreen;
import com.easttown.createsignalsystem.init.ModItems;
import com.simibubi.create.content.trains.signal.SignalBlock;
import com.simibubi.create.AllItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.Minecraft;
import com.simibubi.create.content.trains.signal.SignalBlockEntity;
import com.simibubi.create.content.trains.signal.SignalBoundary;
import java.util.UUID;
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
        // 检查是否拿着扳手，如果是则让onWrenched处理
        boolean isWrench = player.getItemInHand(hand).is(AllItems.WRENCH.get());
        if (isWrench) {
            return InteractionResult.PASS;
        }

        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof SignalStateDisplayBlockEntity display) {
            // 显示四显示信号状态
            SignalStateDisplayBlockEntity.FourAspectSignalState fourAspectState = display.getFourAspectState();
            String fourAspectStateName = fourAspectState.name();
            String localizedFourAspectState = getLocalizedFourAspectStateName(fourAspectState);
            String fourAspectColor = getFourAspectStateColor(fourAspectState);

            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "§6四显示信号状态: " + fourAspectColor + localizedFourAspectState + " §7(" + fourAspectStateName + ")"
            ), false);

            // 显示基础信号状态（兼容）
            SignalBlockEntity.SignalState baseState = display.getState();
            String baseStateColor = getBaseStateColor(baseState);
            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "§6基础信号状态: " + baseStateColor + baseState.name()
            ), false);

            // 显示当前进路和强制红灯状态
            String routeInfo = "§6当前进路: §e" + display.getCurrentRoute();
            if (display.isForceRed()) {
                routeInfo += " §c(强制红灯)";
            }
            player.displayClientMessage(net.minecraft.network.chat.Component.literal(routeInfo), false);

            // 分隔线
            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "§8------------------------"
            ), false);

            // 如果连接了信号边界，显示更多信息
            SignalBoundary boundary = display.getSignal();
            if (boundary != null) {
                player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                        "§6连接状态: §a已连接到信号边界"
                ), false);
                // 显示边界ID
                if (boundary.id != null) {
                    String boundaryId = boundary.id.toString();
                    if (boundaryId.length() > 24) {
                        boundaryId = boundaryId.substring(0, 12) + "..." + boundaryId.substring(boundaryId.length() - 12);
                    }
                    player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                            "§6边界ID: §b" + boundaryId
                    ), false);
                }
            } else {
                player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                        "§6连接状态: §c未连接到任何信号"
                ), false);
            }

            // 分隔线
            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "§8------------------------"
            ), false);

            // 显示每个区间的详细信息
            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "§6=== 区间占用状态 ==="
            ), false);

            // 获取区间数据
            UUID[] signalGroupIds = display.getSignalGroupIds();
            boolean[] occupancyStates = display.getOccupancyStates();
            String[] boundaryIds = display.getBoundaryIds();

            // 区间描述数组
            String[] intervalDescriptions = {"当前区间", "第一前方区间", "第二前方区间", "第三前方区间"};
            String[] intervalSymbols = {"§f[0]", "§f[1]", "§f[2]", "§f[3]"};

            for (int i = 0; i < 4; i++) {
                String intervalDesc = intervalDescriptions[i];
                String occupancyStatus = occupancyStates[i] ? "§c占用" : "§a空闲";
                String signalGroupInfo;
                if (signalGroupIds[i] != null) {
                    String uuidStr = signalGroupIds[i].toString();
                    signalGroupInfo = "§7信号组: §e" + uuidStr.substring(0, 8) + "...";
                } else {
                    signalGroupInfo = "§7无信号组";
                }

                String boundaryInfo;
                if (boundaryIds[i] != null && !boundaryIds[i].isEmpty()) {
                    // 截断边界ID显示，如果太长
                    String boundaryId = boundaryIds[i];
                    if (boundaryId.length() > 16) {
                        boundaryId = boundaryId.substring(0, 8) + "..." + boundaryId.substring(boundaryId.length() - 8);
                    }
                    boundaryInfo = "§7边界: §b" + boundaryId;
                } else {
                    boundaryInfo = "§7无边界";
                }

                String intervalInfo = String.format("%s §f%s: %s | %s | %s",
                    intervalSymbols[i], intervalDesc, occupancyStatus, signalGroupInfo, boundaryInfo);

                player.displayClientMessage(net.minecraft.network.chat.Component.literal(intervalInfo), false);
            }

            player.displayClientMessage(net.minecraft.network.chat.Component.literal(
                    "§6====================="
            ), false);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();

        if (player == null) {
            return InteractionResult.PASS;
        }

        // 检查是否按住Shift（Shift+扳手快速拆除由onSneakWrenched处理）
        if (player.isShiftKeyDown()) {
            return InteractionResult.PASS;
        }

        // 检查玩家手中的物品是否是扳手
        ItemStack heldItem = player.getItemInHand(context.getHand());
        boolean isWrench = heldItem.is(AllItems.WRENCH.get());

        if (!isWrench) {
            return InteractionResult.PASS;
        }

        // 客户端：打开GUI
        if (level.isClientSide) {
            // 打开进路配置GUI
            openRouteConfigScreen(context.getClickedPos());
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.SUCCESS;
    }

    // 客户端方法：打开进路配置屏幕
    @OnlyIn(Dist.CLIENT)
    private void openRouteConfigScreen(BlockPos pos) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null || minecraft.player == null) {
            return;
        }

        // 获取方块实体
        if (minecraft.level.getBlockEntity(pos) instanceof SignalStateDisplayBlockEntity blockEntity) {
            // 打开配置屏幕
            minecraft.setScreen(new RouteConfigScreen(blockEntity));
        } else {
            // 如果无法获取方块实体，显示错误信息
            minecraft.player.displayClientMessage(
                net.minecraft.network.chat.Component.literal("§c无法打开配置界面：信号机方块实体不存在"),
                false
            );
        }
    }

    @Override
    public InteractionResult onSneakWrenched(BlockState state, UseOnContext context) {
        // Shift+右键使用扳手快速拆除
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

    private String getFourAspectStateColor(SignalStateDisplayBlockEntity.FourAspectSignalState state) {
        // 返回对应状态的颜色代码
        switch (state) {
            case RED: return "§c";      // 红色
            case YELLOW: return "§e";   // 黄色
            case GREEN_YELLOW: return "§a"; // 绿色（绿黄灯用绿色）
            case GREEN: return "§a";    // 绿色
            case INVALID: return "§7";  // 灰色
            default: return "§f";       // 白色
        }
    }

    private String getBaseStateColor(SignalBlockEntity.SignalState state) {
        // 返回基础信号状态的颜色代码
        switch (state) {
            case RED: return "§c";      // 红色
            case YELLOW: return "§e";   // 黄色
            case GREEN: return "§a";    // 绿色
            case INVALID: return "§7";  // 灰色
            default: return "§f";       // 白色
        }
    }
}