package jaiz.jaizmod.mixin;

import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NearestAttackableTargetGoal.class)
public abstract class TargetGoalMixin extends TargetGoal {

    public TargetGoalMixin(Mob mob, boolean checkVisibility) {
        super(mob, checkVisibility);
    }

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void stopTargetingStinkyEntities(CallbackInfo ci) {
        if (!(this.mob.getTarget() == null) && this.mob.getTarget().hasEffect(ModStatusEffects.STINKY)) {
            this.stop();
            ci.cancel();
        }
    }


}
