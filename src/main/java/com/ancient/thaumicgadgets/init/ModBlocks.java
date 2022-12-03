/*     */ package com.ancient.thaumicgadgets.init;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.blocks.BlockAgeingStone;
/*     */ import com.ancient.thaumicgadgets.blocks.BlockBase;
/*     */ import com.ancient.thaumicgadgets.blocks.BlockBlastFurnace;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import com.ancient.thaumicgadgets.blocks.BlockExtruder;
/*     */ import com.ancient.thaumicgadgets.blocks.BlockExtruderUp;
/*     */
/*     */
/*     */
/*     */ import com.ancient.thaumicgadgets.blocks.BlockGemCutter;
/*     */
/*     */ import com.ancient.thaumicgadgets.blocks.BlockLight;
/*     */ import com.ancient.thaumicgadgets.blocks.BlockPlaceholder;
/*     */
/*     */ import com.ancient.thaumicgadgets.blocks.BlockSpinningWheel;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.SoundType;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModBlocks
/*     */ {
    /*  46 */   public static final List<Block> BLOCKS = Lists.newArrayList();
    /*     */
    /*  48 */   public static final Block LIGHT_BLOCK = (Block) new BlockLight("block_light", Material.IRON, 0.6F);
    /*  49 */   public static final Block SHADE_BLOCK = (Block) new BlockBase("block_shade", Material.IRON);
    /*     */
    /*  51 */   public static final Block ORE_LIGHT = (Block) new BlockLight("ore_light", Material.ROCK, 0.26667F);
    /*  52 */   public static final Block ORE_SHADE = (Block) new BlockBase("ore_shade", Material.ROCK);
    /*     */
    /*  54 */   public static final Block SPINNING_WHEEL = (Block) new BlockSpinningWheel("spinning_wheel");

    /*  58 */   public static final Block GEMCUTTER = (Block) new BlockGemCutter("gemcutter");
    /*     */
    /*  60 */   public static final Block EXTRUDER = (Block) new BlockExtruder("extruder");
    /*  61 */   public static final Block EXTRUDER_UP = (Block) new BlockExtruderUp("extruder_up");
    /*     */
    /*  63 */   public static final Block FURNACE = (Block) new BlockBlastFurnace("blast_furnace");
    /*     */
    /*  65 */   public static final Block AGEING_STONE = (Block) new BlockAgeingStone("ageing_stone");

    /*  91 */   public static final Block OBSIDIAN_PH = (Block) new BlockPlaceholder("obsidian_ph", Material.ROCK, Item.getItemFromBlock(Blocks.OBSIDIAN), 1, SoundType.STONE, 4.0F, 30.0F, 0, "pickaxe", 3);
    /*  92 */   public static final Block SOUL_SAND_PH = (Block) new BlockPlaceholder("soul_sand_ph", Material.ROCK, Item.getItemFromBlock(Blocks.SOUL_SAND), 1, SoundType.STONE, 4.0F, 30.0F, 0, "pickaxe", 3);
    /*  93 */   public static final Block NETHER_BRICKS_PH = (Block) new BlockPlaceholder("nether_bricks_ph", Material.ROCK, Item.getItemFromBlock(Blocks.NETHER_BRICK), 1, SoundType.STONE, 4.0F, 30.0F, 0, "pickaxe", 3);
}


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\init\ModBlocks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */