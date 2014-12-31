package bart.randomutils.blocks;

import bart.randomutils.RandomUtilsMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Bart on 29-12-2014.
 */
public class BlockDice extends Block
{

    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 5);


    public BlockDice()
    {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, 0));
        this.setUnlocalizedName("dice");
        this.setCreativeTab(RandomUtilsMain.getCreativeTab());
        this.setStepSound(Block.soundTypeStone);
        this.setHardness(1f);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(STAGE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((Integer) state.getValue(STAGE)).intValue();
    }


    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(6);
        System.out.println(randomNumber  + 1);
        IBlockState diceState = getStateFromMeta(randomNumber);
        world.setBlockState(pos, diceState, 1);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        super.onBlockActivated(world, pos, state, player, side, hitX, hitY, hitZ);
        if (!world.isRemote) {
            Random random = new Random();
            int randomNumber = random.nextInt(6);
            System.out.println(randomNumber + 1);
            IBlockState diceState = getStateFromMeta(randomNumber);
            world.setBlockState(pos, diceState, 1);
            return true;
        }
        return false;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {

        return Item.getItemFromBlock(ModBlocks.blockDice);
    }


    @Override
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    @Override
    public int getComparatorInputOverride(World world, BlockPos pos)
    {
        return getMetaFromState(world.getBlockState(pos)) + 1;
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return true;
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] {STAGE});
    }


//first you need to set your properties like: https://github.com/FlowstoneTeam/Oods-Mod/blob/master/src/main/java/oodmod/block/trees/SaplingClass.java#L30
//then you need to define the blockstate: https://github.com/FlowstoneTeam/Oods-Mod/blob/master/src/main/java/oodmod/block/trees/SaplingClass.java#L117-L120
//after that you need to set the default: https://github.com/FlowstoneTeam/Oods-Mod/blob/master/src/main/java/oodmod/block/trees/SaplingClass.java#L34
//finally, you need to create the mapping to meta with these two functions: https://github.com/FlowstoneTeam/Oods-Mod/blob/master/src/main/java/oodmod/block/trees/SaplingClass.java#L107-L115


}
