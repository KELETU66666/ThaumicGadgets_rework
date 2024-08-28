 package com.ancient.thaumicgadgets.network.particles;

 import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
 import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
 
 
 
 
 
 public class MessageClientSpawnParticlesCustom
   implements IMessage
 {
   private int type;
   private double x;
   private double y;
   private double z;
   private int count;
   private double velX;
   private double velY;
   private double velZ;
   
   public MessageClientSpawnParticlesCustom() {}
   
   public MessageClientSpawnParticlesCustom(EnumHandler.CustomParticles type, double x, double y, double z, int count, double velX, double velY, double velZ) {
/* 32 */     this.type = type.getID();
/* 33 */     this.x = x;
/* 34 */     this.y = y;
/* 35 */     this.z = z;
/* 36 */     this.count = count;
/* 37 */     this.velX = velX;
/* 38 */     this.velY = velY;
/* 39 */     this.velZ = velZ;
   }
 
 
   
   public void fromBytes(ByteBuf buf) {
/* 45 */     this.type = buf.readInt();
/* 46 */     this.x = buf.readDouble();
/* 47 */     this.y = buf.readDouble();
/* 48 */     this.z = buf.readDouble();
/* 49 */     this.count = buf.readInt();
/* 50 */     this.velX = buf.readDouble();
/* 51 */     this.velY = buf.readDouble();
/* 52 */     this.velZ = buf.readDouble();
   }
 
 
   
   public void toBytes(ByteBuf buf) {
/* 58 */     buf.writeInt(this.type);
/* 59 */     buf.writeDouble(this.x);
/* 60 */     buf.writeDouble(this.y);
/* 61 */     buf.writeDouble(this.z);
/* 62 */     buf.writeInt(this.count);
/* 63 */     buf.writeDouble(this.velX);
/* 64 */     buf.writeDouble(this.velY);
/* 65 */     buf.writeDouble(this.velZ);
   }
 
 
   
   public static class handler
     implements IMessageHandler<MessageClientSpawnParticlesCustom, IMessage>
   {
     public IMessage onMessage(final MessageClientSpawnParticlesCustom message, MessageContext ctx) {
/* 74 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {
             
             public void run()
             {
/* 79 */               Minecraft mc = Minecraft.getMinecraft();
/* 80 */               WorldClient worldClient = mc.world;
               
/* 82 */               if (worldClient == null) {
                 return;
               }
 
               
/* 87 */               ParticleSpawner ps = ParticleSpawner.INSTANCE;
               
/* 89 */               EnumHandler.CustomParticles[] CP = EnumHandler.CustomParticles.values();
/* 90 */               ps.spawnParticles(CP[message.type], message.count, message.x, message.y, message.z, message.velX, message.velY, message.velZ);
             }
           });
/* 93 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\particles\MessageClientSpawnParticlesCustom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */