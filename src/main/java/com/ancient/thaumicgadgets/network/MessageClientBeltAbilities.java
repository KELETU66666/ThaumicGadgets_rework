 package com.ancient.thaumicgadgets.network;
 
 import baubles.api.BaublesApi;
 import com.ancient.thaumicgadgets.armour.light.LightBelt;
 import com.ancient.thaumicgadgets.armour.shade.ShadeBelt;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
 
 
 
 
 public class MessageClientBeltAbilities
   implements IMessage
 {
   private Long lastUse;
   private int cd;
   
   public MessageClientBeltAbilities() {}
   
   public MessageClientBeltAbilities(long lastUse, int cd) {
/* 28 */     this.lastUse = Long.valueOf(lastUse);
/* 29 */     this.cd = cd;
   }
 
 
   
   public void fromBytes(ByteBuf buf) {
/* 35 */     this.lastUse = Long.valueOf(buf.readLong());
/* 36 */     this.cd = buf.readInt();
   }
 
 
   
   public void toBytes(ByteBuf buf) {
/* 42 */     buf.writeLong(this.lastUse.longValue());
/* 43 */     buf.writeInt(this.cd);
   }
 
 
   
   public static class handler
     implements IMessageHandler<MessageClientBeltAbilities, IMessage>
   {
     public IMessage onMessage(final MessageClientBeltAbilities message, MessageContext ctx) {
/* 52 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {
             
             public void run()
             {
/* 57 */               Minecraft mc = Minecraft.getMinecraft();
/* 58 */               WorldClient worldClient = mc.world;
               
/* 60 */               if (worldClient == null) {
                 return;
               }
 
               
/* 65 */               ItemStack belt = BaublesApi.getBaublesHandler((EntityPlayer)mc.player).getStackInSlot(3);
/* 66 */               if (belt.getItem() instanceof LightBelt) {
                 
/* 68 */                 LightBelt item = (LightBelt)belt.getItem();
/* 69 */                 item.lastUse = message.lastUse.longValue();
               }
/* 71 */               else if (belt.getItem() instanceof ShadeBelt) {
                 
/* 73 */                 ShadeBelt item = (ShadeBelt)belt.getItem();
/* 74 */                 item.lastUse = message.lastUse.longValue();
               } else {
                 return;
               } 
             }
           });
/* 80 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageClientBeltAbilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */