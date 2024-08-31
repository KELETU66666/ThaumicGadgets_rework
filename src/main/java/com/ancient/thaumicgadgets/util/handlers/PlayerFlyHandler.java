package com.ancient.thaumicgadgets.util.handlers;


import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import com.ancient.thaumicgadgets.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class PlayerFlyHandler {
    private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;


    @SubscribeEvent
    public static void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
        if (!(event.getEntity().getEntityWorld()).isRemote) {
            if (event.getEntity() instanceof EntityPlayer) {
                if (!((EntityPlayer) event.getEntity()).isCreative() && !((EntityPlayer) event.getEntity()).isSpectator()) {
                    EntityPlayer player = (EntityPlayer) event.getEntityLiving();


                    NBTTagCompound nbt = player.getEntityData();

                    if (nbt.hasKey("thaumic_gadgets")) {

                        NBTTagList list = nbt.getTagList("thaumic_gadgets", 10);
                        NBTTagCompound compound = list.getCompoundTagAt(Reference.getNBTPlayerIndexFromString("lightFlying"));

                        Long lastUse = compound.getLong("lastAbilityUse");
                        int duration = compound.getInteger("duration");

                        if (lastUse + duration > player.world.getTotalWorldTime()) {

                            player.capabilities.allowFlying = true;
                            player.capabilities.isFlying = true;
                            player.sendPlayerAbilities();
                        } else if (lastUse + duration == player.world.getTotalWorldTime()) {

                            player.capabilities.allowFlying = false;
                            if (!player.onGround) {
                                player.capabilities.isFlying = false;
                            }
                            player.sendPlayerAbilities();
                        }
                    }
                }
            }
        }
    }


    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onDrawParticles(RenderLivingEvent.Pre event) {
        if (event.getEntity() instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer) event.getEntity();

            checkShadowArmor(player);
        }
    }


    @SubscribeEvent
    public static void checkBootsForStep(LivingEvent.LivingUpdateEvent event) {
        if ((event.getEntityLiving().getEntityWorld()).isRemote) {
            if (event.getEntityLiving() instanceof EntityPlayer) {

                EntityPlayer player = (EntityPlayer) event.getEntityLiving();
                ItemStack stack = player.inventory.armorItemInSlot(0);
                if (stack.getItem() != Items.AIR) {

                    if (stack.getItem() instanceof com.ancient.thaumicgadgets.armor.primal.ArmorPrimal || stack.getItem() instanceof com.ancient.thaumicgadgets.armor.light.ArmorLight || stack.getItem() instanceof com.ancient.thaumicgadgets.armor.shade.ArmorShade) {
                        player.stepHeight = 1.25F;
                    }
                } else {

                    player.stepHeight = 0.61F;
                }
            }
        }
    }


    private static void checkShadowArmor(EntityPlayer player) {
        int i = 0;

        for (ItemStack stack : player.inventory.armorInventory) {

            if (stack.getItem() instanceof com.ancient.thaumicgadgets.armor.shade.ArmorShade) {
                i++;
            }
        }

        IBaublesItemHandler handler = BaublesApi.getBaublesHandler(player);
        ItemStack belt = handler.getStackInSlot(3);

        if (belt.getItem() instanceof com.ancient.thaumicgadgets.armor.shade.ShadeBelt) {
            i++;
        }


        if (i == 5) {


            int count = RandomFunctions.rand.nextInt(2) + 1;

            double height = player.getPosition().getY() + RandomFunctions.rand.nextDouble() * player.height;

            EnumFacing face = player.getHorizontalFacing();
            switch (face) {

                case NORTH:
                    ps.spawnParticles(EnumParticleTypes.SMOKE_NORMAL, count, (player.getPosition().getX() + RandomFunctions.rand.nextFloat() - 0.5F), height, (player.getPosition().getZ() + RandomFunctions.rand.nextFloat()), 0.0D, 0.0D, 0.0D);
                    break;
                case SOUTH:
                    ps.spawnParticles(EnumParticleTypes.SMOKE_NORMAL, count, (player.getPosition().getX() + RandomFunctions.rand.nextFloat() - 0.75F), height, (player.getPosition().getZ() - RandomFunctions.rand.nextFloat() / 2.0F), 0.0D, 0.0D, 0.0D);
                    break;
                case EAST:
                    ps.spawnParticles(EnumParticleTypes.SMOKE_NORMAL, count, (player.getPosition().getX() - RandomFunctions.rand.nextFloat() / 2.0F - 0.25F), height, (player.getPosition().getZ() - RandomFunctions.rand.nextFloat() + 0.5F), 0.0D, 0.0D, 0.0D);
                    break;
                case WEST:
                    ps.spawnParticles(EnumParticleTypes.SMOKE_NORMAL, count, (player.getPosition().getX() - RandomFunctions.rand.nextFloat() / 2.0F + 1.0F), height, (player.getPosition().getZ() + RandomFunctions.rand.nextFloat() - 0.5F), 0.0D, 0.0D, 0.0D);
                    break;
            }
        }
    }
}