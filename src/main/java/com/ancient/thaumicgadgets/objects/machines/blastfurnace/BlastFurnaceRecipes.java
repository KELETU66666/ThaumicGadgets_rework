/*     */ package com.ancient.thaumicgadgets.objects.machines.blastfurnace;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.init.ModBlocks;
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ import thaumcraft.api.items.ItemsTC;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlastFurnaceRecipes
/*     */ {
/*  16 */   public static final BlastFurnaceRecipes INSTANCE = new BlastFurnaceRecipes();
/*     */   
/*     */   public final class smeltRecipe
/*     */   {
/*     */     public ItemStack input;
/*  21 */     public ArrayList<BlastFurnaceRecipes.outPut> output = new ArrayList<>();
/*     */     public float experience;
/*     */     
/*     */     public smeltRecipe(ItemStack input, float experience, ItemStack... output) {
/*  25 */       this.input = input;
/*  26 */       this.experience = experience;
/*  27 */       for (ItemStack s : output) {
/*     */         
/*  29 */         if (s instanceof ItemStack)
/*     */         {
/*  31 */           this.output.add(new BlastFurnaceRecipes.outPut(s.getItem(), s.getMetadata(), s.getCount()));
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class outPut
/*     */   {
/*     */     public Item item;
/*     */     public int meta;
/*     */     public int count;
/*     */     
/*     */     public outPut(Item item, int meta, int count) {
/*  44 */       this.item = item;
/*  45 */       this.meta = meta;
/*  46 */       this.count = count;
/*     */     }
/*     */   }
/*     */   
/*  50 */   private final ArrayList<smeltRecipe> list = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public static BlastFurnaceRecipes getInstance() {
/*  54 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */   
/*     */   private BlastFurnaceRecipes() {
/*  59 */     addBlastFurnaceRecipe(new ItemStack(ItemsTC.clusters, 1, 0), 5.0F, new ItemStack[] { new ItemStack(Items.IRON_INGOT, 3), new ItemStack(Items.IRON_NUGGET) });
/*  60 */     addBlastFurnaceRecipe(new ItemStack(ItemsTC.clusters, 1, 1), 5.0F, new ItemStack[] { new ItemStack(Items.GOLD_INGOT, 3), new ItemStack(Items.GOLD_NUGGET) });
/*  61 */     addBlastFurnaceRecipe(new ItemStack(ItemsTC.clusters, 1, 6), 5.0F, new ItemStack[] { new ItemStack(ItemsTC.quicksilver, 3), new ItemStack(ItemsTC.nuggets, 1, 5) });
/*  62 */     addBlastFurnaceRecipe(new ItemStack(ItemsTC.clusters, 1, 7), 5.0F, new ItemStack[] { new ItemStack(Items.QUARTZ, 3), new ItemStack(ItemsTC.nuggets, 1, 9) });
/*  63 */     if (OreDictionary.getOres("ingotCopper").size() > 0)
/*     */     {
/*  65 */       for (ItemStack stack : OreDictionary.getOres("ingotCopper")) {
/*     */         
/*  67 */         addBlastFurnaceRecipe(new ItemStack(ItemsTC.clusters, 1, 2), 5.0F, new ItemStack[] { new ItemStack(stack.getItem(), 3, stack.getMetadata()), new ItemStack(ItemsTC.nuggets, 1, 1) });
/*     */       } 
/*     */     }
/*  70 */     if (OreDictionary.getOres("ingotTin").size() > 0)
/*     */     {
/*  72 */       for (ItemStack stack : OreDictionary.getOres("ingotTin")) {
/*     */         
/*  74 */         addBlastFurnaceRecipe(new ItemStack(ItemsTC.clusters, 1, 3), 5.0F, new ItemStack[] { new ItemStack(stack.getItem(), 3, stack.getMetadata()), new ItemStack(ItemsTC.nuggets, 1, 2) });
/*     */       } 
/*     */     }
/*  77 */     if (OreDictionary.getOres("ingotSilver").size() > 0)
/*     */     {
/*  79 */       for (ItemStack stack : OreDictionary.getOres("ingotSilver")) {
/*     */         
/*  81 */         addBlastFurnaceRecipe(new ItemStack(ItemsTC.clusters, 1, 4), 5.0F, new ItemStack[] { new ItemStack(stack.getItem(), 3, stack.getMetadata()), new ItemStack(ItemsTC.nuggets, 1, 3) });
/*     */       } 
/*     */     }
/*  84 */     if (OreDictionary.getOres("ingotLead").size() > 0)
/*     */     {
/*  86 */       for (ItemStack stack : OreDictionary.getOres("ingotLead")) {
/*     */         
/*  88 */         addBlastFurnaceRecipe(new ItemStack(ItemsTC.clusters, 1, 5), 5.0F, new ItemStack[] { new ItemStack(stack.getItem(), 3, stack.getMetadata()), new ItemStack(ItemsTC.nuggets, 1, 4) });
/*     */       } 
/*     */     }
/*  91 */     addBlastFurnaceRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.ORE_LIGHT)), 5.0F, new ItemStack[] { new ItemStack(ModItems.INGOT_LIGHT) });
/*  92 */     addBlastFurnaceRecipe(new ItemStack(Item.getItemFromBlock(ModBlocks.ORE_SHADE)), 5.0F, new ItemStack[] { new ItemStack(ModItems.INGOT_SHADE) });
/*     */   }
/*     */ 
/*     */   
/*     */   public void addBlastFurnaceRecipe(ItemStack input, float experience, ItemStack... output) {
/*  97 */     if (output.length > 0 && !input.isEmpty()) {
/*     */       
/*  99 */       smeltRecipe r = new smeltRecipe(input, experience, output);
/* 100 */       this.list.add(r);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<outPut> getWorkResult(ItemStack stack) {
/* 106 */     for (smeltRecipe r : this.list) {
/*     */       
/* 108 */       if (r.input.isItemEqual(stack))
/*     */       {
/* 110 */         return r.output;
/*     */       }
/*     */     } 
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public boolean hasWorkResult(ItemStack stack) {
/* 117 */     for (smeltRecipe r : this.list) {
/*     */       
/* 119 */       if (stack.isItemEqual(r.input))
/*     */       {
/* 121 */         return true;
/*     */       }
/*     */     } 
/* 124 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean compareItemStacks(ItemStack item1, ItemStack item2) {
/* 129 */     return (item2.getItem() == item1.getItem() && (item2.getMetadata() == 32767 || item2.getMetadata() == item1.getMetadata()));
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<smeltRecipe> getWorkingList() {
/* 134 */     return this.list;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWorkExperience(ItemStack input) {
/* 139 */     for (smeltRecipe r : this.list) {
/*     */       
/* 141 */       if (input.isItemEqual(r.input))
/*     */       {
/* 143 */         return r.experience;
/*     */       }
/*     */     } 
/*     */     
/* 147 */     return 0.0F;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\blastfurnace\BlastFurnaceRecipes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */