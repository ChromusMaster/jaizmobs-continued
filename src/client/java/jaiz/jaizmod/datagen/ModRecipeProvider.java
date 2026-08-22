package jaiz.jaizmod.datagen;


import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeExporter) {
        super(wrapperLookup, recipeExporter);
    }

    @Override
    public void buildRecipes() {


        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PLATED_CALCITE, 4)
                .pattern("RX")
                .pattern("XR")
                .define('R', Items.CALCITE)
                .define('X', Items.POLISHED_BLACKSTONE)
                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                .unlockedBy(getHasName(Items.POLISHED_BLACKSTONE), has(Items.POLISHED_BLACKSTONE))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_PLATED_CALCITE, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.PLATED_CALCITE)
                .unlockedBy(getHasName(ModItems.PLATED_CALCITE), has(ModItems.PLATED_CALCITE))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FROST, 4)
                .pattern("RR")
                .define('R', Items.ICE)
                .unlockedBy(getHasName(Items.ICE), has(Items.ICE))
                .save(output);

        this.shaped(RecipeCategory.DECORATIONS, ModItems.BLOOMING_IVY_BLOCK, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.BLOOMING_IVY)
                .unlockedBy(getHasName(ModItems.BLOOMING_IVY), has(ModItems.BLOOMING_IVY))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SNIFFER_WOOL, 1)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.SNIFFER_TUFT)
                .unlockedBy(getHasName(ModItems.SNIFFER_TUFT), has(ModItems.SNIFFER_TUFT))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "sniffer_wool_from_tuft")));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SNIFFER_CARPET, 3)
                .pattern("RR")
                .define('R', ModItems.SNIFFER_WOOL)
                .unlockedBy(getHasName(ModItems.SNIFFER_WOOL), has(ModItems.SNIFFER_WOOL))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "sniffer_carpet_from_wool")));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.ARROW, 4)
                .pattern("R")
                .pattern("G")
                .pattern("X")
                .define('X', ModItems.SNIFFER_TUFT)
                .define('G', Items.FLINT)
                .define('R', Items.STICK)
                .unlockedBy(getHasName(ModItems.SNIFFER_TUFT), has(ModItems.SNIFFER_TUFT))
                .unlockedBy(getHasName(Items.FLINT), has(Items.FLINT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "arrow_from_tuft")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.WRITABLE_BOOK, 1)
                .requires(ModItems.SNIFFER_TUFT)
                .requires(Items.BOOK)
                .requires(Items.INK_SAC)
                .unlockedBy(getHasName(ModItems.SNIFFER_TUFT), has(ModItems.SNIFFER_TUFT))
                .unlockedBy(getHasName(Items.INK_SAC), has(Items.INK_SAC))
                .unlockedBy(getHasName(Items.BOOK), has(Items.BOOK))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "book_and_quill_from_tuft")));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BRUSH, 1)
                .pattern("X")
                .pattern("G")
                .pattern("R")
                .define('X', ModItems.SNIFFER_TUFT)
                .define('G', Items.COPPER_INGOT)
                .define('R', Items.STICK)
                .unlockedBy(getHasName(ModItems.SNIFFER_TUFT), has(ModItems.SNIFFER_TUFT))
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "brush_from_tuft")));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BED.pick(DyeColor.GREEN), 1)
                .pattern("GGG")
                .pattern("RRR")
                .define('G', ModItems.SNIFFER_WOOL)
                .define('R', ItemTags.PLANKS)
                .unlockedBy(getHasName(ModItems.SNIFFER_WOOL), has(ModItems.SNIFFER_WOOL))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "bed_from_sniffer_wool")));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, Items.BANNER.pick(DyeColor.GREEN), 6)
                .pattern("GGG")
                .pattern("GGG")
                .pattern(" R ")
                .define('G', ModItems.SNIFFER_WOOL)
                .define('R', Items.STICK)
                .unlockedBy(getHasName(ModItems.SNIFFER_WOOL), has(ModItems.SNIFFER_WOOL))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "banner_from_sniffer_wool")));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModItems.PLATED_CALCITE), RecipeCategory.BUILDING_BLOCKS, ModItems.CHISELED_PLATED_CALCITE, 1)
                .unlockedBy(getHasName(ModItems.PLATED_CALCITE), has(ModItems.PLATED_CALCITE))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "chiseled_plated_calcite_from_stone_cutter")));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModItems.PLATED_CALCITE, 1)
                .unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "plated_calcite_from_stone_cutter")));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.TERRACOTTA), RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICKS, 1)
                .unlockedBy(getHasName(Items.TERRACOTTA), has(Items.TERRACOTTA))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "terracotta_bricks_from_stone_cutter")));


        this.shapeless(RecipeCategory.MISC, ModItems.DYNAMITE, 1)
                .requires(Items.PAPER)
                .requires(Items.STRING)
                .requires(Items.GUNPOWDER)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .unlockedBy(getHasName(Items.GUNPOWDER), has(Items.GUNPOWDER))
                .unlockedBy(getHasName(ModItems.DYNAMITE), has(ModItems.DYNAMITE))
                .save(this.output);

        List<ItemLike> UNFIRED_TEA_CUP = List.of(ModItems.UNFIRED_TEA_CUP);
        this.oreSmelting(UNFIRED_TEA_CUP, RecipeCategory.FOOD, CookingBookCategory.FOOD, ModItems.TEA_CUP, 0.25f, 200, "tea_cup");
        this.oreBlasting(UNFIRED_TEA_CUP, RecipeCategory.FOOD, CookingBookCategory.FOOD, ModItems.TEA_CUP, 0.25f, 150, "tea_cup");

        List<ItemLike> SNIFFER_MEAT = List.of(ModItems.SNIFFER_MEAT);
        this.oreSmelting(SNIFFER_MEAT, RecipeCategory.FOOD, CookingBookCategory.FOOD, ModItems.COOKED_SNIFFER_MEAT, 0.25f, 200, "sniffer_meat");

        this.shaped(RecipeCategory.FOOD, ModItems.UNFIRED_TEA_CUP, 1)
                .pattern("R R")
                .pattern(" R ")
                .define('R', Items.CLAY_BALL)
                .unlockedBy(getHasName(Items.CLAY_BALL), has(Items.CLAY_BALL))
                .save(output);

        this.shaped(RecipeCategory.FOOD, ModItems.TEAPOTBLOCK, 1)
                .pattern("R R")
                .pattern(" R ")
                .pattern("XCX")
                .define('R', Items.COPPER_INGOT)
                .define('X', ItemTags.LOGS)
                .define('C', Items.COAL)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .unlockedBy(getHasName(Items.OAK_LOG), has(Items.OAK_LOG))
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(output);


        this.shaped(RecipeCategory.TOOLS, ModItems.GLOWING_SPYGLASS, 1)
                .pattern("LLL")
                .pattern("LXL")
                .pattern("LLL")
                .define('X', Items.SPYGLASS)
                .define('L', Items.GLOW_INK_SAC)
                .unlockedBy(getHasName(Items.SPYGLASS), has(Items.SPYGLASS))
                .unlockedBy(getHasName(Items.GLOW_INK_SAC), has(Items.GLOW_INK_SAC))
                .save(output);

        this.shapeless(RecipeCategory.FOOD, ModItems.GOURMET_MEAL, 1)
                .requires(ModItems.RARE_SPICES)
                .requires(Items.BEETROOT)
                .requires(Items.COOKED_CHICKEN)
                .requires(Items.CARROT)
                .unlockedBy(getHasName(ModItems.RARE_SPICES), has(ModItems.RARE_SPICES))
                .unlockedBy(getHasName(Items.BEETROOT), has(Items.BEETROOT))
                .unlockedBy(getHasName(Items.CARROT), has(Items.CARROT))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN), has(Items.COOKED_CHICKEN))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "gourmet_meal_chicken")));

        this.shapeless(RecipeCategory.FOOD, ModItems.GOURMET_MEAL, 1)
                .requires(ModItems.RARE_SPICES)
                .requires(Items.BEETROOT)
                .requires(Items.COOKED_RABBIT)
                .requires(Items.CARROT)
                .unlockedBy(getHasName(ModItems.RARE_SPICES), has(ModItems.RARE_SPICES))
                .unlockedBy(getHasName(Items.BEETROOT), has(Items.BEETROOT))
                .unlockedBy(getHasName(Items.CARROT), has(Items.CARROT))
                .unlockedBy(getHasName(Items.COOKED_RABBIT), has(Items.COOKED_RABBIT))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "gourmet_meal_rabbit")));


        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.WATER_TORCH, 4)
                .pattern("Y")
                .pattern("X")
                .define('Y', Items.GLOW_INK_SAC)
                .define('X', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.GLOW_INK_SAC), has(Items.GLOW_INK_SAC))
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .save(output);


        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICKS, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', Items.TERRACOTTA)
                .define('R', Items.BRICK)
                .unlockedBy(getHasName(Items.BRICK), has(Items.BRICK))
                .unlockedBy(getHasName(Items.TERRACOTTA), has(Items.TERRACOTTA))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.PETRIFIED_DIRT, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', Items.RESIN_CLUMP)
                .define('R', Items.DIRT)
                .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                .unlockedBy(getHasName(Blocks.DIRT), has(Items.DIRT))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BLACK_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.BLACK))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.BLACK)), has(Items.WOOL.pick(DyeColor.BLACK)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_GRAY_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.GRAY))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.GRAY)), has(Items.WOOL.pick(DyeColor.GRAY)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIGHT_GRAY_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.LIGHT_GRAY))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.LIGHT_GRAY)), has(Items.WOOL.pick(DyeColor.LIGHT_GRAY)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_WHITE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.WHITE))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.WHITE)), has(Items.WOOL.pick(DyeColor.WHITE)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BROWN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.BROWN))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.BROWN)), has(Items.WOOL.pick(DyeColor.BROWN)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_ORANGE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.ORANGE))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.ORANGE)), has(Items.WOOL.pick(DyeColor.ORANGE)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_RED_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.RED))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.RED)), has(Items.WOOL.pick(DyeColor.RED)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_YELLOW_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.YELLOW))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.YELLOW)), has(Items.WOOL.pick(DyeColor.YELLOW)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIME_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.LIME))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.LIME)), has(Items.WOOL.pick(DyeColor.LIME)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_GREEN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.GREEN))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.GREEN)), has(Items.WOOL.pick(DyeColor.GREEN)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_CYAN_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.CYAN))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.CYAN)), has(Items.WOOL.pick(DyeColor.CYAN)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIGHT_BLUE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.LIGHT_BLUE))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.LIGHT_BLUE)), has(Items.WOOL.pick(DyeColor.LIGHT_BLUE)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BLUE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.BLUE))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.BLUE)), has(Items.WOOL.pick(DyeColor.BLUE)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_PURPLE_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.PURPLE))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.PURPLE)), has(Items.WOOL.pick(DyeColor.PURPLE)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_MAGENTA_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.MAGENTA))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.MAGENTA)), has(Items.WOOL.pick(DyeColor.MAGENTA)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_PINK_WOOL, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', ModItems.SILK)
                .define('R', Items.WOOL.pick(DyeColor.PINK))
                .unlockedBy(getHasName(Items.WOOL.pick(DyeColor.PINK)), has(Items.WOOL.pick(DyeColor.PINK)))
                .unlockedBy(getHasName(ModItems.SILK), has(ModItems.SILK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BLACK_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_BLACK_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_BLACK_WOOL), has(ModItems.FANCY_BLACK_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BROWN_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_BROWN_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_BROWN_WOOL), has(ModItems.FANCY_BROWN_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_GRAY_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_GRAY_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_GRAY_WOOL), has(ModItems.FANCY_GRAY_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIGHT_GRAY_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_LIGHT_GRAY_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_LIGHT_GRAY_WOOL), has(ModItems.FANCY_LIGHT_GRAY_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_WHITE_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_WHITE_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_WHITE_WOOL), has(ModItems.FANCY_WHITE_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_BLUE_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_BLUE_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_BLUE_WOOL), has(ModItems.FANCY_BLUE_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIGHT_BLUE_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_LIGHT_BLUE_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_LIGHT_BLUE_WOOL), has(ModItems.FANCY_LIGHT_BLUE_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_LIME_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_LIME_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_LIME_WOOL), has(ModItems.FANCY_LIME_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_GREEN_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_GREEN_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_GREEN_WOOL), has(ModItems.FANCY_GREEN_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_YELLOW_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_YELLOW_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_YELLOW_WOOL), has(ModItems.FANCY_YELLOW_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_RED_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_RED_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_RED_WOOL), has(ModItems.FANCY_RED_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_ORANGE_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_ORANGE_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_ORANGE_WOOL), has(ModItems.FANCY_ORANGE_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_PINK_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_PINK_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_PINK_WOOL), has(ModItems.FANCY_PINK_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_CYAN_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_CYAN_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_CYAN_WOOL), has(ModItems.FANCY_CYAN_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_MAGENTA_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_MAGENTA_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_MAGENTA_WOOL), has(ModItems.FANCY_MAGENTA_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.FANCY_PURPLE_CARPET, 2)
                .pattern("RR")
                .define('R', ModItems.FANCY_PURPLE_WOOL)
                .unlockedBy(getHasName(ModItems.FANCY_PURPLE_WOOL), has(ModItems.FANCY_PURPLE_WOOL))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GILDED_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', Items.GOLD_NUGGET)
                .define('R', Items.SANDSTONE)
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(Items.SANDSTONE), has(Items.SANDSTONE))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GILDED_CHISELED_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', Items.GOLD_NUGGET)
                .define('R', Items.CHISELED_SANDSTONE)
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(Items.CHISELED_SANDSTONE), has(Items.CHISELED_SANDSTONE))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GILDED_CUT_SANDSTONE, 4)
                .pattern("RS")
                .pattern("SR")
                .define('S', Items.GOLD_NUGGET)
                .define('R', Items.CUT_SANDSTONE)
                .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                .unlockedBy(getHasName(Items.CUT_SANDSTONE), has(Items.CUT_SANDSTONE))
                .save(output);

        //Desert Oak

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .define('X', ModItems.DESERT_OAK_PLANKS)
                .define('R', Items.STICK)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_SLAB, 6)
                .pattern("RRR")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.TRANSPORTATION, ModItems.DESERT_OAK_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.DESERT_OAK_LOG)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_LOG), has(ModItems.DESERT_OAK_LOG))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STRIPPED_DESERT_OAK_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.STRIPPED_DESERT_OAK_LOG)
                .unlockedBy(getHasName(ModItems.STRIPPED_DESERT_OAK_LOG), has(ModItems.STRIPPED_DESERT_OAK_LOG))
                .save(output);

        this.shaped(RecipeCategory.REDSTONE, ModItems.DESERT_OAK_PRESSURE_PLATE, 1)
                .pattern("RR")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .define('R', ModItems.OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSIDIAN_SHARD), has(ModItems.OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .define('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.WEDGE_OBSIDIAN_SHARD), has(ModItems.WEDGE_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.SHARP_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("R")
                .pattern("X")
                .define('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.SHARP_OBSIDIAN_SHARD), has(ModItems.SHARP_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        //custom ones
        this.shaped(RecipeCategory.COMBAT, ModItems.SHARP_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .define('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .define('C', ModItems.OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSIDIAN_SHARD), has(ModItems.OBSIDIAN_SHARD))
                .unlockedBy(getHasName(ModItems.SHARP_OBSIDIAN_SHARD), has(ModItems.SHARP_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .define('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .define('C', ModItems.OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSIDIAN_SHARD), has(ModItems.OBSIDIAN_SHARD))
                .unlockedBy(getHasName(ModItems.WEDGE_OBSIDIAN_SHARD), has(ModItems.WEDGE_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.SHARP_WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .define('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .define('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.WEDGE_OBSIDIAN_SHARD), has(ModItems.WEDGE_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(ModItems.SHARP_OBSIDIAN_SHARD), has(ModItems.SHARP_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.SHARP_WEDGE_OBSIDIAN_SWORD, 1)
                .pattern("C")
                .pattern("R")
                .pattern("X")
                .define('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .define('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.WEDGE_OBSIDIAN_SHARD), has(ModItems.WEDGE_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(ModItems.SHARP_OBSIDIAN_SHARD), has(ModItems.SHARP_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "sharp_wedge_obsidian_sword_2")));

        this.shaped(RecipeCategory.COMBAT, ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .define('R', ModItems.OBSIDIAN_SHARD)
                .define('C', ModItems.WEDGE_OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.WEDGE_OBSIDIAN_SHARD), has(ModItems.WEDGE_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(ModItems.OBSIDIAN_SHARD), has(ModItems.OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "regular_wedge_obsidian_sword_2")));

        this.shaped(RecipeCategory.COMBAT, ModItems.SHARP_REGULAR_OBSIDIAN_SWORD, 1)
                .pattern("R")
                .pattern("C")
                .pattern("X")
                .define('R', ModItems.OBSIDIAN_SHARD)
                .define('C', ModItems.SHARP_OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.SHARP_OBSIDIAN_SHARD), has(ModItems.SHARP_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(ModItems.OBSIDIAN_SHARD), has(ModItems.OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "regular_sharp_obsidian_sword_2")));

        this.shaped(RecipeCategory.COMBAT, ModItems.OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .define('R', ModItems.OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.OBSIDIAN_SHARD), has(ModItems.OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.WEDGE_OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .define('R', ModItems.WEDGE_OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.WEDGE_OBSIDIAN_SHARD), has(ModItems.WEDGE_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.SHARP_OBSIDIAN_DAGGER, 1)
                .pattern("R")
                .pattern("X")
                .define('R', ModItems.SHARP_OBSIDIAN_SHARD)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.SHARP_OBSIDIAN_SHARD), has(ModItems.SHARP_OBSIDIAN_SHARD))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_SLAB, 6)
                .pattern("RRR")
                .define('R', ModItems.TERRACOTTA_BRICKS)
                .unlockedBy(getHasName(ModItems.TERRACOTTA_BRICKS), has(ModItems.TERRACOTTA_BRICKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .define('R', ModItems.TERRACOTTA_BRICKS)
                .unlockedBy(getHasName(ModItems.TERRACOTTA_BRICKS), has(ModItems.TERRACOTTA_BRICKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TERRACOTTA_BRICK_WALL, 6)
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.TERRACOTTA_BRICKS)
                .unlockedBy(getHasName(ModItems.TERRACOTTA_BRICKS), has(ModItems.TERRACOTTA_BRICKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GUANO_BRICKS, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.PACKED_GUANO)
                .unlockedBy(getHasName(ModItems.PACKED_GUANO), has(ModItems.PACKED_GUANO))
                .save(output);


        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GUANO_BRICK_SLAB, 6)
                .pattern("RRR")
                .define('R', ModItems.GUANO_BRICKS)
                .unlockedBy(getHasName(ModItems.GUANO_BRICKS), has(ModItems.GUANO_BRICKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GUANO_BRICK_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .define('R', ModItems.GUANO_BRICKS)
                .unlockedBy(getHasName(ModItems.GUANO_BRICKS), has(ModItems.GUANO_BRICKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GUANO_BRICK_WALL, 6)
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.GUANO_BRICKS)
                .unlockedBy(getHasName(ModItems.GUANO_BRICKS), has(ModItems.GUANO_BRICKS))
                .save(output);





        this.shaped(RecipeCategory.FOOD, ModItems.SPICE_BARREL, 1)
                .pattern("RRR")
                .pattern("RXR")
                .pattern("RRR")
                .define('R', ModItems.RARE_SPICES)
                .define('X', Items.BARREL)
                .unlockedBy(getHasName(ModItems.RARE_SPICES), has(ModItems.RARE_SPICES))
                .unlockedBy(getHasName(Items.BARREL), has(Items.BARREL))
                .save(output);

        this.shaped(RecipeCategory.TOOLS, ModItems.BATTERED_AXE, 1)
                .pattern("RYR")
                .pattern(" X ")
                .define('Y', ModItems.BATTERED_AXE_REMNANT)
                .define('X', Items.STICK)
                .define('R', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .unlockedBy(getHasName(ModItems.BATTERED_AXE_REMNANT), has(ModItems.BATTERED_AXE_REMNANT))
                .save(output);


        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_HANGING_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.STRIPPED_DESERT_OAK_LOG)
                .define('X', Blocks.IRON_CHAIN)
                .unlockedBy(getHasName(ModItems.STRIPPED_DESERT_OAK_LOG), has(ModItems.STRIPPED_DESERT_OAK_LOG))
                .unlockedBy(getHasName(Blocks.IRON_CHAIN), has(Blocks.IRON_CHAIN))
                .save(output);

        this.copySmithingTemplate(ModItems.PETRIFIED_ARMOR_TRIM_SMITHING_TEMPLATE, Ingredient.of(ModItems.PETRIFIED_DIRT));

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_BUTTON, 1)
                .pattern("R")
                .define('R', ModItems.DESERT_OAK_PLANKS)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_PLANKS), has(ModItems.DESERT_OAK_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.UNDERGROWTH, 3)
                .pattern("RR")
                .unlockedBy(getHasName(Items.SHEARS), has(Items.SHEARS))
                .define('R', ItemTags.LEAVES)
                .save(output);


        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_PLANKS, 4)
                .requires(ModItems.DESERT_OAK_LOG)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_LOG), has(ModItems.DESERT_OAK_LOG))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_desert0")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_PLANKS, 4)
                .requires(ModItems.STRIPPED_DESERT_OAK_LOG)
                .unlockedBy(getHasName(ModItems.STRIPPED_DESERT_OAK_LOG), has(ModItems.STRIPPED_DESERT_OAK_LOG))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_desert1")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_PLANKS, 4)
                .requires(ModItems.STRIPPED_DESERT_OAK_WOOD)
                .unlockedBy(getHasName(ModItems.STRIPPED_DESERT_OAK_WOOD), has(ModItems.STRIPPED_DESERT_OAK_WOOD))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_desert2")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DESERT_OAK_PLANKS, 4)
                .requires(ModItems.DESERT_OAK_WOOD)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_WOOD), has(ModItems.DESERT_OAK_WOOD))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_desert3")));

        this.shapeless(RecipeCategory.MISC, ModItems.SILK, 1)
                .requires(Items.STRING)
                .unlockedBy(getHasName(Items.STRING), has(Items.STRING))
                .save(output);



        this.shapeless(RecipeCategory.MISC, Items.DYE.pick(DyeColor.MAGENTA), 2)
                .requires(ModItems.CALLALILY_LILAC)
                .unlockedBy(getHasName(ModItems.CALLALILY_LILAC), has(ModItems.CALLALILY_LILAC))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "magenta_dye_lily")));

        this.shapeless(RecipeCategory.MISC, Items.DYE.pick(DyeColor.PINK), 2)
                .requires(ModItems.CALLALILY_PINK)
                .unlockedBy(getHasName(ModItems.CALLALILY_PINK), has(ModItems.CALLALILY_PINK))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "pink_dye_lily")));


        this.shapeless(RecipeCategory.MISC, Items.DYE.pick(DyeColor.WHITE), 2)
                .requires(ModItems.CALLALILY_WHITE)
                .unlockedBy(getHasName(ModItems.CALLALILY_WHITE), has(ModItems.CALLALILY_WHITE))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "white_dye_lily")));

        this.shapeless(RecipeCategory.MISC, Items.DYE.pick(DyeColor.PURPLE), 1)
                .requires(ModItems.COLUMBINE)
                .unlockedBy(getHasName(ModItems.COLUMBINE), has(ModItems.COLUMBINE))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "purple_dye_columbine")));


        this.shapeless(RecipeCategory.MISC, Items.DYE.pick(DyeColor.YELLOW), 2)
                .requires(ModItems.CALLALILY_YELLOW)
                .unlockedBy(getHasName(ModItems.CALLALILY_YELLOW), has(ModItems.CALLALILY_YELLOW))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "yellow_dye_lily")));

        this.shapeless(RecipeCategory.MISC, Items.DYE.pick(DyeColor.PURPLE), 2)
                .requires(ModItems.CALLALILY_PURPLE)
                .unlockedBy(getHasName(ModItems.CALLALILY_PURPLE), has(ModItems.CALLALILY_PURPLE))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "purple_dye_lily")));



        //rotten wood
        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_BUTTON, 1)
                .pattern("R")
                .define('R', ModItems.ROTTEN_PLANKS)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PRESSURE_PLATE, 1)
                .pattern("RR")
                .define('R', ModItems.ROTTEN_PLANKS)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.ROTTEN_PLANKS)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.ROTTEN_PLANKS)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .define('R', ModItems.ROTTEN_PLANKS)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .define('X', ModItems.ROTTEN_PLANKS)
                .define('R', Items.STICK)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);


        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .define('R', ModItems.ROTTEN_PLANKS)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_HANGING_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.STRIPPED_ROTTEN_LOG)
                .define('X', Blocks.IRON_CHAIN)
                .unlockedBy(getHasName(ModItems.STRIPPED_ROTTEN_LOG), has(ModItems.STRIPPED_ROTTEN_LOG))
                .unlockedBy(getHasName(Blocks.IRON_CHAIN), has(Blocks.IRON_CHAIN))
                .save(output);


        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_SLAB, 6)
                .pattern("RRR")
                .define('R', ModItems.ROTTEN_PLANKS)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .define('R', ModItems.ROTTEN_PLANKS)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.TRANSPORTATION, ModItems.ROTTEN_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .define('R', ModItems.ROTTEN_PLANKS)
                .unlockedBy(getHasName(ModItems.ROTTEN_PLANKS), has(ModItems.ROTTEN_PLANKS))
                                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.ROTTEN_LOG)
                .unlockedBy(getHasName(ModItems.ROTTEN_LOG), has(ModItems.ROTTEN_LOG))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STRIPPED_ROTTEN_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.STRIPPED_ROTTEN_LOG)
                .unlockedBy(getHasName(ModItems.STRIPPED_ROTTEN_LOG), has(ModItems.STRIPPED_ROTTEN_LOG))
                .save(output);

        this.shaped(RecipeCategory.DECORATIONS, ModItems.ROT_BLOCK, 4)
                .pattern("XR")
                .pattern("RX")
                .define('R', Blocks.DIRT)
                .define('X', Items.BONE_MEAL)
                .unlockedBy(getHasName(Blocks.DIRT), has(Blocks.DIRT))
                .unlockedBy(getHasName(Items.BONE_MEAL), has(Items.BONE_MEAL))
                .save(output);

        this.shaped(RecipeCategory.DECORATIONS, ModItems.GUANO_PILE, 2)
                .pattern("RR")
                .define('R', ModItems.GUANO)
                .unlockedBy(getHasName(ModItems.GUANO), has(ModItems.GUANO))
                .save(output);
        this.shaped(RecipeCategory.DECORATIONS, ModItems.GUANO_BLOCK, 1)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.GUANO)
                .unlockedBy(getHasName(ModItems.GUANO), has(ModItems.GUANO))
                .save(output);

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.BONE_MEAL, 3)
                .requires(ModItems.GUANO)
                .unlockedBy(getHasName(ModItems.GUANO), has(ModItems.GUANO))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "bonemeal_from_guano")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PLANKS, 4)
                .requires(ModItems.MAHOGANY_LOG)
                .unlockedBy(getHasName(ModItems.MAHOGANY_LOG), has(ModItems.MAHOGANY_LOG))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_mahogany0")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PLANKS, 4)
                .requires(ModItems.STRIPPED_MAHOGANY_LOG)
                .unlockedBy(getHasName(ModItems.STRIPPED_MAHOGANY_LOG), has(ModItems.STRIPPED_MAHOGANY_LOG))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_mahogany1")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PLANKS, 4)
                .requires(ModItems.STRIPPED_MAHOGANY_WOOD)
                .unlockedBy(getHasName(ModItems.STRIPPED_MAHOGANY_WOOD), has(ModItems.STRIPPED_MAHOGANY_WOOD))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_mahogany2")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PLANKS, 4)
                .requires(ModItems.MAHOGANY_WOOD)
                .unlockedBy(getHasName(ModItems.MAHOGANY_WOOD), has(ModItems.MAHOGANY_WOOD))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_mahogany3")));




        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PLANKS, 4)
                .requires(ModItems.ROTTEN_LOG)
                .unlockedBy(getHasName(ModItems.ROTTEN_LOG), has(ModItems.ROTTEN_LOG))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_rotten0")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PLANKS, 4)
                .requires(ModItems.STRIPPED_ROTTEN_LOG)
                .unlockedBy(getHasName(ModItems.STRIPPED_ROTTEN_LOG), has(ModItems.STRIPPED_ROTTEN_LOG))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_rotten1")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PLANKS, 4)
                .requires(ModItems.STRIPPED_ROTTEN_WOOD)
                .unlockedBy(getHasName(ModItems.STRIPPED_ROTTEN_WOOD), has(ModItems.STRIPPED_ROTTEN_WOOD))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_rotten2")));

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ROTTEN_PLANKS, 4)
                .requires(ModItems.ROTTEN_WOOD)
                .unlockedBy(getHasName(ModItems.ROTTEN_WOOD), has(ModItems.ROTTEN_WOOD))
                .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "planks_rotten3")));


        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_DOOR, 3)
                .pattern("RR")
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_TRAPDOOR, 2)
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_FENCE, 3)
                .pattern("RXR")
                .pattern("RXR")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_FENCE_GATE, 1)
                .pattern("RXR")
                .pattern("RXR")
                .define('X', ModItems.MAHOGANY_PLANKS)
                .define('R', Items.STICK)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_SLAB, 6)
                .pattern("RRR")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_STAIRS, 4)
                .pattern("R  ")
                .pattern("RR ")
                .pattern("RRR")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.TRANSPORTATION, ModItems.MAHOGANY_BOAT, 1)
                .pattern("R R")
                .pattern("RRR")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.MAHOGANY_LOG)
                .unlockedBy(getHasName(ModItems.MAHOGANY_LOG), has(ModItems.MAHOGANY_LOG))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STRIPPED_MAHOGANY_WOOD, 4)
                .pattern("RR")
                .pattern("RR")
                .define('R', ModItems.STRIPPED_MAHOGANY_LOG)
                .unlockedBy(getHasName(ModItems.STRIPPED_MAHOGANY_LOG), has(ModItems.STRIPPED_MAHOGANY_LOG))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_SIGN, 3)
                .pattern("RRR")
                .pattern("RRR")
                .pattern(" X ")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_HANGING_SIGN, 6)
                .pattern("X X")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.STRIPPED_MAHOGANY_LOG)
                .define('X', Blocks.IRON_CHAIN)
                .unlockedBy(getHasName(ModItems.STRIPPED_MAHOGANY_LOG), has(ModItems.STRIPPED_MAHOGANY_LOG))
                .unlockedBy(getHasName(Blocks.IRON_CHAIN), has(Blocks.IRON_CHAIN))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_BUTTON, 1)
                .pattern("R")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .save(output);

        this.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAHOGANY_PRESSURE_PLATE, 1)
                .pattern("RR")
                .define('R', ModItems.MAHOGANY_PLANKS)
                .unlockedBy(getHasName(ModItems.MAHOGANY_PLANKS), has(ModItems.MAHOGANY_PLANKS))
                .save(output);

        this.shapeless(RecipeCategory.COMBAT, ModItems.GLOW_BALL, 1)
                .requires(Items.SNOWBALL)
                .requires(Items.GLOW_INK_SAC)
                .unlockedBy(getHasName(Items.SNOWBALL), has(Items.SNOWBALL))
                .unlockedBy(getHasName(Items.GLOW_INK_SAC), has(Items.GLOW_INK_SAC))
                .save(this.output);

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.BIOLUMINESCENT_BOTTLE.asItem(), 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLOW_INK_SAC)
                .unlockedBy(getHasName(Items.GLASS_BOTTLE), has(Items.GLASS_BOTTLE))
                .unlockedBy(getHasName(Items.GLOW_INK_SAC), has(Items.GLOW_INK_SAC))
                .save(this.output);

        this.shapeless(RecipeCategory.TRANSPORTATION, ModItems.DESERT_OAK_CHEST_BOAT, 1)
                .requires(ModItems.DESERT_OAK_BOAT)
                .requires(Items.CHEST)
                .unlockedBy(getHasName(ModItems.DESERT_OAK_BOAT), has(ModItems.DESERT_OAK_BOAT))
                .unlockedBy(getHasName(Items.CHEST), has(Items.CHEST))
                .save(output);

        this.shapeless(RecipeCategory.TRANSPORTATION, ModItems.MAHOGANY_CHEST_BOAT, 1)
                .requires(ModItems.MAHOGANY_BOAT)
                .requires(Items.CHEST)
                .unlockedBy(getHasName(ModItems.MAHOGANY_BOAT), has(ModItems.MAHOGANY_BOAT))
                .unlockedBy(getHasName(Items.CHEST), has(Items.CHEST))
                .save(output);

        this.shapeless(RecipeCategory.TRANSPORTATION, ModItems.ROTTEN_CHEST_BOAT, 1)
                .requires(ModItems.ROTTEN_BOAT)
                .requires(Items.CHEST)
                .unlockedBy(getHasName(ModItems.ROTTEN_BOAT), has(ModItems.ROTTEN_BOAT))
                .unlockedBy(getHasName(Items.CHEST), has(Items.CHEST))
                .save(output);


        this.shapeless(RecipeCategory.TRANSPORTATION, ModItems.PACKED_GUANO, 4)
                .requires(ModItems.GUANO_BLOCK)
                .requires(Items.WHEAT)
                .unlockedBy(getHasName(ModItems.GUANO_BLOCK), has(ModItems.GUANO_BLOCK))
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(output);

        this.shaped(RecipeCategory.COMBAT, ModItems.MACUAHUITL, 1)
                .pattern("RCR")
                .pattern("RCR")
                .pattern(" X ")
                .define('R', ModTags.Items.OBSIDIAN_SHARDS)
                .define('C', ItemTags.PLANKS)
                .define('X', Items.STICK)
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                .save(output);

    }

    public static class Provider extends RecipeProvider.Runner {
        public Provider(PackOutput dataOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(dataOutput, completableFuture);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput exporter) {
            return new ModRecipeProvider(registries, exporter);
        }

        @Override
        public String getName() {
            return "JaizMod Recipes";
        }
    }

}
