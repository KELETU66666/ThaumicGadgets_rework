package com.ancient.thaumicgadgets.blocks;

import com.ancient.thaumicgadgets.init.ModBlocks;
import com.ancient.thaumicgadgets.objects.machines.blastfurnace.InfernalBlastfurnaceRecipe;
import com.ancient.thaumicgadgets.objects.machines.blastfurnace.TileEntityBlastFurnace;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.common.blocks.IBlockFacingHorizontal;

import java.util.Random;


public class BlockBlastFurnace extends BlockBase implements ITileEntityProvider ,IBlockFacingHorizontal{
    public static boolean ignoreDestroy = false;
    public static final PropertyDirection FACING = BlockHorizontal.FACING;


    public BlockBlastFurnace(String name) {
        super(name, Material.ROCK);

        setSoundType(SoundType.STONE);
        setHardness(4.0F);
        setResistance(30.0F);
        setLightOpacity(1);
        setHarvestLevel("pickaxe", 3);
        setLightLevel(1.0F);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityBlastFurnace();
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.FURNACE);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(ModBlocks.FURNACE);
    }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        destroyFurnace(worldIn, pos, state, pos);
        super.breakBlock(worldIn, pos, state);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
    }

    public void onEntityCollision(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        if (!world.isRemote && world.getTileEntity(pos) instanceof TileEntityBlastFurnace)
            if (entity instanceof EntityItem) {
                ItemStack input = ((EntityItem) entity).getItem();
                if (InfernalBlastfurnaceRecipe.getRecipeForInput(input) == null) {
                    world.addBlockEvent(pos, this, 5, 0);
                    entity.setDead();
                    return;
                }

                BlockPos mPos = world.getTileEntity(pos).getPos();
                TileEntityBlastFurnace master = (TileEntityBlastFurnace) world.getTileEntity(mPos);
                master.addStackToInputs(input);
                entity.setDead();
            } else if (entity instanceof EntityLivingBase && !entity.isImmuneToFire()) {
                entity.attackEntityFrom(DamageSource.LAVA, 3.0F);
                entity.setFire(10);
            }
    }

    public static void destroyFurnace(World world, BlockPos pos, IBlockState state, BlockPos startPos) {
        if (ignoreDestroy || world.isRemote) {
            return;
        }
        ignoreDestroy = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    BlockPos blockPos = pos.add(i, j, k);
                    if (blockPos != startPos) {
                        IBlockState bs = world.getBlockState(blockPos);
                        if (bs.getBlock() == ModBlocks.OBSIDIAN_PH) {
                            world.setBlockState(blockPos, Blocks.OBSIDIAN.getDefaultState());
                        } else if (bs.getBlock() == ModBlocks.SOUL_SAND_PH) {
                            world.setBlockState(blockPos, Blocks.SOUL_SAND.getDefaultState());
                        } else if (bs.getBlock() == ModBlocks.NETHER_BRICKS_PH)
                        {
                            world.setBlockState(blockPos, Blocks.NETHER_BRICK.getDefaultState());
                        } else if (bs.getBlock() == ModBlocks.AIR_PH) {
                            world.setBlockState(blockPos, Blocks.LAVA.getDefaultState());
                        }
                    }
                }
            }
        }
        world.setBlockState(pos, Blocks.SOUL_SAND.getDefaultState());
        ignoreDestroy = false;
    }
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        IBlockState bs = getDefaultState();
        bs = bs.withProperty(IBlockFacingHorizontal.FACING, placer.getHorizontalFacing().getOpposite());
        return bs;
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
    {
      face = EnumFacing.NORTH;
    }
        return getDefaultState().withProperty((IProperty)FACING, (Comparable)face);
  }

  public int getMetaFromState(IBlockState state) {
    return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
  }



  protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
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
}