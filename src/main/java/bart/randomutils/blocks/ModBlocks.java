package bart.randomutils.blocks;


import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Bart on 29-12-2014.
 */
public class ModBlocks {
    public static Block blockDice;
    public static void init()
    {
        blockDice = new BlockDice();
            GameRegistry.registerBlock(blockDice, "DiceBlock");
    }
}
