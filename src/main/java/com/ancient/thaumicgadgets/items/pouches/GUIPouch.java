 package com.ancient.thaumicgadgets.items.pouches;
 
 import net.minecraft.client.gui.inventory.GuiContainer;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.util.ResourceLocation;
 
 
 
 public class GUIPouch
   extends GuiContainer
 {
   private final InventoryPouch inventory;
   
   public GUIPouch(ContainerPouch inventory) {
/* 15 */     super(inventory);
/* 16 */     this.inventory = inventory.getInv();
   }
 
 
   
   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
/* 22 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 23 */     ResourceLocation TEXTURE = new ResourceLocation("tg", "textures/gui/pouches/" + this.inventory.getName() + ".png");
/* 24 */     this.mc.getTextureManager().bindTexture(TEXTURE);
     
/* 26 */     drawTexturedModalRect(this.guiLeft, this.guiTop - 27, 0, 0, this.xSize, this.ySize + 20);
   }

     protected boolean checkHotbarKeys(int par1) {
         return false;
     }
   
   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 32 */     super.drawScreen(mouseX, mouseY, partialTicks);
/* 33 */     renderHoveredToolTip(mouseX, mouseY);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\pouches\GUIPouch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */