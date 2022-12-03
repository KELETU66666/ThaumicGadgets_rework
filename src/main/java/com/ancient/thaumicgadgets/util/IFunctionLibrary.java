/*     */ package com.ancient.thaumicgadgets.util;
/*     */ 
/*     */ import java.util.function.Function;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.block.model.IBakedModel;
/*     */ import net.minecraft.client.renderer.texture.TextureAtlasSprite;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.client.renderer.vertex.VertexFormat;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraftforge.client.model.ModelLoader;
/*     */ import net.minecraftforge.client.model.ModelLoaderRegistry;
/*     */ import net.minecraftforge.client.model.obj.OBJLoader;
/*     */ import net.minecraftforge.common.model.IModelState;
/*     */ import net.minecraftforge.common.model.TRSRTransformation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import thaumcraft.api.aspects.Aspect;
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface IFunctionLibrary
/*     */ {
/*     */   static int getCrystalModeFromName(String str) {
/*  27 */     if (str.contains("oval_crystal_air"))
/*     */     {
/*  29 */       return 0;
/*     */     }
/*  31 */     if (str.contains("oval_crystal_fire"))
/*     */     {
/*  33 */       return 1;
/*     */     }
/*  35 */     if (str.contains("oval_crystal_water"))
/*     */     {
/*  37 */       return 2;
/*     */     }
/*  39 */     if (str.contains("oval_crystal_earth"))
/*     */     {
/*  41 */       return 3;
/*     */     }
/*  43 */     if (str.contains("oval_crystal_order"))
/*     */     {
/*  45 */       return 4;
/*     */     }
/*  47 */     if (str.contains("oval_crystal_entropy"))
/*     */     {
/*  49 */       return 5;
/*     */     }
/*  51 */     return 6;
/*     */   }
/*     */ 
/*     */   
/*     */   static Aspect getAspectFromMode(int mode) {
/*  56 */     switch (mode) {
/*     */       
/*     */       case 0:
/*  59 */         return Aspect.AIR;
/*     */       case 1:
/*  61 */         return Aspect.FIRE;
/*     */       case 2:
/*  63 */         return Aspect.WATER;
/*     */       case 3:
/*  65 */         return Aspect.EARTH;
/*     */       case 4:
/*  67 */         return Aspect.ORDER;
/*     */       case 5:
/*  69 */         return Aspect.ENTROPY;
/*     */     } 
/*  71 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   static Aspect getAspectFromName(String name) {
/*  76 */     if (name.contains("oval_crystal_air"))
/*     */     {
/*  78 */       return Aspect.AIR;
/*     */     }
/*  80 */     if (name.contains("oval_crystal_fire"))
/*     */     {
/*  82 */       return Aspect.FIRE;
/*     */     }
/*  84 */     if (name.contains("oval_crystal_water"))
/*     */     {
/*  86 */       return Aspect.WATER;
/*     */     }
/*  88 */     if (name.contains("oval_crystal_earth"))
/*     */     {
/*  90 */       return Aspect.EARTH;
/*     */     }
/*  92 */     if (name.contains("oval_crystal_order"))
/*     */     {
/*  94 */       return Aspect.ORDER;
/*     */     }
/*  96 */     if (name.contains("oval_crystal_entropy"))
/*     */     {
/*  98 */       return Aspect.ENTROPY;
/*     */     }
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   static IBakedModel loadModelObj(ResourceLocation modelLoc) {
/* 105 */     TRSRTransformation tRSRTransformation = TRSRTransformation.identity();
/* 106 */     VertexFormat format = DefaultVertexFormats.BLOCK;
/* 107 */     Function<ResourceLocation, TextureAtlasSprite> getter = ModelLoader.defaultTextureGetter();
/*     */     
/* 109 */     IBakedModel model = ModelLoaderRegistry.getMissingModel().bake((IModelState)tRSRTransformation, format, getter);
/*     */     
/*     */     try {
/* 112 */       model = OBJLoader.INSTANCE.loadModel(modelLoc).bake((IModelState)tRSRTransformation, format, location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString()));
/*     */     }
/* 114 */     catch (Exception e) {
/*     */       
/* 116 */       e.printStackTrace();
/*     */     } 
/* 118 */     return model;
/*     */   }
/*     */ 
/*     */   
/*     */   static IBakedModel loadModelJson(ResourceLocation modelLoc) {
/* 123 */     TRSRTransformation tRSRTransformation = TRSRTransformation.identity();
/* 124 */     VertexFormat format = DefaultVertexFormats.BLOCK;
/* 125 */     Function<ResourceLocation, TextureAtlasSprite> getter = ModelLoader.defaultTextureGetter();
/*     */     
/* 127 */     IBakedModel model = ModelLoaderRegistry.getMissingModel().bake((IModelState)tRSRTransformation, format, getter);
/*     */     
/*     */     try {
/* 130 */       model = ModelLoaderRegistry.getModel(modelLoc).bake((IModelState)tRSRTransformation, format, location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString()));
/*     */     }
/* 132 */     catch (Exception e) {
/*     */       
/* 134 */       e.printStackTrace();
/*     */     } 
/* 136 */     return model;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   static boolean isPointInRegion(int sX, int sY, int fX, int fY, int mouseX, int mouseY) {
/* 142 */     if (mouseX > sX && mouseX < sX + fX)
/*     */     {
/* 144 */       if (mouseY > sY && mouseY < sY + fY)
/*     */       {
/* 146 */         return true;
/*     */       }
/*     */     }
/* 149 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static RayTraceResult rayTrace(Entity ent, double reachDistance) {
/* 154 */     Vec3d start = new Vec3d(ent.posX, ent.posY + ent.getEyeHeight(), ent.posZ);
/* 155 */     Vec3d finish = start.add(ent.getLookVec().scale(reachDistance));
/* 156 */     return ent.world.rayTraceBlocks(start, finish, false, false, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadget\\util\IFunctionLibrary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */