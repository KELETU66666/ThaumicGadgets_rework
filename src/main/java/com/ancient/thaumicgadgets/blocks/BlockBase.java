package com.ancient.thaumicgadgets.blocks;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModBlocks;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;


public class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material) {
        super(material);

        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.GADGETSTAB);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add((new ItemBlock(this)).setRegistryName(getRegistryName()));
    }

    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}