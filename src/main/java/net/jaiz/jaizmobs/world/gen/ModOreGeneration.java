package net.jaiz.jaizmobs.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.jaiz.jaizmobs.world.ModPlacedFeatures;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.BASALT_DELTAS),
                GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.NETHER_SULFUR_ORE_PLACED_KEY);
    }
}
