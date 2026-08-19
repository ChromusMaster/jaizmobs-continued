package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.world.entity.AnimationState;

public interface AnimatedMob {
    default AnimationState idleAnimationState() {
        return null;
    }

    default AnimationState attackAnimationState() {
        return null;
    }
}
