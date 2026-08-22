package jaiz.jaizmod.entity.dragonfly;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class DragonflyRenderState extends LivingEntityRenderState {
    public AnimationState flyingAnimationState = new AnimationState();
    public Object texture;
}
