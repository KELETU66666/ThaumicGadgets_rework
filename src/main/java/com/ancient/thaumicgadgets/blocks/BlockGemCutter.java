package com.ancient.thaumicgadgets.blocks;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModBlocks;
import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
import java.util.Random;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockGemCutter extends BlockBase implements ITileEntityProvider
{ public static final PropertyDirection FACING = BlockHorizontal.FACING;public BlockGemCutter(String name) {
    super(name, Material.WOOD);

    setSoundType(SoundType.WOOD);
    setHardness(2.5F);
    setResistance(30.0F);
    setLightOpacity(1);
    setHarvestLevel("axe", 0);

    setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH));
}


public TileEntity createNewTileEntity(World worldIn, int meta) {
    return new TileEntityGemCutter();
}



public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    return Item.getItemFromBlock(ModBlocks.GEMCUTTER);
}



public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
    return new ItemStack(ModBlocks.GEMCUTTER);
}



public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    if (!worldIn.isRemote)
    {playerIn.openGui(Main.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
    }

    return true;
}



public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
    TileEntityGemCutter tileentity = (TileEntityGemCutter)worldIn.getTileEntity(pos);
    InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);

    super.breakBlock(worldIn, pos, state);
}



public EnumBlockRenderType getRenderType(IBlockState state) {
    return EnumBlockRenderType.MODEL;
}


@SideOnly(Side.CLIENT)
public BlockRenderLayer getRenderLayer() {
    return BlockRenderLayer.SOLID;
}



public boolean isOpaqueCube(IBlockState state) {
    return false;
}



public boolean isFullCube(IBlockState state) {
    return false;
}



public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
    if (!worldIn.isRemote) {IBlockState north = worldIn.getBlockState(pos.north());IBlockState south = worldIn.getBlockState(pos.south());IBlockState east = worldIn.getBlockState(pos.east());IBlockState west = worldIn.getBlockState(pos.west());EnumFacing face = (EnumFacing)state.getValue((IProperty)FACING);if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {

        face = EnumFacing.SOUTH;
    }
    else if (face == EnumFacing.SOUTH && !north.isFullBlock() && south.isFullBlock()) {

        face = EnumFacing.NORTH;
    }
    else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {

        face = EnumFacing.EAST;
    }
    else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {

        face = EnumFacing.WEST;
    }
    worldIn.setBlockState(pos, state.withProperty((IProperty)FACING, (Comparable)face), 2);
    }
}


public static void setState(World worldIn, BlockPos pos) {
    IBlockState state = worldIn.getBlockState(pos);
    TileEntity te = worldIn.getTileEntity(pos);

    worldIn.setBlockState(pos, ModBlocks.GEMCUTTER.getDefaultState().withProperty((IProperty)FACING, state.getValue((IProperty)FACING)));

    if (te != null) {te.validate();worldIn.setTileEntity(pos, te);
    }
}



public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
    return getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite());
}



public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
    worldIn.setBlockState(pos, getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite()), 2);
}



public IBlockState withRotation(IBlockState state, Rotation rot) {
    return state.withProperty((IProperty)FACING, (Comparable)rot.rotate((EnumFacing)state.getValue((IProperty)FACING)));
}



public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
    return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue((IProperty)FACING)));
}



public IBlockState getStateFromMeta(int meta) {
    EnumFacing face = EnumFacing.byIndex(meta);
    if (face.getAxis() == EnumFacing.Axis.Y)
    {face = EnumFacing.NORTH;
    }
    return getDefaultState().withProperty((IProperty)FACING, (Comparable)face);
}



public int getMetaFromState(IBlockState state) {
    return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
}



protected BlockStateContainer createBlockState() {
    return new BlockStateContainer(this, FACING);
}
}