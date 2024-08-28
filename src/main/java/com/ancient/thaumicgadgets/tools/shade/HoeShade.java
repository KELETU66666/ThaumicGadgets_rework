 package com.ancient.thaumicgadgets.tools.shade;

 import com.ancient.thaumicgadgets.tools.ToolHoeBase;
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
 
 
 public class HoeShade
   extends ToolHoeBase
   implements IItemAutoRepair
 {
   private int cd;
   private int count;
   private float damage;
   private float speed;
   
   public HoeShade(String name, Item.ToolMaterial material, int repairCount, int repairCooldown, float damage, float speed) {
       super(name, material);
       this.count = repairCount;
       this.cd = repairCooldown;

       this.damage = damage;
       this.speed = speed;
   }
 
 
   
   public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
/* 40 */     if (!world.isRemote) {
       
/* 42 */       EntityLivingBase elb = (EntityLivingBase)entity;
/* 43 */       if (CheckTime(stack, world, 12516L, 24000L)) {
         
/* 45 */         if (stack.getItemDamage() > 0)
         {
/* 47 */           UpdateDamage(stack, entity, world, this.count, this.cd);
         }
         
/* 50 */         if (isSelected)
         {
/* 52 */           elb.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 110, 0));
         
         }
       
       }
/* 57 */       else if (isSelected) {
         
/* 59 */         elb.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 110, 0));
       } 
     } 
   }
 
 
 
   
   public Multimap<String, AttributeModifier> func_111205_h(EntityEquipmentSlot equipmentSlot) {
/* 68 */     ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();
     
/* 70 */     if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {
       
/* 72 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
/* 73 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
     } 
     
/* 76 */     return (Multimap<String, AttributeModifier>)arrayListMultimap;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\shade\HoeShade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */