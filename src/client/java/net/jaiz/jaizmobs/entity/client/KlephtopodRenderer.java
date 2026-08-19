package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.KlephtopodEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class KlephtopodRenderer extends JaizMobRenderer<KlephtopodEntity, Klephtopod> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/klephtopod.png");

    public KlephtopodRenderer(EntityRendererProvider.Context context) {
        super(context, new Klephtopod(context.bakeLayer(ModModelLayers.KLEPHTOPOD)), 0.8f, TEXTURE);
    }
}
