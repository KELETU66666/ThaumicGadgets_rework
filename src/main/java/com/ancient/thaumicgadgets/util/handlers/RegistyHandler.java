package com.ancient.thaumicgadgets.util.handlers;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModBlocks;
import com.ancient.thaumicgadgets.init.ModEnchantments;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.init.ModSounds;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.oredict.OreDictionary;


@EventBusSubscriber
public class RegistyHandler {
    public static void preInitRegistries() {
        ModSounds.registerSounds();

        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GUIHandler());
    }


    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }


    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.ITEMS) {

            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : ModBlocks.BLOCKS) {

            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }


    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray((new Block[0])));
    }


    @SubscribeEvent
    public static void onEnchantmentRegister(RegistryEvent.Register<Enchantment> event) {
        /* 75 */
        event.getRegistry().registerAll(ModEnchantments.ECHANTMENTS.toArray((new Enchantment[0])));
    }


    @SubscribeEvent
    public static void onSoundRegister(RegistryEvent.Register<SoundEvent> event) {
        /* 82 */
        event.getRegistry().registerAll(ModSounds.SOUNDS.toArray((new SoundEvent[0])));
    }

    @SubscribeEvent
    public static void OreRegister(RegistryEvent.Register<Enchantment> event) {
        OreDictionary.registerOre("dustFlour", new ItemStack(ModItems.FOOD_MATERIAL, 1, 0));
        OreDictionary.registerOre("dustNetherWart", new ItemStack(ModItems.FOOD_MATERIAL, 1, 1));
        OreDictionary.registerOre("ingotShade", new ItemStack(ModItems.INGOT_SHADE));
        OreDictionary.registerOre("ingotLight", new ItemStack(ModItems.INGOT_LIGHT));
        OreDictionary.registerOre("nuggetShade", new ItemStack(ModItems.NUGGET_SHADE));
        OreDictionary.registerOre("nuggetLight", new ItemStack(ModItems.NUGGET_LIGHT));
        OreDictionary.registerOre("oreShade", new ItemStack(ModBlocks.ORE_SHADE));
        OreDictionary.registerOre("oreLight", new ItemStack(ModBlocks.ORE_LIGHT));
        OreDictionary.registerOre("blockShade", new ItemStack(ModBlocks.SHADE_BLOCK));
        OreDictionary.registerOre("blockLight", new ItemStack(ModBlocks.LIGHT_BLOCK));
    }
}