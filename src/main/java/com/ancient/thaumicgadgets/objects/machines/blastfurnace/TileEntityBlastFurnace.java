/*     */ package com.ancient.thaumicgadgets.objects.machines.blastfurnace;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.Main;
/*     */ import com.ancient.thaumicgadgets.init.ModItems;
/*     */ import com.ancient.thaumicgadgets.init.ModMultiBlocks;
/*     */ import com.ancient.thaumicgadgets.util.ICheckMultiBlock;
/*     */ import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
/*     */ import com.ancient.thaumicgadgets.util.handlers.ParticleSpawner;
/*     */ import com.ancient.thaumicgadgets.util.handlers.RandomFunctions;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.BlockHorizontal;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ITickable;
/*     */ import net.minecraft.util.math.AxisAlignedBB;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import thaumcraft.api.aspects.Aspect;
/*     */ import thaumcraft.api.blocks.BlocksTC;
/*     */ import thaumcraft.common.lib.events.EssentiaHandler;
/*     */ 
/*     */ public class TileEntityBlastFurnace
/*     */   extends TileEntity
/*     */   implements ITickable {
/*     */   private int workTime;
/*     */   private int maxWorkTime;
/*  41 */   private static final ParticleSpawner ps = ParticleSpawner.INSTANCE;
/*     */ 
/*     */   
/*  44 */   private final Map<Aspect, Integer> aspectList = Maps.newHashMap();
/*  45 */   private final Map<ItemStack, Integer> inputs = Maps.newHashMap();
/*     */   
/*     */   private int essenceCount;
/*     */   
/*     */   public TileEntityBlastFurnace() {
/*  50 */     this.workTime = 0;
/*  51 */     this.maxWorkTime = getWorkTime();
/*  52 */     this.aspectList.put(Aspect.FIRE, Integer.valueOf(0));
/*  53 */     this.essenceCount = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NBTTagCompound writeToNBT(NBTTagCompound compound) {
/*  60 */     super.writeToNBT(compound);
/*  61 */     compound.setInteger("WorkTime", (short)this.workTime);
/*  62 */     compound.setInteger("MaxWorkTime", (short)this.maxWorkTime);
/*  63 */     compound.setInteger("Fire", ((Integer)this.aspectList.get(Aspect.FIRE)).intValue());
/*  64 */     NBTTagList tList = new NBTTagList();
/*  65 */     for (Map.Entry<ItemStack, Integer> e : this.inputs.entrySet()) {
/*     */       
/*  67 */       NBTTagCompound compoundItem = new NBTTagCompound();
/*  68 */       ItemStack st = e.getKey(); st.setCount(((Integer)e.getValue()).intValue());
/*  69 */       compoundItem = st.serializeNBT();
/*  70 */       tList.appendTag((NBTBase)compoundItem);
/*     */     } 
/*  72 */     compound.setTag("inputs", (NBTBase)tList);
/*  73 */     return compound;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFromNBT(NBTTagCompound compound) {
/*  79 */     super.readFromNBT(compound);
/*     */     
/*  81 */     this.workTime = compound.getInteger("WorkTime");
/*  82 */     this.maxWorkTime = compound.getInteger("MaxWorkTime");
/*  83 */     this.aspectList.clear();
/*  84 */     this.aspectList.put(Aspect.FIRE, Integer.valueOf(compound.getInteger("Fire")));
/*  85 */     this.inputs.clear();
/*  86 */     NBTTagList tList = compound.getTagList("inputs", 10);
/*     */     
/*  88 */     if (tList.tagCount() > 0)
/*     */     {
/*  90 */       for (int q = 0; q < tList.tagCount(); q++) {
/*     */         
/*  92 */         NBTTagCompound tC = tList.getCompoundTagAt(q);
/*  93 */         ItemStack st = new ItemStack(tC);
/*  94 */         this.inputs.put(new ItemStack(st.getItem(), 1, st.getMetadata()), Integer.valueOf(st.getCount()));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canWork() {
/* 101 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void findItem(TileEntityBlastFurnace te) {
/* 106 */     double x = this.pos.getX();
/* 107 */     double y = this.pos.getY() + 1.0D;
/* 108 */     double z = this.pos.getZ();
/*     */     
/* 110 */     AxisAlignedBB scanAbove = new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D);
/*     */     
/* 112 */     List<EntityItem> entities = this.world.getEntitiesWithinAABB(EntityItem.class, scanAbove);
/*     */     
/* 114 */     if (entities.size() > 0)
/*     */     {
/* 116 */       for (EntityItem i : entities) {
/*     */         
/* 118 */         ItemStack stack = i.getItem();
/* 119 */         ItemStack check = new ItemStack(stack.getItem(), 1, stack.getMetadata());
/* 120 */         if (this.inputs.containsKey(check)) {
/*     */           
/* 122 */           this.inputs.replace(check, Integer.valueOf(((Integer)this.inputs.get(check)).intValue() + stack.getCount()));
/*     */         }
/*     */         else {
/*     */           
/* 126 */           this.inputs.put(check, Integer.valueOf(stack.getCount()));
/*     */         } 
/* 128 */         i.setDead();
/*     */       } 
/*     */     }
/*     */     
/* 132 */     List<EntityPlayer> players = this.world.getEntitiesWithinAABB(EntityPlayer.class, scanAbove);
/*     */     
/* 134 */     if (players.size() > 0)
/*     */     {
/* 136 */       for (EntityPlayer pl : players)
/*     */       {
/* 138 */         pl.setFire(5);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int findBellows(TileEntityBlastFurnace te) {
/*     */     EnumFacing face;
/* 146 */     if (te.world.getBlockState(te.pos).getProperties().containsKey(BlockHorizontal.FACING)) {
/*     */       
/* 148 */       face = (EnumFacing)te.world.getBlockState(te.pos).getValue((IProperty)BlockHorizontal.FACING);
/*     */     }
/*     */     else {
/*     */       
/* 152 */       face = EnumFacing.NORTH;
/*     */     } 
/* 154 */     int x = face.getFrontOffsetX();
/* 155 */     int z = face.getFrontOffsetZ();
/*     */     
/* 157 */     int i = 0;
/*     */     
/* 159 */     if (x != 0) {
/*     */       
/* 161 */       IBlockState state = te.world.getBlockState(new BlockPos(te.pos.getX() - 2, te.pos.getY(), te.pos.getZ()));
/* 162 */       if (state.getBlock().equals(BlocksTC.bellows))
/*     */       {
/* 164 */         i++;
/*     */       }
/* 166 */       state = te.world.getBlockState(new BlockPos(te.pos.getX() + 2, te.pos.getY(), te.pos.getZ()));
/* 167 */       if (state.getBlock().equals(BlocksTC.bellows))
/*     */       {
/* 169 */         i++;
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 174 */       IBlockState state = te.world.getBlockState(new BlockPos(te.pos.getX() + x * 2, te.pos.getY(), te.pos.getZ()));
/* 175 */       if (state.getBlock().equals(BlocksTC.bellows))
/*     */       {
/* 177 */         i++;
/*     */       }
/*     */     } 
/* 180 */     if (z != 0) {
/*     */       
/* 182 */       IBlockState iBlockState = te.world.getBlockState(new BlockPos(te.pos.getX(), te.pos.getY(), te.pos.getZ() + 2));
/* 183 */       if (iBlockState.getBlock().equals(BlocksTC.bellows))
/*     */       {
/* 185 */         i++;
/*     */       }
/* 187 */       iBlockState = te.world.getBlockState(new BlockPos(te.pos.getX(), te.pos.getY(), te.pos.getZ() - 2));
/* 188 */       if (iBlockState.getBlock().equals(BlocksTC.bellows))
/*     */       {
/* 190 */         i++;
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 195 */       IBlockState iBlockState = te.world.getBlockState(new BlockPos(te.pos.getX(), te.pos.getY(), te.pos.getZ() + z * 2));
/* 196 */       if (iBlockState.getBlock().equals(BlocksTC.bellows))
/*     */       {
/* 198 */         i++;
/*     */       }
/*     */     } 
/*     */     
/* 202 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static boolean isWorking(TileEntityBlastFurnace ent) {
/* 208 */     return (ent.getField(0) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isWorking() {
/* 213 */     return (this.workTime > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWorkTime() {
/* 220 */     return 80;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getField(int id) {
/* 225 */     switch (id) {
/*     */       
/*     */       case 0:
/* 228 */         return this.workTime;
/*     */       case 1:
/* 230 */         return this.maxWorkTime;
/*     */     } 
/* 232 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setField(int id, int value) {
/* 238 */     switch (id) {
/*     */       
/*     */       case 0:
/* 241 */         this.workTime = value;
/*     */         break;
/*     */       case 1:
/* 244 */         this.maxWorkTime = value;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getFieldCount() {
/* 251 */     return 2;
/*     */   }
/*     */ 
/*     */
/*     */
/*     */   
/*     */   public void update() {
/* 258 */     boolean flag = isWorking();
/* 259 */     boolean flag1 = false;
/*     */     
/* 261 */     if (!this.world.isRemote) {
/*     */
/* 269 */       findItem(this);
/*     */       
/* 271 */       ArrayList<ItemStack> forRemove = new ArrayList<>();
/* 272 */       for (Map.Entry<ItemStack, Integer> e : this.inputs.entrySet()) {
/*     */         
/* 274 */         if (((Integer)e.getValue()).intValue() == 0)
/*     */         {
/* 276 */           forRemove.add(e.getKey());
/*     */         }
/*     */       } 
/* 279 */       if (forRemove.size() > 0) {
/*     */         
/* 281 */         for (ItemStack st : forRemove)
/*     */         {
/* 283 */           this.inputs.remove(st);
/*     */         }
/* 285 */         forRemove.clear();
/*     */       } 
/*     */ 
/*     */       
/* 289 */       int bellows = findBellows(this);
/* 290 */       if (((Integer)this.aspectList.get(Aspect.FIRE)).intValue() < this.essenceCount && EssentiaHandler.drainEssentia(this, Aspect.FIRE, null, 10, 1))
/*     */       {
/* 292 */         this.aspectList.replace(Aspect.FIRE, Integer.valueOf(((Integer)this.aspectList.get(Aspect.FIRE)).intValue() + 1));
/*     */       }
/* 294 */       if (bellows > 0) {
/*     */         
/* 296 */         float f = 1.0F + 0.33F * (bellows + 1);
/* 297 */         this.maxWorkTime = Math.round(getWorkTime() / f);
/*     */       }
/*     */       else {
/*     */         
/* 301 */         this.maxWorkTime = getWorkTime();
/*     */       } 
/* 303 */       if (((Integer)this.aspectList.get(Aspect.FIRE)).intValue() >= this.essenceCount)
/*     */       {
/* 305 */         this.maxWorkTime = Math.round(this.maxWorkTime * 0.75F);
/*     */       }
/* 307 */       if (!this.inputs.isEmpty()) {
/*     */ 
/*     */         
/* 310 */         Object[] ks = this.inputs.keySet().toArray();
/* 311 */         int rand = RandomFunctions.rand.nextInt(ks.length);
/* 312 */         ItemStack it = (ItemStack)ks[rand];
/* 313 */         it.setCount(((Integer)this.inputs.get(it)).intValue());
/*     */         
/* 315 */         if (this.workTime >= this.maxWorkTime) {
/*     */           
/* 317 */           this.workTime = 0;
/* 318 */           if (((Integer)this.aspectList.get(Aspect.FIRE)).intValue() >= this.essenceCount)
/*     */           {
/* 320 */             this.aspectList.replace(Aspect.FIRE, Integer.valueOf(0));
/*     */           }
/* 322 */           EnumFacing face = (EnumFacing)this.world.getBlockState(this.pos).getValue((IProperty)BlockHorizontal.FACING);
/* 323 */           ArrayList<EntityItem> output = new ArrayList<>();
/* 324 */           ArrayList<BlastFurnaceRecipes.outPut> result = new ArrayList<>();
/* 325 */           if (BlastFurnaceRecipes.INSTANCE.hasWorkResult(it)) {
/*     */             
/* 327 */             result = BlastFurnaceRecipes.INSTANCE.getWorkResult(it);
/*     */           }
/*     */           else {
/*     */             
/* 331 */             ItemStack temp = new ItemStack(ModItems.ASH, 1);
/* 332 */             BlastFurnaceRecipes.INSTANCE.getClass();result.add(new BlastFurnaceRecipes.outPut(temp.getItem(), temp.getMetadata(), temp.getCount()));
/* 333 */             }
/*     */           
/* 336 */           ItemStack st = (ItemStack)ks[rand];
/* 337 */           this.inputs.replace(st, Integer.valueOf(it.getCount() - 1));
/*     */           
/* 339 */           int q = 0;
/* 340 */           switch (face) {
/*     */             
/*     */             case NORTH:
/* 343 */               for (BlastFurnaceRecipes.outPut res : result) {
/*     */                 
/* 345 */                 output.add(new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() - 1.5D, new ItemStack(((BlastFurnaceRecipes.outPut)result.get(q)).item, ((BlastFurnaceRecipes.outPut)result.get(q)).count, ((BlastFurnaceRecipes.outPut)result.get(q)).meta)));
/* 346 */                 q++;
/*     */               } 
/*     */               break;
/*     */             case SOUTH:
/* 350 */               for (BlastFurnaceRecipes.outPut res : result) {
/*     */                 
/* 352 */                 output.add(new EntityItem(this.world, this.pos.getX() + 0.5D, this.pos.getY(), this.pos.getZ() + 2.5D, new ItemStack(((BlastFurnaceRecipes.outPut)result.get(q)).item, ((BlastFurnaceRecipes.outPut)result.get(q)).count, ((BlastFurnaceRecipes.outPut)result.get(q)).meta)));
/* 353 */                 q++;
/*     */               } 
/*     */               break;
/*     */             case EAST:
/* 357 */               for (BlastFurnaceRecipes.outPut res : result) {
/*     */                 
/* 359 */                 output.add(new EntityItem(this.world, this.pos.getX() + 2.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(((BlastFurnaceRecipes.outPut)result.get(q)).item, ((BlastFurnaceRecipes.outPut)result.get(q)).count, ((BlastFurnaceRecipes.outPut)result.get(q)).meta)));
/* 360 */                 q++;
/*     */               } 
/*     */               break;
/*     */             case WEST:
/* 364 */               for (BlastFurnaceRecipes.outPut res : result) {
/*     */                 
/* 366 */                 output.add(new EntityItem(this.world, this.pos.getX() - 1.5D, this.pos.getY(), this.pos.getZ() + 0.5D, new ItemStack(((BlastFurnaceRecipes.outPut)result.get(q)).item, ((BlastFurnaceRecipes.outPut)result.get(q)).count, ((BlastFurnaceRecipes.outPut)result.get(q)).meta)));
/* 367 */                 q++;
/*     */               } 
/*     */               break;
/*     */           } 
/*     */ 
/*     */           
/* 373 */           for (EntityItem t : output) {
/*     */             
/* 375 */             t.motionX = 0.025D * face.getFrontOffsetX();
/* 376 */             t.motionY = 0.075D;
/* 377 */             t.motionZ = 0.025D * face.getFrontOffsetZ();
/* 378 */             ps.transferData(EnumParticleTypes.EXPLOSION_NORMAL, RandomFunctions.rand.nextInt(5) + 1, t.posX, t.posY, t.posZ, t.dimension);
/* 379 */             ps.transferData(EnumParticleTypes.SMOKE_NORMAL, RandomFunctions.rand.nextInt(5) + 1, t.posX, t.posY, t.posZ, t.dimension);
/* 380 */             this.world.spawnEntity((Entity)t);
/*     */           } 
/* 382 */           flag1 = true;
/*     */         } 
/* 384 */         this.workTime++;
/*     */       }
/*     */       else {
/*     */         
/* 388 */         this.workTime = 0;
/*     */       } 
/*     */     } 
/* 391 */     if (flag1)
/*     */     {
/* 393 */       markDirty();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\objects\machines\blastfurnace\TileEntityBlastFurnace.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */