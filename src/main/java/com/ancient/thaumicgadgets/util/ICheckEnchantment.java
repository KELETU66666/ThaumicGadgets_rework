/*     */ package com.ancient.thaumicgadgets.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentData;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface ICheckEnchantment
/*     */ {
/*     */   default boolean canApplyEchantment(ItemStack stack, int enchId, int enchLvl) {
/*  16 */     boolean canApply = true;
/*  17 */     boolean changeLvl = false;
/*  18 */     Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);
/*  19 */     ArrayList<EnchantmentData> ed = new ArrayList<>();
/*     */     
/*  21 */     for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {
/*     */       
/*  23 */       if (e.getKey() == Enchantment.getEnchantmentByID(enchId)) {
/*     */         
/*  25 */         if (((Integer)e.getValue()).intValue() < enchLvl) {
/*     */           
/*  27 */           ed.add(new EnchantmentData(e.getKey(), ((Integer)e.getValue()).intValue()));
/*  28 */           changeLvl = true;
/*     */         } 
/*  30 */         canApply = false;
/*     */       } 
/*     */     } 
/*  33 */     if (canApply)
/*     */     {
/*  35 */       stack.addEnchantment(Enchantment.getEnchantmentByID(enchId), enchLvl);
/*     */     }
/*  37 */     if (changeLvl)
/*     */     {
/*  39 */       for (EnchantmentData data : ed)
/*     */       {
/*  41 */         changeLvlEnch(stack, data);
/*     */       }
/*     */     }
/*  44 */     return canApply;
/*     */   }
/*     */ 
/*     */   
/*     */   default boolean canApplyEchantment(ItemStack stack, Enchantment enchType, int enchLvl) {
/*  49 */     boolean canApply = true;
/*  50 */     Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);
/*     */     
/*  52 */     for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {
/*     */       
/*  54 */       if (e.getKey() == enchType)
/*     */       {
/*  56 */         canApply = false;
/*     */       }
/*     */     } 
/*  59 */     if (canApply)
/*     */     {
/*  61 */       stack.addEnchantment(enchType, enchLvl);
/*     */     }
/*  63 */     return canApply;
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean canApplyEchantmentStatic(ItemStack stack, int enchId, int enchLvl) {
/*  68 */     boolean canApply = true;
/*  69 */     boolean changeLvl = false;
/*  70 */     Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);
/*  71 */     ArrayList<EnchantmentData> ed = new ArrayList<>();
/*     */     
/*  73 */     for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {
/*     */       
/*  75 */       if (e.getKey() == Enchantment.getEnchantmentByID(enchId)) {
/*     */         
/*  77 */         if (((Integer)e.getValue()).intValue() < enchLvl) {
/*     */           
/*  79 */           ed.add(new EnchantmentData(e.getKey(), ((Integer)e.getValue()).intValue()));
/*  80 */           changeLvl = true;
/*     */         } 
/*  82 */         canApply = false;
/*     */       } 
/*     */     } 
/*  85 */     if (canApply)
/*     */     {
/*  87 */       stack.addEnchantment(Enchantment.getEnchantmentByID(enchId), enchLvl);
/*     */     }
/*  89 */     if (changeLvl)
/*     */     {
/*  91 */       for (EnchantmentData data : ed)
/*     */       {
/*  93 */         changeLvlEnchStatic(stack, data);
/*     */       }
/*     */     }
/*  96 */     return canApply;
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean canApplyEchantmentStatic(ItemStack stack, Enchantment enchType, int enchLvl) {
/* 101 */     boolean canApply = true;
/* 102 */     Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);
/*     */     
/* 104 */     for (Map.Entry<Enchantment, Integer> e : ench.entrySet()) {
/*     */       
/* 106 */       if (e.getKey() == enchType)
/*     */       {
/* 108 */         canApply = false;
/*     */       }
/*     */     } 
/* 111 */     if (canApply)
/*     */     {
/* 113 */       stack.addEnchantment(enchType, enchLvl);
/*     */     }
/* 115 */     return canApply;
/*     */   }
/*     */ 
/*     */   
/*     */   default void changeLvlEnch(ItemStack stack, EnchantmentData ed) {
/* 120 */     Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);
/*     */     
/* 122 */     if (ench.get(ed.enchantment) != null)
/*     */     {
/* 124 */       ench.replace(ed.enchantment, Integer.valueOf(ed.enchantmentLevel));
/*     */     }
/* 126 */     EnchantmentHelper.setEnchantments(ench, stack);
/*     */   }
/*     */ 
/*     */   
/*     */   static void changeLvlEnchStatic(ItemStack stack, EnchantmentData ed) {
/* 131 */     Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(stack);
/*     */     
/* 133 */     if (ench.get(ed.enchantment) != null)
/*     */     {
/* 135 */       ench.replace(ed.enchantment, Integer.valueOf(ed.enchantmentLevel));
/*     */     }
/* 137 */     EnchantmentHelper.setEnchantments(ench, stack);
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\ICheckEnchantment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */