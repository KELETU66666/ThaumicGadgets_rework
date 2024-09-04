package com.ancient.thaumicgadgets.armor.shade;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.items.ItemBase;
import com.ancient.thaumicgadgets.network.MessageClientBeltAbilities;
import com.ancient.thaumicgadgets.util.IItemAutoRepair;
import com.ancient.thaumicgadgets.util.Reference;
import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;

public class ShadeBelt extends ItemBase implements IBauble, IItemAutoRepair {
    private final int distance = 8;
    public final int cd = 300;
    public long lastUse;
    private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;


    public ShadeBelt(String name) {
        super(name);
        this.setMaxStackSize(1);
    }


    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BELT;
    }


    public void onWornTick(ItemStack itemStack, EntityLivingBase player) {
        if (!player.world.isRemote) {
            if (CheckTime(itemStack, player.world, 12517L, 24000L)) {

                EntityPlayer pl = (EntityPlayer) player;

                int i = 0;

                NonNullList<ItemStack> list = pl.inventory.armorInventory;

                for (ItemStack stack : list) {

                    if (!stack.getItem().equals(Items.AIR)) {

                        ItemArmor s = (ItemArmor) stack.getItem();
                        if (s.armorType.equals(EntityEquipmentSlot.FEET)) {
                            if (s.equals(ModItems.BOOTS_SHADE)) {

                                pl.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
                                pl.fallDistance = 0.0F;
                            }
                        }

                        if (s instanceof ArmorShade) {
                            i++;
                        }
                    }
                }

                if (i == 4) {

                    pl.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 105, 1));
                    pl.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 205, 1));
                }
            }
        }
    }


    public void ActivateTeleportation(EntityPlayer player) {
        if (!player.world.isRemote) {
            NBTTagCompound nbt = player.getEntityData();
            NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);

            NBTTagCompound compound = list.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("darkBlink"));

            if (!compound.hasKey("lastAbilityUse")) {
                compound.setLong("lastAbilityUse", 0L);
            }
            if (!compound.hasKey("cd")) {

                compound.setInteger("cd", 300);
            }
            long lastTick = compound.getLong("lastAbilityUse");

            if (lastTick + 300L <= player.world.getTotalWorldTime()) {

                compound.setLong("lastAbilityUse", player.world.getTotalWorldTime());
                boolean canBlink = true;
                int incDistance = 8;
                double x = 0.0D;
                double z = 0.0D;
                double prevX = x;
                double prevZ = z;
                while (canBlink && incDistance >= 0) {

                    x = player.posX + -Math.sin((player.rotationYaw / 180.0F * 3.1415927F)) * Math.cos((player.rotationPitch / 180.0F * 3.1415927F)) * (8 - incDistance);
                    z = player.posZ + Math.cos((player.rotationYaw / 180.0F * 3.1415927F)) * Math.cos((player.rotationPitch / 180.0F * 3.1415927F)) * (8 - incDistance);

                    IBlockState state = player.world.getBlockState(new BlockPos(x, player.posY, z));
                    if (state.getBlock() != Blocks.AIR) {

                        canBlink = false;
                        x = prevX;
                        z = prevZ;

                        continue;
                    }
                    incDistance--;
                    prevX = x;
                    prevZ = z;
                }

                int q;
                for (q = 0; q < 10; q++) {
                    ps.transferData(EnumParticleTypes.DRAGON_BREATH, 1, player.posX + RandomFunctions.rand.nextDouble() - 0.5D, player.posY, player.posZ + RandomFunctions.rand.nextDouble() - 0.5D, player.dimension);
                }


                player.setPositionAndUpdate(x, player.posY + 0.5D, z);

                for (q = 0; q < 10; q++) {
                    ps.transferData(EnumParticleTypes.DRAGON_BREATH, 1, x + RandomFunctions.rand.nextDouble() - 0.5D, player.posY, z + RandomFunctions.rand.nextDouble() - 0.5D, player.dimension);
                }

                list.set(Reference.getNBTPlayerIndexFromString("darkBlink"), compound);
                nbt.setTag("thaumic_gadgets", list);

                NetworkHandler.sendToClient(new MessageClientBeltAbilities(player.world.getTotalWorldTime(), 300), (EntityPlayerMP) player);
            }
        }
    }

    public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}