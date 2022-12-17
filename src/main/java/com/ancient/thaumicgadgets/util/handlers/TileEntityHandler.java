 package com.ancient.thaumicgadgets.util.handlers;
 
 import com.ancient.thaumicgadgets.objects.machines.ageingstone.TileEntityAgeingStone;
 import com.ancient.thaumicgadgets.objects.machines.blastfurnace.TileEntityBlastFurnace;
 import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruder;
 import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruderUp;
 import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
 import com.ancient.thaumicgadgets.objects.machines.spinningwheel.TileEntitySpinningWheel;
 import net.minecraft.util.ResourceLocation;
 import net.minecraftforge.fml.common.registry.GameRegistry;
 
 
 
 
 public class TileEntityHandler
 {
   public static void registerTileEntities() {
/* 27 */     GameRegistry.registerTileEntity(TileEntitySpinningWheel.class, new ResourceLocation("tg", "spinning_wheel"));
/* 29 */     GameRegistry.registerTileEntity(TileEntityGemCutter.class, new ResourceLocation("tg", "gemcutter"));
/* 30 */     GameRegistry.registerTileEntity(TileEntityExtruder.class, new ResourceLocation("tg", "extruder"));
/* 31 */     GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, new ResourceLocation("tg", "blast_furnace"));
/* 32 */     GameRegistry.registerTileEntity(TileEntityAgeingStone.class, new ResourceLocation("tg", "ageing_stone"));
/* 37 */     GameRegistry.registerTileEntity(TileEntityExtruderUp.class, new ResourceLocation("tg", "extruder_up"));
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\TileEntityHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */