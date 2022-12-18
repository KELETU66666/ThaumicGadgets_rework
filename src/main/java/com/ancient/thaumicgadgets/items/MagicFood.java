package com.ancient.thaumicgadgets.items;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.capabilities.IPlayerKnowledge;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;

import javax.annotation.Nullable;
import java.util.Arrays;

public class MagicFood extends ItemFood implements IHasModel {
    private int[] hungerHealed = {2, 6, 6};
    private float[] saturation = {0.4f, 1.5f, 1.0f};

    private static final String[] subNames = {"sweetwart", "nethercake", "brainjerky"};

    public MagicFood() {
        super(0, 0, false);
        setCreativeTab(Main.GADGETSTAB);
        setHasSubtypes(true);
        setHasSubtypes(true);
        setRegistryName("magicfood");
        setUnlocalizedName("magicfood");
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

        ModItems.ITEMS.add(this);
    }

    @Override
    public int getHealAmount(ItemStack stack) {
        return hungerHealed[Math.min(hungerHealed.length - 1, stack.getItemDamage())];
    }

    @Override
    public float getSaturationModifier(ItemStack stack) {
        return saturation[Math.min(saturation.length - 1, stack.getItemDamage())];
    }

    @Override
    public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        if (stack.getItemDamage() == 2 && !world.isRemote) {
            int luck = world.rand.nextInt(3);
            for (int pass = 0; pass <= luck; pass++) {
                int oProg = IPlayerKnowledge.EnumKnowledgeType.OBSERVATION.getProgression();
                int tProg = IPlayerKnowledge.EnumKnowledgeType.THEORY.getProgression();

                ResearchCategory[] rc = ResearchCategories.researchCategories.values().toArray(new ResearchCategory[0]);
                ThaumcraftApi.internalMethods.addKnowledge(player, IPlayerKnowledge.EnumKnowledgeType.OBSERVATION, rc[player.getRNG().nextInt(rc.length)], MathHelper.getInt(player.getRNG(), oProg / 4, oProg / 3));
                ThaumcraftApi.internalMethods.addKnowledge(player, IPlayerKnowledge.EnumKnowledgeType.THEORY, rc[player.getRNG().nextInt(rc.length)], MathHelper.getInt(player.getRNG(), tProg / 8, tProg / 6));

            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return getUnlocalizedName() + "." + subNames[itemstack.getItemDamage()];
    }

    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (!isInCreativeTab(tab)) {
            return;
        }

        for (int i = 0; i < subNames.length; i++)
        {
            if (i != 2 || Loader.isModLoaded("tconstruct")) items.add(new ItemStack(this, 1, i));
        }
    }

    public void registerModels() {
        for (int i = 0; i < subNames.length; i++) {
            Main.proxy.registerItemRenderer(this, i, "inventory");
        }
    }
}
