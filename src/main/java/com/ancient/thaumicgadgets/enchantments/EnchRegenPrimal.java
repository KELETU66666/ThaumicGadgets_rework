package com.ancient.thaumicgadgets.enchantments;

import com.ancient.thaumicgadgets.init.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchRegenPrimal extends Enchantment {
    public EnchRegenPrimal(String name, Enchantment.Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
        super(rarityIn, typeIn, slots);
        setName(name);
        setRegistryName(new ResourceLocation("thaumicgadgets:" + name));

        ModEnchantments.ECHANTMENTS.add(this);
    }


    public int getMinEnchantability(int enchantmentLevel) {
        return 10 * enchantmentLevel;
    }


    public int getMaxEnchantability(int enchantmentLevel) {
        return getMinEnchantability(enchantmentLevel) + 10;
    }


    public int getMaxLevel() {
        return 4;
    }


    protected boolean canApplyTogether(Enchantment ench) {
        return (super.canApplyTogether(ench) && ench != Enchantments.PROTECTION && ench != Enchantments.FIRE_PROTECTION && ench != Enchantments.PROJECTILE_PROTECTION && ench != Enchantments.BLAST_PROTECTION);
    }


    public boolean isTreasureEnchantment() {
        return false;
    }


    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }


    public boolean isAllowedOnBooks() {
        return false;
    }
}