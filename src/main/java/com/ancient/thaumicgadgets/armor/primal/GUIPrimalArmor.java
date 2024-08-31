package com.ancient.thaumicgadgets.armor.primal;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;


public class GUIPrimalArmor extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("thaumicgadgets", "textures/gui/primal_armor.png");

    private final InventoryPrimalArmor inventory;

    public GUIPrimalArmor(ContainerPrimalArmor inventory) {
        super(inventory);
        this.inventory = inventory.getInv();
    }


    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);

        drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }


    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(this.inventory.getDisplayName().getUnformattedText(), 40, -10, 4210752);
    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}