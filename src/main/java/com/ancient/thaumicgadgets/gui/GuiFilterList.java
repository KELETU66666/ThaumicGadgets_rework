package com.ancient.thaumicgadgets.gui;


import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.util.List;


public class GuiFilterList
        extends Gui {
    protected static final ResourceLocation TEXTURE = new ResourceLocation("thaumicgadgets", "textures/gui/gui.png");
    private final GuiTextField field;
    public String fieldText = "";
    private final GuiButtonListRL[] lrButtons = new GuiButtonListRL[2];
    private GuiLabel lbl;
    private final FontRenderer fontRenderer;
    private final int id;
    public int x;
    public int y;
    public int width;
    public int height;
    private final int backTextureX;
    private final int backTextureY;
    public List<String> displayList = Lists.newArrayList();
    public List<GuiButtonActiveText> buttons = Lists.newArrayList();
    public int textColor;
    public boolean isEnabled;
    public boolean visible;
    public int currentPage;
    private int maxPage;
    public int buttonsPerPage;
    private int choosedButton = -1;


    public GuiFilterList(int id, int x, int y, int width, int height, List<String> displayList, int buttonsPerPage, FontRenderer fontRenderer, int textColor, int backTextureX, int backTextureY) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backTextureX = backTextureX;
        this.backTextureY = backTextureY;
        this.displayList = displayList;
        this.fontRenderer = fontRenderer;
        this.textColor = textColor;
        int divW = width / 2;
        int divH = height / 2;
        this.lrButtons[0] = new GuiButtonListRL(id + 1, x + divW - 10, y + height - 13, 8, 8, "left", TEXTURE, 198, 142, 256, 256);
        this.lrButtons[1] = new GuiButtonListRL(id + 2, x + divW + 10, y + height - 13, 8, 8, "right", TEXTURE, 174, 142, 256, 256);
        this.field = new GuiTextField(id + 4, fontRenderer, x + 6, y + 6, width - 25, 13);
        this.field.setFocused(true);
        this.buttonsPerPage = buttonsPerPage;
        this.maxPage = 0;
        if (!displayList.isEmpty()) {

            int q = 0;
            int z = 0;
            for (String s : displayList) {

                this.buttons.add(new GuiButtonActiveText(id + 5 + q, q, x + 5, y + 5 + this.field.height + 5 + z * 16, width - 10, 13, s, 12072391, 14737632));
                q++;
                if (++z % buttonsPerPage == 0)
                    z = 0;
            }
            this.maxPage = Math.floorDiv(displayList.size(), buttonsPerPage);
        }
        this.visible = true;
    }


    public void drawFilterList(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (this.visible) {

            GlStateManager.pushMatrix();

            mc.getTextureManager().bindTexture(TEXTURE);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            drawTexturedModalRect(this.x, this.y, this.backTextureX, this.backTextureY, this.width, this.height);
            drawTexturedModalRect(this.x + this.width - 16, this.y + 8, 200, 84, 9, 8);
            GlStateManager.disableBlend();

            if (!this.displayList.isEmpty()) {

                this.lrButtons[0].drawButton(mc, mouseX, mouseY, partialTicks);
                this.lrButtons[1].drawButton(mc, mouseX, mouseY, partialTicks);
                this.lbl = new GuiLabel(this.fontRenderer, this.id + 3, this.x + this.width / 2 + 1, this.y + this.height - 12, 8, 8, this.textColor);
                this.lbl.addLine(Integer.toString(this.currentPage));
                this.lbl.drawLabel(mc, mouseX, mouseY);
                this.field.drawTextBox();
                int t = this.currentPage * this.buttonsPerPage;
                int q = 0;
                for (GuiButton b : updateList()) {

                    if (q >= t && q < t + this.buttonsPerPage) {

                        b.enabled = true;
                        b.visible = true;
                        b.drawButton(mc, mouseX, mouseY, partialTicks);
                    } else {

                        b.enabled = false;
                        b.visible = false;
                    }
                    q++;
                }
            }

            GlStateManager.popMatrix();
        }
    }


    public void setCurrentPage(int value) {
        if (value >= 0) {

            if (value <= this.maxPage) {
                this.currentPage = value;
            } else {
                this.currentPage = this.maxPage;
            }

        } else {

            this.currentPage = 0;
        }
    }


    public void incrPage() {
        if (this.currentPage < this.maxPage) {

            this.currentPage++;
        } else if (this.currentPage == this.maxPage) {

            this.currentPage = 0;
        }
    }

    public void decrPage() {
        if (this.currentPage > 0) {

            this.currentPage--;
        } else if (this.currentPage == 0) {

            this.currentPage = this.maxPage;
        }
    }


    public GuiTextField getField() {
        return this.field;
    }


    public GuiLabel getLabel() {
        return this.lbl;
    }


    public GuiButtonListRL[] getLRButtons() {
        return this.lrButtons;
    }


    public List<GuiButtonActiveText> getButtons() {
        return this.buttons;
    }


    public int getId() {
        return this.id;
    }


    public int getChoosedButton() {
        return this.choosedButton;
    }


    public void setChoosedButton(int value) {
        if (value < 0) {
            value = -1;
        }
        if (value >= this.displayList.size()) {
            value = this.displayList.size() - 1;
        }
        this.choosedButton = value;
    }


    protected List<GuiButtonActiveText> updateList() {
        List<Integer> afterFilter = filterList();
        List<GuiButtonActiveText> buttons = Lists.newArrayList();


        int i = 0, q = 0;

        for (GuiButtonActiveText b : this.buttons) {

            if (afterFilter.contains(i)) {

                b.y = this.y + 5 + this.field.height + 5 + q * 16;
                if (++q % this.buttonsPerPage == 0) {
                    q = 0;
                }

                b.enabled = true;
                b.visible = true;
                buttons.add(b);
            } else {

                b.enabled = false;
                b.visible = false;
            }
            i++;
        }

        return buttons;
    }


    public List<Integer> filterList() {
        List<Integer> dummyList = Lists.newArrayList();

        if (this.fieldText.equals("")) {

            for (int q = 0; q < this.displayList.size(); q++) {
                dummyList.add(q);
            }
            return dummyList;
        }


        if (!this.displayList.isEmpty()) {
            for (int q = 0; q < this.displayList.size(); q++) {

                if (this.displayList.get(q).toLowerCase().contains(this.fieldText.toLowerCase())) {
                    dummyList.add(q);
                }
            }
        }


        return dummyList;
    }
}