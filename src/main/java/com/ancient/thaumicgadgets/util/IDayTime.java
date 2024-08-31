package com.ancient.thaumicgadgets.util;

import net.minecraft.world.World;


public interface IDayTime {
    default int getDayCount(World world) {
        long worldTime = world.getTotalWorldTime();
        return (int) Math.floorDiv(worldTime, 24000L);
    }


    default long getCurrentDayTime(World world) {
        long worldTime = world.getWorldTime();
        return Math.floorMod(worldTime, 24000L);
    }
}