 package com.ancient.thaumicgadgets.armour.light;
 
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
 
 
 public class ArmorLight
   extends ArmorBase
   implements IWarpingGear, IItemAutoRepair
 {
/* 23 */   private final int period = 100;
/* 24 */   private final int regenCount = 2;
 
   
   public ArmorLight(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
/* 28 */     super(name, materialIn, renderIndexIn, equipmentSlotIn);
   }
 
 
   
   public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
/* 34 */     if (!world.isRemote)
     {
/* 36 */       if (CheckTime(itemStack, world, 0L, 12516L))
       {
/* 38 */         if (itemStack.getItemDamage() > 0) {
           
/* 40 */           getClass(); getClass(); UpdateDamage(itemStack, (Entity)player, world, 2, 100);
         } 
       }
     }
   }
 
 
   
   public int getWarp(ItemStack itemstack, EntityPlayer player) {
/* 49 */     return -5;
   }
 
 
   
   @SideOnly(Side.CLIENT)
   public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
/* 56 */     if (!itemStack.isEmpty())
     {
/* 58 */       if (itemStack.getItem() instanceof ItemArmor) {
         
/* 60 */         ArmorLightModel armorModel = ClientProxy.ARMOR_LIGHT_MODEL;
/* 61 */         ArmorLightModel armorModelLegs = ClientProxy.ARMOR_LIGHT_MODEL_LEGS;
         
/* 63 */         armorModel.bipedHead.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
/* 64 */         armorModel.bipedHeadwear.showModel = (armorSlot == EntityEquipmentSlot.HEAD);
/* 65 */         armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST || armorSlot == EntityEquipmentSlot.CHEST);
/* 66 */         armorModel.bipedRightArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
/* 67 */         armorModel.bipedLeftArm.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
/* 68 */         armorModelLegs.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET);
/* 69 */         armorModelLegs.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS || armorSlot == EntityEquipmentSlot.FEET);
         
/* 71 */         armorModel.isSneak = _default.isSneak;
/* 72 */         armorModel.isRiding = _default.isRiding;
/* 73 */         armorModel.isChild = _default.isChild;
/* 74 */         armorModel.rightArmPose = _default.rightArmPose;
/* 75 */         armorModel.leftArmPose = _default.leftArmPose;
         
/* 77 */         armorModelLegs.isSneak = _default.isSneak;
/* 78 */         armorModelLegs.isRiding = _default.isRiding;
/* 79 */         armorModelLegs.isChild = _default.isChild;
/* 80 */         armorModelLegs.rightArmPose = _default.rightArmPose;
/* 81 */         armorModelLegs.leftArmPose = _default.leftArmPose;
         
/* 83 */         return armorModel;
       } 
     }
/* 86 */     return null;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\light\ArmorLight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */