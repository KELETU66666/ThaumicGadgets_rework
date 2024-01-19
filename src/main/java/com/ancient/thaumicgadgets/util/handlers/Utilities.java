package com.ancient.thaumicgadgets.util.handlers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Utilities {

    public static boolean compareToOreName(ItemStack item, String oreName) {
        for (int oid : OreDictionary.getOreIDs(item))
            if (OreDictionary.getOreName(oid).equalsIgnoreCase(oreName)) return true;
        return false;
    }

    public static ItemStack copyStackWithSize(ItemStack stack, int i) {
        stack.setCount(i);
        if (stack.hasTagCompound())
            stack.setTagCompound(stack.getTagCompound());
        return stack;
    }

    public static class OreDictStack {

        public final String key;
        public final int amount;

        public OreDictStack(String key, int amount) {
            this.key = key;
            this.amount = amount;
        }

        public boolean matches(ItemStack stack) {
            return Utilities.compareToOreName(stack, key) && stack.getCount() >= amount;
        }
    }
}
