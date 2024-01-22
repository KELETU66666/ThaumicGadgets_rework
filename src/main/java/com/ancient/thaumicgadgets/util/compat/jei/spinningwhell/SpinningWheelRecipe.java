package com.ancient.thaumicgadgets.util.compat.jei.spinningwhell;

import com.ancient.thaumicgadgets.objects.machines.spinningwheel.SpinningWheelRecipes;
import com.ancient.thaumicgadgets.util.compat.jei.JEICompat;
import java.awt.Color;
import java.util.List;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;



public class SpinningWheelRecipe implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public SpinningWheelRecipe(List<ItemStack> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }



    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(ItemStack.class, this.inputs);
        ingredients.setOutput(ItemStack.class, this.output);
    }



    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        SpinningWheelRecipes recipes = SpinningWheelRecipes.getInstance();

        float experience = recipes.getWorkExperience(this.output);

        if (experience > 0.0F) {

            String experienceString = JEICompat.translateToLocalFormatted("gui.jei.category.smelting.experience", new Object[] { Float.valueOf(experience) });
            FontRenderer renderer = minecraft.fontRenderer;
            int stringWidth = renderer.getStringWidth(experienceString);
            renderer.drawString(experienceString, recipeWidth - stringWidth, 0, Color.GRAY.getRGB());
        }
    }
}
