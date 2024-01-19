package com.ancient.thaumicgadgets.objects.machines.extruder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class RenderExtruderUp extends TileEntitySpecialRenderer<TileEntityExtruderUp> {
    private float timer = 0.0F;
    private static final EntityItem modeIndicator = new EntityItem((Minecraft.getMinecraft()).world, 0.0D, 0.0D, 0.0D);



    public void render(TileEntityExtruderUp te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        super.render(te, x, y, z, partialTicks, destroyStage, alpha);

        this.timer += partialTicks;
        if (this.timer > 360.0F)
        {
            this.timer = 0.0F;
        }



        modeIndicator.setItem(new ItemStack(te.getItemFromMode(te.getField(2)), 1));


        GlStateManager.pushMatrix();


        GlStateManager.translate(x + 0.5D, y + 1.2D, z + 0.5D);

        GlStateManager.scale(0.7F, 0.7F, 0.7F);

        Minecraft.getMinecraft().getRenderManager().renderEntity(modeIndicator, 0.0D, 0.0D, 0.0D, 0.0F, this.timer, false);


        GlStateManager.popMatrix();
    }
}