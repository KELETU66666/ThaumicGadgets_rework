package com.ancient.thaumicgadgets.armor.primal;

import com.ancient.thaumicgadgets.Main;
import com.ancient.thaumicgadgets.util.IFunctionLibrary;
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

import java.util.List;


public class ArmorPrimalUpgraded extends ArmorPrimal {
    public ArmorPrimalUpgraded(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, materialIn, renderIndexIn, equipmentSlotIn);
    }


    public int getMaxItemUseDuration(ItemStack stack) {
        return 1;
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote) {
            if (playerIn.isSneaking()) {
                playerIn.openGui(Main.instance, 2, worldIn, 0, 0, 0);
            } else {

                super.onItemRightClick(worldIn, playerIn, handIn);
            }
        }
        return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItemMainhand());
    }


    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("primalInventory")) {

            NBTTagList list = stack.getTagCompound().getTagList("primalInventory", 10);
            ItemStack st = new ItemStack(list.getCompoundTagAt(0));

            if (!st.getItem().equals(Items.AIR) && st != null) {
                tooltip.add(I18n.format("item.primal_upgraded.description", new Object[0]) + IFunctionLibrary.getAspectFromName(st.getTranslationKey()).getChatcolor() + st.getDisplayName());
            }
        }
    }
}