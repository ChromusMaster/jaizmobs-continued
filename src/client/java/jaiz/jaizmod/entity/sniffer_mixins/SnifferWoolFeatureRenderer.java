package jaiz.jaizmod.entity.sniffer_mixins;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.dragonfly.DragonflyVariant;
import java.util.Map;
import net.minecraft.client.model.animal.sniffer.SnifferModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SnifferRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

public class SnifferWoolFeatureRenderer extends RenderLayer<SnifferRenderState, SnifferModel> {
    public SnifferWoolFeatureRenderer(RenderLayerParent<SnifferRenderState, SnifferModel> context) {
        super(context);
    }

    public static final Map<SnifferVariant, Identifier> SNIFFER_VARIANT =
            Util.make(Maps.newEnumMap(SnifferVariant.class), (map) -> {
                map.put(SnifferVariant.DEFAULT, Identifier.withDefaultNamespace("textures/entity/sniffer/wool.png"));
                map.put(SnifferVariant.BLUE, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_blue.png"));
                map.put(SnifferVariant.AUTUMN, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_autumn.png"));
                map.put(SnifferVariant.LIME, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_lime.png"));
                map.put(SnifferVariant.DANDELION, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_dandelion.png"));
                map.put(SnifferVariant.DUSK, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_dusk.png"));
                map.put(SnifferVariant.GREY, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_grey.png"));
                map.put(SnifferVariant.WHITE, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_white.png"));
                map.put(SnifferVariant.DUSK_LIME, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_dusky_lime.png"));
                map.put(SnifferVariant.GREEN, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_green.png"));
                map.put(SnifferVariant.PALE, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_pale.png"));
                map.put(SnifferVariant.SUNSET, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_sunset.png"));
                map.put(SnifferVariant.MUSKY, Identifier.withDefaultNamespace("textures/entity/sniffer/wool_musky.png"));


            });

    @Override
    public void submit(PoseStack matrices, SubmitNodeCollector vertexConsumers, int light, SnifferRenderState state, float limbAngle, float limbDistance) {
        if (!state.isInvisible) {
            renderColoredCutoutModel(this.getParentModel(), SNIFFER_VARIANT.get(((SnifferRenderStateMixinAccessor)state).getTextureLocation()), matrices, vertexConsumers, light, state, -1, 1);
        }
    }
}
