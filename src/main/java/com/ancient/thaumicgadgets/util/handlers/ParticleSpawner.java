/*     */ package com.ancient.thaumicgadgets.util.handlers;
/*     */ 
/*     */

import com.ancient.thaumicgadgets.network.particles.MessageClientSpawnParticles;
import com.ancient.thaumicgadgets.network.particles.MessageClientSpawnParticlesCustom;
import com.ancient.thaumicgadgets.network.particles.MessageClientSpawnParticlesCustomLightning;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ParticleSpawner
/*     */ {
/*  21 */   public RandomFunctions rf = RandomFunctions.INSTANCE;
/*  22 */   public static final ParticleSpawner INSTANCE = new ParticleSpawner();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void transferData(EnumParticleTypes type, int count, double x, double y, double z, int dim) {
/*  31 */     NetworkHandler.sendToAllNearby((IMessage)new MessageClientSpawnParticles(type, x, y, z, count, this.rf.getRandomPartcileVelocity(0.2D), this.rf.getRandomPartcileVelocity(0.2D), this.rf.getRandomPartcileVelocity(0.2D)), new NetworkRegistry.TargetPoint(dim, x, y, z, 64.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void transferData(EnumParticleTypes type, int count, double x, double y, double z, double velX, double velY, double velZ, int dim) {
/*  36 */     NetworkHandler.sendToAllNearby((IMessage)new MessageClientSpawnParticles(type, x, y, z, count, velX, velY, velZ), new NetworkRegistry.TargetPoint(dim, x, y, z, 64.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void transferData(EnumHandler.CustomParticles type, int count, double x, double y, double z, double velX, double velY, double velZ, int dim) {
/*  41 */     NetworkHandler.sendToAllNearby((IMessage)new MessageClientSpawnParticlesCustom(type, x, y, z, count, velX, velY, velZ), new NetworkRegistry.TargetPoint(dim, x, y, z, 64.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public void transferData(EnumHandler.CustomParticles type, Vec3d start, Vec3d finish, int dim) {
/*  46 */     NetworkHandler.sendToAllNearby((IMessage)new MessageClientSpawnParticlesCustomLightning(type, start, finish), new NetworkRegistry.TargetPoint(dim, start.x, start.y, start.z, 64.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void spawnParticles(EnumParticleTypes type, int count, double x, double y, double z) {
/*  52 */     if (count > 0)
/*     */     {
/*  54 */       for (int q = 0; q < count; q++)
/*     */       {
/*  56 */         (Minecraft.getMinecraft()).world.spawnParticle(type, x, y, z, this.rf.getRandomPartcileVelocity(0.2D), this.rf.getRandomPartcileVelocity(0.2D), this.rf.getRandomPartcileVelocity(0.2D), new int[0]);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void spawnParticles(EnumParticleTypes type, int count, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
/*  64 */     if (count > 0)
/*     */     {
/*  66 */       for (int q = 0; q < count; q++)
/*     */       {
/*  68 */         (Minecraft.getMinecraft()).world.spawnParticle(type, x, y, z, velocityX, velocityY, velocityZ, new int[0]);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void spawnParticles(EnumHandler.CustomParticles type, Vec3d start, Vec3d end) {
/*  76 */     Minecraft mc = Minecraft.getMinecraft();
/*  77 */     double Rse = Math.sqrt(Math.pow(end.x - start.x, 2.0D) + Math.pow(end.y - start.y, 2.0D) + Math.pow(end.z - start.z, 2.0D));
/*  78 */     int count = (int)Math.ceil(Rse / 0.20000000298023224D);
/*     */     
/*  80 */     if (count > 0) {
/*     */       
/*  82 */       int i = 0;
/*  83 */       for (int q = 0; q < count; q++) {
/*     */         
/*  85 */         double k = 0.20000000298023224D / Rse * q;
/*  86 */         double xk = start.x + (end.x - start.x) * k;
/*  87 */         double yk = start.y + (end.y - start.y) * k;
/*  88 */         double zk = start.z + (end.z - start.z) * k;
/*  89 */         Object particle = null;
/*     */         
/*     */         try {
/*  92 */           String p = type.getParticle();
/*  93 */           particle = Class.forName(p).getConstructor(new Class[] { World.class, double.class, double.class, double.class, double.class, double.class, double.class, int.class }).newInstance(new Object[] { mc.world, Double.valueOf(xk), Double.valueOf(yk), Double.valueOf(zk), Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(i) });
/*     */         }
/*  95 */         catch (InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException|ClassNotFoundException e) {
/*     */           
/*  97 */           e.printStackTrace();
/*     */         } 
/*  99 */         if (particle instanceof Particle) {
/*     */           
/* 101 */           Particle part = (Particle)particle;
/* 102 */           mc.effectRenderer.addEffect(part);
/*     */         } 
/* 104 */         if (i++ > 7)
/*     */         {
/* 106 */           i = 0;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void spawnParticles(EnumHandler.CustomParticles type, int count, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
/* 115 */     Minecraft mc = Minecraft.getMinecraft();
/*     */     
/* 117 */     if (count > 0)
/*     */     {
/* 119 */       for (int q = 0; q < count; q++) {
/*     */         
/* 121 */         Object particle = null;
/*     */         
/*     */         try {
/* 124 */           String p = type.getParticle();
/* 125 */           particle = Class.forName(p).getConstructor(new Class[] { World.class, double.class, double.class, double.class, double.class, double.class, double.class }).newInstance(new Object[] { mc.world, Double.valueOf(x), Double.valueOf(y), Double.valueOf(z), Double.valueOf(velocityX), Double.valueOf(velocityY), Double.valueOf(velocityZ) });
/*     */         }
/* 127 */         catch (InstantiationException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|NoSuchMethodException|SecurityException|ClassNotFoundException e) {
/*     */           
/* 129 */           e.printStackTrace();
/*     */         } 
/* 131 */         if (particle instanceof Particle) {
/*     */           
/* 133 */           Particle part = (Particle)particle;
/* 134 */           mc.effectRenderer.addEffect(part);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\handlers\ParticleSpawner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */