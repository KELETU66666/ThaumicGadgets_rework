package com.ancient.thaumicgadgets.util.compat.jei.blast_furnace;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;


public abstract class AbstractBlastFurnaceRecipeCategory<T extends IRecipeWrapper>
        implements IRecipeCategory<T>
{
    protected static final ResourceLocation TEXTURES = new ResourceLocation("tg:textures/gui/jei/blast_furnace.png");

    protected static final int input1 = 0;

    protected static final int output1 = 1;

    protected static final int output2 = 2;
    protected final IDrawableAnimated animatedProcess;

    public AbstractBlastFurnaceRecipeCategory(IGuiHelper helper) {
        IDrawableStatic process = helper.createDrawable(TEXTURES, 176, 0, 21, 14);
        this.animatedProcess = helper.createAnimatedDrawable(process, 80, IDrawableAnimated.StartDirection.LEFT, false);
    }
}
