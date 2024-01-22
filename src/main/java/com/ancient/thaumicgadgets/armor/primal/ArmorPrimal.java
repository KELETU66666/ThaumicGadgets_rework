package com.ancient.thaumicgadgets.armor.primal;

import com.ancient.thaumicgadgets.armor.ArmorBase;
/*     */
import com.ancient.thaumicgadgets.init.ModEnchantments;
/*     */
/*     */ import com.ancient.thaumicgadgets.util.ICheckEnchantment;
/*     */ import com.ancient.thaumicgadgets.util.IFunctionLibrary;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.client.util.ITooltipFlag;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Enchantments;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.DamageSource;
/*     */
import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;



public class ArmorPrimal extends ArmorBase implements ICheckEnchantment {
    private final int regenCount;
    private final long lastTick;
    private final int period;
    private final int mode;
    ModelBiped model;
    String location;
    public ArmorPrimal(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(name, materialIn, renderIndexIn, equipmentSlotIn);
        this.mode = 0;
        model = null;
        location = null;
        this.regenCount = 2;
        this.lastTick = 0L;
        this.period = 100;
    }

    public void OnPlayerHurt(EntityPlayer player, DamageSource source, float amount) {}

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        int mode = 0;

        if (stack.hasTagCompound())
        {
            mode = stack.getTagCompound().getInteger("mode");
        }

        tooltip.add(I18n.format("item.primal.description") + IFunctionLibrary.getAspectFromMode(mode).getChatcolor() + IFunctionLibrary.getAspectFromMode(mode).getName());
    }



    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTagCompound()) {

            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("mode", this.mode);
            stack.setTagCompound(nbt);
        }
    }




    public void changeItemMode(EntityPlayer player, ItemStack stack, int slotId) {
        ArmorPrimal ar = (ArmorPrimal)stack.getItem();
        ItemStack is = new ItemStack(stack.getItem());
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("mode", stack.getTagCompound().getInteger("mode") + 1);
        is.setTagCompound(nbt);
        if (is.getTagCompound().getInteger("mode") > 5)
        {
            is.getTagCompound().setInteger("mode", 0);
        }
        if (stack.getItem() instanceof ArmorPrimalUpgraded) {

            NBTTagList list = stack.getTagCompound().getTagList("primalInventory", 10);
            is.getTagCompound().setTag("primalInventory", list);
        }
        player.inventory.armorInventory.set(slotId, is);
    }




    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (itemStack.getItemDamage() > 0)
        {
            setDamage(itemStack, -1);
        }

        int mode = 0;

        if (itemStack.getItem() instanceof ArmorPrimal)
        {
            canApplyEchantment(itemStack, 0, 5);
        }


        if (itemStack.hasTagCompound() && itemStack.getTagCompound().getInteger("mode") == 2) {

            boolean canApply = true;
            Map<Enchantment, Integer> enc = EnchantmentHelper.getEnchantments(itemStack);

            for (Map.Entry<Enchantment, Integer> e : enc.entrySet()) {

                if (EnchantmentHelper.getEnchantmentLevel(ModEnchantments.REGEN_PRIMAL, itemStack) > 0) {

                    canApply = false;
                    regenTick(world, player, itemStack);
                }
            }

            if (canApply) {

                itemStack.addEnchantment(ModEnchantments.REGEN_PRIMAL, 1);
                NBTTagCompound nbt = itemStack.getTagCompound();
                if (nbt == null)
                {
                    nbt = new NBTTagCompound();
                }
                nbt.setLong("lastTick", world.getTotalWorldTime());
                itemStack.setTagCompound(nbt);
            }
        }

        if (itemStack.hasTagCompound() && itemStack.getTagCompound().getInteger("mode") == 5)
        {
            canApplyEchantment(itemStack, Enchantments.THORNS, 5);
        }
    }


    private void regenTick(World world, EntityPlayer player, ItemStack stack) {
        NBTTagCompound nbt = stack.getTagCompound();
        long lastTick = nbt.getLong("lastTick");

        if (lastTick + this.period < world.getTotalWorldTime()) {

            player.heal(this.regenCount);
            nbt.setLong("lastTick", world.getTotalWorldTime());
            stack.setTagCompound(nbt);
        }
    }

    @Override
    @Nullable
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default) {

        if (model == null) {
            if (slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.FEET)
                model = new ArmorPrimalModel(stack);
            else
                model = new ArmorPrimalModel(stack);

            model.bipedHead.showModel = slot == EntityEquipmentSlot.HEAD;
            model.bipedHeadwear.showModel = slot == EntityEquipmentSlot.HEAD;
            model.bipedBody.showModel = slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.LEGS;
            model.bipedRightArm.showModel = slot == EntityEquipmentSlot.CHEST;
            model.bipedLeftArm.showModel = slot == EntityEquipmentSlot.CHEST;
            model.bipedRightLeg.showModel = slot == EntityEquipmentSlot.LEGS;
            model.bipedLeftLeg.showModel = slot == EntityEquipmentSlot.LEGS;
        }

        if(slot == EntityEquipmentSlot.LEGS)
            return ArmorPrimalModel.getModel(living, stack);
        if(slot == EntityEquipmentSlot.FEET)
            return null;
        return model;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if (location == null) {
            if (slot == EntityEquipmentSlot.FEET)
                location = "tg:textures/models/armor/primal_boots.png";
            else
                location = "tg:textures/models/armor/primal_armor.png";
        }
        return location;
    }
}