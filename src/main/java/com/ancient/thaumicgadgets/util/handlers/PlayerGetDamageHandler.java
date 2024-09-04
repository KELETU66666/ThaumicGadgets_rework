package com.ancient.thaumicgadgets.util.handlers;


import com.ancient.thaumicgadgets.armor.primal.ArmorPrimal;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.tools.primal.ToolAxePrimal;
import com.ancient.thaumicgadgets.tools.primal.ToolPickaxePrimal;
import com.ancient.thaumicgadgets.util.IPrimalArmorAbilities;
import com.ancient.thaumicgadgets.util.IPrimalWeaponAbilities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class PlayerGetDamageHandler implements IPrimalArmorAbilities {
    @SubscribeEvent
    public static void onEvent(LivingHurtEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {

            int[] count = {0, 0, 0, 0, 0, 0};
            int[] c = {0, 0, 0, 0, 0, 0, 0};

            for (ItemStack s : event.getEntity().getArmorInventoryList()) {

                if (s.getTranslationKey().contains("primal")) {

                    if (s.hasTagCompound()) {
                        count[s.getTagCompound().getInteger("mode")] = count[s.getTagCompound().getInteger("mode")] + 1;
                    }
                    ArmorPrimal armor = (ArmorPrimal) s.getItem();
                    armor.OnPlayerHurt((EntityPlayer) event.getEntity(), event.getSource(), event.getAmount());
                }
            }


            EntityLivingBase source = null;
            EntityLivingBase ent = event.getEntityLiving();
            if (event.getSource().getTrueSource() instanceof EntityLivingBase) {
                source = (EntityLivingBase) event.getSource().getTrueSource();
            }
            if (source != null) {


                if (count[0] == 4) {
                    IPrimalArmorAbilities.ablilityAirArmorGetDamage(null, source, count[0]);
                }

                if (count[1] > 0) {
                    IPrimalArmorAbilities.ablilityFireArmorGetDamage(null, source, count[1]);
                }

                if (count[2] == 4) {
                    IPrimalArmorAbilities.ablilityWaterArmorGetDamage(null, source, count[2]);
                }

                if (count[3] == 4) {
                    IPrimalArmorAbilities.ablilityEarthArmorGetDamage(null, source, count[3]);
                }

                IPrimalArmorAbilities.ablilityOrdoArmorGetDamage(ent, null, count[4]);

                if (count[5] == 4) {
                    IPrimalArmorAbilities.ablilityEntropyArmorGetDamage(null, source, count[5]);
                }


                if (c[1] > 0) {
                    IPrimalArmorAbilities.ablilityFireCrystalGetDamage(ent, source, c[1]);
                }

                if (c[2] > 0) {
                    IPrimalArmorAbilities.ablilityWaterCrystalGetDamage(ent, c[2], event.getAmount());
                }

                if (c[4] > 0) {
                    IPrimalArmorAbilities.ablilityOrdoCrystalGetDamage(ent, source, c[4]);
                }

                if (c[5] > 0) {
                    IPrimalArmorAbilities.ablilityEntropyCrystalGetDamage(null, source, c[5]);
                }
            }
        }

        if (event.getSource().getTrueSource() instanceof EntityLivingBase) {

            EntityLivingBase entity = (EntityLivingBase) event.getSource().getTrueSource();
            ItemStack stack = entity.getHeldItemMainhand();
            EntityLivingBase target = (EntityLivingBase) event.getEntity();
            if (stack.getItem() == ModItems.AXE_PRIMAL) {

                ToolAxePrimal axe = (ToolAxePrimal) stack.getItem();
                int mode = stack.getTagCompound().getInteger("mode");

                if (mode == 1) {

                    IPrimalWeaponAbilities.abilityAxeFire(entity, target, 1);
                } else if (mode == 2) {

                    IPrimalWeaponAbilities.abilityAxeWater(null, target);
                } else if (mode == 3) {

                    event.setAmount(IPrimalWeaponAbilities.abilityAxeEarth(null, target, event.getAmount(), 1.5F));
                } else if (mode == 4) {

                    event.setAmount(IPrimalWeaponAbilities.abilityAxeOrdo(null, entity, event.getAmount(), 2.0F));
                } else if (mode == 5) {

                    event.setAmount(IPrimalWeaponAbilities.abilityAxeEntropy(null, entity, event.getAmount(), 2.0F));
                }
            }

            if (stack.getItem() == ModItems.HAMMER_PRIMAL) {

                ToolPickaxePrimal axe = (ToolPickaxePrimal) stack.getItem();
                int mode = stack.getTagCompound().getInteger("mode");

                if (mode == 0) {

                    IPrimalWeaponAbilities.abilityHammerAir(null, target);
                } else if (mode == 1) {

                    IPrimalWeaponAbilities.abilityHammerFire(null, target);
                } else if (mode == 2) {

                    IPrimalWeaponAbilities.abilityHammerWater(null, target);
                } else if (mode == 3) {

                    IPrimalWeaponAbilities.abilityHammerEarth(null, target);
                } else if (mode == 4) {

                    IPrimalWeaponAbilities.abilityHammerOrdo(null, target);
                } else if (mode == 5) {

                    IPrimalWeaponAbilities.abilityHammerEntropy(null, target);
                }
            }

            if (stack.getItem() == ModItems.SWORD_SHADE) {

                int[] z = {0, 0};
                for (ItemStack s : target.getArmorInventoryList()) {

                    if (s.getTranslationKey().contains("light")) {

                        z[0] = z[0] + 1;
                        continue;
                    }
                    if (s.getTranslationKey().contains("shade")) {
                        z[1] = z[1] + 1;
                    }
                }
                if (z[0] == 4) {

                    event.setAmount(event.getAmount() * 2.0F);
                } else if (z[1] == 4) {

                    event.setAmount(event.getAmount() * 0.5F);
                }
            }
            if (stack.getItem() == ModItems.SWORD_LIGHT) {

                int[] z = {0, 0};
                for (ItemStack s : target.getArmorInventoryList()) {

                    if (s.getTranslationKey().contains("light")) {

                        z[0] = z[0] + 1;
                        continue;
                    }
                    if (s.getTranslationKey().contains("shade")) {
                        z[1] = z[1] + 1;
                    }
                }
                if (z[0] == 4) {

                    event.setAmount(event.getAmount() * 0.5F);
                } else if (z[1] == 4) {

                    event.setAmount(event.getAmount() * 2.0F);
                }
            }
        }
    }
}