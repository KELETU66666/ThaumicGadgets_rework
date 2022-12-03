 package com.ancient.thaumicgadgets.network.gemcutter;

 import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.util.math.BlockPos;
 import net.minecraftforge.fml.common.network.ByteBufUtils;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 import thaumcraft.api.aspects.Aspect;
 import thaumcraft.api.aspects.AspectList;

 public class MessageClientAllAspects
   implements IMessage
 {
   private int x;
   private int y;
   private int z;
/* 21 */   private AspectList aspects = new AspectList();







   public MessageClientAllAspects(AspectList aspects, TileEntityGemCutter te) {
/* 30 */     this.x = te.getPos().getX();
/* 31 */     this.y = te.getPos().getY();
/* 32 */     this.z = te.getPos().getZ();
/* 33 */     this.aspects = aspects;
   }



   public void fromBytes(ByteBuf buf) {
/* 39 */     this.x = buf.readInt();
/* 40 */     this.y = buf.readInt();
/* 41 */     this.z = buf.readInt();
/* 42 */     int i = buf.readInt();
/* 43 */     this.aspects.aspects.clear();
/* 44 */     for (int q = 0; q < i; q++)
     {
/* 46 */       this.aspects.add(Aspect.getAspect(ByteBufUtils.readUTF8String(buf)), buf.readInt());
     }
   }



   public void toBytes(ByteBuf buf) {
/* 53 */     buf.writeInt(this.x);
/* 54 */     buf.writeInt(this.y);
/* 55 */     buf.writeInt(this.z);
/* 56 */     buf.writeInt(this.aspects.size());
/* 57 */     for (Aspect as : this.aspects.getAspects()) {

/* 59 */       ByteBufUtils.writeUTF8String(buf, as.getTag());
/* 60 */       buf.writeInt(this.aspects.getAmount(as));
     }
   }

   public MessageClientAllAspects() {}

   public static class handler
     implements IMessageHandler<MessageClientAllAspects, IMessage>
   {
     public IMessage onMessage(final MessageClientAllAspects message, MessageContext ctx) {
/* 70 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 75 */               Minecraft mc = Minecraft.getMinecraft();
/* 76 */               WorldClient worldClient = mc.world;

/* 78 */               if (worldClient == null) {
                 return;
               }


/* 83 */               TileEntityGemCutter tile = (TileEntityGemCutter)worldClient.getTileEntity(new BlockPos(message.x, message.y, message.z));

/* 85 */               if (tile != null)
               {
/* 87 */                 tile.setAspectList(message.aspects);
               }
             }
           });
/* 91 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\gemcutter\MessageClientAllAspects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */