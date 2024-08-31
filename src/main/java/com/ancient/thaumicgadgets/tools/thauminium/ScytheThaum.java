package com.ancient.thaumicgadgets.tools.thauminium;

import com.ancient.thaumicgadgets.tools.ToolScytheBase;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;


public class ScytheThaum extends ToolScytheBase {
    private int cd;
    private int count;
    private float damage;
    private float speed;

    public ScytheThaum(String name, Item.ToolMaterial material, float damage, float speed, int xSize, int ySize, int zSize) {
        super(name, material, xSize, ySize, zSize);

        this.damage = damage;
        this.speed = speed;
    }


    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        ArrayListMultimap<String, AttributeModifier> arrayListMultimap = ArrayListMultimap.create();

        if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {

            arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
            arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
        }

        return arrayListMultimap;
    }
}