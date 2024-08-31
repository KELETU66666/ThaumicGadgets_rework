
package com.ancient.thaumicgadgets.armor.light;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.items.ItemBase;
import com.ancient.thaumicgadgets.network.MessageClientBeltAbilities;
import com.ancient.thaumicgadgets.util.IItemAutoRepair;
import com.ancient.thaumicgadgets.util.Reference;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;

public class LightBelt extends ItemBase implements IBauble, IItemAutoRepair {
    public final int cd = 1200;
    public final int duration = 100;

    public long lastUse;

    public LightBelt(String name) {
        super(name);
        this.setMaxStackSize(1);
    }


    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BELT;
    }


    public void onWornTick(ItemStack itemStack, EntityLivingBase player) {
        if (!player.world.isRemote) {
            if (CheckTime(itemStack, player.world, 0L, 12516L)) {

                EntityPlayer pl = (EntityPlayer) player;

                int i = 0;

                NonNullList<ItemStack> list = pl.inventory.armorInventory;

                for (ItemStack stack : list) {

                    if (!stack.getItem().equals(Items.AIR)) {

                        ItemArmor s = (ItemArmor) stack.getItem();
                        if (s.armorType.equals(EntityEquipmentSlot.FEET)) {
                            if (s.equals(ModItems.BOOTS_LIGHT)) {

                                pl.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
                                pl.fallDistance = 0.0F;
                            }
                        }

                        if (s instanceof ArmorLight) {
                            i++;
                        }
                    }
                }

                if (i == 4) {
                    pl.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 105, 1));
                }
            }
        }
    }


    public void EnableFly(EntityPlayer player) {
        if (!player.world.isRemote) {


            NBTTagCompound nbt = player.getEntityData();
            NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);

            NBTTagCompound compound = list.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("lightFlying"));

            if (!compound.hasKey("lastAbilityUse")) {
                compound.setLong("lastAbilityUse", 0L);
            }
            if (!compound.hasKey("cd")) {

                compound.setInteger("cd", 1200);
            }
            long lastTick = compound.getLong("lastAbilityUse");

            if (lastTick + 1200L <= player.world.getTotalWorldTime()) {

                compound.setLong("lastAbilityUse", player.world.getTotalWorldTime());

                compound.setInteger("duration", 100);
                list.set(Reference.getNBTPlayerIndexFromString("lightFlying"), compound);
                nbt.setTag("thaumic_gadgets", list);
                NetworkHandler.sendToClient(new MessageClientBeltAbilities(player.world.getTotalWorldTime(), 1200), (EntityPlayerMP) player);
            }
        }
    }


    public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}