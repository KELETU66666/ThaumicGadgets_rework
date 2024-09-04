package com.ancient.thaumicgadgets.items.pouches;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.List;

public class InventoryPouch implements IInventory {
    private String customName;
    private final ItemStack invItem;
    public final int inv_size;
    private final List<ItemStack> inventory;

    public InventoryPouch(ItemStack stack) {
        this.invItem = stack;
        this.customName = stack.getTranslationKey().substring(5);
        this.inv_size = 18;
        this.inventory = NonNullList.withSize(this.inv_size, ItemStack.EMPTY);
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }
        readFromNBT(stack);
    }

    public String getName() {
        return hasCustomName() ? this.customName : "container.magic_pouch";
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
        ItemStack stack = getStackInSlot(index);
        if (stack != ItemStack.EMPTY) {
            if (stack.getCount() > count) {

                stack = stack.splitStack(count);
                markDirty();
            } else {

                setInventorySlotContents(index, ItemStack.EMPTY);
            }
        }
        return stack;
    }

    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }

    public void setInventorySlotContents(int index, ItemStack stack) {
        this.inventory.set(index, stack);
        if (stack != ItemStack.EMPTY && stack.getCount() > getInventoryStackLimit()) {
            stack.setCount(getInventoryStackLimit());
        }
        markDirty();
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public void markDirty() {
        for (int i = 0; i < getSizeInventory(); i++) {
            if (getStackInSlot(i) != ItemStack.EMPTY && getStackInSlot(i).getCount() == 0) {
                this.inventory.set(i, ItemStack.EMPTY);
            }
        }
        writeToNBT(this.invItem);
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    public void openInventory(EntityPlayer player) {
    }

    public void closeInventory(EntityPlayer player) {
    }

    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    public void readFromNBT(ItemStack stack) {
        String tagName = stack.getTranslationKey().substring(5);
        NBTTagList items = stack.getTagCompound().getTagList(tagName, 10);
        for (int i = 0; i < items.tagCount(); i++) {
            NBTTagCompound item = items.getCompoundTagAt(i);
            int slot = item.getInteger("slot");
            if (slot >= 0 && slot < getSizeInventory()) {
                this.inventory.set(slot, new ItemStack(item));
            }
        }
    }

    public void writeToNBT(ItemStack stack) {
        NBTTagList items = new NBTTagList();
        for (int i = 0; i < getSizeInventory(); i++) {
            if (getStackInSlot(i) != ItemStack.EMPTY) {
                NBTTagCompound item = new NBTTagCompound();
                item.setInteger("slot", i);
                getStackInSlot(i).writeToNBT(item);
                items.appendTag(item);
            }
        }
        String tagName = stack.getTranslationKey().substring(5);
        stack.getTagCompound().setTag(tagName, items);
    }

    public int getField(int id) {
        return 0;
    }

    public void setField(int id, int value) {
    }

    public int getFieldCount() {
        return 0;
    }

    public void clear() {
    }
}