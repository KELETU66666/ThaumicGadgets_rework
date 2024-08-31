package com.ancient.thaumicgadgets.objects.machines.spinningwheel;

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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntitySpinningWheel extends TileEntity implements IInventory, ITickable {
  private NonNullList<ItemStack> inventory = NonNullList.withSize(5, ItemStack.EMPTY);

  private String customName;

  private int totalWorkTime;

  private int workTime;

  public String getName() {
      return hasCustomName() ? this.customName : "container.spinning_wheel";
  }



   public boolean hasCustomName() {
     return (this.customName != null && !this.customName.isEmpty());
   }


   public void setCustomName(String customName) {
     this.customName = customName;
   }



   public ITextComponent getDisplayName() {
     return hasCustomName() ? new TextComponentString(getName()) : new TextComponentTranslation(getName());
   }



   public int getSizeInventory() {
     return this.inventory.size();
   }



   public boolean isEmpty() {
     for (ItemStack stack : this.inventory) {

       if (!stack.isEmpty()) return false;
     }
     return true;
   }



   public ItemStack getStackInSlot(int index) {
     return this.inventory.get(index);
   }



   public ItemStack decrStackSize(int index, int count) {
     return ItemStackHelper.getAndSplit(this.inventory, index, count);
   }



   public ItemStack removeStackFromSlot(int index) {
     return ItemStackHelper.getAndRemove(this.inventory, index);
   }



   public void setInventorySlotContents(int index, ItemStack stack) {
     ItemStack itemStack = this.inventory.get(index);
     boolean flag = (!stack.isEmpty() && stack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(stack, itemStack));
     this.inventory.set(index, stack);

     if (stack.getCount() > getInventoryStackLimit())
     {
       stack.setCount(getInventoryStackLimit());
     }
     if (index == 0 && index + 1 == 1 && !flag) {

       ItemStack stack1 = this.inventory.get(index + 1);
       ItemStack stack2 = this.inventory.get(index + 2);
       ItemStack stack3 = this.inventory.get(index + 3);
       this.totalWorkTime = getWorkTime(stack, stack1, stack2, stack3);
       this.workTime = 0;
       markDirty();
     }
   }



   public NBTTagCompound writeToNBT(NBTTagCompound compound) {
     super.writeToNBT(compound);
     compound.setInteger("WorkTime", (short)this.workTime);
     compound.setInteger("TotalWorkTime", (short)this.totalWorkTime);
     ItemStackHelper.saveAllItems(compound, this.inventory);

     if (hasCustomName())
     {
       compound.setString("CustomName", this.customName);
     }
     return compound;
   }



   public void readFromNBT(NBTTagCompound compound) {
     super.readFromNBT(compound);

     this.inventory = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
     ItemStackHelper.loadAllItems(compound, this.inventory);

     this.workTime = compound.getInteger("WorkTime");
     this.totalWorkTime = compound.getInteger("TotalWorkTime");

     if (compound.hasKey("CustomName", 8))
     {
       setCustomName(compound.getString("CustomName"));
     }
   }



   public int getInventoryStackLimit() {
     return 1;
   }


   public boolean isWorking() {
     return (this.workTime > 0);
   }


   @SideOnly(Side.CLIENT)
   public static boolean isWorking(IInventory inventory) {
     return (inventory.getField(0) > 0);
   }



   public int getWorkTime(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4) {
     return 200;
   }


   private boolean canWork() {
     if (this.inventory.get(0).isEmpty() || this.inventory.get(1).isEmpty() || this.inventory.get(2).isEmpty() || this.inventory.get(3).isEmpty()) {
       return false;
     }

     ItemStack result = SpinningWheelRecipes.getInstance().getWorkResult(this.inventory.get(0), this.inventory.get(1), this.inventory.get(2), this.inventory.get(3));
     if (result.isEmpty()) {
       return false;
     }

     ItemStack output = this.inventory.get(4);
     if (output.isEmpty())
       return true;
     if (!output.isItemEqual(result))
       return false;
     int res = output.getCount() + result.getCount();
     return (res <= getInventoryStackLimit() && res <= output.getMaxStackSize());
   }




   public void craftItem() {
     if (canWork()) {

       ItemStack input1 = this.inventory.get(0);
       ItemStack input2 = this.inventory.get(1);
       ItemStack input3 = this.inventory.get(2);
       ItemStack input4 = this.inventory.get(3);
       ItemStack result = SpinningWheelRecipes.getInstance().getWorkResult(input1, input2, input3, input4);
       ItemStack output = this.inventory.get(4);

       if (output.isEmpty()) { this.inventory.set(4, result.copy()); }
       else if (output.getItem() == result.getItem()) { output.grow(result.getCount()); }

       input1.shrink(1);
       input2.shrink(1);
       input3.shrink(1);
       input4.shrink(1);
     }
   }



   public boolean isUsableByPlayer(EntityPlayer player) {
     return this.world.getTileEntity(this.pos) == this && ((player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D));
   }



   public void openInventory(EntityPlayer player) {}


   public void closeInventory(EntityPlayer player) {}


   public boolean isItemValidForSlot(int index, ItemStack stack) {
      return index != 4;
  }

  public String getGuiID() {
      return "thaumicgadgets:spinning_wheel";
  }

  public int getField(int id) {switch (id) {

      case 0: return this.workTime;
      case 1: return this.totalWorkTime;
  }
  return 0;
  }

  public void setField(int id, int value) {switch (id) {

      case 0: this.workTime = value;
      break;
      case 1: this.totalWorkTime = value;
      break;
  }
  }

  public int getFieldCount() {return 2;
  }

  public void clear() {this.inventory.clear();
  }

  public void update() {boolean flag = isWorking();boolean flag1 = false;if (!this.world.isRemote) {

      ItemStack item1 = this.inventory.get(0);
      ItemStack item2 = this.inventory.get(1);
      ItemStack item3 = this.inventory.get(2);
      ItemStack item4 = this.inventory.get(3);

      if (canWork()) {this.workTime++;if (this.workTime == this.totalWorkTime) {

          this.workTime = 0;
          this.totalWorkTime = getWorkTime(item1, item2, item3, item4);
          craftItem();
          flag1 = true;
      }
      } else {this.workTime = 0;
      }  if (flag == isWorking())
      {flag1 = true;
      }
  }

  if (flag1)
  {
      markDirty();
  }
  }
}