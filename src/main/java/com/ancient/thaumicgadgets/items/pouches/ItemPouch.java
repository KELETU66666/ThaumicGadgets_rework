/*     */ package com.ancient.thaumicgadgets.items.pouches;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.Main;
/*     */ import com.ancient.thaumicgadgets.items.ItemBase;
/*     */ import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.NonNullList;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.Vec3d;
/*     */ import net.minecraft.util.text.ITextComponent;
/*     */ import net.minecraft.util.text.TextComponentString;
/*     */ import net.minecraft.world.World;
/*     */
/*     */ 
/*     */ public class ItemPouch
/*     */   extends ItemBase
/*     */ {
/*  31 */   private UUID defaultUUID = new UUID(0L, 1L);
/*     */ 
/*     */
/*     */   public ItemPouch(String name) {
/*  35 */     super(name);
/*     */     
/*  37 */     setMaxStackSize(1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxItemUseDuration(ItemStack stack) {
/*  43 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected) {
/*  49 */     if (!stack.hasTagCompound()) {
/*     */       
/*  51 */       NBTTagCompound nbt = new NBTTagCompound();
/*  52 */       nbt.setUniqueId("playerID", this.defaultUUID);
/*  53 */       stack.setTagCompound(nbt);
/*     */     } 
/*     */     
/*  56 */     if (stack.getUnlocalizedName().contains("magic") && stack.getUnlocalizedName().contains("pouch") && stack.getUnlocalizedName().contains("hungry") && !entity.isSneaking()) {
/*     */       
/*  58 */       AxisAlignedBB aabb = new AxisAlignedBB(entity.posX - 2.5D, entity.posY - 2.5D, entity.posZ - 2.5D, entity.posX + 2.5D, entity.posY + 2.5D, entity.posZ + 2.5D);
/*  59 */       for (EntityItem item : entity.world.getEntitiesWithinAABB(EntityItem.class, aabb)) {
/*     */         
/*  61 */         if (item != null) {
/*     */           
/*  63 */           double x = entity.posX - item.posX;
/*  64 */           double y = entity.posY - item.posY;
/*  65 */           double z = entity.posZ - item.posZ;
/*  66 */           Vec3d vec = (new Vec3d(x, y, z)).normalize();
/*  67 */           item.motionX = vec.x * 0.20000000298023224D;
/*  68 */           item.motionY = vec.y * 0.20000000298023224D;
/*  69 */           item.motionZ = vec.z * 0.20000000298023224D;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
/*  79 */     if (!worldIn.isRemote) {
/*     */       
/*  81 */       ItemStack stack = playerIn.getHeldItem(handIn);
/*  82 */       NBTTagCompound nbt = stack.getTagCompound();
/*     */       
/*  84 */       if (!stack.getUnlocalizedName().contains("ender") && stack.getUnlocalizedName().contains("pouch")) {
/*     */         
/*  86 */         if (!playerIn.isSneaking())
/*     */         {
/*  88 */           if (nbt.getUniqueId("playerID").equals(playerIn.getUniqueID()) || nbt.getUniqueId("playerID").equals(this.defaultUUID))
/*     */           {
/*  90 */             playerIn.openGui(Main.instance, 3, worldIn, 0, 0, 0);
/*     */           }
/*     */           else
/*     */           {
/*  94 */             playerIn.attackEntityFrom(DamageSource.MAGIC, 4.0F);
/*     */           
/*     */           }
/*     */         
/*     */         }
/*  99 */         else if (nbt.getUniqueId("playerID").equals(this.defaultUUID))
/*     */         {
/* 101 */           nbt.setUniqueId("playerID", playerIn.getUniqueID());
/* 102 */           stack.setTagCompound(nbt);
/* 103 */           playerIn.sendMessage((ITextComponent)new TextComponentString(I18n.format("item.pouch.description.soulbinded", new Object[0])));
/*     */         }
/* 105 */         else if (nbt.getUniqueId("playerID").equals(playerIn.getUniqueID()))
/*     */         {
/* 107 */           nbt.setUniqueId("playerID", this.defaultUUID);
/* 108 */           stack.setTagCompound(nbt);
/* 109 */           playerIn.sendMessage((ITextComponent)new TextComponentString(I18n.format("item.pouch.description.unbinded", new Object[0])));
/*     */         }
/*     */         else
/*     */         {
/* 113 */           playerIn.sendMessage((ITextComponent)new TextComponentString(I18n.format("item.pouch.description.wrong_owner", new Object[0])));
/*     */         }
/*     */       
/*     */       }
/* 117 */       else if (stack.getUnlocalizedName().contains("ender") && stack.getUnlocalizedName().contains("pouch")) {
/*     */         
/* 119 */         playerIn.displayGUIChest((IInventory)playerIn.getInventoryEnderChest());
/*     */       } 
/*     */     } 
/* 122 */     return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
/*     */   }
/*     */ 
/*     */   
/*     */   public NonNullList<ItemStack> getInventory(ItemStack stack) {
/* 127 */     NBTTagCompound nbt = stack.getTagCompound();
/* 128 */     String tagName = stack.getUnlocalizedName().substring(5, stack.getUnlocalizedName().length());
/* 129 */     NBTTagList items = nbt.getTagList(tagName, 10);
/* 130 */     NonNullList<ItemStack> inventory = NonNullList.withSize(EnumHandler.PouchTypes.valueOf(tagName).getSlotCount(), ItemStack.EMPTY);
/* 131 */     for (int i = 0; i < items.tagCount(); i++) {
/*     */       
/* 133 */       NBTTagCompound item = items.getCompoundTagAt(i);
/* 134 */       int slot = item.getInteger("slot");
/* 135 */       if (slot >= 0 && slot < inventory.size())
/*     */       {
/* 137 */         inventory.set(slot, new ItemStack(item));
/*     */       }
/*     */     } 
/* 140 */     return inventory;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInventory(ItemStack stack, NonNullList<ItemStack> inv) {
/* 146 */     NBTTagList items = new NBTTagList();
/* 147 */     for (int i = 0; i < inv.size(); i++) {
/*     */       
/* 149 */       if (inv.get(i) != ItemStack.EMPTY) {
/*     */         
/* 151 */         NBTTagCompound item = new NBTTagCompound();
/* 152 */         item.setInteger("slot", i);
/* 153 */         ((ItemStack)inv.get(i)).writeToNBT(item);
/* 154 */         items.appendTag((NBTBase)item);
/*     */       } 
/*     */     } 
/* 157 */     String tagName = stack.getUnlocalizedName().substring(5, stack.getUnlocalizedName().length());
/* 158 */     stack.getTagCompound().setTag(tagName, (NBTBase)items);
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\items\pouches\ItemPouch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */