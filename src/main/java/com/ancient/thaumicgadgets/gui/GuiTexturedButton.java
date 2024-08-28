 package com.ancient.thaumicgadgets.gui;

 import com.ancient.thaumicgadgets.util.IFunctionLibrary;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.gui.GuiButton;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.util.ResourceLocation;
 
 
 
 public class GuiTexturedButton
   extends GuiButton
 {
   public int buttonId;
   public int x;
   public int y;
   public int width;
   public int height;
   public ResourceLocation loc;
   public int textureX;
   public int textureY;
   public int textureWidth;
   public int textureHeight;
   
   public GuiTexturedButton(int id, int x, int y, int width, int height, String buttonText, ResourceLocation loc, int textureX, int textureY, int textureWidth, int textureHeight) {
/* 26 */     super(id, x, y, width, height, buttonText);
/* 27 */     this.buttonId = id;
/* 28 */     this.x = x;
/* 29 */     this.y = y;
/* 30 */     this.width = width;
/* 31 */     this.height = height;
/* 32 */     this.loc = loc;
/* 33 */     this.textureX = textureX;
/* 34 */     this.textureY = textureY;
/* 35 */     this.textureWidth = textureWidth;
/* 36 */     this.textureHeight = textureHeight;
   }
   
   public void setButtonId(int buttonId) {
/* 40 */     this.buttonId = buttonId;
   }
 
   
   public int getButtonId() {
/* 45 */     return this.buttonId;
   }
 
 
 
 
   
   public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 53 */     if (this.visible) {
       
/* 55 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 56 */       GlStateManager.pushMatrix();
       
/* 58 */       mc.renderEngine.bindTexture(this.loc);
/* 59 */       drawModalRectWithCustomSizedTexture(this.x, this.y, this.textureX, this.textureY, this.width, this.height, this.textureWidth, this.textureHeight);
       
/* 61 */       GlStateManager.popMatrix();
       
/* 63 */       this.hovered = IFunctionLibrary.isPointInRegion(this.x, this.y, this.width, this.height, mouseX, mouseY);
       
/* 65 */       drawCenteredString(mc.fontRenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, 14737632);
     } 
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiTexturedButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */