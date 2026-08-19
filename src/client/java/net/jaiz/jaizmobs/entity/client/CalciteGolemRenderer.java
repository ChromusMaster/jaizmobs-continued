package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.CalciteGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class CalciteGolemRenderer extends JaizMobRenderer<CalciteGolemEntity, Calcite_Golem> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/calcite_golem.png");

    public CalciteGolemRenderer(EntityRendererProvider.Context context) {
        super(context, new Calcite_Golem(context.bakeLayer(ModModelLayers.CALCITE_GOLEM)), 0.3f, TEXTURE);
    }
}
