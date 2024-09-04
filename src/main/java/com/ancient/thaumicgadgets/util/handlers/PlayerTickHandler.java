package com.ancient.thaumicgadgets.util.handlers;


import com.ancient.thaumicgadgets.util.IPrimalArmorAbilities;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class PlayerTickHandler implements IPrimalArmorAbilities {
    @SubscribeEvent
    public static void onEvent(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity()).world.isRemote) {
            if (event.getEntity() instanceof EntityPlayer) {

                EntityPlayer player = (EntityPlayer) event.getEntity();
                int[] i = {0, 0, 0, 0, 0, 0};
                for (ItemStack stack : player.inventory.armorInventory) {

                    if (stack.getTranslationKey().contains("primal")) {
                        if (stack.hasTagCompound()) {
                            i[stack.getTagCompound().getInteger("mode")] = i[stack.getTagCompound().getInteger("mode")] + 1;
                        }
                    }
                }

                if (i[0] > 0) {
                    IPrimalArmorAbilities.abilityAirArmorTick(player, null, i[0]);
                }
                if (i[1] == 4) {
                    IPrimalArmorAbilities.abilityFireArmorTick(player, null, i[1]);
                }
                if (i[3] > 0) {
                    IPrimalArmorAbilities.abilityEarthArmorTick(player, null, i[3]);
                }
            }
        }
    }

}