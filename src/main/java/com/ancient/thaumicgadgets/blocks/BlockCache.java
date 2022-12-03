 package com.ancient.thaumicgadgets.blocks;

 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;

 public class BlockCache
   extends BlockBase
 {
   public BlockCache(String name) {
/* 10 */     super(name, Material.ROCK);

/* 12 */     setSoundType(SoundType.STONE);
/* 13 */     setHardness(5.0F);
/* 14 */     setResistance(6000.0F);
/* 15 */     setHarvestLevel("pickaxe", 3);
/* 16 */     setLightOpacity(0);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockCache.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */