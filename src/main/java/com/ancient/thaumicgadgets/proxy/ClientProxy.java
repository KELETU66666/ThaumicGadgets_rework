package com.ancient.thaumicgadgets.proxy;

import com.ancient.thaumicgadgets.gui.GuiOverlay;
import com.ancient.thaumicgadgets.keys.KeyInputHandler;
import com.ancient.thaumicgadgets.keys.Keybindings;
import com.ancient.thaumicgadgets.objects.machines.extruder.RenderExtruderUp;
import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruderUp;
import net.minecraft.client.particle.ParticleLava;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    public void init() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityExtruderUp.class, new RenderExtruderUp());
    }

    public void preInit() {

        OBJLoader.INSTANCE.addDomain("tg");

        super.preInit();

    }

    public void postInit() {
        MinecraftForge.EVENT_BUS.register(new GuiOverlay());
        registerKeyBinds();
    }

    private void registerKeyBinds() {
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
        for (Keybindings key : Keybindings.values())
        {
            ClientRegistry.registerKeyBinding(key.getKeyding());
        }
    }

    @Override
    public void createFurnaceOutputBlobFx(World worldObj, int x, int y, int z, EnumFacing facing) {
        float xx = x + .5f + facing.getXOffset() * 1.66f + worldObj.rand.nextFloat() * .3f;
        float zz = z + .5f + facing.getZOffset() * 1.66f + worldObj.rand.nextFloat() * .3f;

        ParticleLava fb = (ParticleLava) new ParticleLava.Factory().createParticle(0, worldObj, xx, y + 1.3f, zz, 0, 0, 0);
        fb.motionY = .2f * worldObj.rand.nextFloat();
        float mx = facing.getXOffset() != 0 ? (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * .5f
                : facing.getXOffset() * worldObj.rand.nextFloat();
        float mz = facing.getZOffset() != 0 ? (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * .5f
                : facing.getZOffset() * worldObj.rand.nextFloat();
        fb.motionX = (0.15f * mx);
        fb.motionZ = (0.15f * mz);
        FMLClientHandler.instance().getClient().effectRenderer.addEffect(fb);
    }
}