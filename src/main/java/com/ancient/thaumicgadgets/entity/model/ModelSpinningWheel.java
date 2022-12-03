/*     */ package com.ancient.thaumicgadgets.entity.model;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModelSpinningWheel
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer Stand;
/*     */   public ModelRenderer Stand2;
/*     */   public ModelRenderer w_t_l;
/*     */   public ModelRenderer w_t_r;
/*     */   public ModelRenderer w_b_r;
/*     */   public ModelRenderer w_b_l;
/*     */   public ModelRenderer w_c_b;
/*     */   public ModelRenderer w_c_t;
/*     */   public ModelRenderer w_c_r;
/*     */   public ModelRenderer w_c_l;
/*     */   public ModelRenderer wheel_top;
/*     */   public ModelRenderer wheel_bot;
/*     */   public ModelRenderer wheel_left;
/*     */   public ModelRenderer wheel_right;
/*     */   public ModelRenderer wheel_center;
/*     */   public ModelRenderer cloth;
/*     */   public ModelRenderer cloth_stand;
/*     */   public ModelRenderer Leg_1;
/*     */   public ModelRenderer Leg_2;
/*     */   public ModelRenderer Leg_3;
/*     */   
/*     */   public ModelSpinningWheel() {
/*  35 */     this.textureWidth = 64;
/*  36 */     this.textureHeight = 32;
/*  37 */     this.cloth = new ModelRenderer(this, 49, 6);
/*  38 */     this.cloth.setRotationPoint(-2.5F, 6.0F, 3.0F);
/*  39 */     this.cloth.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
/*  40 */     this.Stand = new ModelRenderer(this, 0, 0);
/*  41 */     this.Stand.setRotationPoint(-7.0F, 16.0F, -9.0F);
/*  42 */     this.Stand.addBox(0.0F, 0.0F, 0.0F, 14, 1, 16, 0.0F);
/*  43 */     setRotateAngle(this.Stand, 0.27314404F, 0.0F, 0.0F);
/*  44 */     this.w_b_l = new ModelRenderer(this, 48, 0);
/*  45 */     this.w_b_l.setRotationPoint(-1.5F, 10.75F, -3.7F);
/*  46 */     this.w_b_l.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/*  47 */     setRotateAngle(this.w_b_l, -0.7853982F, 0.0F, 0.0F);
/*  48 */     this.wheel_center = new ModelRenderer(this, 44, 6);
/*  49 */     this.wheel_center.setRotationPoint(1.0F, 10.0F, -6.0F);
/*  50 */     this.wheel_center.addBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
/*  51 */     this.Leg_1 = new ModelRenderer(this, 0, 17);
/*  52 */     this.Leg_1.setRotationPoint(0.0F, 16.0F, -8.0F);
/*  53 */     this.Leg_1.addBox(0.0F, 0.0F, 0.0F, 3, 8, 3, 0.0F);
/*  54 */     this.Leg_3 = new ModelRenderer(this, 20, 17);
/*  55 */     this.Leg_3.setRotationPoint(-6.5F, 13.0F, 4.0F);
/*  56 */     this.Leg_3.addBox(0.0F, 0.0F, 0.0F, 2, 11, 2, 0.0F);
/*  57 */     this.wheel_bot = new ModelRenderer(this, 56, 3);
/*  58 */     this.wheel_bot.setRotationPoint(-1.5F, 12.0F, -6.5F);
/*  59 */     this.wheel_bot.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
/*  60 */     this.Stand2 = new ModelRenderer(this, 0, 0);
/*  61 */     this.Stand2.setRotationPoint(2.0F, 9.2F, -6.6F);
/*  62 */     this.Stand2.addBox(0.0F, 0.0F, 0.0F, 1, 6, 2, 0.0F);
/*  63 */     this.w_t_l = new ModelRenderer(this, 6, 0);
/*  64 */     this.w_t_l.setRotationPoint(-1.5F, 8.7F, -5.1F);
/*  65 */     this.w_t_l.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/*  66 */     setRotateAngle(this.w_t_l, 0.7853982F, 0.0F, 0.0F);
/*  67 */     this.w_b_r = new ModelRenderer(this, 44, 0);
/*  68 */     this.w_b_r.setRotationPoint(-1.5F, 11.6F, -7.9F);
/*  69 */     this.w_b_r.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/*  70 */     setRotateAngle(this.w_b_r, 0.7853982F, 0.0F, 0.0F);
/*  71 */     this.wheel_right = new ModelRenderer(this, 6, 6);
/*  72 */     this.wheel_right.setRotationPoint(-1.5F, 9.5F, -8.0F);
/*  73 */     this.wheel_right.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/*  74 */     this.w_c_b = new ModelRenderer(this, 52, 0);
/*  75 */     this.w_c_b.setRotationPoint(-1.5F, 11.0F, -6.0F);
/*  76 */     this.w_c_b.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/*  77 */     this.w_c_r = new ModelRenderer(this, 6, 3);
/*  78 */     this.w_c_r.setRotationPoint(-1.5F, 10.0F, -5.0F);
/*  79 */     this.w_c_r.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
/*  80 */     this.wheel_top = new ModelRenderer(this, 50, 3);
/*  81 */     this.wheel_top.setRotationPoint(-1.5F, 8.0F, -6.5F);
/*  82 */     this.wheel_top.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
/*  83 */     this.w_c_t = new ModelRenderer(this, 56, 0);
/*  84 */     this.w_c_t.setRotationPoint(-1.5F, 9.0F, -6.0F);
/*  85 */     this.w_c_t.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/*  86 */     this.w_c_l = new ModelRenderer(this, 44, 3);
/*  87 */     this.w_c_l.setRotationPoint(-1.5F, 10.0F, -8.0F);
/*  88 */     this.w_c_l.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
/*  89 */     this.cloth_stand = new ModelRenderer(this, 10, 6);
/*  90 */     this.cloth_stand.setRotationPoint(-1.5F, 8.4F, 4.0F);
/*  91 */     this.cloth_stand.addBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
/*  92 */     this.w_t_r = new ModelRenderer(this, 10, 0);
/*  93 */     this.w_t_r.setRotationPoint(-1.5F, 8.05F, -6.6F);
/*  94 */     this.w_t_r.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/*  95 */     setRotateAngle(this.w_t_r, -0.7853982F, 0.0F, 0.0F);
/*  96 */     this.wheel_left = new ModelRenderer(this, 12, 3);
/*  97 */     this.wheel_left.setRotationPoint(-1.5F, 9.5F, -4.0F);
/*  98 */     this.wheel_left.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
/*  99 */     this.Leg_2 = new ModelRenderer(this, 12, 17);
/* 100 */     this.Leg_2.setRotationPoint(4.5F, 13.0F, 4.0F);
/* 101 */     this.Leg_2.addBox(0.0F, 0.0F, 0.0F, 2, 11, 2, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(TileEntity te, float f, float f1, float f2, float f3, float f4, float f5) {
/* 106 */     this.cloth.render(f5);
/* 107 */     this.Stand.render(f5);
/* 108 */     this.w_b_l.render(f5);
/* 109 */     this.wheel_center.render(f5);
/* 110 */     this.Leg_1.render(f5);
/* 111 */     this.Leg_3.render(f5);
/* 112 */     this.wheel_bot.render(f5);
/* 113 */     this.Stand2.render(f5);
/* 114 */     this.w_t_l.render(f5);
/* 115 */     this.w_b_r.render(f5);
/* 116 */     this.wheel_right.render(f5);
/* 117 */     this.w_c_b.render(f5);
/* 118 */     this.w_c_r.render(f5);
/* 119 */     this.wheel_top.render(f5);
/* 120 */     this.w_c_t.render(f5);
/* 121 */     this.w_c_l.render(f5);
/* 122 */     this.cloth_stand.render(f5);
/* 123 */     this.w_t_r.render(f5);
/* 124 */     this.wheel_left.render(f5);
/* 125 */     this.Leg_2.render(f5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 132 */     modelRenderer.rotateAngleX = x;
/* 133 */     modelRenderer.rotateAngleY = y;
/* 134 */     modelRenderer.rotateAngleZ = z;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\entity\model\ModelSpinningWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */