 package com.ancient.thaumicgadgets.objects.machines.extruder;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.item.EntityItem;
 import net.minecraft.item.ItemStack;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.world.World;

 public class RenderExtruderUp extends TileEntitySpecialRenderer<TileEntityExtruderUp> {
/* 11 */   private float timer = 0.0F;
/* 12 */   private static final EntityItem modeIndicator = new EntityItem((World)(Minecraft.getMinecraft()).world, 0.0D, 0.0D, 0.0D);



   public void render(TileEntityExtruderUp te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
/* 17 */     super.render(te, x, y, z, partialTicks, destroyStage, alpha);

/* 19 */     this.timer += partialTicks;
/* 20 */     if (this.timer > 360.0F)
     {
/* 22 */       this.timer = 0.0F;
     }


/* 26 */     modeIndicator.setItem(new ItemStack(te.getItemFromMode(te.getField(2)), 1));

/* 28 */     GlStateManager.pushMatrix();

/* 30 */     GlStateManager.translate(x + 0.5D, y + 1.2D, z + 0.5D);
/* 31 */     GlStateManager.scale(0.7F, 0.7F, 0.7F);
/* 32 */     Minecraft.getMinecraft().getRenderManager().renderEntity((Entity)modeIndicator, 0.0D, 0.0D, 0.0D, 0.0F, this.timer, false);

/* 34 */     GlStateManager.popMatrix();
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\extruder\RenderExtruderUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */