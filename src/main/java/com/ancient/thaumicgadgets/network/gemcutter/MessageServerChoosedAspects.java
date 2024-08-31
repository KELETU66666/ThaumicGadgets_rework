package com.ancient.thaumicgadgets.network.gemcutter;

import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class MessageServerChoosedAspects implements IMessage {
    private int id;
    private int x;
    private int y;
    private int z;
    private AspectList aspects = new AspectList();


    public MessageServerChoosedAspects(TileEntityGemCutter ent, AspectList aspects) {
        this.id = (ent.getWorld()).provider.getDimension();
        this.x = ent.getPos().getX();
        this.y = ent.getPos().getY();
        this.z = ent.getPos().getZ();
        this.aspects = aspects;
    }


    public void fromBytes(ByteBuf buf) {
        this.id = buf.readInt();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        int q = buf.readInt();
        this.aspects.aspects.clear();
        for (int i = 0; i < q; i++) {
            this.aspects.add(Aspect.getAspect(ByteBufUtils.readUTF8String(buf)), buf.readInt());
        }
    }


    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.id);
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
        buf.writeInt(this.aspects.size());
        for (Aspect s : this.aspects.getAspects()) {

            ByteBufUtils.writeUTF8String(buf, s.getTag());
            buf.writeInt(this.aspects.getAmount(s));
        }
    }

    public MessageServerChoosedAspects() {
    }

    public static class handler
            implements IMessageHandler<MessageServerChoosedAspects, IMessage> {
        public IMessage onMessage(final MessageServerChoosedAspects message, MessageContext ctx) {
            EntityPlayerMP pl = (ctx.getServerHandler()).player;

            pl.getServerWorld().addScheduledTask(new Runnable() {

                public void run() {
                    WorldServer worldServer = DimensionManager.getWorld(message.id);
                    if (worldServer == null) {
                        return;
                    }


                    TileEntityGemCutter tile = (TileEntityGemCutter) worldServer.getTileEntity(new BlockPos(message.x, message.y, message.z));

                    if (tile != null) {
                        tile.setChoosedAspects(message.aspects);
                    }
                }
            });
            return null;
        }
    }
}