package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.DripletEntity;

public final class DripletAttackGoal extends AnimatedMeleeAttackGoal<DripletEntity> {
    private static final double ATTACK_DISTANCE = 2.5f; // TODO

    public DripletAttackGoal(DripletEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 17, 12, ATTACK_DISTANCE);
    }
}
