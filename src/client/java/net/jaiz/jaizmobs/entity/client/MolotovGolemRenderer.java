package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.MolotovGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class MolotovGolemRenderer extends JaizMobRenderer<MolotovGolemEntity, MolotovGolem> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/molotov_golem.png");

    public MolotovGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new MolotovGolem(context.bakeLayer(ModModelLayers.MOLOTOV_GOLEM)), 0.5f, TEXTURE);
        this.addLayer(new GlowingEyesLayer<>(this, Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/molotov_golem_glow.png")));
    }
}
