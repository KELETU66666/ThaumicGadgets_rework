/*     */ package com.ancient.thaumicgadgets.util.handlers;
/*     */ 
/*     */ import net.minecraft.util.IStringSerializable;
/*     */ 
/*     */ public class EnumHandler
/*     */ {
/*     */   public enum FocusTypes
/*     */     implements IStringSerializable {
/*   9 */     TAIGA(0, "taiga"),
/*  10 */     DESERT(1, "desert"),
/*  11 */     HELL(2, "hell"),
/*  12 */     JUNGLE(3, "jungle"),
/*  13 */     MUSHROOM(4, "mushroom"),
/*  14 */     PLAINS(5, "plains"),
/*  15 */     ICE_PLAINS(6, "ice_plains"),
/*  16 */     FOREST(7, "forest"),
/*  17 */     SWAMPLAND(8, "swampland"),
/*  18 */     SAVANNA(9, "savanna");
/*     */ 
/*     */     
/*     */     private int id;
/*     */     
/*     */     private String name;
/*     */ 
/*     */     
/*     */     FocusTypes(int id, String name) {
/*  27 */       this.id = id;
/*  28 */       this.name = name;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/*  34 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getId() {
/*  39 */       return this.id;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  45 */       return getName();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public enum PouchTypes
/*     */   {
/*  52 */     pouch_magic_1("pouch_magic_1", 18),
/*  53 */     pouch_magic_2("pouch_magic_2", 27),
/*  54 */     pouch_magic_3("pouch_magic_3", 36),
/*  55 */     pouch_hungry_magic_1("pouch_hungry_magic_1", 18),
/*  56 */     pouch_hungry_magic_2("pouch_hungry_magic_2", 27),
/*  57 */     pouch_hungry_magic_3("pouch_hungry_magic_3", 36),
/*  58 */     pouch_void("pouch_void", 18);
/*     */     
/*     */     private String name;
/*     */     
/*     */     private int slotCount;
/*     */     
/*     */     PouchTypes(String name, int slotCount) {
/*  66 */       this.slotCount = slotCount;
/*  67 */       this.name = name;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getName() {
/*  72 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getSlotCount() {
/*  77 */       return this.slotCount;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  83 */       return getName();
/*     */     }
/*     */   }
/*     */   
/*     */   public enum CustomParticles
/*     */   {
/*  89 */     LIGHTNING(0, "lightning", "com.ancient.thaumicgadgets.particles.ParticleCustomLightning"),
/*  90 */     BUBBLE(1, "bubble", "com.ancient.thaumicgadgets.particles.ParticleCustomBubble"),
/*  91 */     SMOKE(2, "smoke", "com.ancient.thaumicgadgets.particles.ParticleCustomSmoke");
/*     */     
/*     */     private final String name;
/*     */     
/*     */     private final int id;
/*     */     private final String cl;
/*     */     
/*     */     CustomParticles(int id, String name, String cl) {
/*  99 */       this.name = name;
/* 100 */       this.id = id;
/* 101 */       this.cl = cl;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getName() {
/* 106 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getID() {
/* 111 */       return this.id;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getParticle() {
/* 116 */       return this.cl;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 122 */       return getName();
/*     */     }
/*     */   }
/*     */   
/*     */   public enum MultiBlocks
/*     */   {
/* 130 */     BLAST_FURNACE(2, "blast_furnace");
/*     */     
/*     */     private final String name;
/*     */     
/*     */     private final int id;
/*     */     
/*     */     MultiBlocks(int id, String name) {
/* 139 */       this.name = name;
/* 140 */       this.id = id;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getName() {
/* 145 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getId() {
/* 150 */       return this.id;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 156 */       return this.name;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\EnumHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */