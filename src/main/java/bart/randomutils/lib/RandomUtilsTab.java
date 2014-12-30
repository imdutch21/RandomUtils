package bart.randomutils.lib;

import bart.randomutils.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Bart on 29-12-2014.
 */
public class RandomUtilsTab extends CreativeTabs {
    public RandomUtilsTab(int id, String modid) {
        super(id, modid);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ModBlocks.blockDice);
    }
}
