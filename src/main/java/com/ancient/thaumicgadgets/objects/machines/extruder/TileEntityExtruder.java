package com.ancient.thaumicgadgets.objects.machines.extruder;

import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class TileEntityExtruder extends TileEntity implements ITickable {
    private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;
    private int workTime = 0;
    private int maxWorkTime = getWorkTime();

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("WorkTime", (short)this.workTime);
        compound.setInteger("MaxWorkTime", (short)this.maxWorkTime);

        return compound;
    }

    public boolean canWork() {
        return this.world.isBlockPowered(this.pos);
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        this.workTime = compound.getInteger("WorkTime");
        this.maxWorkTime = compound.getInteger("MaxWorkTime");
    }

    @SideOnly(Side.CLIENT)
    public static boolean isWorking(TileEntityExtruder ent) {
        return (ent.getField(0) > 0);
    }

    public boolean isWorking() {
        return (this.workTime > 0);
    }

    public int getWorkTime() {
        return 100;
    }

    public int getField(int id) {
        switch (id) {

            case 0:
                return this.workTime;
                case 1:
                    return this.maxWorkTime;
        }
        return 0;
    }

    public void setField(int id, int value) {
        switch (id) {

            case 0:
                this.workTime = value;
                break;
                case 1:
                    this.maxWorkTime = value;
                    break;
        }
    }

    public void update() {
        boolean flag = isWorking();
        boolean flag1 = false;

        if (!this.world.isRemote) {

            int dim = this.world.provider.getDimension();
            if (canWork()) {

                IBlockState state = this.world.getBlockState(this.pos);
                EnumFacing face = (EnumFacing)state.getValue((IProperty)BlockHorizontal.FACING);
                this.workTime++;

                if (this.workTime % 7 == 0)
                {
                    ps.transferData(EnumHandler.CustomParticles.SMOKE, 1, (this.pos.getX() + face.getFrontOffsetX()), this.pos.getY() + 0.1D, (this.pos.getZ() + face.getFrontOffsetZ()), ps.rf.getRandomPartcileVelocity(0.02D), 0.05D, ps.rf.getRandomPartcileVelocity(0.02D), dim);
                }
                if (this.workTime >= this.maxWorkTime) {

                    this.workTime = 0;
                    this.maxWorkTime = getWorkTime();
                    EntityItem cobble = null;
                    switch (face) {

                        case NORTH:
                            cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
                            break;
                            case SOUTH:
                                cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 1.5D, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
                                break;
                                case EAST:
                                    cobble = new EntityItem(this.world, this.pos.getX() + 1.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
                                    break;
                                    case WEST:
                                        cobble = new EntityItem(this.world, this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
                                        break;
                    }


                    cobble.motionX = 0.025D;
                    cobble.motionY = 0.075D;
                    cobble.motionZ = 0.025D;
                    ps.transferData(EnumParticleTypes.LAVA, RandomFunctions.rand.nextInt(5) + 1, cobble.posX, cobble.posY, cobble.posZ, dim);
                    ps.transferData(EnumParticleTypes.SMOKE_NORMAL, RandomFunctions.rand.nextInt(5) + 1, cobble.posX, cobble.posY, cobble.posZ, dim);
                    this.world.spawnEntity(cobble);
                    flag1 = true;
                }
            } else {

                this.workTime = 0;
            }  if (flag == isWorking())
            {
                flag1 = true;
            }
        }
        if (flag1)
        {
            markDirty();
        }
    }
}
