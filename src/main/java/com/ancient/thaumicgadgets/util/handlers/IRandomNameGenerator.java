 package com.ancient.thaumicgadgets.util.handlers;
 
 import java.util.Random;
 
 public interface IRandomNameGenerator
 {
/*  7 */   public static final String[] random1 = new String[] { "Kr", "Ca", "Ra", "Rei", "Mar", "Luk", "Cro", "Cru", "Ray", "Bre", "Zed", "Mor", "Jag", "Mer", "Jar", "Mad", "Cry", "Zur", "Mjol", "Zork", "Creo", "Azak", "Azur", "Mrok", "Drak" };
 
 
 
 
   
/* 13 */   public static final String[] random2 = new String[] { "ir", "mi", "air", "sor", "mee", "clo", "red", "cra", "ark", "arc", "mur", "zer", "miri", "lori", "cres", "zoir", "urak", "marac", "slamar", "salmar" };
 
 
 
 
 
 
   
/* 21 */   public static final String[] random3 = new String[] { "d", "ed", "es", "er", "ark", "arc", "der", "med", "ure", "zur", "mur", "tron", "cred" };
 
 
 
 
 
 
   
   static String generateName(Random rand) {
/* 30 */     return random1[rand.nextInt(random1.length)] + random2[rand.nextInt(random2.length)] + random3[rand.nextInt(random3.length)];
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\IRandomNameGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */