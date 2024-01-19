package com.ancient.thaumicgadgets.blocks;

import com.ancient.thaumicgadgets.init.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;


public class BlockPlaceholder extends BlockBase
{
    private Item drop;

    public BlockPlaceholder(String name, Material material, Item drop, int count, SoundType sound, float hard, float res, int lightOp, String inst, int lvl) {
        super(name, material);

        setCreativeTab(null);
        setSoundType(sound);
        setHardness(hard);
        setResistance(res);
        setLightOpacity(lightOp);
        setHarvestLevel(inst, lvl);
        this.drop = drop;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if ((state.getBlock() instanceof BlockPlaceholder) && !BlockBlastFurnace.ignoreDestroy && !worldIn.isRemote) {
            this.destroyFurnace(worldIn, pos);
        }
        super.breakBlock(worldIn, pos, state);
    }

    private void destroyFurnace(World worldIn, BlockPos pos) {
        for (int i = -1; i <= 1; i++) {
             for (int j = -1; j <= 1; j++) {
                 for (int k = -1; k <= 1; k++) {
                     BlockPos targetPos = pos.add(i, j, k);
                     IBlockState targetState = worldIn.getBlockState(targetPos);
                     if (targetState.getBlock() == ModBlocks.FURNACE) {
                         BlockBlastFurnace.destroyFurnace(worldIn, targetPos, targetState, pos);
                         return;
                     }
                 }
             }
         }
     }
   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 38 */     return EnumBlockRenderType.INVISIBLE;
   }

    @Override
    @SuppressWarnings("deprecation")
    public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState)
    {
        if (entity != null && (!(entity instanceof EntityItem) || !(world.getBlockState(pos) == ModBlocks.AIR_PH.getDefaultState())))
            super.addCollisionBoxToList(state, world, pos, entityBox, collidingBoxes, entity, isActualState);
    }

   public boolean isOpaqueCube(IBlockState state) {
/* 50 */     return false;
   }
   public boolean isFullCube(IBlockState state) {
/* 56 */     return false;
   }
   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 62 */     return this.drop;
   }
   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/* 68 */     return new ItemStack(this.drop);
   }
}