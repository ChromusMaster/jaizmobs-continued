package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.SporeTrapEntity;

public final class SporeTrapAttackGoal extends AnimatedMeleeAttackGoal<SporeTrapEntity> {
    private static final double ATTACK_DISTANCE = 2.0f; // TODO

    public SporeTrapAttackGoal(SporeTrapEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 15, 5, ATTACK_DISTANCE);
    }
}
