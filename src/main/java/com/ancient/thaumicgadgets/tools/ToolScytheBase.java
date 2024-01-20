 package com.ancient.thaumicgadgets.tools;
 
 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.init.ModItems;
 import com.ancient.thaumicgadgets.util.IHasModel;
 import net.minecraft.block.Block;
 import net.minecraft.block.material.Material;
 import net.minecraft.block.state.IBlockState;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemSpade;
 import net.minecraft.item.ItemStack;
 import net.minecraft.util.EnumActionResult;
 import net.minecraft.util.EnumFacing;
 import net.minecraft.util.EnumHand;
 import net.minecraft.util.math.BlockPos;
 import net.minecraft.world.World;
 
 
 
 
 
 
 
 public class ToolScytheBase
   extends ItemSpade
   implements IHasModel
 {
   private final int xSize;
   private final int ySize;
   private final int zSize;
   
   public ToolScytheBase(String name, Item.ToolMaterial material, int xSize, int ySize, int zSize) {
/* 35 */     super(material);
     
/* 37 */     setTranslationKey(name);
/* 38 */     setRegistryName(name);
/* 39 */     setCreativeTab(Main.GADGETSTAB);
     
/* 41 */     this.xSize = xSize;
/* 42 */     this.ySize = ySize;
/* 43 */     this.zSize = zSize;
     
/* 45 */     ModItems.ITEMS.add(this);
   }
 
 
   
   public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 51 */     if (!player.world.isRemote) {
       
/* 53 */       if (!player.isCreative()) {
         
/* 55 */         ItemStack stack = player.getHeldItemMainhand();
/* 56 */         stack.damageItem(5, (EntityLivingBase)player);
       } 
/* 58 */       Iterable<BlockPos> blocks = BlockPos.getAllInBox(pos.add(this.xSize, this.ySize, this.zSize), pos.add(-this.xSize, -this.ySize, -this.zSize));
/* 59 */       for (BlockPos p : blocks) {
         
/* 61 */         IBlockState state = player.world.getBlockState(p);
/* 62 */         if (state.getBlock() instanceof net.minecraft.block.BlockLeaves || state.getMaterial() == Material.LEAVES || state.getBlock() instanceof net.minecraft.block.BlockWeb || state.getBlock() instanceof net.minecraft.block.BlockFlower || state.getBlock() instanceof net.minecraft.block.BlockTallGrass || state.getBlock() instanceof net.minecraft.block.BlockDoublePlant || state.getBlock() instanceof thaumcraft.common.blocks.world.plants.BlockLeavesTC || state.getBlock() instanceof net.minecraft.block.BlockBush)
         {
/* 64 */           player.world.destroyBlock(p, true);
         }
       } 
     } 
/* 68 */     return EnumActionResult.SUCCESS;
   }
 
 
   
   public boolean canHarvestBlock(IBlockState state) {
/* 74 */     Block bl = state.getBlock();
/* 75 */     return (state.getBlock() instanceof net.minecraft.block.BlockLeaves || state.getMaterial() == Material.LEAVES || state.getBlock() instanceof net.minecraft.block.BlockWeb || state.getBlock() instanceof net.minecraft.block.BlockFlower || state.getBlock() instanceof net.minecraft.block.BlockTallGrass || state.getBlock() instanceof net.minecraft.block.BlockDoublePlant || state.getBlock() instanceof thaumcraft.common.blocks.world.plants.BlockLeavesTC || state.getBlock() instanceof net.minecraft.block.BlockBush);
   }
 
 
   
   public float getDestroySpeed(ItemStack stack, IBlockState state) {
/* 81 */     return 1.0F;
   }
 
 
   
   public void registerModels() {
/* 87 */     Main.proxy.registerItemRenderer((Item)this, 0, "inventory");
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\ToolScytheBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */