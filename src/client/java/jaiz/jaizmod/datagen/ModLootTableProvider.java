package jaiz.jaizmod.datagen;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {


    public ModLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        dropSelf(ModBlocks.HANGING_DESERT_OAK_SIGN);
        dropSelf(ModBlocks.WALL_HANGING_DESERT_OAK_SIGN);
        dropSelf(ModBlocks.STANDING_DESERT_OAK_SIGN);
        dropSelf(ModBlocks.WALL_DESERT_OAK_SIGN);
        dropSelf(ModBlocks.HANGING_MAHOGANY_SIGN);
        dropSelf(ModBlocks.WALL_HANGING_MAHOGANY_SIGN);
        dropSelf(ModBlocks.STANDING_MAHOGANY_SIGN);
        dropSelf(ModBlocks.WALL_MAHOGANY_SIGN);
        dropSelf(ModBlocks.HANGING_ROTTEN_SIGN);
        dropSelf(ModBlocks.WALL_HANGING_ROTTEN_SIGN);
        dropSelf(ModBlocks.STANDING_ROTTEN_SIGN);
        dropSelf(ModBlocks.WALL_ROTTEN_SIGN);

        dropSelf(ModBlocks.AUTUMN_SAPLING);
        dropSelf(ModBlocks.FANCY_WHITE_WOOL);
        dropSelf(ModBlocks.FANCY_LIGHT_GRAY_WOOL);
        dropSelf(ModBlocks.FANCY_GRAY_WOOL);
        dropSelf(ModBlocks.FANCY_BLACK_WOOL);
        dropSelf(ModBlocks.FANCY_BROWN_WOOL);
        dropSelf(ModBlocks.FANCY_ORANGE_WOOL);
        dropSelf(ModBlocks.FANCY_RED_WOOL);
        dropSelf(ModBlocks.FANCY_YELLOW_WOOL);
        dropSelf(ModBlocks.FANCY_LIME_WOOL);
        dropSelf(ModBlocks.FANCY_GREEN_WOOL);
        dropSelf(ModBlocks.FANCY_CYAN_WOOL);
        dropSelf(ModBlocks.FANCY_LIGHT_BLUE_WOOL);
        dropSelf(ModBlocks.FANCY_BLUE_WOOL);
        dropSelf(ModBlocks.FANCY_PURPLE_WOOL);
        dropSelf(ModBlocks.FANCY_MAGENTA_WOOL);
        dropSelf(ModBlocks.FANCY_PINK_WOOL);

        dropSelf(ModBlocks.BIOLUMINESCENT_BOTTLE);

        dropSelf(ModBlocks.BLOOMING_IVY_BLOCK);

        dropSelf(ModBlocks.GILDED_CHISELED_SANDSTONE);
        dropSelf(ModBlocks.GILDED_CUT_SANDSTONE);
        dropSelf(ModBlocks.GILDED_SANDSTONE);

        dropSelf(ModBlocks.DESERT_OAK_WOOD);
        dropSelf(ModBlocks.STRIPPED_DESERT_OAK_WOOD);
        dropSelf(ModBlocks.DESERT_OAK_LOG);
        dropSelf(ModBlocks.STRIPPED_DESERT_OAK_LOG);
        dropSelf(ModBlocks.DESERT_OAK_PLANKS);

        add(ModBlocks.DESERT_OAK_DOOR, createDoorTable(ModBlocks.DESERT_OAK_DOOR));
        add(ModBlocks.DESERT_OAK_SLAB, createSlabItemTable(ModBlocks.DESERT_OAK_SLAB));
        dropSelf(ModBlocks.DESERT_OAK_TRAPDOOR);
        dropSelf(ModBlocks.DESERT_OAK_FENCE);
        dropSelf(ModBlocks.DESERT_OAK_STAIRS);
        dropSelf(ModBlocks.DESERT_OAK_FENCE_GATE);
        dropSelf(ModBlocks.DESERT_OAK_SAPLING);
        dropSelf(ModBlocks.DESERT_OAK_BUTTON);
        dropSelf(ModBlocks.DESERT_OAK_PRESSURE_PLATE);

        dropSelf(ModBlocks.PETRIFIED_DIRT);
        dropSelf(ModBlocks.TERRACOTTA_BRICKS);

        dropSelf(ModBlocks.TERRACOTTA_BRICK_WALL);
        add(ModBlocks.TERRACOTTA_BRICK_SLAB, createSlabItemTable(ModBlocks.TERRACOTTA_BRICK_SLAB));
        dropSelf(ModBlocks.TERRACOTTA_BRICK_STAIRS);

        dropSelf(ModBlocks.PACKED_GUANO);
        dropSelf(ModBlocks.GUANO_BRICKS);
        dropSelf(ModBlocks.GUANO_BRICK_WALL);
        add(ModBlocks.GUANO_BRICK_SLAB, createSlabItemTable(ModBlocks.GUANO_BRICK_SLAB));
        dropSelf(ModBlocks.GUANO_BRICK_STAIRS);

        add(ModBlocks.DESERT_OAK_LEAVES, createLeavesDrops(ModBlocks.DESERT_OAK_LEAVES, ModBlocks.DESERT_OAK_SAPLING, 0.2f));
        add(ModBlocks.SNOWY_LEAVES, createLeavesDrops(ModBlocks.SNOWY_LEAVES, Blocks.SPRUCE_SAPLING, 0.1f));

        dropSelf(ModBlocks.MAHOGANY_WOOD);
        dropSelf(ModBlocks.STRIPPED_MAHOGANY_WOOD);
        dropSelf(ModBlocks.MAHOGANY_LOG);
        dropSelf(ModBlocks.STRIPPED_MAHOGANY_LOG);
        dropSelf(ModBlocks.MAHOGANY_PLANKS);

        add(ModBlocks.MAHOGANY_DOOR, createDoorTable(ModBlocks.MAHOGANY_DOOR));
        add(ModBlocks.MAHOGANY_SLAB, createSlabItemTable(ModBlocks.MAHOGANY_SLAB));
        dropSelf(ModBlocks.MAHOGANY_TRAPDOOR);
        dropSelf(ModBlocks.MAHOGANY_FENCE);
        dropSelf(ModBlocks.MAHOGANY_STAIRS);
        dropSelf(ModBlocks.MAHOGANY_FENCE_GATE);
        dropSelf(ModBlocks.MAHOGANY_BUTTON);
        dropSelf(ModBlocks.MAHOGANY_PRESSURE_PLATE);

        dropSelf(ModBlocks.CHISELED_PLATED_CALCITE);
        dropSelf(ModBlocks.PLATED_CALCITE);
        dropSelf(ModBlocks.MAHOGANY_SAPLING);
        dropSelf(ModBlocks.GUANO_BLOCK);

        dropOther(ModBlocks.GUANO_PILE, ModItems.GUANO);
        this.add(ModBlocks.SLIME_DRIP, block -> this.createOreDrop(block, Items.SLIME_BALL));

        dropOther(ModBlocks.WATER_TORCH, ModItems.WATER_TORCH);
        dropOther(ModBlocks.WALL_WATER_TORCH, ModItems.WATER_TORCH);

        add(ModBlocks.WHITE_FLORAL_VEIL, createMultifaceBlockDrops(ModBlocks.WHITE_FLORAL_VEIL));
        add(ModBlocks.FROST, createMultifaceBlockDrops(ModBlocks.FROST));
        add(ModBlocks.PINK_FLORAL_VEIL, createMultifaceBlockDrops(ModBlocks.PINK_FLORAL_VEIL));
        add(ModBlocks.YELLOW_FLORAL_VEIL, createMultifaceBlockDrops(ModBlocks.YELLOW_FLORAL_VEIL));

        add(ModBlocks.MAHOGANY_LEAVES, createLeavesDrops(ModBlocks.MAHOGANY_LEAVES, ModBlocks.MAHOGANY_SAPLING, 0.1f));

        add(ModBlocks.DRIED_LEAVES, createLeavesDrops(ModBlocks.DRIED_LEAVES, ModBlocks.AUTUMN_SAPLING, 0.1f));
        add(ModBlocks.DEAD_LEAVES, createLeavesDrops(ModBlocks.DEAD_LEAVES, Blocks.DEAD_BUSH, 0.1f));

        dropSelf(ModBlocks.SNIFFER_WOOL);
        dropSelf(ModBlocks.SNIFFER_CARPET);
        dropSelf(ModBlocks.SHELF_MUSHROOM_BLOCK);
        dropSelf(ModBlocks.COLUMBINE);
        dropSelf(ModBlocks.BLOOMING_IVY);
        dropSelf(ModBlocks.ANCIENT_SPROUT);
        LootItemCondition.Builder ancient_sprout_builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ANCIENT_SPROUT_CROP)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(ModBlocks.ANCIENT_SPROUT_CROP, createCropDrops(ModBlocks.ANCIENT_SPROUT_CROP, ModItems.ANCIENT_SPROUT, ModItems.ANCIENT_SPROUT_SEEDS, ancient_sprout_builder));

        LootItemCondition.Builder blooming_ivy_builder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLOOMING_IVY_CROP)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(ModBlocks.BLOOMING_IVY_CROP, createCropDrops(ModBlocks.BLOOMING_IVY_CROP, ModItems.BLOOMING_IVY, ModItems.BLOOMING_IVY_SEEDS, blooming_ivy_builder));


        dropSelf(ModBlocks.ROTTEN_WOOD);
        dropSelf(ModBlocks.STRIPPED_ROTTEN_WOOD);
        dropSelf(ModBlocks.ROTTEN_LOG);
        dropSelf(ModBlocks.STRIPPED_ROTTEN_LOG);
        dropSelf(ModBlocks.ROTTEN_PLANKS);
        dropSelf(ModBlocks.ROTTEN_BUTTON);
        dropSelf(ModBlocks.ROTTEN_PRESSURE_PLATE);
        dropSelf(ModBlocks.ROT_BLOCK);

        add(ModBlocks.IVY, createGrassDrops(ModBlocks.IVY));
        add(ModBlocks.UNDERGROWTH, createGrassDrops(ModBlocks.UNDERGROWTH));
        add(ModBlocks.ROT_ROOTS, createGrassDrops(ModBlocks.ROT_ROOTS));

        add(ModBlocks.ROTTEN_DOOR, createDoorTable(ModBlocks.ROTTEN_DOOR));
        add(ModBlocks.ROTTEN_SLAB, createSlabItemTable(ModBlocks.ROTTEN_SLAB));
        dropSelf(ModBlocks.ROTTEN_TRAPDOOR);
        dropSelf(ModBlocks.ROTTEN_FENCE);
        dropSelf(ModBlocks.ROTTEN_STAIRS);
        dropSelf(ModBlocks.ROTTEN_FENCE_GATE);
    }
}
