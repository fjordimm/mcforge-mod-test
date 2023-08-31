package io.github.fjordimm.bayunga.block;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class ManBlock extends Block
{
    public static final String REGISTRY_NAME = "man_block";

    public ManBlock()
    {
        super(makeBlockProperties());
    }

    private static BlockBehaviour.Properties makeBlockProperties()
    {
        BlockBehaviour.Properties ret = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT);

        ret.sound(SoundType.MUD);
        ret.strength(0.5F);

        return ret;
    }
}