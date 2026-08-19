package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.TotemSpiritEntity;

public final class TotemSpiritAttackGoal extends AnimatedMeleeAttackGoal<TotemSpiritEntity> {
    private static final double ATTACK_DISTANCE = 2.5f; // TODO

    public TotemSpiritAttackGoal(TotemSpiritEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 17, 12, ATTACK_DISTANCE);
    }
}
