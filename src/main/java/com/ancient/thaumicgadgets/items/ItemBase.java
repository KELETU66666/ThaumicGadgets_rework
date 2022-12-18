 package com.ancient.thaumicgadgets.items;
 
 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.item.Item;
 
 
 
 public class ItemBase
   extends Item
   implements IHasModel
 {
   public ItemBase(String name) {
/* 15 */     setUnlocalizedName(name);
/* 16 */     setRegistryName(name);
/* 17 */     setCreativeTab(Main.GADGETSTAB);
     
/* 19 */     ModItems.ITEMS.add(this);
   }
 
   
   public void registerModels() {
     Main.proxy.registerItemRenderer(this, 0, "inventory");
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\ItemBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */