 package com.ancient.thaumicgadgets.tools;

 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemPickaxe;
 
 
 
 public class ToolPickaxeBase
   extends ItemPickaxe
   implements IHasModel
 {
   public ToolPickaxeBase(String name, Item.ToolMaterial material) {
/* 16 */     super(material);
     
/* 18 */     setTranslationKey(name);
/* 19 */     setRegistryName(name);
/* 20 */     setCreativeTab(Main.GADGETSTAB);
     
/* 22 */     ModItems.ITEMS.add(this);
   }
 
 
 
   
   public void registerModels() {
/* 29 */     Main.proxy.registerItemRenderer((Item)this, 0, "inventory");
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\ToolPickaxeBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */