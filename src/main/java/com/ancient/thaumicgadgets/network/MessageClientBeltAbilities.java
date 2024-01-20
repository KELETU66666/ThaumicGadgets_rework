package com.ancient.thaumicgadgets.network;

import baubles.api.BaublesApi;
import com.ancient.thaumicgadgets.armor.light.LightBelt;
import com.ancient.thaumicgadgets.armor.shade.ShadeBelt;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;





public class MessageClientBeltAbilities implements IMessage {
    private Long lastUse;
    private int cd;

    public MessageClientBeltAbilities() {}

    public MessageClientBeltAbilities(long lastUse, int cd) {
        this.lastUse = lastUse;
        this.cd = cd;
    }



    public void fromBytes(ByteBuf buf) {
        this.lastUse = buf.readLong();
        this.cd = buf.readInt();
    }



    public void toBytes(ByteBuf buf) {
        buf.writeLong(this.lastUse);
        buf.writeInt(this.cd);
    }



    public static class handler
            implements IMessageHandler<MessageClientBeltAbilities, IMessage>
    {
        public IMessage onMessage(final MessageClientBeltAbilities message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                Minecraft mc = Minecraft.getMinecraft();
                WorldClient worldClient = mc.world;

                if (worldClient == null) {
                    return;
                }

                ItemStack belt = BaublesApi.getBaublesHandler(mc.player).getStackInSlot(3);
                if (belt.getItem() instanceof LightBelt) {

                    LightBelt item = (LightBelt)belt.getItem();
                    item.lastUse = message.lastUse;
                }
                else if (belt.getItem() instanceof ShadeBelt) {

                    ShadeBelt item = (ShadeBelt)belt.getItem();
                    item.lastUse = message.lastUse;
                }
            });
            return null;
        }
    }
}