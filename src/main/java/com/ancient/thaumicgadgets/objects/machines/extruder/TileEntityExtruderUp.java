/*     */ package com.ancient.thaumicgadgets.objects.machines.extruder;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
/*     */ import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
/*     */ import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.BlockHorizontal;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ITickable;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import thaumcraft.api.aspects.Aspect;
/*     */ import thaumcraft.common.lib.events.EssentiaHandler;
/*     */ 
/*     */ public class TileEntityExtruderUp
/*     */   extends TileEntity implements ITickable {
/*     */   private int workTime;
/*     */   private int maxWorkTime;
/*     */   private int mode;
/*  33 */   private final Map<Aspect, Integer> aspectList = Maps.newHashMap();
/*     */   
/*  35 */   private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;
/*     */ 
/*     */   
/*     */   public TileEntityExtruderUp() {
/*  39 */     this.workTime = 0;
/*  40 */     this.maxWorkTime = getWorkTime();
/*  41 */     this.mode = 0;
/*  42 */     this.aspectList.put(Aspect.EARTH, Integer.valueOf(0));
/*  43 */     this.aspectList.put(Aspect.WATER, Integer.valueOf(0));
/*  44 */     this.aspectList.put(Aspect.FIRE, Integer.valueOf(0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeToNBT(NBTTagCompound compound) {
/*  50 */     super.writeToNBT(compound);
/*  51 */     compound.setInteger("WorkTime", (short)this.workTime);
/*  52 */     compound.setInteger("MaxWorkTime", (short)this.maxWorkTime);
/*  53 */     compound.setInteger("Mode", this.mode);
/*     */     
/*  55 */     NBTTagList tagList = new NBTTagList();
/*  56 */     for (Map.Entry<Aspect, Integer> e : this.aspectList.entrySet()) {
/*     */       
/*  58 */       NBTTagCompound tag = new NBTTagCompound();
/*  59 */       compound.setString("aspect", ((Aspect)e.getKey()).getTag());
/*  60 */       compound.setInteger("count", ((Integer)e.getValue()).intValue());
/*  61 */       tagList.appendTag((NBTBase)tag);
/*     */     } 
/*  63 */     compound.setTag("aspects", (NBTBase)tagList);
/*     */     
/*  65 */     return compound;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWork() {
/*  70 */     if (this.world.isBlockPowered(this.pos)) {
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagCompound compound) {
/*  80 */     super.readFromNBT(compound);
/*     */     
/*  82 */     this.workTime = compound.getInteger("WorkTime");
/*  83 */     this.maxWorkTime = compound.getInteger("MaxWorkTime");
/*  84 */     this.mode = compound.getInteger("Mode");
/*     */     
/*  86 */     NBTTagList tagList = compound.getTagList("aspects", 10);
/*  87 */     this.aspectList.clear();
/*  88 */     for (int q = 0; q < tagList.tagCount(); q++) {
/*     */       
/*  90 */       NBTTagCompound tag = tagList.getCompoundTagAt(q);
/*  91 */       this.aspectList.put(Aspect.getAspect(compound.getString("aspect")), Integer.valueOf(compound.getInteger("count")));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean isWorking(TileEntityExtruderUp ent) {
/* 100 */     return (ent.getField(0) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWorking() {
/* 105 */     return (this.workTime > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWorkTime() {
/* 112 */     return 100;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getField(int id) {
/* 117 */     switch (id) {
/*     */       
/*     */       case 0:
/* 120 */         return this.workTime;
/*     */       case 1:
/* 122 */         return this.maxWorkTime;
/*     */       case 2:
/* 124 */         return this.mode;
/*     */     } 
/* 126 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(int id, int value) {
/* 132 */     switch (id) {
/*     */       
/*     */       case 0:
/* 135 */         this.workTime = value;
/*     */         break;
/*     */       case 1:
/* 138 */         this.maxWorkTime = value;
/*     */         break;
/*     */       case 2:
/* 141 */         this.mode = value;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFieldCount() {
/* 148 */     return 3;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update() {
/* 154 */     boolean flag = isWorking();
/* 155 */     boolean flag1 = false;
/*     */     
/* 157 */     if (!this.world.isRemote) {
/*     */       
/* 159 */       int dim = this.world.provider.getDimension();
/* 160 */       if (canWork()) {
/*     */         
/* 162 */         if (this.mode == 2) {
/*     */           
/* 164 */           if (getAspectCount(Aspect.EARTH) < 10 && EssentiaHandler.drainEssentia(this, Aspect.EARTH, null, 10, 1))
/*     */           {
/* 166 */             this.aspectList.put(Aspect.EARTH, Integer.valueOf(getAspectCount(Aspect.EARTH) + 1));
/*     */           }
/* 168 */           if (getAspectCount(Aspect.FIRE) < 10 && EssentiaHandler.drainEssentia(this, Aspect.FIRE, null, 10, 1))
/*     */           {
/* 170 */             this.aspectList.put(Aspect.FIRE, Integer.valueOf(getAspectCount(Aspect.FIRE) + 1));
/*     */           }
/* 172 */           if (getAspectCount(Aspect.WATER) < 10 && EssentiaHandler.drainEssentia(this, Aspect.WATER, null, 10, 1))
/*     */           {
/* 174 */             this.aspectList.put(Aspect.WATER, Integer.valueOf(getAspectCount(Aspect.WATER) + 1));
/*     */           }
/*     */           
/* 177 */           if (this.workTime >= this.maxWorkTime && getAspectCount(Aspect.EARTH) >= 10 && getAspectCount(Aspect.FIRE) >= 10 && getAspectCount(Aspect.WATER) >= 10)
/*     */           {
/* 179 */             this.workTime = 0;
/* 180 */             this.aspectList.put(Aspect.EARTH, Integer.valueOf(getAspectCount(Aspect.EARTH) - 10));
/* 181 */             this.aspectList.put(Aspect.FIRE, Integer.valueOf(getAspectCount(Aspect.FIRE) - 10));
/* 182 */             this.aspectList.put(Aspect.WATER, Integer.valueOf(getAspectCount(Aspect.WATER) - 10));
/* 183 */             this.maxWorkTime = getWorkTime();
/* 184 */             IBlockState iBlockState = this.world.getBlockState(this.pos);
/* 185 */             EnumFacing enumFacing = (EnumFacing)iBlockState.getValue((IProperty)BlockHorizontal.FACING);
/* 186 */             EntityItem cobble = null;
/* 187 */             switch (enumFacing) {
/*     */               
/*     */               case NORTH:
/* 190 */                 cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
/*     */                 break;
/*     */               case SOUTH:
/* 193 */                 cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 1.5D, new ItemStack(getItemFromMode(this.mode), 1));
/*     */                 break;
/*     */               case EAST:
/* 196 */                 cobble = new EntityItem(this.world, this.pos.getX() + 1.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
/*     */                 break;
/*     */               case WEST:
/* 199 */                 cobble = new EntityItem(this.world, this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
/*     */                 break;
/*     */             } 
/*     */ 
/*     */             
/* 204 */             cobble.motionX = 0.025D;
/* 205 */             cobble.motionY = 0.075D;
/* 206 */             cobble.motionZ = 0.025D;
/* 207 */             ps.transferData(EnumParticleTypes.LAVA, RandomFunctions.rand.nextInt(5) + 1, cobble.posX, cobble.posY, cobble.posZ, dim);
/* 208 */             ps.transferData(EnumParticleTypes.SMOKE_NORMAL, RandomFunctions.rand.nextInt(5) + 1, cobble.posX, cobble.posY, cobble.posZ, dim);
/* 209 */             this.world.spawnEntity((Entity)cobble);
/* 210 */             flag1 = true;
/*     */           
/*     */           }
/*     */         
/*     */         }
/* 215 */         else if (this.workTime >= this.maxWorkTime) {
/*     */           
/* 217 */           this.workTime = 0;
/* 218 */           this.maxWorkTime = getWorkTime();
/* 219 */           IBlockState iBlockState = this.world.getBlockState(this.pos);
/* 220 */           EnumFacing enumFacing = (EnumFacing)iBlockState.getValue((IProperty)BlockHorizontal.FACING);
/* 221 */           EntityItem cobble = null;
/* 222 */           switch (enumFacing) {
/*     */             
/*     */             case NORTH:
/* 225 */               cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() - 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
/*     */               break;
/*     */             case SOUTH:
/* 228 */               cobble = new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 1.5D, new ItemStack(getItemFromMode(this.mode), 1));
/*     */               break;
/*     */             case EAST:
/* 231 */               cobble = new EntityItem(this.world, this.pos.getX() + 1.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
/*     */               break;
/*     */             case WEST:
/* 234 */               cobble = new EntityItem(this.world, this.pos.getX() - 0.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(getItemFromMode(this.mode), 1));
/*     */               break;
/*     */           } 
/*     */ 
/*     */           
/* 239 */           cobble.motionX = 0.025D;
/* 240 */           cobble.motionY = 0.075D;
/* 241 */           cobble.motionZ = 0.025D;
/* 242 */           ps.transferData(EnumParticleTypes.LAVA, RandomFunctions.rand.nextInt(5) + 1, cobble.posX, cobble.posY, cobble.posZ, dim);
/* 243 */           ps.transferData(EnumParticleTypes.SMOKE_NORMAL, RandomFunctions.rand.nextInt(5) + 1, cobble.posX, cobble.posY, cobble.posZ, dim);
/* 244 */           this.world.spawnEntity((Entity)cobble);
/* 245 */           flag1 = true;
/*     */         } 
/*     */         
/* 248 */         this.workTime++;
/* 249 */         IBlockState state = this.world.getBlockState(this.pos);
/* 250 */         EnumFacing face = (EnumFacing)state.getValue((IProperty)BlockHorizontal.FACING);
/* 251 */         if (this.workTime % 7 == 0) {
/* 252 */           ps.transferData(EnumHandler.CustomParticles.SMOKE, 1, (this.pos.getX() + face.getFrontOffsetX()), this.pos.getY() + 0.8D, (this.pos.getZ() + face.getFrontOffsetZ()), ps.rf.getRandomPartcileVelocity(0.02D), 0.05D, ps.rf.getRandomPartcileVelocity(0.02D), dim);
/*     */         }
/*     */       } else {
/* 255 */         this.workTime = 0;
/* 256 */       }  if (flag == isWorking())
/*     */       {
/* 258 */         flag1 = true;
/*     */       }
/*     */     } 
/* 261 */     if (flag1)
/*     */     {
/* 263 */       markDirty();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item getItemFromMode(int value) {
/* 270 */     switch (value) {
/*     */       
/*     */       case 0:
/* 273 */         return Item.getItemFromBlock(Blocks.COBBLESTONE);
/*     */       case 1:
/* 275 */         return Item.getItemFromBlock(Blocks.STONE);
/*     */       case 2:
/* 277 */         return Item.getItemFromBlock(Blocks.OBSIDIAN);
/*     */     } 
/* 279 */     return Item.getItemFromBlock(Blocks.COBBLESTONE);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getAspectCount(Aspect as) {
/* 284 */     if (as == null || !this.aspectList.containsKey(as))
/*     */     {
/* 286 */       return 0;
/*     */     }
/* 288 */     return ((Integer)this.aspectList.get(as)).intValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\extruder\TileEntityExtruderUp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */