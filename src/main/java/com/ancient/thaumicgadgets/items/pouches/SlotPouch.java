package com.ancient.thaumicgadgets.items.pouches;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotPouch extends Slot {
    public SlotPouch(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }

    public boolean isItemValid(ItemStack stack) {
        return !stack.getTranslationKey().contains("pouch") || (!stack.getTranslationKey().contains("void") && !stack.getTranslationKey().contains("magic"));
    }
}