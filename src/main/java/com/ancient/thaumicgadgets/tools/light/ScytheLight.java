package com.ancient.thaumicgadgets.tools.light;

import com.ancient.thaumicgadgets.tools.ToolScytheBase;
import com.ancient.thaumicgadgets.util.IItemAutoRepair;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class ScytheLight extends ToolScytheBase implements IItemAutoRepair {
    private int cd;
    private int count;
    private float damage;
    private float speed;

    public ScytheLight(String name, Item.ToolMaterial material, int repairCount, int repairCooldown, float damage, float speed, int xSize, int ySize, int zSize) {
        super(name, material, xSize, ySize, zSize);

        this.cd = repairCooldown;
        this.count = repairCount;
        this.damage = damage;
        this.speed = speed;
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


    public Multimap<String, AttributeModifier> func_111205_h(EntityEquipmentSlot equipmentSlot) {
        ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();

        if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {

            arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
            arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
        }

        return (Multimap<String, AttributeModifier>) arrayListMultimap;
    }
}