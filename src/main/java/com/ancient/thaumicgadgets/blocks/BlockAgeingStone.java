package com.ancient.thaumicgadgets.blocks;

import com.ancient.thaumicgadgets.init.ModBlocks;
import com.ancient.thaumicgadgets.objects.machines.ageingstone.TileEntityAgeingStone;
import java.util.Random;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class BlockAgeingStone extends BlockBase implements ITileEntityProvider {
  public BlockAgeingStone(String name) {
      super(name, Material.ROCK);

      setSoundType(SoundType.STONE);
      setHardness(4.0F);
      setResistance(30.0F);
      setLightOpacity(0);
      setHarvestLevel("pickaxe", 0);
  }

  public TileEntity createNewTileEntity(World worldIn, int meta) {
      return new TileEntityAgeingStone();
  }

  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
      return Item.getItemFromBlock(ModBlocks.AGEING_STONE);
  }

  public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
      return new ItemStack(ModBlocks.AGEING_STONE);
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