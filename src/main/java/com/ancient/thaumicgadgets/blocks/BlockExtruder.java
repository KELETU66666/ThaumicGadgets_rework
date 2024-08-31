package com.ancient.thaumicgadgets.blocks;

import com.ancient.thaumicgadgets.init.ModBlocks;
import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruder;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;


public class BlockExtruder extends BlockBase implements ITileEntityProvider, IHasModel {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;


    public BlockExtruder(String name) {
        super(name, Material.WOOD);

        setSoundType(SoundType.WOOD);
        setHardness(2.5F);
        setResistance(30.0F);
        setLightOpacity(1);
        setLightLevel(0.4F);
        setHarvestLevel("axe", 0);

        setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityExtruder();
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.EXTRUDER);
    }


    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(ModBlocks.EXTRUDER);
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {

            IBlockState north = worldIn.getBlockState(pos.north());
            IBlockState south = worldIn.getBlockState(pos.south());
            IBlockState east = worldIn.getBlockState(pos.east());
            IBlockState west = worldIn.getBlockState(pos.west());
            EnumFacing face = state.getValue(FACING);

            if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {

                face = EnumFacing.SOUTH;
            } else if (face == EnumFacing.SOUTH && !north.isFullBlock() && south.isFullBlock()) {

                face = EnumFacing.NORTH;
            } else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {

                face = EnumFacing.EAST;
            } else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {

                face = EnumFacing.WEST;
            }
            worldIn.setBlockState(pos, state.withProperty(FACING, face), 2);
        }
    }

    public static void setState(World worldIn, BlockPos pos) {
        IBlockState state = worldIn.getBlockState(pos);
        TileEntity te = worldIn.getTileEntity(pos);


        worldIn.setBlockState(pos, ModBlocks.EXTRUDER.getDefaultState().withProperty(FACING, state.getValue(FACING)));

        if (te != null) {

            te.validate();
            worldIn.setTileEntity(pos, te);
        }
    }

    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }


    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }


    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntityExtruder te = (TileEntityExtruder) worldIn.getTileEntity(pos);
        super.breakBlock(worldIn, pos, state);
    }


    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }


    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }


    public IBlockState getStateFromMeta(int meta) {
        EnumFacing face = EnumFacing.byIndex(meta);
        if (face.getAxis() == EnumFacing.Axis.Y) {
            face = EnumFacing.NORTH;
        }
        return getDefaultState().withProperty(FACING, face);
    }


    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }


    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }


    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
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
}