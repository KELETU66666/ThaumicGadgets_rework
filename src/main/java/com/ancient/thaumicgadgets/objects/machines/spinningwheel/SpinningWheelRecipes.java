/*     */ package com.ancient.thaumicgadgets.objects.machines.spinningwheel;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Map;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import thaumcraft.api.blocks.BlocksTC;
/*     */ import thaumcraft.api.items.ItemsTC;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpinningWheelRecipes
/*     */ {
/*  17 */   private static final SpinningWheelRecipes INSTANCE = new SpinningWheelRecipes();
/*     */ 
/*     */   
/*     */   public class craftingRecepies
/*     */   {
/*     */     public String group;
/*     */     public ItemStack item1;
/*     */     public ItemStack item2;
/*     */     public ItemStack item3;
/*     */     public ItemStack item4;
/*     */     public ItemStack result;
/*     */     public float experience;
/*     */     
/*     */     public craftingRecepies(String group, ItemStack Item1, ItemStack Item2, ItemStack Item3, ItemStack Item4, ItemStack Result, float Experience) {
/*  31 */       this.group = group;
/*  32 */       this.item1 = Item1;
/*  33 */       this.item2 = Item2;
/*  34 */       this.item3 = Item3;
/*  35 */       this.item4 = Item4;
/*  36 */       this.result = Result;
/*  37 */       this.experience = Experience;
/*     */     }
/*     */   }
/*     */   
/*  41 */   private final Map<String, craftingRecepies> list = Maps.newHashMap();
/*     */ 
/*     */   
/*     */   public static SpinningWheelRecipes getInstance() {
/*  45 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private SpinningWheelRecipes() {
/*  51 */     addSpinningWheelRecipe("tg:yarn", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ModItems.YARN), 5.0F);
/*  52 */     addSpinningWheelRecipe("tg:yarn_gold", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.GOLD_NUGGET), new ItemStack(ModItems.YARN_GOLD), 5.0F);
/*  53 */     addSpinningWheelRecipe("tg:yarn_thanium", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ItemsTC.nuggets, 1, 6), new ItemStack(ModItems.YARN_THANIUM), 5.0F);
/*  54 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ItemsTC.nuggets, 1, 8), new ItemStack(ModItems.YARN_MAGIC), 5.0F);
/*  55 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ModItems.NUGGET_LIGHT), new ItemStack(ModItems.YARN_LIGHT), 5.0F);
/*  56 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ModItems.NUGGET_SHADE), new ItemStack(ModItems.YARN_SHADE), 5.0F);
/*  57 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Item.getItemFromBlock(BlocksTC.shimmerleaf)), new ItemStack(ModItems.YARN_ETHER), 5.0F);
/*  58 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ItemsTC.nuggets, 1, 7), new ItemStack(ModItems.YARN_VOID), 5.0F);
/*     */     
/*  60 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(ModItems.YARN), new ItemStack(ModItems.YARN), new ItemStack(ModItems.YARN_GOLD), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.FABRIC_DECORATED), 5.0F);
/*  61 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(ModItems.YARN), new ItemStack(ModItems.YARN), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ItemsTC.fabric), 5.0F);
/*  62 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_GOLD), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.FABRIC_ENCHANTED), 5.0F);
/*  63 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(ModItems.YARN_ETHER), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.YARN_LIGHT), new ItemStack(ModItems.YARN_LIGHT), new ItemStack(ModItems.FABRIC_LIGHT), 5.0F);
/*  64 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(ModItems.YARN_ETHER), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.YARN_SHADE), new ItemStack(ModItems.YARN_SHADE), new ItemStack(ModItems.FABRIC_SHADE), 5.0F);
/*  65 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(ModItems.YARN_GOLD), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_VOID), new ItemStack(ModItems.YARN_VOID), new ItemStack(ModItems.FABRIC_VOID), 5.0F);
/*  66 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(ModItems.YARN_ETHER), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.FABRIC_BEWITCHED), 5.0F);
/*  67 */     addSpinningWheelRecipe("tg:weaving", new ItemStack(ModItems.YARN_ETHER), new ItemStack(ModItems.YARN_LIGHT), new ItemStack(ModItems.YARN_SHADE), new ItemStack(ModItems.YARN_VOID), new ItemStack(ModItems.FABRIC_VOLATILE), 5.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSpinningWheelRecipe(String group, ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack result, float experience) {
/*  73 */     if (!result.isEmpty()) {
/*     */       
/*  75 */       craftingRecepies recipe = new craftingRecepies(group, input1, input2, input3, input4, result, Float.valueOf(experience).floatValue());
/*  76 */       this.list.put(result.getUnlocalizedName().toLowerCase(), recipe);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxRecipeCount() {
/*  82 */     return this.list.size();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getWorkResult(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4) {
/*  88 */     for (Map.Entry<String, craftingRecepies> e : this.list.entrySet()) {
/*     */       
/*  90 */       craftingRecepies recipe = (craftingRecepies)e.getValue();
/*     */       
/*  92 */       if (compareItemStacks(input1, recipe.item1) && compareItemStacks(input2, recipe.item2) && compareItemStacks(input3, recipe.item3) && compareItemStacks(input4, recipe.item4))
/*     */       {
/*  94 */         return recipe.result;
/*     */       }
/*     */     } 
/*     */     
/*  98 */     return ItemStack.EMPTY;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean compareItemStacks(ItemStack item1, ItemStack item2) {
/* 103 */     return (item2.getItem() == item1.getItem() && (item2.getMetadata() == 32767 || item2.getMetadata() == item1.getMetadata()));
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, craftingRecepies> getDualWorkingList() {
/* 108 */     return this.list;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getWorkExperience(ItemStack output) {
/* 113 */     for (Map.Entry<String, craftingRecepies> e : this.list.entrySet()) {
/*     */       
/* 115 */       craftingRecepies recipe = (craftingRecepies)e.getValue();
/* 116 */       if (output.isItemEqual(recipe.result))
/*     */       {
/* 118 */         return recipe.experience;
/*     */       }
/*     */     } 
/*     */     
/* 122 */     return 0.0F;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\spinningwheel\SpinningWheelRecipes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */