package com.ancient.thaumicgadgets.util.handlers;

import com.ancient.thaumicgadgets.objects.machines.ageingstone.TileEntityAgeingStone;
import com.ancient.thaumicgadgets.objects.machines.blastfurnace.TileEntityBlastFurnace;
import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruder;
import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruderUp;
import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
import com.ancient.thaumicgadgets.objects.machines.spinningwheel.TileEntitySpinningWheel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class TileEntityHandler {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntitySpinningWheel.class, new ResourceLocation("thaumicgadgets", "spinning_wheel"));
        GameRegistry.registerTileEntity(TileEntityGemCutter.class, new ResourceLocation("thaumicgadgets", "gemcutter"));
        GameRegistry.registerTileEntity(TileEntityExtruder.class, new ResourceLocation("thaumicgadgets", "extruder"));
        GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, new ResourceLocation("thaumicgadgets", "infernal_blast_furnace"));
        GameRegistry.registerTileEntity(TileEntityAgeingStone.class, new ResourceLocation("thaumicgadgets", "ageing_stone"));
        GameRegistry.registerTileEntity(TileEntityExtruderUp.class, new ResourceLocation("thaumicgadgets", "extruder_up"));
    }
}