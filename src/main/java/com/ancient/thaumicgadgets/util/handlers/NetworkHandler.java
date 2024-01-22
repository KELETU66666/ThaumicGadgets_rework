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
        INSTANCE = new SimpleNetworkWrapper("tg");
        int id = 0;

        INSTANCE.registerMessage(MessageGUIButton.handler.class, MessageGUIButton.class, id++, Side.SERVER);
        INSTANCE.registerMessage(MessageButtonCraft.handler.class, MessageButtonCraft.class, id++, Side.SERVER);
        INSTANCE.registerMessage(MessageChangeModeArmor.handler.class, MessageChangeModeArmor.class, id++, Side.SERVER);
        INSTANCE.registerMessage(MessageChangeModeWeapon.handler.class, MessageChangeModeWeapon.class, id++, Side.SERVER);
        INSTANCE.registerMessage(MessageArmorAbility.handler.class, MessageArmorAbility.class, id++, Side.SERVER);
        INSTANCE.registerMessage(MessageClientBeltAbilities.handler.class, MessageClientBeltAbilities.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(MessageClientExtruderUp.handler.class, MessageClientExtruderUp.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(MessageClientSpawnParticles.handler.class, MessageClientSpawnParticles.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(MessageClientSpawnParticlesCustom.handler.class, MessageClientSpawnParticlesCustom.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(MessageClientSpawnParticlesCustomLightning.handler.class, MessageClientSpawnParticlesCustomLightning.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(MessageClientCachePos.handler.class, MessageClientCachePos.class, id++, Side.CLIENT);
        INSTANCE.registerMessage(MessageServerChoosedAspects.handler.class, MessageServerChoosedAspects.class, id++, Side.SERVER);
        INSTANCE.registerMessage(MessageClientAllAspects.handler.class, MessageClientAllAspects.class, id++, Side.CLIENT);
    }


    public static void sendToServer(IMessage message) {
        INSTANCE.sendToServer(message);
    }


    public static void sendToClient(IMessage message, EntityPlayerMP player) {
        INSTANCE.sendTo(message, player);
    }


    public static void sendToClients(IMessage message) {
        INSTANCE.sendToAll(message);
    }


    public static void sendToAllNearby(IMessage message, NetworkRegistry.TargetPoint point) {
        INSTANCE.sendToAllAround(message, point);
    }
}