 package com.ancient.thaumicgadgets.tools.thauminium;

 import com.ancient.thaumicgadgets.tools.ToolScytheBase;
 import com.google.common.collect.ArrayListMultimap;
 import com.google.common.collect.Multimap;
 import net.minecraft.entity.SharedMonsterAttributes;
 import net.minecraft.entity.ai.attributes.AttributeModifier;
 import net.minecraft.inventory.EntityEquipmentSlot;
 import net.minecraft.item.Item;








 public class ScytheThaum
   extends ToolScytheBase
 {
   private int cd;
   private int count;
   private float damage;
   private float speed;

   public ScytheThaum(String name, Item.ToolMaterial material, float damage, float speed, int xSize, int ySize, int zSize) {
/* 27 */     super(name, material, xSize, ySize, zSize);

/* 29 */     this.damage = damage;
/* 30 */     this.speed = speed;
   }



   public Multimap<String, AttributeModifier> func_111205_h(EntityEquipmentSlot equipmentSlot) {
/* 36 */     ArrayListMultimap arrayListMultimap = ArrayListMultimap.create();

/* 38 */     if (equipmentSlot.equals(EntityEquipmentSlot.MAINHAND)) {

/* 40 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.damage, 0));
/* 41 */       arrayListMultimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed, 0));
     }

/* 44 */     return (Multimap<String, AttributeModifier>)arrayListMultimap;
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\thauminium\ScytheThaum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */