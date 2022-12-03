/*     */ package com.ancient.thaumicgadgets.init;
/*     */ 
/*     */ import com.ancient.thaumicgadgets.armour.light.ArmorLight;
/*     */ import com.ancient.thaumicgadgets.armour.light.LightBelt;
/*     */ import com.ancient.thaumicgadgets.armour.primal.ArmorPrimal;
/*     */ import com.ancient.thaumicgadgets.armour.primal.ArmorPrimalUpgraded;
/*     */ import com.ancient.thaumicgadgets.armour.shade.ArmorShade;
/*     */ import com.ancient.thaumicgadgets.armour.shade.ShadeBelt;
/*     */ import com.ancient.thaumicgadgets.items.GemCutter;
/*     */ import com.ancient.thaumicgadgets.items.ItemBase;
/*     */
/*     */ import com.ancient.thaumicgadgets.items.ItemCrystal;
/*     */ import com.ancient.thaumicgadgets.items.ItemLense;
/*     */ import com.ancient.thaumicgadgets.items.ItemTab;
/*     */ import com.ancient.thaumicgadgets.items.pouches.ItemPouch;
/*     */
/*     */ import com.ancient.thaumicgadgets.tools.light.AxeLight;
/*     */ import com.ancient.thaumicgadgets.tools.light.HoeLight;
/*     */ import com.ancient.thaumicgadgets.tools.light.PickaxeLight;
/*     */ import com.ancient.thaumicgadgets.tools.light.ScytheLight;
/*     */ import com.ancient.thaumicgadgets.tools.light.ShearsLight;
/*     */ import com.ancient.thaumicgadgets.tools.light.ShovelLight;
/*     */ import com.ancient.thaumicgadgets.tools.light.SwordLight;
/*     */ import com.ancient.thaumicgadgets.tools.primal.ToolAxePrimal;
/*     */ import com.ancient.thaumicgadgets.tools.primal.ToolSwordPrimal;
/*     */ import com.ancient.thaumicgadgets.tools.shade.AxeShade;
/*     */ import com.ancient.thaumicgadgets.tools.shade.HoeShade;
/*     */ import com.ancient.thaumicgadgets.tools.shade.PickaxeShade;
/*     */ import com.ancient.thaumicgadgets.tools.shade.ScytheShade;
/*     */ import com.ancient.thaumicgadgets.tools.shade.ShearsShade;
/*     */ import com.ancient.thaumicgadgets.tools.shade.ShovelShade;
/*     */ import com.ancient.thaumicgadgets.tools.shade.SwordShade;
/*     */ import com.ancient.thaumicgadgets.tools.thauminium.ScytheThaum;
/*     */ import com.ancient.thaumicgadgets.tools.voiid.ScytheVoid;
/*     */ import com.ancient.thaumicgadgets.util.handlers.EnumHandler;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.inventory.EntityEquipmentSlot;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraftforge.common.util.EnumHelper;
/*     */ import thaumcraft.api.ThaumcraftMaterials;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModItems
/*     */ {
/*  52 */   public static final List<Item> ITEMS = new ArrayList<>();
/*     */ 
/*     */   
/*  55 */   public static final Item.ToolMaterial TOOL_PRIMAL = EnumHelper.addToolMaterial("tool_primal", 3, 2048, 8.0F, 3.0F, 0);
/*  56 */   public static final Item.ToolMaterial TOOL_LIGHT = EnumHelper.addToolMaterial("tool_light", 3, 1024, 8.0F, 3.0F, 10);
/*  57 */   public static final Item.ToolMaterial TOOL_SHADE = EnumHelper.addToolMaterial("tool_shade", 3, 1024, 8.0F, 3.0F, 10);
/*     */   
/*  59 */   public static final ItemArmor.ArmorMaterial ARMOR_PRIMAL = EnumHelper.addArmorMaterial("armour_primal", "tg:primal", 50, new int[] { 4, 6, 8, 4 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 8.0F);
/*     */   
/*  61 */   public static final ItemArmor.ArmorMaterial ARMOR_SHADE = EnumHelper.addArmorMaterial("armour_shade", "tg:shade", 33, new int[] { 3, 6, 9, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 15.0F);
/*     */   
/*  63 */   public static final ItemArmor.ArmorMaterial ARMOR_LIGHT = EnumHelper.addArmorMaterial("armour_light", "tg:light", 33, new int[] { 3, 6, 9, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 15.0F);
/*     */   
/*  65 */   public static final ItemArmor.ArmorMaterial ARMOR_MAGE = EnumHelper.addArmorMaterial("armour_mage", "tg:mage", 33, new int[] { 4, 12, 8, 4 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public static final Item HELMET_LIGHT = (Item)new ArmorLight("helmet_light", ARMOR_LIGHT, 1, EntityEquipmentSlot.HEAD);
/*  71 */   public static final Item CHESTPLATE_LIGHT = (Item)new ArmorLight("chestplate_light", ARMOR_LIGHT, 1, EntityEquipmentSlot.CHEST);
/*  72 */   public static final Item LEGGINS_LIGHT = (Item)new ArmorLight("leggins_light", ARMOR_LIGHT, 2, EntityEquipmentSlot.LEGS);
/*  73 */   public static final Item BOOTS_LIGHT = (Item)new ArmorLight("boots_light", ARMOR_LIGHT, 1, EntityEquipmentSlot.FEET);
/*  74 */   public static final Item BELT_LIGHT = (Item)new LightBelt("belt_light");
/*  75 */   public static final Item SWORD_LIGHT = (Item)new SwordLight("sword_light", TOOL_LIGHT, 2, 100, 10.0F, -2.4F);
/*     */ 
/*     */   
/*  78 */   public static final Item AXE_LIGHT = (Item)new AxeLight("axe_light", TOOL_LIGHT, 2, 100, 12.0F, -3.1F);
/*  79 */   public static final Item HOE_LIGHT = (Item)new HoeLight("hoe_light", TOOL_LIGHT, 2, 100, 1.0F, -3.0F);
/*  80 */   public static final Item PICKAXE_LIGHT = (Item)new PickaxeLight("pickaxe_light", TOOL_LIGHT, 2, 100, 6.0F, -2.8F);
/*  81 */   public static final Item SHOVEL_LIGHT = (Item)new ShovelLight("shovel_light", TOOL_LIGHT, 2, 100, 4.0F, -2.8F);
/*  82 */   public static final Item SHEARS_LIGHT = (Item)new ShearsLight("shears_light", TOOL_LIGHT, 2, 100);
/*     */ 
/*     */   
/*  85 */   public static final Item HELMET_SHADE = (Item)new ArmorShade("helmet_shade", ARMOR_SHADE, 1, EntityEquipmentSlot.HEAD);
/*  86 */   public static final Item CHESTPLATE_SHADE = (Item)new ArmorShade("chestplate_shade", ARMOR_SHADE, 1, EntityEquipmentSlot.CHEST);
/*  87 */   public static final Item LEGGINS_SHADE = (Item)new ArmorShade("leggins_shade", ARMOR_SHADE, 2, EntityEquipmentSlot.LEGS);
/*  88 */   public static final Item BOOTS_SHADE = (Item)new ArmorShade("boots_shade", ARMOR_SHADE, 1, EntityEquipmentSlot.FEET);
/*  89 */   public static final Item BELT_SHADE = (Item)new ShadeBelt("belt_shade");
/*  90 */   public static final Item SWORD_SHADE = (Item)new SwordShade("sword_shade", TOOL_SHADE, 2, 100, 10.0F, -2.4F);
/*     */ 
/*     */   
/*  93 */   public static final Item AXE_SHADE = (Item)new AxeShade("axe_shade", TOOL_LIGHT, 2, 100, 12.0F, -3.1F);
/*  94 */   public static final Item HOE_SHADE = (Item)new HoeShade("hoe_shade", TOOL_LIGHT, 2, 100, 1.0F, -3.0F);
/*  95 */   public static final Item PICKAXE_SHADE = (Item)new PickaxeShade("pickaxe_shade", TOOL_LIGHT, 2, 100, 6.0F, -2.8F);
/*  96 */   public static final Item SHOVEL_SHADE = (Item)new ShovelShade("shovel_shade", TOOL_LIGHT, 2, 100, 4.0F, -2.8F);
/*  97 */   public static final Item SHEARS_SHADE = (Item)new ShearsShade("shears_shade", TOOL_LIGHT, 2, 100);
/*     */ 
/*     */   
/* 100 */   public static final Item SWORD_PRIMAL = (Item)new ToolSwordPrimal("sword_primal", TOOL_PRIMAL, 11.0F, -2.4F);
/* 101 */   public static final Item AXE_PRIMAL = (Item)new ToolAxePrimal("axe_primal", TOOL_PRIMAL, 12.0F, -2.75F);
/* 102 */   public static final Item HAMMER_PRIMAL = (Item)new ToolAxePrimal("hammer_primal", TOOL_PRIMAL, 16.0F, -3.1F);
/*     */ 
/*     */   
/* 105 */   public static final Item HELMET_PRIMAL = (Item)new ArmorPrimal("helmet_primal", ARMOR_PRIMAL, 1, EntityEquipmentSlot.HEAD);
/* 106 */   public static final Item CHESTPLATE_PRIMAL = (Item)new ArmorPrimal("chestplate_primal", ARMOR_PRIMAL, 1, EntityEquipmentSlot.CHEST);
/* 107 */   public static final Item LEGGINS_PRIMAL = (Item)new ArmorPrimal("leggins_primal", ARMOR_PRIMAL, 2, EntityEquipmentSlot.LEGS);
/* 108 */   public static final Item BOOTS_PRIMAL = (Item)new ArmorPrimal("boots_primal", ARMOR_PRIMAL, 1, EntityEquipmentSlot.FEET);
/*     */ 
/*     */   
/* 111 */   public static final Item HELMET_PRIMAL_UP = (Item)new ArmorPrimalUpgraded("helmet_primal_up", ARMOR_PRIMAL, 1, EntityEquipmentSlot.HEAD);
/* 112 */   public static final Item CHESTPLATE_PRIMAL_UP = (Item)new ArmorPrimalUpgraded("chestplate_primal_up", ARMOR_PRIMAL, 1, EntityEquipmentSlot.CHEST);
/* 113 */   public static final Item LEGGINS_PRIMAL_UP = (Item)new ArmorPrimalUpgraded("leggins_primal_up", ARMOR_PRIMAL, 2, EntityEquipmentSlot.LEGS);
/* 114 */   public static final Item BOOTS_PRIMAL_UP = (Item)new ArmorPrimalUpgraded("boots_primal_up", ARMOR_PRIMAL, 1, EntityEquipmentSlot.FEET);
/*     */   
/* 116 */   public static final Item TOOL_GEMCUTTER = (Item)new GemCutter("tool_gemcutter");
/*     */   
/* 118 */   public static final Item YARN = (Item)new ItemBase("yarn");
/* 119 */   public static final Item YARN_GOLD = (Item)new ItemBase("yarn_gold");
/* 120 */   public static final Item YARN_THANIUM = (Item)new ItemBase("yarn_thanium");
/* 121 */   public static final Item YARN_MAGIC = (Item)new ItemBase("yarn_magic");
/* 122 */   public static final Item YARN_LIGHT = (Item)new ItemBase("yarn_light");
/* 123 */   public static final Item YARN_SHADE = (Item)new ItemBase("yarn_shade");
/* 124 */   public static final Item YARN_ETHER = (Item)new ItemBase("yarn_ether");
/* 125 */   public static final Item YARN_VOID = (Item)new ItemBase("yarn_void");
/*     */   
/* 127 */   public static final Item FABRIC_DECORATED = (Item)new ItemBase("fabric_decorated");
/* 128 */   public static final Item FABRIC_ENCHANTED = (Item)new ItemBase("fabric_enchanted");
/* 129 */   public static final Item FABRIC_LIGHT = (Item)new ItemBase("fabric_light");
/* 130 */   public static final Item FABRIC_SHADE = (Item)new ItemBase("fabric_shade");
/* 131 */   public static final Item FABRIC_VOID = (Item)new ItemBase("fabric_void");
/* 132 */   public static final Item FABRIC_BEWITCHED = (Item)new ItemBase("fabric_bewitched");
/* 133 */   public static final Item FABRIC_VOLATILE = (Item)new ItemBase("fabric_volatile");
/*     */ 
/*     */   
/* 136 */   public static final Item WOLF_HIDE = (Item)new ItemBase("wolf_hide");
/*     */   
/* 138 */   public static final Item INGOT_LIGHT = (Item)new ItemBase("ingot_light");
/* 139 */   public static final Item INGOT_SHADE = (Item)new ItemBase("ingot_shade");
/* 140 */   public static final Item NUGGET_LIGHT = (Item)new ItemBase("nugget_light");
/* 141 */   public static final Item NUGGET_SHADE = (Item)new ItemBase("nugget_shade");
/*     */ 
/*     */   
/* 144 */   public static final Item OVAL_CTYSTAL_AIR = (Item)new ItemCrystal("oval_crystal_air");
/* 145 */   public static final Item OVAL_CTYSTAL_EARTH = (Item)new ItemCrystal("oval_crystal_earth");
/* 146 */   public static final Item OVAL_CTYSTAL_FIRE = (Item)new ItemCrystal("oval_crystal_fire");
/* 147 */   public static final Item OVAL_CTYSTAL_WATER = (Item)new ItemCrystal("oval_crystal_water");
/* 148 */   public static final Item OVAL_CTYSTAL_ORDER = (Item)new ItemCrystal("oval_crystal_order");
/* 149 */   public static final Item OVAL_CTYSTAL_ENTROPY = (Item)new ItemCrystal("oval_crystal_entropy");
/*     */   
/* 151 */   public static final Item SHARPED_CTYSTAL_AIR = (Item)new ItemCrystal("sharped_crystal_air");
/* 152 */   public static final Item SHARPED_CTYSTAL_EARTH = (Item)new ItemCrystal("sharped_crystal_earth");
/* 153 */   public static final Item SHARPED_CTYSTAL_FIRE = (Item)new ItemCrystal("sharped_crystal_fire");
/* 154 */   public static final Item SHARPED_CTYSTAL_WATER = (Item)new ItemCrystal("sharped_crystal_water");
/* 155 */   public static final Item SHARPED_CTYSTAL_ORDER = (Item)new ItemCrystal("sharped_crystal_order");
/* 156 */   public static final Item SHARPED_CTYSTAL_ENTROPY = (Item)new ItemCrystal("sharped_crystal_entropy");
/*     */   
/* 158 */   public static final Item CRYSTAL_DUST = (Item)new ItemBase("crystal_dust");
/*     */   
/* 160 */   public static final Item ASH = (Item)new ItemBase("ash");
/*     */ 
/*     */   
/* 163 */   public static final Item MAGIC_POUCH = (Item)new ItemPouch("pouch_magic_1");
/* 164 */   public static final Item ENCHANTED_POUCH = (Item)new ItemPouch("pouch_magic_2");
/* 165 */   public static final Item BEWITCHED_POUCH = (Item)new ItemPouch("pouch_magic_3");
/*     */   
/* 167 */   public static final Item HUNGRY_MAGIC_POUCH = (Item)new ItemPouch("pouch_hungry_magic_1");
/* 168 */   public static final Item HUNGRY_ENCHANTED_POUCH = (Item)new ItemPouch("pouch_hungry_magic_2");
/* 169 */   public static final Item HUNGRY_BEWITCHED_POUCH = (Item)new ItemPouch("pouch_hungry_magic_3");
/*     */   
/* 171 */   public static final Item ENDER_POUCH = (Item)new ItemPouch("pouch_ender");
/*     */   
/* 173 */   public static final Item VOID_POUCH = (Item)new ItemPouch("pouch_void");
/*     */   
/* 175 */   public static final Item LENSE_POUCH = (Item)new ItemPouch("pouch_lense");
/*     */   
/* 177 */   public static final Item SCYTHE_THAUM = (Item)new ScytheThaum("scythe_thaum", ThaumcraftMaterials.TOOLMAT_THAUMIUM, 8.0F, -3.0F, 2, 1, 2);
/* 178 */   public static final Item SCYTHE_VOID = (Item)new ScytheVoid("scythe_void", ThaumcraftMaterials.TOOLMAT_VOID, 1, 60, 9.0F, -3.0F, 3, 2, 3);
/* 179 */   public static final Item SCYTHE_LIGHT = (Item)new ScytheLight("scythe_light", TOOL_LIGHT, 2, 100, 10.0F, -3.0F, 4, 3, 4);
/* 180 */   public static final Item SCYTHE_SHADE = (Item)new ScytheShade("scythe_shade", TOOL_LIGHT, 2, 100, 10.0F, -3.0F, 4, 3, 4);
/*     */   
/* 182 */   public static final Item FORTIFIED_GLASS_SHARD = (Item)new ItemBase("fortified_glass_shard");
/*     */   
/* 192 */   public static final Item LENSE_BLANK = (Item)new ItemBase("lense_blank");
/* 193 */   public static final Item LENSE_NIGHT_VISION = (Item)new ItemLense("lense_night_vision", EnumHandler.LenseTypes.NIGHT_VISION);
/* 194 */   public static final Item LENSE_ECHO_LOC = (Item)new ItemLense("lense_echo_loc", EnumHandler.LenseTypes.ECHO_LOC);
/* 195 */   public static final Item LENSE_DEATH_GAZE = (Item)new ItemLense("lense_death_gaze", EnumHandler.LenseTypes.DEATH_GAZE);
/* 196 */   public static final Item LENSE_FIRE = (Item)new ItemLense("lense_fire", EnumHandler.LenseTypes.FIRE);
/* 197 */   public static final Item LENSE_KNOCKBACK = (Item)new ItemLense("lense_knockback", EnumHandler.LenseTypes.KNOCKBACK);
/* 198 */   public static final Item LENSE_DECAY = (Item)new ItemLense("lense_decay", EnumHandler.LenseTypes.DECAY);
/*     */   
/* 200 */   public static final Item TG = (Item)new ItemTab("tg");
/*     */ }


/* Location:              C:\Users\戴尔\Desktop\code\Thaumic_Gadgets_1.12.2_0.1.6_tb.26.jar!\com\ancient\thaumicgadgets\init\ModItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */