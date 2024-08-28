/*     */ package com.ancient.thaumicgadgets.gui;
/*     */ 
/*     */

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.ancient.thaumicgadgets.armor.light.LightBelt;
import com.ancient.thaumicgadgets.armor.shade.ShadeBelt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiOverlay
/*     */   extends Gui
/*     */ {
/*  26 */   private static final ResourceLocation loc = new ResourceLocation("tg", "textures/gui/hud.png");
/*     */   
/*  28 */   private int[][] Coords = new int[][] { { 6, 14 }, { 6, 24 } };
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void renderOverlay(RenderGameOverlayEvent.Post event) {
/*  33 */     if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
/*     */ 
/*     */       
/*  36 */       Minecraft mc = Minecraft.getMinecraft();
/*  37 */       EntityPlayerSP pl = mc.player;
/*     */       
/*  39 */       int[] i = { 0, 0 };
/*  40 */       for (ItemStack s : pl.inventory.armorInventory) {
/*     */         
/*  42 */         if (s.getItem() instanceof com.ancient.thaumicgadgets.armor.light.ArmorLight)
/*     */         {
/*  44 */           i[0] = i[0] + 1;
/*     */         }
/*  46 */         if (s.getItem() instanceof com.ancient.thaumicgadgets.armor.shade.ArmorShade)
/*     */         {
/*  48 */           i[1] = i[1] + 1;
/*     */         }
/*     */       } 
/*     */       
/*  52 */       IBaublesItemHandler handler = BaublesApi.getBaublesHandler((EntityPlayer)pl);
/*  53 */       ItemStack stack = handler.getStackInSlot(3);
/*     */       
/*  55 */       if (!stack.isEmpty()) {
/*     */         
/*  57 */         long lastTick = 0L;
/*  58 */         int cooldown = 0;
/*     */         
/*  60 */         if (stack.getItem() instanceof LightBelt) {
/*     */           
/*  62 */           LightBelt item = (LightBelt)stack.getItem();
/*  63 */           lastTick = item.lastUse;
/*  64 */           item.getClass(); cooldown = 1200;
/*  65 */           i[0] = i[0] + 1;
/*     */         } 
/*  67 */         if (stack.getItem() instanceof ShadeBelt) {
/*     */           
/*  69 */           ShadeBelt item = (ShadeBelt)stack.getItem();
/*  70 */           lastTick = item.lastUse;
/*  71 */           item.getClass(); cooldown = 300;
/*  72 */           i[1] = i[1] + 1;
/*     */         } 
/*     */         
/*  75 */         if (i[0] == 5 || i[1] == 5) {
/*     */           
/*  77 */           int q = (i[1] == 5) ? 1 : 0;
/*     */ 
/*     */           
/*  80 */           float v = (float)(pl.world.getTotalWorldTime() - lastTick) * 60.0F / cooldown;
/*     */           
/*  82 */           GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/*  83 */           mc.renderEngine.bindTexture(loc);
/*  84 */           GlStateManager.enableBlend();
/*  85 */           if (v < 60.0F) {
/*     */             
/*  87 */             drawTexturedModalRect(5, 2, this.Coords[q][0], this.Coords[q][1], Math.round(v), 7);
/*     */           }
/*     */           else {
/*     */             
/*  91 */             drawTexturedModalRect(5, 2, this.Coords[q][0], this.Coords[q][1], 60, 7);
/*     */           } 
/*  93 */           drawTexturedModalRect(0, 0, 1, 1, 64, 11);
/*  94 */           GlStateManager.disableBlend();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  99 */       stack = handler.getStackInSlot(0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiOverlay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */