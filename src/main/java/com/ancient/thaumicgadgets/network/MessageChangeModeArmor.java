 package com.ancient.thaumicgadgets.network;
 
 import com.ancient.thaumicgadgets.armor.primal.ArmorPrimal;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.player.EntityPlayerMP;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
 
 
 public class MessageChangeModeArmor
   implements IMessage
 {
   private int itemSlot;
   
   public MessageChangeModeArmor() {}
   
   public MessageChangeModeArmor(int itemSlot) {
/* 22 */     this.itemSlot = itemSlot;
   }
 
 
   
   public void fromBytes(ByteBuf buf) {
/* 28 */     this.itemSlot = buf.readInt();
   }
 
 
   
   public void toBytes(ByteBuf buf) {
/* 34 */     buf.writeInt(this.itemSlot);
   }
 
   
   public static class handler
     implements IMessageHandler<MessageChangeModeArmor, IMessage>
   {
     public IMessage onMessage(final MessageChangeModeArmor message, MessageContext ctx) {
/* 42 */       final EntityPlayerMP pl = (ctx.getServerHandler()).player;
       
/* 44 */       pl.getServerWorld().addScheduledTask(new Runnable()
           {
             
             public void run()
             {
/* 49 */               if (pl.inventory.armorInventory.get(message.itemSlot) != null) {
                 
/* 51 */                 ArmorPrimal r = (ArmorPrimal)((ItemStack)pl.inventory.armorInventory.get(message.itemSlot)).getItem();
/* 52 */                 r.changeItemMode((EntityPlayer)pl, (ItemStack)pl.inventory.armorInventory.get(message.itemSlot), message.itemSlot);
               } 
             }
           });
/* 56 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageChangeModeArmor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */