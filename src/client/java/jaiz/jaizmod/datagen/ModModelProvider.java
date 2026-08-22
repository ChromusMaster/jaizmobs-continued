package jaiz.jaizmod.datagen;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Blocks;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) { super(output);}

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.AMETHYST_THORN, BlockModelGenerators.PlantType.NOT_TINTED);

        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.COLUMBINE, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.ANCIENT_SPROUT, BlockModelGenerators.PlantType.EMISSIVE_NOT_TINTED);
        blockStateModelGenerator.createCrossBlockWithDefaultItem(Blocks.TORCHFLOWER, BlockModelGenerators.PlantType.EMISSIVE_NOT_TINTED);
        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.ROT_ROOTS, BlockModelGenerators.PlantType.NOT_TINTED);

        blockStateModelGenerator.createDoublePlantWithDefaultItem(ModBlocks.CALLALILY_WHITE, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createDoublePlantWithDefaultItem(ModBlocks.CALLALILY_PURPLE, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createDoublePlantWithDefaultItem(ModBlocks.CALLALILY_YELLOW, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createDoublePlantWithDefaultItem(ModBlocks.CALLALILY_LILAC, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createDoublePlantWithDefaultItem(ModBlocks.CALLALILY_PINK, BlockModelGenerators.PlantType.NOT_TINTED);

        blockStateModelGenerator.woodProvider(ModBlocks.STRIPPED_ROTTEN_LOG).log(ModBlocks.STRIPPED_ROTTEN_LOG).wood(ModBlocks.STRIPPED_ROTTEN_WOOD);

        BlockModelGenerators.BlockFamilyProvider rotten_pool = blockStateModelGenerator.family(ModBlocks.ROTTEN_PLANKS);
        rotten_pool.generateFor(ModBlocks.ROTTEN_FAMILY);

        rotten_pool.stairs(ModBlocks.ROTTEN_STAIRS);
        rotten_pool.slab(ModBlocks.ROTTEN_SLAB);
        rotten_pool.fence(ModBlocks.ROTTEN_FENCE);
        rotten_pool.fenceGate(ModBlocks.ROTTEN_FENCE_GATE);
        rotten_pool.button(ModBlocks.ROTTEN_BUTTON);
        rotten_pool.pressurePlate(ModBlocks.ROTTEN_PRESSURE_PLATE);
        blockStateModelGenerator.createDoor(ModBlocks.ROTTEN_DOOR);
        blockStateModelGenerator.createOrientableTrapdoor(ModBlocks.ROTTEN_TRAPDOOR);

        blockStateModelGenerator.woodProvider(ModBlocks.MAHOGANY_LOG).log(ModBlocks.MAHOGANY_LOG).wood(ModBlocks.MAHOGANY_WOOD);

        blockStateModelGenerator.woodProvider(ModBlocks.STRIPPED_MAHOGANY_LOG).log(ModBlocks.STRIPPED_MAHOGANY_LOG).wood(ModBlocks.STRIPPED_MAHOGANY_WOOD);

        BlockModelGenerators.BlockFamilyProvider mahogany_pool = blockStateModelGenerator.family(ModBlocks.MAHOGANY_PLANKS);
        mahogany_pool.generateFor(ModBlocks.MAHOGANY_FAMILY);

        mahogany_pool.stairs(ModBlocks.MAHOGANY_STAIRS);
        mahogany_pool.slab(ModBlocks.MAHOGANY_SLAB);
        mahogany_pool.fence(ModBlocks.MAHOGANY_FENCE);
        mahogany_pool.fenceGate(ModBlocks.MAHOGANY_FENCE_GATE);
        mahogany_pool.button(ModBlocks.MAHOGANY_BUTTON);
        mahogany_pool.pressurePlate(ModBlocks.MAHOGANY_PRESSURE_PLATE);
        blockStateModelGenerator.createDoor(ModBlocks.MAHOGANY_DOOR);
        blockStateModelGenerator.createOrientableTrapdoor(ModBlocks.MAHOGANY_TRAPDOOR);

        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_WHITE_WOOL), (ModBlocks.FANCY_WHITE_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_LIGHT_GRAY_WOOL), (ModBlocks.FANCY_LIGHT_GRAY_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_GRAY_WOOL), (ModBlocks.FANCY_GRAY_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_BLACK_WOOL), (ModBlocks.FANCY_BLACK_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_BROWN_WOOL), (ModBlocks.FANCY_BROWN_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_RED_WOOL), (ModBlocks.FANCY_RED_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_YELLOW_WOOL), (ModBlocks.FANCY_YELLOW_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_LIME_WOOL), (ModBlocks.FANCY_LIME_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_CYAN_WOOL), (ModBlocks.FANCY_CYAN_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_LIGHT_BLUE_WOOL), (ModBlocks.FANCY_LIGHT_BLUE_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_PURPLE_WOOL), (ModBlocks.FANCY_PURPLE_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_MAGENTA_WOOL), (ModBlocks.FANCY_MAGENTA_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_PINK_WOOL), (ModBlocks.FANCY_PINK_CARPET));
        blockStateModelGenerator.createFullAndCarpetBlocks((ModBlocks.FANCY_BLUE_WOOL), (ModBlocks.FANCY_BLUE_CARPET));

        blockStateModelGenerator.woodProvider(ModBlocks.FANCY_ORANGE_WOOL).log(ModBlocks.FANCY_ORANGE_WOOL);
        blockStateModelGenerator.woodProvider(ModBlocks.FANCY_GREEN_WOOL).log(ModBlocks.FANCY_GREEN_WOOL);

        blockStateModelGenerator.createTintedLeaves(ModBlocks.MAHOGANY_LEAVES, TexturedModel.LEAVES, 7316046);
        blockStateModelGenerator.createTintedLeaves(ModBlocks.DESERT_OAK_LEAVES, TexturedModel.LEAVES, 8362326);

        blockStateModelGenerator.woodProvider(ModBlocks.DESERT_OAK_LOG).log(ModBlocks.DESERT_OAK_LOG).wood(ModBlocks.DESERT_OAK_WOOD);
        blockStateModelGenerator.woodProvider(ModBlocks.STRIPPED_DESERT_OAK_LOG).log(ModBlocks.STRIPPED_DESERT_OAK_LOG).wood(ModBlocks.STRIPPED_DESERT_OAK_WOOD);

        BlockModelGenerators.BlockFamilyProvider desert_oak_pool = blockStateModelGenerator.family(ModBlocks.DESERT_OAK_PLANKS);
        desert_oak_pool.generateFor(ModBlocks.DESERT_OAK_FAMILY);

        BlockModelGenerators.BlockFamilyProvider terracotta_brick_pool = blockStateModelGenerator.family(ModBlocks.TERRACOTTA_BRICKS);
        terracotta_brick_pool.generateFor(ModBlocks.TERRACOTTA_BRICK_FAMILY);
        terracotta_brick_pool.stairs(ModBlocks.TERRACOTTA_BRICK_STAIRS);
        terracotta_brick_pool.slab(ModBlocks.TERRACOTTA_BRICK_SLAB);
        terracotta_brick_pool.wall(ModBlocks.TERRACOTTA_BRICK_WALL);

        BlockModelGenerators.BlockFamilyProvider guano_pool = blockStateModelGenerator.family(ModBlocks.GUANO_BRICKS);
        guano_pool.generateFor(ModBlocks.GUANO_FAMILY);
        guano_pool.stairs(ModBlocks.GUANO_BRICK_STAIRS);
        guano_pool.slab(ModBlocks.GUANO_BRICK_SLAB);
        guano_pool.wall(ModBlocks.GUANO_BRICK_WALL);

        desert_oak_pool.stairs(ModBlocks.DESERT_OAK_STAIRS);
        desert_oak_pool.slab(ModBlocks.DESERT_OAK_SLAB);
        desert_oak_pool.fence(ModBlocks.DESERT_OAK_FENCE);
        desert_oak_pool.fenceGate(ModBlocks.DESERT_OAK_FENCE_GATE);
        desert_oak_pool.button(ModBlocks.DESERT_OAK_BUTTON);
        desert_oak_pool.pressurePlate(ModBlocks.DESERT_OAK_PRESSURE_PLATE);

        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.DESERT_OAK_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.AUTUMN_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.MAHOGANY_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

        blockStateModelGenerator.createDoor(ModBlocks.DESERT_OAK_DOOR);
        blockStateModelGenerator.createTrapdoor(ModBlocks.DESERT_OAK_TRAPDOOR);

        blockStateModelGenerator.createBrushableBlock(ModBlocks.FOSSIL_SOIL);

        blockStateModelGenerator.createTrivialCube(ModBlocks.PETRIFIED_DIRT);
        blockStateModelGenerator.createTrivialCube(ModBlocks.PACKED_GUANO);
        blockStateModelGenerator.createTrivialCube(ModBlocks.SNOWY_LEAVES);
        blockStateModelGenerator.createTrivialCube(ModBlocks.DRIED_LEAVES);
        blockStateModelGenerator.createTrivialCube(ModBlocks.DEAD_LEAVES);
        blockStateModelGenerator.createTrivialCube(ModBlocks.BLOOMING_IVY_BLOCK);

        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.SLIME_DRIP, BlockModelGenerators.PlantType.NOT_TINTED);

        blockStateModelGenerator.createMultiface(ModBlocks.YELLOW_FLORAL_VEIL);
        blockStateModelGenerator.createMultiface(ModBlocks.WHITE_FLORAL_VEIL);
        blockStateModelGenerator.createMultiface(ModBlocks.PINK_FLORAL_VEIL);
        blockStateModelGenerator.createMultiface(ModBlocks.FROST);
        blockStateModelGenerator.createRotatedVariantBlock(ModBlocks.GUANO_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

        itemModelGenerator.generateFlatItem(ModItems.SILK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TEAPOTBLOCK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WATER_TORCH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SNIFFER_TUFT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BIOLUMINESCENT_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FIREFLY_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHELF_MUSHROOM_BLOCK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.IVY, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNDERGROWTH, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.COCOON_BLOCK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DYNAMITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RARE_SPICES, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OBSIDIAN_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WEDGE_OBSIDIAN_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHARP_OBSIDIAN_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MIMIC_POT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GOURMET_MEAL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.SNIFFER_MEAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.COOKED_SNIFFER_MEAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.BLOOMING_IVY, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.DESERT_OAK_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ROTTEN_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MAHOGANY_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.DESERT_OAK_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ROTTEN_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MAHOGANY_CHEST_BOAT, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.BATTERED_AXE_REMNANT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BATTERED_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.GLOW_BALL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.ORIGAMI_HAIRBALL_MUSIC_DISC, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PETRIFIED_ARMOR_TRIM_SMITHING_TEMPLATE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.MACUAHUITL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHARP_OBSIDIAN_DAGGER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WEDGE_OBSIDIAN_DAGGER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OBSIDIAN_DAGGER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHARP_OBSIDIAN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WEDGE_OBSIDIAN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OBSIDIAN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.GUANO, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.CATERPILLAR_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SNAIL_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BUTTERFLY_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DRAGONFLY_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FRUIT_BAT_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BANDIT_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FIREFLY_SWARM_SPAWN_EGG, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.TEA_CUP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NOVEL_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNFIRED_TEA_CUP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WITHER_ROSE_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PUMPKIN_SPICE_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HERBAL_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHORUS_FRUIT_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.FLOWER_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GLOW_BERRY_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GUNPOWDER_GREEN_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KOMBUCHA_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NETHER_FUNGUS_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.WARPED_NETHER_FUNGUS_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PITCHER_PLANT_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SPORE_BLOSSOM_TEA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TORCH_FLOWER_TEA, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.BUTTERFLY_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SNAIL_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DRAGONFLY_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CATERPILLAR_BOTTLE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.BLOOMING_IVY_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ANCIENT_SPROUT_SEEDS, ModelTemplates.FLAT_ITEM);

    }
}
