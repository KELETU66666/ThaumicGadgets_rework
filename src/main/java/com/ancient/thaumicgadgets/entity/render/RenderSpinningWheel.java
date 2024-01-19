package com.ancient.thaumicgadgets.entity.render;

import com.ancient.thaumicgadgets.entity.model.ModelSpinningWheel;
import com.ancient.thaumicgadgets.objects.machines.spinningwheel.TileEntitySpinningWheel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;






@SideOnly(Side.CLIENT)
public class RenderSpinningWheel extends TileEntitySpecialRenderer<TileEntitySpinningWheel> {
    public static final ModelSpinningWheel MODEL = new ModelSpinningWheel();
    public void render(TileEntitySpinningWheel te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
      renderSpinningWheel(te, x, y, z, partialTicks, destroyStage, alpha);
    }


    public void renderSpinningWheel(TileEntitySpinningWheel te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();

        GlStateManager.translate((float)x, (float)y, (float)z);

        GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(0.07F, 0.07F, 0.07F);

        GlStateManager.translate(x + 6.0D, y - 25.0D, z - 5.0D);

        ResourceLocation texture = new ResourceLocation("tg:textures/models/spinning_wheel.png");
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        MODEL.render(te, (float)x, (float)y, (float)z, partialTicks, destroyStage, alpha);


        GlStateManager.popMatrix();
    }
}