package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.EnderwingEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class EnderwingRenderer extends JaizMobRenderer<EnderwingEntity, Enderwing> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/enderwing.png");

    public EnderwingRenderer(EntityRendererProvider.Context context) {
        super(context, new Enderwing(context.bakeLayer(ModModelLayers.ENDERWING)), 0.7f, TEXTURE);
        this.addLayer(new GlowingEyesLayer<>(this, Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/enderwing_glow.png")));
    }
}
