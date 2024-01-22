package com.ancient.thaumicgadgets.util.compat.jei.gemcutter;

import com.ancient.thaumicgadgets.objects.machines.gemcutter.GUIGemCutter;
import com.ancient.thaumicgadgets.util.IRenderHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;


public class GemCutterRecipe implements IRecipeWrapper {
    private final ItemStack input;
    private final AspectList aspects;
    private final int mode;
    private final ItemStack output;

    public GemCutterRecipe(ItemStack input, AspectList aspects, int mode, ItemStack output) {
        this.input = input;
        this.aspects = aspects;
        this.mode = mode;
        this.output = output;
    }


    public void drawInfo(Minecraft mc, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        GlStateManager.pushMatrix();

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        mc.renderEngine.bindTexture(AbstractGemCutterRecipeCategory.TEXTURES);

        int x = GUIGemCutter.gemCoords[this.mode][0];
        int y = GUIGemCutter.gemCoords[this.mode][1];

        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();

        IRenderHelper.drawTexturedModalRect(recipeWidth / 2 - 15, recipeHeight / 2 - 38, x, y, 30, 30);

        int q = 0;
        for (Aspect as : this.aspects.getAspects()) {

            mc.renderEngine.bindTexture(as.getImage());
            String color = Integer.toHexString(as.getColor());
            float rColor = Integer.parseInt(color.substring(0, 2), 16) / 255.0F;
            float gColor = Integer.parseInt(color.substring(2, 4), 16) / 255.0F;
            float bColor = Integer.parseInt(color.substring(4, 6), 16) / 255.0F;
            GlStateManager.color(rColor, gColor, bColor);
            GlStateManager.scale(0.5F, 0.5F, 1.0F);
            IRenderHelper.drawTexturedModalRectCustomSized((recipeWidth / 2 - q * 20 - 8) * 2, (recipeHeight / 2 + 16) * 2, 0, 0, 32, 32, 32, 32);
            GlStateManager.scale(1.5F, 1.5F, 1.0F);
            String s = Integer.toString(this.aspects.getAmount(as));
            IRenderHelper.drawString(mc.fontRenderer, s, Math.round((recipeWidth / 2 - mc.fontRenderer.getStringWidth(s) - 2 - q * 20) * 1.5F), Math.round((recipeHeight / 2 + 0) * 1.5F), as.getColor());
            GlStateManager.scale(1.5F, 1.5F, 1.0F);
            q++;
        }
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();

        GlStateManager.popMatrix();
    }


    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(ItemStack.class, this.input);
        ingredients.setOutput(ItemStack.class, this.output);
    }
}