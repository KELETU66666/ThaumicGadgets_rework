package com.ancient.thaumicgadgets.objects.machines.gemcutter;


import com.ancient.thaumicgadgets.gui.GuiAspectButton;
import com.ancient.thaumicgadgets.gui.GuiTexturedButton;
import com.ancient.thaumicgadgets.network.MessageButtonCraft;
import com.ancient.thaumicgadgets.network.MessageGUIButton;
import com.ancient.thaumicgadgets.network.gemcutter.MessageServerChoosedAspects;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import com.google.common.collect.Lists;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import java.io.IOException;
import java.util.List;


public class GUIGemCutter
        extends GuiContainer {
    private static final ResourceLocation TEXTURES = new ResourceLocation("thaumicgadgets", "textures/gui/gemcutter.png");


    public static final int[][] gemCoords = new int[][]{{184, 8}, {223, 8}, {184, 46}};
    private final InventoryPlayer player;
    private final TileEntityGemCutter tileentity;
    private int mode;
    private final int maxMode = 2;
    private final int workTime;
    private AspectList allAspects = new AspectList();
    private final AspectList choosedAspects = new AspectList();
    private final List<GuiAspectButton> buttons = Lists.newArrayList();


    public GUIGemCutter(InventoryPlayer player, TileEntityGemCutter tileentity) {
        super(new ContainerGemCutter(player, tileentity));
        this.player = player;
        this.tileentity = tileentity;
        this.mode = this.tileentity.getField(0);
        this.workTime = this.tileentity.getField(1);

        gemCoords[0][0] = 184;
        gemCoords[0][1] = 8;

        gemCoords[1][0] = 223;
        gemCoords[1][1] = 8;

        gemCoords[2][0] = 184;
        gemCoords[2][1] = 46;
        this.allAspects.add(Aspect.AIR, 0);
        this.allAspects.add(Aspect.FIRE, 0);
        this.allAspects.add(Aspect.WATER, 0);
        this.allAspects.add(Aspect.EARTH, 0);
        this.allAspects.add(Aspect.ORDER, 0);
        this.allAspects.add(Aspect.ENTROPY, 0);
    }


    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }


    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.allAspects = this.tileentity.getAspectList();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        GlStateManager.enableBlend();
        drawTexturedModalRect(this.width / 2 - 88, this.height / 2 - 90, 0, 0, this.xSize, this.ySize + 15);


        this.tileentity.getClass();
        float perc = this.tileentity.getField(1) / 40.0F;
        drawTexturedModalRect(this.width / 2 - 52, Math.round((this.height / 2 - 14) + 1.0F - perc * 35.0F), 225, 119 + Math.round(1.0F - perc * 35.0F), 27, Math.round(perc * 35.0F));

        GlStateManager.disableBlend();
        drawTexturedModalRect(this.width / 2 - 15, this.height / 2 - 83, gemCoords[this.mode][0], gemCoords[this.mode][1], 30, 30);
        for (GuiAspectButton b : this.buttons) {

            if (!this.allAspects.aspects.containsKey(b.getAspect())) {
                this.allAspects.add(b.getAspect(), 0);
            }
            String s = Integer.toString(this.allAspects.getAmount(b.getAspect()));
            GlStateManager.scale(0.5F, 0.5F, 1.0F);
            drawString(this.mc.fontRenderer, s, (b.x + b.width / 2 - this.mc.fontRenderer.getStringWidth(s) / 2 + 6) * 2, (b.y - b.height / 2 + 3) * 2, b.getAspect().getColor());
            GlStateManager.scale(2.0F, 2.0F, 1.0F);
        }
    }


    public void initGui() {
        super.initGui();

        this.buttonList.add(new GuiTexturedButton(0, this.guiLeft + 60, this.guiTop - 1, 10, 9, "", TEXTURES, 185, 97, 256, 256));
        this.buttonList.add(new GuiTexturedButton(1, this.guiLeft + 107, this.guiTop - 1, 10, 9, "", TEXTURES, 185, 82, 256, 256));
        this.buttonList.add(new GuiTexturedButton(2, this.guiLeft + 128, this.guiTop + 55, 24, 16, "", TEXTURES, 229, 65, 256, 256));

        this.buttons.clear();
        this.buttons.add(new GuiAspectButton(3, this.width / 2 - 22, this.height / 2 - 42, 16, 16, Aspect.AIR, TEXTURES, 181, 120, 256, 256));
        this.buttons.add(new GuiAspectButton(4, this.width / 2 - 4, this.height / 2 - 42, 16, 16, Aspect.FIRE, TEXTURES, 181, 120, 256, 256));
        this.buttons.add(new GuiAspectButton(5, this.width / 2 + 14, this.height / 2 - 42, 16, 16, Aspect.EARTH, TEXTURES, 181, 120, 256, 256));
        this.buttons.add(new GuiAspectButton(6, this.width / 2 - 22, this.height / 2 - 17, 16, 16, Aspect.WATER, TEXTURES, 181, 120, 256, 256));
        this.buttons.add(new GuiAspectButton(7, this.width / 2 - 4, this.height / 2 - 17, 16, 16, Aspect.ORDER, TEXTURES, 181, 120, 256, 256));
        this.buttons.add(new GuiAspectButton(8, this.width / 2 + 14, this.height / 2 - 17, 16, 16, Aspect.ENTROPY, TEXTURES, 181, 120, 256, 256));

        for (GuiButton b : this.buttons) {
            this.buttonList.add(b);
        }
    }


    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 0) {

            NetworkHandler.sendToServer(new MessageGUIButton(this.tileentity, decrMode()));
        } else if (button.id == 1) {

            NetworkHandler.sendToServer(new MessageGUIButton(this.tileentity, incrMode()));
        } else if (button.id == 2) {

            NetworkHandler.sendToServer(new MessageButtonCraft(this.tileentity));
        }
        if (button.id > 2 && button.id < 9) {

            Aspect as = ((GuiAspectButton) button).getAspect();
            if (this.choosedAspects.aspects.containsKey(as)) {

                this.choosedAspects.remove(as);
            } else {

                this.choosedAspects.add(as, this.allAspects.getAmount(as));
            }
            NetworkHandler.sendToServer(new MessageServerChoosedAspects(this.tileentity, this.choosedAspects));
        }
    }


    public int incrMode() {
        if (this.mode < this.maxMode) {

            this.mode++;
        } else if (this.mode == this.maxMode) {

            this.mode = 0;
        }
        return this.mode;
    }

    public int decrMode() {
        if (this.mode > 0) {

            this.mode--;
        } else if (this.mode == 0) {

            this.mode = this.maxMode;
        }
        return this.mode;
    }
}