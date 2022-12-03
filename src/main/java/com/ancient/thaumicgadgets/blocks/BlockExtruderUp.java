/*     */ package com.ancient.thaumicgadgets.blocks;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.init.ModBlocks;
/*     */ import com.ancient.thaumicgadgets.network.MessageClientExtruderUp;
/*     */ import com.ancient.thaumicgadgets.objects.machines.extruder.TileEntityExtruderUp;
/*     */ import com.ancient.thaumicgadgets.util.IHasModel;
/*     */ import com.ancient.thaumicgadgets.util.handlers.NetworkHandler;
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
/*     */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockExtruderUp
/*     */   extends BlockBase
/*     */   implements ITileEntityProvider, IHasModel {
/*  38 */   public static final PropertyDirection FACING = BlockHorizontal.FACING;
/*     */ 
/*     */   
/*     */   public BlockExtruderUp(String name) {
/*  42 */     super(name, Material.WOOD);
/*     */     
/*  44 */     setSoundType(SoundType.WOOD);
/*  45 */     setHardness(2.5F);
/*  46 */     setResistance(30.0F);
/*  47 */     setLightOpacity(1);
/*  48 */     setLightLevel(0.4F);
/*  49 */     setHarvestLevel("axe", 0);
/*     */     
/*  51 */     setDefaultState(this.blockState.getBaseState().withProperty((IProperty)FACING, (Comparable)EnumFacing.NORTH));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/*  57 */     if (!worldIn.isRemote) {
/*     */       
/*  59 */       TileEntity te = worldIn.getTileEntity(pos);
/*  60 */       if (te instanceof TileEntityExtruderUp) {
/*     */         
/*  62 */         TileEntityExtruderUp teu = (TileEntityExtruderUp)te;
/*  63 */         teu.setField(2, teu.getField(2) + 1);
/*  64 */         if (teu.getField(2) > 2)
/*     */         {
/*  66 */           teu.setField(2, 0);
/*     */         }
/*  68 */         NetworkHandler.sendToAllNearby((IMessage)new MessageClientExtruderUp(teu.getField(2), teu), new NetworkRegistry.TargetPoint((teu.getWorld()).provider.getDimension(), teu.getPos().getX(), teu.getPos().getY(), teu.getPos().getZ(), 50.0D));
/*  69 */         return true;
/*     */       } 
/*     */     } 
/*  72 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/*  78 */     return (TileEntity)new TileEntityExtruderUp();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/*  84 */     return Item.getItemFromBlock(ModBlocks.EXTRUDER_UP);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/*  90 */     return new ItemStack(ModBlocks.EXTRUDER_UP);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
/*  96 */     if (!worldIn.isRemote) {
/*     */       
/*  98 */       IBlockState north = worldIn.getBlockState(pos.north());
/*  99 */       IBlockState south = worldIn.getBlockState(pos.south());
/* 100 */       IBlockState east = worldIn.getBlockState(pos.east());
/* 101 */       IBlockState west = worldIn.getBlockState(pos.west());
/* 102 */       EnumFacing face = (EnumFacing)state.getValue((IProperty)FACING);
/*     */       
/* 104 */       if (face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) {
/*     */         
/* 106 */         face = EnumFacing.SOUTH;
/*     */       }
/* 108 */       else if (face == EnumFacing.SOUTH && !north.isFullBlock() && south.isFullBlock()) {
/*     */         
/* 110 */         face = EnumFacing.NORTH;
/*     */       }
/* 112 */       else if (face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) {
/*     */         
/* 114 */         face = EnumFacing.EAST;
/*     */       }
/* 116 */       else if (face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) {
/*     */         
/* 118 */         face = EnumFacing.WEST;
/*     */       } 
/* 120 */       worldIn.setBlockState(pos, state.withProperty((IProperty)FACING, (Comparable)face), 2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setState(World worldIn, BlockPos pos) {
/* 126 */     IBlockState state = worldIn.getBlockState(pos);
/* 127 */     TileEntity te = worldIn.getTileEntity(pos);
/*     */ 
/*     */     
/* 130 */     worldIn.setBlockState(pos, ModBlocks.EXTRUDER.getDefaultState().withProperty((IProperty)FACING, state.getValue((IProperty)FACING)));
/*     */     
/* 132 */     if (te != null) {
/*     */       
/* 134 */       te.validate();
/* 135 */       worldIn.setTileEntity(pos, te);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
/* 142 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
/* 148 */     worldIn.setBlockState(pos, getDefaultState().withProperty((IProperty)FACING, (Comparable)placer.getHorizontalFacing().getOpposite()), 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
/* 155 */     super.breakBlock(worldIn, pos, state);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withRotation(IBlockState state, Rotation rot) {
/* 161 */     return state.withProperty((IProperty)FACING, (Comparable)rot.rotate((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
/* 167 */     return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue((IProperty)FACING)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IBlockState getStateFromMeta(int meta) {
/* 173 */     EnumFacing face = EnumFacing.getFront(meta);
/* 174 */     if (face.getAxis() == EnumFacing.Axis.Y)
/*     */     {
/* 176 */       face = EnumFacing.NORTH;
/*     */     }
/* 178 */     return getDefaultState().withProperty((IProperty)FACING, (Comparable)face);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMetaFromState(IBlockState state) {
/* 184 */     return ((EnumFacing)state.getValue((IProperty)FACING)).getIndex();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected BlockStateContainer createBlockState() {
/* 190 */     return new BlockStateContainer(this, new IProperty[] { (IProperty)FACING });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 196 */     return EnumBlockRenderType.MODEL;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public BlockRenderLayer getRenderLayer() {
/* 202 */     return BlockRenderLayer.SOLID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaqueCube(IBlockState state) {
/* 208 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFullCube(IBlockState state) {
/* 214 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockExtruderUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */