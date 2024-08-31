package com.ancient.thaumicgadgets.util.compat.jei.gemcutter;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;


public abstract class AbstractGemCutterRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("thaumicgadgets:textures/gui/jei/gemcutter.png");

    protected static final int input = 0;

    protected static final int aspects = 1;
    protected static final int mode = 2;
    protected static final int output = 3;

    public AbstractGemCutterRecipeCategory(IGuiHelper helper) {
        IDrawableStatic process = helper.createDrawable(TEXTURES, 225, 84, 27, 35);
    }
}