 package com.ancient.thaumicgadgets.tools.shade;
 
 import com.ancient.thaumicgadgets.tools.ToolAxeBase;
 import com.ancient.thaumicgadgets.util.IItemAutoRepair;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;
 
 public class AxeShade
   extends ToolAxeBase
   implements IItemAutoRepair
 {
   private int cd;
   private int count;
   
   public AxeShade(String name, Item.ToolMaterial material, int repairCount, int repairCooldown, float damage, float speed) {
/* 21 */     super(name, material, damage, speed);
/* 22 */     this.cd = repairCooldown;
/* 23 */     this.count = repairCount;
   }
 
 
   
   public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
/* 29 */     if (!world.isRemote) {
       
/* 31 */       EntityLivingBase elb = (EntityLivingBase)entity;
/* 32 */       if (CheckTime(stack, world, 12516L, 24000L)) {
         
/* 34 */         if (stack.getItemDamage() > 0)
         {
/* 36 */           UpdateDamage(stack, entity, world, this.count, this.cd);
         }
         
/* 39 */         if (isSelected)
         {
/* 41 */           elb.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 110, 0));
         
         }
       
       }
/* 46 */       else if (isSelected) {
         
/* 48 */         elb.addPotionEffect(new PotionEffect(Potion.getPotionById(4), 110, 0));
       } 
     } 
   }
 }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\shade\AxeShade.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */