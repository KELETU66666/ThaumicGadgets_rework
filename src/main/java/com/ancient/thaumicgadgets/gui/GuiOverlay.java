package com.ancient.thaumicgadgets.gui;


import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.ancient.thaumicgadgets.armor.light.LightBelt;
import com.ancient.thaumicgadgets.armor.shade.ShadeBelt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class GuiOverlay
        extends Gui {
    private static final ResourceLocation loc = new ResourceLocation("thaumicgadgets", "textures/gui/hud.png");

    private final int[][] Coords = new int[][]{{6, 14}, {6, 24}};


    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {


            Minecraft mc = Minecraft.getMinecraft();
            EntityPlayerSP pl = mc.player;

            int[] i = {0, 0};
            for (ItemStack s : pl.inventory.armorInventory) {

                if (s.getItem() instanceof com.ancient.thaumicgadgets.armor.light.ArmorLight) {
                    i[0] = i[0] + 1;
                }
                if (s.getItem() instanceof com.ancient.thaumicgadgets.armor.shade.ArmorShade) {
                    i[1] = i[1] + 1;
                }
            }

            IBaublesItemHandler handler = BaublesApi.getBaublesHandler(pl);
            ItemStack stack = handler.getStackInSlot(3);

            if (!stack.isEmpty()) {

                long lastTick = 0L;
                int cooldown = 0;

                if (stack.getItem() instanceof LightBelt) {

                    LightBelt item = (LightBelt) stack.getItem();
                    lastTick = item.lastUse;
                    cooldown = 1200;
                    i[0] = i[0] + 1;
                }
                if (stack.getItem() instanceof ShadeBelt) {

                    ShadeBelt item = (ShadeBelt) stack.getItem();
                    lastTick = item.lastUse;
                    cooldown = 300;
                    i[1] = i[1] + 1;
                }

                if (i[0] == 5 || i[1] == 5) {

                    int q = (i[1] == 5) ? 1 : 0;


                    float v = (float) (pl.world.getTotalWorldTime() - lastTick) * 60.0F / cooldown;

                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                    mc.renderEngine.bindTexture(loc);
                    GlStateManager.enableBlend();
                    if (v < 60.0F) {

                        drawTexturedModalRect(5, 2, this.Coords[q][0], this.Coords[q][1], Math.round(v), 7);
                    } else {

                        drawTexturedModalRect(5, 2, this.Coords[q][0], this.Coords[q][1], 60, 7);
                    }
                    drawTexturedModalRect(0, 0, 1, 1, 64, 11);
                    GlStateManager.disableBlend();
                }
            }


            stack = handler.getStackInSlot(0);
        }
    }
}