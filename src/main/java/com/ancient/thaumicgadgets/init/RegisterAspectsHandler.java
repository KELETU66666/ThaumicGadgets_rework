 package com.ancient.thaumicgadgets.init;

 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 import thaumcraft.api.aspects.Aspect;
 import thaumcraft.api.aspects.AspectList;
 import thaumcraft.api.aspects.AspectRegistryEvent;
 
 
 public class RegisterAspectsHandler
 {
   @SubscribeEvent
   public static void OnRegisterAspects(AspectRegistryEvent event) {
/* 17 */     event.register.registerObjectTag(new ItemStack(ModItems.TOOL_GEMCUTTER), (new AspectList()).add(Aspect.METAL, 3).add(Aspect.PLANT, 2));
     
/* 19 */     event.register.registerObjectTag(new ItemStack(ModItems.YARN), (new AspectList()).add(Aspect.CRAFT, 1));
/* 20 */     event.register.registerObjectTag(new ItemStack(ModItems.YARN_GOLD), (new AspectList()).add(Aspect.CRAFT, 1).add(Aspect.LIGHT, 1));
/* 21 */     event.register.registerObjectTag(new ItemStack(ModItems.YARN_THANIUM), (new AspectList()).add(Aspect.CRAFT, 1).add(Aspect.MAGIC, 1).add(Aspect.METAL, 1));

/* 25 */     event.register.registerObjectTag(new ItemStack(Item.getItemFromBlock(ModBlocks.SPINNING_WHEEL)), (new AspectList()).add(Aspect.AIR, 2).add(Aspect.PLANT, 3).add(Aspect.METAL, 3).add(Aspect.ORDER, 2));
     
/* 43 */     event.register.registerObjectTag(new ItemStack(Item.getItemFromBlock(ModBlocks.GEMCUTTER)), (new AspectList()).add(Aspect.PLANT, 2).add(Aspect.CRYSTAL, 2).add(Aspect.CRAFT, 2));
     
/* 45 */     event.register.registerObjectTag(new ItemStack(Item.getItemFromBlock(ModBlocks.EXTRUDER)), (new AspectList()).add(Aspect.WATER, 3).add(Aspect.PLANT, 2).add(Aspect.FIRE, 3).add(Aspect.METAL, 18).add(Aspect.MAGIC, 4).add(Aspect.EARTH, 4));
     
/* 47 */     event.register.registerObjectTag(new ItemStack(Item.getItemFromBlock(ModBlocks.AGEING_STONE)), (new AspectList()).add(Aspect.AIR, 3).add(Aspect.METAL, 6).add(Aspect.ORDER, 3).add(Aspect.ENTROPY, 3).add(Aspect.MAGIC, 3).add(Aspect.MAN, 4));
}
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\init\RegisterAspectsHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */