 package com.ancient.thaumicgadgets.armour.shade;

 import com.ancient.thaumicgadgets.armour.ArmorBase;
 import com.ancient.thaumicgadgets.proxy.ClientProxy;
 import com.ancient.thaumicgadgets.util.IItemAutoRepair;
 import net.minecraft.client.model.ModelBiped;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.ItemArmor;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;
 import net.minecraftforge.fml.relauncher.Side;
 import net.minecraftforge.fml.relauncher.SideOnly;
 import thaumcraft.api.items.IWarpingGear;

 public class ArmorShade
   extends ArmorBase
   implements IWarpingGear, IItemAutoRepair {
/* 21 */   private final int period = 100;
/* 22 */   private final int regenCount = 2;


   public ArmorShade(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
/* 26 */     super(name, materialIn, renderIndexIn, equipmentSlotIn);
   }



   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
/* 32 */     if (!world.isRemote)
     {
/* 34 */       if (CheckTime(itemStack, world, 12516L, 24000L))
       {
/* 36 */         if (itemStack.getItemDamage() > 0) {

/* 38 */           getClass(); getClass(); UpdateDamage(itemStack, (Entity)player, world, 2, 100);
         }
       }
     }
   }



   public int getWarp(ItemStack itemstack, EntityPlayer player) {
/* 47 */     return 5;
   }



   @SideOnly(Side.CLIENT)
   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
/* 54 */     if (!itemStack.isEmpty())
     {
/* 56 */       if (itemStack.getItem() instanceof ItemArmor) {

/* 58 */         ArmorShadeModel armorModel = ClientProxy.ARMOR_SHADE_MODEL;
/* 59 */         ArmorShadeModel armorModelLegs = ClientProxy.ARMOR_SHADE_MODEL_LEGS;

/* 61 */         armorModel.bipedHead.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
/* 62 */         armorModel.bipedHeadwear.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
/* 63 */         armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.CHEST);
/* 64 */         armorModel.bipedRightArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
/* 65 */         armorModel.bipedLeftArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
/* 66 */         armorModelLegs.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET);
/* 67 */         armorModelLegs.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET);

/* 69 */         armorModel.isSneak = _default.isSneak;
/* 70 */         armorModel.isRiding = _default.isRiding;
/* 71 */         armorModel.isChild = _default.isChild;
/* 72 */         armorModel.rightArmPose = _default.rightArmPose;
/* 73 */         armorModel.leftArmPose = _default.leftArmPose;

/* 75 */         armorModelLegs.isSneak = _default.isSneak;
/* 76 */         armorModelLegs.isRiding = _default.isRiding;
/* 77 */         armorModelLegs.isChild = _default.isChild;
/* 78 */         armorModelLegs.rightArmPose = _default.rightArmPose;
/* 79 */         armorModelLegs.leftArmPose = _default.leftArmPose;

/* 81 */         return armorModel;
       }
     }

/* 85 */     return null;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\shade\ArmorShade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */