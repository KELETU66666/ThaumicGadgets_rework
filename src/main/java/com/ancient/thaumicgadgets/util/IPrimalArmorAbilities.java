/*     */ package com.ancient.thaumicgadgets.util;
/*     */ 
/*     */ import java.util.Random;
/*     */ import javax.annotation.Nullable;
/*     */ import net.minecraft.enchantment.EnchantmentData;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.init.MobEffects;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import thaumcraft.common.lib.potions.PotionWarpWard;
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface IPrimalArmorAbilities
/*     */ {
/*  28 */   public static final Random rand = new Random();
/*     */ 
/*     */   
/*     */   static void abilityAirArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
/*  32 */     if (count == 1)
/*     */     {
/*  34 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 0));
/*     */     }
/*  36 */     if (count == 2) {
/*     */       
/*  38 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 0));
/*  39 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 0));
/*     */     } 
/*  41 */     if (count == 3) {
/*     */       
/*  43 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 1));
/*  44 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 0));
/*     */     } 
/*  46 */     if (count == 4) {
/*     */       
/*  48 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 25, 1));
/*  49 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 25, 2));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void abilityFireArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
/*  55 */     entity.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 205, 0));
/*     */   }
/*     */ 
/*     */   
/*     */   static void abilityEarthArmorTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase target, @Nullable int count) {
/*  60 */     if (count < 4) {
/*     */       
/*  62 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 205, 0));
/*     */     }
/*     */     else {
/*     */       
/*  66 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 205, 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityAirArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
/*  72 */     if (source != null)
/*     */     {
/*  74 */       if (rand.nextInt(101) < 25)
/*     */       {
/*  76 */         source.addPotionEffect(new PotionEffect(Potion.getPotionById(25), 205, 0));
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityFireArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
/*  83 */     if (source != null)
/*     */     {
/*  85 */       if (rand.nextInt(101) < 25 * count)
/*     */       {
/*  87 */         source.setFire(2);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityWaterArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
/*  94 */     if (source != null)
/*     */     {
/*  96 */       source.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 205, 1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityEarthArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
/* 102 */     if (source != null) {
/*     */       
/* 104 */       if (source instanceof EntityPlayer)
/*     */       {
/* 106 */         source.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 205, 2));
/*     */       }
/* 108 */       source.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 205, 0));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityOrdoArmorGetDamage(EntityLivingBase entity, @Nullable EntityLivingBase source, int count) {
/* 114 */     int modifier = (count > 0) ? count : 0;
/* 115 */     entity.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D * modifier);
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityEntropyArmorGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
/* 120 */     if (source != null)
/*     */     {
/* 122 */       source.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 205, 1));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityAirCrystalTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
/* 128 */     if (entity instanceof EntityPlayer) {
/*     */       
/* 130 */       EntityPlayer ent = (EntityPlayer)entity;
/*     */       
/* 132 */       NonNullList<ItemStack> inv = ent.inventory.armorInventory;
/*     */ 
/*     */       
/* 135 */       if (inv.get(0) != ItemStack.EMPTY) {
/*     */         
/* 137 */         ICheckEnchantment.canApplyEchantmentStatic((ItemStack)ent.inventory.armorInventory.get(0), 2, count);
/* 138 */         ICheckEnchantment.changeLvlEnchStatic((ItemStack)ent.inventory.armorInventory.get(0), new EnchantmentData(Enchantments.FEATHER_FALLING, count));
/*     */       } 
/*     */ 
/*     */       
/* 142 */       if (inv.get(1) != ItemStack.EMPTY)
/*     */       {
/* 144 */         ent.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 100, count - 1));
/*     */       }
/*     */ 
/*     */       
/* 148 */       if (inv.get(2) != ItemStack.EMPTY) {
/*     */ 
/*     */         
/* 151 */         AxisAlignedBB aabb = new AxisAlignedBB(ent.posX - (3 + count), ent.posY - (3 + count), ent.posZ - (3 + count), ent.posX + (3 + count), ent.posY + (3 + count), ent.posZ + (3 + count));
/* 152 */         for (EntityItem item : ent.world.getEntitiesWithinAABB(EntityItem.class, aabb)) {
/*     */           
/* 154 */           if (item != null) {
/*     */             
/* 156 */             double x = ent.posX - item.posX;
/* 157 */             double y = ent.posY - item.posY;
/* 158 */             double z = ent.posZ - item.posZ;
/* 159 */             Vec3d vec = (new Vec3d(x, y, z)).normalize();
/* 160 */             item.motionX = vec.x * 0.20000000298023224D;
/* 161 */             item.motionY = vec.y * 0.20000000298023224D;
/* 162 */             item.motionZ = vec.z * 0.20000000298023224D;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 167 */       if (inv.get(3) != ItemStack.EMPTY) {
/*     */         
/* 169 */         ICheckEnchantment.canApplyEchantmentStatic((ItemStack)ent.inventory.armorInventory.get(3), 5, count);
/* 170 */         ICheckEnchantment.changeLvlEnchStatic((ItemStack)ent.inventory.armorInventory.get(3), new EnchantmentData(Enchantments.RESPIRATION, count));
/*     */       } 
/*     */     } 
/*     */     
/* 174 */     if (count == 4) {
/*     */       
/* 176 */       AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - 3.0D, entity.posY - 3.0D, entity.posZ - 3.0D, entity.posX + 3.0D, entity.posY + 3.0D, entity.posZ + 3.0D);
/* 177 */       for (Entity projectile : entity.world.getEntitiesWithinAABB(Entity.class, aabb)) {
/*     */         
/* 179 */         if (projectile instanceof net.minecraft.entity.IProjectile || !projectile.getClass().getSimpleName().equalsIgnoreCase("IManaBurst")) {
/*     */           EntityLivingBase entityLivingBase = source;
/*     */           
/* 182 */           Entity shooter = null;
/* 183 */           if (projectile instanceof EntityArrow) {
/* 184 */             shooter = ((EntityArrow)projectile).shootingEntity;
/* 185 */           } else if (projectile instanceof EntityThrowable) {
/* 186 */             entityLivingBase = ((EntityThrowable)projectile).getThrower();
/*     */           } 
/* 188 */           if (entityLivingBase != null) {
/*     */             
/* 190 */             double delX = projectile.posX - entity.posX;
/* 191 */             double delY = projectile.posY - entity.posY;
/* 192 */             double delZ = projectile.posZ - entity.posZ;
/*     */             
/* 194 */             double angle = (delX * projectile.motionX + delY * projectile.motionY + delZ * projectile.motionZ) / Math.sqrt(delX * delX + delY * delY + delZ * delZ) * Math.sqrt(projectile.motionX * projectile.motionX + projectile.motionY * projectile.motionY + projectile.motionZ * projectile.motionZ);
/* 195 */             angle = Math.acos(angle);
/* 196 */             if (angle < 2.356194490192345D) {
/*     */               continue;
/*     */             }
/* 199 */             if (entityLivingBase != null) {
/*     */               
/* 201 */               delX = -projectile.posX + ((Entity)entityLivingBase).posX;
/* 202 */               delY = -projectile.posY + ((Entity)entityLivingBase).posY + entityLivingBase.getEyeHeight();
/* 203 */               delZ = -projectile.posZ + ((Entity)entityLivingBase).posZ;
/*     */             } 
/*     */ 
/*     */             
/* 207 */             double curVel = Math.sqrt(delX * delX + delY * delY + delZ * delZ);
/* 208 */             delX /= curVel;
/* 209 */             delY /= curVel;
/* 210 */             delZ /= curVel;
/* 211 */             double newVel = Math.sqrt(projectile.motionX * projectile.motionX + projectile.motionY * projectile.motionY + projectile.motionZ * projectile.motionZ);
/* 212 */             projectile.motionX = newVel * delX;
/* 213 */             projectile.motionY = newVel * delY;
/* 214 */             projectile.motionZ = newVel * delZ;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityFireCrystalTick(EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
/* 223 */     AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - 4.5D, entity.posY - 4.5D, entity.posZ - 4.5D, entity.posX + 4.5D, entity.posY + 4.5D, entity.posZ + 4.5D);
/* 224 */     for (Entity ent : entity.world.getEntitiesWithinAABB(Entity.class, aabb)) {
/*     */       
/* 226 */       if (ent != null)
/*     */       {
/* 228 */         if (ent instanceof EntityLivingBase) {
/*     */           
/* 230 */           EntityLivingBase e = (EntityLivingBase)ent;
/* 231 */           if (e.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD)
/*     */           {
/* 233 */             e.setFire(5);
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 239 */     if (entity != null && entity instanceof EntityLivingBase && count == 4)
/*     */     {
/* 241 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 205, 0));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityWaterCrystalTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
/* 247 */     if (entity.getActivePotionEffects().size() > 0)
/*     */     {
/* 249 */       for (PotionEffect ef : (PotionEffect[])entity.getActivePotionEffects().toArray((Object[])new PotionEffect[0])) {
/*     */         
/* 251 */         if (ef.getPotion().equals(Potion.getPotionById(20)) || ef.getPotion().equals(Potion.getPotionById(19)) || ef.getPotion().equals(Potion.getPotionById(9)))
/*     */         {
/* 253 */           entity.removePotionEffect(ef.getPotion());
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityEarthCrystalTick(EntityLivingBase entity, @Nullable EntityLivingBase source, int count) {
/* 261 */     if (count <= 2) {
/*     */       
/* 263 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 100, (int)Math.floor((count / 2))));
/*     */     }
/*     */     else {
/*     */       
/* 267 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 100, (int)Math.ceil((count / 2))));
/*     */     } 
/* 269 */     if (count == 4)
/*     */     {
/* 271 */       entity.addPotionEffect(new PotionEffect(Potion.getPotionById(22), 105, 4));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityOrdoCrystalTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
/* 277 */     Potion potion = PotionWarpWard.instance;
/* 278 */     entity.addPotionEffect(new PotionEffect(potion, 105));
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityEntropyCrystalTick(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
/* 283 */     AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - 2.5D, entity.posY - 2.5D, entity.posZ - 2.5D, entity.posX + 2.5D, entity.posY + 2.5D, entity.posZ + 2.5D);
/* 284 */     for (EntityLivingBase ent : entity.world.getEntitiesWithinAABB(EntityLivingBase.class, aabb)) {
/*     */       
/* 286 */       if (ent != entity)
/*     */       {
/* 288 */         if (ent.getActivePotionEffect(MobEffects.WITHER) == null)
/*     */         {
/* 290 */           ent.addPotionEffect(new PotionEffect(Potion.getPotionById(20), 45, 1));
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityFireCrystalGetDamage(@Nullable EntityLivingBase entity, EntityLivingBase source, @Nullable int count) {
/* 298 */     if (source != null)
/*     */     {
/* 300 */       if (rand.nextInt(101) < 25 * count) {
/*     */         
/* 302 */         source.knockBack((Entity)source, 5.0F, entity.posX - source.posX, entity.posZ - source.posZ);
/* 303 */         source.setFire(2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void ablilityWaterCrystalGetDamage(@Nullable EntityLivingBase entity, @Nullable int count, float damageAmount) {
/* 311 */     entity.heal(damageAmount * 0.15F * count);
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityOrdoCrystalGetDamage(EntityLivingBase entity, EntityLivingBase source, int count) {
/* 316 */     if (source != null)
/*     */     {
/* 318 */       if (rand.nextInt(101) < 25 * count)
/*     */       {
/* 320 */         for (PotionEffect ef : (PotionEffect[])source.getActivePotionEffects().toArray((Object[])new PotionEffect[0])) {
/*     */           
/* 322 */           if (!ef.getPotion().isBadEffect()) {
/*     */             
/* 324 */             entity.addPotionEffect(ef);
/* 325 */             source.removePotionEffect(ef.getPotion());
/*     */           } 
/*     */         } 
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static void ablilityEntropyCrystalGetDamage(@Nullable EntityLivingBase entity, @Nullable EntityLivingBase source, @Nullable int count) {
/* 334 */     if (source != null)
/*     */     {
/* 336 */       if (rand.nextInt(101) < 25 * count)
/*     */       {
/* 338 */         if (source.getActivePotionEffect(MobEffects.POISON) == null)
/*     */         {
/* 340 */           source.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 205, 1));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\IPrimalArmorAbilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */