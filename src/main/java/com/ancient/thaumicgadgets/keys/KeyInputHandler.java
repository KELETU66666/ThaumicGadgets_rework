package com.ancient.thaumicgadgets.keys;

import baubles.api.BaublesApi;
import com.ancient.thaumicgadgets.gui.GuiChangeMode;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.network.MessageArmorAbility;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;


public class KeyInputHandler {
    private Keybindings getPressedkey() {
        for (Keybindings key : Keybindings.values()) {

            if (key.isPressed()) {
                return key;
            }
        }
        return null;
    }


    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {
        Keybindings key = getPressedkey();
        if (key != null) {
            switch (key) {

                case OPEN_GUI:
                    Minecraft.getMinecraft().displayGuiScreen(new GuiChangeMode());
                    break;
                case ARMOR_ABILITY:
                    AbilityArmor();
                    break;
            }
        }
    }


    private void AbilityArmor() {
        EntityPlayerSP player = (Minecraft.getMinecraft()).player;
        int li = 0;
        int sh = 0;
        for (ItemStack stack : player.inventory.armorInventory) {

            if (!stack.getItem().equals(Items.AIR)) {

                ItemArmor s = (ItemArmor) stack.getItem();
                if (s instanceof com.ancient.thaumicgadgets.armor.light.ArmorLight) {
                    li++;
                }
                if (s instanceof com.ancient.thaumicgadgets.armor.shade.ArmorShade) {
                    sh++;
                }
            }
        }
        if (BaublesApi.isBaubleEquipped(player, ModItems.BELT_LIGHT) > -1) {
            li++;
        }

        if (BaublesApi.isBaubleEquipped(player, ModItems.BELT_SHADE) > -1) {
            sh++;
        }

        if (li == 5) {
            NetworkHandler.sendToServer(new MessageArmorAbility(1));
        }
        if (sh == 5) {
            NetworkHandler.sendToServer(new MessageArmorAbility(0));
        }
    }
}
