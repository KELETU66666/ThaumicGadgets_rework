/*     */ package com.ancient.thaumicgadgets.objects.machines.extruder;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
/*     */ import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
/*     */ import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
/*     */ import net.minecraft.block.BlockHorizontal;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ITickable;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ public class TileEntityExtruder
/*     */   extends TileEntity
/*     */   implements ITickable
/*     */ {
/*  27 */   private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;
/*     */ 
/*     */ 
/*     */   
/*  31 */   private int workTime = 0;
/*  32 */   private int maxWorkTime = getWorkTime();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeToNBT(NBTTagCompound compound) {
/*  38 */     super.writeToNBT(compound);
/*  39 */     compound.setInteger("WorkTime", (short)this.workTime);
/*  40 */     compound.setInteger("MaxWorkTime", (short)this.maxWorkTime);
/*     */     
/*  42 */     return compound;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWork() {
/*  47 */     if (this.world.isBlockPowered(this.pos)) {
/*  48 */       return true;
/*     */     }
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagCompound compound) {
/*  57 */     super.readFromNBT(compound);
/*     */     
/*  59 */     this.workTime = compound.getInteger("WorkTime");
/*  60 */     this.maxWorkTime = compound.getInteger("MaxWorkTime");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean isWorking(TileEntityExtruder ent) {
/*  67 */     return (ent.getField(0) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWorking() {
/*  72 */     return (this.workTime > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWorkTime() {
/*  79 */     return 100;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getField(int id) {
/*  84 */     switch (id) {
/*     */       
/*     */       case 0:
/*  87 */         return this.workTime;
/*     */       case 1:
/*  89 */         return this.maxWorkTime;
/*     */     } 
/*  91 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(int id, int value) {
/*  97 */     switch (id) {
/*     */       
/*     */       case 0:
/* 100 */         this.workTime = value;
/*     */         break;
/*     */       case 1:
/* 103 */         this.maxWorkTime = value;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFieldCount() {
/* 110 */     return 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/* 116 */     boolean flag = isWorking();
/* 117 */     boolean flag1 = false;
/*     */     
/* 119 */     if (!this.world.isRemote) {
/*     */       
/* 121 */       int dim = this.world.provider.getDimension();
/* 122 */       if (canWork()) {
/*     */         
/* 124 */         IBlockState state = this.world.getBlockState(this.pos);
/* 125 */         EnumFacing face = (EnumFacing)state.getValue((IProperty)BlockHorizontal.FACING);
/* 126 */         this.workTime++;
/*     */         
/* 128 */         if (this.workTime % 7 == 0)
/*     */         {
/* 130 */           ps.transferData(EnumHandler.CustomParticles.SMOKE, 1, (this.pos.getX() + face.getFrontOffsetX()), this.pos.getY() + 0.1D, (this.pos.getZ() + face.getFrontOffsetZ()), ps.rf.getRandomPartcileVelocity(0.02D), 0.05D, ps.rf.getRandomPartcileVelocity(0.02D), dim);
/*     */         }
/* 132 */         if (this.workTime >= this.maxWorkTime) {
/*     */           
/* 134 */           this.workTime = 0;
/* 135 */           this.maxWorkTime = getWorkTime();
/* 136 */           EntityItem cobble = null;
/* 137 */           switch (face) {
/*     */             
/*     */             case NORTH:
/* 140 */               cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
/*     */               break;
/*     */             case SOUTH:
/* 143 */               cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 1.5D, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
/*     */               break;
/*     */             case EAST:
/* 146 */               cobble = new EntityItem(this.world, this.pos.getX() + 1.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
/*     */               break;
/*     */             case WEST:
/* 149 */               cobble = new EntityItem(this.world, this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1));
/*     */               break;
/*     */           } 
/*     */ 
/*     */           
/* 154 */           cobble.motionX = 0.025D;
/* 155 */           cobble.motionY = 0.075D;
/* 156 */           cobble.motionZ = 0.025D;
/* 157 */           ps.transferData(EnumParticleTypes.LAVA, RandomFunctions.rand.nextInt(5) + 1, cobble.posX, cobble.posY, cobble.posZ, dim);
/* 158 */           ps.transferData(EnumParticleTypes.SMOKE_NORMAL, RandomFunctions.rand.nextInt(5) + 1, cobble.posX, cobble.posY, cobble.posZ, dim);
/* 159 */           this.world.spawnEntity((Entity)cobble);
/* 160 */           flag1 = true;
/*     */         } 
/*     */       } else {
/*     */         
/* 164 */         this.workTime = 0;
/* 165 */       }  if (flag == isWorking())
/*     */       {
/* 167 */         flag1 = true;
/*     */       }
/*     */     } 
/* 170 */     if (flag1)
/*     */     {
/* 172 */       markDirty();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\extruder\TileEntityExtruder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */