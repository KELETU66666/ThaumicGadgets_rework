 package com.ancient.thaumicgadgets.network.particles;
 
 import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
 import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.util.math.Vec3d;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
 
 
 
 
 
 public class MessageClientSpawnParticlesCustomLightning
   implements IMessage
 {
   private int type;
   private Vec3d start;
   private Vec3d finish;
   
   public MessageClientSpawnParticlesCustomLightning() {}
   
   public MessageClientSpawnParticlesCustomLightning(EnumHandler.CustomParticles type, Vec3d start, Vec3d finish) {
/* 28 */     this.type = type.getID();
/* 29 */     this.start = start;
/* 30 */     this.finish = finish;
   }
 
 
   
   public void fromBytes(ByteBuf buf) {
/* 36 */     this.type = buf.readInt();
/* 37 */     this.start = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
/* 38 */     this.finish = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
   }
 
 
   
   public void toBytes(ByteBuf buf) {
/* 44 */     buf.writeInt(this.type);
/* 45 */     buf.writeDouble(this.start.x);
/* 46 */     buf.writeDouble(this.start.y);
/* 47 */     buf.writeDouble(this.start.z);
/* 48 */     buf.writeDouble(this.finish.x);
/* 49 */     buf.writeDouble(this.finish.x);
/* 50 */     buf.writeDouble(this.finish.x);
   }
 
 
   
   public static class handler
     implements IMessageHandler<MessageClientSpawnParticlesCustomLightning, IMessage>
   {
     public IMessage onMessage(final MessageClientSpawnParticlesCustomLightning message, MessageContext ctx) {
/* 59 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {
             
             public void run()
             {
/* 64 */               Minecraft mc = Minecraft.getMinecraft();
/* 65 */               WorldClient worldClient = mc.world;
               
/* 67 */               if (worldClient == null) {
                 return;
               }
 
               
/* 72 */               ParticleSpawner ps = ParticleSpawner.INSTANCE;
               
/* 74 */               EnumHandler.CustomParticles[] CP = EnumHandler.CustomParticles.values();
/* 75 */               ps.spawnParticles(CP[message.type], message.start, message.finish);
             }
           });
/* 78 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\particles\MessageClientSpawnParticlesCustomLightning.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */