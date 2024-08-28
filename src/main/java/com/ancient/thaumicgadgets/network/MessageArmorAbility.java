package com.ancient.thaumicgadgets.network;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.ancient.thaumicgadgets.armor.light.LightBelt;
import com.ancient.thaumicgadgets.armor.shade.ShadeBelt;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class MessageArmorAbility implements IMessage {
    private int armorType;

    public MessageArmorAbility() {
    }

    public MessageArmorAbility(int armorType) {
        this.armorType = armorType;
    }

    public void fromBytes(ByteBuf buf) {
        this.armorType = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.armorType);
    }


    public static class handler implements IMessageHandler<MessageArmorAbility, IMessage> {
        public IMessage onMessage(final MessageArmorAbility message, MessageContext ctx) {
            final EntityPlayerMP pl = (ctx.getServerHandler()).player;

            pl.getServerWorld().addScheduledTask(new Runnable() {

                public void run() {
                    if (pl != null) {

                        if (message.armorType == 0) {

                            IBaublesItemHandler iBaublesItemHandler = BaublesApi.getBaublesHandler(pl);
                            ShadeBelt it = (ShadeBelt) iBaublesItemHandler.getStackInSlot(3).getItem();

                            it.ActivateTeleportation(pl);
                        }

                        if (message.armorType == 1) {

                            IBaublesItemHandler iBaublesItemHandler = BaublesApi.getBaublesHandler(pl);
                            LightBelt it = (LightBelt) iBaublesItemHandler.getStackInSlot(3).getItem();

                            it.EnableFly(pl);
                        }
                    }
                }
            });

            return null;
        }
    }
}