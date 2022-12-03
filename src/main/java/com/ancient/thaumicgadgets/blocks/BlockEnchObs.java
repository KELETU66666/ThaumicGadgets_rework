 package com.ancient.thaumicgadgets.blocks;
 
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 
 
 
 public class BlockEnchObs
   extends BlockBase
 {
   public BlockEnchObs(String name) {
/* 12 */     super(name, Material.ROCK);
/* 13 */     setBreakable();
/* 14 */     setResistance(2000.0F);
   }
 
   
   public Block setBreakable() {
/* 19 */     setHardness(50.0F);
/* 20 */     return this;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockEnchObs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */