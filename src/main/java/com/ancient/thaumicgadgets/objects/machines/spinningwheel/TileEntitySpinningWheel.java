/*     */ package com.ancient.thaumicgadgets.objects.machines.spinningwheel;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.ItemStackHelper;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ITickable;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.util.text.TextComponentString;
/*     */ import net.minecraft.util.text.TextComponentTranslation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class TileEntitySpinningWheel extends TileEntity implements IInventory, ITickable {
/*  19 */   private NonNullList<ItemStack> inventory = NonNullList.withSize(5, ItemStack.EMPTY);
/*     */   
/*     */   private String customName;
/*     */   
/*     */   private int totalWorkTime;
/*     */   
/*     */   private int workTime;
/*     */   
/*     */   public String getName() {
/*  28 */     return hasCustomName() ? this.customName : "container.spinning_wheel";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCustomName() {
/*  34 */     return (this.customName != null && !this.customName.isEmpty());
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCustomName(String customName) {
/*  39 */     this.customName = customName;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ITextComponent getDisplayName() {
/*  45 */     return hasCustomName() ? (ITextComponent)new TextComponentString(getName()) : (ITextComponent)new TextComponentTranslation(getName(), new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSizeInventory() {
/*  51 */     return this.inventory.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  57 */     for (ItemStack stack : this.inventory) {
/*     */       
/*  59 */       if (!stack.isEmpty()) return false; 
/*     */     } 
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getStackInSlot(int index) {
/*  67 */     return (ItemStack)this.inventory.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack decrStackSize(int index, int count) {
/*  73 */     return ItemStackHelper.getAndSplit((List)this.inventory, index, count);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack removeStackFromSlot(int index) {
/*  79 */     return ItemStackHelper.getAndRemove((List)this.inventory, index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventorySlotContents(int index, ItemStack stack) {
/*  85 */     ItemStack itemStack = (ItemStack)this.inventory.get(index);
/*  86 */     boolean flag = (!stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack));
/*  87 */     this.inventory.set(index, stack);
/*     */     
/*  89 */     if (stack.getCount() > getInventoryStackLimit())
/*     */     {
/*  91 */       stack.setCount(getInventoryStackLimit());
/*     */     }
/*  93 */     if (index == 0 && index + 1 == 1 && !flag) {
/*     */       
/*  95 */       ItemStack stack1 = (ItemStack)this.inventory.get(index + 1);
/*  96 */       ItemStack stack2 = (ItemStack)this.inventory.get(index + 2);
/*  97 */       ItemStack stack3 = (ItemStack)this.inventory.get(index + 3);
/*  98 */       this.totalWorkTime = getWorkTime(stack, stack1, stack2, stack3);
/*  99 */       this.workTime = 0;
/* 100 */       markDirty();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeToNBT(NBTTagCompound compound) {
/* 107 */     super.writeToNBT(compound);
/* 108 */     compound.setInteger("WorkTime", (short)this.workTime);
/* 109 */     compound.setInteger("TotalWorkTime", (short)this.totalWorkTime);
/* 110 */     ItemStackHelper.saveAllItems(compound, this.inventory);
/*     */     
/* 112 */     if (hasCustomName())
/*     */     {
/* 114 */       compound.setString("CustomName", this.customName);
/*     */     }
/* 116 */     return compound;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagCompound compound) {
/* 122 */     super.readFromNBT(compound);
/*     */     
/* 124 */     this.inventory = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
/* 125 */     ItemStackHelper.loadAllItems(compound, this.inventory);
/*     */     
/* 127 */     this.workTime = compound.getInteger("WorkTime");
/* 128 */     this.totalWorkTime = compound.getInteger("TotalWorkTime");
/*     */     
/* 130 */     if (compound.hasKey("CustomName", 8))
/*     */     {
/* 132 */       setCustomName(compound.getString("CustomName"));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getInventoryStackLimit() {
/* 139 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWorking() {
/* 144 */     return (this.workTime > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean isWorking(IInventory inventory) {
/* 150 */     return (inventory.getField(0) > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWorkTime(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4) {
/* 156 */     return 200;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canWork() {
/* 161 */     if (((ItemStack)this.inventory.get(0)).isEmpty() || ((ItemStack)this.inventory.get(1)).isEmpty() || ((ItemStack)this.inventory.get(2)).isEmpty() || ((ItemStack)this.inventory.get(3)).isEmpty()) {
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     ItemStack result = SpinningWheelRecipes.getInstance().getWorkResult((ItemStack)this.inventory.get(0), (ItemStack)this.inventory.get(1), (ItemStack)this.inventory.get(2), (ItemStack)this.inventory.get(3));
/* 166 */     if (result.isEmpty()) {
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     ItemStack output = (ItemStack)this.inventory.get(4);
/* 171 */     if (output.isEmpty())
/* 172 */       return true; 
/* 173 */     if (!output.isItemEqual(result))
/* 174 */       return false; 
/* 175 */     int res = output.getCount() + result.getCount();
/* 176 */     return (res <= getInventoryStackLimit() && res <= output.getMaxStackSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void craftItem() {
/* 183 */     if (canWork()) {
/*     */       
/* 185 */       ItemStack input1 = (ItemStack)this.inventory.get(0);
/* 186 */       ItemStack input2 = (ItemStack)this.inventory.get(1);
/* 187 */       ItemStack input3 = (ItemStack)this.inventory.get(2);
/* 188 */       ItemStack input4 = (ItemStack)this.inventory.get(3);
/* 189 */       ItemStack result = SpinningWheelRecipes.getInstance().getWorkResult(input1, input2, input3, input4);
/* 190 */       ItemStack output = (ItemStack)this.inventory.get(4);
/*     */       
/* 192 */       if (output.isEmpty()) { this.inventory.set(4, result.copy()); }
/* 193 */       else if (output.getItem() == result.getItem()) { output.grow(result.getCount()); }
/*     */       
/* 195 */       input1.shrink(1);
/* 196 */       input2.shrink(1);
/* 197 */       input3.shrink(1);
/* 198 */       input4.shrink(1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isUsableByPlayer(EntityPlayer player) {
/* 205 */     return (this.world.getTileEntity(this.pos) != this) ? false : ((player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D));
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
/* 217 */     if (index == 4) {
/* 218 */       return false;
/*     */     }
/* 220 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getGuiID() {
/* 225 */     return "tg:spinning_wheel";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getField(int id) {
/* 231 */     switch (id) {
/*     */       
/*     */       case 0:
/* 234 */         return this.workTime;
/*     */       case 1:
/* 236 */         return this.totalWorkTime;
/*     */     } 
/* 238 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(int id, int value) {
/* 245 */     switch (id) {
/*     */       
/*     */       case 0:
/* 248 */         this.workTime = value;
/*     */         break;
/*     */       case 1:
/* 251 */         this.totalWorkTime = value;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFieldCount() {
/* 259 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 265 */     this.inventory.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 270 */     boolean flag = isWorking();
/* 271 */     boolean flag1 = false;
/*     */     
/* 273 */     if (!this.world.isRemote) {
/*     */       
/* 275 */       ItemStack item1 = (ItemStack)this.inventory.get(0);
/* 276 */       ItemStack item2 = (ItemStack)this.inventory.get(1);
/* 277 */       ItemStack item3 = (ItemStack)this.inventory.get(2);
/* 278 */       ItemStack item4 = (ItemStack)this.inventory.get(3);
/*     */       
/* 280 */       if (canWork()) {
/*     */         
/* 282 */         this.workTime++;
/* 283 */         if (this.workTime == this.totalWorkTime) {
/*     */           
/* 285 */           this.workTime = 0;
/* 286 */           this.totalWorkTime = getWorkTime(item1, item2, item3, item4);
/* 287 */           craftItem();
/* 288 */           flag1 = true;
/*     */         } 
/*     */       } else {
/* 291 */         this.workTime = 0;
/* 292 */       }  if (flag == isWorking())
/*     */       {
/* 294 */         flag1 = true;
/*     */       }
/*     */     } 
/*     */     
/* 298 */     if (flag1)
/*     */     {
/* 300 */       markDirty();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\spinningwheel\TileEntitySpinningWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */