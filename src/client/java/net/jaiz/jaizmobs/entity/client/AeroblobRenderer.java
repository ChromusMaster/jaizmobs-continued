package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.AeroblobEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class AeroblobRenderer extends JaizMobRenderer<AeroblobEntity, Aeroblob> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/aeroblob.png");

    public AeroblobRenderer(EntityRendererProvider.Context context) {
        super(context, new Aeroblob(context.bakeLayer(ModModelLayers.AEROBLOB)), 0.8f, TEXTURE);
        this.addLayer(new GlowingEyesLayer<>(this, Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/aeroblob_glow.png")));
    }
}
