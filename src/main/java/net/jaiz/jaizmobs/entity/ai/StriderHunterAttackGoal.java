package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.StriderHunterEntity;

public final class StriderHunterAttackGoal extends AnimatedMeleeAttackGoal<StriderHunterEntity> {
    private static final double ATTACK_DISTANCE = 2.5f; // TODO

    public StriderHunterAttackGoal(StriderHunterEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 17, 12, ATTACK_DISTANCE);
    }
}
