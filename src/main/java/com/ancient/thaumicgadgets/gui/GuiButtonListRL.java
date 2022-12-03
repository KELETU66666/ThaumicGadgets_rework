 package com.ancient.thaumicgadgets.gui;
 
 import net.minecraft.util.ResourceLocation;
 
 public class GuiButtonListRL
   extends GuiTexturedButton {
/*  7 */   private String buttonSide = "";
 
   
   public GuiButtonListRL(int id, int x, int y, int width, int height, String buttonSide, ResourceLocation loc, int textureX, int textureY, int textureWidth, int textureHeight) {
/* 11 */     super(id, x, y, width, height, "", loc, textureX, textureY, textureWidth, textureHeight);
     
/* 13 */     this.buttonSide = buttonSide;
   }
 
   
   public String getButtonSide() {
/* 18 */     return this.buttonSide;
   }
 
 
 
 
   
   public void setButtonSide(String side) {
/* 26 */     this.buttonSide = side;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiButtonListRL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */