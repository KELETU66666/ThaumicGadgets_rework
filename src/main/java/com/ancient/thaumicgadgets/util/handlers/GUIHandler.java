 package com.ancient.thaumicgadgets.util.handlers;
 
 import com.ancient.thaumicgadgets.armor.primal.ContainerPrimalArmor;
 import com.ancient.thaumicgadgets.armor.primal.GUIPrimalArmor;
 import com.ancient.thaumicgadgets.armor.primal.InventoryPrimalArmor;
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
 
 
 
 
 
 public class GUIHandler
   implements IGuiHandler
 {
   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/* 28 */     if (ID == 0)
/* 29 */       return new ContainerSpinningWheel(player.inventory, (TileEntitySpinningWheel)world.getTileEntity(new BlockPos(x, y, z))); 
/* 30 */     if (ID == 1)
/* 31 */       return new ContainerGemCutter(player.inventory, (TileEntityGemCutter)world.getTileEntity(new BlockPos(x, y, z))); 
/* 32 */     if (ID == 2)
/* 33 */       return new ContainerPrimalArmor(player, player.inventory, new InventoryPrimalArmor(player.getHeldItemMainhand())); 
/* 34 */     if (ID == 3)
/* 35 */       return new ContainerPouch(player, player.inventory, new InventoryPouch(player.getHeldItemMainhand())); 
/* 36 */     return null;
   }
 
 
   
   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/* 42 */     if (ID == 0)
/* 43 */       return new GUISpinningWheel(player.inventory, (TileEntitySpinningWheel)world.getTileEntity(new BlockPos(x, y, z))); 
/* 44 */     if (ID == 1)
/* 45 */       return new GUIGemCutter(player.inventory, (TileEntityGemCutter)world.getTileEntity(new BlockPos(x, y, z))); 
/* 46 */     if (ID == 2)
/* 47 */       return new GUIPrimalArmor(new ContainerPrimalArmor(player, player.inventory, new InventoryPrimalArmor(player.getHeldItemMainhand()))); 
/* 48 */     if (ID == 3)
/* 49 */       return new GUIPouch(new ContainerPouch(player, player.inventory, new InventoryPouch(player.getHeldItemMainhand()))); 
/* 50 */     return null;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\GUIHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */