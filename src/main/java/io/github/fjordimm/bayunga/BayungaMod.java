package io.github.fjordimm.bayunga;

import com.mojang.logging.LogUtils;
import io.github.fjordimm.bayunga.item.IphoneItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
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

    private static final DeferredRegister<Item> SCHIT = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> SCHOT = SCHIT.register("iphone", () -> new IphoneItem());

    public BayungaMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        final DeferredRegister<Block> blocksReg = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
        final DeferredRegister<Item> itemsReg = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

        registerAllBlocks(blocksReg);
        registerAllItems(itemsReg);

        blocksReg.register(modEventBus);
        itemsReg.register(modEventBus);

        SCHIT.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private static void registerAllBlocks(final DeferredRegister<Block> reg)
    {}

    private static void registerAllItems(final DeferredRegister<Item> reg)
    {
        // IphoneItem.register(reg);
    }
}
