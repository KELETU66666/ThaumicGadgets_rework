 package com.ancient.thaumicgadgets.items;
 
 import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
 
 
 
 
 
 
 public class ItemLense
   extends ItemBase
 {
   private final EnumHandler.LenseTypes lense;
   
   public ItemLense(String name, EnumHandler.LenseTypes lense) {
/* 16 */     super(name);
     
/* 18 */     setMaxStackSize(1);
     
/* 20 */     this.lense = lense;
   }
 
   
   public EnumHandler.LenseTypes getLenseType() {
/* 25 */     return this.lense;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\ItemLense.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */