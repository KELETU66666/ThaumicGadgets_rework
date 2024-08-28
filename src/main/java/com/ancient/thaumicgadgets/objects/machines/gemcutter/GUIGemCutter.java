/*     */ package com.ancient.thaumicgadgets.objects.machines.gemcutter;
/*     */ 
/*     */

import com.ancient.thaumicgadgets.gui.GuiAspectButton;
import com.ancient.thaumicgadgets.gui.GuiTexturedButton;
import com.ancient.thaumicgadgets.network.MessageButtonCraft;
import com.ancient.thaumicgadgets.network.MessageGUIButton;
import com.ancient.thaumicgadgets.network.gemcutter.MessageServerChoosedAspects;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import com.google.common.collect.Lists;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import java.io.IOException;
import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GUIGemCutter
/*     */   extends GuiContainer
/*     */ {
/*  26 */   private static final ResourceLocation TEXTURES = new ResourceLocation("tg", "textures/gui/gemcutter.png");
/*     */ 
/*     */   
/*  29 */   public static final int[][] gemCoords = new int[][] { { 184, 8 }, { 223, 8 }, { 184, 46 } };
/*     */   private final InventoryPlayer player;
/*     */   private final TileEntityGemCutter tileentity;
/*     */   private int mode;
/*  33 */   private int maxMode = 2;
/*     */   private int workTime;
/*  35 */   private AspectList allAspects = new AspectList();
/*  36 */   private AspectList choosedAspects = new AspectList();
/*  37 */   private List<GuiAspectButton> buttons = Lists.newArrayList();
/*     */ 
/*     */   
/*     */   public GUIGemCutter(InventoryPlayer player, TileEntityGemCutter tileentity) {
/*  41 */     super(new ContainerGemCutter(player, tileentity));
/*  42 */     this.player = player;
/*  43 */     this.tileentity = tileentity;
/*  44 */     this.mode = this.tileentity.getField(0);
/*  45 */     this.workTime = this.tileentity.getField(1);
/*     */     
/*  47 */     gemCoords[0][0] = 184;
/*  48 */     gemCoords[0][1] = 8;
/*     */     
/*  50 */     gemCoords[1][0] = 223;
/*  51 */     gemCoords[1][1] = 8;
/*     */     
/*  53 */     gemCoords[2][0] = 184;
/*  54 */     gemCoords[2][1] = 46;
/*  55 */     this.allAspects.add(Aspect.AIR, 0);
/*  56 */     this.allAspects.add(Aspect.FIRE, 0);
/*  57 */     this.allAspects.add(Aspect.WATER, 0);
/*  58 */     this.allAspects.add(Aspect.EARTH, 0);
/*  59 */     this.allAspects.add(Aspect.ORDER, 0);
/*  60 */     this.allAspects.add(Aspect.ENTROPY, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  73 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*  74 */     renderHoveredToolTip(mouseX, mouseY);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
/*  80 */     this.allAspects = this.tileentity.getAspectList();
/*  81 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  82 */     this.mc.getTextureManager().bindTexture(TEXTURES);
/*  83 */     GlStateManager.enableBlend();
/*  84 */     drawTexturedModalRect(this.width / 2 - 88, this.height / 2 - 90, 0, 0, this.xSize, this.ySize + 15);
/*     */ 
/*     */     
/*  87 */     this.tileentity.getClass(); float perc = this.tileentity.getField(1) / 40.0F;
/*  88 */     drawTexturedModalRect(this.width / 2 - 52, Math.round((this.height / 2 - 14) + 1.0F - perc * 35.0F), 225, 119 + Math.round(1.0F - perc * 35.0F), 27, Math.round(perc * 35.0F));
/*     */     
/*  90 */     GlStateManager.disableBlend();
/*  91 */     drawTexturedModalRect(this.width / 2 - 15, this.height / 2 - 83, gemCoords[this.mode][0], gemCoords[this.mode][1], 30, 30);
/*  92 */     for (GuiAspectButton b : this.buttons) {
/*     */       
/*  94 */       if (!this.allAspects.aspects.containsKey(b.getAspect()))
/*     */       {
/*  96 */         this.allAspects.add(b.getAspect(), 0);
/*     */       }
/*  98 */       String s = Integer.toString(this.allAspects.getAmount(b.getAspect()));
/*  99 */       GlStateManager.scale(0.5F, 0.5F, 1.0F);
/* 100 */       drawString(this.mc.fontRenderer, s, (b.x + b.width / 2 - this.mc.fontRenderer.getStringWidth(s) / 2 + 6) * 2, (b.y - b.height / 2 + 3) * 2, b.getAspect().getColor());
/* 101 */       GlStateManager.scale(2.0F, 2.0F, 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {
/* 108 */     super.initGui();
/*     */     
/* 110 */     this.buttonList.add(new GuiTexturedButton(0, this.guiLeft + 60, this.guiTop - 1, 10, 9, "", TEXTURES, 185, 97, 256, 256));
/* 111 */     this.buttonList.add(new GuiTexturedButton(1, this.guiLeft + 107, this.guiTop - 1, 10, 9, "", TEXTURES, 185, 82, 256, 256));
/* 112 */     this.buttonList.add(new GuiTexturedButton(2, this.guiLeft + 128, this.guiTop + 55, 24, 16, "", TEXTURES, 229, 65, 256, 256));
/*     */     
/* 114 */     this.buttons.clear();
/* 115 */     this.buttons.add(new GuiAspectButton(3, this.width / 2 - 22, this.height / 2 - 42, 16, 16, Aspect.AIR, TEXTURES, 181, 120, 256, 256));
/* 116 */     this.buttons.add(new GuiAspectButton(4, this.width / 2 - 4, this.height / 2 - 42, 16, 16, Aspect.FIRE, TEXTURES, 181, 120, 256, 256));
/* 117 */     this.buttons.add(new GuiAspectButton(5, this.width / 2 + 14, this.height / 2 - 42, 16, 16, Aspect.EARTH, TEXTURES, 181, 120, 256, 256));
/* 118 */     this.buttons.add(new GuiAspectButton(6, this.width / 2 - 22, this.height / 2 - 17, 16, 16, Aspect.WATER, TEXTURES, 181, 120, 256, 256));
/* 119 */     this.buttons.add(new GuiAspectButton(7, this.width / 2 - 4, this.height / 2 - 17, 16, 16, Aspect.ORDER, TEXTURES, 181, 120, 256, 256));
/* 120 */     this.buttons.add(new GuiAspectButton(8, this.width / 2 + 14, this.height / 2 - 17, 16, 16, Aspect.ENTROPY, TEXTURES, 181, 120, 256, 256));
/*     */     
/* 122 */     for (GuiButton b : this.buttons)
/*     */     {
/* 124 */       this.buttonList.add(b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/* 131 */     if (button.id == 0) {
/*     */       
/* 133 */       NetworkHandler.sendToServer((IMessage)new MessageGUIButton(this.tileentity, decrMode()));
/*     */     }
/* 135 */     else if (button.id == 1) {
/*     */       
/* 137 */       NetworkHandler.sendToServer((IMessage)new MessageGUIButton(this.tileentity, incrMode()));
/*     */     }
/* 139 */     else if (button.id == 2) {
/*     */       
/* 141 */       NetworkHandler.sendToServer((IMessage)new MessageButtonCraft(this.tileentity));
/*     */     } 
/* 143 */     if (button.id > 2 && button.id < 9) {
/*     */       
/* 145 */       Aspect as = ((GuiAspectButton)button).getAspect();
/* 146 */       if (this.choosedAspects.aspects.containsKey(as)) {
/*     */         
/* 148 */         this.choosedAspects.remove(as);
/*     */       }
/*     */       else {
/*     */         
/* 152 */         this.choosedAspects.add(as, this.allAspects.getAmount(as));
/*     */       } 
/* 154 */       NetworkHandler.sendToServer((IMessage)new MessageServerChoosedAspects(this.tileentity, this.choosedAspects));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int incrMode() {
/* 160 */     if (this.mode < this.maxMode) {
/*     */       
/* 162 */       this.mode++;
/*     */     }
/* 164 */     else if (this.mode == this.maxMode) {
/*     */       
/* 166 */       this.mode = 0;
/*     */     } 
/* 168 */     return this.mode;
/*     */   }
/*     */   
/*     */   public int decrMode() {
/* 172 */     if (this.mode > 0) {
/*     */       
/* 174 */       this.mode--;
/*     */     }
/* 176 */     else if (this.mode == 0) {
/*     */       
/* 178 */       this.mode = this.maxMode;
/*     */     } 
/* 180 */     return this.mode;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\gemcutter\GUIGemCutter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */