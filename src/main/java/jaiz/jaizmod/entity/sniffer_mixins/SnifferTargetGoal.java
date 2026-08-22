package jaiz.jaizmod.entity.sniffer_mixins;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

public class SnifferTargetGoal extends NearestAttackableTargetGoal {
    public SnifferTargetGoal(Mob mob, Class targetClass, boolean checkVisibility) {
        super(mob, targetClass, checkVisibility);
    }

    @Override
    public boolean canUse() {
        return ((SnifferMixinAccessor) this).isBull();
    }


}
