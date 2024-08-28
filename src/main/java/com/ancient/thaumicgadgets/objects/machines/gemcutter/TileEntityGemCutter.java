/*     */ package com.ancient.thaumicgadgets.objects.machines.gemcutter;
/*     */ 
/*     */

import com.ancient.thaumicgadgets.network.gemcutter.MessageClientAllAspects;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.aspects.AspectList;

import java.util.List;
/*     */ 
/*     */ public class TileEntityGemCutter
/*     */   extends TileEntity implements IInventory, ITickable {
/*  27 */   private NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY);
/*  28 */   private AspectList aspectList = new AspectList();
/*  29 */   private AspectList choosedAspects = new AspectList();
/*     */   private String customName;
/*  31 */   public final int maxWorkTime = 40;
/*     */   
/*     */   private int workTime;
/*     */   
/*     */   private int mode;
/*     */   
/*     */   public TileEntityGemCutter() {
/*  38 */     this.mode = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  44 */     return hasCustomName() ? this.customName : "container.gemcutter";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCustomName() {
/*  50 */     return (this.customName != null && !this.customName.isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCustomName(String customName) {
/*  55 */     this.customName = customName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ITextComponent getDisplayName() {
/*  61 */     return hasCustomName() ? (ITextComponent)new TextComponentString(getName()) : (ITextComponent)new TextComponentTranslation(getName(), new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSizeInventory() {
/*  67 */     return this.inventory.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  73 */     for (ItemStack stack : this.inventory) {
/*     */       
/*  75 */       if (!stack.isEmpty()) return false; 
/*     */     } 
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getStackInSlot(int index) {
/*  83 */     return (ItemStack)this.inventory.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack decrStackSize(int index, int count) {
/*  89 */     return ItemStackHelper.getAndSplit((List)this.inventory, index, count);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack removeStackFromSlot(int index) {
/*  95 */     return ItemStackHelper.getAndRemove((List)this.inventory, index);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setInventorySlotContents(int index, ItemStack stack) {
/* 100 */     ItemStack itemStack = (ItemStack)this.inventory.get(index);
/* 101 */     boolean flag = (!stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack));
/* 102 */     this.inventory.set(index, stack);
/*     */     
/* 104 */     if (stack.getCount() > getInventoryStackLimit())
/*     */     {
/* 106 */       stack.setCount(getInventoryStackLimit());
/*     */     }
/* 108 */     if (index == 0 && index + 1 == 1 && !flag) {
/*     */       
/* 110 */       ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
/* 111 */       this.mode = 0;
/* 112 */       markDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeToNBT(NBTTagCompound compound) {
/* 119 */     super.writeToNBT(compound);
/* 120 */     compound.setInteger("mode", (short)this.mode);
/* 121 */     compound.setInteger("workTime", this.workTime);
/* 122 */     ItemStackHelper.saveAllItems(compound, this.inventory);
/*     */     
/* 124 */     if (hasCustomName())
/*     */     {
/* 126 */       compound.setString("customName", this.customName);
/*     */     }
/* 128 */     this.aspectList.writeToNBT(compound, "aspects");
/* 129 */     return compound;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagCompound compound) {
/* 135 */     super.readFromNBT(compound);
/*     */     
/* 137 */     this.inventory = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
/* 138 */     ItemStackHelper.loadAllItems(compound, this.inventory);
/*     */     
/* 140 */     this.mode = compound.getInteger("ode");
/* 141 */     this.workTime = compound.getInteger("workTime");
/*     */     
/* 143 */     if (compound.hasKey("customName", 8))
/*     */     {
/* 145 */       setCustomName(compound.getString("customName"));
/*     */     }
/* 147 */     this.aspectList.readFromNBT(compound, "aspects");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 153 */     return 64;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int currentMode(IInventory inventory) {
/* 159 */     return inventory.getField(0);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static int getWorkTime(IInventory inventory) {
/* 165 */     return inventory.getField(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWork() {
/* 170 */     if (((ItemStack)this.inventory.get(0)).isEmpty())
/*     */     {
/* 172 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 176 */     ItemStack result = GemCutterRecipes.getInstance().getWorkResult((ItemStack)this.inventory.get(0), this.choosedAspects, this.mode);
/* 177 */     if (result.isEmpty())
/*     */     {
/* 179 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 183 */     ItemStack output = (ItemStack)this.inventory.get(2);
/* 184 */     if (output.isEmpty())
/*     */     {
/* 186 */       return true;
/*     */     }
/* 188 */     if (!ItemStack.areItemStacksEqual(output, result))
/*     */     {
/* 190 */       return false;
/*     */     }
/* 192 */     int res = output.getCount() + result.getCount();
/* 193 */     return (res < getInventoryStackLimit() && res <= output.getMaxStackSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void craftItem() {
/* 200 */     if (canWork()) {
/*     */       
/* 202 */       ItemStack input0 = (ItemStack)this.inventory.get(0);
/*     */       
/* 204 */       GemCutterRecipes.gemCutterRecipe rec = GemCutterRecipes.getInstance().getRecipeEntry(input0, this.choosedAspects, this.mode);
/*     */       
/* 206 */       if (rec != null) {
/*     */         
/* 208 */         ItemStack result = rec.outPut;
/* 209 */         ItemStack output = (ItemStack)this.inventory.get(2);
/*     */         
/* 211 */         if (output.isEmpty()) {
/*     */           
/* 213 */           for (Aspect as : rec.aspects.getAspects())
/*     */           {
/* 215 */             this.aspectList.reduce(as, rec.aspects.getAmount(as));
/*     */           }
/* 217 */           input0.shrink(rec.input.getCount());
/* 218 */           this.inventory.set(2, result.copy());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsableByPlayer(EntityPlayer player) {
/* 228 */     return (this.world.getTileEntity(this.pos) != this) ? false : ((player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void openInventory(EntityPlayer player) {}
/*     */ 
/*     */   
/*     */   public void closeInventory(EntityPlayer player) {}
/*     */ 
/*     */   
/*     */   public boolean isItemValidForSlot(int index, ItemStack stack) {
/* 240 */     if (index == 2) {
/* 241 */       return false;
/*     */     }
/* 243 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getField(int id) {
/* 249 */     switch (id) {
/*     */       
/*     */       case 0:
/* 252 */         return this.mode;
/*     */       case 1:
/* 254 */         return this.workTime;
/*     */     } 
/* 256 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(int id, int value) {
/* 263 */     switch (id) {
/*     */       
/*     */       case 0:
/* 266 */         this.mode = value;
/*     */         break;
/*     */       case 1:
/* 269 */         this.workTime = value;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFieldCount() {
/* 277 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 283 */     this.inventory.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGuiID() {
/* 288 */     return "tg:gemcutter";
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 293 */     boolean flag1 = false;
/*     */     
/* 295 */     if (!this.world.isRemote) {
/*     */       
/* 297 */       ItemStack item1 = (ItemStack)this.inventory.get(0);
/* 298 */       ItemStack item2 = (ItemStack)this.inventory.get(1);
/*     */       
/* 300 */       while (!GemCutterRecipes.containOnlyPrimalAspects(this.aspectList))
/*     */       {
/* 302 */         this.aspectList = GemCutterRecipes.toPrimal(this.aspectList);
/*     */       }
/*     */       
/* 305 */       if (item2 != ItemStack.EMPTY) {
/*     */         
/* 307 */         if (AspectHelper.getObjectAspects(item2).size() > 0) {
/*     */           
/* 309 */           if (++this.workTime == 40) {
/*     */             
/* 311 */             AspectList asL = AspectHelper.getObjectAspects(item2);
/*     */             
/* 313 */             if (asL != null && asL.size() > 0)
/*     */             {
/* 315 */               for (Aspect as : asL.getAspects())
/*     */               {
/* 317 */                 asL.add(as, asL.getAmount(as));
/*     */               }
/* 319 */               this.aspectList.add(asL);
/* 320 */               while (!GemCutterRecipes.containOnlyPrimalAspects(this.aspectList))
/*     */               {
/* 322 */                 this.aspectList = GemCutterRecipes.toPrimal(this.aspectList);
/*     */               }
/*     */               
/* 325 */               ItemStack st = (ItemStack)this.inventory.get(1);
/* 326 */               if (st.getCount() > 1) {
/*     */                 
/* 328 */                 st.shrink(1);
/*     */               }
/*     */               else {
/*     */                 
/* 332 */                 st = ItemStack.EMPTY;
/*     */               } 
/* 334 */               this.inventory.set(1, st);
/* 335 */               this.workTime = 0;
/*     */             }
/*     */           
/*     */           } 
/*     */         } else {
/*     */           
/* 341 */           this.workTime = 0;
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 346 */         this.workTime = 0;
/*     */       } 
/*     */       
/* 349 */       flag1 = true;
/*     */     } 
/* 351 */     if (flag1) {
/*     */       
/* 353 */       NetworkHandler.sendToAllNearby((IMessage)new MessageClientAllAspects(this.aspectList, this), new NetworkRegistry.TargetPoint(this.world.provider.getDimension(), this.pos.getX(), this.pos.getY(), this.pos.getZ(), 20.0D));
/* 354 */       markDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setChoosedAspects(AspectList choosedAspects) {
/* 360 */     this.choosedAspects = choosedAspects;
/*     */   }
/*     */ 
/*     */   
/*     */   public AspectList getAspectList() {
/* 365 */     return this.aspectList;
/*     */   }
/*     */   
/*     */   public void setAspectList(AspectList aspectList) {
/* 369 */     this.aspectList = aspectList;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\gemcutter\TileEntityGemCutter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */