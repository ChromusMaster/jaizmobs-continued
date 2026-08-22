package jaiz.jaizmod.entity.firefly;


import jaiz.jaizmod.JaizMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;


@Environment(EnvType.CLIENT)
public class FireFliesFeatureRenderer<M extends Fireflies> extends EyesLayer<FireFlyRenderState, M> {

    private static final RenderType GLOW = RenderTypes.eyes(Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/fireflies/fireflies.png"));

    public FireFliesFeatureRenderer(RenderLayerParent<FireFlyRenderState, M> featureRendererContext) {
        super(featureRendererContext);
    }


    @Override
    public RenderType renderType() {
        return GLOW;
    }
}

