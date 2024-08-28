package com.ancient.thaumicgadgets;

import com.ancient.thaumicgadgets.init.ModMultiBlocks;
import com.ancient.thaumicgadgets.init.ModRecipes;
import com.ancient.thaumicgadgets.init.ModResearches;
import com.ancient.thaumicgadgets.init.RegisterAspectsHandler;
import com.ancient.thaumicgadgets.objects.machines.blastfurnace.InfernalBlastfurnaceRecipe;
import com.ancient.thaumicgadgets.proxy.CommonProxy;
import com.ancient.thaumicgadgets.tabs.GadgetsTab;
import com.ancient.thaumicgadgets.util.handlers.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.research.ResearchCategories;







@Mod(modid = "tg", name = "Thaumic Gadgets", version = "0.3.2-kedition", dependencies = "required-after:thaumcraft", acceptedMinecraftVersions = "[1.12.2]")
public class Main
{
    @Instance
    public static Main instance;
    public static final CreativeTabs GADGETSTAB = new GadgetsTab("gadgets");

    public static ModMultiBlocks MMB;

    private static final ResourceLocation research_icon = new ResourceLocation("tg", "textures/items/tg.png");
    private static final ResourceLocation research_background = new ResourceLocation("tg", "textures/gui/research/research_background.jpg");

    @SidedProxy(clientSide = "com.ancient.thaumicgadgets.proxy.ClientProxy", serverSide = "com.ancient.thaumicgadgets.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {
        RegistyHandler.preInitRegistries();
        MinecraftForge.EVENT_BUS.register(PickUpHandler.class);
        MinecraftForge.EVENT_BUS.register(TableMorphHandler.class);
        MinecraftForge.EVENT_BUS.register(PlayerGetDamageHandler.class);
        MinecraftForge.EVENT_BUS.register(PlayerTickHandler.class);
        MinecraftForge.EVENT_BUS.register(PlayerFlyHandler.class);
        MinecraftForge.EVENT_BUS.register(PlayerLoggedIn.class);
        MinecraftForge.EVENT_BUS.register(RegisterAspectsHandler.class);
        proxy.preInit();

        NetworkHandler.init();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        TileEntityHandler.registerTileEntities();
        ResearchCategories.registerCategory("GADGETS", "UNLOCKINFUSION", null, research_icon, research_background);
        ResourceLocation loc = new ResourceLocation("tg", "research/thaumic_gadgets");

        ThaumcraftApi.registerResearchLocation(loc);

        ModRecipes.InitRecipes();
        ModMultiBlocks.InitMultiblocks();

        ModResearches.InitResearches();
        proxy.init();
        MMB = ModMultiBlocks.getInstance();
    }

    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event) {
        proxy.postInit();

        InfernalBlastfurnaceRecipe.tryAddIngotImprovement("Iron", "Steel", false);
        InfernalBlastfurnaceRecipe.tryAddSpecialOreMelting("Tungsten","Tungsten",true);
        InfernalBlastfurnaceRecipe.tryAddSpecialOreMelting("Rutile","Titanium",true);
        InfernalBlastfurnaceRecipe.tryAddSpecialOreMelting("Shade", "Shade", false);
        InfernalBlastfurnaceRecipe.tryAddSpecialOreMelting("Light", "Light", false);
    }
}