 package com.ancient.thaumicgadgets.util;

 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.item.ItemStack;
 import net.minecraft.nbt.NBTTagCompound;
 import net.minecraft.world.World;


 public interface IItemAutoRepair
   extends IDayTime
 {
   default boolean CheckTime(ItemStack stack, World world, long repairAtMin, long repairAtMax) {
/* 14 */     if (getCurrentDayTime(world) > repairAtMin && getCurrentDayTime(world) < repairAtMax)
     {
/* 16 */       return true;
     }
/* 18 */     return false;
   }


   default void UpdateDamage(ItemStack stack, Entity entity, World world, int repairCount, int repairCooldown) {
/* 23 */     if (!stack.hasTagCompound()) {

/* 25 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 26 */       nBTTagCompound.setLong("lastRepairTick", 0L);
/* 27 */       stack.setTagCompound(nBTTagCompound);
     }

/* 30 */     NBTTagCompound nbt = stack.getTagCompound();
/* 31 */     long lastTick = nbt.getLong("lastRepairTick");
/* 32 */     if (lastTick + repairCooldown < world.getTotalWorldTime()) {

/* 34 */       stack.damageItem(-repairCount, (EntityLivingBase)entity);
/* 35 */       nbt.setLong("lastRepairTick", world.getTotalWorldTime());
/* 36 */       stack.setTagCompound(nbt);
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\IItemAutoRepair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */