package com.ancient.thaumicgadgets.util.handlers;

import com.ancient.thaumicgadgets.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class PlayerLoggedIn {
    @SubscribeEvent
    public static void onPlayerLogged(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {

            Entity ent = event.getEntity();

            NBTTagCompound nbt = ent.getEntityData();
            if (!nbt.hasKey("thaumic_gadgets")) {

                nbt.setTag("thaumic_gadgets", new NBTTagList());
                NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);
                NBTTagCompound lightFlying = new NBTTagCompound();
                NBTTagCompound darkBlink = new NBTTagCompound();
                NBTTagCompound tp = new NBTTagCompound();
                NBTTagList tpList = new NBTTagList();

                list.appendTag(lightFlying);
                list.appendTag(darkBlink);
                tp.setTag("tpCoords", tpList);
                list.appendTag(tp);

                nbt.setTag("thaumic_gadgets", list);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCopy(PlayerEvent.Clone event) {
        Entity ent = event.getEntity();
        EntityPlayer entityPlayer = event.getOriginal();

        NBTTagCompound nbt = ent.getEntityData();
        if (!nbt.hasKey("thaumic_gadgets")) {

            nbt.setTag("thaumic_gadgets", new NBTTagList());
            NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);
            NBTTagCompound lightFlying = new NBTTagCompound();
            NBTTagCompound darkBlink = new NBTTagCompound();
            NBTTagCompound tp = new NBTTagCompound();
            NBTTagList tpList = new NBTTagList();

            NBTTagList listOr = entityPlayer.getEntityData().getTagList("thaumic_gadgets", 10);
            lightFlying = listOr.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("lightFlying"));
            darkBlink = listOr.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("darkBlink"));
            tp = listOr.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("tpCoords"));


            list.appendTag(lightFlying);
            list.appendTag(darkBlink);
            list.appendTag(tp);

            nbt.setTag("thaumic_gadgets", list);
        }
    }
}