/*     */ package com.ancient.thaumicgadgets.blocks;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.init.ModBlocks;
/*     */ import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruder;
/*     */ import com.ancient.thaumicgadgets.util.IHasModel;
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
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockRenderLayer;
/*     */ import net.minecraft.util.EnumBlockRenderType;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.Mirror;
/*     */ import net.minecraft.util.Rotation;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ public class BlockExtruder
/*     */   extends BlockBase
/*     */   implements ITileEntityProvider, IHasModel
/*     */ {
/*  35 */   public static final PropertyDirection FACING = BlockHorizontal.FACING;
/*     */ 
/*     */   
/*     */   public BlockExtruder(String name) {
/*  39 */     super(name, Material.WOOD);
/*     */     
/*  41 */     setSoundType(SoundType.WOOD);
/*  42 */     setHardness(2.5F);
/*  43 */     setResistance(30.0F);
/*  44 */     setLightOpacity(1);
/*  45 */     setLightLevel(0.4F);
/*  46 */     setHarvestLevel("axe", 0);
/*     */     
/*  48 */     setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/*  54 */     return (TileEntity)new TileEntityExtruder();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/*  60 */     return Item.getItemFromBlock(ModBlocks.EXTRUDER);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/*  66 */     return new ItemStack(ModBlocks.EXTRUDER);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
/*  72 */     if (!worldIn.isRemote) {
/*     */       
/*  74 */       IBlockState north = worldIn.getBlockState(pos.north());
/*  75 */       IBlockState south = worldIn.getBlockState(pos.south());
/*  76 */       IBlockState east = worldIn.getBlockState(pos.east());
/*  77 */       IBlockState west = worldIn.getBlockState(pos.west());
/*  78 */       EnumFacing face = (EnumFacing)state.getValue((IProperty)FACING);
/*     */       
/*  80 */       if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {
/*     */         
/*  82 */         face = EnumFacing.SOUTH;
/*     */       }
/*  84 */       else if (face == EnumFacing.SOUTH && !north.isFullBlock() && south.isFullBlock()) {
/*     */         
/*  86 */         face = EnumFacing.NORTH;
/*     */       }
/*  88 */       else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {
/*     */         
/*  90 */         face = EnumFacing.EAST;
/*     */       }
/*  92 */       else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {
/*     */         
/*  94 */         face = EnumFacing.WEST;
/*     */       } 
/*  96 */       worldIn.setBlockState(pos, state.withProperty((IProperty)FACING, (Comparable)face), 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setState(World worldIn, BlockPos pos) {
/* 102 */     IBlockState state = worldIn.getBlockState(pos);
/* 103 */     TileEntity te = worldIn.getTileEntity(pos);
/*     */ 
/*     */     
/* 106 */     worldIn.setBlockState(pos, ModBlocks.EXTRUDER.getDefaultState().withProperty((IProperty)FACING, state.getValue((IProperty)FACING)));
/*     */     
/* 108 */     if (te != null) {
/*     */       
/* 110 */       te.validate();
/* 111 */       worldIn.setTileEntity(pos, te);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
/* 118 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
/* 124 */     worldIn.setBlockState(pos, getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite()), 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
/* 130 */     TileEntityExtruder te = (TileEntityExtruder)worldIn.getTileEntity(pos);
/* 131 */     super.breakBlock(worldIn, pos, state);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withRotation(IBlockState state, Rotation rot) {
/* 137 */     return state.withProperty((IProperty)FACING, (Comparable)rot.rotate((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
/* 143 */     return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateFromMeta(int meta) {
/* 149 */     EnumFacing face = EnumFacing.getFront(meta);
/* 150 */     if (face.getAxis() == EnumFacing.Axis.Y)
/*     */     {
/* 152 */       face = EnumFacing.NORTH;
/*     */     }
/* 154 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)face);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMetaFromState(IBlockState state) {
/* 160 */     return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockStateContainer createBlockState() {
/* 166 */     return new BlockStateContainer(this, new IProperty[] { (IProperty)FACING });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 172 */     return EnumBlockRenderType.MODEL;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer getRenderLayer() {
/* 178 */     return BlockRenderLayer.SOLID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube(IBlockState state) {
/* 184 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullCube(IBlockState state) {
/* 190 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockExtruder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */