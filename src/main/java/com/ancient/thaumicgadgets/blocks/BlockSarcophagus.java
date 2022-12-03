 package com.ancient.thaumicgadgets.blocks;
 
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 
 
 public class BlockSarcophagus
   extends BlockBase
 {
   public BlockSarcophagus(String name) {
/* 11 */     super(name, Material.ROCK);
     
/* 13 */     setSoundType(SoundType.STONE);
/* 14 */     setHardness(5.0F);
/* 15 */     setResistance(6000.0F);
/* 16 */     setHarvestLevel("pickaxe", 3);
/* 17 */     setLightOpacity(0);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockSarcophagus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */