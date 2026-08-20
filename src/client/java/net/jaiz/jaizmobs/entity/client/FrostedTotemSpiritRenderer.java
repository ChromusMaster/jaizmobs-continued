package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.FrostedTotemSpiritEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class FrostedTotemSpiritRenderer extends JaizMobRenderer<FrostedTotemSpiritEntity, FrostedTotemSpirit> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/frosted_totem_spirit.png");

    public FrostedTotemSpiritRenderer(EntityRendererProvider.Context context) {
        super(context, new FrostedTotemSpirit(context.bakeLayer(ModModelLayers.FROSTED_TOTEM_SPIRIT)), 0.5f, TEXTURE);
    }
}
