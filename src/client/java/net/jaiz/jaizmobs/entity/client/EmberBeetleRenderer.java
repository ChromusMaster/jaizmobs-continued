package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.EmberBeetleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class EmberBeetleRenderer extends JaizMobRenderer<EmberBeetleEntity, EmberBeetle> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/emberbeetle.png");

    public EmberBeetleRenderer(EntityRendererProvider.Context context) {
        super(context, new EmberBeetle(context.bakeLayer(ModModelLayers.EMBERBEETLE)), 0.1f, TEXTURE);
        this.addLayer(new GlowingEyesLayer<>(this, Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/emberbeetle_glow.png")));
    }
}
