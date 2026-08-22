package jaiz.jaizmod.entity.dragonfly;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import jaiz.jaizmod.entity.butterfly.Butterfly;
import jaiz.jaizmod.entity.butterfly.ButterflyEntity;
import jaiz.jaizmod.entity.butterfly.ButterflyRenderState;
import java.util.Map;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

public class DragonflyRenderer extends MobRenderer<DragonflyEntity, DragonflyRenderState, DragonFly> {

    public static final Map<DragonflyVariant, Identifier> DRAGONFLY_VARIANT =
            Util.make(Maps.newEnumMap(DragonflyVariant.class), (map) -> {
                map.put(DragonflyVariant.AQUA_YELLOW, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/dragonfly/dragonfly_aqua_2.png"));
                map.put(DragonflyVariant.AQUA, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/dragonfly/dragonfly.png"));
                map.put(DragonflyVariant.GRAY, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/dragonfly/dragonfly_grey.png"));
                map.put(DragonflyVariant.BLUE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/dragonfly/dragonfly_blue.png"));
                map.put(DragonflyVariant.ORANGE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/dragonfly/dragonfly_orange.png"));
                map.put(DragonflyVariant.RED, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/dragonfly/dragonfly_red_2.png"));
                map.put(DragonflyVariant.RED_GREEN, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/dragonfly/dragonfly_red.png"));
            });

    public DragonflyRenderer(EntityRendererProvider.Context context) {

        super(context, new DragonFly(context.bakeLayer(ModModelLayers.DRAGONFLY)), 0.45f);
    }

    @Override
    public DragonflyRenderState createRenderState() {
        return new DragonflyRenderState();
    }


    public void render(DragonflyEntity mobEntity, PoseStack matrixStack) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
    }

    @Override
    public Identifier getTextureLocation(DragonflyRenderState state) {
        return DRAGONFLY_VARIANT.get(state.texture);
    }

    public void extractRenderState(DragonflyEntity entity, DragonflyRenderState state, float f) {
        super.extractRenderState(entity, state, f);
        state.texture = entity.getVariant();
        state.flyingAnimationState.copyFrom(entity.dragonflyAnimationState);
    }
}
