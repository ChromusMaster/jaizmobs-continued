package jaiz.jaizmod.util;

import jaiz.jaizmod.JaizMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> ROTTABLE_LEAVES =
                createTag("rottable_leaves");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> SNIFFER_CHERRY =
                createTag("sniffer_cherry");
        public static final TagKey<Biome> SNIFFER_MOSSY =
                createTag("sniffer_mossy");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> BATTERED_REPARABLE =
                createTag("battered_reparable");
        public static final TagKey<Item> MASON_MOUTH_TRANSFORMABLE =
                createTag("mason_mouth_transformable");
        public static final TagKey<Item> TEA_INGREDIENT =
                createTag("tea_ingredient");
        public static final TagKey<Item> TEA_FLOWERS =
                createTag("tea_flowers");
        public static final TagKey<Item> OBSIDIAN_SHARDS =
                createTag("obsidian_shards");



        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name));
        }
    }
}
