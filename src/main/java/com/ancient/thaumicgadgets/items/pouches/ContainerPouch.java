package com.ancient.thaumicgadgets.items.pouches;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerPouch extends Container implements IInventoryChangedListener {
    private final InventoryPouch inventory;
    private final int INV_START = 18;
    private final EntityPlayer player;

    public ContainerPouch(EntityPlayer player, InventoryPlayer invPlayer, InventoryPouch stack) {
        this.inventory = stack;
        this.player = player;
        this.HOTBAR_END = this.INV_START + 27 + 8;

        for (int a = 0; a < INV_START; a++) {
            if (stack.getName().contains("void")) {
                this.addSlotToContainer(new SlotVoidPouch(this.inventory, a, 29 + a % 6 * 20, 7 + a / 6 * 20));
            } else
                this.addSlotToContainer(new SlotPouch(this.inventory, a, 35 + a % 6 * 18, 9 + a / 6 * 18));
        }

        bindPlayerInventory(invPlayer, stack);
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer, InventoryPouch stack) {
        if (stack.getName().contains("void")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                    this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 82 + i * 18));
                }
            }

            for (int i = 0; i < 9; i++) this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 140));
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                    this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 82 + i * 18));
                }
            }

            for (int i = 0; i < 9; i++) this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 140));
        }
    }

    private final int HOTBAR_END;

    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.inventory.isUsableByPlayer(playerIn);
    }


    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < this.INV_START) {
                if (!mergeItemStack(itemstack1, this.INV_START, this.HOTBAR_END + 1, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= this.INV_START) {
                if (!mergeItemStack(itemstack1, 0, this.INV_START, false)) {
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


    private boolean isHoldingPouch() {
        ItemStack is = this.player.getHeldItemMainhand();
        return (is != null) && (is.getItem() instanceof ItemPouch);
    }

    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        if ((!this.player.world.isRemote) && (!isHoldingPouch())) {
            this.player.closeScreen();
        }
    }


    public InventoryPouch getInv() {
        return this.inventory;
    }

    @Override
    public void onInventoryChanged(IInventory invBasic) {
        detectAndSendChanges();
    }
}