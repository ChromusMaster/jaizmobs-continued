package net.jaiz.jaizmobs.entity.client;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.jaiz.jaizmobs.JaizMobs;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public final class ModModelLayers {
    public static final ModelLayerLocation TOTEM_SPIRIT = create("totem_spirit");
    public static final ModelLayerLocation DESERT_TOTEM_SPIRIT = create("desert_totem_spirit");
    public static final ModelLayerLocation JUNGLE_TOTEM_SPIRIT = create("jungle_totem_spirit");
    public static final ModelLayerLocation FROSTED_TOTEM_SPIRIT = create("frosted_totem_spirit");
    public static final ModelLayerLocation SPORETRAP = create("sporetrap");
    public static final ModelLayerLocation VOIDBULL = create("voidbull");
    public static final ModelLayerLocation STARFISH = create("starfish");
    public static final ModelLayerLocation STARFISHLEADER = create("starfishleader");
    public static final ModelLayerLocation PINE_GIANT = create("pine_giant");
    public static final ModelLayerLocation DRIPLET = create("driplet");
    public static final ModelLayerLocation STALAGTITAN = create("stalagtitan");
    public static final ModelLayerLocation CALCITE_GOLEM = create("calcite_golem");
    public static final ModelLayerLocation CULTIVATOR = create("cultivator");
    public static final ModelLayerLocation KLEPHTOPOD = create("klephtopod");
    public static final ModelLayerLocation HUNTER_EEL = create("hunter_eel");
    public static final ModelLayerLocation AEROBLOB = create("aeroblob");
    public static final ModelLayerLocation ENDERWING = create("enderwing");
    public static final ModelLayerLocation MOLOTOV_GOLEM = create("molotov_golem");
    public static final ModelLayerLocation GEYSER_BERRY = create("geyser_berry");
    public static final ModelLayerLocation WARPED_TRUFFLER = create("warped_truffler");
    public static final ModelLayerLocation CRIMSON_TRUFFLER = create("crimson_truffler");
    public static final ModelLayerLocation EMBERBEETLE = create("emberbeetle");
    public static final ModelLayerLocation SOULWADER = create("soulwader");
    public static final ModelLayerLocation STRIDERHUNTER = create("striderhunter");

    private ModModelLayers() {
    }

    public static void register() {
        ModelLayerRegistry.registerModelLayer(TOTEM_SPIRIT, TotemSpirit::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(DESERT_TOTEM_SPIRIT, TotemSpirit::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(JUNGLE_TOTEM_SPIRIT, TotemSpirit::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(FROSTED_TOTEM_SPIRIT, FrostedTotemSpirit::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(SPORETRAP, SporeTrap::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(VOIDBULL, VoidBull::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(STARFISH, StarFish::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(STARFISHLEADER, StarFishLeader::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(PINE_GIANT, PineGiant::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(DRIPLET, Driplet::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(STALAGTITAN, Stalagtitan::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(CALCITE_GOLEM, Calcite_Golem::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(CULTIVATOR, Cultivator::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(KLEPHTOPOD, Klephtopod::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(HUNTER_EEL, HunterEel::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(AEROBLOB, Aeroblob::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(ENDERWING, Enderwing::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(MOLOTOV_GOLEM, MolotovGolem::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(GEYSER_BERRY, GeyserBerry::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(WARPED_TRUFFLER, Warped_Truffler::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(CRIMSON_TRUFFLER, Crimson_Truffler::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(EMBERBEETLE, EmberBeetle::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(SOULWADER, SoulWader::getLayerDefinition);
        ModelLayerRegistry.registerModelLayer(STRIDERHUNTER, StriderHunter::getLayerDefinition);
    }

    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, name), "main");
    }
}
