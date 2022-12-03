 package com.ancient.thaumicgadgets.tools.voiid;

 import com.ancient.thaumicgadgets.tools.ToolScytheBase;
 import com.ancient.thaumicgadgets.util.IItemAutoRepair;
 import com.google.common.collect.ArrayListMultimap;
 import com.google.common.collect.Multimap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.attributes.AttributeModifier;
 import net.minecraft.entity.player.EntityPlayer;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.world.World;
 import thaumcraft.api.items.IWarpingGear;

 public class ScytheVoid
   extends ToolScytheBase
   implements IItemAutoRepair, IWarpingGear
 {
   private int cd;
   private int count;
   private float damage;
   private float speed;

   public ScytheVoid(String name, Item.ToolMaterial material, int repairCount, int repairCooldown, float damage, float speed, int xSize, int ySize, int zSize) {
/* 28 */     super(name, material, xSize, ySize, zSize);

/* 30 */     this.cd = repairCooldown;
/* 31 */     this.count = repairCount;
/* 32 */     this.damage = damage;
/* 33 */     this.speed = speed;
   }



   public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
/* 39 */     if (!world.isRemote) {

/* 41 */       EntityLivingBase elb = (EntityLivingBase)entity;
/* 42 */       if (CheckTime(stack, world, 0L, 24000L))
       {
/* 44 */         if (stack.getItemDamage() > 0)
         {
/* 46 */           UpdateDamage(stack, entity, world, this.count, this.cd);
         }
       }
     }
   }



   public Multimap<String, AttributeModifier> func_111205_h(EntityEquipmentSlot equipmentSlot) {
/* 55 */     ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();

/* 57 */     if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {

/* 59 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
/* 60 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
     }

/* 63 */     return (Multimap<String, AttributeModifier>)arrayListMultimap;
   }



   public int getWarp(ItemStack itemstack, EntityPlayer player) {
/* 69 */     return 2;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\voiid\ScytheVoid.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */