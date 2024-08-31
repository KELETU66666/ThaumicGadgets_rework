package com.ancient.thaumicgadgets.tools.shade;

import com.ancient.thaumicgadgets.tools.ToolShearsBase;
import com.ancient.thaumicgadgets.util.IItemAutoRepair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ShearsShade extends ToolShearsBase implements IItemAutoRepair {
    private int cd;
    private int count;

    public ShearsShade(String name, Item.ToolMaterial material, int repairCount, int repairCooldown) {
        super(name, material);

        this.cd = repairCooldown;
        this.count = repairCount;
    }


    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!world.isRemote) {

            EntityLivingBase elb = (EntityLivingBase) entity;
            if (CheckTime(stack, world, 12516L, 24000L)) {

                if (stack.getItemDamage() > 0) {
                    UpdateDamage(stack, entity, world, this.count, this.cd);
                }

                if (isSelected) {
                    elb.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 110, 0));

                }

            } else if (isSelected) {

                elb.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 110, 0));
            }
        }
    }
}