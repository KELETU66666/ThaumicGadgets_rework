/*     */ package com.ancient.thaumicgadgets.util.handlers;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.armour.primal.ArmorPrimal;
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import com.ancient.thaumicgadgets.tools.primal.ToolAxePrimal;
/*     */ import com.ancient.thaumicgadgets.util.IFunctionLibrary;
/*     */ import com.ancient.thaumicgadgets.util.IPrimalArmorAbilities;
/*     */ import com.ancient.thaumicgadgets.util.IPrimalWeaponAbilities;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerGetDamageHandler
/*     */   implements IPrimalArmorAbilities
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onEvent(LivingHurtEvent event) {
/*  27 */     if (event.getEntity() instanceof EntityPlayer) {
/*     */       
/*  29 */       int[] count = { 0, 0, 0, 0, 0, 0 };
/*  30 */       int[] c = { 0, 0, 0, 0, 0, 0, 0 };
/*     */       
/*  32 */       for (ItemStack s : event.getEntity().getArmorInventoryList()) {
/*     */         
/*  34 */         if (s.getUnlocalizedName().contains("primal")) {
/*     */           
/*  36 */           if (s.hasTagCompound())
/*     */           {
/*  38 */             count[s.getTagCompound().getInteger("mode")] = count[s.getTagCompound().getInteger("mode")] + 1;
/*     */           }
/*  40 */           if (s.getItem() instanceof com.ancient.thaumicgadgets.armour.primal.ArmorPrimalUpgraded) {
/*     */             
/*  42 */             NBTTagList nbt = s.getTagCompound().getTagList("primalInventory", 10);
/*  43 */             NBTTagCompound item = nbt.getCompoundTagAt(0);
/*  44 */             c[IFunctionLibrary.getCrystalModeFromName((new ItemStack(item)).getUnlocalizedName())] = c[IFunctionLibrary.getCrystalModeFromName((new ItemStack(item)).getUnlocalizedName())] + 1;
/*     */             
/*     */             continue;
/*     */           } 
/*  48 */           ArmorPrimal armor = (ArmorPrimal)s.getItem();
/*  49 */           armor.OnPlayerHurt((EntityPlayer)event.getEntity(), event.getSource(), event.getAmount());
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  54 */       EntityLivingBase source = null;
/*  55 */       EntityLivingBase ent = event.getEntityLiving();
/*  56 */       if (event.getSource().getTrueSource() instanceof EntityLivingBase)
/*     */       {
/*  58 */         source = (EntityLivingBase)event.getSource().getTrueSource();
/*     */       }
/*  60 */       if (source != null) {
/*     */ 
/*     */         
/*  63 */         if (count[0] == 4)
/*     */         {
/*  65 */           IPrimalArmorAbilities.ablilityAirArmorGetDamage(null, source, count[0]);
/*     */         }
/*     */         
/*  68 */         if (count[1] > 0)
/*     */         {
/*  70 */           IPrimalArmorAbilities.ablilityFireArmorGetDamage(null, source, count[1]);
/*     */         }
/*     */         
/*  73 */         if (count[2] == 4)
/*     */         {
/*  75 */           IPrimalArmorAbilities.ablilityWaterArmorGetDamage(null, source, count[2]);
/*     */         }
/*     */         
/*  78 */         if (count[3] == 4)
/*     */         {
/*  80 */           IPrimalArmorAbilities.ablilityEarthArmorGetDamage(null, source, count[3]);
/*     */         }
/*     */         
/*  83 */         IPrimalArmorAbilities.ablilityOrdoArmorGetDamage(ent, null, count[4]);
/*     */         
/*  85 */         if (count[5] == 4)
/*     */         {
/*  87 */           IPrimalArmorAbilities.ablilityEntropyArmorGetDamage(null, source, count[5]);
/*     */         }
/*     */ 
/*     */         
/*  91 */         if (c[1] > 0)
/*     */         {
/*  93 */           IPrimalArmorAbilities.ablilityFireCrystalGetDamage(ent, source, c[1]);
/*     */         }
/*     */         
/*  96 */         if (c[2] > 0)
/*     */         {
/*  98 */           IPrimalArmorAbilities.ablilityWaterCrystalGetDamage(ent, c[2], event.getAmount());
/*     */         }
/*     */         
/* 101 */         if (c[4] > 0)
/*     */         {
/* 103 */           IPrimalArmorAbilities.ablilityOrdoCrystalGetDamage(ent, source, c[4]);
/*     */         }
/*     */         
/* 106 */         if (c[5] > 0)
/*     */         {
/* 108 */           IPrimalArmorAbilities.ablilityEntropyCrystalGetDamage(null, source, c[5]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     if (event.getSource().getTrueSource() instanceof EntityLivingBase) {
/*     */       
/* 115 */       EntityLivingBase entity = (EntityLivingBase)event.getSource().getTrueSource();
/* 116 */       ItemStack stack = entity.getHeldItemMainhand();
/* 117 */       EntityLivingBase target = (EntityLivingBase)event.getEntity();
/* 118 */       if (stack.getItem() == ModItems.AXE_PRIMAL) {
/*     */         
/* 120 */         ToolAxePrimal axe = (ToolAxePrimal)stack.getItem();
/* 121 */         int mode = stack.getTagCompound().getInteger("mode");
/*     */         
/* 123 */         if (mode == 1) {
/*     */           
/* 125 */           IPrimalWeaponAbilities.abilityAxeFire(entity, target, 1);
/*     */         }
/* 127 */         else if (mode == 2) {
/*     */           
/* 129 */           IPrimalWeaponAbilities.abilityAxeWater(null, target);
/*     */         }
/* 131 */         else if (mode == 3) {
/*     */           
/* 133 */           event.setAmount(IPrimalWeaponAbilities.abilityAxeEarth(null, target, event.getAmount(), 1.5F));
/*     */         }
/* 135 */         else if (mode == 4) {
/*     */           
/* 137 */           event.setAmount(IPrimalWeaponAbilities.abilityAxeOrdo(null, entity, event.getAmount(), 2.0F));
/*     */         }
/* 139 */         else if (mode == 5) {
/*     */           
/* 141 */           event.setAmount(IPrimalWeaponAbilities.abilityAxeEntropy(null, entity, event.getAmount(), 2.0F));
/*     */         } 
/*     */       } 
/*     */       
/* 145 */       if (stack.getItem() == ModItems.HAMMER_PRIMAL) {
/*     */         
/* 147 */         ToolAxePrimal axe = (ToolAxePrimal)stack.getItem();
/* 148 */         int mode = stack.getTagCompound().getInteger("mode");
/*     */         
/* 150 */         if (mode == 0) {
/*     */           
/* 152 */           IPrimalWeaponAbilities.abilityHammerAir(null, target);
/*     */         }
/* 154 */         else if (mode == 1) {
/*     */           
/* 156 */           IPrimalWeaponAbilities.abilityHammerFire(null, target);
/*     */         }
/* 158 */         else if (mode == 2) {
/*     */           
/* 160 */           IPrimalWeaponAbilities.abilityHammerWater(null, target);
/*     */         }
/* 162 */         else if (mode == 3) {
/*     */           
/* 164 */           IPrimalWeaponAbilities.abilityHammerEarth(null, target);
/*     */         }
/* 166 */         else if (mode == 4) {
/*     */           
/* 168 */           IPrimalWeaponAbilities.abilityHammerOrdo(null, target);
/*     */         }
/* 170 */         else if (mode == 5) {
/*     */           
/* 172 */           IPrimalWeaponAbilities.abilityHammerEntropy(null, target);
/*     */         } 
/*     */       } 
/*     */       
/* 176 */       if (stack.getItem() == ModItems.SWORD_SHADE) {
/*     */         
/* 178 */         int[] z = { 0, 0 };
/* 179 */         for (ItemStack s : target.getArmorInventoryList()) {
/*     */           
/* 181 */           if (s.getUnlocalizedName().contains("light")) {
/*     */             
/* 183 */             z[0] = z[0] + 1; continue;
/*     */           } 
/* 185 */           if (s.getUnlocalizedName().contains("shade"))
/*     */           {
/* 187 */             z[1] = z[1] + 1;
/*     */           }
/*     */         } 
/* 190 */         if (z[0] == 4) {
/*     */           
/* 192 */           event.setAmount(event.getAmount() * 2.0F);
/*     */         }
/* 194 */         else if (z[1] == 4) {
/*     */           
/* 196 */           event.setAmount(event.getAmount() * 0.5F);
/*     */         } 
/*     */       } 
/* 199 */       if (stack.getItem() == ModItems.SWORD_LIGHT) {
/*     */         
/* 201 */         int[] z = { 0, 0 };
/* 202 */         for (ItemStack s : target.getArmorInventoryList()) {
/*     */           
/* 204 */           if (s.getUnlocalizedName().contains("light")) {
/*     */             
/* 206 */             z[0] = z[0] + 1; continue;
/*     */           } 
/* 208 */           if (s.getUnlocalizedName().contains("shade"))
/*     */           {
/* 210 */             z[1] = z[1] + 1;
/*     */           }
/*     */         } 
/* 213 */         if (z[0] == 4) {
/*     */           
/* 215 */           event.setAmount(event.getAmount() * 0.5F);
/*     */         }
/* 217 */         else if (z[1] == 4) {
/*     */           
/* 219 */           event.setAmount(event.getAmount() * 2.0F);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\PlayerGetDamageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */