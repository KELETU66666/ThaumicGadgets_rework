 package com.ancient.thaumicgadgets.entity.render;

 import com.ancient.thaumicgadgets.entity.model.ModelSpinningWheel;
 import com.ancient.thaumicgadgets.objects.machines.spinningwheel.TileEntitySpinningWheel;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.ResourceLocation;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;






 @SideOnly(Side.CLIENT)
 public class RenderSpinningWheel
   extends TileEntitySpecialRenderer<TileEntitySpinningWheel>
 {
/* 22 */   public static final ModelSpinningWheel MODEL = new ModelSpinningWheel();



   public void render(TileEntitySpinningWheel te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
/* 27 */     renderSpinningWheel(te, x, y, z, partialTicks, destroyStage, alpha);
   }


   public void renderSpinningWheel(TileEntitySpinningWheel te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
/* 32 */     GlStateManager.pushMatrix();

/* 34 */     GlStateManager.translate((float)x, (float)y, (float)z);

/* 36 */     GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
/* 37 */     GlStateManager.scale(0.07F, 0.07F, 0.07F);

/* 39 */     GlStateManager.translate(x + 6.0D, y - 25.0D, z - 5.0D);

/* 41 */     ResourceLocation texture = new ResourceLocation("tg:textures/models/spinning_wheel.png");
/* 42 */     Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
/* 43 */     MODEL.render((TileEntity)te, (float)x, (float)y, (float)z, partialTicks, destroyStage, alpha);


/* 46 */     GlStateManager.popMatrix();
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\entity\render\RenderSpinningWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */