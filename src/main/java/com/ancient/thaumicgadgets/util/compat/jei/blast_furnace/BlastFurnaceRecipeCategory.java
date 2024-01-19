 package com.ancient.thaumicgadgets.util.compat.jei.blast_furnace;
 
 import com.ancient.thaumicgadgets.init.ModBlocks;
 import mezz.jei.api.IGuiHelper;
 import mezz.jei.api.gui.IDrawable;
 import mezz.jei.api.gui.IGuiItemStackGroup;
 import mezz.jei.api.gui.IRecipeLayout;
 import mezz.jei.api.ingredients.IIngredients;
 import mezz.jei.api.recipe.IRecipeWrapper;
 import net.minecraft.client.Minecraft;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 
 
 
 
 public class BlastFurnaceRecipeCategory extends AbstractBlastFurnaceRecipeCategory<BlastFurnaceRecipe>
 {
   private final IDrawable background;
   private final IDrawable icon;
   private final String name;
   
   public BlastFurnaceRecipeCategory(IGuiHelper helper) {
       super(helper);
       this.background = helper.createDrawable(TEXTURES, 0, 0, 176, 93);
       this.icon = helper.createDrawableIngredient(new ItemStack(Item.getItemFromBlock(ModBlocks.FURNACE)));
       this.name = "Blast Furnace";
   }
 
 
   
   public IDrawable getBackground() {
/* 34 */     return this.background;
   }
 
 
   
   public void drawExtras(Minecraft minecraft) {
       this.animatedProcess.draw(minecraft, 39, 12);
       this.animatedProcess.draw(minecraft, 116, 28);
       this.animatedProcess.draw(minecraft, 116, 51);
   }
 
 
   
   public String getTitle() {
/* 48 */     return this.name;
   }
 
 
   
   public IDrawable getIcon() {
/* 54 */     return this.icon;
   }
 
 
   
   public String getModName() {
/* 60 */     return "Thaumic Gadgets";
   }
 
 
   
   public String getUid() {
/* 66 */     return "tg.blast_furnace";
   }
 
 
   
   public void setRecipe(IRecipeLayout recipeLayout, BlastFurnaceRecipe recipeWrapper, IIngredients ingredients) {
       IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
       stacks.init(0, true, 13, 11);
       stacks.init(1, false, 143, 23);
       stacks.init(2, false, 143, 48);

       stacks.set(ingredients);
   }
 }