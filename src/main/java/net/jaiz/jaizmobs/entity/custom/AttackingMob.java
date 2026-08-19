package net.jaiz.jaizmobs.entity.custom;

public interface AttackingMob extends AnimatedMob {
    void setAttacking(boolean attacking);

    boolean isAttacking();
}
