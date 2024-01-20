/*     */ package com.ancient.thaumicgadgets.util.handlers;
/*     */ 
/*     */ import baubles.api.BaublesApi;
/*     */ import baubles.api.cap.IBaublesItemHandler;
/*     */ import com.ancient.thaumicgadgets.util.Reference;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerFlyHandler
/*     */ {
/*  28 */   private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
/*  33 */     if (!(event.getEntity().getEntityWorld()).isRemote)
/*     */     {
/*  35 */       if (event.getEntity() instanceof EntityPlayer) {
/*     */         if(!((EntityPlayer) event.getEntity()).isCreative() && !((EntityPlayer) event.getEntity()).isSpectator()){
/*  37 */         EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/*     */
/*     */
/*     */
/*  41 */         NBTTagCompound nbt = player.getEntityData();
/*     */
/*  43 */         if (nbt.hasKey("thaumic_gadgets")) {
/*     */
/*  45 */           NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);
/*  46 */           NBTTagCompound compound = list.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("lightFlying"));
/*     */
/*  48 */           Long lastUse = Long.valueOf(compound.getLong("lastAbilityUse"));
/*  49 */           int duration = compound.getInteger("duration");
/*     */
/*  51 */           if (lastUse.longValue() + duration > player.world.getTotalWorldTime()) {
/*     */
/*  53 */             player.capabilities.allowFlying = true;
/*  54 */             player.capabilities.isFlying = true;
/*  55 */             player.sendPlayerAbilities();
/*     */           }
/*  57 */           else if (lastUse.longValue() + duration == player.world.getTotalWorldTime()) {
/*     */
/*  59 */             player.capabilities.allowFlying = false;
/*  60 */             if (!player.onGround)
/*     */             {
/*  62 */               player.capabilities.isFlying = false;
/*     */             }
/*  64 */             player.sendPlayerAbilities();
/*     */           }
/*     */         }
/*     */       }
            }
        }
    }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void onDrawParticles(RenderLivingEvent.Pre event) {
/*  76 */     if (event.getEntity() instanceof EntityPlayer) {
/*     */       
/*  78 */       EntityPlayer player = (EntityPlayer)event.getEntity();
/*     */       
/*  80 */       checkShadowArmor(player);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public static void checkBootsForStep(LivingEvent.LivingUpdateEvent event) {
/*  88 */     if ((event.getEntityLiving().getEntityWorld()).isRemote)
/*     */     {
/*  90 */       if (event.getEntityLiving() instanceof EntityPlayer) {
/*     */         
/*  92 */         EntityPlayer player = (EntityPlayer)event.getEntityLiving();
/*  93 */         ItemStack stack = player.inventory.armorItemInSlot(0);
/*  94 */         if (stack.getItem() != Items.AIR) {
/*     */           
/*  96 */           if (stack.getItem() instanceof com.ancient.thaumicgadgets.armor.primal.ArmorPrimal || stack.getItem() instanceof com.ancient.thaumicgadgets.armor.light.ArmorLight || stack.getItem() instanceof com.ancient.thaumicgadgets.armor.shade.ArmorShade)
/*     */           {
/*  98 */             player.stepHeight = 1.25F;
/*     */           }
/*     */         }
/*     */         else {
/*     */           
/* 103 */           player.stepHeight = 0.61F;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void checkShadowArmor(EntityPlayer player) {
/* 111 */     int i = 0;
/*     */     
/* 113 */     for (ItemStack stack : player.inventory.armorInventory) {
/*     */       
/* 115 */       if (stack.getItem() instanceof com.ancient.thaumicgadgets.armor.shade.ArmorShade)
/*     */       {
/* 117 */         i++;
/*     */       }
/*     */     } 
/*     */     
/* 121 */     IBaublesItemHandler handler = BaublesApi.getBaublesHandler(player);
/* 122 */     ItemStack belt = handler.getStackInSlot(3);
/*     */     
/* 124 */     if (belt.getItem() instanceof com.ancient.thaumicgadgets.armor.shade.ShadeBelt)
/*     */     {
/* 126 */       i++;
/*     */     }
/*     */ 
/*     */     
/* 130 */     if (i == 5) {
/*     */ 
/*     */       
/* 133 */       int count = RandomFunctions.rand.nextInt(2) + 1;
/*     */       
/* 135 */       double height = player.getPosition().getY() + RandomFunctions.rand.nextDouble() * player.height;
/*     */       
/* 137 */       EnumFacing face = player.getHorizontalFacing();
/* 138 */       switch (face) {
/*     */         
/*     */         case NORTH:
/* 141 */           ps.spawnParticles(EnumParticleTypes.SMOKE_NORMAL, count, (player.getPosition().getX() + RandomFunctions.rand.nextFloat() - 0.5F), height, (player.getPosition().getZ() + RandomFunctions.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
/*     */           break;
/*     */         case SOUTH:
/* 144 */           ps.spawnParticles(EnumParticleTypes.SMOKE_NORMAL, count, (player.getPosition().getX() + RandomFunctions.rand.nextFloat() - 0.75F), height, (player.getPosition().getZ() - RandomFunctions.rand.nextFloat() / 2.0F), 0.0D, 0.0D, 0.0D);
/*     */           break;
/*     */         case EAST:
/* 147 */           ps.spawnParticles(EnumParticleTypes.SMOKE_NORMAL, count, (player.getPosition().getX() - RandomFunctions.rand.nextFloat() / 2.0F - 0.25F), height, (player.getPosition().getZ() - RandomFunctions.rand.nextFloat() + 0.5F), 0.0D, 0.0D, 0.0D);
/*     */           break;
/*     */         case WEST:
/* 150 */           ps.spawnParticles(EnumParticleTypes.SMOKE_NORMAL, count, (player.getPosition().getX() - RandomFunctions.rand.nextFloat() / 2.0F + 1.0F), height, (player.getPosition().getZ() + RandomFunctions.rand.nextFloat() - 0.5F), 0.0D, 0.0D, 0.0D);
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\PlayerFlyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */