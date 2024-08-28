/*     */ package com.ancient.thaumicgadgets.objects.machines.gemcutter;
/*     */ 
/*     */

import com.ancient.thaumicgadgets.init.ModItems;
import com.google.common.collect.Lists;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IThaumcraftRecipe;
import thaumcraft.api.items.ItemsTC;

import java.util.List;
import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GemCutterRecipes
/*     */ {
/*  19 */   private static final GemCutterRecipes INSTANCE = new GemCutterRecipes();
/*     */   
/*     */   public final class gemCutterRecipe
/*     */     implements IThaumcraftRecipe
/*     */   {
/*     */     public String name;
/*     */     public ItemStack input;
/*     */     public AspectList aspects;
/*     */     public ItemStack outPut;
/*     */     public int mode;
/*     */     public String research;
/*     */     public String group;
/*     */     
/*     */     public gemCutterRecipe(String name, ItemStack input, AspectList aspects, ItemStack outPut, int mode, String research, String group) {
/*  33 */       this.name = name;
/*  34 */       this.input = input;
/*  35 */       this.aspects = aspects;
/*  36 */       this.outPut = outPut;
/*  37 */       this.mode = mode;
/*  38 */       this.research = research;
/*  39 */       this.group = group;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getResearch() {
/*  45 */       return this.research;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getGroup() {
/*  51 */       return this.group;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  57 */       return "Input: " + this.input.toString() + " Aspects: " + this.aspects + " OutPut: " + this.outPut.toString() + " Mode: " + this.mode;
/*     */     }
/*     */   }
/*     */   
/*  61 */   private final List<gemCutterRecipe> list = Lists.newArrayList();
/*     */ 
/*     */ 
/*     */   
/*     */   private GemCutterRecipes() {
/*  66 */     addGemCutterRecipe("sharped_crystal_air_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.AIR, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
/*  67 */     addGemCutterRecipe("sharped_crystal_air_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.AIR, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
/*  68 */     addGemCutterRecipe("sharped_crystal_air_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.AIR, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
/*  69 */     addGemCutterRecipe("sharped_crystal_air_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.AIR, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
/*  70 */     addGemCutterRecipe("sharped_crystal_air_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.AIR, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
/*     */     
/*  72 */     addGemCutterRecipe("sharped_crystal_fire_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.FIRE, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
/*  73 */     addGemCutterRecipe("sharped_crystal_fire_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.FIRE, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
/*  74 */     addGemCutterRecipe("sharped_crystal_fire_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.FIRE, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
/*  75 */     addGemCutterRecipe("sharped_crystal_fire_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.FIRE, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
/*  76 */     addGemCutterRecipe("sharped_crystal_fire_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.FIRE, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
/*     */     
/*  78 */     addGemCutterRecipe("sharped_crystal_earth_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.EARTH, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
/*  79 */     addGemCutterRecipe("sharped_crystal_earth_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.EARTH, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
/*  80 */     addGemCutterRecipe("sharped_crystal_earth_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.EARTH, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
/*  81 */     addGemCutterRecipe("sharped_crystal_earth_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.EARTH, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
/*  82 */     addGemCutterRecipe("sharped_crystal_earth_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.EARTH, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
/*     */     
/*  84 */     addGemCutterRecipe("sharped_crystal_water_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.WATER, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
/*  85 */     addGemCutterRecipe("sharped_crystal_water_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.WATER, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
/*  86 */     addGemCutterRecipe("sharped_crystal_water_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.WATER, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
/*  87 */     addGemCutterRecipe("sharped_crystal_water_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.WATER, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
/*  88 */     addGemCutterRecipe("sharped_crystal_water_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.WATER, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
/*     */     
/*  90 */     addGemCutterRecipe("sharped_crystal_order_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.ORDER, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
/*  91 */     addGemCutterRecipe("sharped_crystal_order_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.ORDER, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
/*  92 */     addGemCutterRecipe("sharped_crystal_order_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.ORDER, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
/*  93 */     addGemCutterRecipe("sharped_crystal_order_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.ORDER, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
/*  94 */     addGemCutterRecipe("sharped_crystal_order_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.ORDER, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
/*     */     
/*  96 */     addGemCutterRecipe("sharped_crystal_entropy_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.ENTROPY, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
/*  97 */     addGemCutterRecipe("sharped_crystal_entropy_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.ENTROPY, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
/*  98 */     addGemCutterRecipe("sharped_crystal_entropy_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.ENTROPY, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
/*  99 */     addGemCutterRecipe("sharped_crystal_entropy_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.ENTROPY, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
/* 100 */     addGemCutterRecipe("sharped_crystal_entropy_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.ENTROPY, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
/*     */ 
/*     */     
/* 103 */     addGemCutterRecipe("oval_crystal_air_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.AIR, 40), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
/* 104 */     addGemCutterRecipe("oval_crystal_air_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.AIR, 35), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
/* 105 */     addGemCutterRecipe("oval_crystal_air_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.AIR, 50), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
/* 106 */     addGemCutterRecipe("oval_crystal_air_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.AIR, 75), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
/* 107 */     addGemCutterRecipe("oval_crystal_air_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.AIR, 60), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
/*     */     
/* 109 */     addGemCutterRecipe("oval_crystal_fire_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.FIRE, 40), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
/* 110 */     addGemCutterRecipe("oval_crystal_fire_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.FIRE, 35), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
/* 111 */     addGemCutterRecipe("oval_crystal_fire_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.FIRE, 50), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
/* 112 */     addGemCutterRecipe("oval_crystal_fire_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.FIRE, 75), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
/* 113 */     addGemCutterRecipe("oval_crystal_fire_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.FIRE, 60), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
/*     */     
/* 115 */     addGemCutterRecipe("oval_crystal_earth_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.EARTH, 40), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
/* 116 */     addGemCutterRecipe("oval_crystal_earth_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.EARTH, 35), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
/* 117 */     addGemCutterRecipe("oval_crystal_earth_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.EARTH, 50), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
/* 118 */     addGemCutterRecipe("oval_crystal_earth_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.EARTH, 75), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
/* 119 */     addGemCutterRecipe("oval_crystal_earth_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.EARTH, 60), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
/*     */     
/* 121 */     addGemCutterRecipe("oval_crystal_water_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.WATER, 40), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
/* 122 */     addGemCutterRecipe("oval_crystal_water_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.WATER, 35), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
/* 123 */     addGemCutterRecipe("oval_crystal_water_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.WATER, 50), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
/* 124 */     addGemCutterRecipe("oval_crystal_water_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.WATER, 75), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
/* 125 */     addGemCutterRecipe("oval_crystal_water_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.WATER, 60), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
/*     */     
/* 127 */     addGemCutterRecipe("oval_crystal_order_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.ORDER, 40), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
/* 128 */     addGemCutterRecipe("oval_crystal_order_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.ORDER, 35), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
/* 129 */     addGemCutterRecipe("oval_crystal_order_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.ORDER, 50), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
/* 130 */     addGemCutterRecipe("oval_crystal_order_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.ORDER, 75), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
/* 131 */     addGemCutterRecipe("oval_crystal_order_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.ORDER, 60), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
/*     */     
/* 133 */     addGemCutterRecipe("oval_crystal_entropy_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.ENTROPY, 40), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
/* 134 */     addGemCutterRecipe("oval_crystal_entropy_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.ENTROPY, 35), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
/* 135 */     addGemCutterRecipe("oval_crystal_entropy_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.ENTROPY, 50), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
/* 136 */     addGemCutterRecipe("oval_crystal_entropy_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.ENTROPY, 75), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
/* 137 */     addGemCutterRecipe("oval_crystal_entropy_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.ENTROPY, 60), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
/*     */ }
/*     */ 
/*     */   
/*     */   public static GemCutterRecipes getInstance() {
/* 150 */     return INSTANCE;
/*     */   }
/*     */   
/*     */   public void addGemCutterRecipe(String name, ItemStack input, AspectList aspects, ItemStack result, int mode, String research, String group) {
/*     */     while (true) {
/* 155 */       if (!containOnlyPrimalAspects(aspects)) {
/*     */         
/* 157 */         toPrimal(aspects); continue;
/*     */       }  break;
/* 159 */     }  this.list.add(new gemCutterRecipe(name, input, aspects, result, mode, research, group));
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxRecipeCount() {
/* 164 */     return this.list.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public ItemStack getWorkResult(ItemStack input, AspectList aspects, int mode) {
/* 169 */     if (input != ItemStack.EMPTY && aspects != null)
/*     */     {
/* 171 */       for (gemCutterRecipe r : this.list) {
/*     */         
/* 173 */         if (compareItemStacks(input, r.input) && compareAspectList(r.aspects, aspects) && r.mode == mode)
/*     */         {
/* 175 */           return r.outPut;
/*     */         }
/*     */       } 
/*     */     }
/* 179 */     return ItemStack.EMPTY;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean compareItemStacks(ItemStack item1, ItemStack item2) {
/* 184 */     return (item2.getItem() == item1.getItem() && (item2.getMetadata() == 32767 || item2.getMetadata() == item1.getMetadata()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public gemCutterRecipe getRecipeEntry(ItemStack input, AspectList aspects, int mode) {
/* 190 */     for (gemCutterRecipe r : this.list) {
/*     */       
/* 192 */       if (compareItemStacks(r.input, input) && compareAspectList(r.aspects, aspects) && r.mode == mode)
/*     */       {
/* 194 */         return r;
/*     */       }
/*     */     } 
/* 197 */     return null;
/*     */   }
/*     */   
/*     */   public List<gemCutterRecipe> getRecipeList() {
/* 201 */     return this.list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static AspectList toPrimal(AspectList aspects) {
/* 207 */     AspectList toAdd = new AspectList();
/* 208 */     AspectList toRemove = new AspectList();
/* 209 */     if (aspects != null) {
/*     */       
/* 211 */       for (Map.Entry<Aspect, Integer> e : (Iterable<Map.Entry<Aspect, Integer>>)aspects.aspects.entrySet()) {
/*     */         
/* 213 */         if (!((Aspect)e.getKey()).isPrimal()) {
/*     */           
/* 215 */           for (Aspect as : ((Aspect)e.getKey()).getComponents())
/*     */           {
/* 217 */             toAdd.add(as, ((Integer)e.getValue()).intValue());
/*     */           }
/* 219 */           toRemove.add(e.getKey(), ((Integer)e.getValue()).intValue());
/*     */         } 
/*     */       } 
/*     */       
/* 223 */       for (Aspect as : toAdd.getAspects())
/*     */       {
/* 225 */         aspects.add(as, toAdd.getAmount(as));
/*     */       }
/* 227 */       for (Aspect as : toRemove.getAspects())
/*     */       {
/* 229 */         aspects.remove(as, toRemove.getAmount(as));
/*     */       }
/* 231 */       return aspects;
/*     */     } 
/* 233 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean containOnlyPrimalAspects(AspectList aspects) {
/* 238 */     if (aspects != null) {
/*     */       
/* 240 */       for (Aspect as : aspects.getAspects()) {
/*     */         
/* 242 */         if (!as.isPrimal())
/*     */         {
/* 244 */           return false;
/*     */         }
/*     */       } 
/* 247 */       return true;
/*     */     } 
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean compareAspectList(AspectList recipe, AspectList table) {
/* 254 */     for (Aspect as : recipe.getAspects()) {
/*     */       
/* 256 */       if (!table.aspects.containsKey(as) || ((Integer)table.aspects.get(as)).intValue() < recipe.getAmount(as))
/*     */       {
/* 258 */         return false;
/*     */       }
/*     */     } 
/* 261 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\gemcutter\GemCutterRecipes.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */