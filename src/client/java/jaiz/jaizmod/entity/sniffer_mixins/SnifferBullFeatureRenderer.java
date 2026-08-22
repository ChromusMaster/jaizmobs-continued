package jaiz.jaizmod.entity.sniffer_mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.animal.sniffer.SnifferModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SnifferRenderState;
import net.minecraft.resources.Identifier;

public class SnifferBullFeatureRenderer extends RenderLayer<SnifferRenderState, SnifferModel> {
    public SnifferBullFeatureRenderer(RenderLayerParent<SnifferRenderState, SnifferModel> context) {
        super(context);
    }

    private static final Identifier BULL_TEXTURE = Identifier.withDefaultNamespace("textures/entity/sniffer/bull.png");

    @Override
    public void submit(PoseStack matrices, SubmitNodeCollector vertexConsumers, int light, SnifferRenderState state, float limbAngle, float limbDistance) {
        if (!state.isInvisible) {
            if (((SnifferRenderStateMixinAccessor)state).getBull()) {
                renderColoredCutoutModel(this.getParentModel(), BULL_TEXTURE, matrices, vertexConsumers, light, state, -1, 1);
            }
        }
    }
}
