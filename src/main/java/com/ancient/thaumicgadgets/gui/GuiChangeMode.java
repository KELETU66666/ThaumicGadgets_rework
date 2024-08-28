/*     */ package com.ancient.thaumicgadgets.gui;
/*     */ 
/*     */

import com.ancient.thaumicgadgets.armor.primal.ArmorPrimal;
import com.ancient.thaumicgadgets.network.MessageChangeModeArmor;
import com.ancient.thaumicgadgets.network.MessageChangeModeWeapon;
import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.io.IOException;
/*     */ 
/*     */ public class GuiChangeMode
/*     */   extends GuiScreen
/*     */ {
/*  24 */   private static final ResourceLocation HELMET_LOC = new ResourceLocation("tg", "textures/items/helmet_primal.png");
/*  25 */   private static final ResourceLocation CHEST_LOC = new ResourceLocation("tg", "textures/items/chestplate_primal.png");
/*  26 */   private static final ResourceLocation LEGGINS_LOC = new ResourceLocation("tg", "textures/items/leggins_primal.png");
/*  27 */   private static final ResourceLocation BOOTS_LOC = new ResourceLocation("tg", "textures/items/boots_primal.png");
/*  28 */   private static final ResourceLocation HAMMER_LOC = new ResourceLocation("tg", "textures/items/hammer_primal.png");
/*  29 */   private static final ResourceLocation SWORD_LOC = new ResourceLocation("tg", "textures/items/sword_primal.png");
/*  30 */   private static final ResourceLocation AXE_LOC = new ResourceLocation("tg", "textures/items/axe_primal.png");
/*  31 */   private static final ResourceLocation BACKGROUND = new ResourceLocation("tg", "textures/gui/change_mode.png");
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  36 */     super.initGui();
/*     */     
/*  38 */     EntityPlayerSP entityPlayerSP = this.mc.player;
/*  39 */     NonNullList<ItemStack> list = ((EntityPlayer)entityPlayerSP).inventory.armorInventory;
/*     */     
/*  41 */     for (ItemStack stack : list) {
/*     */       
/*  43 */       if (stack != null && stack.getTranslationKey().contains("primal")) {
/*     */         
/*  45 */         if (stack.getTranslationKey().contains("helmet"))
/*     */         {
/*  47 */           this.buttonList.add(new GuiTexturedButton(3, this.width / 2 - 64, this.height / 2 - 68, 32, 32, "", HELMET_LOC, 32, 32, 32, 32));
/*     */         }
/*  49 */         if (stack.getTranslationKey().contains("chest"))
/*     */         {
/*  51 */           this.buttonList.add(new GuiTexturedButton(2, this.width / 2 + 30, this.height / 2 - 68, 32, 32, "", CHEST_LOC, 0, 0, 32, 32));
/*     */         }
/*  53 */         if (stack.getTranslationKey().contains("leggins"))
/*     */         {
/*  55 */           this.buttonList.add(new GuiTexturedButton(1, this.width / 2 - 68, this.height / 2 + 30, 32, 32, "", LEGGINS_LOC, 0, 0, 32, 32));
/*     */         }
/*  57 */         if (stack.getTranslationKey().contains("boots"))
/*     */         {
/*  59 */           this.buttonList.add(new GuiTexturedButton(0, this.width / 2 + 30, this.height / 2 + 30, 32, 32, "", BOOTS_LOC, 0, 0, 32, 32));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  64 */     ItemStack stackRightHand = entityPlayerSP.getHeldItemMainhand();
/*  65 */     if (stackRightHand.getTranslationKey().contains("primal"))
/*     */     {
/*  67 */       if (stackRightHand.getTranslationKey().contains("axe")) {
/*     */         
/*  69 */         this.buttonList.add(new GuiTexturedButton(4, this.width / 2 - 16, this.height / 2 - 16, 32, 32, "", AXE_LOC, 0, 0, 32, 32));
/*     */       }
/*  71 */       else if (stackRightHand.getTranslationKey().contains("sword")) {
/*     */         
/*  73 */         this.buttonList.add(new GuiTexturedButton(4, this.width / 2 - 16, this.height / 2 - 16, 32, 32, "", SWORD_LOC, 0, 32, 32, 32));
/*     */       }
/*  75 */       else if (stackRightHand.getTranslationKey().contains("hammer")) {
/*     */         
/*  77 */         this.buttonList.add(new GuiTexturedButton(4, this.width / 2 - 16, this.height / 2 - 16, 32, 32, "", HAMMER_LOC, 0, 0, 32, 32));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/*  86 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  87 */     this.mc.getTextureManager().bindTexture(BACKGROUND);
/*  88 */     GlStateManager.enableBlend();
/*  89 */     drawTexturedModalRect(this.width / 2 - 128, this.height / 2 - 128, 0, 0, 256, 256);
/*  90 */     GlStateManager.disableBlend();
/*  91 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/*  93 */     EntityPlayerSP entityPlayerSP = this.mc.player;
/*  94 */     NonNullList<ItemStack> list = ((EntityPlayer)entityPlayerSP).inventory.armorInventory;
/*  95 */     for (ItemStack stack : list) {
/*     */       
/*  97 */       if (stack != null && stack.getTranslationKey().contains("primal")) {
/*     */         
/*  99 */         ArmorPrimal l = (ArmorPrimal)stack.getItem();
/* 100 */         int i = l.getEquipmentSlot().getIndex();
/*     */         
/* 102 */         for (GuiButton b : this.buttonList) {
/*     */           
/* 104 */           if (b.id == i)
/*     */           {
/* 106 */             if (IFunctionLibrary.isPointInRegion(b.x, b.y, b.width, b.height, mouseX, mouseY))
/*     */             {
/* 108 */               drawHoveringText(((ItemStack)((EntityPlayer)entityPlayerSP).inventory.armorInventory.get(i)).getTooltip((EntityPlayer)entityPlayerSP, (ITooltipFlag)ITooltipFlag.TooltipFlags.NORMAL), mouseX, mouseY);
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     ItemStack stackRightHand = entityPlayerSP.getHeldItemMainhand();
/* 116 */     for (GuiButton b : this.buttonList) {
/*     */       
/* 118 */       if (b.id == 4)
/*     */       {
/* 120 */         if (stackRightHand.getTranslationKey().contains("sword_primal") || stackRightHand.getTranslationKey().contains("axe_primal") || stackRightHand.getTranslationKey().contains("hammer_primal"))
/*     */         {
/* 122 */           if (IFunctionLibrary.isPointInRegion(b.x, b.y, b.width, b.height, mouseX, mouseY))
/*     */           {
/* 124 */             drawHoveringText(stackRightHand.getTooltip((EntityPlayer)entityPlayerSP, (ITooltipFlag)ITooltipFlag.TooltipFlags.NORMAL), mouseX, mouseY);
/*     */           }
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesGuiPauseGame() {
/* 134 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/* 140 */     if (button.id == 4) {
/*     */ 
/*     */       
/* 143 */       EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).player;
/* 144 */       NetworkHandler.sendToServer((IMessage)new MessageChangeModeWeapon(((EntityPlayer)entityPlayerSP).inventory.getSlotFor(entityPlayerSP.getHeldItemMainhand())));
/*     */     } 
/*     */     
/* 147 */     if (button.id <= 3)
/*     */     {
/*     */       
/* 150 */       NetworkHandler.sendToServer((IMessage)new MessageChangeModeArmor(button.id));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiChangeMode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */