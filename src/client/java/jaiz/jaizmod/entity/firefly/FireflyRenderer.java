package jaiz.jaizmod.entity.firefly;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class FireflyRenderer<T extends FireFlySwarmEntity> extends MobRenderer<T, FireFlyRenderState, Fireflies> {

    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID,"textures/entity/fireflies/fireflies.png");

    public FireflyRenderer(EntityRendererProvider.Context context) {
        super(context, new Fireflies(context.bakeLayer(ModModelLayers.FIRE_FLY_SWARM)), 0f);
        this.addLayer(new FireFliesFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTextureLocation(FireFlyRenderState state) {
        return TEXTURE;
    }

    @Override
    public FireFlyRenderState createRenderState() {
        return new FireFlyRenderState();
    }

    public void extractRenderState(FireFlySwarmEntity entity, FireFlyRenderState state, float f) {
        state.flyingAnimationState.copyFrom(entity.fireflyAnimationState);
    }

}
