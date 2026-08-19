package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.CalciteGolemEntity;

public final class CalciteGolemAttackGoal extends AnimatedMeleeAttackGoal<CalciteGolemEntity> {
    private static final double ATTACK_DISTANCE = 2.5f; // TODO

    public CalciteGolemAttackGoal(CalciteGolemEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 17, 12, ATTACK_DISTANCE);
    }
}
