package com.ancient.thaumicgadgets.tools;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;


public class ToolAxeBase extends ItemAxe implements IHasModel {
    public ToolAxeBase(String name, Item.ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);

        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.GADGETSTAB);

        ModItems.ITEMS.add(this);
    }


    public void registerModels() {
        Main.proxy.registerItemRenderer((Item) this, 0, "inventory");
    }
}