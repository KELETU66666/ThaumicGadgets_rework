 package com.ancient.thaumicgadgets.tools.light;
 
 import com.ancient.thaumicgadgets.tools.ToolShearsBase;
 import com.ancient.thaumicgadgets.util.IItemAutoRepair;
 import net.minecraft.entity.Entity;
 import net.minecraft.entity.EntityLivingBase;
 import net.minecraft.item.Item;
 import net.minecraft.item.ItemStack;
 import net.minecraft.potion.Potion;
 import net.minecraft.potion.PotionEffect;
 import net.minecraft.world.World;
 
 public class ShearsLight
   extends ToolShearsBase
   implements IItemAutoRepair {
   private int cd;
   private int count;
   
   public ShearsLight(String name, Item.ToolMaterial material, int repairCount, int repairCooldown) {
/* 20 */     super(name, material);
     
/* 22 */     this.cd = repairCooldown;
/* 23 */     this.count = repairCount;
   }
 
 
   
   public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
/* 29 */     if (!world.isRemote) {
       
/* 31 */       EntityLivingBase elb = (EntityLivingBase)entity;
/* 32 */       if (CheckTime(stack, world, 0L, 12516L)) {
         
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


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\tools\light\ShearsLight.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */