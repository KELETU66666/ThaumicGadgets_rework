package com.ancient.thaumicgadgets.objects.machines.blastfurnace;

import com.ancient.thaumicgadgets.util.handlers.Utilities;
import com.ancient.thaumicgadgets.util.handlers.Utilities.OreDictStack;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.IAspectSource;
import thaumcraft.api.aspects.IEssentiaTransport;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.lib.network.PacketHandler;
import thaumcraft.common.lib.network.fx.PacketFXEssentiaSource;
import thaumcraft.common.lib.utils.InventoryUtils;
import thaumcraft.common.tiles.devices.TileBellows;

import java.util.ArrayList;
import java.util.List;

public class TileEntityBlastFurnace extends TileEntityWGBase implements ITickable, IEssentiaTransport {

    float speedupTick = 0;
    int processTick = 0;
    int recipeTime = 0;
    int fuel = 0;
    int tick = 0;
    boolean specialFuel;
    public boolean active = false;
    List<ItemStack> inputs = new ArrayList<>();

    public int facingX = -5;
    public int facingZ = -5;
    public EnumFacing facing = EnumFacing.NORTH;

    private void setFacing() {
        facingX = 0;
        facingZ = 0;
        facing = EnumFacing.byIndex(getBlockMetadata() & 0x7);
        facingX = facing.getXOffset();
        facingZ = facing.getZOffset();
    }

    /*public void update()
    {
        if(world.isRemote)
            return;

        if (facingX == -5) {
            setFacing();
        }

        if(world.getWorldTime()%5==0 && world.getTileEntity(pos) instanceof TileEntityBlastFurnace)
        {
            TileEntityBlastFurnace master = (TileEntityBlastFurnace) world.getTileEntity(pos);
            //if(storeFuel())
            //    master.speedupTick += 600;
        }

        TileEntityBlastFurnace master = (TileEntityBlastFurnace) world.getTileEntity(pos);
        if(master.speedupTick <= 0)
            master.speedupTick = AuraHelper.drainVis(world, pos, 0.05F, false);

        boolean cooking = false;
        if(processTick>0)
        {
            processTick--;
            cooking = true;
            if(speedupTick>0)
                speedupTick--;

            int calc = calculateTime();
            if(processTick > calc)
                processTick = calc;
        }

        if(processTick<=0 && !inputs.isEmpty())
            if(cooking)
            {
                ItemStack inputStack = inputs.get(0);
                InfernalBlastfurnaceRecipe recipe = InfernalBlastfurnaceRecipe.getRecipeForInput(inputStack);
                ItemStack outputStack = recipe.getOutput();
                outputItem(outputStack);

                if(recipe.getBonus()!=null)
                {
                    ItemStack bonus = Utilities.copyStackWithSize(recipe.getBonus(), 0);
                    if(getBellows()==0)
                    {
                        if(this.world.rand.nextInt(4) == 0)
                            bonus.setCount(bonus.getCount() + 1);
                    }
                    else
                        for (int b=0;b<getBellows();b++)
                            if (this.world.rand.nextFloat() < 0.44F)
                                bonus.setCount(bonus.getCount() + 1);
                    outputItem(bonus);
                }

                inputStack.setCount(inputStack.getCount() - ((recipe.getInput() instanceof OreDictStack)? ((OreDictStack)recipe.getInput()).amount : ((ItemStack)recipe.getInput()).getCount()));
                if(inputStack.getCount()>0)
                    inputs.set(0, inputStack);
                else
                    inputs.remove(0);
                cooking = false;
                this.specialFuel = false;
            }
            else
            {
                ItemStack inputStack = inputs.get(0);
                InfernalBlastfurnaceRecipe recipe = InfernalBlastfurnaceRecipe.getRecipeForInput(inputStack);
                if(recipe!=null)
                {
                    this.recipeTime = recipe.getSmeltingTime();
                    this.processTick = calculateTime();
                    if(recipe.isSpecial())
                        this.specialFuel = true;
                }
                else
                    inputs.remove(0);
                cooking = true;
            }
        if(cooking!=this.active)
        {
            this.active = cooking;
            this.world.addBlockEvent(pos, getBlockType(), 3, specialFuel?1:0);
            this.world.addBlockEvent(pos, getBlockType(), 4, active?1:0);
        }

    }*/

    public boolean addStackToInputs(ItemStack stack) {
        for (int i = 0; i < inputs.size(); i++) if (this.inputs.get(i) != null && this.inputs.get(i).isItemEqual(stack)
                && (this.inputs.get(i).getCount() + stack.getCount() <= stack.getMaxStackSize())) {
            this.inputs.get(i).setCount(this.inputs.get(i).getCount() + stack.getCount());
            return true;
        }
        this.inputs.add(stack);
        return true;
    }
    
    void storeFuel() {
        for (int x =         this.getPos().getX() - 5; x < this.getPos().getX() + 5; x++) {
            for (int y =     this.getPos().getY() - 5; y < this.getPos().getY() + 5; y++) {
                for (int z = this.getPos().getZ() - 5; z < this.getPos().getZ() + 5; z++) {
                    TileEntity tile = this.world.getTileEntity(new BlockPos(x, y, z));
                    if ((tile != null) && ((tile instanceof IAspectSource))) {
                        IAspectSource as = (IAspectSource) tile;
                        if ((as.doesContainerContainAmount(Aspect.FIRE, 1)) && (as.takeFromContainer(Aspect.FIRE, 1))) {
                            PacketHandler.INSTANCE.sendToAllAround(
                                    new PacketFXEssentiaSource(
                                            pos,
                                            (byte) (this.getPos().getX() - x),
                                            (byte) (this.getPos().getY() - y),
                                            (byte) (this.getPos().getZ() - z),
                                            Aspect.FIRE.getColor(), 0),
                                    new NetworkRegistry.TargetPoint(
                                            getWorld().provider.getDimension(),
                                            this.getPos().getX(),
                                            this.getPos().getY(),
                                            this.getPos().getZ(),
                                            32.0D));
                            this.fuel += 1;
                        }
                    }
                }
            }
        }
    }


    int getBellows() {
        int bellows = 0;
        for (EnumFacing fd : EnumFacing.HORIZONTALS){
                int bx = pos.getX() + fd.getXOffset() * 2;
                int by = pos.getY() + fd.getYOffset() * 2;
                int bz = pos.getZ() + fd.getZOffset() * 2;
                BlockPos pos1 = new BlockPos(bx, by - 1, bz);
                if (world.getTileEntity(pos1) instanceof TileBellows && (((TileBellows) world.getTileEntity(pos1)).getFacing() == fd.getOpposite()))
                    bellows++;
            }
        return bellows;
    }

    int calculateTime() {
        return Math.max(1, recipeTime / (speedupTick > 0 ? 2 : 1) - getBellows() * 40);
    }

    void outputItem(ItemStack item) {
        TileEntity inventory = this.world.getTileEntity(new BlockPos(pos.getX() + facing.getXOffset() * 2, pos.getY() + 1, pos.getZ() + facing.getZOffset() * 2));
        if ((inventory != null) && ((inventory instanceof IInventory)))
            item = InventoryUtils.insertStackAt(world, pos, this.facing.getOpposite(), item, true);

        if (item != null) {
            EntityItem ei = new EntityItem(
                    this.world,
                    this.getPos().getX() + 0.5D + this.facing.getXOffset() * 1D * 1.66,
                    this.getPos().getY() + 0.2D,
                    this.getPos().getZ() + 0.5D + this.facing.getZOffset() * 1D * 1.66,
                    item.copy());
            ei.motionX = (0.075F * this.facing.getXOffset());
            ei.motionY = 0.025000000372529D;
            ei.motionZ = (0.075F * this.facing.getZOffset());
            this.world.spawnEntity(ei);
        }
        world.addBlockEvent(pos, getBlockType(), 3, 0);
    }

    @Override
    public void update() {
        if (this.world.isRemote)
            return;

        if (facingX == -5) {
            setFacing();
        }

        TileEntityBlastFurnace tile = (TileEntityBlastFurnace) world.getTileEntity(pos);
        if (tile.speedupTick <= 0)
            tile.speedupTick = AuraHelper.drainVis(world, pos, 0.05f, false);

        if (tick <= 80)
            ++tick;
        else
            tick = 0;

        if (fuel < 256)
            storeFuel();

        boolean cooking = false;

        if (processTick > 0 && fuel > 0) {
            processTick--;
            cooking = true;

            if (fuel > 0 && tick == 0) --fuel;

            if (speedupTick > 0) speedupTick--;

            int calc = calculateTime();
            if (processTick > calc) processTick = calc;
        }

        if (processTick <= 0 && !inputs.isEmpty() && fuel > 0)
            if (cooking) {
            ItemStack inputStack = inputs.get(0);
            InfernalBlastfurnaceRecipe recipe = InfernalBlastfurnaceRecipe.getRecipeForInput(inputStack);
            ItemStack outputStack = recipe.getOutput();
            outputItem(outputStack);

            if (recipe.getBonus() != null) {
                ItemStack bonus = Utilities.copyStackWithSize(recipe.getBonus(), 0);
                if (getBellows() == 0) {
                    if (this.world.rand.nextInt(4) == 0) bonus.setCount(bonus.getCount() + 1);
                } else for (int b = 0; b < getBellows(); b++)
                    if (this.world.rand.nextFloat() < 0.44F) bonus.setCount(bonus.getCount() + 1);
                outputItem(bonus);
            }

            inputStack.setCount(inputStack.getCount() - ((recipe.getInput() instanceof OreDictStack) ? ((Utilities.OreDictStack) recipe.getInput()).amount : ((ItemStack) recipe.getInput()).getCount()));
            if (inputStack.getCount() > 0) inputs.set(0, inputStack);
            else inputs.remove(0);
            cooking = false;
            this.specialFuel = false;
        } else {
            ItemStack inputStack = inputs.get(0);
            InfernalBlastfurnaceRecipe recipe = InfernalBlastfurnaceRecipe.getRecipeForInput(inputStack);
            if (recipe != null) {
                this.recipeTime = recipe.getSmeltingTime();
                this.processTick = calculateTime();
                if (recipe.isSpecial()) this.specialFuel = true;
            } else inputs.remove(0);
            cooking = true;
        }

        if (cooking != this.active) {
            this.active = cooking;
            this.world.addBlockEvent(pos, getBlockType(), 3, specialFuel ? 1 : 0);
            this.world.addBlockEvent(pos, getBlockType(), 4, active ? 1 : 0);
        }
    }

    @Override
    public void readCustomNBT(NBTTagCompound tags) {
        fuel = tags.getInteger("fuel");
        speedupTick = tags.getFloat("speedupTick");
        processTick = tags.getInteger("processTick");
        recipeTime = tags.getInteger("recipeTime");
        facing = EnumFacing.byIndex(tags.getInteger("facing")).getOpposite();
        active = tags.getBoolean("active");
        specialFuel = tags.getBoolean("specialFuel");
        tick = tags.getInteger("tick");

        NBTTagList invList = tags.getTagList("inputs", 10);
        inputs.clear();
        for (int i = 0; i < invList.tagCount(); i++)
            inputs.add(new ItemStack(invList.getCompoundTagAt(i)));
    }

    @Override
    public void writeCustomNBT(NBTTagCompound tags) {
        tags.setInteger("fuel", fuel);
        tags.setFloat("speedupTick", speedupTick);
        tags.setInteger("processTick", processTick);
        tags.setInteger("recipeTime", recipeTime);
        tags.setInteger("facing", facing.ordinal());
        tags.setInteger("tick", tick);
        tags.setBoolean("active", active);
        tags.setBoolean("specialFuel", specialFuel);

        NBTTagList invList = new NBTTagList();
        for (ItemStack s : inputs) invList.appendTag(s.writeToNBT(new NBTTagCompound()));
        tags.setTag("inputs", invList);
    }

    @Override
    public boolean isConnectable(EnumFacing enumFacing) {
        return false;
    }

    @Override
    public boolean canInputFrom(EnumFacing fd) {
        return true;
    }

    @Override
    public boolean canOutputTo(EnumFacing enumFacing) {
        return false;
    }

    @Override
    public void setSuction(Aspect aspect, int i) {

    }

    @Override
    public Aspect getSuctionType(EnumFacing enumFacing) {
        return Aspect.FIRE;
    }

    @Override
    public int getSuctionAmount(EnumFacing enumFacing) {
        return 0;
    }

    @Override
    public int takeEssentia(Aspect aspect, int i, EnumFacing enumFacing) {
        return 0;
    }

    @Override
    public int addEssentia(Aspect aspect, int i, EnumFacing enumFacing) {
        return 0;
    }

    @Override
    public int getEssentiaAmount(EnumFacing fd) {
        TileEntity te = world.getTileEntity(pos);
        if (te != null && te instanceof TileEntityBlastFurnace)
            return ((TileEntityBlastFurnace) world.getTileEntity(pos)).fuel;
        return 0;
    }

    @Override
    public Aspect getEssentiaType(EnumFacing fd) {
        return Aspect.FIRE;
    }

    @Override
    public int getMinimumSuction() {
        return 0;
    }

    @Override
    public boolean receiveClientEvent(int i, int j) {
        if (i == 3) {
            if (world.isRemote) {
                for (int a = 0; a < 5; ++a) {
                    FXDispatcher.INSTANCE.furnaceLavaFx(pos.getX(), pos.getY(), pos.getZ(), facingX, facingZ);
                    world.playSound(pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.1f + world.rand.nextFloat() * 0.1f, 0.9f + world.rand.nextFloat() * 0.15f, false);
                }
            }
            return true;
        }
        return super.receiveClientEvent(i, j);
    }
}