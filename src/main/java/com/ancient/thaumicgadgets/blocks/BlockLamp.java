 package com.ancient.thaumicgadgets.blocks;

 import com.ancient.thaumicgadgets.init.ModBlocks;
 import com.ancient.thaumicgadgets.objects.machines.lamp.TileEntityLamp;
 import java.util.Random;
 import net.minecraft.block.ITileEntityProvider;
 import net.minecraft.block.SoundType;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.tileentity.TileEntity;
 import net.minecraft.util.BlockRenderLayer;
 import net.minecraft.util.EnumBlockRenderType;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 import net.minecraftforge.client.model.ModelLoader;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;




 public class BlockLamp
   extends BlockBase
   implements ITileEntityProvider
 {
   private final String name;

   public BlockLamp(String name) {
/* 32 */     super(name, Material.GLASS);

/* 34 */     this.name = name;
/* 35 */     setSoundType(SoundType.GLASS);
/* 36 */     setHardness(4.0F);
/* 37 */     setResistance(30.0F);
/* 38 */     setLightOpacity(1);
/* 39 */     setLightLevel(0.5F);
/* 40 */     setHarvestLevel("pickaxe", 0);
   }




   public TileEntity createNewTileEntity(World worldIn, int meta) {
/* 47 */     return (TileEntity)new TileEntityLamp();
   }



   public Item getItemDropped(IBlockState state, Random rand, int fortune) {
/* 53 */     return Item.getItemFromBlock(ModBlocks.LAMP);
   }



   public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
/* 59 */     return new ItemStack(ModBlocks.LAMP);
   }



   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 65 */     return EnumBlockRenderType.MODEL;
   }


   @SideOnly(Side.CLIENT)
   public BlockRenderLayer getRenderLayer() {
/* 71 */     return BlockRenderLayer.TRANSLUCENT;
   }



   public boolean isOpaqueCube(IBlockState state) {
/* 77 */     return false;
   }



   public boolean isFullCube(IBlockState state) {
/* 83 */     return false;
   }



   public void registerModels() {
/* 89 */     ModelResourceLocation itemModel = new ModelResourceLocation("tg:" + this.name + ".obj");

/* 91 */     ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, itemModel);
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\blocks\BlockLamp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */