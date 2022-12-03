 package com.ancient.thaumicgadgets.network;

 import com.ancient.thaumicgadgets.tools.primal.ToolAxePrimal;
 import com.ancient.thaumicgadgets.tools.primal.ToolSwordPrimal;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.player.EntityPlayerMP;
 import net.minecraft.item.ItemStack;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;



 public class MessageChangeModeWeapon
   implements IMessage
 {
   private int itemSlot;

   public MessageChangeModeWeapon() {}

   public MessageChangeModeWeapon(int itemSlot) {
/* 23 */     this.itemSlot = itemSlot;
   }



   public void fromBytes(ByteBuf buf) {
/* 29 */     this.itemSlot = buf.readInt();
   }



   public void toBytes(ByteBuf buf) {
/* 35 */     buf.writeInt(this.itemSlot);
   }



   public static class handler
     implements IMessageHandler<MessageChangeModeWeapon, IMessage>
   {
     public IMessage onMessage(final MessageChangeModeWeapon message, MessageContext ctx) {
/* 44 */       final EntityPlayerMP pl = (ctx.getServerHandler()).player;

/* 46 */       pl.getServerWorld().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 51 */               ItemStack stack = pl.inventory.getStackInSlot(message.itemSlot);
/* 52 */               if (stack != null)
               {
/* 54 */                 if (stack.getItem() instanceof ToolAxePrimal) {

/* 56 */                   ToolAxePrimal r = (ToolAxePrimal)stack.getItem();
/* 57 */                   r.changeItemMode((EntityPlayer)pl, stack, message.itemSlot);
                 }
/* 59 */                 else if (stack.getItem() instanceof ToolSwordPrimal) {

/* 61 */                   ToolSwordPrimal r = (ToolSwordPrimal)stack.getItem();
/* 62 */                   r.changeItemMode((EntityPlayer)pl, stack, message.itemSlot);
                 }
               }
             }
           });
/* 67 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageChangeModeWeapon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */