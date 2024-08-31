package com.ancient.thaumicgadgets.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Map;


public interface ICheckEnchantment {
    default boolean canApplyEchantment(ItemStack stack, int enchId, int enchLvl) {
        boolean canApply = true;
        boolean changeLvl = false;
        Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);
        ArrayList<EnchantmentData> ed = new ArrayList<>();

        for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {

            if (e.getKey() == Enchantment.getEnchantmentByID(enchId)) {

                if (e.getValue() < enchLvl) {

                    ed.add(new EnchantmentData(e.getKey(), e.getValue()));
                    changeLvl = true;
                }
                canApply = false;
            }
        }
        if (canApply) {
            stack.addEnchantment(Enchantment.getEnchantmentByID(enchId), enchLvl);
        }
        if (changeLvl) {
            for (EnchantmentData data : ed) {
                changeLvlEnch(stack, data);
            }
        }
        return canApply;
    }


    default boolean canApplyEchantment(ItemStack stack, Enchantment enchType, int enchLvl) {
        boolean canApply = true;
        Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);

        for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {

            if (e.getKey() == enchType) {
                canApply = false;
                break;
            }
        }
        if (canApply) {
            stack.addEnchantment(enchType, enchLvl);
        }
        return canApply;
    }


    static boolean canApplyEchantmentStatic(ItemStack stack, int enchId, int enchLvl) {
        boolean canApply = true;
        boolean changeLvl = false;
        Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);
        ArrayList<EnchantmentData> ed = new ArrayList<>();

        for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {

            if (e.getKey() == Enchantment.getEnchantmentByID(enchId)) {

                if (e.getValue() < enchLvl) {

                    ed.add(new EnchantmentData(e.getKey(), e.getValue()));
                    changeLvl = true;
                }
                canApply = false;
            }
        }
        if (canApply) {
            stack.addEnchantment(Enchantment.getEnchantmentByID(enchId), enchLvl);
        }
        if (changeLvl) {
            for (EnchantmentData data : ed) {
                changeLvlEnchStatic(stack, data);
            }
        }
        return canApply;
    }


    static boolean canApplyEchantmentStatic(ItemStack stack, Enchantment enchType, int enchLvl) {
        boolean canApply = true;
        Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);

        for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {

            if (e.getKey() == enchType) {
                canApply = false;
                break;
            }
        }
        if (canApply) {
            stack.addEnchantment(enchType, enchLvl);
        }
        return canApply;
    }


    default void changeLvlEnch(ItemStack stack, EnchantmentData ed) {
        Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);

        if (ench.get(ed.enchantment) != null) {
            ench.replace(ed.enchantment, ed.enchantmentLevel);
        }
        EnchantmentHelper.setEnchantments(ench, stack);
    }


    static void changeLvlEnchStatic(ItemStack stack, EnchantmentData ed) {
        Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);

        if (ench.get(ed.enchantment) != null) {
            ench.replace(ed.enchantment, ed.enchantmentLevel);
        }
        EnchantmentHelper.setEnchantments(ench, stack);
    }
}