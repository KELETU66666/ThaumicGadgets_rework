/*     */ package com.ancient.thaumicgadgets.tools.primal;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.tools.ToolSwordBase;
/*     */ import com.ancient.thaumicgadgets.util.ICheckEnchantment;
/*     */ import com.ancient.thaumicgadgets.util.IFunctionLibrary;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.Multimap;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ToolSwordPrimal
/*     */   extends ToolSwordBase
/*     */   implements ICheckEnchantment
/*     */ {
/*     */   private float damage;
/*     */   private float speed;
/*     */   private final int mode;
/*     */   private final String name;
/*     */   
/*     */   public ToolSwordPrimal(String name, Item.ToolMaterial material, float damage, float speed) {
/*  37 */     super(name, material);
/*     */     
/*  39 */     this.damage = damage;
/*  40 */     this.speed = speed;
/*  41 */     this.name = name;
/*  42 */     this.mode = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
/*  49 */     if (!stack.hasTagCompound()) {
/*     */       
/*  51 */       NBTTagCompound nbt = new NBTTagCompound();
/*  52 */       nbt.setInteger("mode", this.mode);
/*  53 */       stack.setTagCompound(nbt);
/*     */     } 
/*     */     
/*  56 */     if (stack.getItemDamage() > 0)
/*     */     {
/*  58 */       setDamage(stack, -1);
/*     */     }
/*     */     
/*  61 */     EntityLivingBase entity = (EntityLivingBase)entityIn;
/*     */     
/*  63 */     if (isSelected) {
/*     */       
/*  65 */       int mode = stack.getTagCompound().getInteger("mode");
/*     */       
/*  67 */       if (this.name.equals("sword_primal")) {
/*     */         
/*  69 */         int[] ench = { 22, 20, 16, 19, 17, 18 };
/*  70 */         int[] level = { 4, 3, 6, 3, 6, 6 };
/*     */         
/*  72 */         canApplyEchantment(stack, ench[mode], level[mode]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
/*  81 */     int mode = 0;
/*     */     
/*  83 */     if (stack.hasTagCompound())
/*     */     {
/*  85 */       mode = stack.getTagCompound().getInteger("mode");
/*     */     }
/*     */     
/*  88 */     tooltip.add("Current Aspect: " + IFunctionLibrary.getAspectFromMode(mode).getChatcolor() + IFunctionLibrary.getAspectFromMode(mode).getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public void changeItemMode(EntityPlayer player, ItemStack stack, int slotId) {
/*  93 */     ToolSwordPrimal ar = (ToolSwordPrimal)stack.getItem();
/*  94 */     ItemStack is = new ItemStack(stack.getItem());
/*  95 */     NBTTagCompound nbt = new NBTTagCompound();
/*  96 */     nbt.setInteger("mode", stack.getTagCompound().getInteger("mode") + 1);
/*  97 */     is.setTagCompound(nbt);
/*  98 */     if (is.getTagCompound().getInteger("mode") > 5)
/*     */     {
/* 100 */       is.getTagCompound().setInteger("mode", 0);
/*     */     }
/* 102 */     if (stack.getItem() instanceof com.ancient.thaumicgadgets.armour.primal.ArmorPrimalUpgraded) {
/*     */       
/* 104 */       NBTTagList list = stack.getTagCompound().getTagList("primalInventory", 10);
/* 105 */       is.getTagCompound().setTag("primalInventory", (NBTBase)list);
/*     */     } 
/* 107 */     player.inventory.setInventorySlotContents(slotId, is);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Multimap<String, AttributeModifier> func_111205_h(EntityEquipmentSlot equipmentSlot) {
/* 113 */     ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();
/*     */     
/* 115 */     if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {
/*     */       
/* 117 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
/* 118 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
/*     */     } 
/*     */     
/* 121 */     return (Multimap<String, AttributeModifier>)arrayListMultimap;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\primal\ToolSwordPrimal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */