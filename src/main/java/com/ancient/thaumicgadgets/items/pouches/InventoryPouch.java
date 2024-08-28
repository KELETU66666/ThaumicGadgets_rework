/*     */ package com.ancient.thaumicgadgets.items.pouches;
/*     */ 
/*     */

import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InventoryPouch
/*     */   implements IInventory
/*     */ {
/*     */   private String customName;
/*     */   private final ItemStack invItem;
/*     */   public final int inv_size;
/*     */   private List<ItemStack> inventory;
/*     */   
/*     */   public InventoryPouch(ItemStack stack) {
/*  31 */     this.invItem = stack;
/*  32 */     this.customName = stack.getTranslationKey().substring(5, stack.getTranslationKey().length());
/*  33 */     this.inv_size = EnumHandler.PouchTypes.valueOf(this.customName).getSlotCount();
/*  34 */     this.inventory = (List<ItemStack>)NonNullList.withSize(this.inv_size, ItemStack.EMPTY);
/*  35 */     if (!stack.hasTagCompound())
/*     */     {
/*  37 */       stack.setTagCompound(new NBTTagCompound());
/*     */     }
/*  39 */     readFromNBT(stack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  45 */     return hasCustomName() ? this.customName : "container.magic_pouch";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCustomName() {
/*  51 */     return (this.customName != null && !this.customName.isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCustomName(String customName) {
/*  56 */     this.customName = customName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ITextComponent getDisplayName() {
/*  62 */     return hasCustomName() ? (ITextComponent)new TextComponentString(getName()) : (ITextComponent)new TextComponentTranslation(getName(), new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSizeInventory() {
/*  68 */     return this.inventory.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  74 */     for (ItemStack stack : this.inventory) {
/*     */       
/*  76 */       if (!stack.isEmpty()) return false; 
/*     */     } 
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getStackInSlot(int index) {
/*  84 */     return this.inventory.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack decrStackSize(int index, int count) {
/*  90 */     ItemStack stack = getStackInSlot(index);
/*  91 */     if (stack != ItemStack.EMPTY)
/*     */     {
/*  93 */       if (stack.getCount() > count) {
/*     */         
/*  95 */         stack = stack.splitStack(count);
/*  96 */         markDirty();
/*     */       }
/*     */       else {
/*     */         
/* 100 */         setInventorySlotContents(index, ItemStack.EMPTY);
/*     */       } 
/*     */     }
/* 103 */     return stack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack removeStackFromSlot(int index) {
/* 109 */     return ItemStackHelper.getAndRemove(this.inventory, index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventorySlotContents(int index, ItemStack stack) {
/* 115 */     this.inventory.set(index, stack);
/* 116 */     if (stack != ItemStack.EMPTY && stack.getCount() > getInventoryStackLimit())
/*     */     {
/* 118 */       stack.setCount(getInventoryStackLimit());
/*     */     }
/* 120 */     markDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 126 */     return 64;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void markDirty() {
/* 132 */     for (int i = 0; i < getSizeInventory(); i++) {
/*     */       
/* 134 */       if (getStackInSlot(i) != ItemStack.EMPTY && getStackInSlot(i).getCount() == 0)
/*     */       {
/* 136 */         this.inventory.set(i, ItemStack.EMPTY);
/*     */       }
/*     */     } 
/* 139 */     writeToNBT(this.invItem);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsableByPlayer(EntityPlayer player) {
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void openInventory(EntityPlayer player) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeInventory(EntityPlayer player) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isItemValidForSlot(int index, ItemStack stack) {
/* 159 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromNBT(ItemStack stack) {
/* 164 */     String tagName = stack.getTranslationKey().substring(5, stack.getTranslationKey().length());
/* 165 */     NBTTagList items = stack.getTagCompound().getTagList(tagName, 10);
/* 166 */     for (int i = 0; i < items.tagCount(); i++) {
/*     */       
/* 168 */       NBTTagCompound item = items.getCompoundTagAt(i);
/* 169 */       int slot = item.getInteger("slot");
/* 170 */       if (slot >= 0 && slot < getSizeInventory())
/*     */       {
/* 172 */         this.inventory.set(slot, new ItemStack(item));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeToNBT(ItemStack stack) {
/* 180 */     NBTTagList items = new NBTTagList();
/* 181 */     for (int i = 0; i < getSizeInventory(); i++) {
/*     */       
/* 183 */       if (getStackInSlot(i) != ItemStack.EMPTY) {
/*     */         
/* 185 */         NBTTagCompound item = new NBTTagCompound();
/* 186 */         item.setInteger("slot", i);
/* 187 */         getStackInSlot(i).writeToNBT(item);
/* 188 */         items.appendTag((NBTBase)item);
/*     */       } 
/*     */     } 
/* 191 */     String tagName = stack.getTranslationKey().substring(5, stack.getTranslationKey().length());
/* 192 */     stack.getTagCompound().setTag(tagName, (NBTBase)items);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getField(int id) {
/* 198 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(int id, int value) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFieldCount() {
/* 208 */     return 0;
/*     */   }
/*     */   
/*     */   public void clear() {}
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\pouches\InventoryPouch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */