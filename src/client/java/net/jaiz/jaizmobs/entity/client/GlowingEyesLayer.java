package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.Identifier;

public final class GlowingEyesLayer<M extends EntityModel<JaizMobRenderState>> extends EyesLayer<JaizMobRenderState, M> {
    private final RenderType renderType;

    public GlowingEyesLayer(RenderLayerParent<JaizMobRenderState, M> parent, Identifier texture) {
        super(parent);
        this.renderType = RenderTypes.eyes(texture);
    }

    @Override
    public RenderType renderType() {
        return this.renderType;
    }
}
