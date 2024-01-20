package com.ancient.thaumicgadgets.keys;

import baubles.api.BaublesApi;
import com.ancient.thaumicgadgets.gui.GuiChangeMode;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.network.MessageArmorAbility;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;


public class KeyInputHandler
{
    private Keybindings getPressedkey() {
        /* 24 */     for (Keybindings key : Keybindings.values()) {

            /* 26 */       if (key.isPressed())
            {
                /* 28 */         return key;
            }
        }
        /* 31 */     return null;
    }


    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {
        /* 37 */     Keybindings key = getPressedkey();
        /* 38 */     if (key != null)
        {
            /* 40 */       switch (key) {

            case OPEN_GUI:
                /* 43 */           Minecraft.getMinecraft().displayGuiScreen((GuiScreen)new GuiChangeMode());
                break;
            case ARMOR_ABILITY:
                /* 46 */           AbilityArmor();
                break;
        }
        }
    }


    private void AbilityArmor() {
        /* 57 */     EntityPlayerSP player = (Minecraft.getMinecraft()).player;
        /* 58 */     int li = 0;
        /* 59 */     int sh = 0;
        /* 60 */     for (ItemStack stack : player.inventory.armorInventory) {

            /* 62 */       if (!stack.getItem().equals(Items.AIR)) {

                /* 64 */         ItemArmor s = (ItemArmor)stack.getItem();
                /* 65 */         if (s instanceof com.ancient.thaumicgadgets.armor.light.ArmorLight)
                {
                    /* 67 */           li++;
                }
                /* 69 */         if (s instanceof com.ancient.thaumicgadgets.armor.shade.ArmorShade)
                {
                    /* 71 */           sh++;
                }
            }
        }
        /* 75 */     if (BaublesApi.isBaubleEquipped((EntityPlayer)player, ModItems.BELT_LIGHT) > -1)
        {
            /* 77 */       li++;
        }

        /* 80 */     if (BaublesApi.isBaubleEquipped((EntityPlayer)player, ModItems.BELT_SHADE) > -1)
        {
            /* 82 */       sh++;
        }

        /* 85 */     if (li == 5)
        {
            /* 87 */       NetworkHandler.sendToServer((IMessage)new MessageArmorAbility(1));
        }
        /* 89 */     if (sh == 5)
        {
            /* 91 */       NetworkHandler.sendToServer((IMessage)new MessageArmorAbility(0));
        }
    }
}


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\keys\KeyInputHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */