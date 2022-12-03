 package com.ancient.thaumicgadgets.network;

 import net.minecraft.client.Minecraft;
 import net.minecraft.entity.player.EntityPlayerMP;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 import net.minecraftforge.fml.relauncher.Side;



 public abstract class MessageBase<REQ extends IMessage>
   implements IMessage, IMessageHandler<REQ, IMessage>
 {
   public IMessage onMessage(final REQ message, final MessageContext ctx) {
/* 16 */     if (ctx.side == Side.SERVER) {

/* 18 */       EntityPlayerMP pl = (ctx.getServerHandler()).player;

/* 20 */       pl.getServerWorld().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 25 */               MessageBase.this.handleServerSide(message, (ctx.getServerHandler()).player);
             }
           });
     }
     else {

/* 31 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 36 */               MessageBase.this.handleClientSide(message, null);
             }
           });
     }
/* 40 */     return null;
   }

   public abstract void handleClientSide(REQ paramREQ, EntityPlayerMP paramEntityPlayerMP);

   public abstract void handleServerSide(REQ paramREQ, EntityPlayerMP paramEntityPlayerMP);
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */