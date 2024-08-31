package com.ancient.thaumicgadgets.armor.light;

import com.ancient.thaumicgadgets.armor.ArmorBase;
import com.ancient.thaumicgadgets.util.IItemAutoRepair;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.items.IWarpingGear;


public class ArmorLight extends ArmorBase implements IWarpingGear, IItemAutoRepair {
    private final int period = 100;
    private final int regenCount = 2;


    public ArmorLight(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, materialIn, renderIndexIn, equipmentSlotIn);
    }


    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (!world.isRemote) {
            if (CheckTime(itemStack, world, 0L, 12516L)) {
                if (itemStack.getItemDamage() > 0) {

                    UpdateDamage(itemStack, player, world, 2, 100);
                }
            }
        }
    }


    public int getWarp(ItemStack itemstack, EntityPlayer player) {
        return -5;
    }
}