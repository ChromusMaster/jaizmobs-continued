package jaiz.jaizmod.entity.fruit_bat;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class FruitBatRenderer extends MobRenderer<FruitBatEntity, FruitBatRenderState, FruitBat> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bats/fruit_bat.png");

    public FruitBatRenderer(EntityRendererProvider.Context context) {
        super(context, new FruitBat(context.bakeLayer(ModModelLayers.FRUIT_BAT)), 0.25f);
    }

    public FruitBatRenderState createRenderState() {
        return new FruitBatRenderState();
    }


    @Override
    public Identifier getTextureLocation(FruitBatRenderState state) {
        return TEXTURE;

    }

    public void extractRenderState(FruitBatEntity batEntity, FruitBatRenderState FruitBatRenderState, float f) {
        super.extractRenderState(batEntity, FruitBatRenderState, f);
        FruitBatRenderState.roosting = batEntity.isResting();
        FruitBatRenderState.flyingAnimationState.copyFrom(batEntity.flyAnimationState);
        FruitBatRenderState.roostingAnimationState.copyFrom(batEntity.restAnimationState);
    }
}
