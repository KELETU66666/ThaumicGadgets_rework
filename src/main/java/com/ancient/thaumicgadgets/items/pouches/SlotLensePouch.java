 package com.ancient.thaumicgadgets.items.pouches;
 
 import net.minecraft.inventory.IInventory;
 import net.minecraft.inventory.Slot;
 import net.minecraft.item.ItemStack;
 
 
 
 
 public class SlotLensePouch
   extends Slot
 {
   public SlotLensePouch(IInventory inventoryIn, int index, int xPosition, int yPosition) {
/* 14 */     super(inventoryIn, index, xPosition, yPosition);
   }
 
 
   
   public boolean isItemValid(ItemStack stack) {
/* 20 */     if (stack.getItem() instanceof com.ancient.thaumicgadgets.items.ItemLense)
     {
/* 22 */       return true;
     }
/* 24 */     return false;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\pouches\SlotLensePouch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */