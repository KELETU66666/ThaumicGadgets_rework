 package com.ancient.thaumicgadgets.tools;
 
 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemShears;
 
 
 
 public class ToolShearsBase
   extends ItemShears
   implements IHasModel
 {
   public ToolShearsBase(String name, Item.ToolMaterial material) {
/* 16 */     setUnlocalizedName(name);
/* 17 */     setRegistryName(name);
/* 18 */     setCreativeTab(Main.GADGETSTAB);
/* 19 */     setMaxDamage(material.getMaxUses());
     
/* 21 */     ModItems.ITEMS.add(this);
   }
 
 
   
   public void registerModels() {
/* 27 */     Main.proxy.registerItemRenderer((Item)this, 0, "inventory");
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\ToolShearsBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */