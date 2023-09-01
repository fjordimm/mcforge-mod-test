package io.github.fjordimm.bayunga.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;

public class IphoneItem extends Item
{
    public static final String REGISTRY_NAME = "iphone";

    public IphoneItem()
    {
        super(makeItemProperties());
    }

    private static Item.Properties makeItemProperties()
    {
        return new Item.Properties()
                .tab(CreativeModeTab.TAB_TOOLS)
                .stacksTo(3);
    }
}
