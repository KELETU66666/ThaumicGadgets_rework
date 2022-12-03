 package com.ancient.thaumicgadgets.items.pouches;

 import net.minecraft.inventory.IInventory;
 import net.minecraft.inventory.Slot;
 import net.minecraft.item.ItemStack;


 public class SlotVoidPouch
   extends Slot
 {
   public SlotVoidPouch(IInventory inventoryIn, int index, int xPosition, int yPosition) {
/* 12 */     super(inventoryIn, index, xPosition, yPosition);
   }



   public int getItemStackLimit(ItemStack stack) {
/* 18 */     return 1;
   }



   public boolean isItemValid(ItemStack stack) {
/* 24 */     if (stack.getUnlocalizedName().contains("pouch") && (stack.getUnlocalizedName().contains("void") || stack.getUnlocalizedName().contains("magic")))
     {
/* 26 */       return false;
     }
/* 28 */     return true;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\pouches\SlotVoidPouch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */