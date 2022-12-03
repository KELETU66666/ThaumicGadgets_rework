 package com.ancient.thaumicgadgets.objects.machines.lamp;

 import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.ITickable;

 public class TileEntityLamp
   extends TileEntity
   implements ITickable
 {
/* 11 */   public int timer = 0;

/* 13 */   private static final RandomFunctions rf = RandomFunctions.INSTANCE;



   public TileEntityLamp() {
/* 18 */     this.timer = RandomFunctions.rand.nextInt(721);
   }



   public void update() {
/* 24 */     if (this.world.isRemote)
     {
/* 26 */       if (++this.timer >= 721)
       {
/* 28 */         this.timer = 0;
       }
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\lamp\TileEntityLamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */