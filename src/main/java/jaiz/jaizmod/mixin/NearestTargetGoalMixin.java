package jaiz.jaizmod.mixin;

import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NearestAttackableTargetGoal.class)
public abstract class NearestTargetGoalMixin {

    @Shadow protected LivingEntity target;

    @Inject(method = "canUse", at = @At("RETURN"), cancellable = true)
    private void preventTargetingStinkyEntities(CallbackInfoReturnable<Boolean> cir) {
        if (this.target != null && this.target.hasEffect(ModStatusEffects.STINKY)) {
            this.target = null;
            cir.setReturnValue(false);
        }
    }
}
