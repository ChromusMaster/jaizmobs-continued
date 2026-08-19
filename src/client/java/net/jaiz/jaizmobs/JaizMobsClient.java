package net.jaiz.jaizmobs;

import net.fabricmc.api.ClientModInitializer;
import net.jaiz.jaizmobs.entity.ModEntities;
import net.jaiz.jaizmobs.entity.client.*;
import net.minecraft.client.renderer.entity.EntityRenderers;

public final class JaizMobsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelLayers.register();
        EntityRenderers.register(ModEntities.TOTEM_SPIRIT, TotemSpiritRenderer::new);
        EntityRenderers.register(ModEntities.DESERT_TOTEM_SPIRIT, DesertTotemSpiritRenderer::new);
        EntityRenderers.register(ModEntities.JUNGLE_TOTEM_SPIRIT, JungleTotemSpiritRenderer::new);
        EntityRenderers.register(ModEntities.FROSTED_TOTEM_SPIRIT, FrostedTotemSpiritRenderer::new);
        EntityRenderers.register(ModEntities.SPORETRAP, SporeTrapRenderer::new);
        EntityRenderers.register(ModEntities.VOIDBULL, VoidBullRenderer::new);
        EntityRenderers.register(ModEntities.STARFISH, StarFishRenderer::new);
        EntityRenderers.register(ModEntities.STARFISHLEADER, StarFishLeaderRenderer::new);
        EntityRenderers.register(ModEntities.PINE_GIANT, PineGiantRenderer::new);
        EntityRenderers.register(ModEntities.DRIPLET, DripletRenderer::new);
        EntityRenderers.register(ModEntities.STALAGTITAN, StalagtitanRenderer::new);
        EntityRenderers.register(ModEntities.SNAIL, SnailRenderer::new);
        EntityRenderers.register(ModEntities.CALCITE_GOLEM, CalciteGolemRenderer::new);
        EntityRenderers.register(ModEntities.CULTIVATOR, CultivatorRenderer::new);
        EntityRenderers.register(ModEntities.KLEPHTOPOD, KlephtopodRenderer::new);
        EntityRenderers.register(ModEntities.HUNTER_EEL, HunterEelRenderer::new);
        EntityRenderers.register(ModEntities.AEROBLOB, AeroblobRenderer::new);
        EntityRenderers.register(ModEntities.ENDERWING, EnderwingRenderer::new);
        EntityRenderers.register(ModEntities.MOLOTOV_GOLEM, MolotovGolemRenderer::new);
        EntityRenderers.register(ModEntities.GEYSER_BERRY, GeyserBerryRenderer::new);
        EntityRenderers.register(ModEntities.WARPED_TRUFFLER, WarpedTrufflerRenderer::new);
        EntityRenderers.register(ModEntities.CRIMSON_TRUFFLER, CrimsonTrufflerRenderer::new);
        EntityRenderers.register(ModEntities.EMBERBEETLE, EmberBeetleRenderer::new);
        EntityRenderers.register(ModEntities.SOULWADER, SoulWaderRenderer::new);
        EntityRenderers.register(ModEntities.STRIDER_HUNTER, StriderHunterRenderer::new);
    }
}
