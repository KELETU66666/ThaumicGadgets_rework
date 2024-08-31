package com.ancient.thaumicgadgets.objects.machines.gemcutter;


import com.ancient.thaumicgadgets.init.ModItems;
import com.google.common.collect.Lists;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IThaumcraftRecipe;
import thaumcraft.api.items.ItemsTC;

import java.util.List;
import java.util.Map;


public class GemCutterRecipes {
    private static final GemCutterRecipes INSTANCE = new GemCutterRecipes();

    public final class gemCutterRecipe implements IThaumcraftRecipe {
        public String name;
        public ItemStack input;
        public AspectList aspects;
        public ItemStack outPut;
        public int mode;
        public String research;
        public String group;

        public gemCutterRecipe(String name, ItemStack input, AspectList aspects, ItemStack outPut, int mode, String research, String group) {
            this.name = name;
            this.input = input;
            this.aspects = aspects;
            this.outPut = outPut;
            this.mode = mode;
            this.research = research;
            this.group = group;
        }


        public String getResearch() {
            return this.research;
        }


        public String getGroup() {
            return this.group;
        }


        public String toString() {
            return "Input: " + this.input.toString() + " Aspects: " + this.aspects + " OutPut: " + this.outPut.toString() + " Mode: " + this.mode;
        }
    }

    private final List<gemCutterRecipe> list = Lists.newArrayList();


    private GemCutterRecipes() {
        addGemCutterRecipe("sharped_crystal_air_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.AIR, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_air_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.AIR, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_air_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.AIR, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_air_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.AIR, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_air_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.AIR, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_AIR), 0, "JEWERELY", "sharped_crystals");

        addGemCutterRecipe("sharped_crystal_fire_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.FIRE, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_fire_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.FIRE, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_fire_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.FIRE, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_fire_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.FIRE, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_fire_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.FIRE, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_FIRE), 0, "JEWERELY", "sharped_crystals");

        addGemCutterRecipe("sharped_crystal_earth_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.EARTH, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_earth_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.EARTH, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_earth_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.EARTH, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_earth_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.EARTH, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_earth_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.EARTH, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_EARTH), 0, "JEWERELY", "sharped_crystals");

        addGemCutterRecipe("sharped_crystal_water_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.WATER, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_water_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.WATER, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_water_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.WATER, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_water_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.WATER, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_water_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.WATER, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_WATER), 0, "JEWERELY", "sharped_crystals");

        addGemCutterRecipe("sharped_crystal_order_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.ORDER, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_order_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.ORDER, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_order_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.ORDER, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_order_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.ORDER, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_order_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.ORDER, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_ORDER), 0, "JEWERELY", "sharped_crystals");

        addGemCutterRecipe("sharped_crystal_entropy_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.ENTROPY, 25), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_entropy_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.ENTROPY, 20), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_entropy_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.ENTROPY, 35), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_entropy_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.ENTROPY, 50), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");
        addGemCutterRecipe("sharped_crystal_entropy_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.ENTROPY, 40), new ItemStack(ModItems.SHARPED_CTYSTAL_ENTROPY), 0, "JEWERELY", "sharped_crystals");


        addGemCutterRecipe("oval_crystal_air_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.AIR, 40), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_air_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.AIR, 35), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_air_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.AIR, 50), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_air_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.AIR, 75), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_air_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.AIR, 60), new ItemStack(ModItems.OVAL_CTYSTAL_AIR), 1, "JEWERELY", "oval_crystals");

        addGemCutterRecipe("oval_crystal_fire_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.FIRE, 40), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_fire_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.FIRE, 35), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_fire_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.FIRE, 50), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_fire_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.FIRE, 75), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_fire_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.FIRE, 60), new ItemStack(ModItems.OVAL_CTYSTAL_FIRE), 1, "JEWERELY", "oval_crystals");

        addGemCutterRecipe("oval_crystal_earth_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.EARTH, 40), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_earth_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.EARTH, 35), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_earth_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.EARTH, 50), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_earth_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.EARTH, 75), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_earth_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.EARTH, 60), new ItemStack(ModItems.OVAL_CTYSTAL_EARTH), 1, "JEWERELY", "oval_crystals");

        addGemCutterRecipe("oval_crystal_water_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.WATER, 40), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_water_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.WATER, 35), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_water_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.WATER, 50), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_water_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.WATER, 75), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_water_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.WATER, 60), new ItemStack(ModItems.OVAL_CTYSTAL_WATER), 1, "JEWERELY", "oval_crystals");

        addGemCutterRecipe("oval_crystal_order_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.ORDER, 40), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_order_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.ORDER, 35), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_order_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.ORDER, 50), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_order_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.ORDER, 75), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_order_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.ORDER, 60), new ItemStack(ModItems.OVAL_CTYSTAL_ORDER), 1, "JEWERELY", "oval_crystals");

        addGemCutterRecipe("oval_crystal_entropy_diamond", new ItemStack(Items.DIAMOND), (new AspectList()).add(Aspect.ENTROPY, 40), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_entropy_emerald", new ItemStack(Items.EMERALD), (new AspectList()).add(Aspect.ENTROPY, 35), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_entropy_lapis", new ItemStack(Items.DYE, 1, 4), (new AspectList()).add(Aspect.ENTROPY, 50), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_entropy_quartz", new ItemStack(Items.QUARTZ), (new AspectList()).add(Aspect.ENTROPY, 75), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
        addGemCutterRecipe("oval_crystal_entropy_amber", new ItemStack(ItemsTC.amber), (new AspectList()).add(Aspect.ENTROPY, 60), new ItemStack(ModItems.OVAL_CTYSTAL_ENTROPY), 1, "JEWERELY", "oval_crystals");
    }


    public static GemCutterRecipes getInstance() {
        return INSTANCE;
    }

    public void addGemCutterRecipe(String name, ItemStack input, AspectList aspects, ItemStack result, int mode, String research, String group) {
        while (true) {
            if (!containOnlyPrimalAspects(aspects)) {

                toPrimal(aspects);
                continue;
            }
            break;
        }
        this.list.add(new gemCutterRecipe(name, input, aspects, result, mode, research, group));
    }


    public int getMaxRecipeCount() {
        return this.list.size();
    }


    public ItemStack getWorkResult(ItemStack input, AspectList aspects, int mode) {
        if (input != ItemStack.EMPTY && aspects != null) {
            for (gemCutterRecipe r : this.list) {

                if (compareItemStacks(input, r.input) && compareAspectList(r.aspects, aspects) && r.mode == mode) {
                    return r.outPut;
                }
            }
        }
        return ItemStack.EMPTY;
    }


    private boolean compareItemStacks(ItemStack item1, ItemStack item2) {
        return (item2.getItem() == item1.getItem() && (item2.getMetadata() == 32767 || item2.getMetadata() == item1.getMetadata()));
    }


    public gemCutterRecipe getRecipeEntry(ItemStack input, AspectList aspects, int mode) {
        for (gemCutterRecipe r : this.list) {

            if (compareItemStacks(r.input, input) && compareAspectList(r.aspects, aspects) && r.mode == mode) {
                return r;
            }
        }
        return null;
    }

    public List<gemCutterRecipe> getRecipeList() {
        return this.list;
    }


    public static AspectList toPrimal(AspectList aspects) {
        AspectList toAdd = new AspectList();
        AspectList toRemove = new AspectList();
        if (aspects != null) {

            for (Map.Entry<Aspect, Integer> e : aspects.aspects.entrySet()) {

                if (!e.getKey().isPrimal()) {

                    for (Aspect as : e.getKey().getComponents()) {
                        toAdd.add(as, e.getValue());
                    }
                    toRemove.add(e.getKey(), e.getValue());
                }
            }

            for (Aspect as : toAdd.getAspects()) {
                aspects.add(as, toAdd.getAmount(as));
            }
            for (Aspect as : toRemove.getAspects()) {
                aspects.remove(as, toRemove.getAmount(as));
            }
            return aspects;
        }
        return null;
    }


    public static boolean containOnlyPrimalAspects(AspectList aspects) {
        if (aspects != null) {

            for (Aspect as : aspects.getAspects()) {

                if (!as.isPrimal()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }


    public boolean compareAspectList(AspectList recipe, AspectList table) {
        for (Aspect as : recipe.getAspects()) {

            if (!table.aspects.containsKey(as) || table.aspects.get(as) < recipe.getAmount(as)) {
                return false;
            }
        }
        return true;
    }
}