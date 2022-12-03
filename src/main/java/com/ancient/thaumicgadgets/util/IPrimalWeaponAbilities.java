/*     */ package com.ancient.thaumicgadgets.util;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
/*     */ import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.effect.EntityLightningBolt;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface IPrimalWeaponAbilities
/*     */ {
/*  22 */   public static final ParticleSpawner ps = ParticleSpawner.INSTANCE;
/*     */ 
/*     */   
/*     */   static void abilityAxeFire(@Nullable EntityLivingBase entity, EntityLivingBase target, int modifier) {
/*  26 */     if (RandomFunctions.rand.nextInt(101) < 20)
/*     */     {
/*  28 */       if (target != null)
/*     */       {
/*  30 */         target.world.createExplosion((Entity)entity, target.posX, target.posY, target.posZ, modifier, false);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void abilityAxeWater(@Nullable EntityLivingBase entity, EntityLivingBase target) {
/*  37 */     if (target != null) {
/*     */       
/*  39 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 60));
/*  40 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 60, 2));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static float abilityAxeEarth(@Nullable EntityLivingBase entity, EntityLivingBase target, float amount, float modifier) {
/*  46 */     if (RandomFunctions.rand.nextInt(101) < 20) {
/*     */       
/*  48 */       ps.transferData(EnumParticleTypes.CRIT_MAGIC, RandomFunctions.rand.nextInt(2) + 3, target.posX, target.posY + (target.height / 2.0F), target.posZ, target.dimension);
/*  49 */       return amount * modifier;
/*     */     } 
/*  51 */     return amount;
/*     */   }
/*     */ 
/*     */   
/*     */   static float abilityAxeOrdo(@Nullable EntityLivingBase entity, EntityLivingBase target, float amount, float modifier) {
/*  56 */     int z = 0;
/*  57 */     for (ItemStack s : target.getArmorInventoryList()) {
/*     */       
/*  59 */       if (s.getItem() instanceof com.ancient.thaumicgadgets.armour.shade.ArmorShade)
/*     */       {
/*  61 */         z++;
/*     */       }
/*     */     } 
/*     */     
/*  65 */     return (z == 4) ? (amount * modifier) : amount;
/*     */   }
/*     */ 
/*     */   
/*     */   static float abilityAxeEntropy(@Nullable EntityLivingBase entity, EntityLivingBase target, float amount, float modifier) {
/*  70 */     int z = 0;
/*  71 */     for (ItemStack s : target.getArmorInventoryList()) {
/*     */       
/*  73 */       if (s.getItem() instanceof com.ancient.thaumicgadgets.armour.light.ArmorLight)
/*     */       {
/*  75 */         z++;
/*     */       }
/*     */     } 
/*     */     
/*  79 */     return (z == 4) ? (amount * modifier) : amount;
/*     */   }
/*     */ 
/*     */   
/*     */   static void abilityHammerAir(@Nullable EntityLivingBase entity, EntityLivingBase target) {
/*  84 */     if (RandomFunctions.rand.nextInt(101) < 20) {
/*     */       
/*  86 */       EntityLightningBolt entitybolt = new EntityLightningBolt(target.world, 0.0D, 0.0D, 0.0D, false);
/*  87 */       entitybolt.setLocationAndAngles(target.posX, target.posY, target.posZ, 0.0F, 0.0F);
/*     */       
/*  89 */       target.world.addWeatherEffect((Entity)entitybolt);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void abilityHammerFire(@Nullable EntityLivingBase entity, EntityLivingBase target) {
/*  95 */     if (RandomFunctions.rand.nextInt(101) < 20) {
/*     */       
/*  97 */       target.world.createExplosion((Entity)entity, target.posX, target.posY, target.posZ, 1.0F, false);
/*  98 */       target.setFire(3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void abilityHammerWater(@Nullable EntityLivingBase entity, EntityLivingBase target) {
/* 104 */     if (RandomFunctions.rand.nextInt(101) < 50)
/*     */     {
/* 106 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(7), 5, 0));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void abilityHammerEarth(@Nullable EntityLivingBase entity, EntityLivingBase target) {
/* 112 */     if (RandomFunctions.rand.nextInt(101) < 25) {
/*     */       
/* 114 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 65, 6));
/* 115 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 65, -15));
/* 116 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 65, 4));
/* 117 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 65, 1));
/* 118 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 65));
/* 119 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 65));
/*     */       
/* 121 */       target.getEntityWorld().playSound(null, target.posX, target.posY, target.posZ, SoundEvents.ENTITY_LIGHTNING_THUNDER, SoundCategory.PLAYERS, 0.5F, 0.4F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void abilityHammerOrdo(@Nullable EntityLivingBase entity, EntityLivingBase target) {
/* 127 */     for (ItemStack s : target.getArmorInventoryList()) {
/*     */       
/* 129 */       if (s.getItem() != Items.AIR) {
/*     */         
/* 131 */         s.damageItem(25, target);
/* 132 */         ps.transferData(EnumParticleTypes.CRIT_MAGIC, RandomFunctions.rand.nextInt(2) + 3, target.posX, target.posY + (target.height / 2.0F), target.posZ, target.dimension);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   static void abilityHammerEntropy(@Nullable EntityLivingBase entity, EntityLivingBase target) {
/* 138 */     if (RandomFunctions.rand.nextInt(101) < 50)
/*     */     {
/* 140 */       target.addPotionEffect(new PotionEffect(Potion.getPotionById(20), 65, 1));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\IPrimalWeaponAbilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */