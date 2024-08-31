package com.ancient.thaumicgadgets.armor.primal;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPrimalArmor
        extends Container {
    private final InventoryPrimalArmor inventory;
    private static final int INV_START = 1;
    private static final int INV_END = 27;
    private static final int HOTBAR_START = 28;
    private static final int HOTBAR_END = 36;

    public ContainerPrimalArmor(EntityPlayer player, InventoryPlayer invPlayer, InventoryPrimalArmor stack) {
        this.inventory = stack;

        int i;
        for (i = 0; i < 1; i++) {
            addSlotToContainer(new PrimalSlot(this.inventory, i, 79, 29));
        }
        for (i = 0; i < 3; i++) {

            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 86 + i * 18));
            }
        }
        for (i = 0; i < 9; i++) {
            addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 144));
        }
    }


    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.inventory.isUsableByPlayer(playerIn);
    }


    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {

            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 1) {

                if (!mergeItemStack(itemstack1, 1, 37, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);


            } else if (index >= 1) {

                if (!mergeItemStack(itemstack1, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            }


            if (itemstack1.getCount() == 0) {

                slot.putStack(ItemStack.EMPTY);
            } else {

                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }


    public ItemStack slotClick(int slot, int dragType, ClickType clickTypeIn, EntityPlayer player) {
        if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItemMainhand()) {
            return ItemStack.EMPTY;
        }
        return super.slotClick(slot, dragType, clickTypeIn, player);
    }


    protected boolean mergeItemStack(ItemStack stack, int start, int end, boolean backwards) {
        boolean flag1 = false;
        int k = backwards ? (end - 1) : start;


        if (stack.isStackable()) {
            while (stack.getCount() > 0 && ((!backwards && k < end) || (backwards && k >= start))) {

                Slot slot = this.inventorySlots.get(k);
                ItemStack itemstack1 = slot.getStack();

                if (!slot.isItemValid(stack)) {
                    k += backwards ? -1 : 1;

                    continue;
                }
                if (itemstack1 != ItemStack.EMPTY && itemstack1.getItem() == stack.getItem() && (
                        !stack.getHasSubtypes() || stack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(stack, itemstack1)) {

                    int l = itemstack1.getCount() + stack.getCount();

                    if (l <= stack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
                        stack.setCount(0);
                        itemstack1.setCount(1);
                        this.inventory.markDirty();
                        flag1 = true;
                    } else if (itemstack1.getCount() < stack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
                        stack.setCount(stack.getCount() - stack.getMaxStackSize() - itemstack1.getCount());
                        itemstack1.setCount(stack.getMaxStackSize());
                        this.inventory.markDirty();
                        flag1 = true;
                    }
                }

                k += backwards ? -1 : 1;
            }
        }
        if (stack.getCount() > 0) {

            k = backwards ? (end - 1) : start;
            while ((!backwards && k < end) || (backwards && k >= start)) {
                Slot slot = this.inventorySlots.get(k);
                ItemStack itemstack1 = slot.getStack();

                if (!slot.isItemValid(stack)) {
                    k += backwards ? -1 : 1;

                    continue;
                }
                if (itemstack1 == ItemStack.EMPTY) {
                    int l = stack.getCount();
                    if (l <= slot.getSlotStackLimit()) {
                        slot.putStack(stack.copy());
                        stack.setCount(0);
                        this.inventory.markDirty();
                        flag1 = true;
                        break;
                    }
                    putStackInSlot(k, new ItemStack(stack.getItem(), slot.getSlotStackLimit(), stack.getItemDamage()));
                    stack.setCount(stack.getCount() - slot.getSlotStackLimit());
                    this.inventory.markDirty();
                    flag1 = true;
                }


                k += backwards ? -1 : 1;
            }
        }

        return flag1;
    }


    public InventoryPrimalArmor getInv() {
        return this.inventory;
    }
}