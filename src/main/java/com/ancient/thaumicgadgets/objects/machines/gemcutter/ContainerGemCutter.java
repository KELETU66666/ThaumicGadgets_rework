/*     */ package com.ancient.thaumicgadgets.objects.machines.gemcutter;
/*     */ 
/*     */

import com.ancient.thaumicgadgets.objects.machines.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ContainerGemCutter
/*     */   extends Container
/*     */ {
/*     */   private final TileEntityGemCutter tileentity;
/*     */   private int mode;
/*     */   private int workTime;
/*     */   
/*     */   public ContainerGemCutter(InventoryPlayer player, TileEntityGemCutter tileentity) {
/*  24 */     this.tileentity = tileentity;
/*  25 */     this.mode = this.tileentity.getField(0);
/*  26 */     this.workTime = this.tileentity.getField(1);
/*  27 */     addSlotToContainer(new Slot(tileentity, 0, 42, 10));
/*  28 */     addSlotToContainer(new Slot(tileentity, 1, 42, 48));
/*  29 */     addSlotToContainer((Slot)new SlotOutput(player.player, tileentity, 2, 118, 10));
/*     */     
/*  31 */     for (int y = 0; y < 3; y++) {
/*     */       
/*  33 */       for (int i = 0; i < 9; i++)
/*     */       {
/*  35 */         addSlotToContainer(new Slot((IInventory)player, i + y * 9 + 9, 8 + i * 18, 90 + y * 18));
/*     */       }
/*     */     } 
/*     */     
/*  39 */     for (int x = 0; x < 9; x++)
/*     */     {
/*  41 */       addSlotToContainer(new Slot((IInventory)player, x, 8 + x * 18, 148));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addListener(IContainerListener listener) {
/*  48 */     super.addListener(listener);
/*  49 */     listener.sendAllWindowProperties(this, this.tileentity);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void detectAndSendChanges() {
/*  56 */     super.detectAndSendChanges();
/*     */     
/*  58 */     for (int i = 0; i < this.listeners.size(); i++) {
/*     */       
/*  60 */       IContainerListener listener = this.listeners.get(i);
/*     */       
/*  62 */       if (this.mode != this.tileentity.getField(0)) listener.sendWindowProperty(this, 0, this.tileentity.getField(0)); 
/*  63 */       if (this.workTime != this.tileentity.getField(1)) listener.sendWindowProperty(this, 1, this.tileentity.getField(1));
/*     */     
/*     */     } 
/*  66 */     this.mode = this.tileentity.getField(0);
/*  67 */     this.workTime = this.tileentity.getField(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void updateProgressBar(int id, int data) {
/*  74 */     this.tileentity.setField(id, data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer playerIn) {
/*  80 */     return this.tileentity.isUsableByPlayer(playerIn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
/*  86 */     ItemStack stack = ItemStack.EMPTY;
/*  87 */     Slot slot = this.inventorySlots.get(index);
/*     */     
/*  89 */     if (slot != null && slot.getHasStack()) {
/*     */       
/*  91 */       ItemStack stack1 = slot.getStack();
/*  92 */       stack = stack1.copy();
/*     */       
/*  94 */       if (index < 3) {
/*     */         
/*  96 */         if (!mergeItemStack(stack1, 3, 39, true))
/*  97 */           return ItemStack.EMPTY; 
/*  98 */         slot.onSlotChange(stack1, stack);
/*     */       }
/* 100 */       else if (index >= 3) {
/*     */         
/* 102 */         if (!mergeItemStack(stack1, 0, 2, false))
/*     */         {
/* 104 */           return ItemStack.EMPTY;
/*     */         }
/*     */       } 
/* 107 */       if (stack1.isEmpty()) {
/*     */         
/* 109 */         slot.putStack(ItemStack.EMPTY);
/*     */       }
/*     */       else {
/*     */         
/* 113 */         slot.onSlotChanged();
/*     */       } 
/* 115 */       if (stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
/*     */       
/* 117 */       slot.onTake(playerIn, stack1);
/*     */     } 
/* 119 */     return stack;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\gemcutter\ContainerGemCutter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */