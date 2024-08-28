 package com.ancient.thaumicgadgets.objects.machines.spinningwheel;

 import net.minecraft.client.gui.inventory.GuiContainer;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.entity.player.InventoryPlayer;
 import net.minecraft.util.ResourceLocation;
 
 
 public class GUISpinningWheel
   extends GuiContainer
 {
/* 12 */   private static final ResourceLocation TEXTURES = new ResourceLocation("tg:textures/gui/spinning_wheel.png");
   
   private final InventoryPlayer player;
   private final TileEntitySpinningWheel tileentity;
   
   public GUISpinningWheel(InventoryPlayer player, TileEntitySpinningWheel tileentity) {
/* 18 */     super(new ContainerSpinningWheel(player, tileentity));
/* 19 */     this.player = player;
/* 20 */     this.tileentity = tileentity;
   }
 
 
   
   protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
/* 26 */     this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
   }
 
 
   
   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
/* 32 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
/* 33 */     this.mc.getTextureManager().bindTexture(TEXTURES);
/* 34 */     drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
     
/* 36 */     int l = getWorkProgressScaled(63);
/* 37 */     drawTexturedModalRect(this.guiLeft + 38, this.guiTop + 15, 176, 0, l, 53);
   }
 
 
   
   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 43 */     super.drawScreen(mouseX, mouseY, partialTicks);
/* 44 */     renderHoveredToolTip(mouseX, mouseY);
   }
 
   
   private int getWorkProgressScaled(int pixels) {
/* 49 */     int i = this.tileentity.getField(0);
/* 50 */     int j = this.tileentity.getField(1);
     
/* 52 */     return (j != 0 && i != 0) ? (i * pixels / j) : 0;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\spinningwheel\GUISpinningWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */