 package com.ancient.thaumicgadgets.enchantments;

 import com.ancient.thaumicgadgets.init.ModEnchantments;
 import net.minecraft.enchantment.Enchantment;
 import net.minecraft.enchantment.EnumEnchantmentType;
 import net.minecraft.init.Enchantments;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.ResourceLocation;




 public class EnchRegenPrimal
   extends Enchantment
 {
   public EnchRegenPrimal(String name, Enchantment.Rarity rarityIn, EnumEnchantmentType typeIn, EntityEquipmentSlot[] slots) {
/* 18 */     super(rarityIn, typeIn, slots);
/* 19 */     setName(name);
/* 20 */     setRegistryName(new ResourceLocation("tg:" + name));

/* 22 */     ModEnchantments.ECHANTMENTS.add(this);
   }





   public int getMinEnchantability(int enchantmentLevel) {
/* 30 */     return 10 * enchantmentLevel;
   }



   public int getMaxEnchantability(int enchantmentLevel) {
/* 36 */     return getMinEnchantability(enchantmentLevel) + 10;
   }



   public int getMaxLevel() {
/* 42 */     return 4;
   }



   protected boolean canApplyTogether(Enchantment ench) {
/* 48 */     return (super.canApplyTogether(ench) && ench != Enchantments.PROTECTION && ench != Enchantments.FIRE_PROTECTION && ench != Enchantments.PROJECTILE_PROTECTION && ench != Enchantments.BLAST_PROTECTION);
   }



   public boolean isTreasureEnchantment() {
/* 54 */     return false;
   }



   public boolean canApplyAtEnchantingTable(ItemStack stack) {
/* 60 */     return false;
   }



   public boolean isAllowedOnBooks() {
/* 66 */     return false;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\enchantments\EnchRegenPrimal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */