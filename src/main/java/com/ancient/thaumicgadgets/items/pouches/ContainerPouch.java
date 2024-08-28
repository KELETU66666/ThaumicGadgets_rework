package com.ancient.thaumicgadgets.items.pouches;

import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

public class ContainerPouch extends Container implements IInventoryChangedListener {
  private final InventoryPouch inventory;
  private final int INV_START;

  public ContainerPouch(EntityPlayer player, InventoryPlayer invPlayer, InventoryPouch stack) {
    this.inventory = stack;
    this.INV_START = EnumHandler.PouchTypes.valueOf(stack.getName()).getSlotCount();
    this.INV_END = this.INV_START + 26;
    this.HOTBAR_START = this.INV_END + 1;
    this.HOTBAR_END = this.HOTBAR_START + 8;

    if (stack.getName().contains("magic") || stack.getName().contains("hungry")) {

      int q = Integer.parseInt(stack.getName().substring(stack.getName().length() - 1));
      for (int y = 0; y < Math.round((this.INV_START / 9)); y++)
      {
        for (int x = 0; x < 9; x++)
        {
          addSlotToContainer(new SlotPouch(this.inventory, x + y * 9, 8 + 18 * x, -9 * (q - 1) + 18 * y));
        }
      }

    }  else if (stack.getName().contains("void")) {

      for (int y = 0; y < 3; y++) {

        for (int x = 0; x < 6; x++)
        {
          addSlotToContainer(new SlotVoidPouch(this.inventory, x + y * 6, 29 + 20 * x, -20 + 20 * y)); }
      }
    }
    int i;
    for (i = 0; i < 3; i++) {

      for (int j = 0; j < 9; j++)
      {
        addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 73 + i * 18));
      }
    }
    for (i = 0; i < 9; i++)
    {
      addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 131)); }
  }
  private final int INV_END;
  private final int HOTBAR_START;
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

        if (!mergeItemStack(itemstack1, this.INV_START, this.HOTBAR_END + 1, true))
        {
          return ItemStack.EMPTY;
        }

        slot.onSlotChange(itemstack1, itemstack);


      }
      else if (index >= this.INV_START) {

        if (!mergeItemStack(itemstack1, 0, this.INV_START, false))
        {
          return ItemStack.EMPTY;
        }
      }


      if (itemstack1.getCount() == 0) {

        slot.putStack(ItemStack.EMPTY);
      }
      else {

        slot.onSlotChanged();
      }

      if (itemstack1.getCount() == itemstack.getCount())
      {
        return ItemStack.EMPTY;
      }

      slot.onTake(player, itemstack1);
    }

    return itemstack;
  }



  public ItemStack slotClick(int slot, int dragType, ClickType clickTypeIn, EntityPlayer player) {
    if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItemMainhand())
    {
      return ItemStack.EMPTY;
    }
    return super.slotClick(slot, dragType, clickTypeIn, player);
  }


  public InventoryPouch getInv() {
      return this.inventory;
  }

   @Override
   public void onInventoryChanged(IInventory invBasic) {
       detectAndSendChanges();
   }
}