/*     */ package com.ancient.thaumicgadgets.armor.primal;
/*     */ 
/*     */

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerPrimalArmor
/*     */   extends Container {
/*     */   private final InventoryPrimalArmor inventory;
/*     */   private static final int INV_START = 1;
/*     */   private static final int INV_END = 27;
/*     */   private static final int HOTBAR_START = 28;
/*     */   private static final int HOTBAR_END = 36;
/*     */   
/*     */   public ContainerPrimalArmor(EntityPlayer player, InventoryPlayer invPlayer, InventoryPrimalArmor stack) {
/*  20 */     this.inventory = stack;
/*     */     
/*     */     int i;
/*  23 */     for (i = 0; i < 1; i++)
/*     */     {
/*  25 */       addSlotToContainer(new PrimalSlot(this.inventory, i, 79, 29));
/*     */     }
/*  27 */     for (i = 0; i < 3; i++) {
/*     */       
/*  29 */       for (int j = 0; j < 9; j++)
/*     */       {
/*  31 */         addSlotToContainer(new Slot((IInventory)invPlayer, j + i * 9 + 9, 8 + j * 18, 86 + i * 18));
/*     */       }
/*     */     } 
/*  34 */     for (i = 0; i < 9; i++)
/*     */     {
/*  36 */       addSlotToContainer(new Slot((IInventory)invPlayer, i, 8 + i * 18, 144));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer playerIn) {
/*  43 */     return this.inventory.isUsableByPlayer(playerIn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlot(EntityPlayer player, int index) {
/*  49 */     ItemStack itemstack = ItemStack.EMPTY;
/*  50 */     Slot slot = this.inventorySlots.get(index);
/*     */     
/*  52 */     if (slot != null && slot.getHasStack()) {
/*     */       
/*  54 */       ItemStack itemstack1 = slot.getStack();
/*  55 */       itemstack = itemstack1.copy();
/*     */       
/*  57 */       if (index < 1) {
/*     */         
/*  59 */         if (!mergeItemStack(itemstack1, 1, 37, true))
/*     */         {
/*  61 */           return ItemStack.EMPTY;
/*     */         }
/*     */         
/*  64 */         slot.onSlotChange(itemstack1, itemstack);
/*     */ 
/*     */       
/*     */       }
/*  68 */       else if (index >= 1) {
/*     */         
/*  70 */         if (!mergeItemStack(itemstack1, 0, 1, false))
/*     */         {
/*  72 */           return ItemStack.EMPTY;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  77 */       if (itemstack1.getCount() == 0) {
/*     */         
/*  79 */         slot.putStack(ItemStack.EMPTY);
/*     */       }
/*     */       else {
/*     */         
/*  83 */         slot.onSlotChanged();
/*     */       } 
/*     */       
/*  86 */       if (itemstack1.getCount() == itemstack.getCount())
/*     */       {
/*  88 */         return ItemStack.EMPTY;
/*     */       }
/*     */       
/*  91 */       slot.onTake(player, itemstack1);
/*     */     } 
/*     */     
/*  94 */     return itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack slotClick(int slot, int dragType, ClickType clickTypeIn, EntityPlayer player) {
/* 100 */     if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItemMainhand())
/*     */     {
/* 102 */       return ItemStack.EMPTY;
/*     */     }
/* 104 */     return super.slotClick(slot, dragType, clickTypeIn, player);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean mergeItemStack(ItemStack stack, int start, int end, boolean backwards) {
/* 110 */     boolean flag1 = false;
/* 111 */     int k = backwards ? (end - 1) : start;
/*     */ 
/*     */ 
/*     */     
/* 115 */     if (stack.isStackable())
/*     */     {
/* 117 */       while (stack.getCount() > 0 && ((!backwards && k < end) || (backwards && k >= start))) {
/*     */         
/* 119 */         Slot slot = this.inventorySlots.get(k);
/* 120 */         ItemStack itemstack1 = slot.getStack();
/*     */         
/* 122 */         if (!slot.isItemValid(stack)) {
/* 123 */           k += backwards ? -1 : 1;
/*     */           
/*     */           continue;
/*     */         } 
/* 127 */         if (itemstack1 != ItemStack.EMPTY && itemstack1.getItem() == stack.getItem() && (
/* 128 */           !stack.getHasSubtypes() || stack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(stack, itemstack1)) {
/*     */           
/* 130 */           int l = itemstack1.getCount() + stack.getCount();
/*     */           
/* 132 */           if (l <= stack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
/* 133 */             stack.setCount(0);
/* 134 */             itemstack1.setCount(1);
/* 135 */             this.inventory.markDirty();
/* 136 */             flag1 = true;
/* 137 */           } else if (itemstack1.getCount() < stack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
/* 138 */             stack.setCount(stack.getCount() - stack.getMaxStackSize() - itemstack1.getCount());
/* 139 */             itemstack1.setCount(stack.getMaxStackSize());
/* 140 */             this.inventory.markDirty();
/* 141 */             flag1 = true;
/*     */           } 
/*     */         } 
/*     */         
/* 145 */         k += backwards ? -1 : 1;
/*     */       } 
/*     */     }
/* 148 */     if (stack.getCount() > 0) {
/*     */       
/* 150 */       k = backwards ? (end - 1) : start;
/* 151 */       while ((!backwards && k < end) || (backwards && k >= start)) {
/* 152 */         Slot slot = this.inventorySlots.get(k);
/* 153 */         ItemStack itemstack1 = slot.getStack();
/*     */         
/* 155 */         if (!slot.isItemValid(stack)) {
/* 156 */           k += backwards ? -1 : 1;
/*     */           
/*     */           continue;
/*     */         } 
/* 160 */         if (itemstack1 == ItemStack.EMPTY) {
/* 161 */           int l = stack.getCount();
/* 162 */           if (l <= slot.getSlotStackLimit()) {
/* 163 */             slot.putStack(stack.copy());
/* 164 */             stack.setCount(0);
/* 165 */             this.inventory.markDirty();
/* 166 */             flag1 = true;
/*     */             break;
/*     */           } 
/* 169 */           putStackInSlot(k, new ItemStack(stack.getItem(), slot.getSlotStackLimit(), stack.getItemDamage()));
/* 170 */           stack.setCount(stack.getCount() - slot.getSlotStackLimit());
/* 171 */           this.inventory.markDirty();
/* 172 */           flag1 = true;
/*     */         } 
/*     */ 
/*     */         
/* 176 */         k += backwards ? -1 : 1;
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     return flag1;
/*     */   }
/*     */ 
/*     */   
/*     */   public InventoryPrimalArmor getInv() {
/* 185 */     return this.inventory;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\primal\ContainerPrimalArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */