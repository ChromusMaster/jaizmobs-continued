package jaiz.jaizmod.entity.sniffer_mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.animal.sniffer.SnifferModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SnifferRenderState;
import net.minecraft.resources.Identifier;

public class SnifferSaddleFeatureRenderer extends RenderLayer<SnifferRenderState, SnifferModel> {
    public SnifferSaddleFeatureRenderer(RenderLayerParent<SnifferRenderState, SnifferModel> context) {
        super(context);
    }

    private static final Identifier TEXTURE = Identifier.withDefaultNamespace("textures/entity/sniffer/saddle.png");

    @Override
    public void submit(PoseStack matrices, SubmitNodeCollector vertexConsumers, int light, SnifferRenderState state, float limbAngle, float limbDistance) {
        if (!state.isInvisible) {
            if (((SnifferRenderStateMixinAccessor)state).getSaddle()) {
                renderColoredCutoutModel(this.getParentModel(), TEXTURE, matrices, vertexConsumers, light, state, -1, 1);
            }
        }
    }
}
