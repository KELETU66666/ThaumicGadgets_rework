package com.ancient.thaumicgadgets.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;


public interface IItemAutoRepair
        extends IDayTime {
    default boolean CheckTime(ItemStack stack, World world, long repairAtMin, long repairAtMax) {
        if (getCurrentDayTime(world) > repairAtMin && getCurrentDayTime(world) < repairAtMax) {
            return true;
        }
        return false;
    }


    default void UpdateDamage(ItemStack stack, Entity entity, World world, int repairCount, int repairCooldown) {
        if (!stack.hasTagCompound()) {

            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setLong("lastRepairTick", 0L);
            stack.setTagCompound(nBTTagCompound);
        }

        NBTTagCompound nbt = stack.getTagCompound();
        long lastTick = nbt.getLong("lastRepairTick");
        if (lastTick + repairCooldown < world.getTotalWorldTime()) {

            stack.damageItem(-repairCount, (EntityLivingBase) entity);
            nbt.setLong("lastRepairTick", world.getTotalWorldTime());
            stack.setTagCompound(nbt);
        }
    }
}