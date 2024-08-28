 package com.ancient.thaumicgadgets.gui;

 import com.ancient.thaumicgadgets.util.IFunctionLibrary;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.gui.GuiButton;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.util.ResourceLocation;
 
 
 public class GuiTumblerButton
   extends GuiButton
 {
   protected int buttonId;
   protected boolean mode = false;
   public int x;
   public int y;
   public int width;
   public int height;
   private ResourceLocation background;
   private ResourceLocation check;
   private int backX;
   private int backY;
   private int backTexWidth;
   private int backTexHeight;
   private int checkX;
   private int checkY;
   private int checkTexWidth;
   private int checkTexHeight;
   
   public GuiTumblerButton(int id, int x, int y, int width, int height) {
/* 31 */     super(id, x, y, width, height, "");
/* 32 */     this.buttonId = id;
/* 33 */     this.x = x;
/* 34 */     this.y = y;
/* 35 */     this.width = width;
/* 36 */     this.height = height;
   }
 
   
   public void setButtonId(int buttonId) {
/* 41 */     this.buttonId = buttonId;
   }
 
   
   public int getButtonId() {
/* 46 */     return this.buttonId;
   }
 
   
   public GuiTumblerButton addBackground(ResourceLocation loc, int x, int y, int texWidth, int texHeight) {
/* 51 */     this.background = loc;
/* 52 */     this.backX = x;
/* 53 */     this.backY = y;
/* 54 */     this.backTexWidth = texWidth;
/* 55 */     this.backTexHeight = texHeight;
/* 56 */     return this;
   }
 
   
   public GuiTumblerButton addCheck(ResourceLocation loc, int x, int y, int texWidth, int texHeight) {
/* 61 */     this.check = loc;
/* 62 */     this.checkX = x;
/* 63 */     this.checkY = y;
/* 64 */     this.checkTexWidth = texWidth;
/* 65 */     this.checkTexHeight = texHeight;
/* 66 */     return this;
   }
 
 
   
   public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/* 72 */     if (this.visible) {
       
/* 74 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 75 */       GlStateManager.pushMatrix();
       
/* 77 */       mc.renderEngine.bindTexture(this.background);
/* 78 */       drawModalRectWithCustomSizedTexture(this.x, this.y, this.backX, this.backY, this.width, this.height, this.backTexWidth, this.backTexWidth);
/* 79 */       if (this.mode) {
         
/* 81 */         mc.renderEngine.bindTexture(this.check);
/* 82 */         drawModalRectWithCustomSizedTexture(this.x, this.y, this.checkX, this.checkY, this.width, this.height, this.checkTexWidth, this.checkTexWidth);
       } 
       
/* 85 */       GlStateManager.popMatrix();
     } 
   }
 
 
   
   public void func_146118_a(int mouseX, int mouseY) {
/* 92 */     if (IFunctionLibrary.isPointInRegion(this.x, this.y, this.width, this.height, mouseX, mouseY))
     {
/* 94 */       this.mode = !this.mode;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiTumblerButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */