package com.ancient.thaumicgadgets.init;

import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.IDustTrigger;
import thaumcraft.api.crafting.Part;
import thaumcraft.common.lib.crafting.DustTriggerMultiblock;

import java.util.Map;

              
               
               
               
               
               
               
public class ModMultiBlocks {
    private static final ModMultiBlocks INSTANCE = new ModMultiBlocks();
    private final Map<String, MBHeading> list = Maps.newHashMap();
    public static ModMultiBlocks getInstance() {
        return INSTANCE;
    }


    public static void InitMultiblocks() {
        Part N = new Part(Blocks.NETHER_BRICK, ModBlocks.NETHER_BRICKS_PH);
        Part O = new Part(Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_PH);
        Part S = new Part(Blocks.SOUL_SAND, ModBlocks.SOUL_SAND_PH);
        Part C = new Part(Blocks.SOUL_SAND, ModBlocks.FURNACE).setApplyPlayerFacing(true);
        Part L = new Part(Material.LAVA, ModBlocks.AIR_PH);
        Part[][][] MultiblockBlastFurnace = {
                {
                    {N, O, N},
                        {O, L, O},
                        {N, O, N}
                },
                {
                    {O,S,O},
                        {S,C,S},
                        {O,S,O}
                },
                {
                    {N,N,N},
                        {N, O, N},
                        {N, N, N}
                }
        };

        IDustTrigger.registerDustTrigger(new DustTriggerMultiblock("TG_BLAST_FURNACE", MultiblockBlastFurnace));
        ThaumcraftApi.addMultiblockRecipeToCatalog(new ResourceLocation("tg", EnumHandler.MultiBlocks.BLAST_FURNACE.getName()), new ThaumcraftApi.BluePrint("TG_BLAST_FURNACE", new ItemStack(ModBlocks.FURNACE), MultiblockBlastFurnace, new ItemStack(Item.getItemFromBlock(Blocks.OBSIDIAN), 9), new ItemStack(Item.getItemFromBlock(Blocks.SOUL_SAND), 5), new ItemStack(Item.getItemFromBlock(Blocks.NETHER_BRICK), 12), new ItemStack(Items.LAVA_BUCKET)));
    }


    private void addMultiBlockRecipe(String name, MBHeading heading) {
        this.list.put(name, heading);
    }


    public int getMaxRecipeCount() {
        return this.list.size();
    }



    public Map<String, MBHeading> getMultiBlockRecipeList() {
        return this.list;
    }


    private MBComponent[][][] emptyRecipe(int xSize, int ySize, int zSize) {
        MBComponent[][][] recipe = new MBComponent[xSize][ySize][zSize];

        for (int y = 0; y < ySize; y++) {

            for (int x = 0; x < xSize; x++) {

                for (int z = 0; z < zSize; z++)
                {
                    recipe[x][y][z] = new MBComponent(Blocks.AIR, Blocks.AIR, false, true);
                }
            }
        }
        return recipe;
    }


    public class MBComponent
    {
        public IBlockState before;
        public IBlockState after;
        public boolean applyFacing;
        public boolean ignoreAtCheck;

        public MBComponent(IBlockState before, IBlockState after, boolean applyFacing, boolean ignoreAtCheck) {
            this.before = before;
            this.after = after;
            this.applyFacing = applyFacing;
            this.ignoreAtCheck = ignoreAtCheck;
        }


        public MBComponent(Block before, Block after, boolean applyFacing, boolean ignoreAtCheck) {
            this.before = before.getDefaultState();
            this.after = after.getDefaultState();
            this.applyFacing = applyFacing;
            this.ignoreAtCheck = ignoreAtCheck;
        }
    }


    public class MBHeading
    {
        public ModMultiBlocks.MBComponent[][][] recipe;
        public Block blockForClick;
        public Item itemForClick;

        public MBHeading(Block blockForClick, Item itemForClick, ModMultiBlocks.MBComponent[][][] recipe) {
            this.recipe = recipe;
            this.blockForClick = blockForClick;
            this.itemForClick = itemForClick;
        }
    }
}