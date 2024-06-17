package net.kuudraloremaster.andrejmod.datagen;

import net.kuudraloremaster.andrejmod.AndrejMod;
import net.kuudraloremaster.andrejmod.block.ModBlocks;
import net.kuudraloremaster.andrejmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
            ModBlocks.SAPPHIRE_ORE.get(),ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),ModBlocks.NETHER_SAPPHIRE_ORE.get(),
            ModBlocks.END_STONE_SAPPHIRE_ORE.get());
    private static final List<ItemLike> KFC_FOOD = List.of(ModItems.RAW_KFC.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");
        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        simpleCookingRecipe(pWriter, "campfire", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 50, ModItems.RAW_KFC.get(), ModItems.KFC.get(), .7f);
        simpleCookingRecipe(pWriter, "smelting", RecipeSerializer.SMELTING_RECIPE, 100, ModItems.RAW_KFC.get(), ModItems.KFC.get(), .7f);
        simpleCookingRecipe(pWriter, "smoking", RecipeSerializer.SMOKING_RECIPE, 25, ModItems.RAW_KFC.get(), ModItems.KFC.get(), .7f);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PINE_PLANKS.get(), 4)
                .requires(ModBlocks.PINE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.PINE_LOG.get()), has(ModBlocks.PINE_LOG.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BULLET.get(), 9)
                .requires(Items.IRON_INGOT)
                .requires(Items.GUNPOWDER)
                .unlockedBy(getHasName(ModItems.PISTOL.get()), has(ModItems.PISTOL.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KFC_BUCKET.get())
                .pattern("SSS")
                .pattern("S#S")
                .pattern("SSS")
                .define('S', ModItems.KFC.get())
                .define('#', Items.BUCKET)
                .unlockedBy(getHasName(ModItems.KFC.get()), has(ModItems.KFC.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PIXEL.get())
                .pattern(" S ")
                .pattern("S#S")
                .pattern(" S ")
                .define('S', Items.GOLD_INGOT)
                .define('#', Items.SAND)
                .unlockedBy(getHasName(ModItems.KFC.get()), has(ModItems.KFC.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KUUDRA_FOLLOWER_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .define('S', ModItems.KUUDRA_FOLLOWER_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get()), has(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KUUDRA_FOLLOWER_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.KUUDRA_FOLLOWER_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get()), has(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KUUDRA_FOLLOWER_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.KUUDRA_FOLLOWER_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get()), has(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KUUDRA_FOLLOWER_BOOTS.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.KUUDRA_FOLLOWER_FRAGMENT.get())
                .unlockedBy(getHasName(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get()), has(ModItems.KUUDRA_FOLLOWER_FRAGMENT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OHIO_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .define('S', ModItems.OHIO.get())
                .unlockedBy(getHasName(ModItems.OHIO.get()), has(ModItems.OHIO.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OHIO_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.OHIO.get())
                .unlockedBy(getHasName(ModItems.OHIO.get()), has(ModItems.OHIO.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OHIO_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.OHIO.get())
                .unlockedBy(getHasName(ModItems.OHIO.get()), has(ModItems.OHIO.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.OHIO_BOOTS.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.OHIO.get())
                .unlockedBy(getHasName(ModItems.OHIO.get()), has(ModItems.OHIO.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_KFC.get(), 2)
                .requires(Items.CHICKEN)
                .unlockedBy(getHasName(Items.CHICKEN), has(Items.CHICKEN))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MAID_HELMET.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .define('S', ModItems.MAID.get())
                .unlockedBy(getHasName(ModItems.MAID.get()), has(ModItems.MAID.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MAID_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.MAID.get())
                .unlockedBy(getHasName(ModItems.MAID.get()), has(ModItems.MAID.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MAID_LEGGINGS.get())
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.MAID.get())
                .unlockedBy(getHasName(ModItems.MAID.get()), has(ModItems.MAID.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MAID.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .define('S', ModItems.MAID.get())
                .unlockedBy(getHasName(ModItems.MAID.get()), has(ModItems.MAID.get()))
                .save(pWriter);


    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, AndrejMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }

}
