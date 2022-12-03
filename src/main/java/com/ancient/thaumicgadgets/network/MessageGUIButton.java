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




 public class MessageGUIButton
   implements IMessage
 {
   private int id;
   private int x;
   private int y;
   private int z;
   private int mode;

   public MessageGUIButton() {}

   public MessageGUIButton(TileEntityGemCutter ent, int mode) {
/* 28 */     this.id = (ent.getWorld()).provider.getDimension();
/* 29 */     this.x = ent.getPos().getX();
/* 30 */     this.y = ent.getPos().getY();
/* 31 */     this.z = ent.getPos().getZ();
/* 32 */     this.mode = mode;
   }



   public void fromBytes(ByteBuf buf) {
/* 38 */     this.id = buf.readInt();
/* 39 */     this.x = buf.readInt();
/* 40 */     this.y = buf.readInt();
/* 41 */     this.z = buf.readInt();
/* 42 */     this.mode = buf.readInt();
   }



   public void toBytes(ByteBuf buf) {
/* 48 */     buf.writeInt(this.id);
/* 49 */     buf.writeInt(this.x);
/* 50 */     buf.writeInt(this.y);
/* 51 */     buf.writeInt(this.z);
/* 52 */     buf.writeInt(this.mode);
   }


   public static class handler
     implements IMessageHandler<MessageGUIButton, IMessage>
   {
     public IMessage onMessage(final MessageGUIButton message, MessageContext ctx) {
/* 60 */       EntityPlayerMP pl = (ctx.getServerHandler()).player;

/* 62 */       pl.getServerWorld().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 67 */               WorldServer worldServer = DimensionManager.getWorld(message.id);
/* 68 */               if (worldServer == null) {
                 return;
               }


/* 73 */               TileEntityGemCutter tile = (TileEntityGemCutter)worldServer.getTileEntity(new BlockPos(message.x, message.y, message.z));

/* 75 */               if (tile != null)
               {
/* 77 */                 tile.setField(0, message.mode);
               }
             }
           });
/* 81 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageGUIButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */