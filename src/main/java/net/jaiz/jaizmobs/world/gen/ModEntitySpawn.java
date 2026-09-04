package net.jaiz.jaizmobs.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jaiz.jaizmobs.entity.ModEntities;
import net.jaiz.jaizmobs.entity.custom.*;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.Biomes;

public class ModEntitySpawn {
    public static void addEntitySpawn() {

        // Totem Spirit Spawn
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BADLANDS), MobCategory.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SAVANNA), MobCategory.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SAVANNA_PLATEAU), MobCategory.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WOODED_BADLANDS), MobCategory.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.ERODED_BADLANDS), MobCategory.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WINDSWEPT_SAVANNA), MobCategory.MONSTER,
                ModEntities.TOTEM_SPIRIT, 40, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SNOWY_PLAINS), MobCategory.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SNOWY_SLOPES), MobCategory.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SNOWY_TAIGA), MobCategory.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.FROZEN_PEAKS), MobCategory.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.JAGGED_PEAKS), MobCategory.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.ICE_SPIKES), MobCategory.MONSTER,
                ModEntities.FROSTED_TOTEM_SPIRIT, 15, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.JUNGLE), MobCategory.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 60, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BAMBOO_JUNGLE), MobCategory.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 60, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SPARSE_JUNGLE), MobCategory.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 30, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.TAIGA), MobCategory.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_SPRUCE_TAIGA), MobCategory.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 15, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_PINE_TAIGA), MobCategory.MONSTER,
                ModEntities.JUNGLE_TOTEM_SPIRIT, 15, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DESERT), MobCategory.MONSTER,
                ModEntities.DESERT_TOTEM_SPIRIT, 40, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BEACH), MobCategory.MONSTER,
                ModEntities.DESERT_TOTEM_SPIRIT, 40, 1, 2);

        // Pine Giant Spawn
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_PINE_TAIGA), MobCategory.MONSTER,
                ModEntities.PINE_GIANT, 15, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OLD_GROWTH_SPRUCE_TAIGA), MobCategory.MONSTER,
                ModEntities.PINE_GIANT, 15, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DARK_FOREST), MobCategory.MONSTER,
                ModEntities.PINE_GIANT, 15, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.TAIGA), MobCategory.MONSTER,
                ModEntities.PINE_GIANT, 15, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.LUSH_CAVES), MobCategory.MONSTER,
                ModEntities.PINE_GIANT, 10, 1, 1);

        // Spore Trap Spawn
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BAMBOO_JUNGLE), MobCategory.MONSTER,
                ModEntities.SPORETRAP, 70, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.LUSH_CAVES), MobCategory.MONSTER,
                ModEntities.SPORETRAP, 200, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.JUNGLE), MobCategory.MONSTER,
                ModEntities.SPORETRAP, 40, 1, 2);

        // Void Bull Spawn

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.END_HIGHLANDS), MobCategory.MONSTER,
                ModEntities.VOIDBULL, 1, 1, 1);

        // Aeroblob
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.END_BARRENS), MobCategory.MONSTER,
                ModEntities.AEROBLOB, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SMALL_END_ISLANDS), MobCategory.MONSTER,
                ModEntities.AEROBLOB, 2, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.END_HIGHLANDS), MobCategory.MONSTER,
                ModEntities.AEROBLOB, 1, 1, 1);

        // StarFishes Spawn

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.END_HIGHLANDS), MobCategory.MONSTER,
                ModEntities.STARFISH, 5, 2, 8);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.END_HIGHLANDS), MobCategory.MONSTER,
                ModEntities.STARFISHLEADER, 5, 1, 3);

        // Enderwing / Arch Phantom

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.END_HIGHLANDS), MobCategory.MONSTER,
                ModEntities.ENDERWING, 1, 1, 1);

        // Dripstone Creatures

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DRIPSTONE_CAVES), MobCategory.MONSTER,
                ModEntities.DRIPLET, 220, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DRIPSTONE_CAVES), MobCategory.MONSTER,
                ModEntities.STALAGTITAN, 100, 1, 1);

        // Calcite Golem

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.STONY_PEAKS), MobCategory.CREATURE,
                ModEntities.CALCITE_GOLEM, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.STONY_SHORE), MobCategory.CREATURE,
                ModEntities.CALCITE_GOLEM, 1, 1, 1);

        // Cultivator

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.CHERRY_GROVE), MobCategory.CREATURE,
                ModEntities.CULTIVATOR, 1, 1, 1);

        // Klephtopod

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DEEP_LUKEWARM_OCEAN), MobCategory.WATER_CREATURE,
                ModEntities.KLEPHTOPOD, 1, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WARM_OCEAN), MobCategory.WATER_CREATURE,
                ModEntities.KLEPHTOPOD, 1, 1, 1);

        // Hunter Eel

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.DEEP_LUKEWARM_OCEAN), MobCategory.WATER_CREATURE,
                ModEntities.HUNTER_EEL, 2, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WARM_OCEAN), MobCategory.WATER_CREATURE,
                ModEntities.HUNTER_EEL, 2, 1, 2);

        // MolotovGolem

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BASALT_DELTAS), MobCategory.MONSTER,
                ModEntities.MOLOTOV_GOLEM, 30, 1, 2);

        // Geyser Berry

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WARPED_FOREST), MobCategory.MONSTER,
                ModEntities.GEYSER_BERRY, 10, 2, 5);

        // Trufflers

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.CRIMSON_FOREST), MobCategory.MONSTER,
                ModEntities.CRIMSON_TRUFFLER, 15, 1, 3);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WARPED_FOREST), MobCategory.MONSTER,
                ModEntities.WARPED_TRUFFLER, 15, 1, 3);

        // Ember Beetle

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WARPED_FOREST), MobCategory.MONSTER,
                ModEntities.EMBERBEETLE, 5, 1, 7);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.CRIMSON_FOREST), MobCategory.MONSTER,
                ModEntities.EMBERBEETLE, 5, 1, 7);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.NETHER_WASTES), MobCategory.MONSTER,
                ModEntities.EMBERBEETLE, 5, 1, 7);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BASALT_DELTAS), MobCategory.MONSTER,
                ModEntities.EMBERBEETLE, 5, 1, 7);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY), MobCategory.MONSTER,
                ModEntities.EMBERBEETLE, 4, 1, 7);

        // Soul Wader

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.SOUL_SAND_VALLEY), MobCategory.MONSTER,
                ModEntities.SOULWADER, 1, 1, 3);

        // Strider hunter

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.NETHER_WASTES), MobCategory.MONSTER,
                ModEntities.STRIDER_HUNTER, 10, 1, 2);

        // Spawn Restrictors

        SpawnPlacements.register(ModEntities.TOTEM_SPIRIT, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.JUNGLE_TOTEM_SPIRIT, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.DESERT_TOTEM_SPIRIT, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.FROSTED_TOTEM_SPIRIT, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.PINE_GIANT, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.SPORETRAP, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SporeTrapEntity::canSpawn);
        SpawnPlacements.register(ModEntities.VOIDBULL, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.AEROBLOB, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AeroblobEntity::canSpawn);
        SpawnPlacements.register(ModEntities.DRIPLET, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.STALAGTITAN, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.STARFISH, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, StarFishEntity::canSpawn);
        SpawnPlacements.register(ModEntities.STARFISHLEADER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, StarFishLeaderEntity::canSpawn);
        SpawnPlacements.register(ModEntities.CULTIVATOR, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CultivatorEntity::canSpawn);
        SpawnPlacements.register(ModEntities.CALCITE_GOLEM, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CalciteGolemEntity::canSpawn);
        SpawnPlacements.register(ModEntities.KLEPHTOPOD, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, KlephtopodEntity::canSpawn);
        SpawnPlacements.register(ModEntities.HUNTER_EEL, SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HunterEelEntity::canSpawn);
        SpawnPlacements.register(ModEntities.ENDERWING, SpawnPlacementTypes.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EnderwingEntity::canSpawn);
        SpawnPlacements.register(ModEntities.MOLOTOV_GOLEM, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MolotovGolemEntity::canSpawn);
        SpawnPlacements.register(ModEntities.GEYSER_BERRY, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GeyserBerryEntity::canSpawn);
        SpawnPlacements.register(ModEntities.CRIMSON_TRUFFLER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrimsonTrufflerEntity::canSpawn);
        SpawnPlacements.register(ModEntities.WARPED_TRUFFLER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WarpedTrufflerEntity::canSpawn);
        SpawnPlacements.register(ModEntities.EMBERBEETLE, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EmberBeetleEntity::canSpawn);
        SpawnPlacements.register(ModEntities.SOULWADER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
        SpawnPlacements.register(ModEntities.STRIDER_HUNTER, SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
    }
}
