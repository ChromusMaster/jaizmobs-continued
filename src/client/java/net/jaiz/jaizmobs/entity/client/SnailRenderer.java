package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.SnailEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class SnailRenderer extends JaizMobRenderer<SnailEntity, Snail> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/snail.png");

    public SnailRenderer(EntityRendererProvider.Context context) {
        super(context, new Snail(context.bakeLayer(ModModelLayers.SNAIL)), 0f, TEXTURE);
    }
}
