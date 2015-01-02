package bart.randomutils.items;

import bart.randomutils.RandomUtilsMain;
import bart.randomutils.lib.References;
import net.minecraft.item.Item;

/**
 * Created by Bart on 2-1-2015.
 */
public class TestItem extends Item {
    public TestItem(){
        this.setUnlocalizedName(References.MODID + ".testitem");
        this.setCreativeTab(RandomUtilsMain.getCreativeTab());
    }

}
