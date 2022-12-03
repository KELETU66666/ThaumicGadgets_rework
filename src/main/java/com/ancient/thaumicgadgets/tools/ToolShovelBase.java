 package com.ancient.thaumicgadgets.tools;
 
 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemSpade;
 
 
 public class ToolShovelBase
   extends ItemSpade
   implements IHasModel
 {
   public ToolShovelBase(String name, Item.ToolMaterial material) {
/* 15 */     super(material);
     
/* 17 */     setUnlocalizedName(name);
/* 18 */     setRegistryName(name);
/* 19 */     setCreativeTab(Main.GADGETSTAB);
     
/* 21 */     ModItems.ITEMS.add(this);
   }
 
 
 
   
   public void registerModels() {
/* 28 */     Main.proxy.registerItemRenderer((Item)this, 0, "inventory");
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\ToolShovelBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */