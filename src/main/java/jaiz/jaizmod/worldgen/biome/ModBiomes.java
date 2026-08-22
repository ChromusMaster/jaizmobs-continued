package jaiz.jaizmod.worldgen.biome;


import jaiz.jaizmod.JaizMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {

    public static final ResourceKey<Biome> MAHOGANY_FOREST = ResourceKey.create(Registries.BIOME,
            Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "mahogany_forest"));

    public static final ResourceKey<Biome> FRUIT_BAT_CAVES = ResourceKey.create(Registries.BIOME,
            Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "fruit_bat_caves"));
}
