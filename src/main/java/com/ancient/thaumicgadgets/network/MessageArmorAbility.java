 package com.ancient.thaumicgadgets.network;
 
 import baubles.api.BaublesApi;
 import baubles.api.cap.IBaublesItemHandler;
 import com.ancient.thaumicgadgets.armour.light.LightBelt;
 import com.ancient.thaumicgadgets.armour.shade.ShadeBelt;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.player.EntityPlayerMP;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
 
 
 
 public class MessageArmorAbility
   implements IMessage
 {
   private int armorType;
   
   public MessageArmorAbility() {}
   
   public MessageArmorAbility(int armorType) {
/* 25 */     this.armorType = armorType;
   }
 
 
   
   public void fromBytes(ByteBuf buf) {
/* 31 */     this.armorType = buf.readInt();
   }
 
 
   
   public void toBytes(ByteBuf buf) {
/* 37 */     buf.writeInt(this.armorType);
   }
 
   
   public static class handler
     implements IMessageHandler<MessageArmorAbility, IMessage>
   {
     public IMessage onMessage(final MessageArmorAbility message, MessageContext ctx) {
/* 45 */       final EntityPlayerMP pl = (ctx.getServerHandler()).player;
       
/* 47 */       pl.getServerWorld().addScheduledTask(new Runnable()
           {
             
             public void run()
             {
/* 52 */               if (pl != null) {
                 
/* 54 */                 if (message.armorType == 0) {
                   
/* 56 */                   IBaublesItemHandler iBaublesItemHandler = BaublesApi.getBaublesHandler((EntityPlayer)pl);
/* 57 */                   ShadeBelt it = (ShadeBelt)iBaublesItemHandler.getStackInSlot(3).getItem();
                   
/* 59 */                   it.ActivateTeleportation((EntityPlayer)pl);
                 } 
                 
/* 62 */                 if (message.armorType == 1) {
                   
/* 64 */                   IBaublesItemHandler iBaublesItemHandler = BaublesApi.getBaublesHandler((EntityPlayer)pl);
/* 65 */                   LightBelt it = (LightBelt)iBaublesItemHandler.getStackInSlot(3).getItem();
                   
/* 67 */                   it.EnableFly((EntityPlayer)pl);
                 } 
               } 
             }
           });
       
/* 73 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageArmorAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */