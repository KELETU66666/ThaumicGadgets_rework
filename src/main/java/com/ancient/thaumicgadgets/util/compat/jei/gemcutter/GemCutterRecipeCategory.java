 package com.ancient.thaumicgadgets.util.compat.jei.gemcutter;
 
 import com.ancient.thaumicgadgets.init.ModBlocks;
 import mezz.jei.api.IGuiHelper;
 import mezz.jei.api.gui.IDrawable;
 import mezz.jei.api.gui.IGuiItemStackGroup;
 import mezz.jei.api.gui.IRecipeLayout;
 import mezz.jei.api.ingredients.IIngredients;
 import mezz.jei.api.recipe.IRecipeWrapper;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 
 
 
 
 
 
 public class GemCutterRecipeCategory
   extends AbstractGemCutterRecipeCategory<GemCutterRecipe>
 {
   private final IDrawable background;
   private final IDrawable icon;
   private final String name;
   
   public GemCutterRecipeCategory(IGuiHelper helper) {
/* 26 */     super(helper);
/* 27 */     this.background = (IDrawable)helper.createDrawable(TEXTURES, 0, 0, 176, 90);
/* 28 */     this.icon = helper.createDrawableIngredient(new ItemStack(Item.getItemFromBlock(ModBlocks.GEMCUTTER)));
/* 29 */     this.name = "GemCutter";
   }
 
 
   
   public IDrawable getBackground() {
/* 35 */     return this.background;
   }
 
 
   
   public String getTitle() {
/* 41 */     return this.name;
   }
 
 
   
   public IDrawable getIcon() {
/* 47 */     return this.icon;
   }
 
 
   
   public String getModName() {
/* 53 */     return "Thaumic Gadgets";
   }
 
 
   
   public String getUid() {
/* 59 */     return "tg.gemcutter";
   }
 
 
   
   public void setRecipe(IRecipeLayout recipeLayout, GemCutterRecipe recipeWrapper, IIngredients ingredients) {
/* 65 */     IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
/* 66 */     stacks.init(0, true, 41, 16);
     
/* 68 */     stacks.init(3, false, 117, 16);
     
/* 70 */     stacks.set(ingredients);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\gemcutter\GemCutterRecipeCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */