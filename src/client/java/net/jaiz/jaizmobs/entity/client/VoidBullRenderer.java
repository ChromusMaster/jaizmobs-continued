package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.VoidBullEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class VoidBullRenderer extends JaizMobRenderer<VoidBullEntity, VoidBull> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/voidbull.png");

    public VoidBullRenderer(EntityRendererProvider.Context context) {
        super(context, new VoidBull(context.bakeLayer(ModModelLayers.VOIDBULL)), 1f, TEXTURE);
    }
}
