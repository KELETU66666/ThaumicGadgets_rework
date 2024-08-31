package com.ancient.thaumicgadgets.objects.machines.spinningwheel;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;


public class GUISpinningWheel extends GuiContainer {
    private static final ResourceLocation TEXTURES = new ResourceLocation("thaumicgadgets:textures/gui/spinning_wheel.png");

    private final InventoryPlayer player;
    private final TileEntitySpinningWheel tileentity;

    public GUISpinningWheel(InventoryPlayer player, TileEntitySpinningWheel tileentity) {
        super(new ContainerSpinningWheel(player, tileentity));
        this.player = player;
        this.tileentity = tileentity;
    }


    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
    }


    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        int l = getWorkProgressScaled(63);
        drawTexturedModalRect(this.guiLeft + 38, this.guiTop + 15, 176, 0, l, 53);
    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }


    private int getWorkProgressScaled(int pixels) {
        int i = this.tileentity.getField(0);
        int j = this.tileentity.getField(1);

        return (j != 0 && i != 0) ? (i * pixels / j) : 0;
    }
}