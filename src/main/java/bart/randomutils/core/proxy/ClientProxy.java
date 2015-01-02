package bart.randomutils.core.proxy;

import bart.randomutils.blocks.ModBlocks;
import bart.randomutils.items.ModItems;
import com.sun.java.swing.plaf.motif.MotifTextUI;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.FMLClientHandler;

/**
 * Created by Bart on 29-12-2014.
 */
public class ClientProxy extends CommonProxy {


    @Override
    public void registerModels()
    {
        registerBlockModels();
        registerItemModels();
    }

    private void registerBlockModels()
    {
        RenderItem renderItem = FMLClientHandler.instance().getClient().getRenderItem();
        ItemModelMesher itemModelMesher = renderItem.getItemModelMesher();


        ModelBakery.addVariantName(Item.getItemFromBlock(ModBlocks.blockDice), "randomutils:DiceBlock");

        itemModelMesher.register(Item.getItemFromBlock(ModBlocks.blockDice), 0, new ModelResourceLocation("randomutils:DiceBlock", "inventory"));
    }

    private void registerItemModels()
    {
        RenderItem renderItem = FMLClientHandler.instance().getClient().getRenderItem();
        ItemModelMesher itemModelMesher = renderItem.getItemModelMesher();

        itemModelMesher.register(ModItems.testItem, 0, new ModelResourceLocation("randomutils:TestItem", "inventory"));

    }
}
