/*     */ package com.ancient.thaumicgadgets.blocks;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.Main;
/*     */ import com.ancient.thaumicgadgets.init.ModBlocks;
/*     */ import com.ancient.thaumicgadgets.objects.machines.spinningwheel.TileEntitySpinningWheel;
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
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockSpinningWheel
/*     */   extends BlockBase
/*     */   implements ITileEntityProvider
/*     */ {
/*  42 */   public static final PropertyDirection FACING = BlockHorizontal.FACING;
/*     */   
/*  44 */   public static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
/*     */ 
/*     */   
/*     */   public BlockSpinningWheel(String name) {
/*  48 */     super(name, Material.WOOD);
/*  49 */     setSoundType(SoundType.WOOD);
/*  50 */     setHardness(2.5F);
/*  51 */     setResistance(30.0F);
/*  52 */     setLightOpacity(1);
/*  53 */     setHarvestLevel("axe", 0);
/*  54 */     setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/*  60 */     return Item.getItemFromBlock(ModBlocks.SPINNING_WHEEL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/*  66 */     return new ItemStack(ModBlocks.SPINNING_WHEEL);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/*  72 */     if (!worldIn.isRemote)
/*     */     {
/*  74 */       playerIn.openGui(Main.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
/*     */     }
/*     */     
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
/*  83 */     if (!worldIn.isRemote) {
/*     */       
/*  85 */       IBlockState north = worldIn.getBlockState(pos.north());
/*  86 */       IBlockState south = worldIn.getBlockState(pos.south());
/*  87 */       IBlockState east = worldIn.getBlockState(pos.east());
/*  88 */       IBlockState west = worldIn.getBlockState(pos.west());
/*  89 */       EnumFacing face = (EnumFacing)state.getValue((IProperty)FACING);
/*     */       
/*  91 */       if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {
/*     */         
/*  93 */         face = EnumFacing.SOUTH;
/*     */       }
/*  95 */       else if (face == EnumFacing.SOUTH && !north.isFullBlock() && south.isFullBlock()) {
/*     */         
/*  97 */         face = EnumFacing.NORTH;
/*     */       }
/*  99 */       else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {
/*     */         
/* 101 */         face = EnumFacing.EAST;
/*     */       }
/* 103 */       else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {
/*     */         
/* 105 */         face = EnumFacing.WEST;
/*     */       } 
/* 107 */       worldIn.setBlockState(pos, state.withProperty((IProperty)FACING, (Comparable)face), 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setState(World worldIn, BlockPos pos) {
/* 113 */     IBlockState state = worldIn.getBlockState(pos);
/* 114 */     TileEntity te = worldIn.getTileEntity(pos);
/*     */ 
/*     */     
/* 117 */     worldIn.setBlockState(pos, ModBlocks.SPINNING_WHEEL.getDefaultState().withProperty((IProperty)FACING, state.getValue((IProperty)FACING)));
/*     */     
/* 119 */     if (te != null) {
/*     */       
/* 121 */       te.validate();
/* 122 */       worldIn.setTileEntity(pos, te);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
/* 129 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
/* 135 */     worldIn.setBlockState(pos, getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite()), 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
/* 141 */     TileEntitySpinningWheel tileentity = (TileEntitySpinningWheel)worldIn.getTileEntity(pos);
/* 142 */     InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
/*     */     
/* 144 */     super.breakBlock(worldIn, pos, state);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 150 */     return EnumBlockRenderType.MODEL;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer getRenderLayer() {
/* 156 */     return BlockRenderLayer.SOLID;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withRotation(IBlockState state, Rotation rot) {
/* 163 */     return state.withProperty((IProperty)FACING, (Comparable)rot.rotate((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
/* 169 */     return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockStateContainer createBlockState() {
/* 175 */     return new BlockStateContainer(this, new IProperty[] { (IProperty)FACING });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateFromMeta(int meta) {
/* 181 */     EnumFacing facing = EnumFacing.getFront(meta);
/*     */     
/* 183 */     if (facing.getAxis() == EnumFacing.Axis.Y)
/*     */     {
/* 185 */       facing = EnumFacing.NORTH;
/*     */     }
/* 187 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)facing);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMetaFromState(IBlockState state) {
/* 194 */     return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/* 200 */     return (TileEntity)new TileEntitySpinningWheel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube(IBlockState state) {
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullCube(IBlockState state) {
/* 212 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
/* 218 */     return AABB;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockSpinningWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */