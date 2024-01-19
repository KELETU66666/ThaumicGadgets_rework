package com.ancient.thaumicgadgets.util.compat.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.IngredientStack;
import crafttweaker.api.oredict.IOreDictEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import static crafttweaker.api.minecraft.CraftTweakerMC.getItemStack;

public class TGCrafttweaker
{
	public static void init()
	{
		CraftTweakerAPI.registerClass(InfernalBlastfurnace.class);
	}

	/** Helper Methods */
	public static ItemStack toStack(IItemStack iStack)
	{
		return getItemStack(iStack);
	}
	public static Object toObject(IIngredient iStack)
	{
		if (iStack == null)
			return null;
		else
		{
			if(iStack instanceof IOreDictEntry)
				return ((IOreDictEntry)iStack).getName();
			else if(iStack instanceof IItemStack)
				return getItemStack((IItemStack) iStack);
			else if(iStack instanceof IngredientStack)
			{
				IIngredient ingr = ReflectionHelper.getPrivateValue(IngredientStack.class, (IngredientStack)iStack, "ingredient");
				return toObject(ingr);
			}
			else
				return null;
		}
	}
	public static Object[] toObjects(IIngredient[] iStacks)
	{
		Object[] oA = new Object[iStacks.length];
		for(int i=0; i<iStacks.length; i++)
			oA[i] = toObject(iStacks[i]);
		return oA;
	}
}