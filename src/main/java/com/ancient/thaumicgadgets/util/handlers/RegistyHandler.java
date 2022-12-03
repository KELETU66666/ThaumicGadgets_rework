 package com.ancient.thaumicgadgets.util.handlers;

 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModBlocks;
 import com.ancient.thaumicgadgets.init.ModEnchantments;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.init.ModSounds;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.block.Block;
 import net.minecraft.enchantment.Enchantment;
 import net.minecraft.item.Item;
 import net.minecraft.util.SoundEvent;
 import net.minecraftforge.client.event.ModelRegistryEvent;
 import net.minecraftforge.event.RegistryEvent;
 import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 import net.minecraftforge.fml.common.network.NetworkRegistry;


 @EventBusSubscriber
 public class RegistyHandler
 {
   public static void preInitRegistries() {
/* 31 */     ModSounds.registerSounds();

/* 34 */     NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GUIHandler());
   }


   @SubscribeEvent
   public static void onItemRegister(RegistryEvent.Register<Item> event) {
/* 40 */     event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
   }


   @SubscribeEvent
   public static void onModelRegister(ModelRegistryEvent event) {
/* 46 */     for (Item item : ModItems.ITEMS) {

/* 48 */       if (item instanceof IHasModel)
       {
/* 50 */         ((IHasModel)item).registerModels();
       }
     }

/* 54 */     for (Block block : ModBlocks.BLOCKS) {

/* 56 */       if (block instanceof IHasModel)
       {
/* 58 */         ((IHasModel)block).registerModels();
       }
     }
   }




   @SubscribeEvent
   public static void onBlockRegister(RegistryEvent.Register<Block> event) {
/* 68 */     event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray((new Block[0])));
/* 69 */     TileEntityHandler.registerTileEntities();
   }


   @SubscribeEvent
   public static void onEnchantmentRegister(RegistryEvent.Register<Enchantment> event) {
/* 75 */     event.getRegistry().registerAll(ModEnchantments.ECHANTMENTS.toArray((new Enchantment[0])));
   }



   @SubscribeEvent
   public static void onSoundRegister(RegistryEvent.Register<SoundEvent> event) {
/* 82 */     event.getRegistry().registerAll(ModSounds.SOUNDS.toArray((new SoundEvent[0])));
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\RegistyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */