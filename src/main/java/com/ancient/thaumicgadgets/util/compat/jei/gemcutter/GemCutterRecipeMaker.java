package com.ancient.thaumicgadgets.util.compat.jei.gemcutter;

import com.ancient.thaumicgadgets.objects.machines.gemcutter.GemCutterRecipes;
import com.google.common.collect.Lists;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.AspectList;

import java.util.List;





public class GemCutterRecipeMaker
{
    public static List<GemCutterRecipe> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        GemCutterRecipes instance = GemCutterRecipes.getInstance();
        List<GemCutterRecipe> jeiRecipes = Lists.newArrayList();

        List<GemCutterRecipes.gemCutterRecipe> list = instance.getRecipeList();

        for (GemCutterRecipes.gemCutterRecipe e : list) {

            ItemStack input = e.input;
            AspectList aspects = e.aspects;
            int mode = e.mode;
            ItemStack output = e.outPut;

            GemCutterRecipe swrecipe = new GemCutterRecipe(input, aspects, mode, output);

            jeiRecipes.add(swrecipe);
        }

        return jeiRecipes;
    }
}
