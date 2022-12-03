 package com.ancient.thaumicgadgets.network;
 
 import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruderUp;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.util.math.BlockPos;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
 
 
 
 
 public class MessageClientExtruderUp
   implements IMessage
 {
   private int mode;
   private int x;
   private int y;
   private int z;
   
   public MessageClientExtruderUp() {}
   
   public MessageClientExtruderUp(int mode, TileEntityExtruderUp te) {
/* 27 */     this.mode = mode;
/* 28 */     this.x = te.getPos().getX();
/* 29 */     this.y = te.getPos().getY();
/* 30 */     this.z = te.getPos().getZ();
   }
 
 
   
   public void fromBytes(ByteBuf buf) {
/* 36 */     this.mode = buf.readInt();
/* 37 */     this.x = buf.readInt();
/* 38 */     this.y = buf.readInt();
/* 39 */     this.z = buf.readInt();
   }
 
 
   
   public void toBytes(ByteBuf buf) {
/* 45 */     buf.writeInt(this.mode);
/* 46 */     buf.writeInt(this.x);
/* 47 */     buf.writeInt(this.y);
/* 48 */     buf.writeInt(this.z);
   }
 
 
   
   public static class handler
     implements IMessageHandler<MessageClientExtruderUp, IMessage>
   {
     public IMessage onMessage(final MessageClientExtruderUp message, MessageContext ctx) {
/* 57 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {
             
             public void run()
             {
/* 62 */               Minecraft mc = Minecraft.getMinecraft();
/* 63 */               WorldClient worldClient = mc.world;
               
/* 65 */               if (worldClient == null) {
                 return;
               }
 
               
/* 70 */               TileEntityExtruderUp tile = (TileEntityExtruderUp)worldClient.getTileEntity(new BlockPos(message.x, message.y, message.z));
               
/* 72 */               if (tile != null)
               {
/* 74 */                 tile.setField(2, message.mode);
               }
             }
           });
/* 78 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageClientExtruderUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */