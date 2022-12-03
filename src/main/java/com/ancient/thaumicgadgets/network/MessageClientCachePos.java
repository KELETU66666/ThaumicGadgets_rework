 package com.ancient.thaumicgadgets.network;

 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.util.math.BlockPos;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;






 public class MessageClientCachePos
   implements IMessage
 {
   private BlockPos cachePos;

   public MessageClientCachePos() {}

   public MessageClientCachePos(BlockPos cachePos) {
/* 28 */     this.cachePos = cachePos;
   }



   public void fromBytes(ByteBuf buf) {
/* 34 */     this.cachePos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
   }



   public void toBytes(ByteBuf buf) {
/* 40 */     buf.writeInt(this.cachePos.getX());
/* 41 */     buf.writeInt(this.cachePos.getY());
/* 42 */     buf.writeInt(this.cachePos.getZ());
   }


   public static class handler
     implements IMessageHandler<MessageClientCachePos, IMessage>
   {
     public IMessage onMessage(final MessageClientCachePos message, MessageContext ctx) {
/* 50 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 55 */               Minecraft mc = Minecraft.getMinecraft();
/* 56 */               WorldClient worldClient = mc.world;

/* 58 */               if (worldClient == null) {
                 return;
               }
             }
           });
/* 74 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageClientCachePos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */