package com.ancient.thaumicgadgets.network;

import com.ancient.thaumicgadgets.tools.primal.ToolAxePrimal;
import com.ancient.thaumicgadgets.tools.primal.ToolSwordPrimal;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


public class MessageChangeModeWeapon
        implements IMessage {
    private int itemSlot;

    public MessageChangeModeWeapon() {
    }

    public MessageChangeModeWeapon(int itemSlot) {
        this.itemSlot = itemSlot;
    }


    public void fromBytes(ByteBuf buf) {
        this.itemSlot = buf.readInt();
    }


    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.itemSlot);
    }


    public static class handler
            implements IMessageHandler<MessageChangeModeWeapon, IMessage> {
        public IMessage onMessage(final MessageChangeModeWeapon message, MessageContext ctx) {
            final EntityPlayerMP pl = (ctx.getServerHandler()).player;

            pl.getServerWorld().addScheduledTask(new Runnable() {

                public void run() {
                    ItemStack stack = pl.inventory.getStackInSlot(message.itemSlot);
                    if (stack != null) {
                        if (stack.getItem() instanceof ToolAxePrimal) {

                            ToolAxePrimal r = (ToolAxePrimal) stack.getItem();
                            r.changeItemMode((EntityPlayer) pl, stack, message.itemSlot);
                        } else if (stack.getItem() instanceof ToolSwordPrimal) {

                            ToolSwordPrimal r = (ToolSwordPrimal) stack.getItem();
                            r.changeItemMode((EntityPlayer) pl, stack, message.itemSlot);
                        }
                    }
                }
            });
            return null;
        }
    }
}