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
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Set;

public class ToolPickaxePrimal extends ItemTool implements IHasModel, ICheckEnchantment {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE);

    private final String name;
    private final int mode;

    public ToolPickaxePrimal(String name, ToolMaterial material, float damage, float attackSpeed) {
        super(damage, attackSpeed, material, EFFECTIVE_ON);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.GADGETSTAB);

        this.name = name;
        this.mode = 0;

        ModItems.ITEMS.add(this);
    }

    public boolean canHarvestBlock(IBlockState state) {
        Block block = state.getBlock();
        if (block == Blocks.OBSIDIAN) {
            return this.toolMaterial.getHarvestLevel() == 3;
        } else if (block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE) {
            if (block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK) {
                if (block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE) {
                    if (block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE) {
                        if (block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE) {
                            if (block != Blocks.REDSTONE_ORE && block != Blocks.LIT_REDSTONE_ORE) {
                                Material mat = state.getMaterial();
                                if (mat == Material.ROCK) {
                                    return true;
                                } else if (mat == Material.IRON) {
                                    return true;
                                } else {
                                    return mat == Material.ANVIL;
                                }
                            } else {
                                return this.toolMaterial.getHarvestLevel() >= 2;
                            }
                        } else {
                            return this.toolMaterial.getHarvestLevel() >= 1;
                        }
                    } else {
                        return this.toolMaterial.getHarvestLevel() >= 1;
                    }
                } else {
                    return this.toolMaterial.getHarvestLevel() >= 2;
                }
            } else {
                return this.toolMaterial.getHarvestLevel() >= 2;
            }
        } else {
            return this.toolMaterial.getHarvestLevel() >= 2;
        }
    }

    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        Material mat = state.getMaterial();
        return mat != Material.IRON && mat != Material.ANVIL && mat != Material.ROCK ? super.getDestroySpeed(stack, state) : this.efficiency;
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
        ToolPickaxePrimal ar = (ToolPickaxePrimal) stack.getItem();
        ItemStack is = new ItemStack(stack.getItem());
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("mode", stack.getTagCompound().getInteger("mode") + 1);
        is.setTagCompound(nbt);
        if (is.getTagCompound().getInteger("mode") > 5) {
            is.getTagCompound().setInteger("mode", 0);
        }
        player.inventory.setInventorySlotContents(slotId, is);
    }
}