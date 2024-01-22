package com.ancient.thaumicgadgets.util.compat.jei;

import com.ancient.thaumicgadgets.objects.machines.gemcutter.GUIGemCutter;
import com.ancient.thaumicgadgets.objects.machines.spinningwheel.ContainerSpinningWheel;
import com.ancient.thaumicgadgets.objects.machines.spinningwheel.GUISpinningWheel;
import com.ancient.thaumicgadgets.util.compat.jei.blast_furnace.BlastFurnaceRecipeCategory;
import com.ancient.thaumicgadgets.util.compat.jei.blast_furnace.BlastFurnaceRecipeMaker;
import com.ancient.thaumicgadgets.util.compat.jei.gemcutter.GemCutterRecipeCategory;
import com.ancient.thaumicgadgets.util.compat.jei.gemcutter.GemCutterRecipeMaker;
import com.ancient.thaumicgadgets.util.compat.jei.spinningwhell.SpinningWheelRecipeCategory;
import com.ancient.thaumicgadgets.util.compat.jei.spinningwhell.SpinningWheelRecipeMaker;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.client.resources.I18n;

import java.util.IllegalFormatException;

@JEIPlugin
public class JEICompat implements IModPlugin {
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IJeiHelpers helpers = registry.getJeiHelpers();
        IGuiHelper gui = helpers.getGuiHelper();

        registry.addRecipeCategories(new SpinningWheelRecipeCategory(gui));
        registry.addRecipeCategories(new BlastFurnaceRecipeCategory(gui));
        registry.addRecipeCategories(new GemCutterRecipeCategory(gui));
    }

    public void register(IModRegistry registry) {
        IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();

        registry.addRecipes(BlastFurnaceRecipeMaker.getRecipes(jeiHelpers), "tg.blast_furnace");

        registry.addRecipes(SpinningWheelRecipeMaker.getRecipes(jeiHelpers), "tg.spinning_wheel");
        registry.addRecipeClickArea(GUISpinningWheel.class, 130, 0, 50, 50, "tg.spinning_wheel");
        recipeTransfer.addRecipeTransferHandler(ContainerSpinningWheel.class, "tg.spinning_wheel", 0, 4, 5, 36);

        registry.addRecipes(GemCutterRecipeMaker.getRecipes(jeiHelpers), "tg.gemcutter");
        registry.addRecipeClickArea(GUIGemCutter.class, 130, 0, 50, 50, "tg.gemcutter");
    }


    public static String translateToLocal(String key) {
        if (I18n.hasKey(key))
        {
            return I18n.format(key);
        }

        return I18n.format(key);
    }
    
    public static String translateToLocalFormatted(String key, Object... format) {
        String s = translateToLocal(key);

        try {
            return String.format(s, format);
        }
        catch (IllegalFormatException e) {

            return "Format Error" + s;
        }
    }
}
