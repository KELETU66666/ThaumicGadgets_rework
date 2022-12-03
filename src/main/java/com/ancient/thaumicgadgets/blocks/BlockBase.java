 package com.ancient.thaumicgadgets.blocks;
 
 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModBlocks;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.util.math.AxisAlignedBB;
 
 
 public class BlockBase
   extends Block
   implements IHasModel
 {
/* 18 */   protected static final AxisAlignedBB EMPTY_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
 
   
   public BlockBase(String name, Material material) {
/* 22 */     super(material);
     
/* 24 */     setUnlocalizedName(name);
/* 25 */     setRegistryName(name);
/* 26 */     setCreativeTab(Main.GADGETSTAB);
     
/* 28 */     ModBlocks.BLOCKS.add(this);
/* 29 */     ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(getRegistryName()));
   }
 
 
   
   public void registerModels() {
/* 35 */     Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */