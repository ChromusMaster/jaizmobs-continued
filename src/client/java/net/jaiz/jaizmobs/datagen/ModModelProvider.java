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
    }

    @Override
    public String getName() {
        return "Jaiz Mobs Models";
    }
}
