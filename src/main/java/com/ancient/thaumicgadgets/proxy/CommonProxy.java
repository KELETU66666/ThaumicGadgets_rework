package com.ancient.thaumicgadgets.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;


public class CommonProxy
{
    public void registerItemRenderer(Item item, int meta, String id) {}
    public void init() {}
    public void preInit() {
    }
    public void postInit() {}

    public void createFurnaceOutputBlobFx(World worldObj, int x, int y, int z, EnumFacing facing) {}
}