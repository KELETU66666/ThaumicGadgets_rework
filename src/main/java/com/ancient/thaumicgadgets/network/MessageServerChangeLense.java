/*     */ package com.ancient.thaumicgadgets.network;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import com.ancient.thaumicgadgets.items.ItemLense;
/*     */ import com.ancient.thaumicgadgets.items.pouches.ItemPouch;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MessageServerChangeLense
/*     */   implements IMessage
/*     */ {
/*     */   private ItemStack newLense;
/*     */   
/*     */   public MessageServerChangeLense() {}
/*     */   
/*     */   public MessageServerChangeLense(ItemStack newLense) {
/*  31 */     this.newLense = newLense;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void fromBytes(ByteBuf buf) {
/*  37 */     this.newLense = ByteBufUtils.readItemStack(buf);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toBytes(ByteBuf buf) {
/*  43 */     ByteBufUtils.writeItemStack(buf, this.newLense);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class handler
/*     */     implements IMessageHandler<MessageServerChangeLense, IMessage>
/*     */   {
/*     */     public IMessage onMessage(final MessageServerChangeLense message, MessageContext ctx) {
/*  51 */       final EntityPlayerMP pl = (ctx.getServerHandler()).player;
/*     */       
/*  53 */       pl.getServerWorld().addScheduledTask(new Runnable()
/*     */           {
/*     */             
/*     */             public void run()
/*     */             {
/*  58 */               ItemStack stack = (ItemStack)pl.inventory.armorInventory.get(3);
/*  59 */               if (!stack.equals(ItemStack.EMPTY)) {
/*     */                 
/*  61 */                 NBTTagCompound tag = new NBTTagCompound();
/*  62 */                 if (stack.hasTagCompound())
/*     */                 {
/*  64 */                   tag = stack.getTagCompound();
/*     */                 }
/*  66 */                 ItemLense l = null;
/*     */                 
/*  68 */                 if (tag.hasKey("tg:lense")) {
/*     */                   
/*  70 */                   Item temp = Item.getByNameOrId(tag.getString("tg:lense"));
/*  71 */                   if (temp instanceof ItemLense)
/*     */                   {
/*  73 */                     l = (ItemLense)temp;
/*     */                   }
/*     */                 } 
/*     */                 
/*  77 */                 for (ItemStack s : pl.inventory.mainInventory) {
/*     */                   
/*  79 */                   if (s.getItem().equals(ModItems.LENSE_POUCH)) {
/*     */                     
/*  81 */                     ItemPouch p = (ItemPouch)s.getItem();
/*  82 */                     NonNullList<ItemStack> inv = p.getInventory(s);
/*     */                     
/*  84 */                     int slot = -1;
/*  85 */                     for (int q = 0; q < inv.size(); q++) {
/*     */                       
/*  87 */                       if (ItemStack.areItemStacksEqual((ItemStack)inv.get(q), message.newLense))
/*     */                       {
/*  89 */                         slot = q;
/*     */                       }
/*     */                     } 
/*     */                     
/*  93 */                     if (slot > -1)
/*     */                     {
/*  95 */                       inv.set(slot, ItemStack.EMPTY);
/*     */                     }
/*  97 */                     int emptySlot = -1;
/*  98 */                     for (int i = 0; i < inv.size(); i++) {
/*     */                       
/* 100 */                       if (ItemStack.areItemStacksEqual((ItemStack)inv.get(i), ItemStack.EMPTY))
/*     */                       {
/* 102 */                         emptySlot = i;
/*     */                       }
/*     */                     } 
/*     */                     
/* 106 */                     if (l != null)
/*     */                     {
/* 108 */                       if (emptySlot > -1) {
/*     */                         
/* 110 */                         inv.set(emptySlot, new ItemStack((Item)l));
/*     */                       }
/*     */                       else {
/*     */                         
/* 114 */                         pl.world.spawnEntity((Entity)new EntityItem(pl.world, pl.posX, pl.posY, pl.posZ, new ItemStack((Item)l)));
/*     */                       } 
/*     */                     }
/* 117 */                     p.setInventory(s, inv);
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/* 122 */                 tag.setString("tg:lense", message.newLense.getItem().getRegistryName().toString());
/* 123 */                 stack.setTagCompound(tag);
/*     */               } 
/*     */             }
/*     */           });
/* 127 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\network\MessageServerChangeLense.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */