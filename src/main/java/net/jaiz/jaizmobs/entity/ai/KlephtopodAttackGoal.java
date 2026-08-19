package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.KlephtopodEntity;

public final class KlephtopodAttackGoal extends AnimatedMeleeAttackGoal<KlephtopodEntity> {
    private static final double ATTACK_DISTANCE = 2.5f; // TODO

    public KlephtopodAttackGoal(KlephtopodEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 0, 0, ATTACK_DISTANCE);
    }
}
