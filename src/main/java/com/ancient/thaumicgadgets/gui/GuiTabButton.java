 package com.ancient.thaumicgadgets.gui;

 import com.ancient.thaumicgadgets.util.IFunctionLibrary;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.gui.GuiButton;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.util.ResourceLocation;



 public class GuiTabButton
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
   public int textureXAct;
   public int textureYAct;
   public int textureWidth;
   public int textureHeight;
   public boolean isActive;

   public GuiTabButton(int id, boolean isActive, int x, int y, int width, int height, String buttonText, ResourceLocation loc, int textureX, int textureY, int textureXAct, int textureYAct, int textureWidth, int textureHeight) {
/* 29 */     super(id, x, y, width, height, buttonText);
/* 30 */     this.buttonId = id;
/* 31 */     this.isActive = isActive;
/* 32 */     this.x = x;
/* 33 */     this.y = y;
/* 34 */     this.width = width;
/* 35 */     this.height = height;
/* 36 */     this.loc = loc;
/* 37 */     this.textureX = textureX;
/* 38 */     this.textureY = textureY;
/* 39 */     this.textureXAct = textureXAct;
/* 40 */     this.textureYAct = textureYAct;
/* 41 */     this.textureWidth = textureWidth;
/* 42 */     this.textureHeight = textureHeight;
   }

   public void setButtonId(int buttonId) {
/* 46 */     this.buttonId = buttonId;
   }


   public int getButtonId() {
/* 51 */     return this.buttonId;
   }



   public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 57 */     if (this.visible) {

/* 59 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 60 */       GlStateManager.pushMatrix();

/* 62 */       mc.renderEngine.bindTexture(this.loc);
/* 63 */       if (!this.isActive) {

/* 65 */         drawModalRectWithCustomSizedTexture(this.x, this.y, this.textureX, this.textureY, this.width, this.height, this.textureWidth, this.textureHeight);
       }
       else {

/* 69 */         drawModalRectWithCustomSizedTexture(this.x, this.y, this.textureXAct, this.textureYAct, this.width, this.height, this.textureWidth, this.textureHeight);
       }

/* 72 */       GlStateManager.popMatrix();

/* 74 */       this.hovered = IFunctionLibrary.isPointInRegion(this.x, this.y, this.width, this.height, mouseX, mouseY);

/* 76 */       drawCenteredString(mc.fontRenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, 14737632);
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiTabButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */