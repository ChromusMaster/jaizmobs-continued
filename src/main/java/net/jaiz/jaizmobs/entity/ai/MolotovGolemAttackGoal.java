package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.MolotovGolemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public final class MolotovGolemAttackGoal extends AnimatedMeleeAttackGoal<MolotovGolemEntity> {
    private static final double ATTACK_DISTANCE = 2f; // TODO

    public MolotovGolemAttackGoal(MolotovGolemEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 15, 5, ATTACK_DISTANCE);
    }

    @Override
    protected void performAttack(LivingEntity target) {
        this.resetAttackCooldown();
        this.entity.level().explode(this.entity, this.entity.getX(), this.entity.getY() + 1.5, this.entity.getZ(), 1.2f, Level.ExplosionInteraction.MOB);
        this.entity.doHurtTarget((ServerLevel) this.entity.level(), target);
    }
}
