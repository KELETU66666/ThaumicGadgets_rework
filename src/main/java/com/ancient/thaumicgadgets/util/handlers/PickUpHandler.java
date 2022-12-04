 package com.ancient.thaumicgadgets.util.handlers;

 import com.ancient.thaumicgadgets.items.pouches.ItemPouch;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.entity.player.InventoryPlayer;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.NonNullList;
 import net.minecraft.util.math.BlockPos;
 import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 import net.minecraftforge.oredict.OreDictionary;
 import thaumcraft.api.aura.AuraHelper;



 public class PickUpHandler
 {
   @SubscribeEvent
   public static void onEvent(EntityItemPickupEvent event) {
/* 20 */     if (!(event.getEntity()).world.isRemote) {

/* 22 */       EntityPlayer player = event.getEntityPlayer();
/* 23 */       InventoryPlayer inv = player.inventory;
/* 24 */       for (int i = 0; i < (event.getEntityPlayer()).inventory.getSizeInventory(); i++) {

/* 26 */         if (inv.getStackInSlot(i).getUnlocalizedName().contains("void") && inv.getStackInSlot(i).getUnlocalizedName().contains("pouch")) {

/* 28 */           ItemPouch pouch = (ItemPouch)inv.getStackInSlot(i).getItem();
/* 29 */           NonNullList<ItemStack> pouchInv = pouch.getInventory(inv.getStackInSlot(i));

/* 31 */           for (ItemStack stack : pouchInv) {
    if(stack.getTagCompound() != null && event.getItem().getItem().getTagCompound() != null)
/* 32 */             if (OreDictionary.itemMatches(stack, event.getItem().getItem(), true) && stack.getTagCompound().equals(event.getItem().getItem().getTagCompound()))
             {
/* 34 */               if (ItemStack.areItemStackTagsEqual(stack, event.getItem().getItem())) {

/* 36 */                 AuraHelper.addVis((event.getEntityPlayer()).world, new BlockPos((event.getEntityPlayer()).posX, (event.getEntityPlayer()).posY, (event.getEntityPlayer()).posZ), 0.2F * stack.getCount());
/* 37 */                 event.getItem().setDead();
/* 38 */                 event.setCanceled(true);


                 return;
               }
             }
           }
/* 45 */         } else if (inv.getStackInSlot(i).getUnlocalizedName().contains("hungry") && inv.getStackInSlot(i).getUnlocalizedName().contains("pouch")) {

/* 47 */           ItemPouch pouch = (ItemPouch)inv.getStackInSlot(i).getItem();
/* 48 */           NonNullList<ItemStack> pouchInv = pouch.getInventory(inv.getStackInSlot(i));
/* 49 */           for (int q = 0; q < pouchInv.size(); q++) {

/* 51 */             if (pouchInv.get(q) == ItemStack.EMPTY) {

/* 53 */               pouchInv.set(q, event.getItem().getItem());
/* 54 */               event.getItem().setDead();
/* 55 */               event.setCanceled(true);
/* 56 */               pouch.setInventory(inv.getStackInSlot(i), pouchInv);
               return;
             }
/* 59 */             if (OreDictionary.itemMatches((ItemStack)pouchInv.get(q), event.getItem().getItem(), true))
             {
/* 61 */               if (ItemStack.areItemStackTagsEqual((ItemStack)pouchInv.get(q), event.getItem().getItem())) {

/* 63 */                 int fit = Math.min(Math.min(64, ((ItemStack)pouchInv.get(q)).getMaxStackSize()) - ((ItemStack)pouchInv.get(q)).getCount(), event.getItem().getItem().getCount());
/* 64 */                 ((ItemStack)pouchInv.get(q)).setCount(((ItemStack)pouchInv.get(q)).getCount() + fit);
/* 65 */                 pouch.setInventory(inv.getStackInSlot(i), pouchInv);
/* 66 */                 event.getItem().getItem().setCount(event.getItem().getItem().getCount() - fit);
/* 67 */                 if (event.getItem().getItem().getCount() <= 0) {

/* 69 */                   event.getItem().setDead();
/* 70 */                   event.setCanceled(true);
                   return;
                 }
               }
             }
           }
         }
       }
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\PickUpHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */