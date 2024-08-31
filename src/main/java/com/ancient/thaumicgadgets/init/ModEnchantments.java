package com.ancient.thaumicgadgets.init;

import com.ancient.thaumicgadgets.enchantments.EnchRegenPrimal;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;


@EventBusSubscriber(modid = "thaumicgadgets")
public class ModEnchantments {
    public static final List<Enchantment> ECHANTMENTS = new ArrayList<>();

    public static final Enchantment REGEN_PRIMAL = new EnchRegenPrimal("regen_primal", Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET});


    @SubscribeEvent
    public static void RegenPrimal(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase l = event.getEntityLiving();
        int lvl = EnchantmentHelper.getMaxEnchantmentLevel(REGEN_PRIMAL, l);
        BlockPos pos = l.getPosition();
        World world = (event.getEntity()).world;
    }
}