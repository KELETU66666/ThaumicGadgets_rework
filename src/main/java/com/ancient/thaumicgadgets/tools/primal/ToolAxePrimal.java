/*     */ package com.ancient.thaumicgadgets.tools.primal;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.Main;
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import com.ancient.thaumicgadgets.util.ICheckEnchantment;
/*     */ import com.ancient.thaumicgadgets.util.IFunctionLibrary;
/*     */ import com.ancient.thaumicgadgets.util.IHasModel;
/*     */ import com.google.common.collect.Sets;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ToolAxePrimal
/*     */   extends ItemTool
/*     */   implements IHasModel, ICheckEnchantment
/*     */ {
/*  41 */   private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet( Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, (Block)Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.LADDER, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, Blocks.WEB );
/*     */   
/*     */   private final String name;
/*     */   private final int mode;
/*     */   
/*     */   public ToolAxePrimal(String name, Item.ToolMaterial material, float damage, float attackSpeed) {
/*  47 */     super(damage, attackSpeed, material, EFFECTIVE_ON);
/*  48 */     setTranslationKey(name);
/*  49 */     setRegistryName(name);
/*  50 */     setCreativeTab(Main.GADGETSTAB);
/*     */     
/*  52 */     this.name = name;
/*  53 */     this.mode = 0;
/*     */     
/*  55 */     ModItems.ITEMS.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getStrVsBlock(ItemStack stack, IBlockState state) {
/*  60 */     Material material = state.getMaterial();
/*  61 */     return (material != Material.WOOD && material != Material.PLANTS && material != Material.VINE) ? getStrVsBlock(stack, state) : this.efficiency;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerModels() {
/*  67 */     Main.proxy.registerItemRenderer((Item)this, 0, "inventory");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
/*  73 */     if (!stack.hasTagCompound()) {
/*     */       
/*  75 */       NBTTagCompound nbt = new NBTTagCompound();
/*  76 */       nbt.setInteger("mode", this.mode);
/*  77 */       stack.setTagCompound(nbt);
/*     */     } 
/*     */     
/*  80 */     if (stack.getItemDamage() > 0)
/*     */     {
/*  82 */       setDamage(stack, -1);
/*     */     }
/*     */     
/*  85 */     EntityLivingBase entity = (EntityLivingBase)entityIn;
/*     */     
/*  87 */     if (isSelected) {
/*     */       
/*  89 */       int mode = stack.getTagCompound().getInteger("mode");
/*     */       
/*  91 */       if (this.name.equals("sword_primal")) {
/*     */         
/*  93 */         int[] ench = { 22, 20, 16, 19, 17, 18 };
/*  94 */         int[] level = { 4, 3, 6, 3, 6, 6 };
/*     */         
/*  96 */         canApplyEchantment(stack, ench[mode], level[mode]);
/*     */       }
/*  98 */       else if (this.name.equals("axe_primal")) {
/*     */         
/* 100 */         if (mode == 0)
/*     */         {
/* 102 */           entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 1));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
/* 114 */     int mode = 0;
/*     */     
/* 116 */     if (stack.hasTagCompound())
/*     */     {
/* 118 */       mode = stack.getTagCompound().getInteger("mode");
/*     */     }
/*     */     
/* 121 */     tooltip.add("Current Aspect: " + IFunctionLibrary.getAspectFromMode(mode).getChatcolor() + IFunctionLibrary.getAspectFromMode(mode).getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public void changeItemMode(EntityPlayer player, ItemStack stack, int slotId) {
/* 126 */     ToolAxePrimal ar = (ToolAxePrimal)stack.getItem();
/* 127 */     ItemStack is = new ItemStack(stack.getItem());
/* 128 */     NBTTagCompound nbt = new NBTTagCompound();
/* 129 */     nbt.setInteger("mode", stack.getTagCompound().getInteger("mode") + 1);
/* 130 */     is.setTagCompound(nbt);
/* 131 */     if (is.getTagCompound().getInteger("mode") > 5)
/*     */     {
/* 133 */       is.getTagCompound().setInteger("mode", 0);
/*     */     }
/* 135 */     if (stack.getItem() instanceof com.ancient.thaumicgadgets.armor.primal.ArmorPrimalUpgraded) {
/*     */       
/* 137 */       NBTTagList list = stack.getTagCompound().getTagList("primalInventory", 10);
/* 138 */       is.getTagCompound().setTag("primalInventory", (NBTBase)list);
/*     */     } 
/* 140 */     player.inventory.setInventorySlotContents(slotId, is);
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\primal\ToolAxePrimal.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */