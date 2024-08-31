package com.ancient.thaumicgadgets.util.compat.jei.gemcutter;

import com.ancient.thaumicgadgets.init.ModBlocks;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class GemCutterRecipeCategory
        extends AbstractGemCutterRecipeCategory<GemCutterRecipe> {
    private final IDrawable background;
    private final IDrawable icon;
    private final String name;

    public GemCutterRecipeCategory(IGuiHelper helper) {
        super(helper);
        this.background = helper.createDrawable(TEXTURES, 0, 0, 176, 90);
        this.icon = helper.createDrawableIngredient(new ItemStack(Item.getItemFromBlock(ModBlocks.GEMCUTTER)));
        this.name = "GemCutter";
    }


    public IDrawable getBackground() {
        return this.background;
    }


    public String getTitle() {
        return this.name;
    }


    public IDrawable getIcon() {
        return this.icon;
    }


    public String getModName() {
        return "Thaumic Gadgets";
    }


    public String getUid() {
        return "tg.gemcutter";
    }


    public void setRecipe(IRecipeLayout recipeLayout, GemCutterRecipe recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
        stacks.init(0, true, 41, 16);

        stacks.init(3, false, 117, 16);

        stacks.set(ingredients);
    }
}