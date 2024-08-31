package com.ancient.thaumicgadgets.gui;


import com.ancient.thaumicgadgets.armor.primal.ArmorPrimal;
import com.ancient.thaumicgadgets.network.MessageChangeModeArmor;
import com.ancient.thaumicgadgets.network.MessageChangeModeWeapon;
import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class GuiChangeMode
        extends GuiScreen {
    private static final ResourceLocation HELMET_LOC = new ResourceLocation("thaumicgadgets", "textures/items/helmet_primal.png");
    private static final ResourceLocation CHEST_LOC = new ResourceLocation("thaumicgadgets", "textures/items/chestplate_primal.png");
    private static final ResourceLocation LEGGINS_LOC = new ResourceLocation("thaumicgadgets", "textures/items/leggins_primal.png");
    private static final ResourceLocation BOOTS_LOC = new ResourceLocation("thaumicgadgets", "textures/items/boots_primal.png");
    private static final ResourceLocation HAMMER_LOC = new ResourceLocation("thaumicgadgets", "textures/items/hammer_primal.png");
    private static final ResourceLocation SWORD_LOC = new ResourceLocation("thaumicgadgets", "textures/items/sword_primal.png");
    private static final ResourceLocation AXE_LOC = new ResourceLocation("thaumicgadgets", "textures/items/axe_primal.png");
    private static final ResourceLocation BACKGROUND = new ResourceLocation("thaumicgadgets", "textures/gui/change_mode.png");


    public void initGui() {
        super.initGui();

        EntityPlayerSP entityPlayerSP = this.mc.player;
        NonNullList<ItemStack> list = entityPlayerSP.inventory.armorInventory;

        for (ItemStack stack : list) {

            if (stack != null && stack.getTranslationKey().contains("primal")) {

                if (stack.getTranslationKey().contains("helmet")) {
                    this.buttonList.add(new GuiTexturedButton(3, this.width / 2 - 64, this.height / 2 - 68, 32, 32, "", HELMET_LOC, 32, 32, 32, 32));
                }
                if (stack.getTranslationKey().contains("chest")) {
                    this.buttonList.add(new GuiTexturedButton(2, this.width / 2 + 30, this.height / 2 - 68, 32, 32, "", CHEST_LOC, 0, 0, 32, 32));
                }
                if (stack.getTranslationKey().contains("leggins")) {
                    this.buttonList.add(new GuiTexturedButton(1, this.width / 2 - 68, this.height / 2 + 30, 32, 32, "", LEGGINS_LOC, 0, 0, 32, 32));
                }
                if (stack.getTranslationKey().contains("boots")) {
                    this.buttonList.add(new GuiTexturedButton(0, this.width / 2 + 30, this.height / 2 + 30, 32, 32, "", BOOTS_LOC, 0, 0, 32, 32));
                }
            }
        }

        ItemStack stackRightHand = entityPlayerSP.getHeldItemMainhand();
        if (stackRightHand.getTranslationKey().contains("primal")) {
            if (stackRightHand.getTranslationKey().contains("axe")) {

                this.buttonList.add(new GuiTexturedButton(4, this.width / 2 - 16, this.height / 2 - 16, 32, 32, "", AXE_LOC, 0, 0, 32, 32));
            } else if (stackRightHand.getTranslationKey().contains("sword")) {

                this.buttonList.add(new GuiTexturedButton(4, this.width / 2 - 16, this.height / 2 - 16, 32, 32, "", SWORD_LOC, 0, 32, 32, 32));
            } else if (stackRightHand.getTranslationKey().contains("hammer")) {

                this.buttonList.add(new GuiTexturedButton(4, this.width / 2 - 16, this.height / 2 - 16, 32, 32, "", HAMMER_LOC, 0, 0, 32, 32));
            }
        }
    }


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(BACKGROUND);
        GlStateManager.enableBlend();
        drawTexturedModalRect(this.width / 2 - 128, this.height / 2 - 128, 0, 0, 256, 256);
        GlStateManager.disableBlend();
        super.drawScreen(mouseX, mouseY, partialTicks);

        EntityPlayerSP entityPlayerSP = this.mc.player;
        NonNullList<ItemStack> list = entityPlayerSP.inventory.armorInventory;
        for (ItemStack stack : list) {

            if (stack != null && stack.getTranslationKey().contains("primal")) {

                ArmorPrimal l = (ArmorPrimal) stack.getItem();
                int i = l.getEquipmentSlot().getIndex();

                for (GuiButton b : this.buttonList) {

                    if (b.id == i) {
                        if (IFunctionLibrary.isPointInRegion(b.x, b.y, b.width, b.height, mouseX, mouseY)) {
                            drawHoveringText(entityPlayerSP.inventory.armorInventory.get(i).getTooltip(entityPlayerSP, ITooltipFlag.TooltipFlags.NORMAL), mouseX, mouseY);
                        }
                    }
                }
            }
        }

        ItemStack stackRightHand = entityPlayerSP.getHeldItemMainhand();
        for (GuiButton b : this.buttonList) {

            if (b.id == 4) {
                if (stackRightHand.getTranslationKey().contains("sword_primal") || stackRightHand.getTranslationKey().contains("axe_primal") || stackRightHand.getTranslationKey().contains("hammer_primal")) {
                    if (IFunctionLibrary.isPointInRegion(b.x, b.y, b.width, b.height, mouseX, mouseY)) {
                        drawHoveringText(stackRightHand.getTooltip(entityPlayerSP, ITooltipFlag.TooltipFlags.NORMAL), mouseX, mouseY);
                    }
                }
            }
        }
    }


    public boolean doesGuiPauseGame() {
        return false;
    }


    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 4) {


            EntityPlayerSP entityPlayerSP = (Minecraft.getMinecraft()).player;
            NetworkHandler.sendToServer(new MessageChangeModeWeapon(entityPlayerSP.inventory.getSlotFor(entityPlayerSP.getHeldItemMainhand())));
        }

        if (button.id <= 3) {

            NetworkHandler.sendToServer(new MessageChangeModeArmor(button.id));
        }
    }
}