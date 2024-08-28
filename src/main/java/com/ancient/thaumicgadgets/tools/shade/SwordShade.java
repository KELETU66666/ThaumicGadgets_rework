 package com.ancient.thaumicgadgets.tools.shade;

 import com.ancient.thaumicgadgets.tools.ToolSwordBase;
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
 
 public class SwordShade
   extends ToolSwordBase
   implements IItemAutoRepair
 {
   private int cd;
   private int count;
   private float damage;
   private float speed;
   
   public SwordShade(String name, Item.ToolMaterial material, int repairCount, int repairCooldown, float damage, float speed) {
/* 28 */     super(name, material);
     
/* 30 */     this.cd = repairCooldown;
/* 31 */     this.count = repairCount;
/* 32 */     this.damage = damage;
/* 33 */     this.speed = speed;
   }
 
 
   
   public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
/* 39 */     if (!world.isRemote) {
       
/* 41 */       EntityLivingBase elb = (EntityLivingBase)entity;
/* 42 */       if (CheckTime(stack, world, 12516L, 24000L)) {
         
/* 44 */         if (stack.getItemDamage() > 0)
         {
/* 46 */           UpdateDamage(stack, entity, world, this.count, this.cd);
         }
         
/* 49 */         if (isSelected)
         {
/* 51 */           elb.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 110, 0));
         
         }
       
       }
/* 56 */       else if (isSelected) {
         
/* 58 */         elb.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 110, 0));
       } 
     } 
   }
 
 
 
   
   public Multimap<String, AttributeModifier> func_111205_h(EntityEquipmentSlot equipmentSlot) {
/* 67 */     ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();
     
/* 69 */     if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {
       
/* 71 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
/* 72 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
     } 
     
/* 75 */     return (Multimap<String, AttributeModifier>)arrayListMultimap;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\shade\SwordShade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */