 package com.ancient.thaumicgadgets.items.pouches;
 
 import net.minecraft.inventory.IInventory;
 import net.minecraft.inventory.Slot;
 import net.minecraft.item.ItemStack;
 
 
 public class SlotPouch
   extends Slot
 {
   public SlotPouch(IInventory inventoryIn, int index, int xPosition, int yPosition) {
/* 12 */     super(inventoryIn, index, xPosition, yPosition);
   }
 
 
   
   public boolean isItemValid(ItemStack stack) {
/* 18 */     if (stack.getTranslationKey().contains("pouch") && (stack.getTranslationKey().contains("void") || stack.getTranslationKey().contains("magic")))
     {
/* 20 */       return false;
     }
/* 22 */     return true;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\pouches\SlotPouch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */