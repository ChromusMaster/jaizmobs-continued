package net.jaiz.jaizmobs.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public final class ModFoodComponents {
    public static final FoodProperties STAR_FISH = food(4, 0.1F);
    public static final Consumable STAR_FISH_CONSUMABLE = effect(MobEffects.LEVITATION, 50, 0.1F);
    public static final FoodProperties COOKED_STAR_FISH = food(6, 0.3F);
    public static final FoodProperties HELIUM_MEMBRANE = new FoodProperties.Builder().nutrition(1).saturationModifier(0.05F).alwaysEdible().build();
    public static final Consumable HELIUM_MEMBRANE_CONSUMABLE = effect(MobEffects.LEVITATION, 200, 1.0F);
    public static final FoodProperties HUNTER_EEL = food(3, 0.1F);
    public static final Consumable HUNTER_EEL_CONSUMABLE = effect(MobEffects.BLINDNESS, 10, 0.1F);
    public static final FoodProperties COOKED_HUNTER_EEL = food(7, 0.2F);
    public static final FoodProperties GEYSER_BERRY = food(8, 0.4F);
    public static final FoodProperties COOKED_WARPED_FUNGUS = food(5, 0.3F);
    public static final FoodProperties COOKED_CRIMSON_FUNGUS = food(5, 0.3F);
    public static final FoodProperties STRIDER_HAM = food(6, 0.6F);
    public static final Consumable STRIDER_HAM_CONSUMABLE = effect(MobEffects.FIRE_RESISTANCE, 60, 0.1F);
    public static final Consumable DEFAULT_CONSUMABLE = Consumables.defaultFood().build();

    private ModFoodComponents() {
    }

    private static FoodProperties food(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }

    private static Consumable effect(Holder<MobEffect> effect, int duration, float probability) {
        return Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(effect, duration), probability))
                .build();
    }
}
