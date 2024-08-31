package com.ancient.thaumicgadgets.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;


public class GuiAspectButton extends GuiTumblerButton {
    public ResourceLocation loc;
    public int textureX;
    public int textureY;
    public int textureWidth;
    public int textureHeight;
    private Aspect as;
    private float rColor;
    private float gColor;
    private float bColor;

    public GuiAspectButton(int id, int x, int y, int width, int height, Aspect as, ResourceLocation loc, int textureX, int textureY, int textureWidth, int textureHeight) {
        super(id, x, y, width, height);
        addBackground(as.getImage(), 0, 0, width, height);
        addCheck(loc, textureX, textureY, textureWidth, textureHeight);
        this.as = as;
        this.loc = loc;
        String color = Integer.toHexString(as.getColor());
        this.rColor = Integer.parseInt(color.substring(0, 2), 16) / 255.0F;
        this.gColor = Integer.parseInt(color.substring(2, 4), 16) / 255.0F;
        this.bColor = Integer.parseInt(color.substring(4, 6), 16) / 255.0F;
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


    public Aspect getAspect() {
        return this.as;
    }


    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {

            GlStateManager.pushMatrix();

            GlStateManager.color(this.rColor, this.gColor, this.bColor, 1.0F);
            mc.renderEngine.bindTexture(this.as.getImage());
            GlStateManager.scale(0.5F, 0.5F, 1.0F);
            GlStateManager.enableBlend();
            drawModalRectWithCustomSizedTexture(this.x * 2, this.y * 2, 0.0F, 0.0F, this.width * 2, this.height * 2, 32.0F, 32.0F);
            if (this.mode) {

                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                mc.renderEngine.bindTexture(this.loc);
                drawModalRectWithCustomSizedTexture(this.x * 2, this.y * 2, this.textureX, this.textureY, this.width * 2, this.height * 2, this.textureWidth, this.textureHeight);
            }
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
}