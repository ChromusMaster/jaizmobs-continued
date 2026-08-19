package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.GeyserBerryEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class GeyserBerryRenderer extends JaizMobRenderer<GeyserBerryEntity, GeyserBerry> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/geyser_berry.png");

    public GeyserBerryRenderer(EntityRendererProvider.Context context) {
        super(context, new GeyserBerry(context.bakeLayer(ModModelLayers.GEYSER_BERRY)), 0.3f, TEXTURE);
    }
}
