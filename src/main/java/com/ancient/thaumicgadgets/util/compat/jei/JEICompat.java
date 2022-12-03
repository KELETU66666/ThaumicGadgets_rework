 package com.ancient.thaumicgadgets.util.compat.jei;
 
 import com.ancient.thaumicgadgets.objects.machines.gemcutter.GUIGemCutter;
 import com.ancient.thaumicgadgets.objects.machines.spinningwheel.ContainerSpinningWheel;
 import com.ancient.thaumicgadgets.objects.machines.spinningwheel.GUISpinningWheel;
 import com.ancient.thaumicgadgets.util.compat.jei.blast_furnace.BlastFurnaceRecipeCategory;
 import com.ancient.thaumicgadgets.util.compat.jei.blast_furnace.BlastFurnaceRecipeMaker;
 import com.ancient.thaumicgadgets.util.compat.jei.gemcutter.GemCutterRecipeCategory;
 import com.ancient.thaumicgadgets.util.compat.jei.gemcutter.GemCutterRecipeMaker;
 import com.ancient.thaumicgadgets.util.compat.jei.spinningwhell.SpinningWheelRecipeCategory;
 import com.ancient.thaumicgadgets.util.compat.jei.spinningwhell.SpinningWheelRecipeMaker;
 import java.util.IllegalFormatException;
 import mezz.jei.api.IGuiHelper;
 import mezz.jei.api.IJeiHelpers;
 import mezz.jei.api.IModPlugin;
 import mezz.jei.api.IModRegistry;
 import mezz.jei.api.JEIPlugin;
 import mezz.jei.api.ingredients.IIngredientRegistry;
 import mezz.jei.api.recipe.IRecipeCategory;
 import mezz.jei.api.recipe.IRecipeCategoryRegistration;
 import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
 import net.minecraft.util.text.translation.I18n;
 
 
 
 @JEIPlugin
 public class JEICompat
   implements IModPlugin
 {
   public void registerCategories(IRecipeCategoryRegistration registry) {
/* 31 */     IJeiHelpers helpers = registry.getJeiHelpers();
/* 32 */     IGuiHelper gui = helpers.getGuiHelper();
     
/* 34 */     registry.addRecipeCategories(new IRecipeCategory[] { (IRecipeCategory)new SpinningWheelRecipeCategory(gui) });
/* 35 */     registry.addRecipeCategories(new IRecipeCategory[] { (IRecipeCategory)new BlastFurnaceRecipeCategory(gui) });
/* 36 */     registry.addRecipeCategories(new IRecipeCategory[] { (IRecipeCategory)new GemCutterRecipeCategory(gui) });
   }
 
 
   
   public void register(IModRegistry registry) {
/* 42 */     IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
/* 43 */     IJeiHelpers jeiHelpers = registry.getJeiHelpers();
/* 44 */     IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
     
/* 46 */     registry.addRecipes(SpinningWheelRecipeMaker.getRecipes(jeiHelpers), "tg.spinning_wheel");
/* 47 */     registry.addRecipeClickArea(GUISpinningWheel.class, 130, 0, 50, 50, new String[] { "tg.spinning_wheel" });
/* 48 */     recipeTransfer.addRecipeTransferHandler(ContainerSpinningWheel.class, "tg.spinning_wheel", 0, 4, 5, 36);
     
/* 50 */     registry.addRecipes(BlastFurnaceRecipeMaker.getRecipes(jeiHelpers), "tg.blast_furnace");
     
/* 52 */     registry.addRecipes(GemCutterRecipeMaker.getRecipes(jeiHelpers), "tg.gemcutter");
/* 53 */     registry.addRecipeClickArea(GUIGemCutter.class, 130, 0, 50, 50, new String[] { "tg.gemcutter" });
   }
 
   
   public static String translateToLocal(String key) {
/* 58 */     if (I18n.canTranslate(key))
     {
/* 60 */       return I18n.translateToLocal(key);
     }
 
     
/* 64 */     return I18n.translateToFallback(key);
   }
 
 
   
   public static String translateToLocalFormatted(String key, Object... format) {
/* 70 */     String s = translateToLocal(key);
     
     try {
/* 73 */       return String.format(s, format);
     }
/* 75 */     catch (IllegalFormatException e) {
       
/* 77 */       return "Format Error" + s;
     } 
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\JEICompat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */