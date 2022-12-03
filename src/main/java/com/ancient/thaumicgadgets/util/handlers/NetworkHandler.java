 package com.ancient.thaumicgadgets.util.handlers;

 import com.ancient.thaumicgadgets.network.*;
 import com.ancient.thaumicgadgets.network.gemcutter.MessageClientAllAspects;
 import com.ancient.thaumicgadgets.network.gemcutter.MessageServerChoosedAspects;
 import com.ancient.thaumicgadgets.network.particles.MessageClientSpawnParticles;
 import com.ancient.thaumicgadgets.network.particles.MessageClientSpawnParticlesCustom;
 import com.ancient.thaumicgadgets.network.particles.MessageClientSpawnParticlesCustomLightning;
 import net.minecraft.entity.player.EntityPlayerMP;
 import net.minecraftforge.fml.common.network.NetworkRegistry;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
 import net.minecraftforge.fml.relauncher.Side;




 public class NetworkHandler
 {
   public static SimpleNetworkWrapper INSTANCE;

   public static void init() {
/* 40 */     INSTANCE = new SimpleNetworkWrapper("tg");
/* 41 */     int id = 0;

/* 43 */     INSTANCE.registerMessage(MessageGUIButton.handler.class, MessageGUIButton.class, id++, Side.SERVER);
/* 44 */     INSTANCE.registerMessage(MessageButtonCraft.handler.class, MessageButtonCraft.class, id++, Side.SERVER);
/* 45 */     INSTANCE.registerMessage(MessageChangeModeArmor.handler.class, MessageChangeModeArmor.class, id++, Side.SERVER);
/* 46 */     INSTANCE.registerMessage(MessageChangeModeWeapon.handler.class, MessageChangeModeWeapon.class, id++, Side.SERVER);
/* 47 */     INSTANCE.registerMessage(MessageArmorAbility.handler.class, MessageArmorAbility.class, id++, Side.SERVER);
/* 48 */     INSTANCE.registerMessage(MessageClientBeltAbilities.handler.class, MessageClientBeltAbilities.class, id++, Side.CLIENT);
/* 51 */     INSTANCE.registerMessage(MessageClientExtruderUp.handler.class, MessageClientExtruderUp.class, id++, Side.CLIENT);
/* 54 */     INSTANCE.registerMessage(MessageClientSpawnParticles.handler.class, MessageClientSpawnParticles.class, id++, Side.CLIENT);
/* 59 */     INSTANCE.registerMessage(MessageClientSpawnParticlesCustom.handler.class, MessageClientSpawnParticlesCustom.class, id++, Side.CLIENT);
/* 60 */     INSTANCE.registerMessage(MessageClientSpawnParticlesCustomLightning.handler.class, MessageClientSpawnParticlesCustomLightning.class, id++, Side.CLIENT);
/* 61 */     INSTANCE.registerMessage(MessageClientCachePos.handler.class, MessageClientCachePos.class, id++, Side.CLIENT);
/* 62 */     INSTANCE.registerMessage(MessageServerChoosedAspects.handler.class, MessageServerChoosedAspects.class, id++, Side.SERVER);
/* 65 */     INSTANCE.registerMessage(MessageClientAllAspects.handler.class, MessageClientAllAspects.class, id++, Side.CLIENT);
   }


   public static void sendToServer(IMessage message) {
/* 70 */     INSTANCE.sendToServer(message);
   }


   public static void sendToClient(IMessage message, EntityPlayerMP player) {
/* 75 */     INSTANCE.sendTo(message, player);
   }


   public static void sendToClients(IMessage message) {
/* 80 */     INSTANCE.sendToAll(message);
   }


   public static void sendToAllNearby(IMessage message, NetworkRegistry.TargetPoint point) {
/* 85 */     INSTANCE.sendToAllAround(message, point);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\NetworkHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */