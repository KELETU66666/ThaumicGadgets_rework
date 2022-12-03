/*     */ package com.ancient.thaumicgadgets.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.math.MathHelper;
/*     */ 
/*     */ public class ModelCentaur
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer CowBody;
/*     */   public ModelRenderer Udders;
/*     */   public ModelRenderer RearLeftLeg;
/*     */   public ModelRenderer FrontLeftLeg;
/*     */   public ModelRenderer RearRightLeg;
/*     */   public ModelRenderer FrontRightLeg;
/*     */   public ModelRenderer VillagerHead;
/*     */   public ModelRenderer VillagerCoat;
/*     */   public ModelRenderer VillagerMiddleArm;
/*     */   public ModelRenderer VillagerRightArm;
/*     */   public ModelRenderer VillagerLeftArm;
/*     */   public ModelRenderer VillagerChest;
/*     */   public ModelRenderer VillagerNose;
/*     */   
/*     */   public ModelCentaur() {
/*  26 */     this.textureWidth = 64;
/*  27 */     this.textureHeight = 32;
/*  28 */     this.FrontLeftLeg = new ModelRenderer(this, 0, 16);
/*  29 */     this.FrontLeftLeg.setRotationPoint(4.0F, 12.0F, -6.0F);
/*  30 */     this.FrontLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  31 */     this.VillagerHead = new ModelRenderer(this, 0, 0);
/*  32 */     this.VillagerHead.setRotationPoint(0.0F, -15.0F, -3.0F);
/*  33 */     this.VillagerHead.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
/*  34 */     this.CowBody = new ModelRenderer(this, 18, 4);
/*  35 */     this.CowBody.setRotationPoint(0.0F, 5.0F, 2.0F);
/*  36 */     this.CowBody.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
/*  37 */     setRotateAngle(this.CowBody, 1.5707964F, 0.0F, 0.0F);
/*  38 */     this.FrontRightLeg = new ModelRenderer(this, 0, 16);
/*  39 */     this.FrontRightLeg.setRotationPoint(-4.0F, 12.0F, -6.0F);
/*  40 */     this.FrontRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  41 */     this.VillagerMiddleArm = new ModelRenderer(this, 40, 38);
/*  42 */     this.VillagerMiddleArm.setRotationPoint(0.0F, -12.0F, -4.0F);
/*  43 */     this.VillagerMiddleArm.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
/*  44 */     setRotateAngle(this.VillagerMiddleArm, -0.749968F, 0.0F, 0.0F);
/*  45 */     this.RearLeftLeg = new ModelRenderer(this, 0, 16);
/*  46 */     this.RearLeftLeg.setRotationPoint(4.0F, 12.0F, 7.0F);
/*  47 */     this.RearLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  48 */     this.VillagerCoat = new ModelRenderer(this, 0, 38);
/*  49 */     this.VillagerCoat.setRotationPoint(0.0F, -15.0F, -3.0F);
/*  50 */     this.VillagerCoat.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
/*  51 */     this.Udders = new ModelRenderer(this, 52, 0);
/*  52 */     this.Udders.setRotationPoint(0.0F, 5.0F, 2.0F);
/*  53 */     this.Udders.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
/*  54 */     setRotateAngle(this.Udders, 1.5707964F, 0.0F, 0.0F);
/*  55 */     this.VillagerNose = new ModelRenderer(this, 24, 0);
/*  56 */     this.VillagerNose.setRotationPoint(0.0F, -2.0F, 0.0F);
/*  57 */     this.VillagerNose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
/*  58 */     this.VillagerRightArm = new ModelRenderer(this, 44, 22);
/*  59 */     this.VillagerRightArm.setRotationPoint(0.0F, -12.0F, -4.0F);
/*  60 */     this.VillagerRightArm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
/*  61 */     setRotateAngle(this.VillagerRightArm, -0.749968F, 0.0F, 0.0F);
/*  62 */     this.VillagerLeftArm = new ModelRenderer(this, 44, 22);
/*  63 */     this.VillagerLeftArm.setRotationPoint(0.0F, -12.0F, -4.0F);
/*  64 */     this.VillagerLeftArm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
/*  65 */     setRotateAngle(this.VillagerLeftArm, -0.749968F, 0.0F, 0.0F);
/*  66 */     this.VillagerChest = new ModelRenderer(this, 16, 20);
/*  67 */     this.VillagerChest.setRotationPoint(0.0F, -12.0F, -3.0F);
/*  68 */     this.VillagerChest.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
/*  69 */     this.RearRightLeg = new ModelRenderer(this, 0, 16);
/*  70 */     this.RearRightLeg.setRotationPoint(-4.0F, 12.0F, 7.0F);
/*  71 */     this.RearRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  72 */     this.VillagerHead.addChild(this.VillagerNose);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/*  78 */     this.FrontLeftLeg.render(f5);
/*  79 */     this.VillagerHead.render(f5);
/*  80 */     this.CowBody.render(f5);
/*  81 */     this.FrontRightLeg.render(f5);
/*  82 */     this.VillagerMiddleArm.render(f5);
/*  83 */     this.RearLeftLeg.render(f5);
/*  84 */     this.VillagerCoat.render(f5);
/*  85 */     this.Udders.render(f5);
/*  86 */     this.VillagerRightArm.render(f5);
/*  87 */     this.VillagerLeftArm.render(f5);
/*  88 */     this.VillagerChest.render(f5);
/*  89 */     this.RearRightLeg.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  97 */     modelRenderer.rotateAngleX = x;
/*  98 */     modelRenderer.rotateAngleY = y;
/*  99 */     modelRenderer.rotateAngleZ = z;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
/* 105 */     this.FrontLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
/* 106 */     this.RearLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
/* 107 */     this.FrontRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
/* 108 */     this.RearRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
/*     */     
/* 110 */     this.VillagerHead.rotateAngleY = netHeadYaw * 0.017453292F;
/* 111 */     this.VillagerHead.rotateAngleX = headPitch * 0.017453292F;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\entity\model\ModelCentaur.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */