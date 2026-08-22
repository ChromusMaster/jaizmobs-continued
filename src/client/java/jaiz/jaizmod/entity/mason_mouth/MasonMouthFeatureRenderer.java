package jaiz.jaizmod.entity.mason_mouth;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import jaiz.jaizmod.JaizMod;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.Identifier;

public class MasonMouthFeatureRenderer extends RenderLayer<MasonMouthRenderState, Masonmouth> {

    public MasonMouthFeatureRenderer(RenderLayerParent<MasonMouthRenderState, Masonmouth> context) {
        super(context);
    }

    private static final Identifier CRACK_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/cracked.png");

    @Override
    public void submit(PoseStack matrices, SubmitNodeCollector vertexConsumers, int light, MasonMouthRenderState state, float limbAngle, float limbDistance) {
        if (!state.isInvisible) {
            if (state.cracked) {
                renderColoredCutoutModel(this.getParentModel(), CRACK_TEXTURE, matrices, vertexConsumers, light, state, -1, 1);
            }
        }
    }
}
