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
     protected static final ResourceLocation TEXTURES = new ResourceLocation("tg:textures/gui/spinning_wheel.png");
   
   protected static final int input1 = 0;
   
   protected static final int input2 = 1;
   
   protected static final int input3 = 2;
   protected static final int input4 = 3;
   protected static final int output = 4;
   protected final IDrawableAnimated animatedProcess;
   
   public AbstractSpinningWheelRecipeCategory(IGuiHelper helper) {
       IDrawableStatic process = helper.createDrawable(TEXTURES, 176, 0, 63, 53);
       this.animatedProcess = helper.createAnimatedDrawable(process, 200, IDrawableAnimated.StartDirection.LEFT, false);
   }
 }