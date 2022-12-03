 package com.ancient.thaumicgadgets.blocks;
 
 import com.ancient.thaumicgadgets.init.ModItems;
 import java.util.Random;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.EnumPushReaction;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.BlockRenderLayer;
 import net.minecraft.util.EnumBlockRenderType;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 
 
 
 
 
 public class BlockFortifiedGlass
   extends BlockBase
 {
   public BlockFortifiedGlass(String name) {
/* 27 */     super(name, Material.GLASS);
     
/* 29 */     setSoundType(SoundType.GLASS);
/* 30 */     setHardness(5.0F);
/* 31 */     setResistance(6000.0F);
/* 32 */     setHarvestLevel("pickaxe", 3);
/* 33 */     setLightOpacity(1);
   }
 
 
   
   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 39 */     return ModItems.FORTIFIED_GLASS_SHARD;
   }
 
 
   
   public int func_149745_a(Random random) {
/* 45 */     return 6;
   }
 
 
   
   public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
/* 51 */     return true;
   }
 
 
 
   
   protected ItemStack func_180643_i(IBlockState state) {
/* 58 */     return new ItemStack(Item.getItemFromBlock(this), 1);
   }
 
 
   
   public EnumPushReaction func_149656_h(IBlockState state) {
/* 64 */     return EnumPushReaction.BLOCK;
   }
 
 
   
   public boolean isOpaqueCube(IBlockState state) {
/* 70 */     return false;
   }
 
 
   
   public boolean isFullCube(IBlockState state) {
/* 76 */     return false;
   }
 
 
   
   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 82 */     return EnumBlockRenderType.MODEL;
   }
 
 
   
   @SideOnly(Side.CLIENT)
   public BlockRenderLayer getRenderLayer() {
/* 89 */     return BlockRenderLayer.CUTOUT;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockFortifiedGlass.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */