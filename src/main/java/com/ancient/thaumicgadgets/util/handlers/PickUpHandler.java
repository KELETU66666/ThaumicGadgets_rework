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

public class PickUpHandler {
    @SubscribeEvent
    public static void onEvent(EntityItemPickupEvent event) {
        if (!(event.getEntity()).world.isRemote) {

            EntityPlayer player = event.getEntityPlayer();
            InventoryPlayer inv = player.inventory;
            for (int i = 0; i < (event.getEntityPlayer()).inventory.getSizeInventory(); i++) {

                if (inv.getStackInSlot(i).getTranslationKey().contains("void") && inv.getStackInSlot(i).getTranslationKey().contains("pouch")) {

                    ItemPouch pouch = (ItemPouch) inv.getStackInSlot(i).getItem();
                    NonNullList<ItemStack> pouchInv = pouch.getInventory(inv.getStackInSlot(i));

                    for (ItemStack stack : pouchInv) {
                        if (stack.getTagCompound() != null && event.getItem().getItem().getTagCompound() != null)
                            if (OreDictionary.itemMatches(stack, event.getItem().getItem(), true) && stack.getTagCompound().equals(event.getItem().getItem().getTagCompound())) {
                                if (ItemStack.areItemStackTagsEqual(stack, event.getItem().getItem())) {

                                    AuraHelper.addVis((event.getEntityPlayer()).world, new BlockPos((event.getEntityPlayer()).posX, (event.getEntityPlayer()).posY, (event.getEntityPlayer()).posZ), 0.2F * stack.getCount());
                                    event.getItem().setDead();
                                    event.setCanceled(true);


                                    return;
                                }
                            }
                    }
                } else if (inv.getStackInSlot(i).getTranslationKey().contains("hungry") && inv.getStackInSlot(i).getTranslationKey().contains("pouch")) {

                    ItemPouch pouch = (ItemPouch) inv.getStackInSlot(i).getItem();
                    NonNullList<ItemStack> pouchInv = pouch.getInventory(inv.getStackInSlot(i));
                    for (int q = 0; q < pouchInv.size(); q++) {

                        if (pouchInv.get(q) == ItemStack.EMPTY) {

                            pouchInv.set(q, event.getItem().getItem());
                            event.getItem().setDead();
                            event.setCanceled(true);
                            pouch.setInventory(inv.getStackInSlot(i), pouchInv);
                            return;
                        }
                        if (OreDictionary.itemMatches(pouchInv.get(q), event.getItem().getItem(), true)) {
                            if (ItemStack.areItemStackTagsEqual(pouchInv.get(q), event.getItem().getItem())) {

                                int fit = Math.min(Math.min(64, pouchInv.get(q).getMaxStackSize()) - pouchInv.get(q).getCount(), event.getItem().getItem().getCount());
                                pouchInv.get(q).setCount(pouchInv.get(q).getCount() + fit);
                                pouch.setInventory(inv.getStackInSlot(i), pouchInv);
                                event.getItem().getItem().setCount(event.getItem().getItem().getCount() - fit);
                                if (event.getItem().getItem().getCount() <= 0) {

                                    event.getItem().setDead();
                                    event.setCanceled(true);
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