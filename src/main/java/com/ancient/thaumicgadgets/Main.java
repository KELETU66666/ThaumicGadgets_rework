 package com.ancient.thaumicgadgets;
 
 import com.ancient.thaumicgadgets.init.ModMultiBlocks;
 import com.ancient.thaumicgadgets.init.ModRecipes;
 import com.ancient.thaumicgadgets.init.ModResearches;
 import com.ancient.thaumicgadgets.init.RegisterAspectsHandler;
 import com.ancient.thaumicgadgets.proxy.CommonProxy;
 import com.ancient.thaumicgadgets.tabs.GadgetsTab;
 import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
 import com.ancient.thaumicgadgets.util.handlers.PickUpHandler;
 import com.ancient.thaumicgadgets.util.handlers.PlayerFlyHandler;
 import com.ancient.thaumicgadgets.util.handlers.PlayerGetDamageHandler;
 import com.ancient.thaumicgadgets.util.handlers.PlayerLoggedIn;
 import com.ancient.thaumicgadgets.util.handlers.PlayerTickHandler;
 import com.ancient.thaumicgadgets.util.handlers.RegistyHandler;
 import com.ancient.thaumicgadgets.util.handlers.TableMorphHandler;
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
 
 
 
 
 
 
 
 @Mod(modid = "tg", name = "Thaumic Gadgets", version = "0.1.1-Kedition", dependencies = "required-after:thaumcraft", acceptedMinecraftVersions = "[1.12.2]")
 public class Main
 {
   @Instance
   public static Main instance;
/* 43 */   public static final CreativeTabs GADGETSTAB = (CreativeTabs)new GadgetsTab("gadgets");
 
   
   public static ModMultiBlocks MMB;
   
/* 48 */   private static final ResourceLocation research_icon = new ResourceLocation("tg", "textures/items/tg.png");
/* 49 */   private static final ResourceLocation research_background = new ResourceLocation("tg", "textures/gui/research/research_background.jpg");
   
   @SidedProxy(clientSide = "com.ancient.thaumicgadgets.proxy.ClientProxy", serverSide = "com.ancient.thaumicgadgets.proxy.CommonProxy")
   public static CommonProxy proxy;
 
   
   @EventHandler
   public static void PreInit(FMLPreInitializationEvent event) {
/* 57 */     RegistyHandler.preInitRegistries();
/* 59 */     MinecraftForge.EVENT_BUS.register(PickUpHandler.class);
/* 60 */     MinecraftForge.EVENT_BUS.register(TableMorphHandler.class);
/* 62 */     MinecraftForge.EVENT_BUS.register(PlayerGetDamageHandler.class);
/* 63 */     MinecraftForge.EVENT_BUS.register(PlayerTickHandler.class);
/* 64 */     MinecraftForge.EVENT_BUS.register(PlayerFlyHandler.class);
/* 65 */     MinecraftForge.EVENT_BUS.register(PlayerLoggedIn.class);
/* 66 */     MinecraftForge.EVENT_BUS.register(RegisterAspectsHandler.class);
/* 67 */     proxy.preInit();
     
/* 69 */     NetworkHandler.init();
   }
 
   
   @EventHandler
   public static void init(FMLInitializationEvent event) {
/* 75 */     ResearchCategories.registerCategory("GADGETS", "UNLOCKINFUSION", null, research_icon, research_background);
     
/* 77 */     ResourceLocation loc = new ResourceLocation("tg", "research/thaumic_gadgets");
     
/* 79 */     ThaumcraftApi.registerResearchLocation(loc);
     
/* 81 */     ModRecipes.InitRecipes();

ModMultiBlocks.InitMultiblocks();

/* 83 */     ModResearches.InitResearches();
     
/* 85 */     proxy.init();
     
/* 87 */     MMB = ModMultiBlocks.getInstance();
   }
 
 
 
   
   @EventHandler
   public static void PostInit(FMLPostInitializationEvent event) {
/* 95 */     proxy.postInit();
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */