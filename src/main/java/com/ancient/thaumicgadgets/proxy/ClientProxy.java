 package com.ancient.thaumicgadgets.proxy;

 import com.ancient.thaumicgadgets.gui.GuiOverlay;
 import com.ancient.thaumicgadgets.keys.KeyInputHandler;
 import com.ancient.thaumicgadgets.keys.Keybindings;
 import com.ancient.thaumicgadgets.objects.machines.extruder.RenderExtruderUp;
 import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruderUp;
 import com.ancient.thaumicgadgets.objects.machines.lamp.RenderLamp;
 import com.ancient.thaumicgadgets.objects.machines.lamp.TileEntityLamp;
 import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
 import net.minecraft.item.Item;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.client.model.obj.OBJLoader;
 import net.minecraftforge.common.MinecraftForge;
 import net.minecraftforge.fml.client.registry.ClientRegistry;

 public class ClientProxy
   extends CommonProxy
 {



   public void registerItemRenderer(Item item, int meta, String id) {
/* 52 */     ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
   }


   public void init() {
/* 57 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityExtruderUp.class, (TileEntitySpecialRenderer)new RenderExtruderUp());
/* 63 */     ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLamp.class, (TileEntitySpecialRenderer)new RenderLamp());
/* 64 */    }




   public void preInit() {
       /* 72 */
       OBJLoader.INSTANCE.addDomain("tg");
       /* 73 */
       super.preInit();
       /* 74 */
       for (int i = 0; i < (EnumHandler.FocusTypes.values()).length; i++) {

           /* 76 */
           ModelResourceLocation itemModel = new ModelResourceLocation("tg:terra_focus_" + EnumHandler.FocusTypes.values()[i].getName() + ".obj");


       }
   }


   public void postInit() {
/* 88 */     MinecraftForge.EVENT_BUS.register(new GuiOverlay());
       registerKeyBinds();
   }


   private void registerKeyBinds() {
/* 93 */     MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
/* 94 */     for (Keybindings key : Keybindings.values())
     {
/* 96 */       ClientRegistry.registerKeyBinding(key.getKeyding());
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\proxy\ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */