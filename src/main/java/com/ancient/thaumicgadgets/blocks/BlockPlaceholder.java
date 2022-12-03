 package com.ancient.thaumicgadgets.blocks;
 
 import java.util.Random;

 import com.ancient.thaumicgadgets.init.ModBlocks;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.init.Blocks;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.BlockRenderLayer;
 import net.minecraft.util.EnumBlockRenderType;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.common.Mod;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import thaumcraft.common.blocks.devices.BlockInfernalFurnace;


 public class BlockPlaceholder
   extends BlockBase
 {
   private Item drop;
   
   public BlockPlaceholder(String name, Material material, Item drop, int count, SoundType sound, float hard, float res, int lightOp, String inst, int lvl) {
/* 24 */     super(name, material);
     
/* 26 */     setCreativeTab(null);
/* 27 */     setSoundType(sound);
/* 28 */     setHardness(hard);
/* 29 */     setResistance(res);
/* 30 */     setLightOpacity(lightOp);
/* 31 */     setHarvestLevel(inst, lvl);
/* 32 */     this.drop = drop;
   }

     @Override
     public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
         if ((state.getBlock() == ModBlocks.NETHER_BRICKS_PH || state.getBlock() == ModBlocks.SOUL_SAND_PH || state.getBlock() == ModBlocks.OBSIDIAN_PH) && !BlockBlastFurnace.ignoreDestroy && !worldIn.isRemote) {
             this.destroyFurnace(worldIn, pos);
         }
         super.breakBlock(worldIn, pos, state);
     }

     private void destroyFurnace(World worldIn, BlockPos pos) {
         for (int i = -1; i <= 1; i++) {
             for (int j = -1; j <= 1; j++) {
                 for (int k = -1; k <= 1; k++) {
                     BlockPos targetPos = pos.add(i, j, k);
                     IBlockState targetState = worldIn.getBlockState(targetPos);
                     if (targetState.getBlock() == ModBlocks.FURNACE) {
                         BlockBlastFurnace.destroyFurnace(worldIn, targetPos, targetState, pos);
                         return;
                     }
                 }
             }
         }
     }

   
   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 38 */     return EnumBlockRenderType.INVISIBLE;
   }
 
   
   @SideOnly(Side.CLIENT)
   public BlockRenderLayer getRenderLayer() {
/* 44 */     return BlockRenderLayer.SOLID;
   }
 
 
   
   public boolean isOpaqueCube(IBlockState state) {
/* 50 */     return false;
   }
 
 
   
   public boolean isFullCube(IBlockState state) {
/* 56 */     return false;
   }
 
 
   
   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 62 */     return this.drop;
   }
 
 
   
   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/* 68 */     return new ItemStack(this.drop);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockPlaceholder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */