 package com.ancient.thaumicgadgets.tabs;

 import com.ancient.thaumicgadgets.init.ModItems;
 import net.minecraft.creativetab.CreativeTabs;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;


 public class GadgetsTab
   extends CreativeTabs
 {
   private final String file;

   public GadgetsTab(String label) {
/* 16 */     super(label);
/* 17 */     this.file = label + ".png";
/* 18 */     setBackgroundImageName(this.file);
/* 19 */     setNoTitle();
   }


   public ItemStack getTabIconItem() {
/* 24 */     return new ItemStack(ModItems.TG);
   }



   @SideOnly(Side.CLIENT)
   public String getBackgroundImageName() {
/* 31 */     return this.file;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tabs\GadgetsTab.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */