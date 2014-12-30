package bart.randomutils;

import bart.randomutils.blocks.ModBlocks;
import bart.randomutils.core.proxy.CommonProxy;
import bart.randomutils.lib.RandomUtilsTab;
import bart.randomutils.lib.References;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Bart on 29-12-2014.
 */
@Mod(modid = References.MODID, name = References.MODNAME, version = References.VERSION)
public class RandomUtilsMain {
    @Instance
    public static RandomUtilsMain instance;

    @SidedProxy(clientSide = References.CLIENTPROXYLOCATION, serverSide = References.COMMONPROXYLOCATION)
    public static CommonProxy proxy;

    private static CreativeTabs randomUtilsTab = new RandomUtilsTab(CreativeTabs.getNextID(), References.MODID);
    public static CreativeTabs getCreativeTab() {
        return randomUtilsTab;
    }
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();

    }
    @EventHandler
    public void init(FMLInitializationEvent event) {
        //registering model
        proxy.registerModels();
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
