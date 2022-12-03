 package com.ancient.thaumicgadgets.objects.machines.lamp;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.item.EntityItem;
 import net.minecraft.init.Items;
 import net.minecraft.item.ItemStack;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.world.World;

 public class RenderLamp extends TileEntitySpecialRenderer<TileEntityLamp> {
/* 12 */   private float timer = 0.0F;
/* 13 */   private static final EntityItem modeIndicator = new EntityItem((World)(Minecraft.getMinecraft()).world, 0.0D, 0.0D, 0.0D);
 
 
   
   public void render(TileEntityLamp te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
/* 18 */     super.render(te, x, y, z, partialTicks, destroyStage, alpha);
     
/* 20 */     this.timer = te.timer * 0.5F;
 
     
/* 23 */     modeIndicator.setItem(new ItemStack(Items.NETHER_STAR));
     
/* 25 */     GlStateManager.pushMatrix();
     
/* 27 */     GlStateManager.translate(x + 0.5D, y + 0.4D, z + 0.5D);
/* 28 */     GlStateManager.scale(0.5F, 0.5F, 0.5F);
/* 29 */     Minecraft.getMinecraft().getRenderManager().renderEntity((Entity)modeIndicator, 0.0D, 0.0D, 0.0D, 0.0F, this.timer, false);
     
/* 31 */     GlStateManager.popMatrix();
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\lamp\RenderLamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */