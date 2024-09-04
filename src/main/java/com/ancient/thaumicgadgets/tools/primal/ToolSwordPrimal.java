package com.ancient.thaumicgadgets.tools.primal;


import com.ancient.thaumicgadgets.tools.ToolSwordBase;
import com.ancient.thaumicgadgets.util.ICheckEnchantment;
import com.ancient.thaumicgadgets.util.IFunctionLibrary;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;


public class ToolSwordPrimal extends ToolSwordBase implements ICheckEnchantment {
    private final float damage;
    private final float speed;
    private final int mode;
    private final String name;

    public ToolSwordPrimal(String name, Item.ToolMaterial material, float damage, float speed) {
        super(name, material);

        this.damage = damage;
        this.speed = speed;
        this.name = name;
        this.mode = 0;
    }


    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound()) {

            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("mode", this.mode);
            stack.setTagCompound(nbt);
        }

        if (stack.getItemDamage() > 0) {
            setDamage(stack, -1);
        }

        if (isSelected) {

            int mode = stack.getTagCompound().getInteger("mode");

            if (this.name.equals("sword_primal")) {

                int[] ench = {22, 20, 16, 19, 17, 18};
                int[] level = {4, 3, 6, 3, 6, 6};

                canApplyEchantment(stack, ench[mode], level[mode]);
            }
        }
    }


    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        int mode = 0;

        if (stack.hasTagCompound()) {
            mode = stack.getTagCompound().getInteger("mode");
        }

        tooltip.add("Current Aspect: " + IFunctionLibrary.getAspectFromMode(mode).getChatcolor() + IFunctionLibrary.getAspectFromMode(mode).getName());
    }


    public void changeItemMode(EntityPlayer player, ItemStack stack, int slotId) {
        ToolSwordPrimal ar = (ToolSwordPrimal) stack.getItem();
        ItemStack is = new ItemStack(stack.getItem());
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("mode", stack.getTagCompound().getInteger("mode") + 1);
        is.setTagCompound(nbt);
        if (is.getTagCompound().getInteger("mode") > 5) {
            is.getTagCompound().setInteger("mode", 0);
        }
        player.inventory.setInventorySlotContents(slotId, is);
    }


    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        ArrayListMultimap<String, AttributeModifier> arrayListMultimap = ArrayListMultimap.create();

        if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {

            arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
            arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
        }

        return arrayListMultimap;
    }
}