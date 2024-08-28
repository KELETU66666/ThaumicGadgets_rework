/*     */ package com.ancient.thaumicgadgets.gui;
/*     */ 
/*     */

import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiFilterList
/*     */   extends Gui
/*     */ {
/*  19 */   protected static final ResourceLocation TEXTURE = new ResourceLocation("tg", "textures/gui/gui.png");
/*     */   private GuiTextField field;
/*  21 */   public String fieldText = "";
/*  22 */   private GuiButtonListRL[] lrButtons = new GuiButtonListRL[2];
/*     */   private GuiLabel lbl;
/*     */   private final FontRenderer fontRenderer;
/*     */   private int id;
/*     */   public int x;
/*     */   public int y;
/*     */   public int width;
/*     */   public int height;
/*     */   private int backTextureX;
/*     */   private int backTextureY;
/*  32 */   public List<String> displayList = Lists.newArrayList();
/*  33 */   public List<GuiButtonActiveText> buttons = Lists.newArrayList();
/*     */   public int textColor;
/*     */   public boolean isEnabled;
/*     */   public boolean visible;
/*     */   public int currentPage;
/*     */   private int maxPage;
/*     */   public int buttonsPerPage;
/*  40 */   private int choosedButton = -1;
/*     */ 
/*     */   
/*     */   public GuiFilterList(int id, int x, int y, int width, int height, List<String> displayList, int buttonsPerPage, FontRenderer fontRenderer, int textColor, int backTextureX, int backTextureY) {
/*  44 */     this.id = id;
/*  45 */     this.x = x;
/*  46 */     this.y = y;
/*  47 */     this.width = width;
/*  48 */     this.height = height;
/*  49 */     this.backTextureX = backTextureX;
/*  50 */     this.backTextureY = backTextureY;
/*  51 */     this.displayList = displayList;
/*  52 */     this.fontRenderer = fontRenderer;
/*  53 */     this.textColor = textColor;
/*  54 */     int divW = width / 2;
/*  55 */     int divH = height / 2;
/*  56 */     this.lrButtons[0] = new GuiButtonListRL(id + 1, x + divW - 10, y + height - 13, 8, 8, "left", TEXTURE, 198, 142, 256, 256);
/*  57 */     this.lrButtons[1] = new GuiButtonListRL(id + 2, x + divW + 10, y + height - 13, 8, 8, "right", TEXTURE, 174, 142, 256, 256);
/*  58 */     this.field = new GuiTextField(id + 4, fontRenderer, x + 6, y + 6, width - 25, 13);
/*  59 */     this.field.setFocused(true);
/*  60 */     this.buttonsPerPage = buttonsPerPage;
/*  61 */     this.maxPage = 0;
/*  62 */     if (!displayList.isEmpty()) {
/*     */       
/*  64 */       int q = 0;
/*  65 */       int z = 0;
/*  66 */       for (String s : displayList) {
/*     */         
/*  68 */         this.buttons.add(new GuiButtonActiveText(id + 5 + q, q, x + 5, y + 5 + this.field.height + 5 + z * 16, width - 10, 13, s, 12072391, 14737632));
/*  69 */         q++;
/*  70 */         if (++z % buttonsPerPage == 0)
/*  71 */           z = 0; 
/*     */       } 
/*  73 */       this.maxPage = Math.floorDiv(displayList.size(), buttonsPerPage);
/*     */     } 
/*  75 */     this.visible = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawFilterList(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
/*  80 */     if (this.visible) {
/*     */       
/*  82 */       GlStateManager.pushMatrix();
/*     */       
/*  84 */       mc.getTextureManager().bindTexture(TEXTURE);
/*  85 */       GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  86 */       GlStateManager.enableBlend();
/*  87 */       drawTexturedModalRect(this.x, this.y, this.backTextureX, this.backTextureY, this.width, this.height);
/*  88 */       drawTexturedModalRect(this.x + this.width - 16, this.y + 8, 200, 84, 9, 8);
/*  89 */       GlStateManager.disableBlend();
/*     */       
/*  91 */       if (!this.displayList.isEmpty()) {
/*     */         
/*  93 */         this.lrButtons[0].drawButton(mc, mouseX, mouseY, partialTicks);
/*  94 */         this.lrButtons[1].drawButton(mc, mouseX, mouseY, partialTicks);
/*  95 */         this.lbl = new GuiLabel(this.fontRenderer, this.id + 3, this.x + this.width / 2 + 1, this.y + this.height - 12, 8, 8, this.textColor);
/*  96 */         this.lbl.addLine(Integer.toString(this.currentPage));
/*  97 */         this.lbl.drawLabel(mc, mouseX, mouseY);
/*  98 */         this.field.drawTextBox();
/*  99 */         int t = this.currentPage * this.buttonsPerPage;
/* 100 */         int q = 0;
/* 101 */         for (GuiButton b : updateList()) {
/*     */           
/* 103 */           if (q >= t && q < t + this.buttonsPerPage) {
/*     */             
/* 105 */             b.enabled = true;
/* 106 */             b.visible = true;
/* 107 */             b.drawButton(mc, mouseX, mouseY, partialTicks);
/*     */           }
/*     */           else {
/*     */             
/* 111 */             b.enabled = false;
/* 112 */             b.visible = false;
/*     */           } 
/* 114 */           q++;
/*     */         } 
/*     */       } 
/*     */       
/* 118 */       GlStateManager.popMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCurrentPage(int value) {
/* 124 */     if (value >= 0) {
/*     */       
/* 126 */       if (value <= this.maxPage)
/*     */       {
/* 128 */         this.currentPage = value;
/*     */       }
/*     */       else
/*     */       {
/* 132 */         this.currentPage = this.maxPage;
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 137 */       this.currentPage = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void incrPage() {
/* 143 */     if (this.currentPage < this.maxPage) {
/*     */       
/* 145 */       this.currentPage++;
/*     */     }
/* 147 */     else if (this.currentPage == this.maxPage) {
/*     */       
/* 149 */       this.currentPage = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void decrPage() {
/* 154 */     if (this.currentPage > 0) {
/*     */       
/* 156 */       this.currentPage--;
/*     */     }
/* 158 */     else if (this.currentPage == 0) {
/*     */       
/* 160 */       this.currentPage = this.maxPage;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiTextField getField() {
/* 166 */     return this.field;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiLabel getLabel() {
/* 171 */     return this.lbl;
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiButtonListRL[] getLRButtons() {
/* 176 */     return this.lrButtons;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<GuiButtonActiveText> getButtons() {
/* 181 */     return this.buttons;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getId() {
/* 186 */     return this.id;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getChoosedButton() {
/* 191 */     return this.choosedButton;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChoosedButton(int value) {
/* 198 */     if (value < 0)
/*     */     {
/* 200 */       value = -1;
/*     */     }
/* 202 */     if (value >= this.displayList.size())
/*     */     {
/* 204 */       value = this.displayList.size() - 1;
/*     */     }
/* 206 */     this.choosedButton = value;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<GuiButtonActiveText> updateList() {
/* 211 */     List<Integer> afterFilter = filterList();
/* 212 */     List<GuiButtonActiveText> buttons = Lists.newArrayList();
/*     */ 
/*     */     
/* 215 */     int i = 0, q = 0;
/*     */     
/* 217 */     for (GuiButtonActiveText b : this.buttons) {
/*     */       
/* 219 */       if (afterFilter.contains(Integer.valueOf(i))) {
/*     */         
/* 221 */         b.y = this.y + 5 + this.field.height + 5 + q * 16;
/* 222 */         if (++q % this.buttonsPerPage == 0)
/*     */         {
/* 224 */           q = 0;
/*     */         }
/*     */         
/* 227 */         b.enabled = true;
/* 228 */         b.visible = true;
/* 229 */         buttons.add(b);
/*     */       }
/*     */       else {
/*     */         
/* 233 */         b.enabled = false;
/* 234 */         b.visible = false;
/*     */       } 
/* 236 */       i++;
/*     */     } 
/*     */     
/* 239 */     return buttons;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Integer> filterList() {
/* 244 */     List<Integer> dummyList = Lists.newArrayList();
/*     */     
/* 246 */     if (this.fieldText.equals("")) {
/*     */       
/* 248 */       for (int q = 0; q < this.displayList.size(); q++)
/*     */       {
/* 250 */         dummyList.add(Integer.valueOf(q));
/*     */       }
/* 252 */       return dummyList;
/*     */     } 
/*     */ 
/*     */     
/* 256 */     if (!this.displayList.isEmpty())
/*     */     {
/* 258 */       for (int q = 0; q < this.displayList.size(); q++) {
/*     */         
/* 260 */         if (((String)this.displayList.get(q)).toLowerCase().contains(this.fieldText.toLowerCase()))
/*     */         {
/* 262 */           dummyList.add(Integer.valueOf(q));
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 268 */     return dummyList;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiFilterList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */