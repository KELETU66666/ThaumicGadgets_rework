 package com.ancient.thaumicgadgets.util.compat.jei.gemcutter;

 import mezz.jei.api.IGuiHelper;
 import mezz.jei.api.gui.IDrawableStatic;
 import mezz.jei.api.recipe.IRecipeCategory;
 import mezz.jei.api.recipe.IRecipeWrapper;
 import net.minecraft.util.ResourceLocation;
 
 
 
 public abstract class AbstractGemCutterRecipeCategory<T extends IRecipeWrapper>
   implements IRecipeCategory<T>
 {
/* 14 */   public static final ResourceLocation TEXTURES = new ResourceLocation("tg:textures/gui/jei/gemcutter.png");
   
   protected static final int input = 0;
   
   protected static final int aspects = 1;
   protected static final int mode = 2;
   protected static final int output = 3;
   
   public AbstractGemCutterRecipeCategory(IGuiHelper helper) {
/* 23 */     IDrawableStatic process = helper.createDrawable(TEXTURES, 225, 84, 27, 35);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\gemcutter\AbstractGemCutterRecipeCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */