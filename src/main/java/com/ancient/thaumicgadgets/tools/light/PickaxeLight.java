 package com.ancient.thaumicgadgets.tools.light;

 import com.ancient.thaumicgadgets.tools.ToolPickaxeBase;
 import com.ancient.thaumicgadgets.util.IItemAutoRepair;
 import com.google.common.collect.ArrayListMultimap;
 import com.google.common.collect.Multimap;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.attributes.AttributeModifier;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;
 
 public class PickaxeLight
   extends ToolPickaxeBase
   implements IItemAutoRepair {
   private int cd;
   private int count;
   private float damage;
   private float speed;
   
   public PickaxeLight(String name, Item.ToolMaterial material, int repairCount, int repairCooldown, float damage, float speed) {
/* 27 */     super(name, material);
     
/* 29 */     this.cd = repairCooldown;
/* 30 */     this.count = repairCount;
/* 31 */     this.damage = damage;
/* 32 */     this.speed = speed;
   }
 
 
   
   public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
/* 38 */     if (!world.isRemote) {
       
/* 40 */       EntityLivingBase elb = (EntityLivingBase)entity;
/* 41 */       if (CheckTime(stack, world, 0L, 12516L)) {
         
/* 43 */         if (stack.getItemDamage() > 0)
         {
/* 45 */           UpdateDamage(stack, entity, world, this.count, this.cd);
         }
         
/* 48 */         if (isSelected)
         {
/* 50 */           elb.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 110, 0));
         
         }
       
       }
/* 55 */       else if (isSelected) {
         
/* 57 */         elb.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 110, 0));
       } 
     } 
   }
 
 
 
   
   public Multimap<String, AttributeModifier> func_111205_h(EntityEquipmentSlot equipmentSlot) {
/* 66 */     ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();
     
/* 68 */     if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {
       
/* 70 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
/* 71 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
     } 
     
/* 74 */     return (Multimap<String, AttributeModifier>)arrayListMultimap;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\light\PickaxeLight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */