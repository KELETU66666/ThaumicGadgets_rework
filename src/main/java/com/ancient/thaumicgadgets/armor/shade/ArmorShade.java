package com.ancient.thaumicgadgets.armor.shade;

import com.ancient.thaumicgadgets.armor.ArmorBase;
import com.ancient.thaumicgadgets.util.IItemAutoRepair;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import thaumcraft.api.items.IWarpingGear;

public class ArmorShade extends ArmorBase implements IWarpingGear, IItemAutoRepair {
    ModelBiped model;
    String location;
    private final int period = 100;
    private final int regenCount = 2;


    public ArmorShade(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, materialIn, renderIndexIn, equipmentSlotIn);
        model = null;
        location = null;
   }

   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
       if (!world.isRemote)
     {
         if (CheckTime(itemStack, world, 12516L, 24000L))
       {
           if (itemStack.getItemDamage() > 0) {
               UpdateDamage(itemStack, player, world, 2, 100);
         }
       }
     }
   }

   public int getWarp(ItemStack itemstack, EntityPlayer player) {
/* 47 */     return 5;
   }
}