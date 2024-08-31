package com.ancient.thaumicgadgets.gui;

import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class GuiButtonActiveText extends GuiButton {
    public boolean isActive = false;
    public int assignedNumber = 0;
    private int[] textColor = new int[2];


    public GuiButtonActiveText(int buttonId, int assignedNumber, int x, int y, int widthIn, int heightIn, String buttonText, int textActColor, int textPasColor) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
        this.textColor[0] = textActColor;
        this.textColor[1] = textPasColor;
        this.assignedNumber = assignedNumber;
    }


    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {

            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = IFunctionLibrary.isPointInRegion(this.x, this.y, this.width, this.height, mouseX, mouseY);
            int i = getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            drawTexturedModalRect(this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
            drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);

            drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, this.isActive ? this.textColor[0] : this.textColor[1]);
        }
    }
}