package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.HunterEelEntity;

public final class HunterEelAttackGoal extends AnimatedMeleeAttackGoal<HunterEelEntity> {
    private static final double ATTACK_DISTANCE = 2.5f; // TODO

    public HunterEelAttackGoal(HunterEelEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 17, 12, ATTACK_DISTANCE);
    }
}
