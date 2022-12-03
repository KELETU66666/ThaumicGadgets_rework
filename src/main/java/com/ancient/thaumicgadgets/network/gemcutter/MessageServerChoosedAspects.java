 package com.ancient.thaumicgadgets.network.gemcutter;
 
 import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.entity.player.EntityPlayerMP;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.WorldServer;
 import net.minecraftforge.common.DimensionManager;
 import net.minecraftforge.fml.common.network.ByteBufUtils;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 import thaumcraft.api.aspects.Aspect;
 import thaumcraft.api.aspects.AspectList;
 
 public class MessageServerChoosedAspects
   implements IMessage
 {
   private int id;
   private int x;
   private int y;
   private int z;
/* 23 */   private AspectList aspects = new AspectList();
 
 
 
 
 
   
   public MessageServerChoosedAspects(TileEntityGemCutter ent, AspectList aspects) {
/* 31 */     this.id = (ent.getWorld()).provider.getDimension();
/* 32 */     this.x = ent.getPos().getX();
/* 33 */     this.y = ent.getPos().getY();
/* 34 */     this.z = ent.getPos().getZ();
/* 35 */     this.aspects = aspects;
   }
 
 
   
   public void fromBytes(ByteBuf buf) {
/* 41 */     this.id = buf.readInt();
/* 42 */     this.x = buf.readInt();
/* 43 */     this.y = buf.readInt();
/* 44 */     this.z = buf.readInt();
/* 45 */     int q = buf.readInt();
/* 46 */     this.aspects.aspects.clear();
/* 47 */     for (int i = 0; i < q; i++)
     {
/* 49 */       this.aspects.add(Aspect.getAspect(ByteBufUtils.readUTF8String(buf)), buf.readInt());
     }
   }
 
 
   
   public void toBytes(ByteBuf buf) {
/* 56 */     buf.writeInt(this.id);
/* 57 */     buf.writeInt(this.x);
/* 58 */     buf.writeInt(this.y);
/* 59 */     buf.writeInt(this.z);
/* 60 */     buf.writeInt(this.aspects.size());
/* 61 */     for (Aspect s : this.aspects.getAspects()) {
       
/* 63 */       ByteBufUtils.writeUTF8String(buf, s.getTag());
/* 64 */       buf.writeInt(this.aspects.getAmount(s));
     } 
   }
   
   public MessageServerChoosedAspects() {}
   
   public static class handler
     implements IMessageHandler<MessageServerChoosedAspects, IMessage> {
     public IMessage onMessage(final MessageServerChoosedAspects message, MessageContext ctx) {
/* 73 */       EntityPlayerMP pl = (ctx.getServerHandler()).player;
       
/* 75 */       pl.getServerWorld().addScheduledTask(new Runnable()
           {
             
             public void run()
             {
/* 80 */               WorldServer worldServer = DimensionManager.getWorld(message.id);
/* 81 */               if (worldServer == null) {
                 return;
               }
 
               
/* 86 */               TileEntityGemCutter tile = (TileEntityGemCutter)worldServer.getTileEntity(new BlockPos(message.x, message.y, message.z));
               
/* 88 */               if (tile != null)
               {
/* 90 */                 tile.setChoosedAspects(message.aspects);
               }
             }
           });
/* 94 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\gemcutter\MessageServerChoosedAspects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */