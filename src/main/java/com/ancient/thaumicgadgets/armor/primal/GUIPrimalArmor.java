 package com.ancient.thaumicgadgets.armor.primal;

 import net.minecraft.client.gui.inventory.GuiContainer;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.util.ResourceLocation;



 public class GUIPrimalArmor
   extends GuiContainer
 {
/* 12 */   private static final ResourceLocation TEXTURE = new ResourceLocation("tg", "textures/gui/primal_armor.png");

   private final InventoryPrimalArmor inventory;

   public GUIPrimalArmor(ContainerPrimalArmor inventory) {
/* 17 */     super(inventory);
/* 18 */     this.inventory = inventory.getInv();
   }



   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
/* 24 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 25 */     this.mc.getTextureManager().bindTexture(TEXTURE);

/* 27 */     drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
   }



   protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
/* 33 */     this.fontRenderer.drawString(this.inventory.getDisplayName().getUnformattedText(), 40, -10, 4210752);
   }



   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 39 */     super.drawScreen(mouseX, mouseY, partialTicks);
/* 40 */     renderHoveredToolTip(mouseX, mouseY);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\primal\GUIPrimalArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */