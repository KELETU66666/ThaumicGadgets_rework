package com.ancient.thaumicgadgets.util;

import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.aspects.Aspect;



public interface IFunctionLibrary
{
    static int getCrystalModeFromName(String str) {
        if (str.contains("oval_crystal_air"))
        {
            return 0;
        }
        if (str.contains("oval_crystal_fire"))
        {
            return 1;
        }
        if (str.contains("oval_crystal_water"))
        {
            return 2;
        }
        if (str.contains("oval_crystal_earth"))
        {
            return 3;
        }
        if (str.contains("oval_crystal_order"))
        {
            return 4;
        }
        if (str.contains("oval_crystal_entropy"))
        {
            return 5;
        }
        return 6;
    }


    static Aspect getAspectFromMode(int mode) {
        switch (mode) {

            case 0:
                return Aspect.AIR;
                case 1:
                    return Aspect.FIRE;
                    case 2:
                        return Aspect.WATER;
                        case 3:
                            return Aspect.EARTH;
                            case 4:
                                return Aspect.ORDER;
                                case 5:
                                    return Aspect.ENTROPY;
        }
        return null;
    }


    static Aspect getAspectFromName(String name) {
        if (name.contains("oval_crystal_air"))
        {
            return Aspect.AIR;
        }
        if (name.contains("oval_crystal_fire"))
        {
            return Aspect.FIRE;
        }
        if (name.contains("oval_crystal_water"))
        {
            return Aspect.WATER;
        }
        if (name.contains("oval_crystal_earth"))
        {
            return Aspect.EARTH;
        }
        if (name.contains("oval_crystal_order"))
        {
            return Aspect.ORDER;
        }
        if (name.contains("oval_crystal_entropy"))
        {
            return Aspect.ENTROPY;
        }
        return null;
    }


    static IBakedModel loadModelObj(ResourceLocation modelLoc) {
        TRSRTransformation tRSRTransformation = TRSRTransformation.identity();
        VertexFormat format = DefaultVertexFormats.BLOCK;
        Function<ResourceLocation, TextureAtlasSprite> getter = ModelLoader.defaultTextureGetter();

        IBakedModel model = ModelLoaderRegistry.getMissingModel().bake((IModelState)tRSRTransformation, format, getter);

        try {
            model = OBJLoader.INSTANCE.loadModel(modelLoc).bake((IModelState)tRSRTransformation, format, location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString()));
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        return model;
    }


    static IBakedModel loadModelJson(ResourceLocation modelLoc) {
        TRSRTransformation tRSRTransformation = TRSRTransformation.identity();
        VertexFormat format = DefaultVertexFormats.BLOCK;
        Function<ResourceLocation, TextureAtlasSprite> getter = ModelLoader.defaultTextureGetter();

        IBakedModel model = ModelLoaderRegistry.getMissingModel().bake((IModelState)tRSRTransformation, format, getter);

        try {
            model = ModelLoaderRegistry.getModel(modelLoc).bake((IModelState)tRSRTransformation, format, location -> Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(location.toString()));
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        return model;
    }


    @SideOnly(Side.CLIENT)
    static boolean isPointInRegion(int sX, int sY, int fX, int fY, int mouseX, int mouseY) {
        if (mouseX > sX && mouseX < sX + fX)
        {
            if (mouseY > sY && mouseY < sY + fY)
            {
                return true;
            }
        }
        return false;
    }


    static RayTraceResult rayTrace(Entity ent, double reachDistance) {
        Vec3d start = new Vec3d(ent.posX, ent.posY + ent.getEyeHeight(), ent.posZ);
        Vec3d finish = start.add(ent.getLookVec().scale(reachDistance));
        return ent.world.rayTraceBlocks(start, finish, false, false, true);
    }
}
