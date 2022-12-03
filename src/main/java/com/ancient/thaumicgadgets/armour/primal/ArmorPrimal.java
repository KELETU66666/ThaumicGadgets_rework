/*     */ package com.ancient.thaumicgadgets.armour.primal;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.armour.ArmorBase;
/*     */ import com.ancient.thaumicgadgets.init.ModEnchantments;
/*     */ import com.ancient.thaumicgadgets.proxy.ClientProxy;
/*     */ import com.ancient.thaumicgadgets.util.ICheckEnchantment;
/*     */ import com.ancient.thaumicgadgets.util.IFunctionLibrary;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArmorPrimal
/*     */   extends ArmorBase
/*     */   implements ICheckEnchantment
/*     */ {
/*     */   private int regenCount;
/*     */   private long lastTick;
/*     */   private int period;
/*     */   private int mode;
/*     */   
/*     */   public ArmorPrimal(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
/*  44 */     super(name, materialIn, renderIndexIn, equipmentSlotIn);
/*     */ 
/*     */ 
/*     */     
/*  48 */     this.mode = 0;
/*     */     
/*  50 */     this.regenCount = 2;
/*  51 */     this.lastTick = 0L;
/*  52 */     this.period = 100;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void OnPlayerHurt(EntityPlayer player, DamageSource source, float amount) {}
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
/*  64 */     int mode = 0;
/*     */     
/*  66 */     if (stack.hasTagCompound())
/*     */     {
/*  68 */       mode = stack.getTagCompound().getInteger("mode");
/*     */     }
/*     */     
/*  71 */     tooltip.add(I18n.format("item.primal.description", new Object[0]) + "§" + IFunctionLibrary.getAspectFromMode(mode).getChatcolor() + IFunctionLibrary.getAspectFromMode(mode).getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
/*  77 */     if (!stack.hasTagCompound()) {
/*     */       
/*  79 */       NBTTagCompound nbt = new NBTTagCompound();
/*  80 */       nbt.setInteger("mode", this.mode);
/*  81 */       stack.setTagCompound(nbt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeItemMode(EntityPlayer player, ItemStack stack, int slotId) {
/*  89 */     ArmorPrimal ar = (ArmorPrimal)stack.getItem();
/*  90 */     ItemStack is = new ItemStack(stack.getItem());
/*  91 */     NBTTagCompound nbt = new NBTTagCompound();
/*  92 */     nbt.setInteger("mode", stack.getTagCompound().getInteger("mode") + 1);
/*  93 */     is.setTagCompound(nbt);
/*  94 */     if (is.getTagCompound().getInteger("mode") > 5)
/*     */     {
/*  96 */       is.getTagCompound().setInteger("mode", 0);
/*     */     }
/*  98 */     if (stack.getItem() instanceof ArmorPrimalUpgraded) {
/*     */       
/* 100 */       NBTTagList list = stack.getTagCompound().getTagList("primalInventory", 10);
/* 101 */       is.getTagCompound().setTag("primalInventory", (NBTBase)list);
/*     */     } 
/* 103 */     player.inventory.armorInventory.set(slotId, is);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
/* 110 */     if (itemStack.getItemDamage() > 0)
/*     */     {
/* 112 */       setDamage(itemStack, -1);
/*     */     }
/*     */     
/* 115 */     int mode = 0;
/*     */     
/* 117 */     if (itemStack.getItem() instanceof ArmorPrimal)
/*     */     {
/* 119 */       canApplyEchantment(itemStack, 0, 5);
/*     */     }
/*     */ 
/*     */     
/* 123 */     if (itemStack.hasTagCompound() && itemStack.getTagCompound().getInteger("mode") == 2) {
/*     */       
/* 125 */       boolean canApply = true;
/* 126 */       Map<Enchantment, Integer> enc = EnchantmentHelper.getEnchantments(itemStack);
/*     */       
/* 128 */       for (Map.Entry<Enchantment, Integer> e : enc.entrySet()) {
/*     */         
/* 130 */         if (EnchantmentHelper.getEnchantmentLevel(ModEnchantments.REGEN_PRIMAL, itemStack) > 0) {
/*     */           
/* 132 */           canApply = false;
/* 133 */           regenTick(world, player, itemStack);
/*     */         } 
/*     */       } 
/*     */       
/* 137 */       if (canApply) {
/*     */         
/* 139 */         itemStack.addEnchantment(ModEnchantments.REGEN_PRIMAL, 1);
/* 140 */         NBTTagCompound nbt = itemStack.getTagCompound();
/* 141 */         if (nbt == null)
/*     */         {
/* 143 */           nbt = new NBTTagCompound();
/*     */         }
/* 145 */         nbt.setLong("lastTick", world.getTotalWorldTime());
/* 146 */         itemStack.setTagCompound(nbt);
/*     */       } 
/*     */     } 
/*     */     
/* 150 */     if (itemStack.hasTagCompound() && itemStack.getTagCompound().getInteger("mode") == 5)
/*     */     {
/* 152 */       canApplyEchantment(itemStack, Enchantments.THORNS, 5);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void regenTick(World world, EntityPlayer player, ItemStack stack) {
/* 158 */     NBTTagCompound nbt = stack.getTagCompound();
/* 159 */     long lastTick = nbt.getLong("lastTick");
/*     */     
/* 161 */     if (lastTick + this.period < world.getTotalWorldTime()) {
/*     */       
/* 163 */       player.heal(this.regenCount);
/* 164 */       nbt.setLong("lastTick", world.getTotalWorldTime());
/* 165 */       stack.setTagCompound(nbt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
/* 174 */     if (!itemStack.isEmpty())
/*     */     {
/* 176 */       if (itemStack.getItem() instanceof ItemArmor) {
/*     */ 
/*     */         
/* 179 */         ArmorPrimalModel armorModel = ClientProxy.ARMOR_PRIMAL_MODEL;
/* 180 */         ArmorPrimalModel armorModelLegs = ClientProxy.ARMOR_PRIMAL_MODEL_LEGS;
/*     */         
/* 182 */         armorModel.bipedHead.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
/* 183 */         armorModel.bipedHeadwear.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
/* 184 */         armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.CHEST);
/* 185 */         armorModel.bipedRightArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
/* 186 */         armorModel.bipedLeftArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
/* 187 */         armorModelLegs.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET);
/* 188 */         armorModelLegs.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET);
/*     */         
/* 190 */         armorModel.isSneak = _default.isSneak;
/* 191 */         armorModel.isRiding = _default.isRiding;
/* 192 */         armorModel.isChild = _default.isChild;
/* 193 */         armorModel.rightArmPose = _default.rightArmPose;
/* 194 */         armorModel.leftArmPose = _default.leftArmPose;
/*     */         
/* 196 */         armorModelLegs.isSneak = _default.isSneak;
/* 197 */         armorModelLegs.isRiding = _default.isRiding;
/* 198 */         armorModelLegs.isChild = _default.isChild;
/* 199 */         armorModelLegs.rightArmPose = _default.rightArmPose;
/* 200 */         armorModelLegs.leftArmPose = _default.leftArmPose;
/*     */         
/* 202 */         return armorModel;
/*     */       } 
/*     */     }
/*     */     
/* 206 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\primal\ArmorPrimal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */