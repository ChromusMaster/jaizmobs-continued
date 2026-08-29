package jaiz.jaizmod.advancement;

import com.mojang.serialization.Codec;
import java.util.Optional;
import net.minecraft.advancements.predicates.ContextAwarePredicate;
import net.minecraft.advancements.triggers.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

public final class SimpleEventCriterion extends SimpleCriterionTrigger<SimpleEventCriterion.Conditions> {
    @Override
    public Codec<Conditions> codec() {
        return Conditions.CODEC;
    }

    public void trigger(ServerPlayer player) {
        trigger(player, Conditions::requirementsMet);
    }

    public record Conditions(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<Conditions> CODEC = ContextAwarePredicate.CODEC.optionalFieldOf("player")
                .xmap(Conditions::new, Conditions::player)
                .codec();

        public boolean requirementsMet() {
            return true;
        }
    }
}
