package io.github.fjordimm.bayunga;

import com.mojang.logging.LogUtils;
import io.github.fjordimm.bayunga.item.IphoneItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(BayungaMod.MODID)
public final class BayungaMod
{
    public static final String MODID = "bayunga";

    private static final Logger LOGGER = LogUtils.getLogger();

    public BayungaMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Blocks.BLOCKS.register(modEventBus);
        Items.ITEMS.register(modEventBus);
    }

    public static class Blocks
    {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    }

    public static class Items
    {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

        public static final RegistryObject<Item> IPHONE_ITEM = ITEMS.register(IphoneItem.REGISTRY_NAME, () -> new IphoneItem());
    }
}
