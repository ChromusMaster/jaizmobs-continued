package jaiz.jaizmod.mixin;

import jaiz.jaizmod.entity.mason_mouth.MasonMouthFeatureRenderer;
import jaiz.jaizmod.entity.sniffer_mixins.*;
import jaiz.jaizmod.item.ModItems;
import net.minecraft.client.model.animal.sniffer.SnifferModel;
import net.minecraft.client.renderer.entity.AgeableMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SnifferRenderer;
import net.minecraft.client.renderer.entity.state.SnifferRenderState;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SnifferRenderer.class)
public abstract class SnifferRendererMixin extends AgeableMobRenderer<Sniffer, SnifferRenderState, SnifferModel> {

    public SnifferRendererMixin(EntityRendererProvider.Context context, SnifferModel model, SnifferModel babyModel, float shadowRadius) {
        super(context, model, babyModel, shadowRadius);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    public void getTexturedModelData(EntityRendererProvider.Context context, CallbackInfo ci){
        this.addLayer(new SnifferWoolFeatureRenderer(this));
        this.addLayer(new SnifferBullFeatureRenderer(this));
        this.addLayer(new SnifferMuddyFeatureRenderer(this));
        this.addLayer(new SnifferMossyFeatureRenderer(this));
        this.addLayer(new SnifferBlossomFeatureRenderer(this));
        this.addLayer(new SnifferSnowFeatureRenderer(this));
        this.addLayer(new SnifferSaddleFeatureRenderer(this));
    }

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    public void extractRenderState(Sniffer sniffer, SnifferRenderState state, float f, CallbackInfo ci){
        ((SnifferRenderStateMixinAccessor)state).setSnowy(((SnifferMixinAccessor)sniffer).isSnowy());
        ((SnifferRenderStateMixinAccessor)state).setBull(((SnifferMixinAccessor)sniffer).isBull());
        ((SnifferRenderStateMixinAccessor)state).setCherryBlossom(((SnifferMixinAccessor)sniffer).isCherryBlossom());
        ((SnifferRenderStateMixinAccessor)state).setMossy(((SnifferMixinAccessor)sniffer).isMossy());
        ((SnifferRenderStateMixinAccessor)state).setMuddy(((SnifferMixinAccessor)sniffer).isMuddy());
        ((SnifferRenderStateMixinAccessor)state).setSaddle(((SnifferMixinAccessor)sniffer).isSaddled());
        ((SnifferRenderStateMixinAccessor)state).setTexture((((SnifferMixinAccessor)sniffer).getVariant()));
    }

}
