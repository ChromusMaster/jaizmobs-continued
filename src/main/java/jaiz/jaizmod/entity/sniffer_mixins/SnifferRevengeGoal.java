package jaiz.jaizmod.entity.sniffer_mixins;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class SnifferRevengeGoal extends HurtByTargetGoal {


    public SnifferRevengeGoal(PathfinderMob mob, Class<?>... noRevengeTypes) {
        super(mob, noRevengeTypes);
    }

    @Override
    public boolean canUse() {
        return ((SnifferMixinAccessor) mob).isBull();
    }
}
