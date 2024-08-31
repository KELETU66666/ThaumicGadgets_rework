package com.ancient.thaumicgadgets.objects.machines.spinningwheel;


import com.ancient.thaumicgadgets.objects.machines.SlotOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerSpinningWheel
        extends Container {
    private final TileEntitySpinningWheel tileentity;
    private int worktime;
    private int totalworktime;

    public ContainerSpinningWheel(InventoryPlayer player, TileEntitySpinningWheel tileentity) {
        this.tileentity = tileentity;

        addSlotToContainer(new Slot(tileentity, 0, 18, 8));
        addSlotToContainer(new Slot(tileentity, 1, 18, 24));
        addSlotToContainer(new Slot(tileentity, 2, 18, 41));
        addSlotToContainer(new Slot(tileentity, 3, 18, 57));
        addSlotToContainer(new SlotOutput(player.player, tileentity, 4, 117, 39));

        for (int y = 0; y < 3; y++) {

            for (int i = 0; i < 9; i++) {
                addSlotToContainer(new Slot(player, i + y * 9 + 9, 8 + i * 18, 90 + y * 16));
            }
        }

        for (int x = 0; x < 9; x++) {
            addSlotToContainer(new Slot(player, x, 8 + x * 18, 143));
        }
    }


    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileentity);
    }


    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); i++) {

            IContainerListener listener = this.listeners.get(i);

            if (this.worktime != this.tileentity.getField(0))
                listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
            if (this.totalworktime != this.tileentity.getField(1))
                listener.sendWindowProperty(this, 1, this.tileentity.getField(1));

        }
        this.worktime = this.tileentity.getField(0);
        this.totalworktime = this.tileentity.getField(1);
    }


    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileentity.setField(id, data);
    }


    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileentity.isUsableByPlayer(playerIn);
    }


    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {

            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();

            if (index < 5) {

                if (!mergeItemStack(stack1, 5, 41, true))
                    return ItemStack.EMPTY;
                slot.onSlotChange(stack1, stack);
            } else if (index >= 5) {

                if (!mergeItemStack(stack1, 0, 5, false)) {
                    return ItemStack.EMPTY;


                }


            } else if (!mergeItemStack(stack1, 5, 40, false)) {

                return ItemStack.EMPTY;
            }
            if (stack1.isEmpty()) {

                slot.putStack(ItemStack.EMPTY);
            } else {

                slot.onSlotChanged();
            }
            if (stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(playerIn, stack1);
        }
        return stack;
    }
}
