/*     */ package com.ancient.thaumicgadgets.items;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import thaumcraft.api.aura.AuraHelper;
/*     */ import thaumcraft.common.lib.potions.PotionDeathGaze;
/*     */ 
/*     */ 
/*     */ public class ItemCrystal
/*     */   extends ItemBase
/*     */ {
/*  23 */   private int rechargeTime = 0;
/*  24 */   private int maxRechargeTime = 40;
/*     */   
/*     */   public ItemCrystal(String name) {
/*  27 */     super(name);
/*     */     
/*  29 */     setMaxDamage(15);
/*  30 */     setMaxStackSize(1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
/*  37 */     ItemStack stack = playerIn.getHeldItemMainhand();
/*  38 */     String name = stack.getTranslationKey().substring(5, stack.getTranslationKey().length()).toLowerCase();
/*  39 */     if (isCrystalOval(stack)) {
/*     */       
/*  41 */       stack.damageItem(stack.getMaxDamage() - 8, (EntityLivingBase)playerIn);
/*     */     }
/*     */     else {
/*     */       
/*  45 */       stack.shrink(1);
/*     */     } 
/*     */     
/*  48 */     if (name.equals("sharped_crystal_air")) {
/*     */       
/*  50 */       playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 3600, 1));
/*  51 */       playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 3600, 1));
/*     */     }
/*  53 */     else if (name.equals("sharped_crystal_fire")) {
/*     */       
/*  55 */       playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 6000, 0));
/*     */     }
/*  57 */     else if (name.equals("sharped_crystal_earth")) {
/*     */       
/*  59 */       playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 3600, 0));
/*     */     }
/*  61 */     else if (name.equals("sharped_crystal_order")) {
/*     */       
/*  63 */       for (PotionEffect ef : (PotionEffect[])playerIn.getActivePotionEffects().toArray((Object[])new PotionEffect[0]))
/*     */       {
/*  65 */         if (ef.getPotion().isBadEffect())
/*     */         {
/*  67 */           playerIn.removePotionEffect(ef.getPotion());
/*     */         }
/*     */       }
/*     */     
/*  71 */     } else if (name.equals("sharped_crystal_entropy")) {
/*     */       
/*  73 */       Potion deathGaze = PotionDeathGaze.instance;
/*  74 */       playerIn.addPotionEffect(new PotionEffect(deathGaze, 2400, 0));
/*     */     }
/*  76 */     else if (name.equals("oval_crystal_order")) {
/*     */       
/*  78 */       playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(6), 5, 2));
/*     */     }
/*  80 */     else if (name.equals("oval_crystal_earth")) {
/*     */       
/*  82 */       playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(21), 3600, 1));
/*     */     }
/*  84 */     else if (name.equals("oval_crystal_air")) {
/*     */       
/*  86 */       playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(13), 3600, 0));
/*     */     }
/*  88 */     else if (name.equals("oval_crystal_entropy")) {
/*     */       
/*  90 */       AuraHelper.polluteAura(playerIn.world, playerIn.getPosition(), 50.0F, true);
/*     */     } 
/*     */ 
/*     */     
/*  94 */     return new ActionResult(EnumActionResult.SUCCESS, stack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 100 */     ItemStack stack = player.getHeldItemMainhand();
/* 101 */     String name = stack.getTranslationKey().substring(5, stack.getTranslationKey().length()).toLowerCase();
/*     */     
/* 103 */     if (isCrystalOval(stack)) {
/*     */       
/* 105 */       stack.damageItem(stack.getMaxDamage() - 8, (EntityLivingBase)player);
/*     */     }
/*     */     else {
/*     */       
/* 109 */       stack.shrink(1);
/*     */     } 
/*     */     
/* 112 */     if (name.equals("sharped_crystal_water"))
/*     */     {
/* 114 */       for (int z = 0; z < 5; z++) {
/*     */         
/* 116 */         for (int y = 0; y < 5; y++) {
/*     */           
/* 118 */           for (int x = 0; x < 5; x++) {
/*     */             
/* 120 */             BlockPos p = new BlockPos(pos.getX() - 2 + x, pos.getY() - 2 + y, pos.getZ() + z - 2);
/* 121 */             if (worldIn.getBlockState(p).getBlock().equals(Blocks.LAVA)) {
/*     */               
/* 123 */               worldIn.destroyBlock(p, false);
/* 124 */               worldIn.setBlockState(p, Blocks.OBSIDIAN.getDefaultState());
/*     */             } 
/*     */             
/* 127 */             if (worldIn.getBlockState(p).getBlock().equals(Blocks.FLOWING_LAVA)) {
/*     */               
/* 129 */               worldIn.destroyBlock(p, false);
/* 130 */               worldIn.setBlockState(p, Blocks.STONE.getDefaultState());
/*     */             } 
/*     */             
/* 133 */             if (worldIn.getBlockState(p).getBlock().equals(Blocks.WATER)) {
/*     */               
/* 135 */               worldIn.destroyBlock(p, false);
/* 136 */               worldIn.setBlockState(p, Blocks.ICE.getDefaultState());
/*     */             } 
/* 138 */             if (worldIn.getBlockState(p).getBlock().equals(Blocks.FLOWING_WATER)) {
/*     */               
/* 140 */               worldIn.destroyBlock(p, false);
/* 141 */               worldIn.setBlockState(p, Blocks.ICE.getDefaultState());
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 149 */     if (name.equals("oval_crystal_water") && worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock().equals(Blocks.AIR))
/*     */     {
/* 151 */       worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.WATER.getDefaultState());
/*     */     }
/* 153 */     if (name.equals("oval_crystal_fire") && worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock().equals(Blocks.AIR))
/*     */     {
/* 155 */       worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.FIRE.getDefaultState());
/*     */     }
/*     */ 
/*     */     
/* 159 */     return EnumActionResult.SUCCESS;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCrystalOval(ItemStack stack) {
/* 164 */     String name = stack.getTranslationKey().substring(5, 9);
/* 165 */     if (name.equals("oval"))
/*     */     {
/* 167 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
/* 178 */     if (isSelected && stack.getItemDamage() < stack.getMaxDamage() && AuraHelper.getVis(worldIn, entityIn.getPosition()) > 5.0F) {
/*     */       
/* 180 */       this.rechargeTime++;
/* 181 */       if (this.rechargeTime >= this.maxRechargeTime)
/*     */       {
/* 183 */         this.rechargeTime = 0;
/* 184 */         AuraHelper.drainVis(worldIn, entityIn.getPosition(), 5.0F, true);
/* 185 */         stack.damageItem(-2, (EntityLivingBase)entityIn);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 190 */       this.rechargeTime = 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\ItemCrystal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */