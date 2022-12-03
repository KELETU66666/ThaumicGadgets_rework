 package com.ancient.thaumicgadgets.tools;

 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemSword;










 public class ToolSwordBase
   extends ItemSword
   implements IHasModel
 {
   public ToolSwordBase(String name, Item.ToolMaterial material) {
/* 23 */     super(material);

/* 25 */     setUnlocalizedName(name);
/* 26 */     setRegistryName(name);
/* 27 */     setCreativeTab(Main.GADGETSTAB);

/* 29 */     ModItems.ITEMS.add(this);
   }



   public void registerModels() {
/* 35 */     Main.proxy.registerItemRenderer((Item)this, 0, "inventory");
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\ToolSwordBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */