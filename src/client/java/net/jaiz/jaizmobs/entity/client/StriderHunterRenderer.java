package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.StriderHunterEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class StriderHunterRenderer extends JaizMobRenderer<StriderHunterEntity, StriderHunter> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/strider_hunter.png");
    private static final Identifier PINK_TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/strider_hunter_pink.png");
    private static final Identifier HAHA_TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/strider_hunter_comedian.png");

    public StriderHunterRenderer(EntityRendererProvider.Context context) {
        super(context, new StriderHunter(context.bakeLayer(ModModelLayers.STRIDERHUNTER)), 1.2f, TEXTURE);
    }

    @Override
    public Identifier getTextureLocation(JaizMobRenderState state) {
        if ("Zuper".equals(state.name)) {
            return PINK_TEXTURE;
        }
        if ("DeadComedy".equals(state.name)) {
            return HAHA_TEXTURE;
        }
        return TEXTURE;
    }
}
