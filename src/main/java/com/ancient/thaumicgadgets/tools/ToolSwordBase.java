package com.ancient.thaumicgadgets.tools;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;


public class ToolSwordBase extends ItemSword implements IHasModel {
    public ToolSwordBase(String name, Item.ToolMaterial material) {
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