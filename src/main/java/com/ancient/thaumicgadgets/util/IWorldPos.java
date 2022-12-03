 package com.ancient.thaumicgadgets.util;
 
 public interface IWorldPos
 {
   public static class worldPos
   {
/*  7 */     public static final worldPos EMPTY = (worldPos)null;
     
     public int dimension;
     
     public int x;
     public int y;
     public int z;
     
     public worldPos(int dimension, int x, int y, int z) {
/* 16 */       this.dimension = dimension;
/* 17 */       this.x = x;
/* 18 */       this.y = y;
/* 19 */       this.z = z;
     }
 
     
     public worldPos(int dimension, double x, double y, double z) {
/* 24 */       this.dimension = dimension;
/* 25 */       this.x = (int)Math.round(x);
/* 26 */       this.y = (int)Math.round(y);
/* 27 */       this.z = (int)Math.round(z);
     }
 
 
     
     public boolean equals(Object obj) {
/* 33 */       if (obj instanceof worldPos)
       {
/* 35 */         if (((worldPos)obj).dimension == this.dimension && ((worldPos)obj).x == this.x && ((worldPos)obj).y == this.y && ((worldPos)obj).z == this.z)
         {
/* 37 */           return true;
         }
       }
/* 40 */       return false;
     }
 
 
     
     public String toString() {
/* 46 */       return "Dim: " + this.dimension + " X: " + this.x + " Y: " + this.y + " Z: " + this.z;
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\IWorldPos.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */