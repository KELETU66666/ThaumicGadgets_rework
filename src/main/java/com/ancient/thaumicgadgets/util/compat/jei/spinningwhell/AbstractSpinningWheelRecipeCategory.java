 package com.ancient.thaumicgadgets.util.compat.jei.spinningwhell;
 
 import mezz.jei.api.IGuiHelper;
 import mezz.jei.api.gui.IDrawableAnimated;
 import mezz.jei.api.gui.IDrawableStatic;
 import mezz.jei.api.recipe.IRecipeCategory;
 import mezz.jei.api.recipe.IRecipeWrapper;
 import net.minecraft.util.ResourceLocation;
 
 
 public abstract class AbstractSpinningWheelRecipeCategory<T extends IRecipeWrapper>
   implements IRecipeCategory<T>
 {
/* 14 */   protected static final ResourceLocation TEXTURES = new ResourceLocation("tg:textures/gui/spinning_wheel.png");
   
   protected static final int input1 = 0;
   
   protected static final int input2 = 1;
   
   protected static final int input3 = 2;
   protected static final int input4 = 3;
   protected static final int output = 4;
   protected final IDrawableAnimated animatedProcess;
   
   public AbstractSpinningWheelRecipeCategory(IGuiHelper helper) {
/* 26 */     IDrawableStatic process = helper.createDrawable(TEXTURES, 176, 0, 63, 53);
/* 27 */     this.animatedProcess = helper.createAnimatedDrawable(process, 200, IDrawableAnimated.StartDirection.LEFT, false);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\spinningwhell\AbstractSpinningWheelRecipeCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */