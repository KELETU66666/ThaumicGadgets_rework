package com.ancient.thaumicgadgets.util.handlers;


import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import com.ancient.thaumicgadgets.util.IPrimalArmorAbilities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class PlayerTickHandler
        implements IPrimalArmorAbilities {
    @SubscribeEvent
    public static void onEvent(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity()).world.isRemote) {
            if (event.getEntity() instanceof EntityPlayer) {

                EntityPlayer player = (EntityPlayer) event.getEntity();
                int[] i = {0, 0, 0, 0, 0, 0};
                int[] c = {0, 0, 0, 0, 0, 0, 0};
                for (ItemStack stack : player.inventory.armorInventory) {

                    if (stack.getTranslationKey().contains("primal")) {
                        if (stack.hasTagCompound()) {

                            i[stack.getTagCompound().getInteger("mode")] = i[stack.getTagCompound().getInteger("mode")] + 1;
                            if (stack.getItem() instanceof com.ancient.thaumicgadgets.armor.primal.ArmorPrimalUpgraded) {

                                NBTTagList nbt = stack.getTagCompound().getTagList("primalInventory", 10);
                                NBTTagCompound item = nbt.getCompoundTagAt(0);
                                c[IFunctionLibrary.getCrystalModeFromName((new ItemStack(item)).getTranslationKey())] = c[IFunctionLibrary.getCrystalModeFromName((new ItemStack(item)).getTranslationKey())] + 1;
                            }
                        }
                    }
                }
                EntityLivingBase ent = event.getEntityLiving();

                if (c[0] > 0) {
                    IPrimalArmorAbilities.ablilityAirCrystalTick(ent, null, c[0]);
                }

                if (c[1] == 4) {
                    IPrimalArmorAbilities.ablilityFireCrystalTick(ent, null, c[1]);
                }

                if (c[2] == 4) {
                    IPrimalArmorAbilities.ablilityWaterCrystalTick(ent, null, c[2]);
                }

                if (c[3] > 0) {
                    IPrimalArmorAbilities.ablilityEarthCrystalTick(ent, null, c[3]);
                }

                if (c[4] == 4) {
                    IPrimalArmorAbilities.ablilityOrdoCrystalTick(ent, null, c[4]);
                }

                if (c[5] == 4) {
                    IPrimalArmorAbilities.ablilityEntropyCrystalTick(ent, null, c[5]);
                }


                if (i[0] > 0) {
                    IPrimalArmorAbilities.abilityAirArmorTick((EntityLivingBase) player, null, i[0]);
                }
                if (i[1] == 4) {
                    IPrimalArmorAbilities.abilityFireArmorTick((EntityLivingBase) player, null, i[1]);
                }
                if (i[3] > 0) {
                    IPrimalArmorAbilities.abilityEarthArmorTick((EntityLivingBase) player, null, i[3]);
                }
            }
        }
    }

}