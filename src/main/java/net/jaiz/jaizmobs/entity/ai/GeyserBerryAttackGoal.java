package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.GeyserBerryEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public final class GeyserBerryAttackGoal extends AnimatedMeleeAttackGoal<GeyserBerryEntity> {
    private static final double ATTACK_DISTANCE = 0.6f; // TODO

    public GeyserBerryAttackGoal(GeyserBerryEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 0, 0, ATTACK_DISTANCE);
    }

    @Override
    protected void performAttack(LivingEntity target) {
        this.resetAttackCooldown();
        this.entity.level().explode(this.entity, this.entity.getX(), this.entity.getY(), this.entity.getZ(), 1.2f, Level.ExplosionInteraction.MOB);
        this.entity.doHurtTarget((ServerLevel) this.entity.level(), target);
        this.entity.discard();
    }
}
