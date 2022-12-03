 package com.ancient.thaumicgadgets.util.compat.jei.spinningwhell;
 
 import com.ancient.thaumicgadgets.objects.machines.spinningwheel.SpinningWheelRecipes;
 import com.ancient.thaumicgadgets.util.compat.jei.JEICompat;
 import java.awt.Color;
 import java.util.List;
 import mezz.jei.api.ingredients.IIngredients;
 import mezz.jei.api.recipe.IRecipeWrapper;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.gui.FontRenderer;
 import net.minecraft.item.ItemStack;
 
 
 
 public class SpinningWheelRecipe
   implements IRecipeWrapper
 {
   private final List<ItemStack> inputs;
   private final ItemStack output;
   
   public SpinningWheelRecipe(List<ItemStack> inputs, ItemStack output) {
/* 22 */     this.inputs = inputs;
/* 23 */     this.output = output;
   }
 
 
   
   public void getIngredients(IIngredients ingredients) {
/* 29 */     ingredients.setInputs(ItemStack.class, this.inputs);
/* 30 */     ingredients.setOutput(ItemStack.class, this.output);
   }
 
 
   
   public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
/* 36 */     SpinningWheelRecipes recipes = SpinningWheelRecipes.getInstance();
     
/* 38 */     float experience = recipes.getWorkExperience(this.output);
     
/* 40 */     if (experience > 0.0F) {
       
/* 42 */       String experienceString = JEICompat.translateToLocalFormatted("gui.jei.category.smelting.experience", new Object[] { Float.valueOf(experience) });
/* 43 */       FontRenderer renderer = minecraft.fontRenderer;
/* 44 */       int stringWidth = renderer.getStringWidth(experienceString);
/* 45 */       renderer.drawString(experienceString, recipeWidth - stringWidth, 0, Color.GRAY.getRGB());
     } 
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\spinningwhell\SpinningWheelRecipe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */