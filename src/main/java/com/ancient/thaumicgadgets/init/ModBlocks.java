package com.ancient.thaumicgadgets.init;

import com.ancient.thaumicgadgets.blocks.*;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = Lists.newArrayList();

    public static final Block LIGHT_BLOCK = new BlockLight("block_light", Material.IRON, 0.6F);
    public static final Block SHADE_BLOCK = new BlockBase("block_shade", Material.IRON);

    public static final Block ORE_LIGHT = new BlockLight("ore_light", Material.ROCK, 0.26667F);
    public static final Block ORE_SHADE = new BlockBase("ore_shade", Material.ROCK);

    public static final Block SPINNING_WHEEL = new BlockSpinningWheel("spinning_wheel");

    public static final Block GEMCUTTER = new BlockGemCutter("gemcutter");

    public static final Block EXTRUDER = new BlockExtruder("extruder");
    public static final Block EXTRUDER_UP = new BlockExtruderUp("extruder_up");

    public static final Block FURNACE = new BlockBlastFurnace("blast_furnace");
    public static final Block AGEING_STONE = new BlockAgeingStone("ageing_stone");

    public static final Block OBSIDIAN_PH = new BlockPlaceholder("obsidian_ph", Material.ROCK, Item.getItemFromBlock(Blocks.OBSIDIAN), SoundType.STONE, 4.0F, 30.0F, 0, "pickaxe", 3);
    public static final Block SOUL_SAND_PH = new BlockPlaceholder("soul_sand_ph", Material.ROCK, Item.getItemFromBlock(Blocks.SOUL_SAND), SoundType.STONE, 4.0F, 30.0F, 0, "pickaxe", 3);
    public static final Block NETHER_BRICKS_PH = new BlockPlaceholder("nether_bricks_ph", Material.ROCK, Item.getItemFromBlock(Blocks.NETHER_BRICK), SoundType.STONE, 4.0F, 30.0F, 0, "pickaxe", 3);
    public static final Block AIR_PH = new BlockPlaceholder("air_ph", Material.ROCK, Item.getItemFromBlock(Blocks.STONE), SoundType.STONE, 4.0F, 30.0F, 0, "pickaxe", 3);
}