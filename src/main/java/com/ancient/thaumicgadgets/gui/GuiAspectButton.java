 package com.ancient.thaumicgadgets.gui;
 
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.util.ResourceLocation;
 import thaumcraft.api.aspects.Aspect;
 
 
 public class GuiAspectButton
   extends GuiTumblerButton
 {
   public ResourceLocation loc;
   public int textureX;
   public int textureY;
   public int textureWidth;
   public int textureHeight;
   private Aspect as;
   private float rColor;
   private float gColor;
   private float bColor;
   
   public GuiAspectButton(int id, int x, int y, int width, int height, Aspect as, ResourceLocation loc, int textureX, int textureY, int textureWidth, int textureHeight) {
/* 23 */     super(id, x, y, width, height);
/* 24 */     addBackground(as.getImage(), 0, 0, width, height);
/* 25 */     addCheck(loc, textureX, textureY, textureWidth, textureHeight);
/* 26 */     this.as = as;
/* 27 */     this.loc = loc;
/* 28 */     String color = Integer.toHexString(as.getColor());
/* 29 */     this.rColor = Integer.parseInt(color.substring(0, 2), 16) / 255.0F;
/* 30 */     this.gColor = Integer.parseInt(color.substring(2, 4), 16) / 255.0F;
/* 31 */     this.bColor = Integer.parseInt(color.substring(4, 6), 16) / 255.0F;
/* 32 */     this.textureX = textureX;
/* 33 */     this.textureY = textureY;
/* 34 */     this.textureWidth = textureWidth;
/* 35 */     this.textureHeight = textureHeight;
   }
   
   public void setButtonId(int buttonId) {
/* 39 */     this.buttonId = buttonId;
   }
 
   
   public int getButtonId() {
/* 44 */     return this.buttonId;
   }
 
   
   public float getBlueColor() {
/* 49 */     return this.bColor;
   }
 
   
   public float getRedColor() {
/* 54 */     return this.rColor;
   }
 
   
   public float getGColor() {
/* 59 */     return this.gColor;
   }
   
   public Aspect getAspect() {
/* 63 */     return this.as;
   }
 
 
   
   public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 69 */     if (this.visible) {
       
/* 71 */       GlStateManager.pushMatrix();
       
/* 73 */       GlStateManager.color(this.rColor, this.gColor, this.bColor, 1.0F);
/* 74 */       mc.renderEngine.bindTexture(this.as.getImage());
/* 75 */       GlStateManager.scale(0.5F, 0.5F, 1.0F);
/* 76 */       GlStateManager.enableBlend();
/* 77 */       drawModalRectWithCustomSizedTexture(this.x * 2, this.y * 2, 0.0F, 0.0F, this.width * 2, this.height * 2, 32.0F, 32.0F);
/* 78 */       if (this.mode) {
         
/* 80 */         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 81 */         mc.renderEngine.bindTexture(this.loc);
/* 82 */         drawModalRectWithCustomSizedTexture(this.x * 2, this.y * 2, this.textureX, this.textureY, this.width * 2, this.height * 2, this.textureWidth, this.textureHeight);
       } 
/* 84 */       GlStateManager.disableBlend();
       
/* 86 */       GlStateManager.popMatrix();
     } 
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiAspectButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */