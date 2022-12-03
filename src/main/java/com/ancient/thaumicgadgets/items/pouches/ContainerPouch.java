/*     */ package com.ancient.thaumicgadgets.items.pouches;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.ClickType;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ContainerPouch
/*     */   extends Container
/*     */ {
/*     */   private final InventoryPouch inventory;
/*     */   private final int INV_START;
/*     */   
/*     */   public ContainerPouch(EntityPlayer player, InventoryPlayer invPlayer, InventoryPouch stack) {
/*  19 */     this.inventory = stack;
/*  20 */     this.INV_START = EnumHandler.PouchTypes.valueOf(stack.getName()).getSlotCount();
/*  21 */     this.INV_END = this.INV_START + 26;
/*  22 */     this.HOTBAR_START = this.INV_END + 1;
/*  23 */     this.HOTBAR_END = this.HOTBAR_START + 8;
/*     */     
/*  25 */     if (stack.getName().contains("magic") || stack.getName().contains("hungry")) {
/*     */       
/*  27 */       int q = Integer.parseInt(stack.getName().substring(stack.getName().length() - 1));
/*  28 */       for (int y = 0; y < Math.round((this.INV_START / 9)); y++)
/*     */       {
/*  30 */         for (int x = 0; x < 9; x++)
/*     */         {
/*  32 */           addSlotToContainer(new SlotPouch(this.inventory, x + y * 9, 8 + 18 * x, 0 - 9 * (q - 1) + 18 * y));
/*     */         }
/*     */       }
/*     */     
/*  36 */     } else if (stack.getName().contains("lense")) {
/*     */       
/*  38 */       for (int y = 0; y < 2; y++)
/*     */       {
/*  40 */         for (int x = 0; x < 6; x++)
/*     */         {
/*  42 */           addSlotToContainer(new SlotLensePouch(this.inventory, x + y * 6, 36 + 18 * x, 4 + 16 * y));
/*     */         }
/*     */       }
/*     */     
/*  46 */     } else if (stack.getName().contains("void")) {
/*     */       
/*  48 */       for (int y = 0; y < 3; y++) {
/*     */         
/*  50 */         for (int x = 0; x < 6; x++)
/*     */         {
/*  52 */           addSlotToContainer(new SlotVoidPouch(this.inventory, x + y * 6, 29 + 20 * x, -20 + 20 * y)); } 
/*     */       } 
/*     */     } 
/*     */     int i;
/*  56 */     for (i = 0; i < 3; i++) {
/*     */       
/*  58 */       for (int j = 0; j < 9; j++)
/*     */       {
/*  60 */         addSlotToContainer(new Slot((IInventory)invPlayer, j + i * 9 + 9, 8 + j * 18, 73 + i * 18));
/*     */       }
/*     */     } 
/*  63 */     for (i = 0; i < 9; i++)
/*     */     {
/*  65 */       addSlotToContainer(new Slot((IInventory)invPlayer, i, 8 + i * 18, 131)); } 
/*     */   }
/*     */   private final int INV_END;
/*     */   private final int HOTBAR_START;
/*     */   private final int HOTBAR_END;
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer playerIn) {
/*  72 */     return this.inventory.isUsableByPlayer(playerIn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlot(EntityPlayer player, int index) {
/*  78 */     ItemStack itemstack = ItemStack.EMPTY;
/*  79 */     Slot slot = this.inventorySlots.get(index);
/*     */     
/*  81 */     if (slot != null && slot.getHasStack()) {
/*     */       
/*  83 */       ItemStack itemstack1 = slot.getStack();
/*  84 */       itemstack = itemstack1.copy();
/*     */       
/*  86 */       if (index < this.INV_START) {
/*     */         
/*  88 */         if (!mergeItemStack(itemstack1, this.INV_START, this.HOTBAR_END + 1, true))
/*     */         {
/*  90 */           return ItemStack.EMPTY;
/*     */         }
/*     */         
/*  93 */         slot.onSlotChange(itemstack1, itemstack);
/*     */ 
/*     */       
/*     */       }
/*  97 */       else if (index >= this.INV_START) {
/*     */         
/*  99 */         if (!mergeItemStack(itemstack1, 0, this.INV_START, false))
/*     */         {
/* 101 */           return ItemStack.EMPTY;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 106 */       if (itemstack1.getCount() == 0) {
/*     */         
/* 108 */         slot.putStack(ItemStack.EMPTY);
/*     */       }
/*     */       else {
/*     */         
/* 112 */         slot.onSlotChanged();
/*     */       } 
/*     */       
/* 115 */       if (itemstack1.getCount() == itemstack.getCount())
/*     */       {
/* 117 */         return ItemStack.EMPTY;
/*     */       }
/*     */       
/* 120 */       slot.onTake(player, itemstack1);
/*     */     } 
/*     */     
/* 123 */     return itemstack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack slotClick(int slot, int dragType, ClickType clickTypeIn, EntityPlayer player) {
/* 129 */     if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItemMainhand())
/*     */     {
/* 131 */       return ItemStack.EMPTY;
/*     */     }
/* 133 */     return super.slotClick(slot, dragType, clickTypeIn, player);
/*     */   }
/*     */ 
/*     */   
/*     */   public InventoryPouch getInv() {
/* 138 */     return this.inventory;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\pouches\ContainerPouch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */