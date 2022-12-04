/*     */ package com.ancient.thaumicgadgets.armour.primal;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.armour.ArmorBase;
/*     */ import com.ancient.thaumicgadgets.armour.shade.ArmorShadeModel;
import com.ancient.thaumicgadgets.init.ModEnchantments;
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
/*     */ import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

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
/*     */   ModelBiped model;
String location;
/*     */   public ArmorPrimal(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
/*  44 */     super(name, materialIn, renderIndexIn, equipmentSlotIn);
/*     */ 
/*     */ 
/*     */     
/*  48 */     this.mode = 0;
/*     */     model = null;
location = null;
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
/*  71 */     tooltip.add(I18n.format("item.primal.description", new Object[0]) + IFunctionLibrary.getAspectFromMode(mode).getChatcolor() + IFunctionLibrary.getAspectFromMode(mode).getName());
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
@Override
@Nullable
@SideOnly(Side.CLIENT)
public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot,
                                ModelBiped _default) {

    if (model == null) {
        if (slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.FEET)
            model = new ArmorPrimalModel(stack);
        else
            model = new ArmorPrimalModel(stack);

        model.bipedHead.showModel = slot == EntityEquipmentSlot.HEAD;
        model.bipedHeadwear.showModel = slot == EntityEquipmentSlot.HEAD;
        model.bipedBody.showModel = slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.LEGS;
        model.bipedRightArm.showModel = slot == EntityEquipmentSlot.CHEST;
        model.bipedLeftArm.showModel = slot == EntityEquipmentSlot.CHEST;
        model.bipedRightLeg.showModel = slot == EntityEquipmentSlot.LEGS;
        model.bipedLeftLeg.showModel = slot == EntityEquipmentSlot.LEGS;
    }

    if(slot == EntityEquipmentSlot.LEGS)
        return ArmorPrimalModel.getModel(living, stack);
    if(slot == EntityEquipmentSlot.FEET)
        return null;
    return model;
}

    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if (location == null) {
            if (slot == EntityEquipmentSlot.FEET)
                location = "tg:textures/models/armor/primal_boots.png";
            else
                location = "tg:textures/models/armor/primal_armor.png";
        }
        return location;
    }

/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\primal\ArmorPrimal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */