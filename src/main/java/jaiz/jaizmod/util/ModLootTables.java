package jaiz.jaizmod.util;

import jaiz.jaizmod.JaizMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTables {
    public static ResourceKey<LootTable> BANDIT_TRADES_GAMEPLAY = of("gameplay/bandit_trades");
    public static ResourceKey<LootTable> SNIFFER_BRUSH_COAT_GAMEPLAY = of("gameplay/sniffer_coat");

    private static ResourceKey<LootTable> of(String id) {
        return ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, id));
    }

    public static void registerLootTables(){
    }
}
