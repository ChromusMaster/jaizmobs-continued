package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.PineGiantEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class PineGiantRenderer extends JaizMobRenderer<PineGiantEntity, PineGiant> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/pine_giant.png");

    public PineGiantRenderer(EntityRendererProvider.Context context) {
        super(context, new PineGiant(context.bakeLayer(ModModelLayers.PINE_GIANT)), 0.5f, TEXTURE);
    }
}
