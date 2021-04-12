package couk.mullak99.alphacraft.data.recipes;

import couk.mullak99.alphacraft.AlphaCraft;
import couk.mullak99.alphacraft.common.ModBlocks;
import couk.mullak99.alphacraft.common.ModItems;
import couk.mullak99.alphacraft.common.ModTags;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.StonecuttingRecipe;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static couk.mullak99.alphacraft.AlphaCraft.modId;

public class ModRecipesProvider extends RecipeProvider {
    public ModRecipesProvider(DataGenerator generatorIn) {
        super (generatorIn);
    }

    @Override
    public String getName() {
        return "AlphaCraft - Recipes";
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModBlocks.NOSTALGIA_COBBLESTONE.get(), 8)
                .pattern("ooo")
                .pattern("odo")
                .pattern("ooo")
                .define('o', Tags.Items.COBBLESTONE)
                .define('d', ModTags.Items.DUSTS_NOSTALGIA)
                .unlockedBy("has_item", has(ModTags.Items.DUSTS_NOSTALGIA))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.NOSTALGIA_STONE.get(), 8)
                .pattern("ooo")
                .pattern("odo")
                .pattern("ooo")
                .define('o', Tags.Items.STONE)
                .define('d', ModTags.Items.DUSTS_NOSTALGIA)
                .unlockedBy("has_item", has(ModTags.Items.DUSTS_NOSTALGIA))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.NOSTALGIA_GRASS_BLOCK.get(), 8)
                .pattern("ooo")
                .pattern("odo")
                .pattern("ooo")
                .define('o', Blocks.GRASS_BLOCK)
                .define('d', ModTags.Items.DUSTS_NOSTALGIA)
                .unlockedBy("has_item", has(Blocks.GRASS_BLOCK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.NOSTALGIA_LEAVES.get(), 8)
                .pattern("ooo")
                .pattern("odo")
                .pattern("ooo")
                .define('o', Blocks.OAK_LEAVES)
                .define('d', ModTags.Items.DUSTS_NOSTALGIA)
                .unlockedBy("has_item", has(Blocks.OAK_LEAVES))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.NOSTALGIA_SAPLING.get(), 8)
                .pattern("ooo")
                .pattern("odo")
                .pattern("ooo")
                .define('o', Blocks.OAK_SAPLING)
                .define('d', ModTags.Items.DUSTS_NOSTALGIA)
                .unlockedBy("has_item", has(Blocks.OAK_SAPLING))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.NOSTALGIA_BLOCK.get())
                .requires(Ingredient.of(ModTags.Items.DUSTS_NOSTALGIA), 9)
                .unlockedBy("has_item", has(ModTags.Items.DUSTS_NOSTALGIA))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.NOSTALGIA_ESSENCE.get(), 9)
                .requires(Ingredient.of(ModTags.Items.STORAGE_BLOCKS_NOSTALGIA), 1)
                .unlockedBy("has_item", has(ModTags.Items.STORAGE_BLOCKS_NOSTALGIA))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.NOSTALGIA_COBBLESTONE_WALL.get(), 6)
                .pattern("ccc")
                .pattern("ccc")
                .define('c', ModBlocks.NOSTALGIA_COBBLESTONE.get())
                .unlockedBy("has_item", has(ModBlocks.NOSTALGIA_COBBLESTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.NOSTALGIA_COBBLESTONE_STAIRS.get(), 4)
                .pattern("c  ")
                .pattern("cc ")
                .pattern("ccc")
                .define('c', ModBlocks.NOSTALGIA_COBBLESTONE.get())
                .unlockedBy("has_item", has(ModBlocks.NOSTALGIA_COBBLESTONE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.NOSTALGIA_COBBLESTONE_SLAB.get(), 6)
                .pattern("ccc")
                .define('c', ModBlocks.NOSTALGIA_COBBLESTONE.get())
                .unlockedBy("has_item", has(ModBlocks.NOSTALGIA_COBBLESTONE.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.NOSTALGIA_COBBLESTONE.get()),
                ModBlocks.NOSTALGIA_COBBLESTONE_SLAB.get(), 2)
                .unlocks("has_nostalgia_cobblestone", has(ModBlocks.NOSTALGIA_COBBLESTONE.get()))
                .save(consumer, modId("nostalgia_cobblestone_slab_from_nostalgia_cobblestone_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.NOSTALGIA_COBBLESTONE.get()),
                ModBlocks.NOSTALGIA_COBBLESTONE_STAIRS.get())
                .unlocks("has_nostalgia_cobblestone", has(ModBlocks.NOSTALGIA_COBBLESTONE.get()))
                .save(consumer, modId("nostalgia_cobblestone_stairs_from_nostalgia_cobblestone_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.NOSTALGIA_COBBLESTONE.get()),
                ModBlocks.NOSTALGIA_COBBLESTONE_WALL.get())
                .unlocks("has_nostalgia_cobblestone", has(ModBlocks.NOSTALGIA_COBBLESTONE.get()))
                .save(consumer, modId("nostalgia_cobblestone_wall_from_nostalgia_cobblestone_stonecutting"));

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.NOSTALGIA_ORE.get()), ModItems.NOSTALGIA_ESSENCE.get(), 0.7F, 200)
                .unlockedBy("has_item", has(ModBlocks.NOSTALGIA_ORE.get()))
                .save(consumer, modId("nostalgia_essence_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.NOSTALGIA_ORE.get()), ModItems.NOSTALGIA_ESSENCE.get(), 0.7F, 100)
                .unlockedBy("has_item", has(ModBlocks.NOSTALGIA_ORE.get()))
                .save(consumer, modId("nostalgia_essence_blasting"));

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.NOSTALGIA_COBBLESTONE.get()), ModBlocks.NOSTALGIA_STONE.get(), 0.1F, 200)
                .unlockedBy("has_item", has(ModBlocks.NOSTALGIA_COBBLESTONE.get()))
                .save(consumer, modId("nostalgia_stone_smelting"));
    }
}
