package jaiz.jaizmod.datagen;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.item.ModWoodItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    private static ResourceKey<Item> key(Item item) {
        return item.builtInRegistryHolder().key();
    }


    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {

        builder(ItemTags.WOOL)
                .add(key(ModItems.SNIFFER_WOOL))
                .add(key(ModItems.FANCY_WHITE_WOOL))
                .add(key(ModItems.FANCY_LIGHT_GRAY_WOOL))
                .add(key(ModItems.FANCY_GRAY_WOOL))
                .add(key(ModItems.FANCY_BLACK_WOOL))
                .add(key(ModItems.FANCY_BROWN_WOOL))
                .add(key(ModItems.FANCY_RED_WOOL))
                .add(key(ModItems.FANCY_ORANGE_WOOL))
                .add(key(ModItems.FANCY_YELLOW_WOOL))
                .add(key(ModItems.FANCY_LIME_WOOL))
                .add(key(ModItems.FANCY_GREEN_WOOL))
                .add(key(ModItems.FANCY_CYAN_WOOL))
                .add(key(ModItems.FANCY_LIGHT_BLUE_WOOL))
                .add(key(ModItems.FANCY_BLUE_WOOL))
                .add(key(ModItems.FANCY_PURPLE_WOOL))
                .add(key(ModItems.FANCY_MAGENTA_WOOL))
                .add(key(ModItems.FANCY_PINK_WOOL));

        builder(ItemTags.WOOL_CARPETS)
                .add(key(ModItems.FANCY_WHITE_CARPET))
                .add(key(ModItems.SNIFFER_CARPET))
                .add(key(ModItems.FANCY_LIGHT_GRAY_CARPET))
                .add(key(ModItems.FANCY_GRAY_CARPET))
                .add(key(ModItems.FANCY_BLACK_CARPET))
                .add(key(ModItems.FANCY_BROWN_CARPET))
                .add(key(ModItems.FANCY_RED_CARPET))
                .add(key(ModItems.FANCY_ORANGE_CARPET))
                .add(key(ModItems.FANCY_YELLOW_CARPET))
                .add(key(ModItems.FANCY_LIME_CARPET))
                .add(key(ModItems.FANCY_GREEN_CARPET))
                .add(key(ModItems.FANCY_CYAN_CARPET))
                .add(key(ModItems.FANCY_LIGHT_BLUE_CARPET))
                .add(key(ModItems.FANCY_BLUE_CARPET))
                .add(key(ModItems.FANCY_PURPLE_CARPET))
                .add(key(ModItems.FANCY_MAGENTA_CARPET))
                .add(key(ModItems.FANCY_PINK_CARPET));


        builder(ItemTags.AXES)
                .add(key(ModItems.BATTERED_AXE));

        builder(ItemTags.SWORDS)
                .add(key(ModItems.OBSIDIAN_DAGGER))
                .add(key(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD))
                .add(key(ModItems.SHARP_OBSIDIAN_DAGGER))
                .add(key(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD))
                .add(key(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD))
                .add(key(ModItems.WEDGE_OBSIDIAN_DAGGER))
                .add(key(ModItems.WEDGE_OBSIDIAN_SWORD))
                .add(key(ModItems.SHARP_OBSIDIAN_SWORD))
                .add(key(ModItems.MACUAHUITL))
                .add(key(ModItems.OBSIDIAN_SWORD));

        builder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(key(ModItems.OBSIDIAN_DAGGER))
                .add(key(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD))
                .add(key(ModItems.SHARP_OBSIDIAN_DAGGER))
                .add(key(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD))
                .add(key(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD))
                .add(key(ModItems.WEDGE_OBSIDIAN_DAGGER))
                .add(key(ModItems.WEDGE_OBSIDIAN_SWORD))
                .add(key(ModItems.SHARP_OBSIDIAN_SWORD))
                .add(key(ModItems.MACUAHUITL))
                .add(key(ModItems.BATTERED_AXE))
                .add(key(ModItems.OBSIDIAN_SWORD));

        builder(ItemTags.MINING_ENCHANTABLE)
                .add(key(ModItems.BATTERED_AXE));

        builder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(key(ModItems.BATTERED_AXE));

        builder(ItemTags.VANISHING_ENCHANTABLE)
                .add(key(ModItems.OBSIDIAN_DAGGER))
                .add(key(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD))
                .add(key(ModItems.SHARP_OBSIDIAN_DAGGER))
                .add(key(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD))
                .add(key(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD))
                .add(key(ModItems.WEDGE_OBSIDIAN_DAGGER))
                .add(key(ModItems.WEDGE_OBSIDIAN_SWORD))
                .add(key(ModItems.SHARP_OBSIDIAN_SWORD))
                .add(key(ModItems.MACUAHUITL))
                .add(key(ModItems.AIR_HORN))
                .add(key(ModItems.GLOWING_SPYGLASS))
                .add(key(ModItems.AMETHYST_HORN))
                .add(key(ModItems.ANCIENT_HORN))
                .add(key(ModItems.BATTERED_AXE))
                .add(key(ModItems.OBSIDIAN_SWORD));

        builder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(key(ModItems.OBSIDIAN_DAGGER))
                .add(key(ModItems.GLOWING_SPYGLASS))
                .add(key(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD))
                .add(key(ModItems.SHARP_OBSIDIAN_DAGGER))
                .add(key(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD))
                .add(key(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD))
                .add(key(ModItems.WEDGE_OBSIDIAN_DAGGER))
                .add(key(ModItems.WEDGE_OBSIDIAN_SWORD))
                .add(key(ModItems.SHARP_OBSIDIAN_SWORD))
                .add(key(ModItems.MACUAHUITL))
                .add(key(ModItems.AIR_HORN))
                .add(key(ModItems.AMETHYST_HORN))
                .add(key(ModItems.ANCIENT_HORN))
                .add(key(ModItems.BATTERED_AXE))
                .add(key(ModItems.OBSIDIAN_SWORD));

        builder(BlockItemTags.FENCES.item())
                .add(key(ModItems.ROTTEN_FENCE))
                .add(key(ModItems.DESERT_OAK_FENCE))
                .add(key(ModItems.MAHOGANY_FENCE));

        builder(ItemTags.WALLS)
                .add(key(ModItems.TERRACOTTA_BRICK_WALL));

        builder(ItemTags.STONE_BRICKS)
                .add(key(ModItems.TERRACOTTA_BRICKS));

        builder(ItemTags.LOGS_THAT_BURN)
                .add(key(ModItems.MAHOGANY_LOG))
                .add(key(ModItems.MAHOGANY_WOOD))
                .add(key(ModItems.STRIPPED_MAHOGANY_LOG))
                .add(key(ModItems.STRIPPED_MAHOGANY_WOOD))
                .add(key(ModItems.ROTTEN_LOG))
                .add(key(ModItems.ROTTEN_WOOD))
                .add(key(ModItems.STRIPPED_ROTTEN_LOG))
                .add(key(ModItems.STRIPPED_ROTTEN_WOOD))
                .add(key(ModItems.DESERT_OAK_LOG))
                .add(key(ModItems.DESERT_OAK_WOOD))
                .add(key(ModItems.STRIPPED_DESERT_OAK_LOG))
                .add(key(ModItems.STRIPPED_DESERT_OAK_WOOD));

        builder(ItemTags.PLANKS)
                .add(key(ModItems.ROTTEN_PLANKS))
                .add(key(ModItems.DESERT_OAK_PLANKS))
                .add(key(ModItems.MAHOGANY_PLANKS));

        builder(ItemTags.DIRT)
                .add(key(ModItems.PETRIFIED_DIRT))
                .add(key(ModItems.ROT_BLOCK));

        builder(ItemTags.FENCE_GATES)
                .add(key(ModItems.DESERT_OAK_FENCE_GATE))
                .add(key(ModItems.MAHOGANY_FENCE_GATE))
                .add(key(ModItems.ROTTEN_FENCE_GATE));

        builder(ItemTags.WOODEN_SLABS)
                .add(key(ModItems.DESERT_OAK_SLAB))
                .add(key(ModItems.ROTTEN_SLAB))
                .add(key(ModItems.MAHOGANY_SLAB));

        builder(ItemTags.WOODEN_BUTTONS)
                .add(key(ModItems.DESERT_OAK_BUTTON))
                .add(key(ModItems.MAHOGANY_BUTTON))
                .add(key(ModItems.ROTTEN_BUTTON));

        builder(ItemTags.BEE_FOOD)
                .add(key(ModItems.CALLALILY_LILAC))
                .add(key(ModItems.CALLALILY_YELLOW))
                .add(key(ModItems.CALLALILY_PURPLE))
                .add(key(ModItems.CALLALILY_WHITE))
                .add(key(ModItems.CALLALILY_PINK))
                .add(key(ModItems.PINK_FLORAL_VEIL))
                .add(key(ModItems.WHITE_FLORAL_VEIL))
                .add(key(ModItems.YELLOW_FLORAL_VEIL))
                .add(key(ModItems.COLUMBINE));


        builder(ItemTags.WOODEN_STAIRS)
                .add(key(ModItems.DESERT_OAK_STAIRS))
                .add(key(ModItems.ROTTEN_STAIRS))
                .add(key(ModItems.MAHOGANY_STAIRS));

        builder(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(key(ModItems.DESERT_OAK_PRESSURE_PLATE))
                .add(key(ModItems.ROTTEN_PRESSURE_PLATE))
                .add(key(ModItems.MAHOGANY_PRESSURE_PLATE));

        builder(ItemTags.WOODEN_FENCES)
                .add(key(ModItems.ROTTEN_FENCE))
                .add(key(ModItems.DESERT_OAK_FENCE))
                .add(key(ModItems.MAHOGANY_FENCE));

        builder(ItemTags.WOODEN_DOORS)
                .add(key(ModItems.DESERT_OAK_DOOR))
                .add(key(ModItems.ROTTEN_DOOR))
                .add(key(ModItems.MAHOGANY_DOOR));

        builder(ItemTags.WOODEN_TRAPDOORS)
                .add(key(ModItems.DESERT_OAK_TRAPDOOR))
                .add(key(ModItems.ROTTEN_TRAPDOOR))
                .add(key(ModItems.MAHOGANY_TRAPDOOR));

        builder(ItemTags.LEAVES)
                .add(key(ModItems.DESERT_OAK_LEAVES))
                .add(key(ModItems.DEAD_LEAVES))
                .add(key(ModItems.DRIED_LEAVES))
                .add(key(ModItems.SNOWY_LEAVES))
                .add(key(ModItems.MAHOGANY_LEAVES));

        builder(ItemTags.SAPLINGS)
                .add(key(ModItems.DESERT_OAK_SAPLING))
                .add(key(ModItems.MAHOGANY_SAPLING));

        builder(BlockItemTags.SMALL_FLOWERS.item())
                .add(key(ModItems.COLUMBINE))
                .add(key(ModItems.PINK_FLORAL_VEIL))
                .add(key(ModItems.WHITE_FLORAL_VEIL))
                .add(key(ModItems.YELLOW_FLORAL_VEIL))
                .add(key(ModItems.ANCIENT_SPROUT));

        builder(ItemTags.SNIFFER_FOOD)
                .add(key(ModItems.BLOOMING_IVY))
                .add(key(Items.SMALL_DRIPLEAF))
                .add(key(Items.TORCHFLOWER))
                .add(key(Items.PITCHER_POD))
                .add(key(Items.PITCHER_PLANT))
                .add(key(ModItems.ANCIENT_SPROUT));

        for (ModWoodItems.WoodItems wood : ModWoodItems.ALL) {
            builder(ItemTags.LOGS_THAT_BURN)
                    .add(key(wood.log()))
                    .add(key(wood.wood()))
                    .add(key(wood.strippedLog()))
                    .add(key(wood.strippedWood()));
            builder(ItemTags.PLANKS).add(key(wood.planks()));
            builder(BlockItemTags.FENCES.item()).add(key(wood.fence()));
            builder(ItemTags.FENCE_GATES).add(key(wood.fenceGate()));
            builder(ItemTags.WOODEN_SLABS).add(key(wood.slab()));
            builder(ItemTags.WOODEN_BUTTONS).add(key(wood.button()));
            builder(ItemTags.WOODEN_STAIRS).add(key(wood.stairs()));
            builder(ItemTags.WOODEN_PRESSURE_PLATES).add(key(wood.pressurePlate()));
            builder(ItemTags.WOODEN_FENCES).add(key(wood.fence()));
            builder(ItemTags.WOODEN_DOORS).add(key(wood.door()));
            builder(ItemTags.WOODEN_TRAPDOORS).add(key(wood.trapdoor()));
            builder(ItemTags.LEAVES).add(key(wood.leaves()));
            builder(ItemTags.SAPLINGS).add(key(wood.sapling()));
        }

    }


}
