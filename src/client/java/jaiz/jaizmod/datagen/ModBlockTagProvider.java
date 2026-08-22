package jaiz.jaizmod.datagen;

import jaiz.jaizmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    private static ResourceKey<Block> key(Block block) {
        return block.builtInRegistryHolder().key();
    }

    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

        builder(BlockTags.WOOL)
                .add(key(ModBlocks.SNIFFER_WOOL))
                .add(key(ModBlocks.FANCY_WHITE_WOOL))
                .add(key(ModBlocks.FANCY_LIGHT_GRAY_WOOL))
                .add(key(ModBlocks.FANCY_GRAY_WOOL))
                .add(key(ModBlocks.FANCY_BLACK_WOOL))
                .add(key(ModBlocks.FANCY_BROWN_WOOL))
                .add(key(ModBlocks.FANCY_RED_WOOL))
                .add(key(ModBlocks.FANCY_ORANGE_WOOL))
                .add(key(ModBlocks.FANCY_YELLOW_WOOL))
                .add(key(ModBlocks.FANCY_LIME_WOOL))
                .add(key(ModBlocks.FANCY_GREEN_WOOL))
                .add(key(ModBlocks.FANCY_CYAN_WOOL))
                .add(key(ModBlocks.FANCY_LIGHT_BLUE_WOOL))
                .add(key(ModBlocks.FANCY_BLUE_WOOL))
                .add(key(ModBlocks.FANCY_PURPLE_WOOL))
                .add(key(ModBlocks.FANCY_MAGENTA_WOOL))
                .add(key(ModBlocks.FANCY_PINK_WOOL));

        builder(BlockTags.WOOL_CARPETS)
                .add(key(ModBlocks.FANCY_WHITE_CARPET))
                .add(key(ModBlocks.SNIFFER_CARPET))
                .add(key(ModBlocks.FANCY_LIGHT_GRAY_CARPET))
                .add(key(ModBlocks.FANCY_GRAY_CARPET))
                .add(key(ModBlocks.FANCY_BLACK_CARPET))
                .add(key(ModBlocks.FANCY_BROWN_CARPET))
                .add(key(ModBlocks.FANCY_RED_CARPET))
                .add(key(ModBlocks.FANCY_ORANGE_CARPET))
                .add(key(ModBlocks.FANCY_YELLOW_CARPET))
                .add(key(ModBlocks.FANCY_LIME_CARPET))
                .add(key(ModBlocks.FANCY_GREEN_CARPET))
                .add(key(ModBlocks.FANCY_CYAN_CARPET))
                .add(key(ModBlocks.FANCY_LIGHT_BLUE_CARPET))
                .add(key(ModBlocks.FANCY_BLUE_CARPET))
                .add(key(ModBlocks.FANCY_PURPLE_CARPET))
                .add(key(ModBlocks.FANCY_MAGENTA_CARPET))
                .add(key(ModBlocks.FANCY_PINK_CARPET));

        builder(BlockTags.PLANKS)
                .add(key(ModBlocks.DESERT_OAK_PLANKS))
                .add(key(ModBlocks.MAHOGANY_PLANKS))
                .add(key(ModBlocks.ROTTEN_PLANKS));

        builder(BlockItemTags.LOGS_THAT_BURN.block())
                .add(key(ModBlocks.DESERT_OAK_LOG))
                .add(key(ModBlocks.DESERT_OAK_WOOD))
                .add(key(ModBlocks.STRIPPED_DESERT_OAK_LOG))
                .add(key(ModBlocks.STRIPPED_DESERT_OAK_WOOD))
                .add(key(ModBlocks.MAHOGANY_LOG))
                .add(key(ModBlocks.MAHOGANY_WOOD))
                .add(key(ModBlocks.STRIPPED_MAHOGANY_LOG))
                .add(key(ModBlocks.STRIPPED_MAHOGANY_WOOD))
                .add(key(ModBlocks.ROTTEN_LOG))
                .add(key(ModBlocks.ROTTEN_WOOD))
                .add(key(ModBlocks.STRIPPED_ROTTEN_LOG))
                .add(key(ModBlocks.STRIPPED_ROTTEN_WOOD));

        builder(BlockTags.FENCES)
                .add(key(ModBlocks.DESERT_OAK_FENCE))
                .add(key(ModBlocks.ROTTEN_FENCE))
                .add(key(ModBlocks.MAHOGANY_FENCE));


        builder(BlockTags.DIRT)
                .add(key(ModBlocks.FOSSIL_SOIL))
                .add(key(Blocks.SAND))
                .add(key(Blocks.GRAVEL))
                .add(key(Blocks.RED_SAND))
                .add(key(ModBlocks.PETRIFIED_DIRT))
                .add(key(ModBlocks.ROT_BLOCK));

        builder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(key(ModBlocks.FOSSIL_SOIL))
                .add(key(ModBlocks.GUANO_BLOCK))
                .add(key(ModBlocks.PETRIFIED_DIRT))
                .add(key(ModBlocks.ROT_BLOCK));

        builder(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(key(ModBlocks.FOSSIL_SOIL))
                .add(key(ModBlocks.PETRIFIED_DIRT));

        builder(BlockTags.WALLS)
                .add(key(ModBlocks.GUANO_BRICK_WALL))
                .add(key(ModBlocks.TERRACOTTA_BRICK_WALL));


        builder(BlockTags.FENCE_GATES)
                .add(key(ModBlocks.DESERT_OAK_FENCE_GATE))
                .add(key(ModBlocks.MAHOGANY_FENCE_GATE))
                .add(key(ModBlocks.ROTTEN_FENCE_GATE));

        builder(BlockTags.LEAVES)
                .add(key(ModBlocks.DESERT_OAK_LEAVES))
                .add(key(ModBlocks.DRIED_LEAVES))
                .add(key(ModBlocks.DEAD_LEAVES))
                .add(key(ModBlocks.SNOWY_LEAVES))
                .add(key(ModBlocks.MAHOGANY_LEAVES));


        builder(BlockTags.WOODEN_SLABS)
                .add(key(ModBlocks.DESERT_OAK_SLAB))
                .add(key(ModBlocks.ROTTEN_SLAB))
                .add(key(ModBlocks.MAHOGANY_SLAB));

        builder(BlockTags.SLABS)
                .add(key(ModBlocks.DESERT_OAK_SLAB))
                .add(key(ModBlocks.TERRACOTTA_BRICK_SLAB))
                .add(key(ModBlocks.GUANO_BRICK_SLAB))
                .add(key(ModBlocks.ROTTEN_SLAB))
                .add(key(ModBlocks.MAHOGANY_SLAB));

        builder(BlockTags.WOODEN_BUTTONS)
                .add(key(ModBlocks.DESERT_OAK_BUTTON))
                .add(key(ModBlocks.MAHOGANY_BUTTON))
                .add(key(ModBlocks.ROTTEN_BUTTON));


        builder(BlockTags.WOODEN_STAIRS)
                .add(key(ModBlocks.DESERT_OAK_STAIRS))
                .add(key(ModBlocks.ROTTEN_STAIRS))
                .add(key(ModBlocks.MAHOGANY_STAIRS));

        builder(BlockTags.STAIRS)
                .add(key(ModBlocks.DESERT_OAK_STAIRS))
                .add(key(ModBlocks.TERRACOTTA_BRICK_STAIRS))
                .add(key(ModBlocks.GUANO_BRICK_STAIRS))
                .add(key(ModBlocks.ROTTEN_STAIRS))
                .add(key(ModBlocks.MAHOGANY_STAIRS));

        builder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(key(ModBlocks.DESERT_OAK_PRESSURE_PLATE))
                .add(key(ModBlocks.ROTTEN_PRESSURE_PLATE))
                .add(key(ModBlocks.MAHOGANY_PRESSURE_PLATE));

        builder(BlockTags.WOODEN_FENCES)
                .add(key(ModBlocks.DESERT_OAK_FENCE))
                .add(key(ModBlocks.ROTTEN_FENCE))
                .add(key(ModBlocks.MAHOGANY_FENCE));

        builder(BlockTags.WOODEN_DOORS)
                .add(key(ModBlocks.DESERT_OAK_DOOR))
                .add(key(ModBlocks.DESERT_OAK_TRAPDOOR))
                .add(key(ModBlocks.ROTTEN_DOOR))
                .add(key(ModBlocks.ROTTEN_TRAPDOOR))
                .add(key(ModBlocks.MAHOGANY_DOOR))
                .add(key(ModBlocks.MAHOGANY_TRAPDOOR));


        builder(BlockItemTags.SAPLINGS.block())
                .add(key(ModBlocks.MAHOGANY_SAPLING))
                .add(key(ModBlocks.DESERT_OAK_SAPLING));

        builder(BlockTags.OVERRIDES_MUSHROOM_LIGHT_REQUIREMENT)
                .add(key(ModBlocks.ROT_BLOCK))
                .add(key(ModBlocks.ROTTEN_LOG))
                .add(key(Blocks.BIRCH_LOG))
                .add(key(Blocks.OAK_LOG))
                .add(key(ModBlocks.ROTTEN_WOOD))
                .add(key(ModBlocks.STRIPPED_ROTTEN_LOG))
                .add(key(ModBlocks.STRIPPED_ROTTEN_WOOD));

        builder(BlockTags.MINEABLE_WITH_PICKAXE)

                .add(key(ModBlocks.PACKED_GUANO))
                .add(key(ModBlocks.GUANO_BRICK_WALL))
                .add(key(ModBlocks.GUANO_BRICK_STAIRS))
                .add(key(ModBlocks.GUANO_BRICK_SLAB))
                .add(key(ModBlocks.GUANO_BRICKS))
                .add(key(ModBlocks.TERRACOTTA_BRICK_WALL))
                .add(key(ModBlocks.TERRACOTTA_BRICK_STAIRS))
                .add(key(ModBlocks.TERRACOTTA_BRICKS))
                .add(key(ModBlocks.GILDED_CHISELED_SANDSTONE))
                .add(key(ModBlocks.GILDED_SANDSTONE))
                .add(key(ModBlocks.GILDED_CUT_SANDSTONE))
                .add(key(ModBlocks.CHISELED_PLATED_CALCITE))
                .add(key(ModBlocks.PLATED_CALCITE))
                .add(key(ModBlocks.TERRACOTTA_BRICK_SLAB));

        builder(BlockTags.MINEABLE_WITH_HOE)
                .add(key(ModBlocks.DESERT_OAK_LEAVES))
                .add(key(ModBlocks.BLOOMING_IVY_BLOCK))
                .add(key(ModBlocks.DEAD_LEAVES))
                .add(key(ModBlocks.DRIED_LEAVES))
                .add(key(ModBlocks.MAHOGANY_LEAVES));

        builder(BlockTags.MINEABLE_WITH_AXE)
                .add(key(ModBlocks.ROTTEN_PLANKS))
                .add(key(ModBlocks.ROTTEN_DOOR))
                .add(key(ModBlocks.ROTTEN_TRAPDOOR))
                .add(key(ModBlocks.ROTTEN_FENCE))
                .add(key(ModBlocks.ROTTEN_FENCE_GATE))
                .add(key(ModBlocks.ROTTEN_SLAB))
                .add(key(ModBlocks.ROTTEN_STAIRS))
                .add(key(ModBlocks.WALL_ROTTEN_SIGN))
                .add(key(ModBlocks.STANDING_ROTTEN_SIGN))
                .add(key(ModBlocks.HANGING_ROTTEN_SIGN))
                .add(key(ModBlocks.WALL_HANGING_ROTTEN_SIGN))
                .add(key(ModBlocks.ROTTEN_LOG))
                .add(key(ModBlocks.ROTTEN_WOOD))
                .add(key(ModBlocks.STRIPPED_ROTTEN_LOG))
                .add(key(ModBlocks.STRIPPED_ROTTEN_WOOD))
                .add(key(ModBlocks.SHELF_MUSHROOM_BLOCK))
                .add(key(ModBlocks.MAHOGANY_LOG))
                .add(key(ModBlocks.STRIPPED_MAHOGANY_LOG))
                .add(key(ModBlocks.MAHOGANY_STAIRS))
                .add(key(ModBlocks.MAHOGANY_FENCE))
                .add(key(ModBlocks.MAHOGANY_FENCE_GATE))
                .add(key(ModBlocks.MAHOGANY_BUTTON))
                .add(key(ModBlocks.MAHOGANY_PLANKS))
                .add(key(ModBlocks.MAHOGANY_SLAB))
                .add(key(ModBlocks.MAHOGANY_STAIRS))
                .add(key(ModBlocks.MAHOGANY_WOOD))
                .add(key(ModBlocks.STRIPPED_MAHOGANY_WOOD))
                .add(key(ModBlocks.MAHOGANY_DOOR))
                .add(key(ModBlocks.MAHOGANY_PRESSURE_PLATE))
                .add(key(ModBlocks.MAHOGANY_TRAPDOOR))
                .add(key(ModBlocks.HANGING_MAHOGANY_SIGN))
                .add(key(ModBlocks.WALL_HANGING_MAHOGANY_SIGN))
                .add(key(ModBlocks.WALL_MAHOGANY_SIGN))
                .add(key(ModBlocks.STANDING_DESERT_OAK_SIGN))
                .add(key(ModBlocks.DESERT_OAK_LOG))
                .add(key(ModBlocks.STRIPPED_DESERT_OAK_LOG))
                .add(key(ModBlocks.DESERT_OAK_STAIRS))
                .add(key(ModBlocks.DESERT_OAK_FENCE))
                .add(key(ModBlocks.DESERT_OAK_FENCE_GATE))
                .add(key(ModBlocks.DESERT_OAK_BUTTON))
                .add(key(ModBlocks.DESERT_OAK_PLANKS))
                .add(key(ModBlocks.DESERT_OAK_SLAB))
                .add(key(ModBlocks.DESERT_OAK_STAIRS))
                .add(key(ModBlocks.DESERT_OAK_WOOD))
                .add(key(ModBlocks.STRIPPED_DESERT_OAK_WOOD))
                .add(key(ModBlocks.DESERT_OAK_DOOR))
                .add(key(ModBlocks.DESERT_OAK_PRESSURE_PLATE))
                .add(key(ModBlocks.DESERT_OAK_TRAPDOOR))
                .add(key(ModBlocks.HANGING_DESERT_OAK_SIGN))
                .add(key(ModBlocks.WALL_HANGING_DESERT_OAK_SIGN))
                .add(key(ModBlocks.WALL_DESERT_OAK_SIGN))
                .add(key(ModBlocks.SPICE_BARREL))
                .add(key(ModBlocks.STANDING_DESERT_OAK_SIGN));


        builder(BlockTags.SMALL_FLOWERS)
                .add(key(ModBlocks.ANCIENT_SPROUT))
                .add(key(ModBlocks.PINK_FLORAL_VEIL))
                .add(key(ModBlocks.WHITE_FLORAL_VEIL))
                .add(key(ModBlocks.YELLOW_FLORAL_VEIL))
                .add(key(ModBlocks.COLUMBINE));

        builder(BlockTags.BEE_ATTRACTIVE)
                .add(key(ModBlocks.CALLALILY_LILAC))
                .add(key(ModBlocks.PINK_FLORAL_VEIL))
                .add(key(ModBlocks.WHITE_FLORAL_VEIL))
                .add(key(ModBlocks.YELLOW_FLORAL_VEIL))
                .add(key(ModBlocks.CALLALILY_YELLOW))
                .add(key(ModBlocks.CALLALILY_PURPLE))
                .add(key(ModBlocks.CALLALILY_WHITE))
                .add(key(ModBlocks.CALLALILY_PINK))
                .add(key(ModBlocks.BLOOMING_IVY))
                .add(key(ModBlocks.COLUMBINE));

        builder(BlockTags.REPLACEABLE)
                .add(key(ModBlocks.COLUMBINE))
                .add(key(ModBlocks.BLOOMING_IVY))
                .add(key(ModBlocks.PINK_FLORAL_VEIL))
                .add(key(ModBlocks.WHITE_FLORAL_VEIL))
                .add(key(ModBlocks.YELLOW_FLORAL_VEIL))
                .add(key(ModBlocks.CALLALILY_LILAC))
                .add(key(ModBlocks.CALLALILY_YELLOW))
                .add(key(ModBlocks.CALLALILY_PURPLE))
                .add(key(ModBlocks.CALLALILY_WHITE))
                .add(key(ModBlocks.CALLALILY_PINK))
                .add(key(ModBlocks.SHELF_MUSHROOM_BLOCK))
                .add(key(ModBlocks.IVY))
                .add(key(ModBlocks.ROT_ROOTS))
                .add(key(ModBlocks.UNDERGROWTH));

        builder(BlockTags.REPLACEABLE_BY_TREES)
                .add(key(ModBlocks.SHELF_MUSHROOM_BLOCK))
                .add(key(ModBlocks.IVY))
                .add(key(ModBlocks.PINK_FLORAL_VEIL))
                .add(key(ModBlocks.WHITE_FLORAL_VEIL))
                .add(key(ModBlocks.YELLOW_FLORAL_VEIL))
                .add(key(ModBlocks.BLOOMING_IVY))
                .add(key(ModBlocks.ROT_ROOTS))
                .add(key(ModBlocks.UNDERGROWTH));


    }
}
