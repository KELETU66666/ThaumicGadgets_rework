package com.ancient.thaumicgadgets.tools.light;

import com.ancient.thaumicgadgets.tools.ToolAxeBase;
import com.ancient.thaumicgadgets.util.IItemAutoRepair;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class AxeLight extends ToolAxeBase implements IItemAutoRepair {
    private int cd;
    private int count;

    public AxeLight(String name, Item.ToolMaterial material, int repairCount, int repairCooldown, float damage, float speed) {
        super(name, material, damage, speed);
        this.cd = repairCooldown;
        this.count = repairCount;
    }


    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!world.isRemote) {

            EntityLivingBase elb = (EntityLivingBase) entity;
            if (CheckTime(stack, world, 0L, 12516L)) {

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