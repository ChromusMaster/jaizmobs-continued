package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.CrimsonTrufflerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class CrimsonTrufflerRenderer extends JaizMobRenderer<CrimsonTrufflerEntity, Crimson_Truffler> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/crimson_truffler.png");

    public CrimsonTrufflerRenderer(EntityRendererProvider.Context context) {
        super(context, new Crimson_Truffler(context.bakeLayer(ModModelLayers.CRIMSON_TRUFFLER)), 0.25f, TEXTURE);
    }
}
