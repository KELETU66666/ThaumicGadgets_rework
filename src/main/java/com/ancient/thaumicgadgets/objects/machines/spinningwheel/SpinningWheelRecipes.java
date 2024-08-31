package com.ancient.thaumicgadgets.objects.machines.spinningwheel;

import com.ancient.thaumicgadgets.init.ModItems;
import com.google.common.collect.Maps;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.items.ItemsTC;

import java.util.Map;




public class SpinningWheelRecipes
{
    public static final SpinningWheelRecipes INSTANCE = new SpinningWheelRecipes();


    public static class craftingRecipes
    {
        public String group;
        public ItemStack item1;
        public ItemStack item2;
        public ItemStack item3;
        public ItemStack item4;
        public ItemStack result;
        public float experience;

        public craftingRecipes(String group, ItemStack Item1, ItemStack Item2, ItemStack Item3, ItemStack Item4, ItemStack Result, float Experience) {
            this.group = group;
            this.item1 = Item1;
            this.item2 = Item2;
            this.item3 = Item3;
            this.item4 = Item4;
            this.result = Result;
            this.experience = Experience;
        }
    }

    private final Map<String, craftingRecipes> list = Maps.newHashMap();


    public static SpinningWheelRecipes getInstance() {
        return INSTANCE;
    }



    private SpinningWheelRecipes() {
        addSpinningWheelRecipe("thaumicgadgets:yarn", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ModItems.YARN), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:yarn_gold", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.GOLD_NUGGET), new ItemStack(ModItems.YARN_GOLD), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:yarn_thanium", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ItemsTC.nuggets, 1, 6), new ItemStack(ModItems.YARN_THANIUM), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ItemsTC.nuggets, 1, 8), new ItemStack(ModItems.YARN_MAGIC), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ModItems.NUGGET_LIGHT), new ItemStack(ModItems.YARN_LIGHT), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ModItems.NUGGET_SHADE), new ItemStack(ModItems.YARN_SHADE), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Item.getItemFromBlock(BlocksTC.shimmerleaf)), new ItemStack(ModItems.YARN_ETHER), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(Items.STRING), new ItemStack(ItemsTC.nuggets, 1, 7), new ItemStack(ModItems.YARN_VOID), 5.0F);

        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(ModItems.YARN), new ItemStack(ModItems.YARN), new ItemStack(ModItems.YARN_GOLD), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.FABRIC_DECORATED), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(ModItems.YARN), new ItemStack(ModItems.YARN), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ItemsTC.fabric), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_GOLD), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.FABRIC_ENCHANTED), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(ModItems.YARN_ETHER), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.YARN_LIGHT), new ItemStack(ModItems.YARN_LIGHT), new ItemStack(ModItems.FABRIC_LIGHT), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(ModItems.YARN_ETHER), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.YARN_SHADE), new ItemStack(ModItems.YARN_SHADE), new ItemStack(ModItems.FABRIC_SHADE), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(ModItems.YARN_GOLD), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_VOID), new ItemStack(ModItems.YARN_VOID), new ItemStack(ModItems.FABRIC_VOID), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(ModItems.YARN_ETHER), new ItemStack(ModItems.YARN_THANIUM), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.YARN_MAGIC), new ItemStack(ModItems.FABRIC_BEWITCHED), 5.0F);
        addSpinningWheelRecipe("thaumicgadgets:weaving", new ItemStack(ModItems.YARN_ETHER), new ItemStack(ModItems.YARN_LIGHT), new ItemStack(ModItems.YARN_SHADE), new ItemStack(ModItems.YARN_VOID), new ItemStack(ModItems.FABRIC_VOLATILE), 5.0F);
    }



    public void addSpinningWheelRecipe(String group, ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4, ItemStack result, float experience) {
        if (!result.isEmpty()) {

            craftingRecipes recipe = new craftingRecipes(group, input1, input2, input3, input4, result, Float.valueOf(experience).floatValue());
            this.list.put(result.getTranslationKey().toLowerCase(), recipe);
        }
    }

    public void removeSpinningWheelRecipe(ItemStack result) {
        if (!result.isEmpty()) {

            this.list.remove(result.getTranslationKey().toLowerCase());
        }
    }

    public int getMaxRecipeCount() {
        return this.list.size();
    }



    public ItemStack getWorkResult(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4) {
        for (Map.Entry<String, craftingRecipes> e : this.list.entrySet()) {

            craftingRecipes recipe = e.getValue();

            if (compareItemStacks(input1, recipe.item1) && compareItemStacks(input2, recipe.item2) && compareItemStacks(input3, recipe.item3) && compareItemStacks(input4, recipe.item4))
            {
                return recipe.result;
            }
        }

        return ItemStack.EMPTY;
    }


    private boolean compareItemStacks(ItemStack item1, ItemStack item2) {
        return (item2.getItem() == item1.getItem() && (item2.getMetadata() == 32767 || item2.getMetadata() == item1.getMetadata()));
    }


    public Map<String, craftingRecipes> getDualWorkingList() {
        return this.list;
    }


    public float getWorkExperience(ItemStack output) {
        for (Map.Entry<String, craftingRecipes> e : this.list.entrySet()) {

            craftingRecipes recipe = e.getValue();
            if (output.isItemEqual(recipe.result))
            {
                return recipe.experience;
            }
        }

        return 0.0F;
    }
}