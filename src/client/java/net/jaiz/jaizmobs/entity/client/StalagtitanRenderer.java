package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.StalagtitanEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class StalagtitanRenderer extends JaizMobRenderer<StalagtitanEntity, Stalagtitan> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/stalagtitan.png");

    public StalagtitanRenderer(EntityRendererProvider.Context context) {
        super(context, new Stalagtitan(context.bakeLayer(ModModelLayers.STALAGTITAN)), 0.4f, TEXTURE);
    }
}
