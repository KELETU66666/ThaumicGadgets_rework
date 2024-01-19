package com.ancient.thaumicgadgets.blocks;

import net.minecraft.block.material.Material;

public class BlockLight extends BlockBase {
    public BlockLight(String name, Material material, float lightLvl) {
        super(name, material);
        setLightLevel(lightLvl);
    }
}