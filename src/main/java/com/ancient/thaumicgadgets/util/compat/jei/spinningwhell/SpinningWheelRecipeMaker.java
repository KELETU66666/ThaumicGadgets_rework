 package com.ancient.thaumicgadgets.util.compat.jei.spinningwhell;
 
 import com.ancient.thaumicgadgets.objects.machines.spinningwheel.SpinningWheelRecipes;
 import com.google.common.collect.Lists;
 import java.util.List;
 import java.util.Map;
 import mezz.jei.api.IJeiHelpers;
 import mezz.jei.api.recipe.IStackHelper;
 import net.minecraft.item.ItemStack;
 
 
 
 
 
 public class SpinningWheelRecipeMaker
 {
   public static List<SpinningWheelRecipe> getRecipes(IJeiHelpers helpers) {
/* 18 */     IStackHelper stackHelper = helpers.getStackHelper();
/* 19 */     SpinningWheelRecipes instance = SpinningWheelRecipes.getInstance();
/* 20 */     List<SpinningWheelRecipe> jeiRecipes = Lists.newArrayList();
     
/* 22 */     Map<String, SpinningWheelRecipes.craftingRecepies> list = instance.getDualWorkingList();
     
/* 24 */     for (Map.Entry<String, SpinningWheelRecipes.craftingRecepies> e : list.entrySet()) {
       
/* 26 */       SpinningWheelRecipes.craftingRecepies recipe = (SpinningWheelRecipes.craftingRecepies)e.getValue();
       
/* 28 */       ItemStack input1 = recipe.item1;
/* 29 */       ItemStack input2 = recipe.item2;
/* 30 */       ItemStack input3 = recipe.item3;
/* 31 */       ItemStack input4 = recipe.item4;
/* 32 */       ItemStack output = recipe.result;
       
/* 34 */       List<ItemStack> inputs = Lists.newArrayList((new ItemStack[] { input1, input2, input3, input4 }));
/* 35 */       SpinningWheelRecipe swrecipe = new SpinningWheelRecipe(inputs, output);
       
/* 37 */       jeiRecipes.add(swrecipe);
     } 
     
/* 40 */     return jeiRecipes;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\spinningwhell\SpinningWheelRecipeMaker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */