package jaiz.jaizmod.trim;

import jaiz.jaizmod.JaizMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.TrimPattern;

public class ModTrimPatterns {
    public static final ResourceKey<TrimPattern> PETRIFIED = ResourceKey.create(Registries.TRIM_PATTERN,
            Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "petrified"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, PETRIFIED);
    }

    private static void register(BootstrapContext<TrimPattern> context, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.identifier(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.identifier())), false);

        context.register(key, trimPattern);
    }
}
