package com.ancient.thaumicgadgets.network.particles;

import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class MessageClientSpawnParticlesCustomLightning implements IMessage {
    private int type;
    private Vec3d start;
    private Vec3d finish;

    public MessageClientSpawnParticlesCustomLightning() {
    }

    public MessageClientSpawnParticlesCustomLightning(EnumHandler.CustomParticles type, Vec3d start, Vec3d finish) {
        this.type = type.getID();
        this.start = start;
        this.finish = finish;
    }


    public void fromBytes(ByteBuf buf) {
        this.type = buf.readInt();
        this.start = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
        this.finish = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
    }


    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.type);
        buf.writeDouble(this.start.x);
        buf.writeDouble(this.start.y);
        buf.writeDouble(this.start.z);
        buf.writeDouble(this.finish.x);
        buf.writeDouble(this.finish.x);
        buf.writeDouble(this.finish.x);
    }


    public static class handler
            implements IMessageHandler<MessageClientSpawnParticlesCustomLightning, IMessage> {
        public IMessage onMessage(final MessageClientSpawnParticlesCustomLightning message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {

                public void run() {
                    Minecraft mc = Minecraft.getMinecraft();
                    WorldClient worldClient = mc.world;

                    if (worldClient == null) {
                        return;
                    }


                    ParticleSpawner ps = ParticleSpawner.INSTANCE;

                    EnumHandler.CustomParticles[] CP = EnumHandler.CustomParticles.values();
                    ps.spawnParticles(CP[message.type], message.start, message.finish);
                }
            });
            return null;
        }
    }
}