package com.ancient.thaumicgadgets.armor.primal;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class PrimalSlot
        extends Slot {
    public PrimalSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack) {
        if (stack.getTranslationKey().contains("crystal") && stack.getTranslationKey().contains("oval")) {
            return true;
        }
        return false;
    }
}