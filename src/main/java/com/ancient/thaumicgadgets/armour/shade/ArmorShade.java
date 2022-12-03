 package com.ancient.thaumicgadgets.armour.shade;

 import com.ancient.thaumicgadgets.armour.ArmorBase;
 import com.ancient.thaumicgadgets.proxy.ClientProxy;
 import com.ancient.thaumicgadgets.util.IItemAutoRepair;
 import net.minecraft.client.model.ModelBiped;
 import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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

 import javax.annotation.Nullable;

 public class ArmorShade
   extends ArmorBase
   implements IWarpingGear, IItemAutoRepair {
     ModelBiped model;
     String location;
/* 21 */   private final int period = 100;
/* 22 */   private final int regenCount = 2;


   public ArmorShade(String name, ItemArmor.ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
/* 26 */     super(name, materialIn, renderIndexIn, equipmentSlotIn);
model = null;
location = null;
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

     @Override
     @Nullable
     @SideOnly(Side.CLIENT)
     public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot,
                                     ModelBiped _default) {

         if (model == null) {
             if (slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.FEET)
                 model = new ArmorShadeModel(1.0F);
             else
                 model = new ArmorShadeModel(0.5F);

             model.bipedHead.showModel = slot == EntityEquipmentSlot.HEAD;
             model.bipedHeadwear.showModel = slot == EntityEquipmentSlot.HEAD;
             model.bipedBody.showModel = slot == EntityEquipmentSlot.CHEST || slot == EntityEquipmentSlot.LEGS;
             model.bipedRightArm.showModel = slot == EntityEquipmentSlot.CHEST;
             model.bipedLeftArm.showModel = slot == EntityEquipmentSlot.CHEST;
             model.bipedRightLeg.showModel = slot == EntityEquipmentSlot.LEGS;
             model.bipedLeftLeg.showModel = slot == EntityEquipmentSlot.LEGS;
         }

         if(slot == EntityEquipmentSlot.FEET)
             return null;

         return model;
     }

     public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
         if (location == null) {
             if (slot == EntityEquipmentSlot.FEET)
                 location = "thaumcraft:textures/entity/armor/bootstraveler.png";
             else
                 location = "tg:textures/models/armor/shade_armor.png";
         }
         return location;
   }

   public int getWarp(ItemStack itemstack, EntityPlayer player) {
/* 47 */     return 5;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\shade\ArmorShade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */