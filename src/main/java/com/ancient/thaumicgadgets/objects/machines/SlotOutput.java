 package com.ancient.thaumicgadgets.objects.machines;
 
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.inventory.IInventory;
 import net.minecraft.inventory.Slot;
 import net.minecraft.item.ItemStack;
 
 
 
 
 public class SlotOutput
   extends Slot
 {
   private final EntityPlayer player;
   private final IInventory inventory;
   private int removeCount;
   
   public SlotOutput(EntityPlayer player, IInventory inventory, int index, int xPosition, int yPosition) {
/* 19 */     super(inventory, index, xPosition, yPosition);
/* 20 */     this.player = player;
/* 21 */     this.inventory = inventory;
   }
 
 
   
   public boolean isItemValid(ItemStack stack) {
/* 27 */     return false;
   }
 
 
   
   public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
/* 33 */     onCrafting(stack);
/* 34 */     super.onTake(thePlayer, stack);
/* 35 */     return stack;
   }
 
 
   
   public ItemStack decrStackSize(int amount) {
/* 41 */     if (getHasStack())
     {
/* 43 */       this.removeCount += Math.min(amount, getStack().getCount());
     }
/* 45 */     return super.decrStackSize(amount);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\SlotOutput.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */