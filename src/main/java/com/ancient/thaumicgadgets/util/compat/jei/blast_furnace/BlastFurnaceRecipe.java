 package com.ancient.thaumicgadgets.util.compat.jei.blast_furnace;

 import com.ancient.thaumicgadgets.objects.machines.blastfurnace.BlastFurnaceRecipes;
 import com.ancient.thaumicgadgets.util.compat.jei.JEICompat;
 import java.awt.Color;
 import java.util.List;
 import mezz.jei.api.ingredients.IIngredients;
 import mezz.jei.api.recipe.IRecipeWrapper;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.gui.FontRenderer;
 import net.minecraft.item.ItemStack;



 public class BlastFurnaceRecipe
   implements IRecipeWrapper
 {
   private final ItemStack input;
   private final List<ItemStack> outputs;

   public BlastFurnaceRecipe(ItemStack input, List<ItemStack> outputs) {
/* 22 */     this.input = input;
/* 23 */     this.outputs = outputs;
   }



   public void getIngredients(IIngredients ingredients) {
/* 29 */     ingredients.setInput(ItemStack.class, this.input);
/* 30 */     ingredients.setOutputs(ItemStack.class, this.outputs);
   }



   public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
/* 36 */     BlastFurnaceRecipes recipes = BlastFurnaceRecipes.getInstance();

/* 38 */     float experience = recipes.getWorkExperience(this.outputs.get(0));

/* 40 */     if (experience > 0.0F) {

/* 42 */       String experienceString = JEICompat.translateToLocalFormatted("gui.jei.category.smelting.experience", new Object[] { Float.valueOf(experience) });
/* 43 */       FontRenderer renderer = minecraft.fontRenderer;
/* 44 */       int stringWidth = renderer.getStringWidth(experienceString);
/* 45 */       renderer.drawString(experienceString, recipeWidth - stringWidth, 0, Color.GRAY.getRGB());
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\blast_furnace\BlastFurnaceRecipe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */