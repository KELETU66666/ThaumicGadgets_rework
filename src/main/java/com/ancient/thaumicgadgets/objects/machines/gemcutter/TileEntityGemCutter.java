package com.ancient.thaumicgadgets.objects.machines.gemcutter;


import com.ancient.thaumicgadgets.network.gemcutter.MessageClientAllAspects;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
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
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.aspects.AspectList;

public class TileEntityGemCutter
        extends TileEntity implements IInventory, ITickable {
    private NonNullList<ItemStack> inventory = NonNullList.withSize(3, ItemStack.EMPTY);
    private AspectList aspectList = new AspectList();
    private AspectList choosedAspects = new AspectList();
    private String customName;
    public final int maxWorkTime = 40;

    private int workTime;

    private int mode;

    public TileEntityGemCutter() {
        this.mode = 0;
    }


    public String getName() {
        return hasCustomName() ? this.customName : "container.gemcutter";
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

        if (stack.getCount() > getInventoryStackLimit()) {
            stack.setCount(getInventoryStackLimit());
        }
        if (index == 0 && index + 1 == 1 && !flag) {

            ItemStack stack1 = this.inventory.get(index + 1);
            this.mode = 0;
            markDirty();
        }
    }


    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("mode", (short) this.mode);
        compound.setInteger("workTime", this.workTime);
        ItemStackHelper.saveAllItems(compound, this.inventory);

        if (hasCustomName()) {
            compound.setString("customName", this.customName);
        }
        this.aspectList.writeToNBT(compound, "aspects");
        return compound;
    }


    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        this.inventory = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.inventory);

        this.mode = compound.getInteger("ode");
        this.workTime = compound.getInteger("workTime");

        if (compound.hasKey("customName", 8)) {
            setCustomName(compound.getString("customName"));
        }
        this.aspectList.readFromNBT(compound, "aspects");
    }


    public int getInventoryStackLimit() {
        return 64;
    }


    @SideOnly(Side.CLIENT)
    public static int currentMode(IInventory inventory) {
        return inventory.getField(0);
    }


    @SideOnly(Side.CLIENT)
    public static int getWorkTime(IInventory inventory) {
        return inventory.getField(1);
    }


    public boolean canWork() {
        if (this.inventory.get(0).isEmpty()) {
            return false;
        }


        ItemStack result = GemCutterRecipes.getInstance().getWorkResult(this.inventory.get(0), this.choosedAspects, this.mode);
        if (result.isEmpty()) {
            return false;
        }


        ItemStack output = this.inventory.get(2);
        if (output.isEmpty()) {
            return true;
        }
        if (!ItemStack.areItemStacksEqual(output, result)) {
            return false;
        }
        int res = output.getCount() + result.getCount();
        return (res < getInventoryStackLimit() && res <= output.getMaxStackSize());
    }


    public void craftItem() {
        if (canWork()) {

            ItemStack input0 = this.inventory.get(0);

            GemCutterRecipes.gemCutterRecipe rec = GemCutterRecipes.getInstance().getRecipeEntry(input0, this.choosedAspects, this.mode);

            if (rec != null) {

                ItemStack result = rec.outPut;
                ItemStack output = this.inventory.get(2);

                if (output.isEmpty()) {

                    for (Aspect as : rec.aspects.getAspects()) {
                        this.aspectList.reduce(as, rec.aspects.getAmount(as));
                    }
                    input0.shrink(rec.input.getCount());
                    this.inventory.set(2, result.copy());
                }
            }
        }
    }


    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.pos) == this && ((player.getDistanceSq(this.pos.getX() + 0.5D, this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D) <= 64.0D));
    }


    public void openInventory(EntityPlayer player) {
    }


    public void closeInventory(EntityPlayer player) {
    }


    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return index != 2;
    }


    public int getField(int id) {
        switch (id) {

            case 0:
                return this.mode;
            case 1:
                return this.workTime;
        }
        return 0;
    }


    public void setField(int id, int value) {
        switch (id) {

            case 0:
                this.mode = value;
                break;
            case 1:
                this.workTime = value;
                break;
        }
    }


    public int getFieldCount() {
        return 2;
    }


    public void clear() {
        this.inventory.clear();
    }


    public String getGuiID() {
        return "thaumicgadgets:gemcutter";
    }


    public void update() {
        boolean flag1 = false;

        if (!this.world.isRemote) {

            ItemStack item1 = this.inventory.get(0);
            ItemStack item2 = this.inventory.get(1);

            while (!GemCutterRecipes.containOnlyPrimalAspects(this.aspectList)) {
                this.aspectList = GemCutterRecipes.toPrimal(this.aspectList);
            }

            if (item2 != ItemStack.EMPTY) {

                if (AspectHelper.getObjectAspects(item2).size() > 0) {

                    if (++this.workTime == 40) {

                        AspectList asL = AspectHelper.getObjectAspects(item2);

                        if (asL != null && asL.size() > 0) {
                            for (Aspect as : asL.getAspects()) {
                                asL.add(as, asL.getAmount(as));
                            }
                            this.aspectList.add(asL);
                            while (!GemCutterRecipes.containOnlyPrimalAspects(this.aspectList)) {
                                this.aspectList = GemCutterRecipes.toPrimal(this.aspectList);
                            }

                            ItemStack st = this.inventory.get(1);
                            if (st.getCount() > 1) {

                                st.shrink(1);
                            } else {

                                st = ItemStack.EMPTY;
                            }
                            this.inventory.set(1, st);
                            this.workTime = 0;
                        }

                    }
                } else {

                    this.workTime = 0;
                }

            } else {

                this.workTime = 0;
            }

            flag1 = true;
        }
        if (flag1) {

            NetworkHandler.sendToAllNearby(new MessageClientAllAspects(this.aspectList, this), new NetworkRegistry.TargetPoint(this.world.provider.getDimension(), this.pos.getX(), this.pos.getY(), this.pos.getZ(), 20.0D));
            markDirty();
        }
    }


    public void setChoosedAspects(AspectList choosedAspects) {
        this.choosedAspects = choosedAspects;
    }


    public AspectList getAspectList() {
        return this.aspectList;
    }

    public void setAspectList(AspectList aspectList) {
        this.aspectList = aspectList;
    }
}