 package com.ancient.thaumicgadgets.util.compat.jei.blast_furnace;
 
 import com.ancient.thaumicgadgets.objects.machines.blastfurnace.BlastFurnaceRecipes;
 import com.google.common.collect.Lists;
 import java.util.ArrayList;
 import java.util.List;
 import mezz.jei.api.IJeiHelpers;
 import mezz.jei.api.recipe.IStackHelper;
 import net.minecraft.item.ItemStack;
 
 
 
 
 
 
 public class BlastFurnaceRecipeMaker
 {
   public static List<BlastFurnaceRecipe> getRecipes(IJeiHelpers helpers) {
/* 19 */     IStackHelper stackHelper = helpers.getStackHelper();
/* 20 */     BlastFurnaceRecipes instance = BlastFurnaceRecipes.INSTANCE;
/* 21 */     List<BlastFurnaceRecipe> jeiRecipes = Lists.newArrayList();
     
/* 23 */     ArrayList<BlastFurnaceRecipes.smeltRecipe> list = instance.getWorkingList();
     
/* 25 */     for (BlastFurnaceRecipes.smeltRecipe sr : list) {
       
/* 27 */       ItemStack input1 = sr.input;
/* 28 */       List<ItemStack> outputs = Lists.newArrayList();
/* 29 */       for (BlastFurnaceRecipes.outPut o : sr.output)
       {
/* 31 */         outputs.add(new ItemStack(o.item, o.count, o.meta));
       }
/* 33 */       BlastFurnaceRecipe bfrecipe = new BlastFurnaceRecipe(input1, outputs);
       
/* 35 */       jeiRecipes.add(bfrecipe);
     } 
     
/* 38 */     return jeiRecipes;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\blast_furnace\BlastFurnaceRecipeMaker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */