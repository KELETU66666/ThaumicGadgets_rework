package com.ancient.thaumicgadgets.items;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thaumcraft.api.aura.AuraHelper;
import thaumcraft.common.lib.potions.PotionDeathGaze;


public class ItemCrystal extends ItemBase {
    private int rechargeTime = 0;
    private final int maxRechargeTime = 40;

    public ItemCrystal(String name) {
        super(name);

        setMaxDamage(15);
        setMaxStackSize(1);
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItemMainhand();
        String name = stack.getTranslationKey().substring(5).toLowerCase();
        if (isCrystalOval(stack)) {

            stack.damageItem(stack.getMaxDamage() - 8, playerIn);
        } else {

            stack.shrink(1);
        }

        if (name.equals("sharped_crystal_air")) {

            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 3600, 1));
            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(8), 3600, 1));
        } else if (name.equals("sharped_crystal_fire")) {

            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 6000, 0));
        } else if (name.equals("sharped_crystal_earth")) {

            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 3600, 0));
        } else if (name.equals("sharped_crystal_order")) {

            for (PotionEffect ef : (PotionEffect[]) playerIn.getActivePotionEffects().toArray((Object[]) new PotionEffect[0])) {
                if (ef.getPotion().isBadEffect()) {
                    playerIn.removePotionEffect(ef.getPotion());
                }
            }

        } else if (name.equals("sharped_crystal_entropy")) {

            Potion deathGaze = PotionDeathGaze.instance;
            playerIn.addPotionEffect(new PotionEffect(deathGaze, 2400, 0));
        } else if (name.equals("oval_crystal_order")) {

            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(6), 5, 2));
        } else if (name.equals("oval_crystal_earth")) {

            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(21), 3600, 1));
        } else if (name.equals("oval_crystal_air")) {

            playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(13), 3600, 0));
        } else if (name.equals("oval_crystal_entropy")) {

            AuraHelper.polluteAura(playerIn.world, playerIn.getPosition(), 50.0F, true);
        }


        return new ActionResult(EnumActionResult.SUCCESS, stack);
    }


    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItemMainhand();
        String name = stack.getTranslationKey().substring(5).toLowerCase();

        if (isCrystalOval(stack)) {

            stack.damageItem(stack.getMaxDamage() - 8, player);
        } else {

            stack.shrink(1);
        }

        if (name.equals("sharped_crystal_water")) {
            for (int z = 0; z < 5; z++) {

                for (int y = 0; y < 5; y++) {

                    for (int x = 0; x < 5; x++) {

                        BlockPos p = new BlockPos(pos.getX() - 2 + x, pos.getY() - 2 + y, pos.getZ() + z - 2);
                        if (worldIn.getBlockState(p).getBlock().equals(Blocks.LAVA)) {

                            worldIn.destroyBlock(p, false);
                            worldIn.setBlockState(p, Blocks.OBSIDIAN.getDefaultState());
                        }

                        if (worldIn.getBlockState(p).getBlock().equals(Blocks.FLOWING_LAVA)) {

                            worldIn.destroyBlock(p, false);
                            worldIn.setBlockState(p, Blocks.STONE.getDefaultState());
                        }

                        if (worldIn.getBlockState(p).getBlock().equals(Blocks.WATER)) {

                            worldIn.destroyBlock(p, false);
                            worldIn.setBlockState(p, Blocks.ICE.getDefaultState());
                        }
                        if (worldIn.getBlockState(p).getBlock().equals(Blocks.FLOWING_WATER)) {

                            worldIn.destroyBlock(p, false);
                            worldIn.setBlockState(p, Blocks.ICE.getDefaultState());
                        }
                    }
                }
            }
        }

        if (name.equals("oval_crystal_water") && worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock().equals(Blocks.AIR)) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.WATER.getDefaultState());
        }
        if (name.equals("oval_crystal_fire") && worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock().equals(Blocks.AIR)) {
            worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), Blocks.FIRE.getDefaultState());
        }
        return EnumActionResult.SUCCESS;
    }

    public boolean isCrystalOval(ItemStack stack) {
        String name = stack.getTranslationKey().substring(5, 9);
        return name.equals("oval");
    }


    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (isSelected && stack.getItemDamage() < stack.getMaxDamage() && AuraHelper.getVis(worldIn, entityIn.getPosition()) > 5.0F) {
            this.rechargeTime++;
            if (this.rechargeTime >= this.maxRechargeTime) {
                this.rechargeTime = 0;
                AuraHelper.drainVis(worldIn, entityIn.getPosition(), 5.0F, true);
                stack.damageItem(-2, (EntityLivingBase) entityIn);
            }
        } else {
            this.rechargeTime = 0;
        }
    }
}