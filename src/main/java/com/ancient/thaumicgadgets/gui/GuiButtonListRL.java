package com.ancient.thaumicgadgets.gui;

import net.minecraft.util.ResourceLocation;

public class GuiButtonListRL
        extends GuiTexturedButton {
    private String buttonSide = "";


    public GuiButtonListRL(int id, int x, int y, int width, int height, String buttonSide, ResourceLocation loc, int textureX, int textureY, int textureWidth, int textureHeight) {
        super(id, x, y, width, height, "", loc, textureX, textureY, textureWidth, textureHeight);

        this.buttonSide = buttonSide;
    }


    public String getButtonSide() {
        return this.buttonSide;
    }


    public void setButtonSide(String side) {
        this.buttonSide = side;
    }
}