package net.jaiz.jaizmobs.entity.ai;

import net.jaiz.jaizmobs.entity.custom.FrostedTotemSpiritEntity;

public final class FrostedTotemSpiritAttackGoal extends AnimatedMeleeAttackGoal<FrostedTotemSpiritEntity> {
    private static final double ATTACK_DISTANCE = 2.5f; // TODO

    public FrostedTotemSpiritAttackGoal(FrostedTotemSpiritEntity entity, double speed, boolean pauseWhenMobIdle) {
        super(entity, speed, pauseWhenMobIdle, 17, 12, ATTACK_DISTANCE);
    }
}
