package com.ancient.thaumicgadgets.objects.machines.extruder;

import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
import com.google.common.collect.Maps;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.common.lib.events.EssentiaHandler;

import java.util.Map;
public class TileEntityExtruderUp
        extends TileEntity implements ITickable {
    private int workTime;
    private int maxWorkTime;
    private int mode;
    private final Map<Aspect, Integer> aspectList = Maps.newHashMap();
    private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;
    public TileEntityExtruderUp() {
        this.workTime = 0;
        this.maxWorkTime = getWorkTime();
        this.mode = 0;
        this.aspectList.put(Aspect.EARTH, 0);
        this.aspectList.put(Aspect.WATER, 0);
        this.aspectList.put(Aspect.FIRE, 0);
    }



    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("WorkTime", (short)this.workTime);
        compound.setInteger("MaxWorkTime", (short)this.maxWorkTime);
        compound.setInteger("Mode", this.mode);
        NBTTagList tagList = new NBTTagList();
        for (Map.Entry<Aspect, Integer> e : this.aspectList.entrySet()) {
            NBTTagCompound tag = new NBTTagCompound();
            compound.setString("aspect", e.getKey().getTag());
            compound.setInteger("count", e.getValue());
            tagList.appendTag(tag);
        }
        compound.setTag("aspects", tagList);
        return compound;
    }


    public boolean canWork() {
        return this.world.isBlockPowered(this.pos);
    }




    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.workTime = compound.getInteger("WorkTime");
        this.maxWorkTime = compound.getInteger("MaxWorkTime");
        this.mode = compound.getInteger("Mode");
        NBTTagList tagList = compound.getTagList("aspects", 10);
        this.aspectList.clear();
        for (int q = 0; q < tagList.tagCount(); q++) {
            NBTTagCompound tag = tagList.getCompoundTagAt(q);
            this.aspectList.put(Aspect.getAspect(compound.getString("aspect")), compound.getInteger("count"));
        }
    }




    @SideOnly(Side.CLIENT)
    public static boolean isWorking(TileEntityExtruderUp ent) {
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
                    case 2:
                        return this.mode;
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
                    case 2:
                        this.mode = value;
                        break;
        }
    }

    public void update() {
        boolean flag = isWorking();
        boolean flag1 = false;
        if (!this.world.isRemote) {
            int dim = this.world.provider.getDimension();
            if (canWork()) {
                if (this.mode == 2) {
                    if (getAspectCount(Aspect.EARTH) < 10 && EssentiaHandler.drainEssentia(this, Aspect.EARTH, null, 10, 1))
                    {
                        this.aspectList.put(Aspect.EARTH, getAspectCount(Aspect.EARTH) + 1);
                    }
                    if (getAspectCount(Aspect.FIRE) < 10 && EssentiaHandler.drainEssentia(this, Aspect.FIRE, null, 10, 1))
                    {
                        this.aspectList.put(Aspect.FIRE, getAspectCount(Aspect.FIRE) + 1);
                    }
                    if (getAspectCount(Aspect.WATER) < 10 && EssentiaHandler.drainEssentia(this, Aspect.WATER, null, 10, 1))
                    {
                        this.aspectList.put(Aspect.WATER, getAspectCount(Aspect.WATER) + 1);
                    }

                    if (this.workTime >= this.maxWorkTime && getAspectCount(Aspect.EARTH) >= 10 && getAspectCount(Aspect.FIRE) >= 10 && getAspectCount(Aspect.WATER) >= 10)
                    {
                        this.workTime = 0;
                        this.aspectList.put(Aspect.EARTH, getAspectCount(Aspect.EARTH) - 10);
                        this.aspectList.put(Aspect.FIRE, getAspectCount(Aspect.FIRE) - 10);
                        this.aspectList.put(Aspect.WATER, getAspectCount(Aspect.WATER) - 10);
                        this.maxWorkTime = getWorkTime();
                        IBlockState iBlockState = this.world.getBlockState(this.pos);
                        EnumFacing enumFacing = (EnumFacing)iBlockState.getValue((IProperty)BlockHorizontal.FACING);
                        EntityItem cobble = null;
                        switch (enumFacing) {
                            case NORTH:
                                cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
                                break;
                                case SOUTH:
                                    cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 1.5D, new ItemStack(getItemFromMode(this.mode), 1));
                                    break;
                                    case EAST:
                                        cobble = new EntityItem(this.world, this.pos.getX() + 1.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
                                        break;
                                        case WEST:
                                            cobble = new EntityItem(this.world, this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
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
                }
                else if (this.workTime >= this.maxWorkTime) {
                    this.workTime = 0;
                    this.maxWorkTime = getWorkTime();
                    IBlockState iBlockState = this.world.getBlockState(this.pos);
                    EnumFacing enumFacing = (EnumFacing)iBlockState.getValue((IProperty)BlockHorizontal.FACING);
                    EntityItem cobble = null;
                    switch (enumFacing) {
                        case NORTH:
                            cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
                            break;
                            case SOUTH:
                                cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 1.5D, new ItemStack(getItemFromMode(this.mode), 1));
                                break;
                                case EAST:
                                    cobble = new EntityItem(this.world, this.pos.getX() + 1.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
                                    break;
                                    case WEST:
                                        cobble = new EntityItem(this.world, this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
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

                this.workTime++;
                IBlockState state = this.world.getBlockState(this.pos);
                EnumFacing face = (EnumFacing)state.getValue((IProperty)BlockHorizontal.FACING);
                if (this.workTime % 7 == 0) {
                    ps.transferData(EnumHandler.CustomParticles.SMOKE, 1, (this.pos.getX() + face.getFrontOffsetX()), this.pos.getY() + 0.8D, (this.pos.getZ() + face.getFrontOffsetZ()), ps.rf.getRandomPartcileVelocity(0.02D), 0.05D, ps.rf.getRandomPartcileVelocity(0.02D), dim);
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



    public Item getItemFromMode(int value) {
        switch (value) {
            case 0:
                return Item.getItemFromBlock(Blocks.COBBLESTONE);
                case 1:
                    return Item.getItemFromBlock(Blocks.STONE);
                    case 2:
                        return Item.getItemFromBlock(Blocks.OBSIDIAN);
        }
        return Item.getItemFromBlock(Blocks.COBBLESTONE);
    }


    public int getAspectCount(Aspect as) {
        if (as == null || !this.aspectList.containsKey(as))
        {
            return 0;
        }
        return this.aspectList.get(as);
    }
}


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\extruder\TileEntityExtruderUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */