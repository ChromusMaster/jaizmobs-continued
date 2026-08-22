package jaiz.jaizmod.entity.bandit;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.world.entity.AnimationState;

@Environment(EnvType.CLIENT)
public class BanditRenderState extends ArmedEntityRenderState {

    public AnimationState tradeAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public Object texture;
}
