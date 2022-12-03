/*     */ package com.ancient.thaumicgadgets.util.handlers;
/*     */ 
/*     */

/*     */ import com.ancient.thaumicgadgets.util.IFunctionLibrary;
/*     */
/*     */ import com.ancient.thaumicgadgets.util.IPrimalArmorAbilities;
/*     */
        /*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */
        /*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerTickHandler
/*     */   implements IPrimalArmorAbilities
/*     */ {
/*     */   @SubscribeEvent
/*     */   public static void onEvent(LivingEvent.LivingUpdateEvent event) {
/*  32 */     if (!(event.getEntity()).world.isRemote)
/*     */     {
/*  34 */       if (event.getEntity() instanceof EntityPlayer) {
/*     */         
/*  36 */         EntityPlayer player = (EntityPlayer)event.getEntity();
/*  37 */         int[] i = { 0, 0, 0, 0, 0, 0 };
/*  38 */         int[] c = { 0, 0, 0, 0, 0, 0, 0 };
/*  39 */         for (ItemStack stack : player.inventory.armorInventory) {
/*     */           
/*  41 */           if (stack.getUnlocalizedName().contains("primal"))
/*     */           {
/*  43 */             if (stack.hasTagCompound()) {
/*     */               
/*  45 */               i[stack.getTagCompound().getInteger("mode")] = i[stack.getTagCompound().getInteger("mode")] + 1;
/*  46 */               if (stack.getItem() instanceof com.ancient.thaumicgadgets.armour.primal.ArmorPrimalUpgraded) {
/*     */                 
/*  48 */                 NBTTagList nbt = stack.getTagCompound().getTagList("primalInventory", 10);
/*  49 */                 NBTTagCompound item = nbt.getCompoundTagAt(0);
/*  50 */                 c[IFunctionLibrary.getCrystalModeFromName((new ItemStack(item)).getUnlocalizedName())] = c[IFunctionLibrary.getCrystalModeFromName((new ItemStack(item)).getUnlocalizedName())] + 1;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*  55 */         EntityLivingBase ent = event.getEntityLiving();
/*     */         
/*  57 */         if (c[0] > 0)
/*     */         {
/*  59 */           IPrimalArmorAbilities.ablilityAirCrystalTick(ent, null, c[0]);
/*     */         }
/*     */         
/*  62 */         if (c[1] == 4)
/*     */         {
/*  64 */           IPrimalArmorAbilities.ablilityFireCrystalTick(ent, null, c[1]);
/*     */         }
/*     */         
/*  67 */         if (c[2] == 4)
/*     */         {
/*  69 */           IPrimalArmorAbilities.ablilityWaterCrystalTick(ent, null, c[2]);
/*     */         }
/*     */         
/*  72 */         if (c[3] > 0)
/*     */         {
/*  74 */           IPrimalArmorAbilities.ablilityEarthCrystalTick(ent, null, c[3]);
/*     */         }
/*     */         
/*  77 */         if (c[4] == 4)
/*     */         {
/*  79 */           IPrimalArmorAbilities.ablilityOrdoCrystalTick(ent, null, c[4]);
/*     */         }
/*     */         
/*  82 */         if (c[5] == 4)
/*     */         {
/*  84 */           IPrimalArmorAbilities.ablilityEntropyCrystalTick(ent, null, c[5]);
/*     */         }
/*     */ 
/*     */         
/*  88 */         if (i[0] > 0)
/*     */         {
/*  90 */           IPrimalArmorAbilities.abilityAirArmorTick((EntityLivingBase)player, null, i[0]);
/*     */         }
/*  92 */         if (i[1] == 4)
/*     */         {
/*  94 */           IPrimalArmorAbilities.abilityFireArmorTick((EntityLivingBase)player, null, i[1]);
/*     */         }
/*  96 */         if (i[3] > 0)
/*     */         {
/*  98 */           IPrimalArmorAbilities.abilityEarthArmorTick((EntityLivingBase)player, null, i[3]);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     *
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\PlayerTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */