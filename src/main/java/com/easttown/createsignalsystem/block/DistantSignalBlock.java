package com.easttown.createsignalsystem.block;

import com.easttown.createsignalsystem.block.entity.DistantSignalBlockEntity;
import com.easttown.createsignalsystem.init.ModBlockEntities;
import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.IBE;
import org.jetbrains.annotations.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SignalGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

/**
 * 预告信号方块
 * 显示前方下一个不同信号组的状态
 */
public class DistantSignalBlock extends Block implements IBE<DistantSignalBlockEntity>, IWrenchable {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public DistantSignalBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(POWERED, false));
    }

    @Override
    public Class<DistantSignalBlockEntity> getBlockEntityClass() {
        return DistantSignalBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends DistantSignalBlockEntity> getBlockEntityType() {
        return ModBlockEntities.DISTANT_SIGNAL.get();
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DistantSignalBlockEntity(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Override
    public boolean shouldCheckWeakPower(BlockState state, SignalGetter level, BlockPos pos, Direction side) {
        return false;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
            .setValue(POWERED, Boolean.valueOf(context.getLevel()
                .hasNeighborSignal(context.getClickedPos())));
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos,
                                boolean isMoving) {
        if (level.isClientSide) {
            return;
        }
        boolean powered = state.getValue(POWERED);
        if (powered == level.hasNeighborSignal(pos)) {
            return;
        }
        if (powered) {
            level.scheduleTick(pos, this, 4);
        } else {
            level.setBlock(pos, state.cycle(POWERED), 2);
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(POWERED) && !level.hasNeighborSignal(pos)) {
            level.setBlock(pos, state.cycle(POWERED), 2);
        }
    }

    @Override
    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        IBE.onRemove(state, worldIn, pos, newState);
    }

    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        // 预告信号可以使用扳手调整方向等
        // 暂时不实现特殊功能
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult onSneakWrenched(BlockState state, UseOnContext context) {
        // Shift+右键使用扳手快速拆除
        return IWrenchable.super.onSneakWrenched(state, context);
    }
}