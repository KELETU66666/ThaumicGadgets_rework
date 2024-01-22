package com.ancient.thaumicgadgets.network;

import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruderUp;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;





public class MessageClientExtruderUp implements IMessage {
  private int mode;
  private int x;
  private int y;
  private int z;
   
   public MessageClientExtruderUp() {}
   
   public MessageClientExtruderUp(int mode, TileEntityExtruderUp te) {
       this.mode = mode;
       this.x = te.getPos().getX();
       this.y = te.getPos().getY();
       this.z = te.getPos().getZ();
   }
 
 
   
   public void fromBytes(ByteBuf buf) {
       this.mode = buf.readInt();
       this.x = buf.readInt();
       this.y = buf.readInt();
       this.z = buf.readInt();
   }
 
 
   
   public void toBytes(ByteBuf buf) {
       buf.writeInt(this.mode);
       buf.writeInt(this.x);
       buf.writeInt(this.y);
       buf.writeInt(this.z);
   }
 
 
   
   public static class handler implements IMessageHandler<MessageClientExtruderUp, IMessage> {
     public IMessage onMessage(final MessageClientExtruderUp message, MessageContext ctx) {
         Minecraft.getMinecraft().addScheduledTask(new Runnable() {
             public void run()
             {
                 Minecraft mc = Minecraft.getMinecraft();
                 WorldClient worldClient = mc.world;

                 if (worldClient == null) {
                     return;
                 }

                 TileEntityExtruderUp tile = (TileEntityExtruderUp)worldClient.getTileEntity(new BlockPos(message.x, message.y, message.z));
                 if (tile != null)
                 {
                     tile.setField(2, message.mode);
                 }
             }
         });
         return null;
     }
   }
}