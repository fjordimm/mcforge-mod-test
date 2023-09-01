package io.github.fjordimm.bayunga.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class AmogusBlock extends Block
{
    public static final String REGISTRY_NAME = "amogus";

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public AmogusBlock()
    {
        super(makeBlockProperties());
        this.registerDefaultState(makeDefaultBlockState());
    }

    private static BlockBehaviour.Properties makeBlockProperties()
    {
        return BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_RED)
                .noOcclusion()
                .sound(SoundType.FUNGUS)
                .strength(0.1F);
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(FACING);
    }

    private BlockState makeDefaultBlockState()
    {
        return this.stateDefinition.any()
                .setValue(FACING, Direction.SOUTH);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getClockWise().getClockWise());
    }
}
