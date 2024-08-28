package com.ancient.thaumicgadgets.network;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;


public abstract class MessageBase<REQ extends IMessage>
        implements IMessage, IMessageHandler<REQ, IMessage> {
    public IMessage onMessage(final REQ message, final MessageContext ctx) {
        if (ctx.side == Side.SERVER) {

            EntityPlayerMP pl = (ctx.getServerHandler()).player;

            pl.getServerWorld().addScheduledTask(new Runnable() {

                public void run() {
                    MessageBase.this.handleServerSide(message, (ctx.getServerHandler()).player);
                }
            });
        } else {

            Minecraft.getMinecraft().addScheduledTask(new Runnable() {

                public void run() {
                    MessageBase.this.handleClientSide(message, null);
                }
            });
        }
        return null;
    }

    public abstract void handleClientSide(REQ paramREQ, EntityPlayerMP paramEntityPlayerMP);

    public abstract void handleServerSide(REQ paramREQ, EntityPlayerMP paramEntityPlayerMP);
}
