 package com.ancient.thaumicgadgets.util.compat.jei.blast_furnace;

 import mezz.jei.api.IGuiHelper;
 import mezz.jei.api.gui.IDrawableAnimated;
 import mezz.jei.api.gui.IDrawableStatic;
 import mezz.jei.api.recipe.IRecipeCategory;
 import mezz.jei.api.recipe.IRecipeWrapper;
 import net.minecraft.util.ResourceLocation;


 public abstract class AbstractBlastFurnaceRecipeCategory<T extends IRecipeWrapper>
   implements IRecipeCategory<T>
 {
/* 14 */   protected static final ResourceLocation TEXTURES = new ResourceLocation("tg:textures/gui/jei/blast_furnace.png");

   protected static final int input1 = 0;

   protected static final int output1 = 1;

   protected static final int output2 = 2;
   protected final IDrawableAnimated animatedProcess;

   public AbstractBlastFurnaceRecipeCategory(IGuiHelper helper) {
/* 24 */     IDrawableStatic process = helper.createDrawable(TEXTURES, 176, 0, 21, 14);
/* 25 */     this.animatedProcess = helper.createAnimatedDrawable(process, 80, IDrawableAnimated.StartDirection.LEFT, false);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\blast_furnace\AbstractBlastFurnaceRecipeCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */