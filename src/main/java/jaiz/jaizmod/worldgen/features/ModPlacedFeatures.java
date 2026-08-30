package jaiz.jaizmod.worldgen.features;


import jaiz.jaizmod.JaizMod;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> DESERT_OAK_PLACED_KEY = registerKey("desert_oak_placed");

    public static final ResourceKey<PlacedFeature> SMALL_MAHOGANY_PLACED = registerKey("small_mahogany_tree_placed");
    public static final ResourceKey<PlacedFeature> GUARANA_PATCH = registerKey("guarana_patch_placed");

    public static final ResourceKey<PlacedFeature> ROTTEN_LOG_PLACED = registerKey("rotten_trees");

    public static final ResourceKey<PlacedFeature> WHITE_FLORAL_PLACED = registerKey("white_floral_veil");
    public static final ResourceKey<PlacedFeature> PINK_FLORAL_PLACED = registerKey("pink_floral_veil");
    public static final ResourceKey<PlacedFeature> YELLOW_FLORAL_PLACED = registerKey("yellow_floral_veil");

    public static final ResourceKey<PlacedFeature> AUTUMN_OAK_PLACED = registerKey("autumn_oak_placed");
    public static final ResourceKey<PlacedFeature> AUTUMN_BIRCH_PLACED = registerKey("autumn_birch_placed");

    public static final ResourceKey<PlacedFeature> ROT_RED_MUSHROOM_PLACED = registerKey("red_mushroom_rot_patch_placed");
    public static final ResourceKey<PlacedFeature> ROT_BROWN_MUSHROOM_PLACED = registerKey("brown_mushroom_rot_patch_placed");

    public static final ResourceKey<PlacedFeature> ROT_ROOTS_PLACED = registerKey("rot_roots_patch_placed");

    public static final ResourceKey<PlacedFeature> POO_PLACED = registerKey("poo_patch_placed");
    public static final ResourceKey<PlacedFeature> POO_PLACED_DEEPSLATE = registerKey("deepslate_poo_patch_placed");

    public static final ResourceKey<PlacedFeature> MOSS_PATCH_FRUIT_BAT_CAVES = registerKey("fruitbat_caves_moss_block_patch");
    public static final ResourceKey<PlacedFeature> MOSS_PATCH_FRUIT_BAT_CAVES_DEEPSLATE = registerKey("fruitbat_caves_moss_block_patch_deepslate");

    public static final ResourceKey<PlacedFeature> LEAVES_PATCH_DEEPSLATE = registerKey("leaves_block_patch_deepslate");
    public static final ResourceKey<PlacedFeature> LEAVES_PATCH = registerKey("leaves_block_patch");
    public static final ResourceKey<PlacedFeature> LEAVES_CEILING_PATCH = registerKey("leaves_leaves_block_patch");

    public static final ResourceKey<PlacedFeature> MOSS_CARPET_DEEPSLATE_FRUIT_BAT_CAVES = registerKey("fruitbat_caves_moss_carpet_placed_deepslate");
    public static final ResourceKey<PlacedFeature> MOSS_CARPET_FRUIT_BAT_CAVES = registerKey("fruitbat_caves_moss_carpet_placed");

    public static final ResourceKey<PlacedFeature> PODZOL_PATCH = registerKey("podzol_block_patch");

    public static final ResourceKey<PlacedFeature> MUD_PATCH = registerKey("mud_block_patch");

    public static final ResourceKey<PlacedFeature> BIRCH_LOG_MOSS = registerKey("birch_log_moss_patch_placed");

    public static final ResourceKey<PlacedFeature> BIRCH_FOREST_ROCK = registerKey("birch_forest_rock");
    public static final ResourceKey<PlacedFeature> CALLALILY_PLACED = registerKey("callalily_placed");
    public static final ResourceKey<PlacedFeature> DISK_ROOTED_DIRT = registerKey("disk_rooted_dirt");
    public static final ResourceKey<PlacedFeature> BIRCH_FALLEN_LOG = registerKey("fallen_birch_log_placed");
    public static final ResourceKey<PlacedFeature> DISK_ROT_DIRT = registerKey("disk_rot_dirt");
    public static final ResourceKey<PlacedFeature> FLOWER_COLUMBINE = registerKey("flower_columbine");
    public static final ResourceKey<PlacedFeature> MOSS_PATCH_PLACED = registerKey("moss_patch_placed");
    public static final ResourceKey<PlacedFeature> MOSS_BLOCK_PATCH = registerKey("moss_block_patch");
    public static final ResourceKey<PlacedFeature> UNDERGROWTH_PATCH_PLACED = registerKey("undergrowth_patch_placed");
    public static final ResourceKey<PlacedFeature> LARGE_FERNS_JAIZMOD = registerKey("large_ferns_jaizmod");


    public static void boostrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name));
    }

    public static ResourceKey<PlacedFeature> registerVanillaIDKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.withDefaultNamespace(name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
