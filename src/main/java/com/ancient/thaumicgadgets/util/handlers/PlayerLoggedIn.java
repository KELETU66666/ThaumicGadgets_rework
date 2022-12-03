 package com.ancient.thaumicgadgets.util.handlers;
 
 import com.ancient.thaumicgadgets.util.Reference;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.nbt.NBTBase;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.nbt.NBTTagList;
 import net.minecraftforge.event.entity.EntityJoinWorldEvent;
 import net.minecraftforge.event.entity.player.PlayerEvent;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 
 
 
 public class PlayerLoggedIn
 {
   @SubscribeEvent
   public static void onPlayerLogged(EntityJoinWorldEvent event) {
/* 19 */     if (event.getEntity() instanceof EntityPlayer) {
       
/* 21 */       Entity ent = event.getEntity();
       
/* 23 */       NBTTagCompound nbt = ent.getEntityData();
/* 24 */       if (!nbt.hasKey("thaumic_gadgets")) {
         
/* 26 */         nbt.setTag("thaumic_gadgets", (NBTBase)new NBTTagList());
/* 27 */         NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);
/* 28 */         NBTTagCompound lightFlying = new NBTTagCompound();
/* 29 */         NBTTagCompound darkBlink = new NBTTagCompound();
/* 30 */         NBTTagCompound tp = new NBTTagCompound();
/* 31 */         NBTTagList tpList = new NBTTagList();
         
/* 33 */         list.appendTag((NBTBase)lightFlying);
/* 34 */         list.appendTag((NBTBase)darkBlink);
/* 35 */         tp.setTag("tpCoords", (NBTBase)tpList);
/* 36 */         list.appendTag((NBTBase)tp);
         
/* 38 */         nbt.setTag("thaumic_gadgets", (NBTBase)list);
       } 
     } 
   }
   
   @SubscribeEvent
   public static void onPlayerCopy(PlayerEvent.Clone event) {
/* 45 */     Entity ent = event.getEntity();
/* 46 */     EntityPlayer entityPlayer = event.getOriginal();
     
/* 48 */     NBTTagCompound nbt = ent.getEntityData();
/* 49 */     if (!nbt.hasKey("thaumic_gadgets")) {
       
/* 51 */       nbt.setTag("thaumic_gadgets", (NBTBase)new NBTTagList());
/* 52 */       NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);
/* 53 */       NBTTagCompound lightFlying = new NBTTagCompound();
/* 54 */       NBTTagCompound darkBlink = new NBTTagCompound();
/* 55 */       NBTTagCompound tp = new NBTTagCompound();
/* 56 */       NBTTagList tpList = new NBTTagList();
       
/* 58 */       NBTTagList listOr = entityPlayer.getEntityData().getTagList("thaumic_gadgets", 10);
/* 59 */       lightFlying = listOr.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("lightFlying"));
/* 60 */       darkBlink = listOr.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("darkBlink"));
/* 61 */       tp = listOr.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("tpCoords"));
 
       
/* 64 */       list.appendTag((NBTBase)lightFlying);
/* 65 */       list.appendTag((NBTBase)darkBlink);
/* 66 */       list.appendTag((NBTBase)tp);
       
/* 68 */       nbt.setTag("thaumic_gadgets", (NBTBase)list);
     } 
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\PlayerLoggedIn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */