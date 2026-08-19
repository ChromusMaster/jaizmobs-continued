package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.HunterEelEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class HunterEelRenderer extends JaizMobRenderer<HunterEelEntity, HunterEel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/hunter_eel.png");

    public HunterEelRenderer(EntityRendererProvider.Context context) {
        super(context, new HunterEel(context.bakeLayer(ModModelLayers.HUNTER_EEL)), 0.0f, TEXTURE);
    }
}
