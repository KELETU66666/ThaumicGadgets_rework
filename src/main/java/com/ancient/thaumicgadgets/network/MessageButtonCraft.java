package com.ancient.thaumicgadgets.network;

import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class MessageButtonCraft
        implements IMessage {
    private int id;
    private int x;
    private int y;
    private int z;

    public MessageButtonCraft() {
    }

    public MessageButtonCraft(TileEntityGemCutter ent) {
        this.id = (ent.getWorld()).provider.getDimension();
        this.x = ent.getPos().getX();
        this.y = ent.getPos().getY();
        this.z = ent.getPos().getZ();
    }


    public void fromBytes(ByteBuf buf) {
        this.id = buf.readInt();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }


    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.id);
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
    }


    public static class handler
            implements IMessageHandler<MessageButtonCraft, IMessage> {
        public IMessage onMessage(final MessageButtonCraft message, MessageContext ctx) {
            EntityPlayerMP pl = (ctx.getServerHandler()).player;

            pl.getServerWorld().addScheduledTask(new Runnable() {

                public void run() {
                    WorldServer worldServer = DimensionManager.getWorld(message.id);
                    if (worldServer == null) {
                        return;
                    }


                    TileEntityGemCutter tile = (TileEntityGemCutter) worldServer.getTileEntity(new BlockPos(message.x, message.y, message.z));

                    if (tile != null) {
                        tile.craftItem();
                    }
                }
            });

            return null;
        }
    }
}