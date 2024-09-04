package com.ancient.thaumicgadgets.items.pouches;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

public class GUIPouch extends GuiContainer {
    private final InventoryPouch inventory;

    public GUIPouch(ContainerPouch inventory) {
        super(inventory);
        this.inventory = inventory.getInv();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        ResourceLocation TEXTURE = new ResourceLocation("thaumicgadgets", "textures/gui/pouches/" + this.inventory.getName() + ".png");
        this.mc.getTextureManager().bindTexture(TEXTURE);

        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        this.fontRenderer.drawString(I18n.translateToLocal("container.inventory"), 4, this.ySize - 92, 4210752);
    }

    protected boolean checkHotbarKeys(int par1) {
        return false;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}