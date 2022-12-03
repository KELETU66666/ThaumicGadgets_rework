/*     */ package com.ancient.thaumicgadgets.armour.shade;
/*     */ 
/*     */ import baubles.api.BaubleType;
/*     */ import baubles.api.IBauble;
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import com.ancient.thaumicgadgets.items.ItemBase;
/*     */ import com.ancient.thaumicgadgets.network.MessageClientBeltAbilities;
/*     */ import com.ancient.thaumicgadgets.util.IItemAutoRepair;
/*     */ import com.ancient.thaumicgadgets.util.Reference;
/*     */ import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
/*     */ import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
/*     */ import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ 
/*     */ public class ShadeBelt
/*     */   extends ItemBase
/*     */   implements IBauble, IItemAutoRepair {
/*  36 */   private final int distance = 8;
/*  37 */   public final int cd = 300;
/*     */   public long lastUse;
/*  39 */   private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;
/*     */ 
/*     */   
/*     */   public ShadeBelt(String name) {
/*  43 */     super(name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BaubleType getBaubleType(ItemStack itemstack) {
/*  49 */     return BaubleType.BELT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onWornTick(ItemStack itemStack, EntityLivingBase player) {
/*  55 */     if (!player.world.isRemote)
/*     */     {
/*  57 */       if (CheckTime(itemStack, player.world, 12517L, 24000L)) {
/*     */         
/*  59 */         EntityPlayer pl = (EntityPlayer)player;
/*     */         
/*  61 */         int i = 0;
/*     */         
/*  63 */         NonNullList<ItemStack> list = pl.inventory.armorInventory;
/*     */         
/*  65 */         for (ItemStack stack : list) {
/*     */           
/*  67 */           if (!stack.getItem().equals(Items.AIR)) {
/*     */             
/*  69 */             ItemArmor s = (ItemArmor)stack.getItem();
/*  70 */             if (s.armorType.equals(EntityEquipmentSlot.FEET))
/*     */             {
/*  72 */               if (s.equals(ModItems.BOOTS_SHADE)) {
/*     */                 
/*  74 */                 pl.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
/*  75 */                 pl.fallDistance = 0.0F;
/*     */               } 
/*     */             }
/*     */             
/*  79 */             if (s instanceof ArmorShade)
/*     */             {
/*  81 */               i++;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/*  86 */         if (i == 4) {
/*     */           
/*  88 */           pl.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 105, 1));
/*  89 */           pl.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 205, 1));
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void ActivateTeleportation(EntityPlayer player) {
/*  97 */     if (!player.world.isRemote) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 102 */       NBTTagCompound nbt = player.getEntityData();
/* 103 */       NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);
/*     */       
/* 105 */       NBTTagCompound compound = list.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("darkBlink"));
/*     */       
/* 107 */       if (!compound.hasKey("lastAbilityUse"))
/*     */       {
/* 109 */         compound.setLong("lastAbilityUse", 0L);
/*     */       }
/* 111 */       if (!compound.hasKey("cd")) {
/*     */         
/* 113 */         getClass(); compound.setInteger("cd", 300);
/*     */       } 
/* 115 */       long lastTick = compound.getLong("lastAbilityUse");
/*     */       
/* 117 */       if (lastTick + 300L <= player.world.getTotalWorldTime()) {
/*     */         
/* 119 */         compound.setLong("lastAbilityUse", player.world.getTotalWorldTime());
/* 120 */         boolean canBlink = true;
/* 121 */         getClass(); int incDistance = 8;
/* 122 */         double x = 0.0D;
/* 123 */         double z = 0.0D;
/* 124 */         double prevX = x;
/* 125 */         double prevZ = z;
/* 126 */         while (canBlink && incDistance >= 0) {
/*     */           
/* 128 */           getClass(); x = player.posX + -Math.sin((player.rotationYaw / 180.0F * 3.1415927F)) * Math.cos((player.rotationPitch / 180.0F * 3.1415927F)) * (8 - incDistance);
/* 129 */           getClass(); z = player.posZ + Math.cos((player.rotationYaw / 180.0F * 3.1415927F)) * Math.cos((player.rotationPitch / 180.0F * 3.1415927F)) * (8 - incDistance);
/*     */           
/* 131 */           IBlockState state = player.world.getBlockState(new BlockPos(x, player.posY, z));
/* 132 */           if (state.getBlock() != Blocks.AIR) {
/*     */             
/* 134 */             canBlink = false;
/* 135 */             x = prevX;
/* 136 */             z = prevZ;
/*     */             
/*     */             continue;
/*     */           } 
/* 140 */           incDistance--;
/* 141 */           prevX = x;
/* 142 */           prevZ = z;
/*     */         } 
/*     */         
/*     */         int q;
/* 146 */         for (q = 0; q < 10; q++)
/*     */         {
/* 148 */           ps.transferData(EnumParticleTypes.DRAGON_BREATH, 1, player.posX + RandomFunctions.rand.nextDouble() - 0.5D, player.posY, player.posZ + RandomFunctions.rand.nextDouble() - 0.5D, player.dimension);
/*     */         }
/*     */ 
/*     */         
/* 152 */         player.setPositionAndUpdate(x, player.posY + 0.5D, z);
/*     */         
/* 154 */         for (q = 0; q < 10; q++)
/*     */         {
/* 156 */           ps.transferData(EnumParticleTypes.DRAGON_BREATH, 1, x + RandomFunctions.rand.nextDouble() - 0.5D, player.posY, z + RandomFunctions.rand.nextDouble() - 0.5D, player.dimension);
/*     */         }
/*     */         
/* 159 */         list.set(Reference.getNBTPlayerIndexFromString("darkBlink"), (NBTBase)compound);
/* 160 */         nbt.setTag("thaumic_gadgets", (NBTBase)list);
/*     */         
/* 162 */         getClass(); NetworkHandler.sendToClient((IMessage)new MessageClientBeltAbilities(player.world.getTotalWorldTime(), 300), (EntityPlayerMP)player);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\shade\ShadeBelt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */