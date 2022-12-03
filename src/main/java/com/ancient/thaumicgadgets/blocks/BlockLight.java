 package com.ancient.thaumicgadgets.blocks;
 
 import net.minecraft.block.material.Material;
 
 
 
 
 
 
 
 
 
 
 
 public class BlockLight
   extends BlockBase
 {
   public BlockLight(String name, Material material, float lightLvl) {
/* 19 */     super(name, material);
     
/* 21 */     setLightLevel(lightLvl);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockLight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */