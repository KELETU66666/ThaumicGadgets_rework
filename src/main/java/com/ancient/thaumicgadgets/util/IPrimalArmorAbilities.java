package com.ancient.thaumicgadgets.util;


import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import thaumcraft.common.lib.potions.PotionWarpWard;

import javax.annotation.Nullable;
import java.util.Random;


public interface IPrimalArmorAbilities {
    Random rand = new Random();


    static void abilityAirArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
        if (count == 1) {
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 0));
        }
        if (count == 2) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 0));
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 0));
        }
        if (count == 3) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 1));
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 0));
        }
        if (count == 4) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 1));
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 2));
        }
    }


    static void abilityFireArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
        entity.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 205, 0));
    }


    static void abilityEarthArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
        if (count < 4) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 205, 0));
        } else {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 205, 1));
        }
    }


    static void ablilityAirArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25) {
                source.addPotionEffect(new PotionEffect(Potion.getPotionById(25), 205, 0));
            }
        }
    }


    static void ablilityFireArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25 * count) {
                source.setFire(2);
            }
        }
    }


    static void ablilityWaterArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            source.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 205, 1));
        }
    }


    static void ablilityEarthArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {

            if (source instanceof EntityPlayer) {
                source.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 205, 2));
            }
            source.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 205, 0));
        }
    }


    static void ablilityOrdoArmorGetDamage(EntityLivingBase entity, @Nullable EntityLivingBase source, int count) {
        int modifier = (count > 0) ? count : 0;
        entity.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D * modifier);
    }


    static void ablilityEntropyArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            source.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 205, 1));
        }
    }


    static void ablilityAirCrystalTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
        if (entity instanceof EntityPlayer) {

            EntityPlayer ent = (EntityPlayer) entity;

            NonNullList<ItemStack> inv = ent.inventory.armorInventory;


            if (inv.get(0) != ItemStack.EMPTY) {

                ICheckEnchantment.canApplyEchantmentStatic(ent.inventory.armorInventory.get(0), 2, count);
                ICheckEnchantment.changeLvlEnchStatic(ent.inventory.armorInventory.get(0), new EnchantmentData(Enchantments.FEATHER_FALLING, count));
            }


            if (inv.get(1) != ItemStack.EMPTY) {
                ent.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 100, count - 1));
            }


            if (inv.get(2) != ItemStack.EMPTY) {


                AxisAlignedBB aabb = new AxisAlignedBB(ent.posX - (3 + count), ent.posY - (3 + count), ent.posZ - (3 + count), ent.posX + (3 + count), ent.posY + (3 + count), ent.posZ + (3 + count));
                for (EntityItem item : ent.world.getEntitiesWithinAABB(EntityItem.class, aabb)) {

                    if (item != null) {

                        double x = ent.posX - item.posX;
                        double y = ent.posY - item.posY;
                        double z = ent.posZ - item.posZ;
                        Vec3d vec = (new Vec3d(x, y, z)).normalize();
                        item.motionX = vec.x * 0.20000000298023224D;
                        item.motionY = vec.y * 0.20000000298023224D;
                        item.motionZ = vec.z * 0.20000000298023224D;
                    }
                }
            }

            if (inv.get(3) != ItemStack.EMPTY) {

                ICheckEnchantment.canApplyEchantmentStatic(ent.inventory.armorInventory.get(3), 5, count);
                ICheckEnchantment.changeLvlEnchStatic(ent.inventory.armorInventory.get(3), new EnchantmentData(Enchantments.RESPIRATION, count));
            }
        }

        if (count == 4) {

            AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - 3.0D, entity.posY - 3.0D, entity.posZ - 3.0D, entity.posX + 3.0D, entity.posY + 3.0D, entity.posZ + 3.0D);
            for (Entity projectile : entity.world.getEntitiesWithinAABB(Entity.class, aabb)) {

                if (projectile instanceof net.minecraft.entity.IProjectile || !projectile.getClass().getSimpleName().equalsIgnoreCase("IManaBurst")) {
                    EntityLivingBase entityLivingBase = source;

                    Entity shooter = null;
                    if (projectile instanceof EntityArrow) {
                        shooter = ((EntityArrow) projectile).shootingEntity;
                    } else if (projectile instanceof EntityThrowable) {
                        entityLivingBase = ((EntityThrowable) projectile).getThrower();
                    }
                    if (entityLivingBase != null) {

                        double delX = projectile.posX - entity.posX;
                        double delY = projectile.posY - entity.posY;
                        double delZ = projectile.posZ - entity.posZ;

                        double angle = (delX * projectile.motionX + delY * projectile.motionY + delZ * projectile.motionZ) / Math.sqrt(delX * delX + delY * delY + delZ * delZ) * Math.sqrt(projectile.motionX * projectile.motionX + projectile.motionY * projectile.motionY + projectile.motionZ * projectile.motionZ);
                        angle = Math.acos(angle);
                        if (angle < 2.356194490192345D) {
                            continue;
                        }
                        if (entityLivingBase != null) {

                            delX = -projectile.posX + entityLivingBase.posX;
                            delY = -projectile.posY + entityLivingBase.posY + entityLivingBase.getEyeHeight();
                            delZ = -projectile.posZ + entityLivingBase.posZ;
                        }


                        double curVel = Math.sqrt(delX * delX + delY * delY + delZ * delZ);
                        delX /= curVel;
                        delY /= curVel;
                        delZ /= curVel;
                        double newVel = Math.sqrt(projectile.motionX * projectile.motionX + projectile.motionY * projectile.motionY + projectile.motionZ * projectile.motionZ);
                        projectile.motionX = newVel * delX;
                        projectile.motionY = newVel * delY;
                        projectile.motionZ = newVel * delZ;
                    }
                }
            }
        }
    }


    static void ablilityFireCrystalTick(EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
        AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - 4.5D, entity.posY - 4.5D, entity.posZ - 4.5D, entity.posX + 4.5D, entity.posY + 4.5D, entity.posZ + 4.5D);
        for (Entity ent : entity.world.getEntitiesWithinAABB(Entity.class, aabb)) {

            if (ent != null) {
                if (ent instanceof EntityLivingBase) {

                    EntityLivingBase e = (EntityLivingBase) ent;
                    if (e.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
                        e.setFire(5);
                    }
                }
            }
        }

        if (entity != null && entity instanceof EntityLivingBase && count == 4) {
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 205, 0));
        }
    }


    static void ablilityWaterCrystalTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
        if (entity.getActivePotionEffects().size() > 0) {
            for (PotionEffect ef : (PotionEffect[]) entity.getActivePotionEffects().toArray((Object[]) new PotionEffect[0])) {

                if (ef.getPotion().equals(Potion.getPotionById(20)) || ef.getPotion().equals(Potion.getPotionById(19)) || ef.getPotion().equals(Potion.getPotionById(9))) {
                    entity.removePotionEffect(ef.getPotion());
                }
            }
        }
    }


    static void ablilityEarthCrystalTick(EntityLivingBase entity, @Nullable EntityLivingBase source, int count) {
        if (count <= 2) {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 100, (int) Math.floor((count / 2))));
        } else {

            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 100, (int) Math.ceil((count / 2))));
        }
        if (count == 4) {
            entity.addPotionEffect(new PotionEffect(Potion.getPotionById(22), 105, 4));
        }
    }


    static void ablilityOrdoCrystalTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
        Potion potion = PotionWarpWard.instance;
        entity.addPotionEffect(new PotionEffect(potion, 105));
    }


    static void ablilityEntropyCrystalTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
        AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - 2.5D, entity.posY - 2.5D, entity.posZ - 2.5D, entity.posX + 2.5D, entity.posY + 2.5D, entity.posZ + 2.5D);
        for (EntityLivingBase ent : entity.world.getEntitiesWithinAABB(EntityLivingBase.class, aabb)) {

            if (ent != entity) {
                if (ent.getActivePotionEffect(MobEffects.WITHER) == null) {
                    ent.addPotionEffect(new PotionEffect(Potion.getPotionById(20), 45, 1));
                }
            }
        }
    }


    static void ablilityFireCrystalGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25 * count) {

                source.knockBack(source, 5.0F, entity.posX - source.posX, entity.posZ - source.posZ);
                source.setFire(2);
            }
        }
    }


    static void ablilityWaterCrystalGetDamage(@Nullable EntityLivingBase entity, @Nullable int count, float damageAmount) {
        entity.heal(damageAmount * 0.15F * count);
    }


    static void ablilityOrdoCrystalGetDamage(EntityLivingBase entity, EntityLivingBase source, int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25 * count) {
                for (PotionEffect ef : (PotionEffect[]) source.getActivePotionEffects().toArray((Object[]) new PotionEffect[0])) {

                    if (!ef.getPotion().isBadEffect()) {

                        entity.addPotionEffect(ef);
                        source.removePotionEffect(ef.getPotion());
                    }
                }
            }
        }
    }


    static void ablilityEntropyCrystalGetDamage(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
        if (source != null) {
            if (rand.nextInt(101) < 25 * count) {
                if (source.getActivePotionEffect(MobEffects.POISON) == null) {
                    source.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 205, 1));
                }
            }
        }
    }
}