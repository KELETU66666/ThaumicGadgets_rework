package com.ancient.thaumicgadgets.util.handlers;


import com.ancient.thaumicgadgets.network.particles.MessageClientSpawnParticles;
import com.ancient.thaumicgadgets.network.particles.MessageClientSpawnParticlesCustom;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ParticleSpawner {
    public RandomFunctions rf = RandomFunctions.INSTANCE;
    public static final ParticleSpawner INSTANCE = new ParticleSpawner();


    public void transferData(EnumParticleTypes type, int count, double x, double y, double z, int dim) {
        NetworkHandler.sendToAllNearby(new MessageClientSpawnParticles(type, x, y, z, count, this.rf.getRandomPartcileVelocity(0.2D), this.rf.getRandomPartcileVelocity(0.2D), this.rf.getRandomPartcileVelocity(0.2D)), new NetworkRegistry.TargetPoint(dim, x, y, z, 64.0D));
    }

    public void transferData(EnumHandler.CustomParticles type, int count, double x, double y, double z, double velX, double velY, double velZ, int dim) {
        NetworkHandler.sendToAllNearby(new MessageClientSpawnParticlesCustom(type, x, y, z, count, velX, velY, velZ), new NetworkRegistry.TargetPoint(dim, x, y, z, 64.0D));
    }

    @SideOnly(Side.CLIENT)
    public void spawnParticles(EnumParticleTypes type, int count, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        if (count > 0) {
            for (int q = 0; q < count; q++) {
                (Minecraft.getMinecraft()).world.spawnParticle(type, x, y, z, velocityX, velocityY, velocityZ);
            }
        }
    }


    @SideOnly(Side.CLIENT)
    public void spawnParticles(EnumHandler.CustomParticles type, Vec3d start, Vec3d end) {
        Minecraft mc = Minecraft.getMinecraft();
        double Rse = Math.sqrt(Math.pow(end.x - start.x, 2.0D) + Math.pow(end.y - start.y, 2.0D) + Math.pow(end.z - start.z, 2.0D));
        int count = (int) Math.ceil(Rse / 0.20000000298023224D);

        if (count > 0) {

            int i = 0;
            for (int q = 0; q < count; q++) {

                double k = 0.20000000298023224D / Rse * q;
                double xk = start.x + (end.x - start.x) * k;
                double yk = start.y + (end.y - start.y) * k;
                double zk = start.z + (end.z - start.z) * k;
                Object particle = null;

                try {
                    String p = type.getParticle();
                    particle = Class.forName(p).getConstructor(new Class[]{World.class, double.class, double.class, double.class, double.class, double.class, double.class, int.class}).newInstance(mc.world, xk, yk, zk, 0.0D, 0.0D, 0.0D, i);
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                         java.lang.reflect.InvocationTargetException | NoSuchMethodException | SecurityException |
                         ClassNotFoundException e) {

                    e.printStackTrace();
                }
                if (particle instanceof Particle) {

                    Particle part = (Particle) particle;
                    mc.effectRenderer.addEffect(part);
                }
                if (i++ > 7) {
                    i = 0;
                }
            }
        }
    }


    @SideOnly(Side.CLIENT)
    public void spawnParticles(EnumHandler.CustomParticles type, int count, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        Minecraft mc = Minecraft.getMinecraft();

        if (count > 0) {
            for (int q = 0; q < count; q++) {

                Object particle = null;

                try {
                    String p = type.getParticle();
                    particle = Class.forName(p).getConstructor(new Class[]{World.class, double.class, double.class, double.class, double.class, double.class, double.class}).newInstance(mc.world, x, y, z, velocityX, velocityY, velocityZ);
                } catch (InstantiationException | IllegalAccessException | IllegalArgumentException |
                         java.lang.reflect.InvocationTargetException | NoSuchMethodException | SecurityException |
                         ClassNotFoundException e) {

                    e.printStackTrace();
                }
                if (particle instanceof Particle) {

                    Particle part = (Particle) particle;
                    mc.effectRenderer.addEffect(part);
                }
            }
        }
    }
}