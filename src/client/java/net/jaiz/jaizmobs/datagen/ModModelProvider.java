package net.jaiz.jaizmobs.datagen;

import java.util.List;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.jaiz.jaizmobs.block.ModBlocks;
import net.jaiz.jaizmobs.item.custom.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public final class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        generator.createTrivialCube(ModBlocks.SULFUR_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        List.of(
                ModItems.STAR_FISH, ModItems.STRIDER_HAM, ModItems.COOKED_STAR_FISH,
                ModItems.HELIUM_MEMBRANE, ModItems.HUNTER_EEL, ModItems.COOKED_HUNTER_EEL,
                ModItems.EEL_ON_A_STICK, ModItems.STARFISH_ON_A_STICK, ModItems.GEYSER_BERRY,
                ModItems.COOKED_WARPED_FUNGUS, ModItems.COOKED_CRIMSON_FUNGUS, ModItems.VOID_HUSK,
                ModItems.TATTERED_WING, ModItems.KLEPHTOPOD_SCUTE, ModItems.DRIPSTONE_SHARD,
                ModItems.CRACKED_CALCITE_TOTEM, ModItems.SULFURIC_REMNANT,
                ModItems.HARDENED_BONE_FRAGMENT, ModItems.BASALT_MANDIBLE,
                ModItems.VOID_SCALE_MAIL_HELMET, ModItems.VOID_SCALE_MAIL_CHESTPLATE,
                ModItems.VOID_SCALE_MAIL_LEGGINGS, ModItems.VOID_SCALE_MAIL_BOOTS,
                ModItems.KLEPHTOPOD_SHELL, ModItems.KLEPHTOPOD_CHESTPLATE,
                ModItems.HARDENED_SKULL, ModItems.GLOW_TOOL
        ).forEach(item -> generator.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
        List.of(ModItems.DRIPSTONE_SHANK, ModItems.MANDIBLE_BLADE)
                .forEach(item -> generator.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM));
        List.of(
                ModItems.TOTEM_SPIRIT_SPAWN_EGG, ModItems.DESERT_TOTEM_SPIRIT_SPAWN_EGG,
                ModItems.JUNGLE_TOTEM_SPIRIT_SPAWN_EGG, ModItems.FROSTED_TOTEM_SPIRIT_SPAWN_EGG,
                ModItems.SPORETRAP_SPAWN_EGG, ModItems.VOIDBULL_SPAWN_EGG,
                ModItems.STARFISH_SPAWN_EGG, ModItems.STARFISHLEADER_SPAWN_EGG,
                ModItems.PINE_GIANT_SPAWN_EGG, ModItems.DRIPLET_SPAWN_EGG,
                ModItems.STALAGTITAN_SPAWN_EGG,
                ModItems.CALCITE_GOLEM_SPAWN_EGG, ModItems.CULTIVATOR_SPAWN_EGG,
                ModItems.KLEPHTOPOD_SPAWN_EGG, ModItems.HUNTER_EEL_SPAWN_EGG,
                ModItems.AEROBLOB_SPAWN_EGG, ModItems.ENDERWING_SPAWN_EGG,
                ModItems.MOLOTOV_GOLEM_SPAWN_EGG, ModItems.GEYSER_BERRY_SPAWN_EGG,
                ModItems.CRIMSON_TRUFFLER_SPAWN_EGG, ModItems.WARPED_TRUFFLER_SPAWN_EGG,
                ModItems.EMBERBEETLE_SPAWN_EGG, ModItems.SOULWADER_SPAWN_EGG,
                ModItems.STRIDER_HUNTER_SPAWN_EGG
        ).forEach(item -> generator.generateFlatItem(item, ModelTemplates.FLAT_ITEM));
    }

    @Override
    public String getName() {
        return "Jaiz Mobs Models";
    }
}
