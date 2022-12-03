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
 
 
 
 public class BlockAgeingStone
   extends BlockBase
   implements ITileEntityProvider
 {
   public BlockAgeingStone(String name) {
/* 27 */     super(name, Material.ROCK);
     
/* 29 */     setSoundType(SoundType.STONE);
/* 30 */     setHardness(4.0F);
/* 31 */     setResistance(30.0F);
/* 32 */     setLightOpacity(0);
/* 33 */     setHarvestLevel("pickaxe", 0);
   }
 
 
 
   
   public TileEntity createNewTileEntity(World worldIn, int meta) {
/* 40 */     return (TileEntity)new TileEntityAgeingStone();
   }
 
 
   
   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 46 */     return Item.getItemFromBlock(ModBlocks.AGEING_STONE);
   }
 
 
   
   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/* 52 */     return new ItemStack(ModBlocks.AGEING_STONE);
   }
 
 
   
   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 58 */     return EnumBlockRenderType.MODEL;
   }
 
   
   @SideOnly(Side.CLIENT)
   public BlockRenderLayer getRenderLayer() {
/* 64 */     return BlockRenderLayer.SOLID;
   }
 
 
   
   public boolean isOpaqueCube(IBlockState state) {
/* 70 */     return false;
   }
 
 
   
   public boolean isFullCube(IBlockState state) {
/* 76 */     return false;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockAgeingStone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */