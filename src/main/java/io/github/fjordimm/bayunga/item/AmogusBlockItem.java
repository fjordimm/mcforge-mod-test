package io.github.fjordimm.bayunga.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

public class AmogusBlockItem extends BlockItem
{
    public static final String REGISTRY_NAME = "amogus";

    public AmogusBlockItem(final Block block)
    {
        super(block, makeItemProperties());
    }

    private static Properties makeItemProperties()
    {
        Properties ret = new Properties();

        ret.tab(CreativeModeTab.TAB_TOOLS);

        return ret;
    }
}
