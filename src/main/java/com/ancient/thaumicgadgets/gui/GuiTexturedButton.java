package com.ancient.thaumicgadgets.gui;

import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;


public class GuiTexturedButton extends GuiButton {
    public int buttonId;
    public int x;
    public int y;
    public int width;
    public int height;
    public ResourceLocation loc;
    public int textureX;
    public int textureY;
    public int textureWidth;
    public int textureHeight;

    public GuiTexturedButton(int id, int x, int y, int width, int height, String buttonText, ResourceLocation loc, int textureX, int textureY, int textureWidth, int textureHeight) {
        super(id, x, y, width, height, buttonText);
        this.buttonId = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.loc = loc;
        this.textureX = textureX;
        this.textureY = textureY;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }


    public int getButtonId() {
        return this.buttonId;
    }


    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.pushMatrix();

            mc.renderEngine.bindTexture(this.loc);
            drawModalRectWithCustomSizedTexture(this.x, this.y, this.textureX, this.textureY, this.width, this.height, this.textureWidth, this.textureHeight);

            GlStateManager.popMatrix();

            this.hovered = IFunctionLibrary.isPointInRegion(this.x, this.y, this.width, this.height, mouseX, mouseY);

            drawCenteredString(mc.fontRenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, 14737632);
        }
    }
}