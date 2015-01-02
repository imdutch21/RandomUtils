package bart.randomutils.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Bart on 2-1-2015.
 */
public class ModItems {
    public static TestItem testItem;

    public static void init()
    {
        testItem = new TestItem();
        GameRegistry.registerItem(testItem, "TestItem");
    }
}
