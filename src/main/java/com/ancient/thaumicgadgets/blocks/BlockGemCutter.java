/*     */ package com.ancient.thaumicgadgets.blocks;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.Main;
/*     */ import com.ancient.thaumicgadgets.init.ModBlocks;
/*     */ import com.ancient.thaumicgadgets.objects.machines.gemcutter.TileEntityGemCutter;
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
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryHelper;
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
/*     */ public class BlockGemCutter
/*     */   extends BlockBase
/*     */   implements ITileEntityProvider
/*     */ {
/*  38 */   public static final PropertyDirection FACING = BlockHorizontal.FACING;
/*     */ 
/*     */   
/*     */   public BlockGemCutter(String name) {
/*  42 */     super(name, Material.WOOD);
/*     */     
/*  44 */     setSoundType(SoundType.WOOD);
/*  45 */     setHardness(2.5F);
/*  46 */     setResistance(30.0F);
/*  47 */     setLightOpacity(1);
/*  48 */     setHarvestLevel("axe", 0);
/*     */     
/*  50 */     setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH));
/*     */   }
/*     */ 
/*     */   
/*     */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/*  55 */     return (TileEntity)new TileEntityGemCutter();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/*  61 */     return Item.getItemFromBlock(ModBlocks.GEMCUTTER);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/*  67 */     return new ItemStack(ModBlocks.GEMCUTTER);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/*  73 */     if (!worldIn.isRemote)
/*     */     {
/*  75 */       playerIn.openGui(Main.instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
/*     */     }
/*     */     
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
/*  84 */     TileEntityGemCutter tileentity = (TileEntityGemCutter)worldIn.getTileEntity(pos);
/*  85 */     InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
/*     */     
/*  87 */     super.breakBlock(worldIn, pos, state);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumBlockRenderType getRenderType(IBlockState state) {
/*  93 */     return EnumBlockRenderType.MODEL;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer getRenderLayer() {
/*  99 */     return BlockRenderLayer.SOLID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube(IBlockState state) {
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullCube(IBlockState state) {
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
/* 117 */     if (!worldIn.isRemote) {
/*     */       
/* 119 */       IBlockState north = worldIn.getBlockState(pos.north());
/* 120 */       IBlockState south = worldIn.getBlockState(pos.south());
/* 121 */       IBlockState east = worldIn.getBlockState(pos.east());
/* 122 */       IBlockState west = worldIn.getBlockState(pos.west());
/* 123 */       EnumFacing face = (EnumFacing)state.getValue((IProperty)FACING);
/*     */       
/* 125 */       if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {
/*     */         
/* 127 */         face = EnumFacing.SOUTH;
/*     */       }
/* 129 */       else if (face == EnumFacing.SOUTH && !north.isFullBlock() && south.isFullBlock()) {
/*     */         
/* 131 */         face = EnumFacing.NORTH;
/*     */       }
/* 133 */       else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {
/*     */         
/* 135 */         face = EnumFacing.EAST;
/*     */       }
/* 137 */       else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {
/*     */         
/* 139 */         face = EnumFacing.WEST;
/*     */       } 
/* 141 */       worldIn.setBlockState(pos, state.withProperty((IProperty)FACING, (Comparable)face), 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setState(World worldIn, BlockPos pos) {
/* 147 */     IBlockState state = worldIn.getBlockState(pos);
/* 148 */     TileEntity te = worldIn.getTileEntity(pos);
/*     */ 
/*     */     
/* 151 */     worldIn.setBlockState(pos, ModBlocks.GEMCUTTER.getDefaultState().withProperty((IProperty)FACING, state.getValue((IProperty)FACING)));
/*     */     
/* 153 */     if (te != null) {
/*     */       
/* 155 */       te.validate();
/* 156 */       worldIn.setTileEntity(pos, te);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
/* 163 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
/* 169 */     worldIn.setBlockState(pos, getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite()), 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withRotation(IBlockState state, Rotation rot) {
/* 175 */     return state.withProperty((IProperty)FACING, (Comparable)rot.rotate((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
/* 181 */     return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateFromMeta(int meta) {
/* 187 */     EnumFacing face = EnumFacing.getFront(meta);
/* 188 */     if (face.getAxis() == EnumFacing.Axis.Y)
/*     */     {
/* 190 */       face = EnumFacing.NORTH;
/*     */     }
/* 192 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)face);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMetaFromState(IBlockState state) {
/* 198 */     return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockStateContainer createBlockState() {
/* 204 */     return new BlockStateContainer(this, new IProperty[] { (IProperty)FACING });
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockGemCutter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */