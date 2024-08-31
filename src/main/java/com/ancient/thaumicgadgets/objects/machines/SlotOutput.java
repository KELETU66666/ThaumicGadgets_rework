package com.ancient.thaumicgadgets.objects.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotOutput extends Slot {
    private final EntityPlayer player;
    private final IInventory inventory;
    private int removeCount;

    public SlotOutput(EntityPlayer player, IInventory inventory, int index, int xPosition, int yPosition) {
        super(inventory, index, xPosition, yPosition);
        this.player = player;
        this.inventory = inventory;
    }


    public boolean isItemValid(ItemStack stack) {
        return false;
    }


    public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
        onCrafting(stack);
        super.onTake(thePlayer, stack);
        return stack;
    }


    public ItemStack decrStackSize(int amount) {
        if (getHasStack()) {
            this.removeCount += Math.min(amount, getStack().getCount());
        }
        return super.decrStackSize(amount);
    }
}