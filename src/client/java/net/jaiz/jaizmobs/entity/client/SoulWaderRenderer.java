package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.SoulWaderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class SoulWaderRenderer extends JaizMobRenderer<SoulWaderEntity, SoulWader> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/soulwader.png");

    public SoulWaderRenderer(EntityRendererProvider.Context context) {
        super(context, new SoulWader(context.bakeLayer(ModModelLayers.SOULWADER)), 1.2f, TEXTURE);
        this.addLayer(new GlowingEyesLayer<>(this, Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/soulwader_glow.png")));
    }
}
