package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.custom.AnimatedMob;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.AnimationState;

public abstract class JaizMobRenderer<E extends Mob & AnimatedMob, M extends EntityModel<JaizMobRenderState>> extends MobRenderer<E, JaizMobRenderState, M> {
    private final Identifier texture;

    protected JaizMobRenderer(EntityRendererProvider.Context context, M model, float shadowRadius, Identifier texture) {
        super(context, model, shadowRadius);
        this.texture = texture;
    }

    @Override
    public final JaizMobRenderState createRenderState() {
        return new JaizMobRenderState();
    }

    @Override
    public void extractRenderState(E entity, JaizMobRenderState state, float tickProgress) {
        super.extractRenderState(entity, state, tickProgress);
        copyAnimation(entity.idleAnimationState(), state.idleAnimationState);
        copyAnimation(entity.attackAnimationState(), state.attackAnimationState);
        state.name = ChatFormatting.stripFormatting(entity.getName().getString());
    }

    private static void copyAnimation(AnimationState source, AnimationState target) {
        if (source == null) {
            target.stop();
        } else {
            target.copyFrom(source);
        }
    }

    @Override
    public Identifier getTextureLocation(JaizMobRenderState state) {
        return this.texture;
    }
}
