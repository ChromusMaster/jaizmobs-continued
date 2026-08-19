package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.AttackingMob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class AnimatedMeleeAttackGoal<T extends PathfinderMob & AttackingMob> extends MeleeAttackGoal {
    protected final T entity;
    private final int attackCooldown;
    private final int initialDelay;
    private final double attackDistanceSqr;
    private int ticksUntilNextAttack;
    private boolean counting;

    protected AnimatedMeleeAttackGoal(T entity, double speed, boolean pauseWhenMobIdle, int attackCooldown, int initialDelay, double attackDistance) {
        super(entity, speed, pauseWhenMobIdle);
        this.entity = entity;
        this.attackCooldown = attackCooldown;
        this.initialDelay = initialDelay;
        this.attackDistanceSqr = attackDistance * attackDistance;
    }

    @Override
    public void start() {
        super.start();
        this.ticksUntilNextAttack = this.initialDelay;
        this.counting = false;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity target) {
        if (this.entity.distanceToSqr(target) > this.attackDistanceSqr) {
            this.resetAttackCooldown();
            this.counting = false;
            this.entity.setAttacking(false);
            return;
        }

        this.counting = true;
        this.entity.setAttacking(true);
        if (this.ticksUntilNextAttack <= 0) {
            this.entity.getLookControl().setLookAt(target, 30.0f, 30.0f);
            this.performAttack(target);
        }
    }

    protected void performAttack(LivingEntity target) {
        this.resetAttackCooldown();
        this.entity.swing(InteractionHand.MAIN_HAND);
        this.entity.doHurtTarget((ServerLevel) this.entity.level(), target);
    }

    protected final void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(this.attackCooldown);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.counting) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        this.entity.setAttacking(false);
        this.counting = false;
        super.stop();
    }
}
