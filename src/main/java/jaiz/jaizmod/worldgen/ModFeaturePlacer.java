package jaiz.jaizmod.worldgen;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.fruit_bat.FruitBatEntity;
import jaiz.jaizmod.worldgen.biome.ModBiomes;
import jaiz.jaizmod.worldgen.features.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;

public class ModFeaturePlacer {
    public static void addPlacedFeaturesSpawn() {

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DESERT, Biomes.BADLANDS, Biomes.ERODED_BADLANDS, Biomes.WOODED_BADLANDS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DESERT_OAK_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SMALL_MAHOGANY_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.POO_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.POO_PLACED_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.MOSS_PATCH_FRUIT_BAT_CAVES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.MOSS_PATCH_FRUIT_BAT_CAVES_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.LEAVES_PATCH_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.LEAVES_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.LEAVES_CEILING_PATCH);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.MOSS_CARPET_FRUIT_BAT_CAVES);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES),
                GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.MOSS_CARPET_DEEPSLATE_FRUIT_BAT_CAVES);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PODZOL_PATCH);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.JUNGLE, ModBiomes.MAHOGANY_FOREST, Biomes.BAMBOO_JUNGLE),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MUD_PATCH);


        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.TAIGA,
                        Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.SWAMP, Biomes.DARK_FOREST, Biomes.WOODED_BADLANDS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ROT_RED_MUSHROOM_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST,
                        Biomes.FLOWER_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.SWAMP, Biomes.DARK_FOREST, Biomes.WOODED_BADLANDS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ROT_BROWN_MUSHROOM_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST,
                        Biomes.FLOWER_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.SWAMP, Biomes.DARK_FOREST, Biomes.WOODED_BADLANDS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ROT_ROOTS_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST,
                        Biomes.FLOWER_FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA, Biomes.SWAMP, Biomes.DARK_FOREST, Biomes.WOODED_BADLANDS),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ROTTEN_LOG_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.BIRCH_FOREST_ROCK);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.RIVER, Biomes.BIRCH_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.CALLALILY_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.FLOWER_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DISK_ROOTED_DIRT);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.FLOWER_FOREST),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModPlacedFeatures.WHITE_FLORAL_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModPlacedFeatures.PINK_FLORAL_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.FLOWER_FOREST),
                GenerationStep.Decoration.TOP_LAYER_MODIFICATION, ModPlacedFeatures.YELLOW_FLORAL_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FLOWER_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_BIRCH_PLACED);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.FOREST, Biomes.FLOWER_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_OAK_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.BIRCH_LOG_MOSS);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.BIRCH_FALLEN_LOG);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.DARK_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.DISK_ROT_DIRT);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.FLOWER_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MOSS_BLOCK_PATCH);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.MOSS_PATCH_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.DARK_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FLOWER_COLUMBINE);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.FLOWER_FOREST,
                        Biomes.TAIGA, Biomes.DARK_FOREST, Biomes.JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.UNDERGROWTH_PATCH_PLACED);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.BIRCH_FOREST, Biomes.FOREST, Biomes.FLOWER_FOREST,
                        Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE, ModBiomes.MAHOGANY_FOREST),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.LARGE_FERNS_JAIZMOD);


        //entities
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.MAHOGANY_FOREST), MobCategory.AMBIENT,
                ModEntities.FRUIT_BAT, 15, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(ModBiomes.FRUIT_BAT_CAVES), MobCategory.AMBIENT,
                ModEntities.FRUIT_BAT, 60, 1, 5);

        SpawnPlacements.register(ModEntities.FRUIT_BAT, SpawnPlacements.getPlacementType(ModEntities.FRUIT_BAT), Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FruitBatEntity::canSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.FOREST), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SUNFLOWER_PLAINS), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.TAIGA), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_PINE_TAIGA), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_SPRUCE_TAIGA), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BIRCH_FOREST), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.CHERRY_GROVE), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.MEADOW), MobCategory.CREATURE,
                ModEntities.BUTTERFLY, 5, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.RIVER), MobCategory.CREATURE,
                ModEntities.DRAGONFLY, 3, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SWAMP), MobCategory.CREATURE,
                ModEntities.DRAGONFLY, 3, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.MANGROVE_SWAMP), MobCategory.CREATURE,
                ModEntities.DRAGONFLY, 3, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BEACH), MobCategory.CREATURE,
                ModEntities.DRAGONFLY, 3, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SWAMP), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 5, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_SPRUCE_TAIGA), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_PINE_TAIGA), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_BIRCH_FOREST), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.MANGROVE_SWAMP), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 5, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.RIVER), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.CHERRY_GROVE), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.TAIGA), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SAVANNA), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DARK_FOREST), MobCategory.CREATURE,
                ModEntities.FIRE_FLY_SWARM, 3, 1, 3);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.FLOWER_FOREST), MobCategory.CREATURE,
                ModEntities.CATERPILLAR, 1, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.FOREST), MobCategory.CREATURE,
                ModEntities.CATERPILLAR, 1, 1, 2);

        // Snail
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SWAMP), MobCategory.CREATURE,
                ModEntities.SNAIL, 2, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.MANGROVE_SWAMP), MobCategory.CREATURE,
                ModEntities.SNAIL, 2, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.LUSH_CAVES), MobCategory.CREATURE,
                ModEntities.SNAIL, 2, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DESERT), MobCategory.CREATURE,
                EntityTypes.CAMEL, 1, 1, 1);


        // Spawn Restrictors

        SpawnPlacements.register(ModEntities.BUTTERFLY, SpawnPlacements.getPlacementType(ModEntities.BUTTERFLY), Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntities.CATERPILLAR, SpawnPlacements.getPlacementType(ModEntities.CATERPILLAR), Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntities.FIRE_FLY_SWARM, SpawnPlacements.getPlacementType(ModEntities.FIRE_FLY_SWARM), Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntities.DRAGONFLY, SpawnPlacements.getPlacementType(ModEntities.DRAGONFLY), Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntities.SNAIL, SpawnPlacements.getPlacementType(ModEntities.SNAIL), Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }
}
