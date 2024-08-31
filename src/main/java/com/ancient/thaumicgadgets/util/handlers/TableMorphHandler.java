package com.ancient.thaumicgadgets.util.handlers;

import com.ancient.thaumicgadgets.init.ModBlocks;
import com.ancient.thaumicgadgets.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import thaumcraft.api.blocks.BlocksTC;


public class TableMorphHandler {
    @SubscribeEvent
    public static void onEvent(PlayerInteractEvent.RightClickBlock event) {
        Block newBlock = ModBlocks.GEMCUTTER;
        IBlockState state = newBlock.getDefaultState();
        Block block = event.getWorld().getBlockState(event.getPos()).getBlock();

        if (block == BlocksTC.tableWood && event.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.TOOL_GEMCUTTER && event.getHand() == EnumHand.MAIN_HAND) {


            event.getWorld().setBlockState(event.getPos(), state);
            if (!event.getEntityPlayer().isCreative())
                event.getEntityPlayer().getHeldItemMainhand().shrink(1);
        }
    }
}