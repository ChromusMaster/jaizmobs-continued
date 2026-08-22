package jaiz.jaizmod.datagen;

import jaiz.jaizmod.villager.ModVillagers;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class ModPoiTagProvider extends TagsProvider<PoiType> {
    public ModPoiTagProvider(PackOutput output,
                             CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.POINT_OF_INTEREST_TYPE, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookup) {
        this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(ModVillagers.SPICE_POI_KEY)
                .addOptional(ModVillagers.TEA_POI_KEY);
    }
}
