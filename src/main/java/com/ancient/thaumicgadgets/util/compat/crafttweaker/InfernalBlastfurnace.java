package com.ancient.thaumicgadgets.util.compat.crafttweaker;

import java.util.List;

import com.ancient.thaumicgadgets.objects.machines.blastfurnace.InfernalBlastfurnaceRecipe;
import com.ancient.thaumicgadgets.util.handlers.Utilities;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.witchinggadgets.InfernalBlastfurnace")
public class InfernalBlastfurnace
{
    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient input, int time, IItemStack bonus, boolean isSpecial)
    {
        Object oInput = TGCrafttweaker.toObject(input);
        if(oInput==null)
            return;
        Object inputStack = (oInput instanceof String)? new Utilities.OreDictStack((String)oInput, input.getAmount()) : (ItemStack)oInput;

        InfernalBlastfurnaceRecipe r = new InfernalBlastfurnaceRecipe(TGCrafttweaker.toStack(output), inputStack, time, isSpecial);
        if(bonus!=null)
            r.addBonus(TGCrafttweaker.toStack(bonus));
        CraftTweakerAPI.apply(new Add(r));
    }

    private static class Add implements IAction
    {
        private final InfernalBlastfurnaceRecipe recipe;
        public Add(InfernalBlastfurnaceRecipe recipe)
        {
            this.recipe = recipe;
        }
        @Override
        public void apply()
        {
            InfernalBlastfurnaceRecipe.addRecipe(recipe);
        }
        @Override
        public String describe()
        {
            return "Adding Infernal Blastfurnace Recipe for " + recipe.getOutput().getDisplayName();
        }
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output)
    {
        CraftTweakerAPI.apply(new Remove(TGCrafttweaker.toStack(output)));
    }
    private static class Remove implements IAction
    {
        private final ItemStack output;
        List<InfernalBlastfurnaceRecipe> removedRecipes;
        public Remove(ItemStack output)
        {
            this.output = output;
        }
        @Override
        public void apply()
        {
            removedRecipes = InfernalBlastfurnaceRecipe.removeRecipes(output);
        }

        @Override
        public String describe()
        {
            return "Removing Infernal Blastfurnace Recipe for " + output.getDisplayName();
        }
    }
}