/*     */ package com.ancient.thaumicgadgets.gui;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import com.ancient.thaumicgadgets.items.ItemLense;
/*     */ import com.ancient.thaumicgadgets.items.pouches.ItemPouch;
/*     */ import com.ancient.thaumicgadgets.network.MessageServerChangeLense;
/*     */ import com.ancient.thaumicgadgets.util.IFunctionLibrary;
/*     */ import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ 
/*     */ 
/*     */ public class GuiChangeLense
/*     */   extends GuiScreen
/*     */ {
/*  30 */   private static final ResourceLocation[] LENSE_LOC = new ResourceLocation[] { new ResourceLocation("tg", "textures/items/crystals/lenses/lense_night_vision.png"), new ResourceLocation("tg", "textures/items/crystals/lenses/lense_echo_loc.png"), new ResourceLocation("tg", "textures/items/crystals/lenses/lense_death_gaze.png"), new ResourceLocation("tg", "textures/items/crystals/lenses/lense_fire.png"), new ResourceLocation("tg", "textures/items/crystals/lenses/lense_knockback.png"), new ResourceLocation("tg", "textures/items/crystals/lenses/lense_decay.png") };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   private static final ResourceLocation[] BACKGROUND = new ResourceLocation[] { new ResourceLocation("tg", "textures/gui/change_lense_layer0.png"), new ResourceLocation("tg", "textures/gui/change_lense_layer1.png") };
/*     */ 
/*     */   
/*  40 */   private List<ItemStack> lenseList = Lists.newArrayList();
/*     */   
/*  42 */   private ItemStack centerLense = ItemStack.EMPTY;
/*     */ 
/*     */ 
/*     */   
/*     */   public void initGui() {
/*  47 */     EntityPlayerSP entityPlayerSP = this.mc.player;
/*  48 */     NonNullList<ItemStack> list = ((EntityPlayer)entityPlayerSP).inventory.armorInventory;
/*  49 */     NonNullList<ItemStack> inv = ((EntityPlayer)entityPlayerSP).inventory.mainInventory;
/*  50 */     this.lenseList.clear();
/*  51 */     for (ItemStack s : inv) {
/*     */       
/*  53 */       if (s != ItemStack.EMPTY && s.getItem().equals(ModItems.LENSE_POUCH))
/*     */       {
/*  55 */         for (ItemStack st : ((ItemPouch)s.getItem()).getInventory(s)) {
/*     */           
/*  57 */           if (st != ItemStack.EMPTY && st.getItem() instanceof ItemLense)
/*     */           {
/*  59 */             this.lenseList.add(st);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  65 */     if (list.get(3) != ItemStack.EMPTY)
/*     */     {
/*  67 */       if (((ItemStack)list.get(3)).getTagCompound() != null) {
/*     */         
/*  69 */         NBTTagCompound tag = ((ItemStack)list.get(3)).getTagCompound();
/*     */         
/*  71 */         if (tag.hasKey("tg:lense")) {
/*     */           
/*  73 */           String s = tag.getString("tg:lense");
/*  74 */           if (!s.isEmpty() && s != null) {
/*     */             
/*  76 */             Item temp = Item.getByNameOrId(s);
/*  77 */             if (temp instanceof ItemLense) {
/*     */               
/*  79 */               ItemLense t = (ItemLense)temp;
/*  80 */               this.centerLense = new ItemStack((Item)t);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  87 */     if (!this.centerLense.equals(ItemStack.EMPTY))
/*     */     {
/*  89 */       this.buttonList.add(new GuiTexturedButton(0, this.width / 2 - 16, this.height / 2 - 16, 32, 32, "", getLocFromItem((ItemLense)this.centerLense.getItem()), 0, 0, 32, 32));
/*     */     }
/*  91 */     if (!this.lenseList.isEmpty()) {
/*     */       
/*  93 */       int count = this.lenseList.size();
/*  94 */       float angle = 360.0F / count;
/*  95 */       int distance = 80;
/*  96 */       int q = 0;
/*  97 */       for (ItemStack l : this.lenseList) {
/*     */         
/*  99 */         this.buttonList.add(new GuiTexturedButton(q + 1, this.width / 2 - 16 + (int)Math.round(Math.cos(Math.toRadians((angle * q))) * distance), this.height / 2 - 16 + (int)Math.round(Math.sin(Math.toRadians((angle * q))) * distance), 32, 32, "", getLocFromItem((ItemLense)l.getItem()), 0, 0, 32, 32));
/* 100 */         q++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 109 */     EntityPlayerSP entityPlayerSP = this.mc.player;
/* 110 */     World world = entityPlayerSP.getEntityWorld();
/*     */     
/* 112 */     GlStateManager.pushMatrix();
/*     */     
/* 114 */     float angle = (float)(world.getTotalWorldTime() % 360L);
/* 115 */     GlStateManager.translate(this.width / 2.0F, this.height / 2.0F, 0.0F);
/* 116 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 117 */     this.mc.getTextureManager().bindTexture(BACKGROUND[0]);
/* 118 */     GlStateManager.rotate(angle / 2.0F, 0.0F, 0.0F, 1.0F);
/* 119 */     GlStateManager.enableBlend();
/* 120 */     drawTexturedModalRect(-128, -128, 0, 0, 256, 256);
/* 121 */     GlStateManager.disableBlend();
/* 122 */     this.mc.getTextureManager().bindTexture(BACKGROUND[1]);
/* 123 */     GlStateManager.rotate(-angle, 0.0F, 0.0F, 1.0F);
/* 124 */     GlStateManager.enableBlend();
/* 125 */     drawTexturedModalRect(-128, -128, 0, 0, 256, 256);
/* 126 */     GlStateManager.disableBlend();
/*     */     
/* 128 */     GlStateManager.rotate(angle / 2.0F, 0.0F, 0.0F, 1.0F);
/* 129 */     GlStateManager.translate(-this.width / 2.0F, -this.height / 2.0F, 0.0F);
/*     */     
/* 131 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/* 133 */     for (GuiButton b : this.buttonList) {
/*     */       
/* 135 */       if (IFunctionLibrary.isPointInRegion(b.x, b.y, b.width, b.height, mouseX, mouseY)) {
/*     */         
/* 137 */         if (b.id == 0) {
/*     */           
/* 139 */           drawHoveringText(this.centerLense.getTooltip((EntityPlayer)entityPlayerSP, (ITooltipFlag)ITooltipFlag.TooltipFlags.ADVANCED), mouseX, mouseY);
/*     */           
/*     */           continue;
/*     */         } 
/* 143 */         drawHoveringText(((ItemStack)this.lenseList.get(b.id - 1)).getTooltip((EntityPlayer)entityPlayerSP, (ITooltipFlag)ITooltipFlag.TooltipFlags.ADVANCED), mouseX, mouseY);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 148 */     GlStateManager.popMatrix();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean doesGuiPauseGame() {
/* 155 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException {
/* 161 */     if (button.id == 0) {
/*     */       
/* 163 */       NetworkHandler.sendToServer((IMessage)new MessageServerChangeLense(ItemStack.EMPTY));
/*     */     }
/*     */     else {
/*     */       
/* 167 */       NetworkHandler.sendToServer((IMessage)new MessageServerChangeLense(this.lenseList.get(button.id - 1)));
/*     */     } 
/* 169 */     this.mc.displayGuiScreen(null);
/*     */   }
/*     */ 
/*     */   
/*     */   private ResourceLocation getLocFromItem(ItemLense l) {
/* 174 */     return LENSE_LOC[l.getLenseType().getId()];
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\gui\GuiChangeLense.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */