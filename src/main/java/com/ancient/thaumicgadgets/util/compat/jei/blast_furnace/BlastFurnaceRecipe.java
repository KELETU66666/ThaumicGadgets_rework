package com.ancient.thaumicgadgets.util.compat.jei.blast_furnace;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.List;



public class BlastFurnaceRecipe implements IRecipeWrapper
{
    private final ItemStack input;
    private final List<ItemStack> outputs;

    public BlastFurnaceRecipe(ItemStack input, List<ItemStack> outputs) {

        this.input = input;

        this.outputs = outputs;
    }

    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(ItemStack.class, this.input);
        ingredients.setOutputs(ItemStack.class, this.outputs);
    }
}