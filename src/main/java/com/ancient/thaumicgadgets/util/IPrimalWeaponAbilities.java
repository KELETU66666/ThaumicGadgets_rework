package com.ancient.thaumicgadgets.util;
import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;




public interface IPrimalWeaponAbilities
{
    public static final ParticleSpawner ps = ParticleSpawner.INSTANCE;


    static void abilityAxeFire(@Nullable EntityLivingBase entity, EntityLivingBase target, int modifier) {
        if (RandomFunctions.rand.nextInt(101) < 20)
        {
            if (target != null)
            {
                target.world.createExplosion((Entity)entity, target.posX, target.posY, target.posZ, modifier, false);
            }
        }
    }


    static void abilityAxeWater(@Nullable EntityLivingBase entity, EntityLivingBase target) {
        if (target != null) {

            target.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 60));
            target.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 60, 2));
        }
    }


    static float abilityAxeEarth(@Nullable EntityLivingBase entity, EntityLivingBase target, float amount, float modifier) {
        if (RandomFunctions.rand.nextInt(101) < 20) {

            ps.transferData(EnumParticleTypes.CRIT_MAGIC, RandomFunctions.rand.nextInt(2) + 3, target.posX, target.posY + (target.height / 2.0F), target.posZ, target.dimension);
            return amount * modifier;
        }
        return amount;
    }


    static float abilityAxeOrdo(@Nullable EntityLivingBase entity, EntityLivingBase target, float amount, float modifier) {
        int z = 0;
        for (ItemStack s : target.getArmorInventoryList()) {

            if (s.getItem() instanceof com.ancient.thaumicgadgets.armour.shade.ArmorShade)
            {
                z++;
            }
        }

        return (z == 4) ? (amount * modifier) : amount;
    }


    static float abilityAxeEntropy(@Nullable EntityLivingBase entity, EntityLivingBase target, float amount, float modifier) {
        int z = 0;
        for (ItemStack s : target.getArmorInventoryList()) {

            if (s.getItem() instanceof com.ancient.thaumicgadgets.armour.light.ArmorLight)
            {
                z++;
            }
        }

        return (z == 4) ? (amount * modifier) : amount;
    }


    static void abilityHammerAir(@Nullable EntityLivingBase entity, EntityLivingBase target) {
        if (RandomFunctions.rand.nextInt(101) < 20) {

            EntityLightningBolt entitybolt = new EntityLightningBolt(target.world, 0.0D, 0.0D, 0.0D, false);
            entitybolt.setLocationAndAngles(target.posX, target.posY, target.posZ, 0.0F, 0.0F);

            target.world.addWeatherEffect((Entity)entitybolt);
        }
    }


    static void abilityHammerFire(@Nullable EntityLivingBase entity, EntityLivingBase target) {
        if (RandomFunctions.rand.nextInt(101) < 20) {

            target.world.createExplosion((Entity)entity, target.posX, target.posY, target.posZ, 1.0F, false);
            target.setFire(3);
        }
    }


    static void abilityHammerWater(@Nullable EntityLivingBase entity, EntityLivingBase target) {
        if (RandomFunctions.rand.nextInt(101) < 50)
        {
            target.addPotionEffect(new PotionEffect(Potion.getPotionById(7), 5, 0));
        }
    }


    static void abilityHammerEarth(@Nullable EntityLivingBase entity, EntityLivingBase target) {
        if (RandomFunctions.rand.nextInt(101) < 25) {

            target.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 65, 6));
            target.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 65, -15));
            target.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 65, 4));
            target.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 65, 1));
            target.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 65));
            target.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 65));

            target.getEntityWorld().playSound(null, target.posX, target.posY, target.posZ, SoundEvents.ENTITY_LIGHTNING_THUNDER, SoundCategory.PLAYERS, 0.5F, 0.4F);
        }
    }


    static void abilityHammerOrdo(@Nullable EntityLivingBase entity, EntityLivingBase target) {
        for (ItemStack s : target.getArmorInventoryList()) {

            if (s.getItem() != Items.AIR) {

                s.damageItem(25, target);
                ps.transferData(EnumParticleTypes.CRIT_MAGIC, RandomFunctions.rand.nextInt(2) + 3, target.posX, target.posY + (target.height / 2.0F), target.posZ, target.dimension);
            }
        }
    }

    static void abilityHammerEntropy(@Nullable EntityLivingBase entity, EntityLivingBase target) {
        if (RandomFunctions.rand.nextInt(101) < 50)
        {
            target.addPotionEffect(new PotionEffect(Potion.getPotionById(20), 65, 1));
        }
    }
}