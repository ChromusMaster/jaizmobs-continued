package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.StalagtitanEntity;

public final class StalagtitanAttackGoal extends AnimatedMeleeAttackGoal<StalagtitanEntity> {
    private static final double ATTACK_DISTANCE = 2.0f; // TODO

    public StalagtitanAttackGoal(StalagtitanEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 12, 12, ATTACK_DISTANCE);
    }
}
