 package com.ancient.thaumicgadgets.util;
 
 import net.minecraft.client.gui.FontRenderer;
 import net.minecraft.client.renderer.BufferBuilder;
 import net.minecraft.client.renderer.Tessellator;
 import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
 
 
 public interface IRenderHelper
 {
   public static final int zLevel = 0;
   
   static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
/* 14 */     float f = 0.00390625F;
/* 15 */     float f1 = 0.00390625F;
/* 16 */     Tessellator tessellator = Tessellator.getInstance();
/* 17 */     BufferBuilder bufferbuilder = tessellator.getBuffer();
/* 18 */     bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
/* 19 */     bufferbuilder.pos((x + 0), (y + height), 0.0D).tex(((textureX + 0) * 0.00390625F), ((textureY + height) * 0.00390625F)).endVertex();
/* 20 */     bufferbuilder.pos((x + width), (y + height), 0.0D).tex(((textureX + width) * 0.00390625F), ((textureY + height) * 0.00390625F)).endVertex();
/* 21 */     bufferbuilder.pos((x + width), (y + 0), 0.0D).tex(((textureX + width) * 0.00390625F), ((textureY + 0) * 0.00390625F)).endVertex();
/* 22 */     bufferbuilder.pos((x + 0), (y + 0), 0.0D).tex(((textureX + 0) * 0.00390625F), ((textureY + 0) * 0.00390625F)).endVertex();
/* 23 */     tessellator.draw();
   }
 
   
   static void drawTexturedModalRectCustomSized(int x, int y, int textureX, int textureY, int width, int height, int textureWidth, int textureHeight) {
/* 28 */     float f = 1.0F / textureWidth;
/* 29 */     float f1 = 1.0F / textureHeight;
/* 30 */     Tessellator tessellator = Tessellator.getInstance();
/* 31 */     BufferBuilder bufferbuilder = tessellator.getBuffer();
/* 32 */     bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
/* 33 */     bufferbuilder.pos(x, (y + height), 0.0D).tex((textureX * f), ((textureY + height) * f1)).endVertex();
/* 34 */     bufferbuilder.pos((x + width), (y + height), 0.0D).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
/* 35 */     bufferbuilder.pos((x + width), y, 0.0D).tex(((textureX + width) * f), (textureY * f1)).endVertex();
/* 36 */     bufferbuilder.pos(x, y, 0.0D).tex((textureX * f), (textureY * f1)).endVertex();
/* 37 */     tessellator.draw();
   }
 
   
   static void drawString(FontRenderer fontRendererIn, String text, int x, int y, int color) {
/* 42 */     fontRendererIn.drawStringWithShadow(text, x, y, color);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\IRenderHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */