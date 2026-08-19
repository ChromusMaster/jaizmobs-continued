package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.CultivatorEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class CultivatorRenderer extends JaizMobRenderer<CultivatorEntity, Cultivator> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/cultivator.png");
    private static final Identifier EPIC_TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/cultivator_epic.png");

    public CultivatorRenderer(EntityRendererProvider.Context context) {
        super(context, new Cultivator(context.bakeLayer(ModModelLayers.CULTIVATOR)), 1f, TEXTURE);
    }

    @Override
    public Identifier getTextureLocation(JaizMobRenderState state) {
        if ("Epiccool".equals(state.name)) {
            return EPIC_TEXTURE;
        }
        return TEXTURE;
    }
}
