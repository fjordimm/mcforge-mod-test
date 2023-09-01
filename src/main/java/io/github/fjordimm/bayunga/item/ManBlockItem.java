package io.github.fjordimm.bayunga.item;

import io.github.fjordimm.bayunga.BayungaMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ManBlockItem extends BlockItem
{
    public static final String REGISTRY_NAME = "man_block";

    public ManBlockItem(final Block block)
    {
        super(block, makeItemProperties());
    }

    private static Item.Properties makeItemProperties()
    {
        return new Item.Properties()
                .tab(CreativeModeTab.TAB_TOOLS);
    }
}
