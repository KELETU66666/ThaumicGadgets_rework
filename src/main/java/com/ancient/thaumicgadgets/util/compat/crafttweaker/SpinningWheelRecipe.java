package com.ancient.thaumicgadgets.util.compat.crafttweaker;

import com.ancient.thaumicgadgets.objects.machines.spinningwheel.SpinningWheelRecipes;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.thaumicgadgets.SpinningWheel")
public class SpinningWheelRecipe {

        @ZenMethod
        public static void addRecipe(String name, IItemStack input1, IItemStack input2, IItemStack input3, IItemStack input4, IItemStack output, int experience) {
            CraftTweakerAPI.apply(new AddRecipe(SpinningWheelRecipes.INSTANCE, name, input1, input2, input3, input4, output, experience));
        }

        @ZenMethod
        public static void removeRecipe(IItemStack output) {
            CraftTweakerAPI.apply(new RemoveRecipe(SpinningWheelRecipes.INSTANCE, output));
        }

    private static final class AddRecipe implements IAction {
        private final SpinningWheelRecipes recipes;
        private final String name;
        private final ItemStack input1;
        private final ItemStack input2;
        private final ItemStack input3;
        private final ItemStack input4;
        private final ItemStack output;
        private final int experience;

        private AddRecipe(SpinningWheelRecipes recipes, String name, IItemStack input1, IItemStack input2, IItemStack input3, IItemStack input4,IItemStack output, int experience) {
            this.recipes = recipes;
            this.name = name;
            this.input1   = CraftTweakerMC.getItemStack(input1);
            this.input2   = CraftTweakerMC.getItemStack(input2);
            this.input3  = CraftTweakerMC.getItemStack(input3);
            this.input4   = CraftTweakerMC.getItemStack(input4);
            this.output  = CraftTweakerMC.getItemStack(output);
            this.experience = experience;
        }

        @Override
        public void apply() {
            recipes.addSpinningWheelRecipe(name, input1, input2, input3, input4, output, experience);
        }

        @Override
        public String describe() {
            return recipes.getClass().getSimpleName() + ": Adding recipe (recipeName: " +  name + " ) -> (input: " + input1.toString() + input2.toString() + input3.toString() + input4.toString() +") -> (output: " + output.toString() + ") -> (experience: " + experience +")";
        }
    }

    private static class RemoveRecipe implements IAction {
        public final SpinningWheelRecipes recipes;
        public final ItemStack item;

        public RemoveRecipe(SpinningWheelRecipes recipes, IItemStack item) {
            this.recipes = recipes;
            this.item = CraftTweakerMC.getItemStack(item);
        }

        @Override
        public String describe() {
            return recipes.getClass().getSimpleName() + ": " + getClass().getSimpleName() + " " + item.getItem().getRegistryName();
        }

        @Override
        public void apply() {
            recipes.removeSpinningWheelRecipe(item);
        }
    }
}