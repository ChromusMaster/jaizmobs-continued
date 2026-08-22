package jaiz.jaizmod.statuseffects;

import jaiz.jaizmod.JaizMod;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class ModStatusEffects {

    public static Holder.Reference<MobEffect> STINKY;
    public static Holder.Reference<MobEffect> HYPNO;
    public static Holder.Reference<MobEffect> SHIMMER;


    public static Holder.Reference<MobEffect> registerStinkyStatusEffect(String name) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name),
                new StinkyStatusEffect(MobEffectCategory.NEUTRAL, 5882118, JaizMod.STINK_PARTICLE).addAttributeModifier(
                        Attributes.MOVEMENT_SPEED, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "effects/stinky"), -0.25F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                ));

    }

    public static Holder.Reference<MobEffect> registerHypnoStatusEffect(String name) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name),
                new HypnoStatusEffect(MobEffectCategory.NEUTRAL, 5882118, ParticleTypes.GLOW)
                );
    }

    public static Holder.Reference<MobEffect> registerShimmerStatusEffect(String name) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name),
                new ShimmerStatusEffect(MobEffectCategory.NEUTRAL, 5882118, ParticleTypes.GLOW)
        );
    }


    public static void registerModEffects() {
        STINKY = registerStinkyStatusEffect("stinky");
        SHIMMER = registerShimmerStatusEffect("shimmer");
        HYPNO = registerHypnoStatusEffect("hypno");
        JaizMod.LOGGER.info("Registering Mod Effects for " + JaizMod.MOD_ID);
    }
}
