package jaiz.jaizmod.mixin;

import jaiz.jaizmod.entity.ModEntities;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.golem.IronGolem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IronGolem.class)
public class IronGolemEntityMixin {
    @Inject(at = @At("HEAD"), method = "canAttack", cancellable = true)
    private void canAttack(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
        if(target.getType() == ModEntities.BANDIT){
            cir.setReturnValue(false);
        }
    }

}
