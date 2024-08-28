package com.ancient.thaumicgadgets.util.compat.jei.spinningwhell;

import com.ancient.thaumicgadgets.objects.machines.spinningwheel.SpinningWheelRecipes;
import com.google.common.collect.Lists;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Map;





public class SpinningWheelRecipeMaker
{
    public static List<SpinningWheelRecipe> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        SpinningWheelRecipes instance = SpinningWheelRecipes.getInstance();
        List<SpinningWheelRecipe> jeiRecipes = Lists.newArrayList();

        Map<String, SpinningWheelRecipes.craftingRecipes> list = instance.getDualWorkingList();

        for (Map.Entry<String, SpinningWheelRecipes.craftingRecipes> e : list.entrySet()) {

            SpinningWheelRecipes.craftingRecipes recipe = e.getValue();

            ItemStack input1 = recipe.item1;
            ItemStack input2 = recipe.item2;
            ItemStack input3 = recipe.item3;
            ItemStack input4 = recipe.item4;
            ItemStack output = recipe.result;

            List<ItemStack> inputs = Lists.newArrayList(input1, input2, input3, input4);
            SpinningWheelRecipe swrecipe = new SpinningWheelRecipe(inputs, output);

            jeiRecipes.add(swrecipe);
        }
        return jeiRecipes;
    }
}
