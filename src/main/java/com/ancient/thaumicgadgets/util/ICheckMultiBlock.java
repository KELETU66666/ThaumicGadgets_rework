/*     */ package com.ancient.thaumicgadgets.util;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.Main;
/*     */ import com.ancient.thaumicgadgets.init.ModMultiBlocks;
/*     */ import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockHorizontal;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ICheckMultiBlock
/*     */ {
/*     */   static boolean checkMultiBlockStatic(EntityPlayer player, BlockPos clickedPos, EnumHandler.MultiBlocks predRecipe) {
/*  22 */     if (!player.world.isRemote) {
/*     */       
/*  24 */       System.out.println("Start check");
/*  25 */       World world = player.world;
/*  26 */       ModMultiBlocks.MBHeading heading = (ModMultiBlocks.MBHeading)Main.MMB.getMultiBlockRecipeList().get(predRecipe.getName());
/*  27 */       Block block = world.getBlockState(clickedPos).getBlock();
/*  28 */       Item sal = player.getHeldItemMainhand().getItem();
/*     */ 
/*     */ 
/*     */       
/*  32 */       int x = clickedPos.getX();
/*  33 */       int y = clickedPos.getY();
/*  34 */       int z = clickedPos.getZ();
/*     */       
/*  36 */       int yLenght = (heading.recipe[1]).length;
/*  37 */       int xLenght = heading.recipe.length;
/*     */       
/*  39 */       IBlockState b = null;
/*  40 */       boolean canMorph = true;
/*     */       
/*  42 */       int jx = 0, jy = 0, jz = 0;
/*  43 */       for (int yy = y - (int)Math.floor(yLenght / 2.0D); yy < y + (int)Math.ceil(yLenght / 2.0D); yy++) {
/*     */         
/*  45 */         for (int xx = x - (int)Math.floor(xLenght / 2.0D); xx < x + (int)Math.ceil(xLenght / 2.0D); xx++) {
/*     */           
/*  47 */           for (int zz = z - (int)Math.floor(xLenght / 2.0D); zz < z + (int)Math.ceil(xLenght / 2.0D); zz++) {
/*     */             
/*  49 */             if (!(heading.recipe[jx][jy][jz]).ignoreAtCheck) {
/*     */               
/*  51 */               b = world.getBlockState(new BlockPos(xx, yy, zz)).getBlock().getDefaultState();
/*  52 */               if (!b.equals((heading.recipe[jx][jy][jz]).before)) {
/*     */                 
/*  54 */                 System.out.println("WrongBlock in pos: X: " + xx + " Y: " + yy + " Z: " + zz + " Must be: " + (heading.recipe[jx][jy][jz]).before.getBlock().getLocalizedName() + " but we found: " + b.getBlock().getLocalizedName());
/*  55 */                 canMorph = false;
/*     */               } 
/*     */             } 
/*  58 */             if (++jz > xLenght - 1)
/*     */             {
/*  60 */               jz = 0;
/*     */             }
/*     */           } 
/*  63 */           if (++jx > xLenght - 1)
/*     */           {
/*  65 */             jx = 0;
/*     */           }
/*     */         } 
/*  68 */         if (++jy > yLenght - 1)
/*     */         {
/*  70 */           jy = 0;
/*     */         }
/*     */       } 
/*     */       
/*  74 */       if (canMorph)
/*     */       {
/*  76 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean checkMultiBlockStatic(World world, ModMultiBlocks.MBComponent[][][] parts, BlockPos pos) {
/*  85 */     if (!world.isRemote) {
/*     */       
/*  87 */       int x = pos.getX();
/*  88 */       int y = pos.getY();
/*  89 */       int z = pos.getZ();
/*     */       
/*  91 */       int jx = 0, jy = 0, jz = 0;
/*     */       
/*  93 */       boolean canMorph = true;
/*     */       
/*  95 */       int yLenght = (parts[1]).length;
/*  96 */       int xLenght = parts.length;
/*     */       
/*  98 */       IBlockState checkStack = null;
/*  99 */       for (int yy = y - (int)Math.floor(yLenght / 2.0D); yy < y + (int)Math.ceil(yLenght / 2.0D); yy++) {
/*     */         
/* 101 */         for (int xx = x - (int)Math.floor(xLenght / 2.0D); xx < x + (int)Math.ceil(xLenght / 2.0D); xx++) {
/*     */           
/* 103 */           for (int zz = z - (int)Math.floor(xLenght / 2.0D); zz < z + (int)Math.ceil(xLenght / 2.0D); zz++) {
/*     */             
/* 105 */             if (!(parts[jx][jy][jz]).ignoreAtCheck) {
/*     */               
/* 107 */               checkStack = world.getBlockState(new BlockPos(xx, yy, zz));
/* 108 */               if (!(parts[jx][jy][jz]).after.getBlock().equals(checkStack.getBlock()))
/*     */               {
/* 110 */                 canMorph = false;
/*     */               }
/*     */             } 
/* 113 */             if (++jz > xLenght - 1)
/*     */             {
/* 115 */               jz = 0;
/*     */             }
/*     */           } 
/* 118 */           if (++jx > xLenght - 1)
/*     */           {
/* 120 */             jx = 0;
/*     */           }
/*     */         } 
/* 123 */         if (++jy > yLenght - 1)
/*     */         {
/* 125 */           jy = 0;
/*     */         }
/*     */       } 
/*     */       
/* 129 */       if (canMorph)
/*     */       {
/* 131 */         return true;
/*     */       }
/*     */     } 
/* 134 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static void morphMultiBlockStatic(EntityPlayer player, BlockPos clickedPos, ModMultiBlocks.MBComponent[][][] recipe) {
/* 139 */     if (!player.world.isRemote) {
/*     */       
/* 141 */       EnumFacing pface = player.getHorizontalFacing();
/*     */       
/* 143 */       int x = clickedPos.getX();
/* 144 */       int y = clickedPos.getY();
/* 145 */       int z = clickedPos.getZ();
/*     */       
/* 147 */       int jx = 0, jy = 0, jz = 0;
/*     */       
/* 149 */       int yLenght = (recipe[1]).length;
/* 150 */       int xLenght = recipe.length;
/*     */       
/* 152 */       for (int xx = x - (int)Math.floor(xLenght / 2.0D); xx < x + (int)Math.ceil(xLenght / 2.0D); xx++) {
/*     */         
/* 154 */         for (int yy = y - (int)Math.floor(yLenght / 2.0D); yy < y + (int)Math.ceil(yLenght / 2.0D); yy++) {
/*     */           
/* 156 */           for (int zz = z - (int)Math.floor(xLenght / 2.0D); zz < z + (int)Math.ceil(xLenght / 2.0D); zz++) {
/*     */             
/* 158 */             if (!(recipe[jx][jy][jz]).ignoreAtCheck)
/*     */             {
/* 160 */               if ((recipe[jx][jy][jz]).applyFacing) {
/*     */                 
/* 162 */                 player.world.setBlockState(new BlockPos(xx, yy, zz), (recipe[jx][jy][jz]).after.withProperty((IProperty)BlockHorizontal.FACING, (Comparable)pface.getOpposite()));
/*     */               }
/*     */               else {
/*     */                 
/* 166 */                 player.world.setBlockState(new BlockPos(xx, yy, zz), (recipe[jx][jy][jz]).after);
/*     */               } 
/*     */             }
/* 169 */             if (++jz > xLenght - 1)
/*     */             {
/* 171 */               jz = 0;
/*     */             }
/*     */           } 
/* 174 */           if (++jy > yLenght - 1)
/*     */           {
/* 176 */             jy = 0;
/*     */           }
/*     */         } 
/* 179 */         if (++jx > xLenght - 1)
/*     */         {
/* 181 */           jz = 0;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void demorphMultiBlockStatic(World world, ModMultiBlocks.MBComponent[][][] recipe, BlockPos pos) {
/* 189 */     if (!world.isRemote) {
/*     */       
/* 191 */       int x = pos.getX();
/* 192 */       int y = pos.getY();
/* 193 */       int z = pos.getZ();
/*     */       
/* 195 */       int jx = 0, jy = 0, jz = 0;
/*     */       
/* 197 */       int yLenght = (recipe[1]).length;
/* 198 */       int xLenght = recipe.length;
/*     */ 
/*     */       
/* 201 */       for (int xx = x - (int)Math.floor(xLenght / 2.0D); xx < x + (int)Math.ceil(xLenght / 2.0D); xx++) {
/*     */         
/* 203 */         for (int yy = y - (int)Math.floor(yLenght / 2.0D); yy < y + (int)Math.ceil(yLenght / 2.0D); yy++) {
/*     */           
/* 205 */           for (int zz = z - (int)Math.floor(xLenght / 2.0D); zz < z + (int)Math.ceil(xLenght / 2.0D); zz++) {
/*     */             
/* 207 */             if (!(recipe[jx][jy][jz]).ignoreAtCheck) {
/*     */               
/* 209 */               IBlockState state = world.getBlockState(new BlockPos(xx, yy, zz));
/* 210 */               if (state.getBlock().equals((recipe[jx][jy][jz]).after.getBlock()))
/*     */               {
/* 212 */                 world.setBlockState(new BlockPos(xx, yy, zz), (recipe[jx][jy][jz]).before);
/*     */               }
/*     */             } 
/* 215 */             if (++jz > xLenght - 1)
/*     */             {
/* 217 */               jz = 0;
/*     */             }
/*     */           } 
/* 220 */           if (++jy > yLenght - 1)
/*     */           {
/* 222 */             jy = 0;
/*     */           }
/*     */         } 
/* 225 */         if (++jx > xLenght - 1)
/*     */         {
/* 227 */           jz = 0;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\ICheckMultiBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */