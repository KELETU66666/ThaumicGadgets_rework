package com.ancient.thaumicgadgets.tools;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShears;


public class ToolShearsBase extends ItemShears implements IHasModel {
    public ToolShearsBase(String name, Item.ToolMaterial material) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.GADGETSTAB);
        setMaxDamage(material.getMaxUses());

        ModItems.ITEMS.add(this);
    }


    public void registerModels() {
        Main.proxy.registerItemRenderer((Item) this, 0, "inventory");
    }
}