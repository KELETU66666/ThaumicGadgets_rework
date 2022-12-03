 package com.ancient.thaumicgadgets.util.handlers;
 
 import com.ancient.thaumicgadgets.init.ModBlocks;
 import com.ancient.thaumicgadgets.init.ModItems;
 import net.minecraft.block.Block;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.util.EnumHand;
 import net.minecraftforge.event.entity.player.PlayerInteractEvent;
 import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
 import thaumcraft.api.blocks.BlocksTC;
 
 
 
 public class TableMorphHandler
 {
   @SubscribeEvent
   public static void onEvent(PlayerInteractEvent.RightClickBlock event) {
/* 18 */     Block newBlock = ModBlocks.GEMCUTTER;
/* 19 */     IBlockState state = newBlock.getDefaultState();
/* 20 */     Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
     
/* 22 */     if (block == BlocksTC.tableWood && event.getEntityPlayer().getHeldItemMainhand().getItem() == ModItems.TOOL_GEMCUTTER && event.getHand() == EnumHand.MAIN_HAND) {
 
       
/* 25 */       event.getWorld().setBlockState(event.getPos(), state);
/* 26 */       if (!event.getEntityPlayer().isCreative())
/* 27 */         event.getEntityPlayer().getHeldItemMainhand().shrink(1); 
     } 
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\TableMorphHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */