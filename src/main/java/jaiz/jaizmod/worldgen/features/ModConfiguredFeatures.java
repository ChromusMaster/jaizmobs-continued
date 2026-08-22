package jaiz.jaizmod.worldgen.features;

import jaiz.jaizmod.JaizMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> DESERT_OAK_KEY = registerKey("desert_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> AUTUMN_TREE = registerKey("autumn_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAHOGANY_TREE = registerKey("mahogany_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_MAHOGANY_TREE = registerKey("mahogany_tree_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ROT_DIRT = registerKey("disk_rot_dirt");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ROT_ROOTS = registerKey("rot_roots_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COLUMBINE_PATCH = registerKey("flower_columbine");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM = registerKey("brown_mushroom_rot_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MUSHROOM = registerKey("mushroom_rot_patch");
    public static void boostrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                   ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
