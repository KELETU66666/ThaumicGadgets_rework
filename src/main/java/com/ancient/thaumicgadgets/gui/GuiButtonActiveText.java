 package com.ancient.thaumicgadgets.gui;

 import com.ancient.thaumicgadgets.util.IFunctionLibrary;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.gui.FontRenderer;
 import net.minecraft.client.gui.GuiButton;
 import net.minecraft.client.renderer.GlStateManager;

 public class GuiButtonActiveText
   extends GuiButton
 {
   public boolean isActive = false;
/* 13 */   public int assignedNumber = 0;
/* 14 */   private int[] textColor = new int[2];


   public GuiButtonActiveText(int buttonId, int assignedNumber, int x, int y, int widthIn, int heightIn, String buttonText, int textActColor, int textPasColor) {
/* 18 */     super(buttonId, x, y, widthIn, heightIn, buttonText);
/* 19 */     this.textColor[0] = textActColor;
/* 20 */     this.textColor[1] = textPasColor;
/* 21 */     this.assignedNumber = assignedNumber;
   }



   public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 27 */     if (this.visible) {

/* 29 */       FontRenderer fontrenderer = mc.fontRenderer;
/* 30 */       mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
/* 31 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 32 */       this.hovered = IFunctionLibrary.isPointInRegion(this.x, this.y, this.width, this.height, mouseX, mouseY);
/* 33 */       int i = getHoverState(this.hovered);
/* 34 */       GlStateManager.enableBlend();
/* 35 */       GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
/* 36 */       GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
/* 37 */       drawTexturedModalRect(this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
/* 38 */       drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);

/* 40 */       drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, this.isActive ? this.textColor[0] : this.textColor[1]);
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiButtonActiveText.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */