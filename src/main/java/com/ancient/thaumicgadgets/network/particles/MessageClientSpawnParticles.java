package com.ancient.thaumicgadgets.network.particles;

import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class MessageClientSpawnParticles implements IMessage {
    private EnumParticleTypes type;
    private double x;
    private double y;
    private double z;
    private int count;
    private double velX;
    private double velY;
    private double velZ;

    public MessageClientSpawnParticles() {
    }

    public MessageClientSpawnParticles(EnumParticleTypes type, double x, double y, double z, int count, double velX, double velY, double velZ) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
        this.velX = velX;
        this.velY = velY;
        this.velZ = velZ;
    }


    public void fromBytes(ByteBuf buf) {
        this.type = EnumParticleTypes.getParticleFromId(buf.readInt());
        this.x = buf.readDouble();
        this.y = buf.readDouble();
        this.z = buf.readDouble();
        this.count = buf.readInt();
        this.velX = buf.readDouble();
        this.velY = buf.readDouble();
        this.velZ = buf.readDouble();
    }


    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.type.getParticleID());
        buf.writeDouble(this.x);
        buf.writeDouble(this.y);
        buf.writeDouble(this.z);
        buf.writeInt(this.count);
        buf.writeDouble(this.velX);
        buf.writeDouble(this.velY);
        buf.writeDouble(this.velZ);
    }


    public static class handler
            implements IMessageHandler<MessageClientSpawnParticles, IMessage> {
        public IMessage onMessage(final MessageClientSpawnParticles message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {

                public void run() {
                    Minecraft mc = Minecraft.getMinecraft();
                    WorldClient worldClient = mc.world;

                    if (worldClient == null) {
                        return;
                    }


                    ParticleSpawner ps = ParticleSpawner.INSTANCE;

                    ps.spawnParticles(message.type, message.count, message.x, message.y, message.z, message.velX, message.velY, message.velZ);
                }
            });
            return null;
        }
    }
}