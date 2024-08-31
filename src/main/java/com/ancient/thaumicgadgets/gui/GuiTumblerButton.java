package com.ancient.thaumicgadgets.gui;

import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;


public class GuiTumblerButton
        extends GuiButton {
    protected int buttonId;
    protected boolean mode = false;
    public int x;
    public int y;
    public int width;
    public int height;
    private ResourceLocation background;
    private ResourceLocation check;
    private int backX;
    private int backY;
    private int backTexWidth;
    private int backTexHeight;
    private int checkX;
    private int checkY;
    private int checkTexWidth;
    private int checkTexHeight;

    public GuiTumblerButton(int id, int x, int y, int width, int height) {
        super(id, x, y, width, height, "");
        this.buttonId = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }


    public int getButtonId() {
        return this.buttonId;
    }


    public GuiTumblerButton addBackground(ResourceLocation loc, int x, int y, int texWidth, int texHeight) {
        this.background = loc;
        this.backX = x;
        this.backY = y;
        this.backTexWidth = texWidth;
        this.backTexHeight = texHeight;
        return this;
    }


    public GuiTumblerButton addCheck(ResourceLocation loc, int x, int y, int texWidth, int texHeight) {
        this.check = loc;
        this.checkX = x;
        this.checkY = y;
        this.checkTexWidth = texWidth;
        this.checkTexHeight = texHeight;
        return this;
    }


    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.pushMatrix();

            mc.renderEngine.bindTexture(this.background);
            drawModalRectWithCustomSizedTexture(this.x, this.y, this.backX, this.backY, this.width, this.height, this.backTexWidth, this.backTexWidth);
            if (this.mode) {

                mc.renderEngine.bindTexture(this.check);
                drawModalRectWithCustomSizedTexture(this.x, this.y, this.checkX, this.checkY, this.width, this.height, this.checkTexWidth, this.checkTexWidth);
            }
            GlStateManager.popMatrix();
        }
    }


    public void mouseReleased(int mouseX, int mouseY) {
        if (IFunctionLibrary.isPointInRegion(this.x, this.y, this.width, this.height, mouseX, mouseY)) {
            this.mode = !this.mode;
        }
    }
}