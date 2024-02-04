package com.ancient.thaumicgadgets.util.compat.jei.blast_furnace;

import com.ancient.thaumicgadgets.objects.machines.blastfurnace.InfernalBlastfurnaceRecipe;
import com.ancient.thaumicgadgets.util.handlers.Utilities.OreDictStack;
import com.google.common.collect.Lists;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class BlastFurnaceRecipeMaker
{
	public static List<BlastFurnaceRecipe> getRecipes(IJeiHelpers helpers) {
		IStackHelper stackHelper = helpers.getStackHelper();
		List<BlastFurnaceRecipe> jeiRecipes = Lists.newArrayList();

		List<InfernalBlastfurnaceRecipe> list = InfernalBlastfurnaceRecipe.recipes;

		for (InfernalBlastfurnaceRecipe sr : list) {
			Object oInput = (sr.getInput() instanceof OreDictStack)? OreDictionary.getOres(((OreDictStack)sr.getInput()).key):sr.getInput();

			ItemStack input1 = oInput instanceof  NonNullList ? (ItemStack) ((NonNullList) oInput).get(0) : (ItemStack) oInput;
			List<ItemStack> outputs = Lists.newArrayList();
			outputs.add(sr.getOutput());
			BlastFurnaceRecipe bfrecipe = new BlastFurnaceRecipe(input1, outputs);
			jeiRecipes.add(bfrecipe);
		}
		return jeiRecipes;
	}
}
