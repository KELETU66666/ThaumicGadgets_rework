package com.ancient.thaumicgadgets.network;

import com.ancient.thaumicgadgets.armor.primal.ArmorPrimal;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class MessageChangeModeArmor implements IMessage {
    private int itemSlot;

    public MessageChangeModeArmor() {
    }

    public MessageChangeModeArmor(int itemSlot) {
        this.itemSlot = itemSlot;
    }


    public void fromBytes(ByteBuf buf) {
        this.itemSlot = buf.readInt();
    }


    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.itemSlot);
    }


    public static class handler
            implements IMessageHandler<MessageChangeModeArmor, IMessage> {
        public IMessage onMessage(final MessageChangeModeArmor message, MessageContext ctx) {
            final EntityPlayerMP pl = (ctx.getServerHandler()).player;

            pl.getServerWorld().addScheduledTask(new Runnable() {

                public void run() {
                    if (pl.inventory.armorInventory.get(message.itemSlot) != null) {

                        ArmorPrimal r = (ArmorPrimal) pl.inventory.armorInventory.get(message.itemSlot).getItem();
                        r.changeItemMode(pl, pl.inventory.armorInventory.get(message.itemSlot), message.itemSlot);
                    }
                }
            });
            return null;
        }
    }
}