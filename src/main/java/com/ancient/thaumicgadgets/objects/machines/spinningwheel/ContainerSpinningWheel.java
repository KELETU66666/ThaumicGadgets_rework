/*     */ package com.ancient.thaumicgadgets.objects.machines.spinningwheel;
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
/*     */ public class ContainerSpinningWheel
/*     */   extends Container
/*     */ {
/*     */   private final TileEntitySpinningWheel tileentity;
/*     */   private int worktime;
/*     */   private int totalworktime;
/*     */   
/*     */   public ContainerSpinningWheel(InventoryPlayer player, TileEntitySpinningWheel tileentity) {
/*  22 */     this.tileentity = tileentity;
/*     */     
/*  24 */     addSlotToContainer(new Slot(tileentity, 0, 18, 8));
/*  25 */     addSlotToContainer(new Slot(tileentity, 1, 18, 24));
/*  26 */     addSlotToContainer(new Slot(tileentity, 2, 18, 41));
/*  27 */     addSlotToContainer(new Slot(tileentity, 3, 18, 57));
/*  28 */     addSlotToContainer((Slot)new SlotOutput(player.player, tileentity, 4, 117, 39));
/*     */     
/*  30 */     for (int y = 0; y < 3; y++) {
/*     */       
/*  32 */       for (int i = 0; i < 9; i++)
/*     */       {
/*  34 */         addSlotToContainer(new Slot((IInventory)player, i + y * 9 + 9, 8 + i * 18, 90 + y * 16));
/*     */       }
/*     */     } 
/*     */     
/*  38 */     for (int x = 0; x < 9; x++)
/*     */     {
/*  40 */       addSlotToContainer(new Slot((IInventory)player, x, 8 + x * 18, 143));
/*     */     }
/*     */   }
/*     */ 
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
/*     */   public void detectAndSendChanges() {
/*  55 */     super.detectAndSendChanges();
/*     */     
/*  57 */     for (int i = 0; i < this.listeners.size(); i++) {
/*     */       
/*  59 */       IContainerListener listener = this.listeners.get(i);
/*     */       
/*  61 */       if (this.worktime != this.tileentity.getField(0)) listener.sendWindowProperty(this, 0, this.tileentity.getField(0)); 
/*  62 */       if (this.totalworktime != this.tileentity.getField(1)) listener.sendWindowProperty(this, 1, this.tileentity.getField(1));
/*     */     
/*     */     } 
/*  65 */     this.worktime = this.tileentity.getField(0);
/*  66 */     this.totalworktime = this.tileentity.getField(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void updateProgressBar(int id, int data) {
/*  73 */     this.tileentity.setField(id, data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer playerIn) {
/*  79 */     return this.tileentity.isUsableByPlayer(playerIn);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
/*  85 */     ItemStack stack = ItemStack.EMPTY;
/*  86 */     Slot slot = this.inventorySlots.get(index);
/*     */     
/*  88 */     if (slot != null && slot.getHasStack()) {
/*     */       
/*  90 */       ItemStack stack1 = slot.getStack();
/*  91 */       stack = stack1.copy();
/*     */       
/*  93 */       if (index < 5) {
/*     */         
/*  95 */         if (!mergeItemStack(stack1, 5, 41, true))
/*  96 */           return ItemStack.EMPTY; 
/*  97 */         slot.onSlotChange(stack1, stack);
/*     */       }
/*  99 */       else if (index >= 5) {
/*     */         
/* 101 */         if (!mergeItemStack(stack1, 0, 5, false))
/*     */         {
/* 103 */           return ItemStack.EMPTY;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 115 */       else if (!mergeItemStack(stack1, 5, 40, false)) {
/*     */         
/* 117 */         return ItemStack.EMPTY;
/*     */       } 
/* 119 */       if (stack1.isEmpty()) {
/*     */         
/* 121 */         slot.putStack(ItemStack.EMPTY);
/*     */       }
/*     */       else {
/*     */         
/* 125 */         slot.onSlotChanged();
/*     */       } 
/* 127 */       if (stack1.getCount() == stack.getCount()) return ItemStack.EMPTY; 
/* 128 */       slot.onTake(playerIn, stack1);
/*     */     } 
/* 130 */     return stack;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\spinningwheel\ContainerSpinningWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */