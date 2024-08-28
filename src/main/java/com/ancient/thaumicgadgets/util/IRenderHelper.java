 package com.ancient.thaumicgadgets.util;

 import net.minecraft.client.gui.FontRenderer;
 import net.minecraft.client.renderer.BufferBuilder;
 import net.minecraft.client.renderer.Tessellator;
 import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
 
 
 public interface IRenderHelper
 {
   public static final int zLevel = 0;
   
   static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height) {
       float f = 0.00390625F;
       float f1 = 0.00390625F;
       Tessellator tessellator = Tessellator.getInstance();
       BufferBuilder bufferbuilder = tessellator.getBuffer();
       bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
       bufferbuilder.pos((x + 0), (y + height), 0.0D).tex(((textureX + 0) * 0.00390625F), ((textureY + height) * 0.00390625F)).endVertex();
       bufferbuilder.pos((x + width), (y + height), 0.0D).tex(((textureX + width) * 0.00390625F), ((textureY + height) * 0.00390625F)).endVertex();
       bufferbuilder.pos((x + width), (y + 0), 0.0D).tex(((textureX + width) * 0.00390625F), ((textureY + 0) * 0.00390625F)).endVertex();
       bufferbuilder.pos((x + 0), (y + 0), 0.0D).tex(((textureX + 0) * 0.00390625F), ((textureY + 0) * 0.00390625F)).endVertex();
       tessellator.draw();
   }
 
   
   static void drawTexturedModalRectCustomSized(int x, int y, int textureX, int textureY, int width, int height, int textureWidth, int textureHeight) {
       float f = 1.0F / textureWidth;
       float f1 = 1.0F / textureHeight;
       Tessellator tessellator = Tessellator.getInstance();
       BufferBuilder bufferbuilder = tessellator.getBuffer();
       bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
       bufferbuilder.pos(x, (y + height), 0.0D).tex((textureX * f), ((textureY + height) * f1)).endVertex();
       bufferbuilder.pos((x + width), (y + height), 0.0D).tex(((textureX + width) * f), ((textureY + height) * f1)).endVertex();
       bufferbuilder.pos((x + width), y, 0.0D).tex(((textureX + width) * f), (textureY * f1)).endVertex();
       bufferbuilder.pos(x, y, 0.0D).tex((textureX * f), (textureY * f1)).endVertex();
       tessellator.draw();
   }
 
   
   static void drawString(FontRenderer fontRendererIn, String text, int x, int y, int color) {
    fontRendererIn.drawStringWithShadow(text, x, y, color);
   }
 }