package com.ancient.thaumicgadgets.items.pouches;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.items.ItemBase;
import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.UUID;


public class ItemPouch extends ItemBase {
    private final UUID defaultUUID = new UUID(0L, 1L);


    public ItemPouch(String name) {super(name);
        setMaxStackSize(1);
    }



    public int getMaxItemUseDuration(ItemStack stack) {return 1;
    }



    public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected) {if (!stack.hasTagCompound()) {
        NBTTagCompound nbt = new NBTTagCompound();nbt.setUniqueId("playerID", this.defaultUUID);stack.setTagCompound(nbt);
    }

    if (stack.getTranslationKey().contains("magic") && stack.getTranslationKey().contains("pouch") && stack.getTranslationKey().contains("hungry") && !entity.isSneaking()) {
        AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - 2.5D, entity.posY - 2.5D, entity.posZ - 2.5D, entity.posX + 2.5D, entity.posY + 2.5D, entity.posZ + 2.5D);for (EntityItem item : entity.world.getEntitiesWithinAABB(EntityItem.class, aabb)) {
            if (item != null) {double x = entity.posX - item.posX;double y = entity.posY - item.posY;double z = entity.posZ - item.posZ;Vec3d vec = (new Vec3d(x, y, z)).normalize();item.motionX = vec.x * 0.20000000298023224D;item.motionY = vec.y * 0.20000000298023224D;item.motionZ = vec.z * 0.20000000298023224D;
            }
        }
    }
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {if (!worldIn.isRemote) {
        ItemStack stack = playerIn.getHeldItem(handIn);NBTTagCompound nbt = stack.getTagCompound();
        if (!stack.getTranslationKey().contains("ender") && stack.getTranslationKey().contains("pouch")) {
            if (!playerIn.isSneaking())
            {if (nbt.getUniqueId("playerID").equals(playerIn.getUniqueID()) || nbt.getUniqueId("playerID").equals(this.defaultUUID))
            {playerIn.openGui(Main.instance, 3, worldIn, 0, 0, 0);
            }
            else
            {playerIn.attackEntityFrom(DamageSource.MAGIC, 4.0F);
            }

            } else if (nbt.getUniqueId("playerID").equals(this.defaultUUID))
            {nbt.setUniqueId("playerID", playerIn.getUniqueID());stack.setTagCompound(nbt);playerIn.sendMessage(new TextComponentString(I18n.format("item.pouch.description.soulbinded")));
            } else if (nbt.getUniqueId("playerID").equals(playerIn.getUniqueID()))
            {nbt.setUniqueId("playerID", this.defaultUUID);stack.setTagCompound(nbt);playerIn.sendMessage(new TextComponentString(I18n.format("item.pouch.description.unbinded")));
            }
            else
            {playerIn.sendMessage(new TextComponentString(I18n.format("item.pouch.description.wrong_owner")));
            }
        } else if (stack.getTranslationKey().contains("ender") && stack.getTranslationKey().contains("pouch")) {
            playerIn.displayGUIChest(playerIn.getInventoryEnderChest());
        }
    }
    return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }


    public NonNullList<ItemStack> getInventory(ItemStack stack) {NBTTagCompound nbt = stack.getTagCompound();String tagName = stack.getTranslationKey().substring(5);NBTTagList items = nbt.getTagList(tagName, 10);NonNullList<ItemStack> inventory = NonNullList.withSize(EnumHandler.PouchTypes.valueOf(tagName).getSlotCount(), ItemStack.EMPTY);for (int i = 0; i < items.tagCount(); i++) {
        NBTTagCompound item = items.getCompoundTagAt(i);int slot = item.getInteger("slot");if (slot >= 0 && slot < inventory.size())
        {inventory.set(slot, new ItemStack(item));
        }
    }
    return inventory;
    }



    public void setInventory(ItemStack stack, NonNullList<ItemStack> inv) {NBTTagList items = new NBTTagList();for (int i = 0; i < inv.size(); i++) {
        if (inv.get(i) != ItemStack.EMPTY) {
            NBTTagCompound item = new NBTTagCompound();item.setInteger("slot", i);inv.get(i).writeToNBT(item);items.appendTag(item);
        }
    }
    String tagName = stack.getTranslationKey().substring(5);stack.getTagCompound().setTag(tagName, items);
    }
}