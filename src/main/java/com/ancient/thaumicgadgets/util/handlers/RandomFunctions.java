 package com.ancient.thaumicgadgets.util.handlers;

 import java.util.Random;

 public class RandomFunctions
 {
/*  7 */   public static final RandomFunctions INSTANCE = new RandomFunctions();
/*  8 */   public static final Random rand = new Random();








   public double getRandomPartcileVelocity(double bound) {
/* 18 */     return (rand.nextDouble() - 0.5D) * 2.0D * bound;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\RandomFunctions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */