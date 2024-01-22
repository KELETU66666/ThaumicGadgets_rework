package com.ancient.thaumicgadgets.items.pouches;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotVoidPouch extends Slot {
    public SlotVoidPouch(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public int getItemStackLimit(ItemStack stack) {
        return 1;
    }

    public boolean isItemValid(ItemStack stack) {
        return !stack.getTranslationKey().contains("pouch") || (!stack.getTranslationKey().contains("void") && !stack.getTranslationKey().contains("magic"));
    }
}