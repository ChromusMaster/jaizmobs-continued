package jaiz.jaizmod;

import jaiz.jaizmod.datagen.*;
import jaiz.jaizmod.trim.ModTrimPatterns;
import jaiz.jaizmod.worldgen.features.ModConfiguredFeatures;
import jaiz.jaizmod.worldgen.features.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class JaizModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider.Provider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModWorldGenerator::new);
		pack.addProvider(ModPoiTagProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);

	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
		registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::boostrap);
		registryBuilder.add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap);
	}

}
