package com.ancient.thaumicgadgets.init;

import com.ancient.thaumicgadgets.armor.light.ArmorLight;
import com.ancient.thaumicgadgets.armor.light.LightBelt;
import com.ancient.thaumicgadgets.armor.primal.ArmorPrimal;
import com.ancient.thaumicgadgets.armor.shade.ArmorShade;
import com.ancient.thaumicgadgets.armor.shade.ShadeBelt;
import com.ancient.thaumicgadgets.items.*;
import com.ancient.thaumicgadgets.items.pouches.ItemPouch;
import com.ancient.thaumicgadgets.tools.light.*;
import com.ancient.thaumicgadgets.tools.primal.ToolAxePrimal;
import com.ancient.thaumicgadgets.tools.primal.ToolPickaxePrimal;
import com.ancient.thaumicgadgets.tools.primal.ToolSwordPrimal;
import com.ancient.thaumicgadgets.tools.shade.*;
import com.ancient.thaumicgadgets.tools.thauminium.ScytheThaum;
import com.ancient.thaumicgadgets.tools.voiid.ScytheVoid;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.util.EnumHelper;
import thaumcraft.api.ThaumcraftMaterials;

import java.util.ArrayList;
import java.util.List;


public class ModItems {
    public static final List<Item> ITEMS = new ArrayList<>();


    public static final Item.ToolMaterial TOOL_PRIMAL = EnumHelper.addToolMaterial("tool_primal", 3, 2048, 8.0F, 3.0F, 0);
    public static final Item.ToolMaterial TOOL_LIGHT = EnumHelper.addToolMaterial("tool_light", 3, 1024, 8.0F, 3.0F, 10);
    public static final Item.ToolMaterial TOOL_SHADE = EnumHelper.addToolMaterial("tool_shade", 3, 1024, 8.0F, 3.0F, 10);

    public static final ItemArmor.ArmorMaterial ARMOR_PRIMAL = EnumHelper.addArmorMaterial("armor_primal", "thaumicgadgets:primal", 50, new int[]{4, 6, 8, 4}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 8.0F);

    public static final ItemArmor.ArmorMaterial ARMOR_SHADE = EnumHelper.addArmorMaterial("armor_shade", "thaumicgadgets:shade", 33, new int[]{3, 6, 9, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 15.0F);

    public static final ItemArmor.ArmorMaterial ARMOR_LIGHT = EnumHelper.addArmorMaterial("armor_light", "thaumicgadgets:light", 33, new int[]{3, 6, 9, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 15.0F);

    public static final ItemArmor.ArmorMaterial ARMOR_MAGE = EnumHelper.addArmorMaterial("armor_mage", "thaumicgadgets:mage", 33, new int[]{4, 12, 8, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 2.0F);


    public static final Item HELMET_LIGHT = new ArmorLight("helmet_light", ARMOR_LIGHT, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_LIGHT = new ArmorLight("chestplate_light", ARMOR_LIGHT, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINS_LIGHT = new ArmorLight("leggins_light", ARMOR_LIGHT, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_LIGHT = new ArmorLight("boots_light", ARMOR_LIGHT, 1, EntityEquipmentSlot.FEET);
    public static final Item BELT_LIGHT = new LightBelt("belt_light");
    public static final Item SWORD_LIGHT = new SwordLight("sword_light", TOOL_LIGHT, 2, 100, 10.0F, -2.4F);


    public static final Item AXE_LIGHT = new AxeLight("axe_light", TOOL_LIGHT, 2, 100, 12.0F, -3.1F);
    public static final Item HOE_LIGHT = new HoeLight("hoe_light", TOOL_LIGHT, 2, 100, 1.0F, -3.0F);
    public static final Item PICKAXE_LIGHT = new PickaxeLight("pickaxe_light", TOOL_LIGHT, 2, 100, 6.0F, -2.8F);
    public static final Item SHOVEL_LIGHT = new ShovelLight("shovel_light", TOOL_LIGHT, 2, 100, 4.0F, -2.8F);
    public static final Item SHEARS_LIGHT = new ShearsLight("shears_light", TOOL_LIGHT, 2, 100);


    public static final Item HELMET_SHADE = new ArmorShade("helmet_shade", ARMOR_SHADE, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_SHADE = new ArmorShade("chestplate_shade", ARMOR_SHADE, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINS_SHADE = new ArmorShade("leggins_shade", ARMOR_SHADE, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_SHADE = new ArmorShade("boots_shade", ARMOR_SHADE, 1, EntityEquipmentSlot.FEET);
    public static final Item BELT_SHADE = new ShadeBelt("belt_shade");
    public static final Item SWORD_SHADE = new SwordShade("sword_shade", TOOL_SHADE, 2, 100, 10.0F, -2.4F);


    public static final Item AXE_SHADE = new AxeShade("axe_shade", TOOL_LIGHT, 2, 100, 12.0F, -3.1F);
    public static final Item HOE_SHADE = new HoeShade("hoe_shade", TOOL_LIGHT, 2, 100, 1.0F, -3.0F);
    public static final Item PICKAXE_SHADE = new PickaxeShade("pickaxe_shade", TOOL_LIGHT, 2, 100, 6.0F, -2.8F);
    public static final Item SHOVEL_SHADE = new ShovelShade("shovel_shade", TOOL_LIGHT, 2, 100, 4.0F, -2.8F);
    public static final Item SHEARS_SHADE = new ShearsShade("shears_shade", TOOL_LIGHT, 2, 100);


    public static final Item SWORD_PRIMAL = new ToolSwordPrimal("sword_primal", TOOL_PRIMAL, 11.0F, -2.4F);
    public static final Item AXE_PRIMAL = new ToolAxePrimal("axe_primal", TOOL_PRIMAL, 12.0F, -2.75F);
    public static final Item HAMMER_PRIMAL = new ToolPickaxePrimal("hammer_primal", TOOL_PRIMAL, 16.0F, -3.1F);


    public static final Item HELMET_PRIMAL = new ArmorPrimal("helmet_primal", ARMOR_PRIMAL, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_PRIMAL = new ArmorPrimal("chestplate_primal", ARMOR_PRIMAL, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINS_PRIMAL = new ArmorPrimal("leggins_primal", ARMOR_PRIMAL, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_PRIMAL = new ArmorPrimal("boots_primal", ARMOR_PRIMAL, 1, EntityEquipmentSlot.FEET);

    public static final Item TOOL_GEMCUTTER = new GemCutter("tool_gemcutter");

    public static final Item YARN = new ItemBase("yarn");
    public static final Item YARN_GOLD = new ItemBase("yarn_gold");
    public static final Item YARN_THANIUM = new ItemBase("yarn_thanium");
    public static final Item YARN_MAGIC = new ItemBase("yarn_magic");
    public static final Item YARN_LIGHT = new ItemBase("yarn_light");
    public static final Item YARN_SHADE = new ItemBase("yarn_shade");
    public static final Item YARN_ETHER = new ItemBase("yarn_ether");
    public static final Item YARN_VOID = new ItemBase("yarn_void");

    public static final Item FABRIC_SPACIOUS = new ItemBase("fabric_spacious");
    public static final Item FABRIC_ENCHANTED = new ItemBase("fabric_enchanted");
    public static final Item FABRIC_LIGHT = new ItemBase("fabric_light");
    public static final Item FABRIC_SHADE = new ItemBase("fabric_shade");
    public static final Item FABRIC_VOID = new ItemBase("fabric_void");
    public static final Item FABRIC_BEWITCHED = new ItemBase("fabric_bewitched");
    public static final Item FABRIC_VOLATILE = new ItemBase("fabric_volatile");

    public static final Item INGOT_LIGHT = new ItemBase("ingot_light");
    public static final Item INGOT_SHADE = new ItemBase("ingot_shade");
    public static final Item NUGGET_LIGHT = new ItemBase("nugget_light");
    public static final Item NUGGET_SHADE = new ItemBase("nugget_shade");


    public static final Item OVAL_CTYSTAL_AIR = new ItemCrystal("oval_crystal_air");
    public static final Item OVAL_CTYSTAL_EARTH = new ItemCrystal("oval_crystal_earth");
    public static final Item OVAL_CTYSTAL_FIRE = new ItemCrystal("oval_crystal_fire");
    public static final Item OVAL_CTYSTAL_WATER = new ItemCrystal("oval_crystal_water");
    public static final Item OVAL_CTYSTAL_ORDER = new ItemCrystal("oval_crystal_order");
    public static final Item OVAL_CTYSTAL_ENTROPY = new ItemCrystal("oval_crystal_entropy");

    public static final Item SHARPED_CTYSTAL_AIR = new ItemCrystal("sharped_crystal_air");
    public static final Item SHARPED_CTYSTAL_EARTH = new ItemCrystal("sharped_crystal_earth");
    public static final Item SHARPED_CTYSTAL_FIRE = new ItemCrystal("sharped_crystal_fire");
    public static final Item SHARPED_CTYSTAL_WATER = new ItemCrystal("sharped_crystal_water");
    public static final Item SHARPED_CTYSTAL_ORDER = new ItemCrystal("sharped_crystal_order");
    public static final Item SHARPED_CTYSTAL_ENTROPY = new ItemCrystal("sharped_crystal_entropy");

    public static final Item MAGIC_POUCH = new ItemPouch("pouch_magic");
    public static final Item HUNGRY_MAGIC_POUCH = new ItemPouch("pouch_hungry_magic");
    public static final Item ENDER_POUCH = new ItemPouch("pouch_ender");
    public static final Item VOID_POUCH = new ItemPouch("pouch_void");

    public static final Item SCYTHE_THAUM = new ScytheThaum("scythe_thaum", ThaumcraftMaterials.TOOLMAT_THAUMIUM, 8.0F, -3.0F, 2, 1, 2);
    public static final Item SCYTHE_VOID = new ScytheVoid("scythe_void", ThaumcraftMaterials.TOOLMAT_VOID, 1, 60, 9.0F, -3.0F, 3, 2, 3);
    public static final Item SCYTHE_LIGHT = new ScytheLight("scythe_light", TOOL_LIGHT, 2, 100, 10.0F, -3.0F, 4, 3, 4);
    public static final Item SCYTHE_SHADE = new ScytheShade("scythe_shade", TOOL_LIGHT, 2, 100, 10.0F, -3.0F, 4, 3, 4);

    public static final Item FOOD_MATERIAL = new FoodMaterial();
    public static final ItemFood MAGIC_FOOD = new MagicFood();

    public static final Item TG = new ItemTab("thaumicgadgets");
}