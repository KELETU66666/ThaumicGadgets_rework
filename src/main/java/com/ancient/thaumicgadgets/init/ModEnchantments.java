 package com.ancient.thaumicgadgets.init;
 
 import com.ancient.thaumicgadgets.enchantments.EnchRegenPrimal;
 import java.util.ArrayList;
 import java.util.List;
 import net.minecraft.enchantment.Enchantment;
 import net.minecraft.enchantment.EnchantmentHelper;
 import net.minecraft.enchantment.EnumEnchantmentType;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.event.entity.living.LivingEvent;
 import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 
 
 
 
 
 @EventBusSubscriber(modid = "tg")
 public class ModEnchantments
 {
/* 24 */   public static final List<Enchantment> ECHANTMENTS = new ArrayList<>();
   
/* 26 */   public static final Enchantment REGEN_PRIMAL = (Enchantment)new EnchRegenPrimal("regen_primal", Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[] { EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET });
 
   
   @SubscribeEvent
   public static void RegenPrimal(LivingEvent.LivingUpdateEvent event) {
/* 31 */     EntityLivingBase l = event.getEntityLiving();
/* 32 */     int lvl = EnchantmentHelper.getMaxEnchantmentLevel(REGEN_PRIMAL, l);
/* 33 */     BlockPos pos = l.getPosition();
/* 34 */     World world = (event.getEntity()).world;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\init\ModEnchantments.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */