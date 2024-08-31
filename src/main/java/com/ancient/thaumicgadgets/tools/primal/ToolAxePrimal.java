package com.ancient.thaumicgadgets.tools.primal;


import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.ICheckEnchantment;
import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import com.ancient.thaumicgadgets.util.IHasModel;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Set;


public class ToolAxePrimal extends ItemTool implements IHasModel, ICheckEnchantment {
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.LADDER, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE, Blocks.WEB);

    private final String name;
    private final int mode;

    public ToolAxePrimal(String name, Item.ToolMaterial material, float damage, float attackSpeed) {
        super(damage, attackSpeed, material, EFFECTIVE_ON);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.GADGETSTAB);

        this.name = name;
        this.mode = 0;

        ModItems.ITEMS.add(this);
    }


    public float getStrVsBlock(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return (material != Material.WOOD && material != Material.PLANTS && material != Material.VINE) ? getStrVsBlock(stack, state) : this.efficiency;
    }


    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }


    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound()) {

            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("mode", this.mode);
            stack.setTagCompound(nbt);
        }

        if (stack.getItemDamage() > 0) {
            setDamage(stack, -1);
        }

        EntityLivingBase entity = (EntityLivingBase) entityIn;

        if (isSelected) {

            int mode = stack.getTagCompound().getInteger("mode");

            if (this.name.equals("sword_primal")) {

                int[] ench = {22, 20, 16, 19, 17, 18};
                int[] level = {4, 3, 6, 3, 6, 6};

                canApplyEchantment(stack, ench[mode], level[mode]);
            } else if (this.name.equals("axe_primal")) {

                if (mode == 0) {
                    entity.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 1));
                }
            }
        }
    }


    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        int mode = 0;

        if (stack.hasTagCompound()) {
            mode = stack.getTagCompound().getInteger("mode");
        }

        tooltip.add("Current Aspect: " + IFunctionLibrary.getAspectFromMode(mode).getChatcolor() + IFunctionLibrary.getAspectFromMode(mode).getName());
    }


    public void changeItemMode(EntityPlayer player, ItemStack stack, int slotId) {
        ToolAxePrimal ar = (ToolAxePrimal) stack.getItem();
        ItemStack is = new ItemStack(stack.getItem());
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("mode", stack.getTagCompound().getInteger("mode") + 1);
        is.setTagCompound(nbt);
        if (is.getTagCompound().getInteger("mode") > 5) {
            is.getTagCompound().setInteger("mode", 0);
        }
        if (stack.getItem() instanceof com.ancient.thaumicgadgets.armor.primal.ArmorPrimalUpgraded) {

            NBTTagList list = stack.getTagCompound().getTagList("primalInventory", 10);
            is.getTagCompound().setTag("primalInventory", list);
        }
        player.inventory.setInventorySlotContents(slotId, is);
    }
}