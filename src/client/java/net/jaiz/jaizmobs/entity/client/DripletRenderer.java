package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.DripletEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class DripletRenderer extends JaizMobRenderer<DripletEntity, Driplet> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/driplet.png");

    public DripletRenderer(EntityRendererProvider.Context context) {
        super(context, new Driplet(context.bakeLayer(ModModelLayers.DRIPLET)), 0.2f, TEXTURE);
    }
}
