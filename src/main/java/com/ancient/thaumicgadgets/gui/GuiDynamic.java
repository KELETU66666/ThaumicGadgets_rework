/*     */ package com.ancient.thaumicgadgets.gui;
/*     */ 
/*     */

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/*     */ 
/*     */ public class GuiDynamic
/*     */   extends GuiScreen
/*     */ {
/*  19 */   protected Map<Integer, Tab> tabsList = Maps.newHashMap();
/*     */   
/*  21 */   protected int currentTabId = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void keyTyped(char typedChar, int keyCode) throws IOException {
/*  31 */     super.keyTyped(typedChar, keyCode);
/*     */     
/*  33 */     for (Map.Entry<Integer, Tab> e : this.tabsList.entrySet()) {
/*     */       
/*  35 */       if (this.currentTabId == ((Integer)e.getKey()).intValue()) {
/*     */         
/*  37 */         for (Map.Entry<GuiTextField, String> ev : ((Tab)e.getValue()).textFields.entrySet())
/*     */         {
/*  39 */           ((GuiTextField)ev.getKey()).textboxKeyTyped(typedChar, keyCode);
/*     */         }
/*  41 */         for (GuiFilterList fl : ((Tab)e.getValue()).filterList)
/*     */         {
/*  43 */           fl.getField().textboxKeyTyped(typedChar, keyCode);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
/*  52 */     if (mouseButton == 0)
/*     */     {
/*  54 */       for (Map.Entry<Integer, Tab> e : this.tabsList.entrySet()) {
/*     */         
/*  56 */         if (((Tab)e.getValue()).but.mousePressed(this.mc, mouseX, mouseY))
/*     */         {
/*  58 */           this.currentTabId = ((Integer)e.getKey()).intValue();
/*     */         }
/*  60 */         if (this.currentTabId == ((Integer)e.getKey()).intValue()) {
/*     */           
/*  62 */           for (Map.Entry<GuiTextField, String> field : ((Tab)e.getValue()).textFields.entrySet())
/*     */           {
/*  64 */             ((GuiTextField)field.getKey()).mouseClicked(mouseX, mouseY, mouseButton);
/*     */           }
/*  66 */           for (GuiButton button : ((Tab)e.getValue()).guiButtons) {
/*     */             
/*  68 */             if (button.mousePressed(this.mc, mouseX, mouseY)) {
/*     */               
/*  70 */               GuiScreenEvent.ActionPerformedEvent.Pre event = new GuiScreenEvent.ActionPerformedEvent.Pre(this, button, ((Tab)e.getValue()).guiButtons);
/*  71 */               if (MinecraftForge.EVENT_BUS.post((Event)event))
/*     */                 break; 
/*  73 */               button = event.getButton();
/*  74 */               this.selectedButton = button;
/*  75 */               button.playPressSound(this.mc.getSoundHandler());
/*  76 */               actionPerformed(button);
/*  77 */               if (equals(this.mc.currentScreen)) {
/*  78 */                 MinecraftForge.EVENT_BUS.post((Event)new GuiScreenEvent.ActionPerformedEvent.Post(this, event.getButton(), ((Tab)e.getValue()).guiButtons));
/*     */               }
/*     */               
/*  81 */               if (button instanceof GuiSwitchButton) {
/*     */                 
/*  83 */                 GuiSwitchButton gsb = (GuiSwitchButton)button;
/*  84 */                 gsb.incSwitchValue();
/*     */               } 
/*     */             } 
/*     */           } 
/*  88 */           for (GuiFilterList fl : ((Tab)e.getValue()).filterList) {
/*     */             
/*  90 */             fl.getField().mouseClicked(mouseX, mouseY, mouseButton);
/*  91 */             for (GuiButtonListRL b : fl.getLRButtons()) {
/*     */               
/*  93 */               if (b.mousePressed(this.mc, mouseX, mouseY)) {
/*     */                 
/*  95 */                 switch (b.getButtonSide()) {
/*     */                   
/*     */                   case "left":
/*  98 */                     fl.decrPage();
/*     */                     break;
/*     */                   case "right":
/* 101 */                     fl.incrPage();
/*     */                     break;
/*     */                 } 
/* 104 */                 b.playPressSound(this.mc.getSoundHandler());
/*     */               } 
/*     */             } 
/* 107 */             for (GuiButtonActiveText b : fl.getButtons()) {
/*     */               
/* 109 */               if (b.mousePressed(this.mc, mouseX, mouseY)) {
/*     */                 
/* 111 */                 fl.setChoosedButton(b.assignedNumber);
/* 112 */                 b.playPressSound(this.mc.getSoundHandler());
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateScreen() {
/* 124 */     for (Map.Entry<Integer, Tab> e : this.tabsList.entrySet()) {
/*     */       
/* 126 */       if (this.currentTabId == ((Integer)e.getKey()).intValue()) {
/*     */         
/* 128 */         for (Map.Entry<GuiTextField, String> ev : ((Tab)e.getValue()).textFields.entrySet())
/*     */         {
/* 130 */           ev.setValue((ev.getKey() == null) ? "" : ((GuiTextField)ev.getKey()).getText());
/*     */         }
/* 132 */         ((Tab)e.getValue()).but.isActive = true;
/* 133 */         for (GuiFilterList fl : ((Tab)e.getValue()).filterList) {
/*     */           
/* 135 */           fl.fieldText = (fl.fieldText == null) ? "" : fl.getField().getText();
/*     */           
/* 137 */           for (GuiButtonActiveText b : fl.buttons) {
/*     */             
/* 139 */             if (fl.getChoosedButton() == b.assignedNumber) {
/*     */               
/* 141 */               b.isActive = true;
/*     */               
/*     */               continue;
/*     */             } 
/* 145 */             b.isActive = false;
/*     */           } 
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 152 */       ((Tab)e.getValue()).but.isActive = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesGuiPauseGame() {
/* 160 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 166 */     for (Map.Entry<Integer, Tab> e : this.tabsList.entrySet()) {
/*     */       
/* 168 */       ((Tab)e.getValue()).but.drawButton(this.mc, mouseX, mouseY, partialTicks);
/* 169 */       if (((Integer)e.getKey()).intValue() == this.currentTabId) {
/*     */         
/* 171 */         for (GuiButton b : ((Tab)e.getValue()).guiButtons)
/*     */         {
/* 173 */           b.drawButton(this.mc, mouseX, mouseY, partialTicks);
/*     */         }
/* 175 */         for (GuiLabel l : ((Tab)e.getValue()).labels)
/*     */         {
/* 177 */           l.drawLabel(this.mc, mouseX, mouseY);
/*     */         }
/* 179 */         for (Map.Entry<GuiTextField, String> ev : ((Tab)e.getValue()).textFields.entrySet())
/*     */         {
/* 181 */           ((GuiTextField)ev.getKey()).drawTextBox();
/*     */         }
/* 183 */         for (GuiFilterList fl : ((Tab)e.getValue()).filterList)
/*     */         {
/* 185 */           fl.drawFilterList(this.mc, mouseX, mouseY, partialTicks);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException {}
/*     */ 
/*     */   
/*     */   public class Tab
/*     */   {
/*     */     public int id;
/*     */     
/*     */     public GuiTabButton but;
/*     */     
/*     */     public List<GuiButton> guiButtons;
/*     */     
/*     */     public List<GuiLabel> labels;
/*     */     
/*     */     public List<GuiFilterList> filterList;
/*     */     public Map<GuiTextField, String> textFields;
/*     */     
/*     */     public Tab(int id, GuiTabButton but) {
/* 209 */       this.id = id;
/* 210 */       this.but = but;
/* 211 */       this.guiButtons = Lists.newArrayList();
/* 212 */       this.textFields = Maps.newHashMap();
/* 213 */       this.labels = Lists.newArrayList();
/* 214 */       this.filterList = Lists.newArrayList();
/*     */     }
/*     */ 
/*     */     
/*     */     public Tab(int id, GuiTabButton but, Map<GuiTextField, String> text, List<GuiButton> buttons, List<GuiLabel> labels, List<GuiFilterList> filterList) {
/* 219 */       this.id = id;
/* 220 */       this.but = but;
/* 221 */       this.textFields = text;
/* 222 */       this.guiButtons = buttons;
/* 223 */       this.labels = labels;
/* 224 */       this.filterList = filterList;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getId() {
/* 229 */       return this.id;
/*     */     }
/*     */ 
/*     */     
/*     */     public Map<GuiTextField, String> getTextFields() {
/* 234 */       return this.textFields;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<GuiButton> getButtons() {
/* 239 */       return this.guiButtons;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiDynamic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */