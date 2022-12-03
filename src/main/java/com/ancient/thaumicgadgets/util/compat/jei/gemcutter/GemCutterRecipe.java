 package com.ancient.thaumicgadgets.util.compat.jei.gemcutter;

 import com.ancient.thaumicgadgets.objects.machines.gemcutter.GUIGemCutter;
 import com.ancient.thaumicgadgets.util.IRenderHelper;
 import mezz.jei.api.ingredients.IIngredients;
 import mezz.jei.api.recipe.IRecipeWrapper;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.renderer.GlStateManager;
 import net.minecraft.item.ItemStack;
 import thaumcraft.api.aspects.Aspect;
 import thaumcraft.api.aspects.AspectList;


 public class GemCutterRecipe
   implements IRecipeWrapper
 {
   private final ItemStack input;
   private final AspectList aspects;
   private final int mode;
   private final ItemStack output;

   public GemCutterRecipe(ItemStack input, AspectList aspects, int mode, ItemStack output) {
/* 23 */     this.input = input;
/* 24 */     this.aspects = aspects;
/* 25 */     this.mode = mode;
/* 26 */     this.output = output;
   }




   public void drawInfo(Minecraft mc, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
/* 33 */     GlStateManager.pushMatrix();

/* 35 */     GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

/* 37 */     mc.renderEngine.bindTexture(AbstractGemCutterRecipeCategory.TEXTURES);

/* 39 */     int x = GUIGemCutter.gemCoords[this.mode][0];
/* 40 */     int y = GUIGemCutter.gemCoords[this.mode][1];

/* 42 */     GlStateManager.enableAlpha();
/* 43 */     GlStateManager.enableBlend();

/* 45 */     IRenderHelper.drawTexturedModalRect(recipeWidth / 2 - 15, recipeHeight / 2 - 38, x, y, 30, 30);

/* 47 */     int q = 0;
/* 48 */     for (Aspect as : this.aspects.getAspects()) {

/* 50 */       mc.renderEngine.bindTexture(as.getImage());
/* 51 */       String color = Integer.toHexString(as.getColor());
/* 52 */       float rColor = Integer.parseInt(color.substring(0, 2), 16) / 255.0F;
/* 53 */       float gColor = Integer.parseInt(color.substring(2, 4), 16) / 255.0F;
/* 54 */       float bColor = Integer.parseInt(color.substring(4, 6), 16) / 255.0F;
/* 55 */       GlStateManager.color(rColor, gColor, bColor);
/* 56 */       GlStateManager.scale(0.5F, 0.5F, 1.0F);
/* 57 */       IRenderHelper.drawTexturedModalRectCustomSized((recipeWidth / 2 - q * 20 - 8) * 2, (recipeHeight / 2 + 16) * 2, 0, 0, 32, 32, 32, 32);
/* 58 */       GlStateManager.scale(1.5F, 1.5F, 1.0F);
/* 59 */       String s = Integer.toString(this.aspects.getAmount(as));
/* 60 */       IRenderHelper.drawString(mc.fontRenderer, s, Math.round((recipeWidth / 2 - mc.fontRenderer.getStringWidth(s) - 2 - q * 20) * 1.5F), Math.round((recipeHeight / 2 + 0) * 1.5F), as.getColor());
/* 61 */       GlStateManager.scale(1.5F, 1.5F, 1.0F);
/* 62 */       q++;
     }
/* 64 */     GlStateManager.disableBlend();
/* 65 */     GlStateManager.disableAlpha();

/* 67 */     GlStateManager.popMatrix();
   }



   public void getIngredients(IIngredients ingredients) {
/* 73 */     ingredients.setInput(ItemStack.class, this.input);
/* 74 */     ingredients.setOutput(ItemStack.class, this.output);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\compat\jei\gemcutter\GemCutterRecipe.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */