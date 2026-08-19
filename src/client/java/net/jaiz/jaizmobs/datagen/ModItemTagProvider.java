package net.jaiz.jaizmobs.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.jaiz.jaizmobs.item.custom.ModArmourMaterials;
import net.jaiz.jaizmobs.item.custom.ModItems;
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
                ModItems.VOID_SCALE_MAIL_HELMET,
                ModItems.VOID_SCALE_MAIL_CHESTPLATE,
                ModItems.VOID_SCALE_MAIL_LEGGINGS,
                ModItems.VOID_SCALE_MAIL_BOOTS,
                ModItems.KLEPHTOPOD_SHELL,
                ModItems.KLEPHTOPOD_CHESTPLATE,
                ModItems.HARDENED_SKULL
        );
        builder(ModArmourMaterials.REPAIRS_VOID_SCALE_MAIL).add(ModItems.VOID_HUSK);
        builder(ModArmourMaterials.REPAIRS_KLEPHTOPOD_SHELL).add(ModItems.KLEPHTOPOD_SCUTE);
        builder(ModArmourMaterials.REPAIRS_HARDENED_BONE).add(ModItems.HARDENED_BONE_FRAGMENT);
        builder(ModToolMaterial.REPAIRS_DRIPSTONE_TOOLS).add(ModItems.DRIPSTONE_SHARD);
        builder(ModToolMaterial.REPAIRS_STRIDER_TOOLS).add(ModItems.BASALT_MANDIBLE);
    }
}
