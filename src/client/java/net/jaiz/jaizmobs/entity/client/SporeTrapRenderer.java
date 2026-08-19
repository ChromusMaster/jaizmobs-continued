package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.SporeTrapEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class SporeTrapRenderer extends JaizMobRenderer<SporeTrapEntity, SporeTrap> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/sporetrap.png");

    public SporeTrapRenderer(EntityRendererProvider.Context context) {
        super(context, new SporeTrap(context.bakeLayer(ModModelLayers.SPORETRAP)), 0.25f, TEXTURE);
    }
}
