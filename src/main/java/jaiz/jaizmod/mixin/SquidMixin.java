package jaiz.jaizmod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.AgeableWaterCreature;
import net.minecraft.world.entity.animal.squid.Squid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

@Mixin(Squid.class)
public abstract class SquidMixin extends AgeableWaterCreature {

    public SquidMixin(EntityType<? extends Squid> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "hurtServer")
    private void init(ServerLevel world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if(this.level() == null || this.level().isClientSide()) {return;}
        AABB box = (new AABB(this.blockPosition()).inflate(1.25).expandTowards(0.0, 0.0, 0.0));
        List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, box);
        for (LivingEntity livingEntity  : list) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,
                    120, 0, false, false));
        }
    }

}
