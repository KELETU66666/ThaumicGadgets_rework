package com.ancient.thaumicgadgets.items.pouches;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;



public class GUIPouch
        extends GuiContainer
{
    private final InventoryPouch inventory;

    public GUIPouch(ContainerPouch inventory) {
        super(inventory);
        this.inventory = inventory.getInv();
    }



    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        ResourceLocation TEXTURE = new ResourceLocation("thaumicgadgets", "textures/gui/pouches/" + this.inventory.getName() + ".png");
        this.mc.getTextureManager().bindTexture(TEXTURE);

        drawTexturedModalRect(this.guiLeft, this.guiTop - 27, 0, 0, this.xSize, this.ySize + 20);
    }

    protected boolean checkHotbarKeys(int par1) {
        return false;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}