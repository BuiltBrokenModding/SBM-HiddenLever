package com.builtbroken.hiddenlever;

import com.builtbroken.hiddenlever.content.BlockTorchLeverButton;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 08/02/2018.
 */
@Mod(modid = HiddenLever.DOMAIN, name = "[SBM] Hidden Lever", version = HiddenLever.VERSION)
@Mod.EventBusSubscriber
public class HiddenLever
{
    public static final String DOMAIN = "hiddenlever";
    public static final String PREFIX = DOMAIN + ":";

    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String MC_VERSION = "@MC@";
    public static final String VERSION = MC_VERSION + "-" + MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    @Mod.Instance(DOMAIN)
    public static HiddenLever INSTANCE;

    @SidedProxy(clientSide = "com.builtbroken.hiddenlever.ClientProxy", serverSide = "com.builtbroken.hiddenlever.CommonProxy")
    public static CommonProxy proxy;

    public static Block torchLever;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(torchLever = new BlockTorchLeverButton());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(torchLever).setRegistryName(torchLever.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerAllModels(ModelRegistryEvent event) {
        proxy.doLoadModels();
    }
}