package com.ancient.thaumicgadgets.tools;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;


public class ToolPickaxeBase extends ItemPickaxe implements IHasModel {
    public ToolPickaxeBase(String name, Item.ToolMaterial material) {
        super(material);

        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.GADGETSTAB);

        ModItems.ITEMS.add(this);
    }


    public void registerModels() {
        Main.proxy.registerItemRenderer((Item) this, 0, "inventory");
    }
}