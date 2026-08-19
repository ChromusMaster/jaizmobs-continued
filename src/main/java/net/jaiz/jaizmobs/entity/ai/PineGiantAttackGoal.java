package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.PineGiantEntity;

public final class PineGiantAttackGoal extends AnimatedMeleeAttackGoal<PineGiantEntity> {
    private static final double ATTACK_DISTANCE = 2f; // TODO

    public PineGiantAttackGoal(PineGiantEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 15, 5, ATTACK_DISTANCE);
    }
}
