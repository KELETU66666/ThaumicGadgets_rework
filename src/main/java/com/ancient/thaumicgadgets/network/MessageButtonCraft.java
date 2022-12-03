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





 public class MessageButtonCraft
   implements IMessage
 {
   private int id;
   private int x;
   private int y;
   private int z;

   public MessageButtonCraft() {}

   public MessageButtonCraft(TileEntityGemCutter ent) {
/* 28 */     this.id = (ent.getWorld()).provider.getDimension();
/* 29 */     this.x = ent.getPos().getX();
/* 30 */     this.y = ent.getPos().getY();
/* 31 */     this.z = ent.getPos().getZ();
   }



   public void fromBytes(ByteBuf buf) {
/* 37 */     this.id = buf.readInt();
/* 38 */     this.x = buf.readInt();
/* 39 */     this.y = buf.readInt();
/* 40 */     this.z = buf.readInt();
   }



   public void toBytes(ByteBuf buf) {
/* 46 */     buf.writeInt(this.id);
/* 47 */     buf.writeInt(this.x);
/* 48 */     buf.writeInt(this.y);
/* 49 */     buf.writeInt(this.z);
   }



   public static class handler
     implements IMessageHandler<MessageButtonCraft, IMessage>
   {
     public IMessage onMessage(final MessageButtonCraft message, MessageContext ctx) {
/* 58 */       EntityPlayerMP pl = (ctx.getServerHandler()).player;

/* 60 */       pl.getServerWorld().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 65 */               WorldServer worldServer = DimensionManager.getWorld(message.id);
/* 66 */               if (worldServer == null) {
                 return;
               }


/* 71 */               TileEntityGemCutter tile = (TileEntityGemCutter)worldServer.getTileEntity(new BlockPos(message.x, message.y, message.z));

/* 73 */               if (tile != null)
               {
/* 75 */                 tile.craftItem();
               }
             }
           });

/* 80 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageButtonCraft.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */