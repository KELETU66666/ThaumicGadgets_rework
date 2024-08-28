/*     */ package com.ancient.thaumicgadgets.armor.primal;
/*     */ 
/*     */

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
/*     */ public class InventoryPrimalArmor
/*     */   implements IInventory
/*     */ {
/*  21 */   private String customName = "Primal Armor Socket";
/*     */   private final ItemStack invItem;
/*     */   public static final int INV_SIZE = 1;
/*  24 */   private List<ItemStack> inventory = (List<ItemStack>)NonNullList.withSize(1, ItemStack.EMPTY);
/*     */ 
/*     */   
/*     */   public InventoryPrimalArmor(ItemStack stack) {
/*  28 */     this.invItem = stack;
/*  29 */     if (!stack.hasTagCompound())
/*     */     {
/*  31 */       stack.setTagCompound(new NBTTagCompound());
/*     */     }
/*  33 */     readFromNBT(stack.getTagCompound());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  39 */     return hasCustomName() ? this.customName : "container.primal_armor";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCustomName() {
/*  45 */     return (this.customName != null && !this.customName.isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCustomName(String customName) {
/*  50 */     this.customName = customName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ITextComponent getDisplayName() {
/*  56 */     return hasCustomName() ? (ITextComponent)new TextComponentString(getName()) : (ITextComponent)new TextComponentTranslation(getName(), new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSizeInventory() {
/*  62 */     return this.inventory.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  68 */     for (ItemStack stack : this.inventory) {
/*     */       
/*  70 */       if (!stack.isEmpty()) return false; 
/*     */     } 
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getStackInSlot(int index) {
/*  78 */     return this.inventory.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack decrStackSize(int index, int count) {
/*  84 */     ItemStack stack = getStackInSlot(index);
/*  85 */     if (stack != ItemStack.EMPTY)
/*     */     {
/*  87 */       if (stack.getCount() > count) {
/*     */         
/*  89 */         stack = stack.splitStack(count);
/*  90 */         markDirty();
/*     */       }
/*     */       else {
/*     */         
/*  94 */         setInventorySlotContents(index, ItemStack.EMPTY);
/*     */       } 
/*     */     }
/*  97 */     return stack;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack removeStackFromSlot(int index) {
/* 103 */     return ItemStackHelper.getAndRemove(this.inventory, index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventorySlotContents(int index, ItemStack stack) {
/* 109 */     this.inventory.set(index, stack);
/* 110 */     if (stack != ItemStack.EMPTY && stack.getCount() > getInventoryStackLimit())
/*     */     {
/* 112 */       stack.setCount(getInventoryStackLimit());
/*     */     }
/* 114 */     markDirty();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 120 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void markDirty() {
/* 126 */     for (int i = 0; i < getSizeInventory(); i++) {
/*     */       
/* 128 */       if (getStackInSlot(i) != ItemStack.EMPTY && getStackInSlot(i).getCount() == 0)
/*     */       {
/* 130 */         this.inventory.set(i, ItemStack.EMPTY);
/*     */       }
/*     */     } 
/* 133 */     writeToNBT(this.invItem.getTagCompound());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsableByPlayer(EntityPlayer player) {
/* 139 */     return true;
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
/* 153 */     if (index == 0)
/*     */     {
/* 155 */       return true;
/*     */     }
/* 157 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagCompound compound) {
/* 162 */     NBTTagList items = compound.getTagList("primalInventory", 10);
/* 163 */     for (int i = 0; i < items.tagCount(); i++) {
/*     */       
/* 165 */       NBTTagCompound item = items.getCompoundTagAt(i);
/* 166 */       int slot = item.getInteger("slot");
/*     */       
/* 168 */       if (slot >= 0 && slot < getSizeInventory())
/*     */       {
/* 170 */         this.inventory.set(slot, new ItemStack(item));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeToNBT(NBTTagCompound compound) {
/* 178 */     NBTTagList items = new NBTTagList();
/* 179 */     for (int i = 0; i < getSizeInventory(); i++) {
/*     */       
/* 181 */       if (getStackInSlot(i) != ItemStack.EMPTY) {
/*     */         
/* 183 */         NBTTagCompound item = new NBTTagCompound();
/* 184 */         item.setInteger("slot", i);
/* 185 */         getStackInSlot(i).writeToNBT(item);
/* 186 */         items.appendTag((NBTBase)item);
/*     */       } 
/*     */     } 
/* 189 */     compound.setTag("primalInventory", (NBTBase)items);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getField(int id) {
/* 195 */     ItemStack stack = getStackInSlot(id);
/* 196 */     if (stack.getTranslationKey().contains("Aer"))
/*     */     {
/* 198 */       return 0;
/*     */     }
/* 200 */     if (stack.getTranslationKey().contains("Ignis"))
/*     */     {
/* 202 */       return 1;
/*     */     }
/* 204 */     if (stack.getTranslationKey().contains("Aqua"))
/*     */     {
/* 206 */       return 2;
/*     */     }
/* 208 */     if (stack.getTranslationKey().contains("Terra"))
/*     */     {
/* 210 */       return 3;
/*     */     }
/* 212 */     if (stack.getTranslationKey().contains("Ordo"))
/*     */     {
/* 214 */       return 4;
/*     */     }
/* 216 */     if (stack.getTranslationKey().contains("Perditio"))
/*     */     {
/* 218 */       return 5;
/*     */     }
/* 220 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(int id, int value) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFieldCount() {
/* 231 */     return 1;
/*     */   }
/*     */   
/*     */   public void clear() {}
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\primal\InventoryPrimalArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */