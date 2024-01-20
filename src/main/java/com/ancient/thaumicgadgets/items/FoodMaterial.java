package com.ancient.thaumicgadgets.items;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class FoodMaterial extends ItemBase implements IHasModel {

    private static final String[] subNames = {"dustflour", "dustnetherwart", "netherdough"};

    public FoodMaterial(){
        super("foodmaterial");
        setHasSubtypes(true);
        this.addPropertyOverride(new ResourceLocation("meta"), new IItemPropertyGetter() {
            @Override
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                if (stack.getMetadata() == 1) {
                    return 1.0F;
                }
                if (stack.getMetadata() == 2) {
                    return 2.0F;
                } else return 0.0F;
            }
        });
    }

    @Override
    public String getTranslationKey(ItemStack itemstack) {
        return getTranslationKey() + "." + subNames[itemstack.getItemDamage()];
    }

    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (!isInCreativeTab(tab)) {
            return;
        }

        for (int i = 0; i < subNames.length; i++)
        {
            items.add(new ItemStack(this, 1, i));
        }
    }

    public void registerModels() {
        for (int i = 0; i < subNames.length; i++) {
            Main.proxy.registerItemRenderer(this, i, "inventory");
        }
    }
}
