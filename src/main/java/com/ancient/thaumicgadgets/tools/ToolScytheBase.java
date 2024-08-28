package com.ancient.thaumicgadgets.tools;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.init.ModItems;
import com.ancient.thaumicgadgets.util.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ToolScytheBase extends ItemSpade implements IHasModel {
    private final int xSize;
    private final int ySize;
    private final int zSize;

    public ToolScytheBase(String name, Item.ToolMaterial material, int xSize, int ySize, int zSize) {
        super(material);

        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(Main.GADGETSTAB);

        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;

        ModItems.ITEMS.add(this);
    }


    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!player.world.isRemote) {

            if (!player.isCreative()) {

                ItemStack stack = player.getHeldItemMainhand();
                stack.damageItem(5, player);
            }
            Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(this.xSize, this.ySize, this.zSize), pos.add(-this.xSize, -this.ySize, -this.zSize));
            for (BlockPos p : blocks) {

                IBlockState state = player.world.getBlockState(p);
                if (state.getBlock() instanceof net.minecraft.block.BlockLeaves || state.getMaterial() == Material.LEAVES || state.getBlock() instanceof net.minecraft.block.BlockWeb || state.getBlock() instanceof net.minecraft.block.BlockFlower || state.getBlock() instanceof net.minecraft.block.BlockTallGrass || state.getBlock() instanceof net.minecraft.block.BlockDoublePlant || state.getBlock() instanceof thaumcraft.common.blocks.world.plants.BlockLeavesTC || state.getBlock() instanceof net.minecraft.block.BlockBush) {
                    player.world.destroyBlock(p, true);
                }
            }
        }
        return EnumActionResult.SUCCESS;
    }


    public boolean canHarvestBlock(IBlockState state) {
        return (state.getBlock() instanceof net.minecraft.block.BlockLeaves || state.getMaterial() == Material.LEAVES || state.getBlock() instanceof net.minecraft.block.BlockWeb || state.getBlock() instanceof net.minecraft.block.BlockFlower || state.getBlock() instanceof net.minecraft.block.BlockTallGrass || state.getBlock() instanceof net.minecraft.block.BlockDoublePlant || state.getBlock() instanceof thaumcraft.common.blocks.world.plants.BlockLeavesTC || state.getBlock() instanceof net.minecraft.block.BlockBush);
    }


    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        return 1.0F;
    }


    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}