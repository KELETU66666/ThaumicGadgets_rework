 package com.ancient.thaumicgadgets.util;
 
 import net.minecraft.util.ResourceLocation;
 import net.minecraft.util.math.Vec3d;
 
 public class Reference
 {
   public static final String MOD_ID = "tg";
   public static final String NAME = "Thaumic Gadgets";
   public static final String VERSION = "0.1.2-kedition";
   public static final String ACCEPTED_VERSIONS = "[1.12.2]";
   public static final String CLIENT_PROXY_CLASS = "com.ancient.thaumicgadgets.proxy.ClientProxy";
   public static final String COMMON_PROXY_CLASS = "com.ancient.thaumicgadgets.proxy.CommonProxy";
/* 14 */   public static final ResourceLocation PARTICLES = new ResourceLocation("tg", "textures/particles/particles.png");
   
   public static final int ENTITY_CORRUPTED_OBSERVER = 120;
   
   public static final int GUI_SPINNING_WHEEL = 0;
   
   public static final int GUI_GEMCUTTER = 1;
   
   public static final int PRIMAL_ARMOR = 2;
   
   public static final int GUI_MAGIC_POUCH = 3;
   public static final int TICKET_BLOCK_ID = 0;
   public static final int TICKET_CART_ID = 1;
   public static final String ANCIENT_CACHE_DATA = "tg:AncientCacheSavedData";
   public static final String NBT_PLAYER_GLOBAL = "thaumic_gadgets";
   public static final String lightFlying = "lightFlying";
   public static final String darkBlink = "darkBlink";
   public static final String tpCoords = "tpCoords";
/* 32 */   public static final Vec3d vecX = new Vec3d(1.0D, 0.0D, 0.0D);
/* 33 */   public static final Vec3d vecY = new Vec3d(0.0D, 1.0D, 0.0D);
/* 34 */   public static final Vec3d vecZ = new Vec3d(0.0D, 0.0D, 1.0D);
 
   
   public static final int getNBTPlayerIndexFromString(String str) {
/* 38 */     switch (str) {
       
       case "lightFlying":
/* 41 */         return 0;
       case "darkBlink":
/* 43 */         return 1;
       case "tpCoords":
/* 45 */         return 2;
     } 
/* 47 */     return 32767;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\Reference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */