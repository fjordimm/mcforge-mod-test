package io.github.fjordimm.bayunga.block;

import io.github.fjordimm.bayunga.util.UtilVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AmogusBlock extends Block implements SimpleWaterloggedBlock
{
    public static final String REGISTRY_NAME = "amogus";

    public AmogusBlock()
    {
        super(makeBlockProperties());
        this.registerDefaultState(makeDefaultBlockState());
    }

    private static BlockBehaviour.Properties makeBlockProperties()
    {
        return BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_RED)
                .sound(SoundType.FUNGUS)
                .strength(0.1F);
    }

    private BlockState makeDefaultBlockState()
    {
        return this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(FACING, Direction.SOUTH);
    }

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState()
                .setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER)
                .setValue(FACING, context.getHorizontalDirection().getClockWise().getClockWise());
    }

    @Override
    public BlockState updateShape(BlockState currentState, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos)
    {
        if (currentState.getValue(WATERLOGGED))
        {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return super.updateShape(currentState, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    public FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(5, 0, 5, 11, 14, 11),
            Block.box(6, 10, 11, 10, 12, 12),
            Block.box(5, 4, 3, 11, 11, 5)
    );

    private static final VoxelShape SHAPE_SOUTH = SHAPE;
    private static final VoxelShape SHAPE_EAST = UtilVoxelShape.rotateShapeFromBottom(SHAPE_SOUTH);
    private static final VoxelShape SHAPE_NORTH = UtilVoxelShape.rotateShapeFromBottom(SHAPE_EAST);
    private static final VoxelShape SHAPE_WEST = UtilVoxelShape.rotateShapeFromBottom(SHAPE_NORTH);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context)
    {
        // return Blocks.ANVIL.defaultBlockState().getShape(world, pos, context);
        switch (state.getValue(FACING))
        {
            case SOUTH: return SHAPE_SOUTH;
            case NORTH: return SHAPE_NORTH;
            case WEST: return SHAPE_WEST;
            case EAST: return SHAPE_EAST;
            default: return SHAPE;
        }
    }
}
