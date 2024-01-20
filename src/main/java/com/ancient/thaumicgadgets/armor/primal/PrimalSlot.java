 package com.ancient.thaumicgadgets.armor.primal;
 
 import net.minecraft.inventory.IInventory;
 import net.minecraft.inventory.Slot;
 import net.minecraft.item.ItemStack;
 
 
 
 public class PrimalSlot
   extends Slot
 {
   public PrimalSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
/* 13 */     super(inventoryIn, index, xPosition, yPosition);
   }
 
 
 
   
   public boolean isItemValid(ItemStack stack) {
/* 20 */     if (stack.getTranslationKey().contains("crystal") && stack.getTranslationKey().contains("oval"))
     {
/* 22 */       return true;
     }
/* 24 */     return false;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\primal\PrimalSlot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */