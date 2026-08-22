package jaiz.jaizmod.entity.caterpillar;

import com.google.common.collect.Maps;
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

public class CaterpillarRenderer extends MobRenderer<CaterpillarEntity, CaterpillarRenderState, Caterpillar> {


    public static final Map<CaterpillarVariant, Identifier> CATERPILLAR_VARIANT =
            Util.make(Maps.newEnumMap(CaterpillarVariant.class), (map) -> {
                map.put(CaterpillarVariant.GREEN, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/caterpillar/caterpillar_green.png"));
                map.put(CaterpillarVariant.YELLOW, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/caterpillar/caterpillar_yellow.png"));
                map.put(CaterpillarVariant.GREEN_RED, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/caterpillar/caterpillar_green_red.png"));
            });

    public CaterpillarRenderer(EntityRendererProvider.Context context) {
        super(context, new Caterpillar(context.bakeLayer(ModModelLayers.CATERPILLAR)), 0.35f);
    }

    @Override
    public CaterpillarRenderState createRenderState() {
        return new CaterpillarRenderState();
    }

    @Override
    public Identifier getTextureLocation(CaterpillarRenderState state) {
        return CATERPILLAR_VARIANT.get(state.texture);
    }

    public void extractRenderState(CaterpillarEntity entity, CaterpillarRenderState entityState, float f) {
        super.extractRenderState(entity, entityState, f);
        entityState.texture = entity.getVariant();
    }
}
