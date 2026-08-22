package jaiz.jaizmod.entity.sniffer_mixins;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class SnifferGroupRevengeGoal extends HurtByTargetGoal {

    public SnifferGroupRevengeGoal(PathfinderMob mob, Class<?>... noRevengeTypes) {
        super(mob, noRevengeTypes);
    }

    @Override
    public boolean canUse() {
        return !((SnifferMixinAccessor) this.mob).isBull();
    }

    @Override
    public void tick() {
        if(!((SnifferMixinAccessor) this.mob).isBull()){
            super.stop();
        }
    }
}
