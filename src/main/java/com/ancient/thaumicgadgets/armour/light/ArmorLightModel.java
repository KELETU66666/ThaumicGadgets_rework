/*     */ package com.ancient.thaumicgadgets.armour.light;
/*     */ 
/*     */ import baubles.api.BaublesApi;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ArmorLightModel
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer RShoulderMid2;
/*     */   ModelRenderer RShoulderForw1;
/*     */   ModelRenderer RShoulderBottom;
/*     */   ModelRenderer RShoulderBack;
/*     */   ModelRenderer RShoulderHigh;
/*     */   ModelRenderer RShoulderTop1;
/*     */   ModelRenderer RShoulderTop2;
/*     */   ModelRenderer RShoulderTop3;
/*     */   ModelRenderer RShoulderTop4;
/*     */   ModelRenderer LShoulderTop5;
/*     */   ModelRenderer LShoulderBack;
/*     */   ModelRenderer LShoulderMid2;
/*     */   ModelRenderer RShoulderMid1;
/*     */   ModelRenderer LShoulderBottom;
/*     */   ModelRenderer RShoulderForw;
/*     */   ModelRenderer LShoulderForw1;
/*     */   ModelRenderer LSholuderBack1;
/*     */   ModelRenderer LShoulderHigh;
/*     */   ModelRenderer LShoulderTop1;
/*     */   ModelRenderer LShoulderSquareF;
/*     */   ModelRenderer LShoulderTop2;
/*     */   ModelRenderer RshoulderTop5;
/*     */   ModelRenderer LShoulderTop4;
/*     */   ModelRenderer LShoulderForw;
/*     */   ModelRenderer LShoulderTop3;
/*     */   ModelRenderer RSholuderBack1;
/*     */   ModelRenderer RShoulderSquareB;
/*     */   ModelRenderer LShoulderMid1;
/*     */   ModelRenderer ArmorPlateB1;
/*     */   ModelRenderer BeltB;
/*     */   ModelRenderer CloakF;
/*     */   ModelRenderer GlovesTop2;
/*     */   ModelRenderer GlovesBottom2;
/*     */   ModelRenderer GlovesTop1;
/*     */   ModelRenderer GlovesBottom1;
/*     */   ModelRenderer GlovesMain2;
/*     */   ModelRenderer GlovesMain1;
/*     */   ModelRenderer ArmorPlateB2;
/*     */   ModelRenderer RShoulderSquareF;
/*     */   ModelRenderer LLegArmor1;
/*     */   ModelRenderer RLegArmor1;
/*     */   ModelRenderer RLegArmor2;
/*     */   ModelRenderer LLegArmor2;
/*     */   ModelRenderer LBootsBase;
/*     */   ModelRenderer ArmorPlate1;
/*     */   ModelRenderer ArmorPlate2;
/*     */   ModelRenderer LShoulderSquareB;
/*     */   ModelRenderer RBootsBase;
/*     */   ModelRenderer LBootsF;
/*     */   ModelRenderer RBootsF;
/*     */   ModelRenderer WingLeft;
/*     */   ModelRenderer WingRight;
/*     */   
/*     */   public ArmorLightModel(float f) {
/*  69 */     super(f, 0.0F, 96, 64);
/*  70 */     this.textureWidth = 96;
/*  71 */     this.textureHeight = 64;
/*     */     
/*  73 */     this.RShoulderMid2 = new ModelRenderer((ModelBase)this, 0, 47);
/*  74 */     this.RShoulderMid2.addBox(-3.7F, -0.3F, -1.5F, 1, 2, 3);
/*  75 */     this.RShoulderMid2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  76 */     this.RShoulderMid2.setTextureSize(96, 64);
/*  77 */     this.RShoulderMid2.mirror = true;
/*  78 */     setRotation(this.RShoulderMid2, 0.0F, 0.0F, 0.0F);
/*  79 */     this.RShoulderForw1 = new ModelRenderer((ModelBase)this, 6, 53);
/*  80 */     this.RShoulderForw1.addBox(-4.0F, -1.0F, 1.2F, 3, 2, 1);
/*  81 */     this.RShoulderForw1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  82 */     this.RShoulderForw1.setTextureSize(96, 64);
/*  83 */     this.RShoulderForw1.mirror = true;
/*  84 */     setRotation(this.RShoulderForw1, 0.0F, 0.0F, -0.0523599F);
/*  85 */     this.RShoulderBottom = new ModelRenderer((ModelBase)this, 60, 61);
/*  86 */     this.RShoulderBottom.addBox(-3.7F, 0.7F, 0.7F, 1, 1, 1);
/*  87 */     this.RShoulderBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  88 */     this.RShoulderBottom.setTextureSize(96, 64);
/*  89 */     this.RShoulderBottom.mirror = true;
/*  90 */     setRotation(this.RShoulderBottom, -0.7853982F, 0.0F, 0.0F);
/*  91 */     this.RShoulderBack = new ModelRenderer((ModelBase)this, 15, 54);
/*  92 */     this.RShoulderBack.addBox(-4.0F, -2.5F, -2.5F, 5, 2, 1);
/*  93 */     this.RShoulderBack.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  94 */     this.RShoulderBack.setTextureSize(96, 64);
/*  95 */     this.RShoulderBack.mirror = true;
/*  96 */     setRotation(this.RShoulderBack, 0.0F, 0.0F, -0.0523599F);
/*  97 */     this.RShoulderHigh = new ModelRenderer((ModelBase)this, 6, 57);
/*  98 */     this.RShoulderHigh.addBox(-4.0F, -3.3F, -2.5F, 5, 2, 5);
/*  99 */     this.RShoulderHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 100 */     this.RShoulderHigh.setTextureSize(96, 64);
/* 101 */     this.RShoulderHigh.mirror = true;
/* 102 */     setRotation(this.RShoulderHigh, 0.0F, 0.0F, -0.0523599F);
/* 103 */     this.RShoulderTop1 = new ModelRenderer((ModelBase)this, 26, 58);
/* 104 */     this.RShoulderTop1.addBox(-3.0F, -3.6F, -2.0F, 4, 2, 4);
/* 105 */     this.RShoulderTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 106 */     this.RShoulderTop1.setTextureSize(96, 64);
/* 107 */     this.RShoulderTop1.mirror = true;
/* 108 */     setRotation(this.RShoulderTop1, 0.0F, 0.0F, -0.0349066F);
/* 109 */     this.RShoulderTop2 = new ModelRenderer((ModelBase)this, 42, 59);
/* 110 */     this.RShoulderTop2.addBox(-1.0F, -3.9F, -1.5F, 2, 2, 3);
/* 111 */     this.RShoulderTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 112 */     this.RShoulderTop2.setTextureSize(96, 64);
/* 113 */     this.RShoulderTop2.mirror = true;
/* 114 */     setRotation(this.RShoulderTop2, 0.0F, 0.0F, -0.0174533F);
/* 115 */     this.RShoulderTop3 = new ModelRenderer((ModelBase)this, 60, 61);
/* 116 */     this.RShoulderTop3.addBox(0.0F, -4.7F, -0.5F, 1, 2, 1);
/* 117 */     this.RShoulderTop3.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 118 */     this.RShoulderTop3.setTextureSize(96, 64);
/* 119 */     this.RShoulderTop3.mirror = true;
/* 120 */     setRotation(this.RShoulderTop3, 0.0F, 0.0F, 0.0F);
/* 121 */     this.RShoulderTop4 = new ModelRenderer((ModelBase)this, 52, 60);
/* 122 */     this.RShoulderTop4.addBox(0.0F, -4.3F, -1.5F, 1, 1, 3);
/* 123 */     this.RShoulderTop4.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 124 */     this.RShoulderTop4.setTextureSize(96, 64);
/* 125 */     this.RShoulderTop4.mirror = true;
/* 126 */     setRotation(this.RShoulderTop4, 0.0F, 0.0F, 0.0F);
/* 127 */     this.LShoulderTop5 = new ModelRenderer((ModelBase)this, 42, 54);
/* 128 */     this.LShoulderTop5.addBox(2.4F, -2.0F, -1.5F, 2, 1, 3);
/* 129 */     this.LShoulderTop5.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 130 */     this.LShoulderTop5.setTextureSize(96, 64);
/* 131 */     this.LShoulderTop5.mirror = true;
/* 132 */     setRotation(this.LShoulderTop5, 0.0F, 0.0F, 0.0523599F);
/* 133 */     this.LShoulderBack = new ModelRenderer((ModelBase)this, 15, 54);
/* 134 */     this.LShoulderBack.addBox(-1.0F, -2.5F, -2.5F, 5, 2, 1);
/* 135 */     this.LShoulderBack.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 136 */     this.LShoulderBack.setTextureSize(96, 64);
/* 137 */     this.LShoulderBack.mirror = true;
/* 138 */     setRotation(this.LShoulderBack, 0.0F, 0.0F, 0.0523599F);
/* 139 */     this.LShoulderMid2 = new ModelRenderer((ModelBase)this, 0, 47);
/* 140 */     this.LShoulderMid2.addBox(2.3F, -0.3F, -1.5F, 1, 2, 3);
/* 141 */     this.LShoulderMid2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 142 */     this.LShoulderMid2.setTextureSize(96, 64);
/* 143 */     this.LShoulderMid2.mirror = true;
/* 144 */     setRotation(this.LShoulderMid2, 0.0F, 0.0F, 0.0F);
/* 145 */     this.RShoulderMid1 = new ModelRenderer((ModelBase)this, 69, 0);
/* 146 */     this.RShoulderMid1.addBox(-4.0F, -2.0F, -2.0F, 1, 3, 4);
/* 147 */     this.RShoulderMid1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 148 */     this.RShoulderMid1.setTextureSize(96, 64);
/* 149 */     this.RShoulderMid1.mirror = true;
/* 150 */     setRotation(this.RShoulderMid1, 0.0F, 0.0F, -0.0523599F);
/* 151 */     this.LShoulderBottom = new ModelRenderer((ModelBase)this, 60, 61);
/* 152 */     this.LShoulderBottom.addBox(2.3F, 0.7F, 0.7F, 1, 1, 1);
/* 153 */     this.LShoulderBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 154 */     this.LShoulderBottom.setTextureSize(96, 64);
/* 155 */     this.LShoulderBottom.mirror = true;
/* 156 */     setRotation(this.LShoulderBottom, -0.7853982F, 0.0F, 0.0174533F);
/* 157 */     this.RShoulderForw = new ModelRenderer((ModelBase)this, 28, 54);
/* 158 */     this.RShoulderForw.addBox(-4.0F, -2.5F, 1.5F, 4, 2, 1);
/* 159 */     this.RShoulderForw.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 160 */     this.RShoulderForw.setTextureSize(96, 64);
/* 161 */     this.RShoulderForw.mirror = true;
/* 162 */     setRotation(this.RShoulderForw, 0.0F, 0.0F, -0.0523599F);
/* 163 */     this.LShoulderForw1 = new ModelRenderer((ModelBase)this, 6, 53);
/* 164 */     this.LShoulderForw1.addBox(0.0F, -1.0F, 1.2F, 3, 2, 1);
/* 165 */     this.LShoulderForw1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 166 */     this.LShoulderForw1.setTextureSize(96, 64);
/* 167 */     this.LShoulderForw1.mirror = true;
/* 168 */     setRotation(this.LShoulderForw1, 0.0F, 0.0F, 0.0F);
/* 169 */     this.LSholuderBack1 = new ModelRenderer((ModelBase)this, 6, 53);
/* 170 */     this.LSholuderBack1.addBox(0.0F, -1.0F, -2.2F, 3, 2, 1);
/* 171 */     this.LSholuderBack1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 172 */     this.LSholuderBack1.setTextureSize(96, 64);
/* 173 */     this.LSholuderBack1.mirror = true;
/* 174 */     setRotation(this.LSholuderBack1, 0.0F, 0.0F, 0.0F);
/* 175 */     this.LShoulderHigh = new ModelRenderer((ModelBase)this, 6, 57);
/* 176 */     this.LShoulderHigh.addBox(-1.0F, -3.3F, -2.5F, 5, 2, 5);
/* 177 */     this.LShoulderHigh.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 178 */     this.LShoulderHigh.setTextureSize(96, 64);
/* 179 */     this.LShoulderHigh.mirror = true;
/* 180 */     setRotation(this.LShoulderHigh, 0.0F, 0.0F, 0.0523599F);
/* 181 */     this.LShoulderTop1 = new ModelRenderer((ModelBase)this, 26, 58);
/* 182 */     this.LShoulderTop1.addBox(-1.0F, -3.6F, -2.0F, 4, 2, 4);
/* 183 */     this.LShoulderTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 184 */     this.LShoulderTop1.setTextureSize(96, 64);
/* 185 */     this.LShoulderTop1.mirror = true;
/* 186 */     setRotation(this.LShoulderTop1, 0.0F, 0.0F, 0.0349066F);
/* 187 */     this.LShoulderSquareF = new ModelRenderer((ModelBase)this, 52, 55);
/* 188 */     this.LShoulderSquareF.addBox(-2.0F, -2.0F, -3.2F, 3, 3, 1);
/* 189 */     this.LShoulderSquareF.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 190 */     this.LShoulderSquareF.setTextureSize(96, 64);
/* 191 */     this.LShoulderSquareF.mirror = true;
/* 192 */     setRotation(this.LShoulderSquareF, 0.0F, 0.0F, 0.0F);
/* 193 */     this.LShoulderTop2 = new ModelRenderer((ModelBase)this, 42, 59);
/* 194 */     this.LShoulderTop2.addBox(-1.0F, -3.9F, -1.5F, 2, 2, 3);
/* 195 */     this.LShoulderTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 196 */     this.LShoulderTop2.setTextureSize(96, 64);
/* 197 */     this.LShoulderTop2.mirror = true;
/* 198 */     setRotation(this.LShoulderTop2, 0.0F, 0.0F, 0.0174533F);
/* 199 */     this.RshoulderTop5 = new ModelRenderer((ModelBase)this, 42, 54);
/* 200 */     this.RshoulderTop5.addBox(-4.6F, -2.0F, -1.5F, 2, 1, 3);
/* 201 */     this.RshoulderTop5.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 202 */     this.RshoulderTop5.setTextureSize(96, 64);
/* 203 */     this.RshoulderTop5.mirror = true;
/* 204 */     setRotation(this.RshoulderTop5, 0.0F, 0.0F, -0.0523599F);
/* 205 */     this.LShoulderTop4 = new ModelRenderer((ModelBase)this, 52, 60);
/* 206 */     this.LShoulderTop4.addBox(-1.0F, -4.3F, -1.5F, 1, 1, 3);
/* 207 */     this.LShoulderTop4.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 208 */     this.LShoulderTop4.setTextureSize(96, 64);
/* 209 */     this.LShoulderTop4.mirror = true;
/* 210 */     setRotation(this.LShoulderTop4, 0.0F, 0.0F, 0.0F);
/* 211 */     this.LShoulderForw = new ModelRenderer((ModelBase)this, 28, 54);
/* 212 */     this.LShoulderForw.addBox(-1.0F, -2.5F, 1.5F, 4, 2, 1);
/* 213 */     this.LShoulderForw.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 214 */     this.LShoulderForw.setTextureSize(96, 64);
/* 215 */     this.LShoulderForw.mirror = true;
/* 216 */     setRotation(this.LShoulderForw, 0.0F, 0.0F, 0.0523599F);
/* 217 */     this.LShoulderTop3 = new ModelRenderer((ModelBase)this, 60, 61);
/* 218 */     this.LShoulderTop3.addBox(-1.0F, -4.7F, -0.5F, 1, 2, 1);
/* 219 */     this.LShoulderTop3.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 220 */     this.LShoulderTop3.setTextureSize(96, 64);
/* 221 */     this.LShoulderTop3.mirror = true;
/* 222 */     setRotation(this.LShoulderTop3, 0.0F, 0.0F, 0.0F);
/* 223 */     this.RSholuderBack1 = new ModelRenderer((ModelBase)this, 6, 53);
/* 224 */     this.RSholuderBack1.addBox(-4.0F, -1.0F, -2.2F, 3, 2, 1);
/* 225 */     this.RSholuderBack1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 226 */     this.RSholuderBack1.setTextureSize(96, 64);
/* 227 */     this.RSholuderBack1.mirror = true;
/* 228 */     setRotation(this.RSholuderBack1, 0.0F, 0.0F, -0.0523599F);
/* 229 */     this.RShoulderSquareB = new ModelRenderer((ModelBase)this, 52, 55);
/* 230 */     this.RShoulderSquareB.addBox(-1.0F, -2.0F, 2.8F, 3, 3, 1);
/* 231 */     this.RShoulderSquareB.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 232 */     this.RShoulderSquareB.setTextureSize(96, 64);
/* 233 */     this.RShoulderSquareB.mirror = true;
/* 234 */     setRotation(this.RShoulderSquareB, 0.0F, 0.0F, 0.0F);
/* 235 */     this.LShoulderMid1 = new ModelRenderer((ModelBase)this, 69, 0);
/* 236 */     this.LShoulderMid1.addBox(3.0F, -2.0F, -2.0F, 1, 3, 4);
/* 237 */     this.LShoulderMid1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 238 */     this.LShoulderMid1.setTextureSize(96, 64);
/* 239 */     this.LShoulderMid1.mirror = true;
/* 240 */     setRotation(this.LShoulderMid1, 0.0F, 0.0F, 0.0523599F);
/* 241 */     this.ArmorPlateB1 = new ModelRenderer((ModelBase)this, 18, 45);
/* 242 */     this.ArmorPlateB1.addBox(-4.0F, 0.0F, 1.7F, 8, 5, 2);
/* 243 */     this.ArmorPlateB1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 244 */     this.ArmorPlateB1.setTextureSize(96, 64);
/* 245 */     this.ArmorPlateB1.mirror = true;
/* 246 */     setRotation(this.ArmorPlateB1, -0.0523599F, 0.0F, 0.0F);
/* 247 */     this.BeltB = new ModelRenderer((ModelBase)this, 33, 32);
/* 248 */     this.BeltB.addBox(-4.2F, 9.0F, -3.2F, 8, 2, 6);
/* 249 */     this.BeltB.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 250 */     this.BeltB.setTextureSize(96, 64);
/* 251 */     this.BeltB.mirror = true;
/* 252 */     setRotation(this.BeltB, 0.0F, 0.0F, 0.0F);
/* 253 */     this.CloakF = new ModelRenderer((ModelBase)this, 80, 0);
/* 254 */     this.CloakF.addBox(-3.5F, 1.0F, -2.7F, 7, 14, 1);
/* 255 */     this.CloakF.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 256 */     this.CloakF.setTextureSize(96, 64);
/* 257 */     this.CloakF.mirror = true;
/* 258 */     setRotation(this.CloakF, 0.0F, 0.0F, 0.0F);
/* 259 */     this.GlovesTop2 = new ModelRenderer((ModelBase)this, 0, 60);
/* 260 */     this.GlovesTop2.addBox(-3.6F, 5.0F, -7.0F, 1, 2, 2);
/* 261 */     this.GlovesTop2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 262 */     this.GlovesTop2.setTextureSize(96, 64);
/* 263 */     this.GlovesTop2.mirror = true;
/* 264 */     setRotation(this.GlovesTop2, 0.7853982F, 0.0F, 0.0F);
/* 265 */     this.GlovesBottom2 = new ModelRenderer((ModelBase)this, 0, 60);
/* 266 */     this.GlovesBottom2.addBox(-3.6F, 5.5F, -7.5F, 1, 2, 2);
/* 267 */     this.GlovesBottom2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 268 */     this.GlovesBottom2.setTextureSize(96, 64);
/* 269 */     this.GlovesBottom2.mirror = true;
/* 270 */     setRotation(this.GlovesBottom2, 0.7853982F, 0.0F, 0.0F);
/* 271 */     this.GlovesTop1 = new ModelRenderer((ModelBase)this, 0, 60);
/* 272 */     this.GlovesTop1.addBox(2.6F, 5.0F, -7.0F, 1, 2, 2);
/* 273 */     this.GlovesTop1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 274 */     this.GlovesTop1.setTextureSize(96, 64);
/* 275 */     this.GlovesTop1.mirror = true;
/* 276 */     setRotation(this.GlovesTop1, 0.7853982F, 0.0F, 0.0F);
/* 277 */     this.GlovesBottom1 = new ModelRenderer((ModelBase)this, 0, 60);
/* 278 */     this.GlovesBottom1.addBox(2.6F, 5.5F, -7.5F, 1, 2, 2);
/* 279 */     this.GlovesBottom1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 280 */     this.GlovesBottom1.setTextureSize(96, 64);
/* 281 */     this.GlovesBottom1.mirror = true;
/* 282 */     setRotation(this.GlovesBottom1, 0.7853982F, 0.0F, 0.0F);
/* 283 */     this.GlovesMain2 = new ModelRenderer((ModelBase)this, 9, 45);
/* 284 */     this.GlovesMain2.addBox(-3.5F, 4.5F, -1.5F, 1, 4, 3);
/* 285 */     this.GlovesMain2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 286 */     this.GlovesMain2.setTextureSize(96, 64);
/* 287 */     this.GlovesMain2.mirror = true;
/* 288 */     setRotation(this.GlovesMain2, 0.0F, 0.0F, 0.0F);
/* 289 */     this.GlovesMain1 = new ModelRenderer((ModelBase)this, 9, 45);
/* 290 */     this.GlovesMain1.addBox(2.5F, 4.5F, -1.5F, 1, 4, 3);
/* 291 */     this.GlovesMain1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 292 */     this.GlovesMain1.setTextureSize(96, 64);
/* 293 */     this.GlovesMain1.mirror = true;
/* 294 */     setRotation(this.GlovesMain1, 0.0F, 0.0F, 0.0F);
/* 295 */     this.ArmorPlateB2 = new ModelRenderer((ModelBase)this, 18, 45);
/* 296 */     this.ArmorPlateB2.addBox(-4.0F, 4.0F, 1.4F, 8, 5, 2);
/* 297 */     this.ArmorPlateB2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 298 */     this.ArmorPlateB2.setTextureSize(96, 64);
/* 299 */     this.ArmorPlateB2.mirror = true;
/* 300 */     setRotation(this.ArmorPlateB2, -0.0872665F, 0.0F, 0.0F);
/* 301 */     this.RShoulderSquareF = new ModelRenderer((ModelBase)this, 52, 55);
/* 302 */     this.RShoulderSquareF.addBox(-1.0F, -2.0F, -3.2F, 3, 3, 1);
/* 303 */     this.RShoulderSquareF.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 304 */     this.RShoulderSquareF.setTextureSize(96, 64);
/* 305 */     this.RShoulderSquareF.mirror = true;
/* 306 */     setRotation(this.RShoulderSquareF, 0.0F, 0.0F, 0.0F);
/* 307 */     this.LLegArmor1 = new ModelRenderer((ModelBase)this, 52, 44);
/* 308 */     this.LLegArmor1.addBox(1.8F, 1.0F, -2.5F, 1, 5, 5);
/* 309 */     this.LLegArmor1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 310 */     this.LLegArmor1.setTextureSize(96, 64);
/* 311 */     this.LLegArmor1.mirror = true;
/* 312 */     setRotation(this.LLegArmor1, 0.0F, 0.0F, -0.122173F);
/* 313 */     this.RLegArmor1 = new ModelRenderer((ModelBase)this, 52, 44);
/* 314 */     this.RLegArmor1.addBox(-2.8F, 1.0F, -2.5F, 1, 5, 5);
/* 315 */     this.RLegArmor1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 316 */     this.RLegArmor1.setTextureSize(96, 64);
/* 317 */     this.RLegArmor1.mirror = true;
/* 318 */     setRotation(this.RLegArmor1, 0.0F, 0.0F, 0.1396263F);
/* 319 */     this.RLegArmor2 = new ModelRenderer((ModelBase)this, 52, 45);
/* 320 */     this.RLegArmor2.addBox(-3.0F, -1.0F, -2.5F, 1, 4, 5);
/* 321 */     this.RLegArmor2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 322 */     this.RLegArmor2.setTextureSize(96, 64);
/* 323 */     this.RLegArmor2.mirror = true;
/* 324 */     setRotation(this.RLegArmor2, 0.0F, 0.0F, 0.0F);
/* 325 */     this.LLegArmor2 = new ModelRenderer((ModelBase)this, 52, 45);
/* 326 */     this.LLegArmor2.addBox(2.0F, -1.0F, -2.5F, 1, 4, 5);
/* 327 */     this.LLegArmor2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 328 */     this.LLegArmor2.setTextureSize(96, 64);
/* 329 */     this.LLegArmor2.mirror = true;
/* 330 */     setRotation(this.LLegArmor2, 0.0F, 0.0F, 0.0F);
/* 331 */     this.LBootsBase = new ModelRenderer((ModelBase)this, 0, 35);
/* 332 */     this.LBootsBase.addBox(-2.2F, 7.0F, -2.5F, 5, 5, 5);
/* 333 */     this.LBootsBase.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 334 */     this.LBootsBase.setTextureSize(96, 64);
/* 335 */     this.LBootsBase.mirror = true;
/* 336 */     setRotation(this.LBootsBase, 0.0F, 0.0F, 0.0F);
/* 337 */     this.ArmorPlate1 = new ModelRenderer((ModelBase)this, 38, 47);
/* 338 */     this.ArmorPlate1.addBox(-2.7F, 1.0F, -2.6F, 5, 4, 1);
/* 339 */     this.ArmorPlate1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 340 */     this.ArmorPlate1.setTextureSize(96, 64);
/* 341 */     this.ArmorPlate1.mirror = true;
/* 342 */     setRotation(this.ArmorPlate1, 0.0F, 0.0F, 0.418879F);
/* 343 */     this.ArmorPlate2 = new ModelRenderer((ModelBase)this, 38, 47);
/* 344 */     this.ArmorPlate2.addBox(-2.3F, 1.0F, -2.6F, 5, 4, 1);
/* 345 */     this.ArmorPlate2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 346 */     this.ArmorPlate2.setTextureSize(96, 64);
/* 347 */     this.ArmorPlate2.mirror = true;
/* 348 */     setRotation(this.ArmorPlate2, 0.0F, 0.0F, -0.4363323F);
/* 349 */     this.LShoulderSquareB = new ModelRenderer((ModelBase)this, 52, 55);
/* 350 */     this.LShoulderSquareB.addBox(-1.7F, -2.0F, 2.8F, 3, 3, 1);
/* 351 */     this.LShoulderSquareB.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 352 */     this.LShoulderSquareB.setTextureSize(96, 64);
/* 353 */     this.LShoulderSquareB.mirror = true;
/* 354 */     setRotation(this.LShoulderSquareB, 0.0F, 0.0F, 0.0F);
/* 355 */     this.RBootsBase = new ModelRenderer((ModelBase)this, 0, 35);
/* 356 */     this.RBootsBase.addBox(-2.8F, 7.0F, -2.5F, 5, 5, 5);
/* 357 */     this.RBootsBase.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 358 */     this.RBootsBase.setTextureSize(96, 64);
/* 359 */     this.RBootsBase.mirror = true;
/* 360 */     setRotation(this.RBootsBase, 0.0F, 0.0F, 0.0F);
/* 361 */     this.LBootsF = new ModelRenderer((ModelBase)this, 21, 39);
/* 362 */     this.LBootsF.addBox(-3.2F, 9.0F, -4.0F, 3, 3, 3);
/* 363 */     this.LBootsF.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 364 */     this.LBootsF.setTextureSize(96, 64);
/* 365 */     this.LBootsF.mirror = true;
/* 366 */     setRotation(this.LBootsF, 0.0F, -0.7853982F, 0.0F);
/* 367 */     this.RBootsF = new ModelRenderer((ModelBase)this, 21, 39);
/* 368 */     this.RBootsF.addBox(-3.7F, 9.0F, -2.9F, 3, 3, 3);
/* 369 */     this.RBootsF.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 370 */     this.RBootsF.setTextureSize(96, 64);
/* 371 */     this.RBootsF.mirror = true;
/* 372 */     setRotation(this.RBootsF, 0.0F, -0.7853982F, 0.0F);
/*     */     
/* 374 */     this.WingLeft = new ModelRenderer((ModelBase)this, 72, 17);
/* 375 */     this.WingLeft.addBox(-13.0F, -7.0F, -4.5F, 11, 15, 1);
/* 376 */     this.WingLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 377 */     this.WingLeft.setTextureSize(96, 64);
/* 378 */     this.WingLeft.mirror = false;
/* 379 */     setRotation(this.WingLeft, 0.0F, 3.14159F, 0.0F);
/*     */     
/* 381 */     this.WingRight = new ModelRenderer((ModelBase)this, 72, 17);
/* 382 */     this.WingRight.addBox(-13.0F, -7.0F, 3.5F, 11, 15, 1);
/* 383 */     this.WingRight.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 384 */     this.WingRight.setTextureSize(96, 64);
/* 385 */     this.WingRight.mirror = true;
/* 386 */     setRotation(this.WingRight, 0.0F, 0.0F, 0.0F);
/*     */     
/* 388 */     this.bipedRightArm.addChild(this.RShoulderForw);
/* 389 */     this.bipedRightArm.addChild(this.RShoulderForw1);
/*     */     
/* 391 */     this.bipedRightArm.addChild(this.RShoulderBack);
/* 392 */     this.bipedRightArm.addChild(this.RSholuderBack1);
/*     */     
/* 394 */     this.bipedRightArm.addChild(this.RShoulderMid1);
/* 395 */     this.bipedRightArm.addChild(this.RShoulderMid2);
/*     */     
/* 397 */     this.bipedRightArm.addChild(this.RShoulderBottom);
/*     */     
/* 399 */     this.bipedRightArm.addChild(this.RShoulderHigh);
/* 400 */     this.bipedRightArm.addChild(this.RShoulderTop1);
/* 401 */     this.bipedRightArm.addChild(this.RShoulderTop2);
/* 402 */     this.bipedRightArm.addChild(this.RShoulderTop3);
/* 403 */     this.bipedRightArm.addChild(this.RShoulderTop4);
/* 404 */     this.bipedRightArm.addChild(this.RshoulderTop5);
/*     */     
/* 406 */     this.bipedRightArm.addChild(this.RShoulderSquareB);
/* 407 */     this.bipedRightArm.addChild(this.RShoulderSquareF);
/*     */ 
/*     */     
/* 410 */     this.bipedLeftArm.addChild(this.LShoulderForw);
/* 411 */     this.bipedLeftArm.addChild(this.LShoulderForw1);
/*     */     
/* 413 */     this.bipedLeftArm.addChild(this.LShoulderBack);
/* 414 */     this.bipedLeftArm.addChild(this.LSholuderBack1);
/*     */     
/* 416 */     this.bipedLeftArm.addChild(this.LShoulderMid1);
/* 417 */     this.bipedLeftArm.addChild(this.LShoulderMid2);
/*     */     
/* 419 */     this.bipedLeftArm.addChild(this.LShoulderBottom);
/*     */     
/* 421 */     this.bipedLeftArm.addChild(this.LShoulderHigh);
/* 422 */     this.bipedLeftArm.addChild(this.LShoulderTop1);
/* 423 */     this.bipedLeftArm.addChild(this.LShoulderTop2);
/* 424 */     this.bipedLeftArm.addChild(this.LShoulderTop3);
/* 425 */     this.bipedLeftArm.addChild(this.LShoulderTop4);
/* 426 */     this.bipedLeftArm.addChild(this.LShoulderTop5);
/*     */     
/* 428 */     this.bipedLeftArm.addChild(this.LShoulderSquareF);
/* 429 */     this.bipedLeftArm.addChild(this.LShoulderSquareB);
/*     */     
/* 431 */     this.bipedBody.addChild(this.ArmorPlate1);
/* 432 */     this.bipedBody.addChild(this.ArmorPlate2);
/* 433 */     this.bipedBody.addChild(this.ArmorPlateB1);
/* 434 */     this.bipedBody.addChild(this.ArmorPlateB2);
/*     */     
/* 436 */     this.bipedBody.addChild(this.BeltB);
/* 437 */     this.bipedBody.addChild(this.CloakF);
/*     */     
/* 439 */     this.bipedLeftArm.addChild(this.GlovesMain1);
/* 440 */     this.bipedRightArm.addChild(this.GlovesMain2);
/*     */     
/* 442 */     this.bipedLeftArm.addChild(this.GlovesTop1);
/* 443 */     this.bipedRightArm.addChild(this.GlovesTop2);
/*     */     
/* 445 */     this.bipedLeftArm.addChild(this.GlovesBottom1);
/* 446 */     this.bipedRightArm.addChild(this.GlovesBottom2);
/*     */     
/* 448 */     this.bipedLeftLeg.addChild(this.LLegArmor1);
/* 449 */     this.bipedLeftLeg.addChild(this.LLegArmor2);
/* 450 */     this.bipedLeftLeg.addChild(this.LBootsBase);
/* 451 */     this.bipedLeftLeg.addChild(this.LBootsF);
/*     */     
/* 453 */     this.bipedRightLeg.addChild(this.RLegArmor1);
/* 454 */     this.bipedRightLeg.addChild(this.RLegArmor2);
/* 455 */     this.bipedRightLeg.addChild(this.RBootsBase);
/* 456 */     this.bipedRightLeg.addChild(this.RBootsF);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 462 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 463 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 465 */     if (entity instanceof EntityPlayer) {
/*     */       
/* 467 */       EntityPlayer pl = (EntityPlayer)entity;
/* 468 */       ItemStack belt = BaublesApi.getBaublesHandler(pl).getStackInSlot(3);
/* 469 */       if (belt.getItem() instanceof LightBelt) {
/*     */         
/* 471 */         LightBelt item = (LightBelt)belt.getItem();
/* 472 */         item.getClass(); if (item.lastUse + 100L >= pl.world.getTotalWorldTime()) {
/*     */           
/* 474 */           GlStateManager.enableBlend();
/* 475 */           this.WingLeft.render(f5);
/* 476 */           this.WingRight.render(f5);
/* 477 */           GlStateManager.disableBlend();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 485 */     model.rotateAngleX = x;
/* 486 */     model.rotateAngleY = y;
/* 487 */     model.rotateAngleZ = z;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\light\ArmorLightModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */