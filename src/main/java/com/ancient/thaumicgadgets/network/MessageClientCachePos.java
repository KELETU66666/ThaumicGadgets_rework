package com.ancient.thaumicgadgets.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageClientCachePos implements IMessage {
    private BlockPos cachePos;

    public MessageClientCachePos() {}

    public MessageClientCachePos(BlockPos cachePos) {
        this.cachePos = cachePos;
    }



    public void fromBytes(ByteBuf buf) {
        this.cachePos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
    }



    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.cachePos.getX());
        buf.writeInt(this.cachePos.getY());
        buf.writeInt(this.cachePos.getZ());
    }


    public static class handler implements IMessageHandler<MessageClientCachePos, IMessage>
    {
        public IMessage onMessage(final MessageClientCachePos message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(new Runnable()
            {

                public void run()
                {
                    Minecraft mc = Minecraft.getMinecraft();
                    WorldClient worldClient = mc.world;

                    if (worldClient == null) {
                        return;
                    }
                }
            });
            return null;
        }
    }
}