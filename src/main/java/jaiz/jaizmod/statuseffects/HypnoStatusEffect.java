package jaiz.jaizmod.statuseffects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class HypnoStatusEffect extends MobEffect {
    protected HypnoStatusEffect(MobEffectCategory statusEffectCategory, int i, ParticleOptions particleEffect) {
        super(statusEffectCategory, i, particleEffect);}

        @Override
        public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
            entity.setSwimming(false);
            return true;
        }

    @Override
        public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
            return true;
        }

}
