package io.github.fjordimm.bayunga.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;

public class IphoneItem extends Item
{
    private static final String REGISTRY_NAME = "iphone";

    public IphoneItem()
    {
        super(makeProperties());
    }

    private static Item.Properties makeProperties()
    {
        Item.Properties ret = new Item.Properties();

        ret.stacksTo(3);
        ret.tab(CreativeModeTab.TAB_TOOLS);

        return ret;
    }

    public static void register(final DeferredRegister<Item> itemsRegister)
    {
        itemsRegister.register(REGISTRY_NAME, () -> new IphoneItem());
    }
}
