 package com.ancient.thaumicgadgets.objects.machines;
 
 import net.minecraft.inventory.IInventory;
 import net.minecraft.inventory.Slot;
 import net.minecraft.item.ItemStack;
 import thaumcraft.api.items.ItemsTC;
 
 
 
 public class SlotPhial
   extends Slot
 {
   private int removeCount;
   
   public SlotPhial(IInventory inventory, int index, int xPosition, int yPosition) {
/* 16 */     super(inventory, index, xPosition, yPosition);
   }
 
 
   
   public boolean isItemValid(ItemStack stack) {
/* 22 */     if (stack.getItem() == ItemsTC.phial)
     {
/* 24 */       return true;
     }
 
     
/* 28 */     return false;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\SlotPhial.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */