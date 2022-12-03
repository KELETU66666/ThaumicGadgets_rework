 package com.ancient.thaumicgadgets.objects.machines.ageingstone;

 import net.minecraft.entity.EntityAgeable;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.ITickable;
 import net.minecraft.util.math.AxisAlignedBB;


 public class TileEntityAgeingStone
   extends TileEntity
   implements ITickable
 {
   public void update() {
/* 14 */     if (!this.world.isRemote) {

/* 16 */       AxisAlignedBB aabb = new AxisAlignedBB((this.pos.getX() - 3), (this.pos.getY() - 2), (this.pos.getZ() - 3), (this.pos.getX() + 4), (this.pos.getY() + 3), (this.pos.getZ() + 4));
/* 17 */       for (EntityAgeable ent : this.world.getEntitiesWithinAABB(EntityAgeable.class, aabb)) {

/* 19 */         if (ent.isChild())
         {
/* 21 */           ent.setGrowingAge(ent.getGrowingAge() + 1);
         }
       }
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\ageingstone\TileEntityAgeingStone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */