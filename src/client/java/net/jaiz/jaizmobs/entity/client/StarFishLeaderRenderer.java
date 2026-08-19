package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.StarFishLeaderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class StarFishLeaderRenderer extends JaizMobRenderer<StarFishLeaderEntity, StarFishLeader> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/star_fish_leader.png");
    private static final Identifier ATLAS_TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/star_fish_leader_atlas.png");

    public StarFishLeaderRenderer(EntityRendererProvider.Context context) {
        super(context, new StarFishLeader(context.bakeLayer(ModModelLayers.STARFISHLEADER)), 0.1f, TEXTURE);
        this.addLayer(new GlowingEyesLayer<>(this, Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/star_fish_leader_glow.png")));
    }

    @Override
    public Identifier getTextureLocation(JaizMobRenderState state) {
        if ("Atlas".equals(state.name)) {
            return ATLAS_TEXTURE;
        }
        return TEXTURE;
    }
}
