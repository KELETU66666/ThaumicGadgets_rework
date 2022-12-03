 package com.ancient.thaumicgadgets.network;

 import com.ancient.thaumicgadgets.items.ItemLense;
 import io.netty.buffer.ByteBuf;
 import net.minecraft.client.Minecraft;
 import net.minecraft.client.entity.EntityPlayerSP;
 import net.minecraft.client.multiplayer.WorldClient;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
 import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
 import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;






 public class MessageClientCurrentLense
   implements IMessage
 {
   private ItemLense lense;

   public MessageClientCurrentLense() {}

   public MessageClientCurrentLense(ItemLense lense) {
/* 29 */     this.lense = lense;
   }



   public void fromBytes(ByteBuf buf) {
/* 35 */     this.lense = (ItemLense)Item.getItemById(buf.readInt());
   }



   public void toBytes(ByteBuf buf) {
/* 41 */     buf.writeInt(Item.getIdFromItem((Item)this.lense));
   }


   public static class handler
     implements IMessageHandler<MessageClientCurrentLense, IMessage>
   {
     public IMessage onMessage(final MessageClientCurrentLense message, MessageContext ctx) {
/* 49 */       Minecraft.getMinecraft().addScheduledTask(new Runnable()
           {

             public void run()
             {
/* 54 */               Minecraft mc = Minecraft.getMinecraft();
/* 55 */               WorldClient worldClient = mc.world;

/* 57 */               if (worldClient == null) {
                 return;
               }


/* 62 */               EntityPlayerSP entityPlayerSP = mc.player;
/* 63 */               ItemStack stack = (ItemStack)((EntityPlayer)entityPlayerSP).inventory.armorInventory.get(3);
/* 64 */               if (!stack.equals(ItemStack.EMPTY)) {

/* 66 */                 NBTTagCompound t = new NBTTagCompound();
/* 67 */                 if (stack.hasTagCompound())
                 {
/* 69 */                   t = stack.getTagCompound();
                 }
/* 71 */                 t.setString("tg:lense", message.lense.getRegistryName().toString());
/* 72 */                 stack.setTagCompound(t);
               }
             }
           });
/* 76 */       return null;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageClientCurrentLense.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */