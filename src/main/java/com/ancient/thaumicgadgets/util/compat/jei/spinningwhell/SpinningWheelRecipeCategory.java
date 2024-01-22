package com.ancient.thaumicgadgets.util.compat.jei.spinningwhell;

import com.ancient.thaumicgadgets.init.ModBlocks;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;




public class SpinningWheelRecipeCategory extends AbstractSpinningWheelRecipeCategory<SpinningWheelRecipe> {
    private final IDrawable background;
    private final IDrawable icon;
    private final String name;

    public SpinningWheelRecipeCategory(IGuiHelper helper) {
        super(helper);
        this.background = helper.createDrawable(TEXTURES, 0, 0, 150, 83);
        this.icon = helper.createDrawableIngredient(new ItemStack(Item.getItemFromBlock(ModBlocks.SPINNING_WHEEL)));
        this.name = "Spinning Wheel";
    }



    public IDrawable getBackground() {
        return this.background;
    }



    public void drawExtras(Minecraft minecraft) {
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        this.animatedProcess.draw(minecraft, 38, 15);
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
    }



    public String getTitle() {
        return this.name;
    }



    public IDrawable getIcon() {return this.icon;
    }




    public String getModName() {
        return "Thaumic Gadgets";
    }



    public String getUid() {
        return "tg.spinning_wheel";
    }



    public void setRecipe(IRecipeLayout recipeLayout, SpinningWheelRecipe recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
        stacks.init(0, true, 18, 8);
        stacks.init(1, true, 18, 24);
        stacks.init(2, true, 18, 41);
        stacks.init(3, true, 18, 57);
        stacks.init(4, false, 117, 39);

        stacks.set(ingredients);
    }
}