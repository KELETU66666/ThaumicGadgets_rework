package com.ancient.thaumicgadgets.objects.machines.ageingstone;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;


public class TileEntityAgeingStone extends TileEntity implements ITickable
{
    public void update() {
        if (!this.world.isRemote) {

            AxisAlignedBB aabb = new AxisAlignedBB((this.pos.getX() - 3), (this.pos.getY() - 2), (this.pos.getZ() - 3), (this.pos.getX() + 4), (this.pos.getY() + 3), (this.pos.getZ() + 4));
            for (EntityAgeable ent : this.world.getEntitiesWithinAABB(EntityAgeable.class, aabb)) {

                if (ent.isChild())
                {
                    ent.setGrowingAge(ent.getGrowingAge() + 1);
                }
            }
        }
    }
}