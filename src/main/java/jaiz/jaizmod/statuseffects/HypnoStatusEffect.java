package jaiz.jaizmod.statuseffects;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class HypnoStatusEffect extends MobEffect {
    protected HypnoStatusEffect(MobEffectCategory statusEffectCategory, int i, ParticleOptions particleEffect) {
        super(statusEffectCategory, i, particleEffect);}

    public int hypnoIntensity = 0;
    public static float hypnopulse;
    public int hypnopulseInt;

        @Override
        public boolean applyEffectTick(ServerLevel world, LivingEntity entity, int amplifier) {
            entity.setSwimming(false);

                hypnoIntensity++;
                if (hypnoIntensity == 0) {
                    hypnopulseInt = 0;
                }
                if (hypnoIntensity <= 50) {
                    hypnopulseInt++;
                }
                if (hypnoIntensity > 50) {
                    hypnopulseInt--;
                }
                if (hypnoIntensity >= 100) {
                    hypnoIntensity = 0;
                }


                hypnopulse = hypnopulseInt * 0.01f;

            return true;
        }

    @Override
        public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
            return true;
        }

}
