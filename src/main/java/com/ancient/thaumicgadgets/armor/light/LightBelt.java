/*     */ package com.ancient.thaumicgadgets.armor.light;
/*     */ 
/*     */ import baubles.api.BaubleType;
/*     */ import baubles.api.IBauble;
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import com.ancient.thaumicgadgets.items.ItemBase;
/*     */ import com.ancient.thaumicgadgets.network.MessageClientBeltAbilities;
/*     */ import com.ancient.thaumicgadgets.util.IItemAutoRepair;
/*     */ import com.ancient.thaumicgadgets.util.Reference;
/*     */ import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ 
/*     */ public class LightBelt
/*     */   extends ItemBase implements IBauble, IItemAutoRepair {
/*  29 */   public final int cd = 1200;
/*  30 */   public final int duration = 100;
/*     */   
/*     */   public long lastUse;
/*     */   
/*     */   public LightBelt(String name) {
/*  35 */     super(name);
this.setMaxStackSize(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BaubleType getBaubleType(ItemStack itemstack) {
/*  41 */     return BaubleType.BELT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onWornTick(ItemStack itemStack, EntityLivingBase player) {
/*  47 */     if (!player.world.isRemote)
/*     */     {
/*  49 */       if (CheckTime(itemStack, player.world, 0L, 12516L)) {
/*     */         
/*  51 */         EntityPlayer pl = (EntityPlayer)player;
/*     */         
/*  53 */         int i = 0;
/*     */         
/*  55 */         NonNullList<ItemStack> list = pl.inventory.armorInventory;
/*     */         
/*  57 */         for (ItemStack stack : list) {
/*     */           
/*  59 */           if (!stack.getItem().equals(Items.AIR)) {
/*     */             
/*  61 */             ItemArmor s = (ItemArmor)stack.getItem();
/*  62 */             if (s.armorType.equals(EntityEquipmentSlot.FEET))
/*     */             {
/*  64 */               if (s.equals(ModItems.BOOTS_LIGHT)) {
/*     */                 
/*  66 */                 pl.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
/*  67 */                 pl.fallDistance = 0.0F;
/*     */               } 
/*     */             }
/*     */             
/*  71 */             if (s instanceof ArmorLight)
/*     */             {
/*  73 */               i++;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/*  78 */         if (i == 4)
/*     */         {
/*  80 */           pl.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 105, 1));
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void EnableFly(EntityPlayer player) {
/*  88 */     if (!player.world.isRemote) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  93 */       NBTTagCompound nbt = player.getEntityData();
/*  94 */       NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);
/*     */       
/*  96 */       NBTTagCompound compound = list.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("lightFlying"));
/*     */       
/*  98 */       if (!compound.hasKey("lastAbilityUse"))
/*     */       {
/* 100 */         compound.setLong("lastAbilityUse", 0L);
/*     */       }
/* 102 */       if (!compound.hasKey("cd")) {
/*     */         
/* 104 */         getClass(); compound.setInteger("cd", 1200);
/*     */       } 
/* 106 */       long lastTick = compound.getLong("lastAbilityUse");
/*     */       
/* 108 */       if (lastTick + 1200L <= player.world.getTotalWorldTime()) {
/*     */         
/* 110 */         compound.setLong("lastAbilityUse", player.world.getTotalWorldTime());
/*     */         
/* 112 */         getClass(); compound.setInteger("duration", 100);
/* 113 */         list.set(Reference.getNBTPlayerIndexFromString("lightFlying"), (NBTBase)compound);
/* 114 */         nbt.setTag("thaumic_gadgets", (NBTBase)list);
/*     */         
/* 116 */         getClass(); NetworkHandler.sendToClient((IMessage)new MessageClientBeltAbilities(player.world.getTotalWorldTime(), 1200), (EntityPlayerMP)player);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
/* 126 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\light\LightBelt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */