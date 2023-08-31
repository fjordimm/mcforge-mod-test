package io.github.fjordimm.bayunga.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class PaperSlabBlock extends SlabBlock
{
    public static final String REGISTRY_NAME = "paper_slab";

    public PaperSlabBlock()
    {
        super(makeBlockProperties());
    }

    private static Properties makeBlockProperties()
    {
        Properties ret = Properties.of(Material.WOOL, MaterialColor.WOOL);

        ret.sound(SoundType.WOOL);
        ret.strength(0.1F);

        return ret;
    }
}
