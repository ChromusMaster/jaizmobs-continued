package jaiz.jaizmod.mixin;

import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TargetGoal.class)
public abstract class TargetGoalMixin {

    @Shadow @Final protected Mob mob;

    @Inject(method = "canContinueToUse", at = @At("HEAD"), cancellable = true)
    private void stopTargetingStinkyEntities(CallbackInfoReturnable<Boolean> cir) {
        if (!((Object) this instanceof NearestAttackableTargetGoal<?>)) {
            return;
        }
        LivingEntity target = this.mob.getTarget();
        if (target != null && target.hasEffect(ModStatusEffects.STINKY)) {
            cir.setReturnValue(false);
        }
    }


}
