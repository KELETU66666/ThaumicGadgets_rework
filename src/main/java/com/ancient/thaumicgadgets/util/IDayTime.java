 package com.ancient.thaumicgadgets.util;

 import net.minecraft.world.World;


 public interface IDayTime
 {
   default int getDayCount(World world) {
/*  9 */     long worldTime = world.getTotalWorldTime();
/* 10 */     return (int)Math.floorDiv(worldTime, 24000L);
   }


   default long getCurrentDayTime(World world) {
/* 15 */     long worldTime = world.getWorldTime();
/* 16 */     return Math.floorMod(worldTime, 24000L);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\IDayTime.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */