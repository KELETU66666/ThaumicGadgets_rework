 package com.ancient.thaumicgadgets.network.particles;

 import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.util.EnumParticleTypes;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;











 public class MessageClientSpawnParticles
   implements IMessage
 {
   private EnumParticleTypes type;
   private double x;
   private double y;
   private double z;
   private int count;
   private double velX;
   private double velY;
   private double velZ;

   public MessageClientSpawnParticles() {}

   public MessageClientSpawnParticles(EnumParticleTypes type, double x, double y, double z, int count, double velX, double velY, double velZ) {
/* 37 */     this.type = type;
/* 38 */     this.x = x;
/* 39 */     this.y = y;
/* 40 */     this.z = z;
/* 41 */     this.count = count;
/* 42 */     this.velX = velX;
/* 43 */     this.velY = velY;
/* 44 */     this.velZ = velZ;
   }



   public void fromBytes(ByteBuf buf) {
/* 50 */     this.type = EnumParticleTypes.getParticleFromId(buf.readInt());
/* 51 */     this.x = buf.readDouble();
/* 52 */     this.y = buf.readDouble();
/* 53 */     this.z = buf.readDouble();
/* 54 */     this.count = buf.readInt();
/* 55 */     this.velX = buf.readDouble();
/* 56 */     this.velY = buf.readDouble();
/* 57 */     this.velZ = buf.readDouble();
   }



   public void toBytes(ByteBuf buf) {
/* 63 */     buf.writeInt(this.type.getParticleID());
/* 64 */     buf.writeDouble(this.x);
/* 65 */     buf.writeDouble(this.y);
/* 66 */     buf.writeDouble(this.z);
/* 67 */     buf.writeInt(this.count);
/* 68 */     buf.writeDouble(this.velX);
/* 69 */     buf.writeDouble(this.velY);
/* 70 */     buf.writeDouble(this.velZ);
   }



   public static class handler
     implements IMessageHandler<MessageClientSpawnParticles, IMessage>
   {
     public IMessage onMessage(final MessageClientSpawnParticles message, MessageContext ctx) {
/* 79 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 84 */               Minecraft mc = Minecraft.getMinecraft();
/* 85 */               WorldClient worldClient = mc.world;

/* 87 */               if (worldClient == null) {
                 return;
               }


/* 92 */               ParticleSpawner ps = ParticleSpawner.INSTANCE;

/* 94 */               ps.spawnParticles(message.type, message.count, message.x, message.y, message.z, message.velX, message.velY, message.velZ);
             }
           });
/* 97 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\particles\MessageClientSpawnParticles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */