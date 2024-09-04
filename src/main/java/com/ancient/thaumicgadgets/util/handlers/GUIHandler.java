package com.ancient.thaumicgadgets.util.handlers;

import com.ancient.thaumicgadgets.items.pouches.ContainerPouch;
import com.ancient.thaumicgadgets.items.pouches.GUIPouch;
import com.ancient.thaumicgadgets.items.pouches.InventoryPouch;
import com.ancient.thaumicgadgets.objects.machines.gemcutter.ContainerGemCutter;
import com.ancient.thaumicgadgets.objects.machines.gemcutter.GUIGemCutter;
import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
import com.ancient.thaumicgadgets.objects.machines.spinningwheel.ContainerSpinningWheel;
import com.ancient.thaumicgadgets.objects.machines.spinningwheel.GUISpinningWheel;
import com.ancient.thaumicgadgets.objects.machines.spinningwheel.TileEntitySpinningWheel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;


public class GUIHandler implements IGuiHandler {
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0)
            return new ContainerSpinningWheel(player.inventory, (TileEntitySpinningWheel) world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == 1)
            return new ContainerGemCutter(player.inventory, (TileEntityGemCutter) world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == 3)
            return new ContainerPouch(player, player.inventory, new InventoryPouch(player.getHeldItemMainhand()));
        return null;
    }


    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == 0)
            return new GUISpinningWheel(player.inventory, (TileEntitySpinningWheel) world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == 1)
            return new GUIGemCutter(player.inventory, (TileEntityGemCutter) world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == 3)
            return new GUIPouch(new ContainerPouch(player, player.inventory, new InventoryPouch(player.getHeldItemMainhand())));
        return null;
    }
}