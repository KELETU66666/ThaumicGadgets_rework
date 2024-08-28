/*     */ package com.ancient.thaumicgadgets.gui;
/*     */ 
/*     */

import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiSwitchButton
/*     */   extends GuiButton
/*     */ {
/*     */   public int buttonId;
/*     */   public int x;
/*     */   public int y;
/*     */   public int width;
/*     */   public int height;
/*     */   public List<String> buttonText;
/*     */   public ResourceLocation loc;
/*     */   public int textureX;
/*     */   public int textureY;
/*     */   public int textureWidth;
/*     */   public int textureHeight;
/*     */   public int switchc;
/*     */   
/*     */   public GuiSwitchButton(int id, int switchc, int x, int y, int width, int height, List<String> buttonText, ResourceLocation loc, int textureX, int textureY, int textureWidth, int textureHeight) {
/*  30 */     super(id, x, y, width, height, buttonText.get(switchc));
/*  31 */     this.buttonId = id;
/*  32 */     this.x = x;
/*  33 */     this.y = y;
/*  34 */     this.width = width;
/*  35 */     this.height = height;
/*  36 */     this.buttonText = buttonText;
/*  37 */     this.loc = loc;
/*  38 */     this.textureX = textureX;
/*  39 */     this.textureY = textureY;
/*  40 */     this.textureWidth = textureWidth;
/*  41 */     this.textureHeight = textureHeight;
/*  42 */     this.switchc = switchc;
/*     */   }
/*     */   
/*     */   public void setButtonId(int buttonId) {
/*  46 */     this.buttonId = buttonId;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getButtonId() {
/*  51 */     return this.buttonId;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSwitchValue(int value) {
/*  56 */     if (value >= 0) {
/*     */       
/*  58 */       if (value <= this.buttonText.size() - 1)
/*     */       {
/*  60 */         this.switchc = value;
/*     */       }
/*     */       else
/*     */       {
/*  64 */         this.switchc = this.buttonText.size() - 1;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  69 */       this.switchc = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSwitchValue() {
/*  75 */     return this.switchc;
/*     */   }
/*     */ 
/*     */   
/*     */   public void incSwitchValue() {
/*  80 */     if (this.switchc < this.buttonText.size() - 1) {
/*     */       
/*  82 */       this.switchc++;
/*     */     }
/*  84 */     else if (this.switchc == this.buttonText.size() - 1) {
/*     */       
/*  86 */       this.switchc = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void decrSwitchValue() {
/*  93 */     if (this.switchc > 0) {
/*     */       
/*  95 */       this.switchc--;
/*     */     }
/*  97 */     else if (this.switchc == 0) {
/*     */       
/*  99 */       this.switchc = this.buttonText.size() - 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 107 */     if (this.visible) {
/*     */       
/* 109 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 110 */       GlStateManager.pushMatrix();
/*     */       
/* 112 */       mc.renderEngine.bindTexture(this.loc);
/* 113 */       drawModalRectWithCustomSizedTexture(this.x, this.y, this.textureX, this.textureY, this.width, this.height, this.textureWidth, this.textureHeight);
/*     */       
/* 115 */       GlStateManager.popMatrix();
/*     */       
/* 117 */       this.hovered = IFunctionLibrary.isPointInRegion(this.x, this.y, this.width, this.height, mouseX, mouseY);
/*     */       
/* 119 */       drawCenteredString(mc.fontRenderer, this.buttonText.get(this.switchc), this.x + this.width / 2, this.y + (this.height - 8) / 2, 14737632);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiSwitchButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */