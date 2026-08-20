package net.jaiz.jaizmobs.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.jaiz.jaizmobs.item.custom.ModArmourMaterials;
import net.jaiz.jaizmobs.item.custom.ModItemIds;
import net.jaiz.jaizmobs.item.custom.ModToolMaterial;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

public final class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        builder(ItemTags.TRIMMABLE_ARMOR).add(
                ModItemIds.VOID_SCALE_MAIL_HELMET,
                ModItemIds.VOID_SCALE_MAIL_CHESTPLATE,
                ModItemIds.VOID_SCALE_MAIL_LEGGINGS,
                ModItemIds.VOID_SCALE_MAIL_BOOTS,
                ModItemIds.KLEPHTOPOD_SHELL,
                ModItemIds.KLEPHTOPOD_CHESTPLATE,
                ModItemIds.HARDENED_SKULL
        );
        builder(ModArmourMaterials.REPAIRS_VOID_SCALE_MAIL).add(ModItemIds.VOID_HUSK);
        builder(ModArmourMaterials.REPAIRS_KLEPHTOPOD_SHELL).add(ModItemIds.KLEPHTOPOD_SCUTE);
        builder(ModArmourMaterials.REPAIRS_HARDENED_BONE).add(ModItemIds.HARDENED_BONE_FRAGMENT);
        builder(ModToolMaterial.REPAIRS_DRIPSTONE_TOOLS).add(ModItemIds.DRIPSTONE_SHARD);
        builder(ModToolMaterial.REPAIRS_STRIDER_TOOLS).add(ModItemIds.BASALT_MANDIBLE);
    }
}
