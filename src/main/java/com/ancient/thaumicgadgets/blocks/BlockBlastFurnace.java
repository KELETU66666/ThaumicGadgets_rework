/*     */ package com.ancient.thaumicgadgets.blocks;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.Main;
/*     */ import com.ancient.thaumicgadgets.init.ModBlocks;
/*     */ import com.ancient.thaumicgadgets.init.ModMultiBlocks;
/*     */ import com.ancient.thaumicgadgets.objects.machines.blastfurnace.TileEntityBlastFurnace;
/*     */ import com.ancient.thaumicgadgets.util.ICheckMultiBlock;
/*     */ import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.BlockHorizontal;
/*     */ import net.minecraft.block.ITileEntityProvider;
/*     */ import net.minecraft.block.SoundType;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyDirection;
/*     */ import net.minecraft.block.state.BlockStateContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockRenderLayer;
/*     */ import net.minecraft.util.EnumBlockRenderType;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.Mirror;
/*     */ import net.minecraft.util.Rotation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
import thaumcraft.common.blocks.IBlockFacingHorizontal;
import thaumcraft.common.lib.utils.BlockStateUtils;

/*     */
/*     */ public class BlockBlastFurnace
/*     */   extends BlockBase
/*     */   implements ITileEntityProvider ,IBlockFacingHorizontal{
    public static boolean ignoreDestroy = false;
/*  37 */   public static final PropertyDirection FACING = BlockHorizontal.FACING;
/*     */
/*     */   
/*     */   public BlockBlastFurnace(String name) {
/*  41 */     super(name, Material.ROCK);
/*     */     
/*  43 */     setSoundType(SoundType.STONE);
/*  44 */     setHardness(4.0F);
/*  45 */     setResistance(30.0F);
/*  46 */     setLightOpacity(1);
/*  47 */     setHarvestLevel("pickaxe", 3);
/*  48 */     setLightLevel(1.0F);
/*     */  }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
/*  56 */     if (!worldIn.isRemote)
/*     */     {
/*  58 */       ICheckMultiBlock.demorphMultiBlockStatic(worldIn, ((ModMultiBlocks.MBHeading)Main.MMB.getMultiBlockRecipeList().get(EnumHandler.MultiBlocks.BLAST_FURNACE.getName())).recipe, pos);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
/*  65 */     if (!worldIn.isRemote)
/*     */     {
/*  67 */       ICheckMultiBlock.demorphMultiBlockStatic(worldIn, ((ModMultiBlocks.MBHeading)Main.MMB.getMultiBlockRecipeList().get(EnumHandler.MultiBlocks.BLAST_FURNACE.getName())).recipe, pos);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/*  74 */     return (TileEntity)new TileEntityBlastFurnace();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/*  80 */     return Item.getItemFromBlock(ModBlocks.FURNACE);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/*  86 */     return new ItemStack(ModBlocks.FURNACE);
/*     */   }
/*     */

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        destroyFurnace(worldIn, pos, state, pos);
        super.breakBlock(worldIn, pos, state);
    }



    public static void destroyFurnace(World world, BlockPos pos, IBlockState state, BlockPos startPos) {
        if (ignoreDestroy || world.isRemote) {
            return;
        }
        ignoreDestroy = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    BlockPos blockPos = pos.add(i, j, k);
                    if (blockPos != startPos) {
                        IBlockState bs = world.getBlockState(blockPos);
                        if (bs.getBlock() == ModBlocks.OBSIDIAN_PH) {
                            world.setBlockState(blockPos, Blocks.OBSIDIAN.getDefaultState());
                        } else if (bs.getBlock() == ModBlocks.SOUL_SAND_PH) {
                            world.setBlockState(blockPos, Blocks.SOUL_SAND.getDefaultState());
                        } else if (bs.getBlock() == ModBlocks.NETHER_BRICKS_PH)
                        {
                            world.setBlockState(blockPos, Blocks.NETHER_BRICK.getDefaultState());
                        }
                    }
                }
            }
        }
        world.setBlockState(pos, Blocks.SOUL_SAND.getDefaultState());
        ignoreDestroy = false;
    }
/*     */   
/*     */   @Override
public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
    IBlockState bs = getDefaultState();
    bs = bs.withProperty(IBlockFacingHorizontal.FACING, placer.getHorizontalFacing().getOpposite());
    return bs;
}
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
/* 144 */     worldIn.setBlockState(pos, getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite()), 2);
/*     */   }
/*     */
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withRotation(IBlockState state, Rotation rot) {
/* 157 */     return state.withProperty((IProperty)FACING, (Comparable)rot.rotate((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
/* 163 */     return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateFromMeta(int meta) {
/* 169 */     EnumFacing face = EnumFacing.getFront(meta);
/* 170 */     if (face.getAxis() == EnumFacing.Axis.Y)
/*     */     {
/* 172 */       face = EnumFacing.NORTH;
/*     */     }
/* 174 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)face);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMetaFromState(IBlockState state) {
/* 180 */     return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockStateContainer createBlockState() {
/* 186 */     return new BlockStateContainer(this, new IProperty[] { (IProperty)FACING });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 192 */     return EnumBlockRenderType.MODEL;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer getRenderLayer() {
/* 198 */     return BlockRenderLayer.SOLID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube(IBlockState state) {
/* 204 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullCube(IBlockState state) {
/* 210 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockBlastFurnace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */