package com.ancient.thaumicgadgets.tabs;

import com.ancient.thaumicgadgets.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
public class GadgetsTab extends CreativeTabs
{
    private final String file;
    public GadgetsTab(String label) {
        super(label);
        this.file = label + ".png";
        setBackgroundImageName(this.file);
        setNoTitle();
    }
    public ItemStack createIcon() {
        return new ItemStack(ModItems.TG);
    }
    @SideOnly(Side.CLIENT)
    public String getBackgroundImageName() {
        return this.file;
    }
}