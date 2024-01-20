 package com.ancient.thaumicgadgets.armor.primal;

 import com.ancient.thaumicgadgets.Main;
 import com.ancient.thaumicgadgets.util.IFunctionLibrary;
 import java.util.List;
 import net.minecraft.client.resources.I18n;
 import net.minecraft.client.util.ITooltipFlag;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.init.Items;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.nbt.NBTTagList;
 import net.minecraft.util.ActionResult;
 import net.minecraft.util.EnumActionResult;
 import net.minecraft.util.EnumHand;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;





 public class ArmorPrimalUpgraded
   extends ArmorPrimal
 {
   public ArmorPrimalUpgraded(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
/* 29 */     super(name, materialIn, renderIndexIn, equipmentSlotIn);
   }



   public int getMaxItemUseDuration(ItemStack stack) {
/* 35 */     return 1;
   }



   public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
/* 41 */     if (!worldIn.isRemote)
     {
/* 43 */       if (playerIn.isSneaking()) {

/* 45 */         playerIn.openGui(Main.instance, 2, worldIn, 0, 0, 0);
       }
       else {

/* 49 */         super.onItemRightClick(worldIn, playerIn, handIn);
       }
     }
/* 52 */     return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItemMainhand());
   }



   @SideOnly(Side.CLIENT)
   public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
/* 59 */     super.addInformation(stack, worldIn, tooltip, flagIn);

/* 61 */     if (stack.hasTagCompound() && stack.getTagCompound().hasKey("primalInventory")) {

/* 63 */       NBTTagList list = stack.getTagCompound().getTagList("primalInventory", 10);
/* 64 */       ItemStack st = new ItemStack(list.getCompoundTagAt(0));

/* 66 */       if (!st.getItem().equals(Items.AIR) && st != null)
       {
/* 68 */         tooltip.add(I18n.format("item.primal_upgraded.description", new Object[0]) + IFunctionLibrary.getAspectFromName(st.getTranslationKey()).getChatcolor() + st.getDisplayName());
       }
     }
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\primal\ArmorPrimalUpgraded.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */