/*     */ package com.ancient.thaumicgadgets.armour.primal;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArmorPrimalModel
/*     */   extends ModelBiped
/*     */ {
/*     */   ModelRenderer ChestplateBase;
/*     */   ModelRenderer Chestplate1;
/*     */   ModelRenderer Chestplate2;
/*     */   ModelRenderer Chestplate3;
/*     */   ModelRenderer GlovesLBase;
/*     */   ModelRenderer GlovesL1;
/*     */   ModelRenderer GlovesL2;
/*     */   ModelRenderer GlovesRBase;
/*     */   ModelRenderer GlovesR1;
/*     */   ModelRenderer GlovesR2;
/*     */   ModelRenderer RShoulderBase;
/*     */   ModelRenderer RShoulderBack;
/*     */   ModelRenderer RShoulderForw;
/*     */   ModelRenderer RShoulderBladeBase1;
/*     */   ModelRenderer RShoulderBladeBase2;
/*     */   ModelRenderer RShoulderBladeFront;
/*     */   ModelRenderer RShoulderBladeTop;
/*     */   ModelRenderer RShoulderBladeForw;
/*     */   ModelRenderer RShoulderBladeBack;
/*     */   ModelRenderer RShoulderBladeDiag;
/*     */   ModelRenderer Gorget;
/*     */   ModelRenderer LShoulderBase;
/*     */   ModelRenderer LShoulderBack;
/*     */   ModelRenderer LShoulderForw;
/*     */   ModelRenderer LShoulderBladeBase1;
/*     */   ModelRenderer LShoulderBladeBase2;
/*     */   ModelRenderer LShoulderBladeFront;
/*     */   ModelRenderer LShoulderBladeTop;
/*     */   ModelRenderer LShoulderBladeForw;
/*     */   ModelRenderer LShoulderBladeBack;
/*     */   ModelRenderer LShoulderBladeDiag;
/*     */   ModelRenderer CrownBase;
/*     */   ModelRenderer CrownTop;
/*     */   ModelRenderer CrownSpikeL;
/*     */   ModelRenderer CrownSpikeR;
/*     */   ModelRenderer CrownSpikeL1;
/*     */   ModelRenderer CrownSpikeR1;
/*     */   ModelRenderer CrownSpikeMiddle;
/*     */   ModelRenderer CrownSpikeMiddleTop;
/*     */   ModelRenderer HelmetForw;
/*     */   ModelRenderer HelmetBack;
/*     */   ModelRenderer HelmetFNose;
/*     */   ModelRenderer HelmetEyeArmor;
/*     */   ModelRenderer LLegArmor;
/*     */   ModelRenderer RLegArmor;
/*     */   ModelRenderer BootsL;
/*     */   ModelRenderer BootsL1;
/*     */   ModelRenderer BootsR;
/*     */   ModelRenderer BootsR1;
/*     */   
/*     */   public ArmorPrimalModel(float f) {
/*  76 */     super(f, 0.0F, 128, 80);
/*  77 */     this.textureWidth = 128;
/*  78 */     this.textureHeight = 80;
/*     */     
/*  80 */     this.ChestplateBase = new ModelRenderer((ModelBase)this, 100, 0);
/*  81 */     this.ChestplateBase.addBox(-4.5F, 1.5F, -2.5F, 9, 11, 5);
/*  82 */     this.ChestplateBase.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  83 */     this.ChestplateBase.setTextureSize(128, 80);
/*  84 */     this.ChestplateBase.mirror = true;
/*  85 */     setRotation(this.ChestplateBase, 0.0F, 0.0F, 0.0F);
/*  86 */     this.Chestplate1 = new ModelRenderer((ModelBase)this, 96, 5);
/*  87 */     this.Chestplate1.addBox(-0.5F, 6.0F, -3.1F, 1, 5, 1);
/*  88 */     this.Chestplate1.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  89 */     this.Chestplate1.setTextureSize(128, 80);
/*  90 */     this.Chestplate1.mirror = true;
/*  91 */     setRotation(this.Chestplate1, 0.0F, 0.0F, 0.0F);
/*  92 */     this.Chestplate2 = new ModelRenderer((ModelBase)this, 84, 0);
/*  93 */     this.Chestplate2.addBox(-1.2F, 4.4F, -3.0F, 5, 1, 1);
/*  94 */     this.Chestplate2.setRotationPoint(0.0F, 0.0F, 0.0F);
/*  95 */     this.Chestplate2.setTextureSize(128, 80);
/*  96 */     this.Chestplate2.mirror = true;
/*  97 */     setRotation(this.Chestplate2, 0.0F, 0.0F, 0.669215F);
/*  98 */     this.Chestplate3 = new ModelRenderer((ModelBase)this, 84, 0);
/*  99 */     this.Chestplate3.addBox(-4.2F, 4.3F, -3.0F, 5, 1, 1);
/* 100 */     this.Chestplate3.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 101 */     this.Chestplate3.setTextureSize(128, 80);
/* 102 */     this.Chestplate3.mirror = true;
/* 103 */     setRotation(this.Chestplate3, 0.0F, 0.0F, -0.6692116F);
/* 104 */     this.GlovesLBase = new ModelRenderer((ModelBase)this, 0, 33);
/* 105 */     this.GlovesLBase.addBox(1.0F, 6.0F, -2.5F, 3, 4, 5);
/* 106 */     this.GlovesLBase.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 107 */     this.GlovesLBase.setTextureSize(128, 80);
/* 108 */     this.GlovesLBase.mirror = true;
/* 109 */     setRotation(this.GlovesLBase, 0.0F, 0.0F, 0.0F);
/* 110 */     this.GlovesL1 = new ModelRenderer((ModelBase)this, 17, 33);
/* 111 */     this.GlovesL1.addBox(3.0F, 4.0F, -1.5F, 1, 2, 3);
/* 112 */     this.GlovesL1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 113 */     this.GlovesL1.setTextureSize(128, 80);
/* 114 */     this.GlovesL1.mirror = true;
/* 115 */     setRotation(this.GlovesL1, 0.0F, 0.0F, 0.0F);
/* 116 */     this.GlovesR1 = new ModelRenderer((ModelBase)this, 17, 33);
/* 117 */     this.GlovesR1.addBox(-4.0F, 4.0F, -1.5F, 1, 2, 3);
/* 118 */     this.GlovesR1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 119 */     this.GlovesR1.setTextureSize(128, 80);
/* 120 */     this.GlovesR1.mirror = true;
/* 121 */     setRotation(this.GlovesR1, 0.0F, 0.0F, 0.0F);
/* 122 */     this.GlovesR2 = new ModelRenderer((ModelBase)this, 26, 33);
/* 123 */     this.GlovesR2.addBox(3.0F, 3.0F, -0.5F, 1, 1, 1);
/* 124 */     this.GlovesR2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 125 */     this.GlovesR2.setTextureSize(128, 80);
/* 126 */     this.GlovesR2.mirror = true;
/* 127 */     setRotation(this.GlovesR2, 0.0F, 0.0F, 0.0F);
/* 128 */     this.GlovesRBase = new ModelRenderer((ModelBase)this, 0, 33);
/* 129 */     this.GlovesRBase.addBox(-4.0F, 6.0F, -2.5F, 3, 4, 5);
/* 130 */     this.GlovesRBase.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 131 */     this.GlovesRBase.setTextureSize(128, 80);
/* 132 */     this.GlovesRBase.mirror = true;
/* 133 */     setRotation(this.GlovesRBase, 0.0F, 0.0F, 0.0F);
/* 134 */     this.GlovesL2 = new ModelRenderer((ModelBase)this, 26, 33);
/* 135 */     this.GlovesL2.addBox(-4.0F, 3.0F, -0.5F, 1, 1, 1);
/* 136 */     this.GlovesL2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 137 */     this.GlovesL2.setTextureSize(128, 80);
/* 138 */     this.GlovesL2.mirror = true;
/* 139 */     setRotation(this.GlovesL2, 0.0F, 0.0F, 0.0F);
/* 140 */     this.RShoulderBase = new ModelRenderer((ModelBase)this, 108, 17);
/* 141 */     this.RShoulderBase.addBox(-4.0F, -2.5F, -2.5F, 5, 4, 5);
/* 142 */     this.RShoulderBase.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 143 */     this.RShoulderBase.setTextureSize(128, 80);
/* 144 */     this.RShoulderBase.mirror = true;
/* 145 */     setRotation(this.RShoulderBase, 0.0F, 0.0F, 0.0F);
/* 146 */     this.RShoulderBladeBase2 = new ModelRenderer((ModelBase)this, 103, 17);
/* 147 */     this.RShoulderBladeBase2.addBox(-3.8F, -3.5F, -0.5F, 1, 2, 1);
/* 148 */     this.RShoulderBladeBase2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 149 */     this.RShoulderBladeBase2.setTextureSize(128, 80);
/* 150 */     this.RShoulderBladeBase2.mirror = true;
/* 151 */     setRotation(this.RShoulderBladeBase2, 0.0174533F, 0.0F, 0.0F);
/* 152 */     this.RShoulderBladeTop = new ModelRenderer((ModelBase)this, 116, 26);
/* 153 */     this.RShoulderBladeTop.addBox(-4.0F, -3.3F, 2.3F, 5, 1, 1);
/* 154 */     this.RShoulderBladeTop.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 155 */     this.RShoulderBladeTop.setTextureSize(128, 80);
/* 156 */     this.RShoulderBladeTop.mirror = true;
/* 157 */     setRotation(this.RShoulderBladeTop, 0.7853982F, 0.0F, 0.0F);
/* 158 */     this.RShoulderBladeBase1 = new ModelRenderer((ModelBase)this, 103, 17);
/* 159 */     this.RShoulderBladeBase1.addBox(-0.5F, -3.5F, -0.5F, 1, 2, 1);
/* 160 */     this.RShoulderBladeBase1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 161 */     this.RShoulderBladeBase1.setTextureSize(128, 80);
/* 162 */     this.RShoulderBladeBase1.mirror = true;
/* 163 */     setRotation(this.RShoulderBladeBase1, 0.0174533F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     this.RShoulderBladeBack = new ModelRenderer((ModelBase)this, 118, 29);
/* 171 */     this.RShoulderBladeBack.addBox(-4.5F, 0.5F, 2.0F, 4, 1, 1);
/* 172 */     this.RShoulderBladeBack.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 173 */     this.RShoulderBladeBack.setTextureSize(128, 80);
/* 174 */     this.RShoulderBladeBack.mirror = true;
/* 175 */     setRotation(this.RShoulderBladeBack, 0.7853982F, 0.0F, 0.0F);
/* 176 */     this.RShoulderBladeDiag = new ModelRenderer((ModelBase)this, 108, 29);
/* 177 */     this.RShoulderBladeDiag.addBox(-2.7F, -4.4F, -4.4F, 3, 1, 1);
/* 178 */     this.RShoulderBladeDiag.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 179 */     this.RShoulderBladeDiag.setTextureSize(128, 80);
/* 180 */     this.RShoulderBladeDiag.mirror = true;
/* 181 */     setRotation(this.RShoulderBladeDiag, -0.7853982F, 0.0F, -0.7853982F);
/* 182 */     this.RShoulderBladeForw = new ModelRenderer((ModelBase)this, 118, 29);
/* 183 */     this.RShoulderBladeForw.addBox(-4.5F, -3.0F, -1.5F, 4, 1, 1);
/* 184 */     this.RShoulderBladeForw.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 185 */     this.RShoulderBladeForw.setTextureSize(128, 80);
/* 186 */     this.RShoulderBladeForw.mirror = true;
/* 187 */     setRotation(this.RShoulderBladeForw, 0.7853982F, 0.0F, 0.0F);
/* 188 */     this.RShoulderBack = new ModelRenderer((ModelBase)this, 101, 24);
/* 189 */     this.RShoulderBack.addBox(-1.5F, 0.0F, 2.0F, 2, 2, 1);
/* 190 */     this.RShoulderBack.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 191 */     this.RShoulderBack.setTextureSize(128, 80);
/* 192 */     this.RShoulderBack.mirror = true;
/* 193 */     setRotation(this.RShoulderBack, 0.0F, 0.0F, 0.0F);
/* 194 */     this.RShoulderForw = new ModelRenderer((ModelBase)this, 101, 24);
/* 195 */     this.RShoulderForw.addBox(-1.5F, 0.0F, -3.0F, 2, 2, 1);
/* 196 */     this.RShoulderForw.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 197 */     this.RShoulderForw.setTextureSize(128, 80);
/* 198 */     this.RShoulderForw.mirror = true;
/* 199 */     setRotation(this.RShoulderForw, 0.0F, 0.0F, 0.0F);
/* 200 */     this.LShoulderBase = new ModelRenderer((ModelBase)this, 108, 17);
/* 201 */     this.LShoulderBase.addBox(-1.0F, -2.5F, -2.5F, 5, 4, 5);
/* 202 */     this.LShoulderBase.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 203 */     this.LShoulderBase.setTextureSize(128, 80);
/* 204 */     this.LShoulderBase.mirror = true;
/* 205 */     setRotation(this.LShoulderBase, 0.0F, 0.0F, 0.0F);
/* 206 */     this.Gorget = new ModelRenderer((ModelBase)this, 92, 32);
/* 207 */     this.Gorget.addBox(-4.5F, -1.0F, -4.5F, 9, 3, 9);
/* 208 */     this.Gorget.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 209 */     this.Gorget.setTextureSize(128, 80);
/* 210 */     this.Gorget.mirror = true;
/* 211 */     setRotation(this.Gorget, 0.2792527F, 0.0F, 0.0F);
/* 212 */     this.LShoulderBladeBase1 = new ModelRenderer((ModelBase)this, 103, 17);
/* 213 */     this.LShoulderBladeBase1.addBox(-0.5F, -3.5F, -0.5F, 1, 2, 1);
/* 214 */     this.LShoulderBladeBase1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 215 */     this.LShoulderBladeBase1.setTextureSize(128, 80);
/* 216 */     this.LShoulderBladeBase1.mirror = true;
/* 217 */     setRotation(this.LShoulderBladeBase1, 0.0174533F, 0.0F, 0.0F);
/* 218 */     this.LShoulderBladeBase2 = new ModelRenderer((ModelBase)this, 103, 17);
/* 219 */     this.LShoulderBladeBase2.addBox(2.8F, -3.5F, -0.5F, 1, 2, 1);
/* 220 */     this.LShoulderBladeBase2.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 221 */     this.LShoulderBladeBase2.setTextureSize(128, 80);
/* 222 */     this.LShoulderBladeBase2.mirror = true;
/* 223 */     setRotation(this.LShoulderBladeBase2, 0.0174533F, 0.0F, 0.0F);
/* 224 */     this.LShoulderBladeFront = new ModelRenderer((ModelBase)this, 96, 26);
/* 225 */     this.LShoulderBladeFront.addBox(3.3F, -2.3F, 3.4F, 1, 4, 1);
/* 226 */     this.LShoulderBladeFront.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 227 */     this.LShoulderBladeFront.setTextureSize(128, 80);
/* 228 */     this.LShoulderBladeFront.mirror = true;
/* 229 */     setRotation(this.LShoulderBladeFront, 0.0F, 0.7853982F, 0.0F);
/* 230 */     this.LShoulderBladeDiag = new ModelRenderer((ModelBase)this, 108, 29);
/* 231 */     this.LShoulderBladeDiag.addBox(-0.3F, -4.3F, 3.33F, 3, 1, 1);
/* 232 */     this.LShoulderBladeDiag.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 233 */     this.LShoulderBladeDiag.setTextureSize(128, 80);
/* 234 */     this.LShoulderBladeDiag.mirror = true;
/* 235 */     setRotation(this.LShoulderBladeDiag, 0.7853982F, 0.0F, 0.7853982F);
/* 236 */     this.LShoulderBladeBack = new ModelRenderer((ModelBase)this, 118, 29);
/* 237 */     this.LShoulderBladeBack.addBox(0.5F, 0.5F, 2.0F, 4, 1, 1);
/* 238 */     this.LShoulderBladeBack.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 239 */     this.LShoulderBladeBack.setTextureSize(128, 80);
/* 240 */     this.LShoulderBladeBack.mirror = true;
/* 241 */     setRotation(this.LShoulderBladeBack, 0.7853982F, 0.0F, 0.0F);
/* 242 */     this.LShoulderForw = new ModelRenderer((ModelBase)this, 101, 24);
/* 243 */     this.LShoulderForw.addBox(-0.5F, 0.0F, -3.0F, 2, 2, 1);
/* 244 */     this.LShoulderForw.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 245 */     this.LShoulderForw.setTextureSize(128, 80);
/* 246 */     this.LShoulderForw.mirror = true;
/* 247 */     setRotation(this.LShoulderForw, 0.0F, 0.0F, 0.0F);
/* 248 */     this.LShoulderBladeForw = new ModelRenderer((ModelBase)this, 118, 29);
/* 249 */     this.LShoulderBladeForw.addBox(0.5F, -3.0F, -1.5F, 4, 1, 1);
/* 250 */     this.LShoulderBladeForw.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 251 */     this.LShoulderBladeForw.setTextureSize(128, 80);
/* 252 */     this.LShoulderBladeForw.mirror = true;
/* 253 */     setRotation(this.LShoulderBladeForw, 0.7853982F, 0.0F, 0.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 266 */     this.LShoulderBladeTop = new ModelRenderer((ModelBase)this, 116, 26);
/* 267 */     this.LShoulderBladeTop.addBox(-1.0F, -3.3F, 2.3F, 5, 1, 1);
/* 268 */     this.LShoulderBladeTop.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 269 */     this.LShoulderBladeTop.setTextureSize(128, 80);
/* 270 */     this.LShoulderBladeTop.mirror = true;
/* 271 */     setRotation(this.LShoulderBladeTop, 0.7853982F, 0.0F, 0.0F);
/* 272 */     this.LShoulderBack = new ModelRenderer((ModelBase)this, 101, 24);
/* 273 */     this.LShoulderBack.addBox(-0.5F, 0.0F, 2.0F, 2, 2, 1);
/* 274 */     this.LShoulderBack.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 275 */     this.LShoulderBack.setTextureSize(128, 80);
/* 276 */     this.LShoulderBack.mirror = true;
/* 277 */     setRotation(this.LShoulderBack, 0.0F, 0.0F, 0.0F);
/* 278 */     this.RShoulderBladeFront = new ModelRenderer((ModelBase)this, 96, 26);
/* 279 */     this.RShoulderBladeFront.addBox(-4.3F, -2.3F, -4.4F, 1, 4, 1);
/* 280 */     this.RShoulderBladeFront.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 281 */     this.RShoulderBladeFront.setTextureSize(128, 80);
/* 282 */     this.RShoulderBladeFront.mirror = true;
/* 283 */     setRotation(this.RShoulderBladeFront, 0.0F, 0.7853982F, 0.0F);
/* 284 */     this.HelmetEyeArmor = new ModelRenderer((ModelBase)this, 0, 44);
/* 285 */     this.HelmetEyeArmor.addBox(-4.5F, -6.5F, -5.0F, 9, 2, 3);
/* 286 */     this.HelmetEyeArmor.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 287 */     this.HelmetEyeArmor.setTextureSize(128, 80);
/* 288 */     this.HelmetEyeArmor.mirror = true;
/* 289 */     setRotation(this.HelmetEyeArmor, 0.0F, 0.0F, 0.0F);
/* 290 */     this.CrownBase = new ModelRenderer((ModelBase)this, 0, 50);
/* 291 */     this.CrownBase.addBox(-4.5F, -8.5F, -4.5F, 9, 2, 9);
/* 292 */     this.CrownBase.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 293 */     this.CrownBase.setTextureSize(128, 80);
/* 294 */     this.CrownBase.mirror = true;
/* 295 */     setRotation(this.CrownBase, 0.0F, 0.0F, 0.0F);
/* 296 */     this.CrownSpikeL1 = new ModelRenderer((ModelBase)this, 25, 44);
/* 297 */     this.CrownSpikeL1.addBox(3.9F, -9.5F, -1.0F, 1, 3, 2);
/* 298 */     this.CrownSpikeL1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 299 */     this.CrownSpikeL1.setTextureSize(128, 80);
/* 300 */     this.CrownSpikeL1.mirror = true;
/* 301 */     setRotation(this.CrownSpikeL1, 0.0F, 0.0F, 0.0F);
/* 302 */     this.CrownSpikeMiddleTop = new ModelRenderer((ModelBase)this, 0, 62);
/* 303 */     this.CrownSpikeMiddleTop.addBox(-0.5F, -11.0F, -4.5F, 1, 2, 1);
/* 304 */     this.CrownSpikeMiddleTop.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 305 */     this.CrownSpikeMiddleTop.setTextureSize(128, 80);
/* 306 */     this.CrownSpikeMiddleTop.mirror = true;
/* 307 */     setRotation(this.CrownSpikeMiddleTop, 0.0F, 0.0F, 0.0F);
/* 308 */     this.HelmetForw = new ModelRenderer((ModelBase)this, 5, 62);
/* 309 */     this.HelmetForw.addBox(-4.4F, -3.5F, -4.3F, 9, 4, 3);
/* 310 */     this.HelmetForw.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 311 */     this.HelmetForw.setTextureSize(128, 80);
/* 312 */     this.HelmetForw.mirror = true;
/* 313 */     setRotation(this.HelmetForw, 0.0F, 0.0F, 0.0F);
/* 314 */     this.CrownSpikeR1 = new ModelRenderer((ModelBase)this, 0, 70);
/* 315 */     this.CrownSpikeR1.addBox(-4.866667F, -9.5F, -1.0F, 1, 3, 2);
/* 316 */     this.CrownSpikeR1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 317 */     this.CrownSpikeR1.setTextureSize(128, 80);
/* 318 */     this.CrownSpikeR1.mirror = true;
/* 319 */     setRotation(this.CrownSpikeR1, 0.0F, 0.0F, 0.0F);
/* 320 */     this.CrownSpikeR = new ModelRenderer((ModelBase)this, 0, 62);
/* 321 */     this.CrownSpikeR.addBox(-2.866667F, -9.5F, -5.0F, 1, 2, 1);
/* 322 */     this.CrownSpikeR.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 323 */     this.CrownSpikeR.setTextureSize(128, 80);
/* 324 */     this.CrownSpikeR.mirror = true;
/* 325 */     setRotation(this.CrownSpikeR, 0.0F, 0.0F, 0.0F);
/* 326 */     this.CrownSpikeL = new ModelRenderer((ModelBase)this, 0, 62);
/* 327 */     this.CrownSpikeL.addBox(2.133333F, -9.5F, -5.0F, 1, 2, 1);
/* 328 */     this.CrownSpikeL.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 329 */     this.CrownSpikeL.setTextureSize(128, 80);
/* 330 */     this.CrownSpikeL.mirror = true;
/* 331 */     setRotation(this.CrownSpikeL, 0.0F, 0.0F, 0.0F);
/* 332 */     this.HelmetBack = new ModelRenderer((ModelBase)this, 39, 50);
/* 333 */     this.HelmetBack.addBox(-4.6F, -7.0F, -2.4F, 9, 6, 7);
/* 334 */     this.HelmetBack.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 335 */     this.HelmetBack.setTextureSize(128, 80);
/* 336 */     this.HelmetBack.mirror = true;
/* 337 */     setRotation(this.HelmetBack, 0.0F, 0.0F, 0.0F);
/* 338 */     this.HelmetFNose = new ModelRenderer((ModelBase)this, 30, 62);
/* 339 */     this.HelmetFNose.addBox(-1.0F, -7.0F, -5.1F, 2, 7, 2);
/* 340 */     this.HelmetFNose.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 341 */     this.HelmetFNose.setTextureSize(128, 80);
/* 342 */     this.HelmetFNose.mirror = true;
/* 343 */     setRotation(this.HelmetFNose, 0.0F, 0.0F, 0.0F);
/* 344 */     this.CrownTop = new ModelRenderer((ModelBase)this, 32, 37);
/* 345 */     this.CrownTop.addBox(-3.4F, -9.0F, -3.5F, 7, 5, 7);
/* 346 */     this.CrownTop.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 347 */     this.CrownTop.setTextureSize(128, 80);
/* 348 */     this.CrownTop.mirror = true;
/* 349 */     setRotation(this.CrownTop, 0.0F, 0.0F, 0.0F);
/* 350 */     this.CrownSpikeMiddle = new ModelRenderer((ModelBase)this, 7, 70);
/* 351 */     this.CrownSpikeMiddle.addBox(-1.0F, -10.5F, -5.0F, 2, 4, 1);
/* 352 */     this.CrownSpikeMiddle.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 353 */     this.CrownSpikeMiddle.setTextureSize(128, 80);
/* 354 */     this.CrownSpikeMiddle.mirror = true;
/* 355 */     setRotation(this.CrownSpikeMiddle, 0.0F, 0.0F, 0.0F);
/* 356 */     this.LLegArmor = new ModelRenderer((ModelBase)this, 69, 0);
/* 357 */     this.LLegArmor.addBox(1.5F, -1.0F, -2.6F, 2, 6, 5);
/* 358 */     this.LLegArmor.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 359 */     this.LLegArmor.setTextureSize(128, 80);
/* 360 */     this.LLegArmor.mirror = true;
/* 361 */     setRotation(this.LLegArmor, 0.0F, 0.0F, 0.0F);
/* 362 */     this.RLegArmor = new ModelRenderer((ModelBase)this, 69, 0);
/* 363 */     this.RLegArmor.addBox(-3.5F, -1.0F, -2.6F, 2, 6, 5);
/* 364 */     this.RLegArmor.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 365 */     this.RLegArmor.setTextureSize(128, 80);
/* 366 */     this.RLegArmor.mirror = true;
/* 367 */     setRotation(this.RLegArmor, 0.0F, 0.0F, 0.0F);
/* 368 */     this.BootsR1 = new ModelRenderer((ModelBase)this, 82, 16);
/* 369 */     this.BootsR1.addBox(-1.5F, 9.0F, -4.5F, 3, 3, 2);
/* 370 */     this.BootsR1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 371 */     this.BootsR1.setTextureSize(128, 80);
/* 372 */     this.BootsR1.mirror = true;
/* 373 */     setRotation(this.BootsR1, 0.0F, 0.0F, 0.0F);
/* 374 */     this.BootsL1 = new ModelRenderer((ModelBase)this, 82, 16);
/* 375 */     this.BootsL1.addBox(-1.5F, 9.0F, -4.5F, 3, 3, 2);
/* 376 */     this.BootsL1.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 377 */     this.BootsL1.setTextureSize(128, 80);
/* 378 */     this.BootsL1.mirror = true;
/* 379 */     setRotation(this.BootsL1, 0.0F, 0.0F, 0.0F);
/* 380 */     this.BootsL = new ModelRenderer((ModelBase)this, 59, 16);
/* 381 */     this.BootsL.addBox(-2.5F, 6.0F, -2.5F, 5, 6, 5);
/* 382 */     this.BootsL.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 383 */     this.BootsL.setTextureSize(128, 80);
/* 384 */     this.BootsL.mirror = true;
/* 385 */     setRotation(this.BootsL, 0.0F, 0.0F, 0.0F);
/* 386 */     this.BootsR = new ModelRenderer((ModelBase)this, 59, 16);
/* 387 */     this.BootsR.addBox(-2.5F, 6.0F, -2.5F, 5, 6, 5);
/* 388 */     this.BootsR.setRotationPoint(0.0F, 0.0F, 0.0F);
/* 389 */     this.BootsR.setTextureSize(128, 80);
/* 390 */     this.BootsR.mirror = true;
/* 391 */     setRotation(this.BootsR, 0.0F, 0.0F, 0.0F);
/*     */     
/* 393 */     this.bipedBody.addChild(this.ChestplateBase);
/* 394 */     this.ChestplateBase.addChild(this.Chestplate1);
/* 395 */     this.ChestplateBase.addChild(this.Chestplate2);
/* 396 */     this.ChestplateBase.addChild(this.Chestplate3);
/*     */     
/* 398 */     this.bipedLeftArm.addChild(this.GlovesLBase);
/* 399 */     this.GlovesLBase.addChild(this.GlovesL1);
/* 400 */     this.GlovesLBase.addChild(this.GlovesL2);
/*     */     
/* 402 */     this.bipedRightArm.addChild(this.GlovesRBase);
/* 403 */     this.GlovesRBase.addChild(this.GlovesR1);
/* 404 */     this.GlovesRBase.addChild(this.GlovesR2);
/*     */     
/* 406 */     this.bipedRightArm.addChild(this.RShoulderBase);
/* 407 */     this.RShoulderBase.addChild(this.RShoulderBack);
/* 408 */     this.RShoulderBase.addChild(this.RShoulderForw);
/* 409 */     this.RShoulderBase.addChild(this.RShoulderBladeBase1);
/* 410 */     this.RShoulderBase.addChild(this.RShoulderBladeBase2);
/* 411 */     this.RShoulderBase.addChild(this.RShoulderBladeFront);
/* 412 */     this.RShoulderBase.addChild(this.RShoulderBladeTop);
/* 413 */     this.RShoulderBase.addChild(this.RShoulderBladeForw);
/* 414 */     this.RShoulderBase.addChild(this.RShoulderBladeBack);
/* 415 */     this.RShoulderBase.addChild(this.RShoulderBladeDiag);
/*     */ 
/*     */     
/* 418 */     this.bipedHead.addChild(this.Gorget);
/*     */     
/* 420 */     this.bipedLeftArm.addChild(this.LShoulderBase);
/* 421 */     this.LShoulderBase.addChild(this.LShoulderBack);
/* 422 */     this.LShoulderBase.addChild(this.LShoulderForw);
/* 423 */     this.LShoulderBase.addChild(this.LShoulderBladeBase1);
/* 424 */     this.LShoulderBase.addChild(this.LShoulderBladeBase2);
/* 425 */     this.LShoulderBase.addChild(this.LShoulderBladeFront);
/* 426 */     this.LShoulderBase.addChild(this.LShoulderBladeTop);
/* 427 */     this.LShoulderBase.addChild(this.LShoulderBladeForw);
/* 428 */     this.LShoulderBase.addChild(this.LShoulderBladeBack);
/* 429 */     this.LShoulderBase.addChild(this.LShoulderBladeDiag);
/*     */ 
/*     */ 
/*     */     
/* 433 */     this.bipedHead.addChild(this.CrownBase);
/* 434 */     this.CrownBase.addChild(this.CrownTop);
/* 435 */     this.CrownBase.addChild(this.CrownSpikeL);
/* 436 */     this.CrownBase.addChild(this.CrownSpikeR);
/* 437 */     this.CrownBase.addChild(this.CrownSpikeL1);
/* 438 */     this.CrownBase.addChild(this.CrownSpikeR1);
/* 439 */     this.CrownBase.addChild(this.CrownSpikeMiddle);
/* 440 */     this.CrownBase.addChild(this.CrownSpikeMiddleTop);
/*     */     
/* 442 */     this.bipedHead.addChild(this.HelmetForw);
/* 443 */     this.HelmetForw.addChild(this.HelmetBack);
/* 444 */     this.HelmetForw.addChild(this.HelmetFNose);
/* 445 */     this.HelmetForw.addChild(this.HelmetEyeArmor);
/*     */     
/* 447 */     this.bipedLeftLeg.addChild(this.LLegArmor);
/* 448 */     this.bipedRightLeg.addChild(this.RLegArmor);
/*     */     
/* 450 */     this.bipedLeftLeg.addChild(this.BootsL);
/* 451 */     this.bipedLeftLeg.addChild(this.BootsL1);
/*     */     
/* 453 */     this.bipedRightLeg.addChild(this.BootsR);
/* 454 */     this.bipedRightLeg.addChild(this.BootsR1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 460 */     super.render(entity, f, f1, f2, f3, f4, f5);
/* 461 */     setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*     */   }
/*     */ 
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/* 466 */     model.rotateAngleX = x;
/* 467 */     model.rotateAngleY = y;
/* 468 */     model.rotateAngleZ = z;
/*     */   }
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\armour\primal\ArmorPrimalModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */