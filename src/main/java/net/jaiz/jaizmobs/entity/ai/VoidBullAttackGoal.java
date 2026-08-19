package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.VoidBullEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public final class VoidBullAttackGoal extends AnimatedMeleeAttackGoal<VoidBullEntity> {
    private static final double ATTACK_DISTANCE = 2.0f; // TODO

    public VoidBullAttackGoal(VoidBullEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 15, 5, ATTACK_DISTANCE);
    }

    @Override
    protected void performAttack(LivingEntity target) {
        this.resetAttackCooldown();
        this.entity.doHurtTarget((ServerLevel) this.entity.level(), target);
        this.entity.level().explode(this.entity, this.entity.getX(), this.entity.getY(), this.entity.getZ(), 1.0f / 3.0f, Level.ExplosionInteraction.MOB);
    }
}
