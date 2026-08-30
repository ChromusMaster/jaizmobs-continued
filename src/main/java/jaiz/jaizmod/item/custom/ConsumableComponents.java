package jaiz.jaizmod.item.custom;


import static net.minecraft.world.item.component.Consumables.defaultDrink;
import static net.minecraft.world.item.component.Consumables.defaultFood;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ConsumableComponents {
    public static final Consumable RARE_SPICES = defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 200, 0), 0.5F))
            .build();
    public static final Consumable GOURMET_MEAL = defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 0.25F))
            .build();
    public static final Consumable TEA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 0), 0.1F))
            .build();

    public static final Consumable COCOON = defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 120, 0), 1.0F))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.POISON, 120, 0), 1.0F))
            .build();

    public static final Consumable WITHER_ROSE_TEA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 0), 1.0F))
            .build();
    public static final Consumable SPORE_BLOSSOM_TEA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0F))
            .build();
    public static final Consumable GLOW_BERRY_TEA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0), 1.0F))
            .build();
    public static final Consumable TORCH_FLOWER_TEA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.STRENGTH, 1200, 0), 1.0F))
            .build();
    public static final Consumable PITCHER_PLANT_TEA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.RESISTANCE, 1200, 0), 1.0F))
            .build();
    public static final Consumable NETHER_FUNGAL_TEA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0), 1.0F))
            .build();
    public static final Consumable CHORUS_TEA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.LEVITATION, 120, 0), 1.0F))
            .build();
    public static final Consumable GUARANA_SODA = defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 200, 0), 1.0F))
            .build();
}
