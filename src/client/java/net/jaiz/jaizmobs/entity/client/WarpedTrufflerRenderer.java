package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.WarpedTrufflerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class WarpedTrufflerRenderer extends JaizMobRenderer<WarpedTrufflerEntity, Warped_Truffler> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/warped_truffler.png");

    public WarpedTrufflerRenderer(EntityRendererProvider.Context context) {
        super(context, new Warped_Truffler(context.bakeLayer(ModModelLayers.WARPED_TRUFFLER)), 0.25f, TEXTURE);
    }
}
