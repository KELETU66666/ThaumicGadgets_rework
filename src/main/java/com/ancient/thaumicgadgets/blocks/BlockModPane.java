 package com.ancient.thaumicgadgets.blocks;

 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModBlocks;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.block.Block;
 import net.minecraft.block.BlockPane;
 import net.minecraft.block.material.Material;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemBlock;
 import net.minecraft.util.ResourceLocation;









 public class BlockModPane
   extends BlockPane
   implements IHasModel
 {
   public BlockModPane(String name) {
/* 27 */     super(Material.GLASS, false);

/* 29 */     setRegistryName(new ResourceLocation("tg", name));
/* 30 */     setUnlocalizedName(name);
/* 31 */     setCreativeTab(Main.GADGETSTAB);

/* 33 */     ModBlocks.BLOCKS.add(this);
/* 34 */     ModItems.ITEMS.add((new ItemBlock((Block)this)).setRegistryName(getRegistryName()));
   }



   public void registerModels() {
/* 40 */     Main.proxy.registerItemRenderer(Item.getItemFromBlock((Block)this), 0, "inventory");
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockModPane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */