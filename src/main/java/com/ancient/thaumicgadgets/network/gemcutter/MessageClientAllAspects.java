package com.ancient.thaumicgadgets.network.gemcutter;

import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class MessageClientAllAspects implements IMessage {
    private int x;
    private int y;
    private int z;
    private AspectList aspects = new AspectList();


    public MessageClientAllAspects(AspectList aspects, TileEntityGemCutter te) {
        this.x = te.getPos().getX();
        this.y = te.getPos().getY();
        this.z = te.getPos().getZ();
        this.aspects = aspects;
    }


    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        int i = buf.readInt();
        this.aspects.aspects.clear();
        for (int q = 0; q < i; q++) {
            this.aspects.add(Aspect.getAspect(ByteBufUtils.readUTF8String(buf)), buf.readInt());
        }
    }


    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
        buf.writeInt(this.aspects.size());
        for (Aspect as : this.aspects.getAspects()) {

            ByteBufUtils.writeUTF8String(buf, as.getTag());
            buf.writeInt(this.aspects.getAmount(as));
        }
    }

    public MessageClientAllAspects() {
    }

    public static class handler
            implements IMessageHandler<MessageClientAllAspects, IMessage> {
        public IMessage onMessage(final MessageClientAllAspects message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {

                public void run() {
                    Minecraft mc = Minecraft.getMinecraft();
                    WorldClient worldClient = mc.world;

                    if (worldClient == null) {
                        return;
                    }


                    TileEntityGemCutter tile = (TileEntityGemCutter) worldClient.getTileEntity(new BlockPos(message.x, message.y, message.z));

                    if (tile != null) {
                        tile.setAspectList(message.aspects);
                    }
                }
            });
            return null;
        }
    }
}