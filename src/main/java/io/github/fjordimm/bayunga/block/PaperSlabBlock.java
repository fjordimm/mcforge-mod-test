package io.github.fjordimm.bayunga.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class PaperSlabBlock extends SlabBlock
{
    public static final String REGISTRY_NAME = "paper_slab";

    public PaperSlabBlock()
    {
        super(makeBlockProperties());
    }

    private static BlockBehaviour.Properties makeBlockProperties()
    {
        return BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL)
                .sound(SoundType.WOOL)
                .strength(0.1F);
    }
}
