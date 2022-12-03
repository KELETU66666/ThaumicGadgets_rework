 package com.ancient.thaumicgadgets.util.compat.jei.gemcutter;

 import com.ancient.thaumicgadgets.objects.machines.gemcutter.GemCutterRecipes;
 import com.google.common.collect.Lists;
 import java.util.List;
 import mezz.jei.api.IJeiHelpers;
 import mezz.jei.api.recipe.IStackHelper;
 import net.minecraft.item.ItemStack;
 import thaumcraft.api.aspects.AspectList;





 public class GemCutterRecipeMaker
 {
   public static List<GemCutterRecipe> getRecipes(IJeiHelpers helpers) {
/* 18 */     IStackHelper stackHelper = helpers.getStackHelper();
/* 19 */     GemCutterRecipes instance = GemCutterRecipes.getInstance();
/* 20 */     List<GemCutterRecipe> jeiRecipes = Lists.newArrayList();

/* 22 */     List<GemCutterRecipes.gemCutterRecipe> list = instance.getRecipeList();

/* 24 */     for (GemCutterRecipes.gemCutterRecipe e : list) {

/* 26 */       ItemStack input = e.input;
/* 27 */       AspectList aspects = e.aspects;
/* 28 */       int mode = e.mode;
/* 29 */       ItemStack output = e.outPut;

/* 31 */       GemCutterRecipe swrecipe = new GemCutterRecipe(input, aspects, mode, output);

/* 33 */       jeiRecipes.add(swrecipe);
     }

/* 36 */     return jeiRecipes;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\gemcutter\GemCutterRecipeMaker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */