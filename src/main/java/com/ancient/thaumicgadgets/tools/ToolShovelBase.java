package com.ancient.thaumicgadgets.tools;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;


public class ToolShovelBase extends ItemSpade implements IHasModel {
    public ToolShovelBase(String name, Item.ToolMaterial material) {
        super(material);

        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.GADGETSTAB);

        ModItems.ITEMS.add(this);
    }


    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}