package jaiz.jaizmod.villager;

import com.google.common.collect.ImmutableSet;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PoiHelper;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.level.block.Block;

public class ModVillagers {

    public static final ResourceKey<PoiType> TEA_POI_KEY = poiKey("teapoi");
    public static final PoiType TEA_POI = registerPoi("teapoi", ModBlocks.TEAPOTBLOCK);
    public static final VillagerProfession TEA_BREWER = registerTeaProfession("tea_brewer", TEA_POI_KEY);

    public static final ResourceKey<PoiType> SPICE_POI_KEY = poiKey("spicepoi");
    public static final PoiType SPICE_POI = registerPoi("spicepoi", ModBlocks.SPICE_BARREL);
    public static final VillagerProfession SPICE_TRADER = registerSpiceProfession("spice_trader", SPICE_POI_KEY);

    private static VillagerProfession registerSpiceProfession(String name, ResourceKey<PoiType> type) {
        return Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name),
                new VillagerProfession(Component.translatable("entity.jaizmod.villager." + name), entry -> entry.is(type), entry -> entry.is(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FISHERMAN,
                        Int2ObjectMap.ofEntries(
                                Int2ObjectMap.entry(1, tradeSetKey(name, 1)),
                                Int2ObjectMap.entry(2, tradeSetKey(name, 2)),
                                Int2ObjectMap.entry(3, tradeSetKey(name, 3)),
                                Int2ObjectMap.entry(4, tradeSetKey(name, 4)),
                                Int2ObjectMap.entry(5, tradeSetKey(name, 5)))));
    }

    private static VillagerProfession registerTeaProfession(String name, ResourceKey<PoiType> type) {
        return Registry.register(BuiltInRegistries.VILLAGER_PROFESSION, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name),
                new VillagerProfession(Component.translatable("entity.jaizmod.villager." + name), entry -> entry.is(type), entry -> entry.is(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CLERIC,
                        Int2ObjectMap.ofEntries(
                                Int2ObjectMap.entry(1, tradeSetKey(name, 1)),
                                Int2ObjectMap.entry(2, tradeSetKey(name, 2)),
                                Int2ObjectMap.entry(3, tradeSetKey(name, 3)),
                                Int2ObjectMap.entry(4, tradeSetKey(name, 4)))));
    }

    private static ResourceKey<TradeSet> tradeSetKey(String profession, int level) {
        return ResourceKey.create(Registries.TRADE_SET, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, profession + "/level_" + level));
    }

    private static PoiType registerPoi(String name, Block block) {
        return PoiHelper.register(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name), 1, 1, block);
    }

    public static ResourceKey<PoiType>  poiKey(String name) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name));
    }

    public static void registerVillagers() {
        JaizMod.LOGGER.info("Registering Villagers " + JaizMod.MOD_ID);

    }
}
