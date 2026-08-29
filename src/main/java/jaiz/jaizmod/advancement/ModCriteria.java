package jaiz.jaizmod.advancement;

import jaiz.jaizmod.JaizMod;
import net.minecraft.advancements.triggers.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public final class ModCriteria {
    public static final SimpleEventCriterion COCOON_HATCHED = register("cocoon_hatched", new SimpleEventCriterion());
    public static final SimpleEventCriterion GUANO_LANDED = register("guano_landed", new SimpleEventCriterion());
    public static final SimpleEventCriterion HORN_USED = register("horn_used", new SimpleEventCriterion());
    public static final SimpleEventCriterion VOID_ARMOR_WORN = register("void_armor_worn", new SimpleEventCriterion());
    public static final SimpleEventCriterion KLEPHTOPOD_ARMOR_WORN = register("klephtopod_armor_worn", new SimpleEventCriterion());

    private ModCriteria() {
    }

    private static <T extends CriterionTrigger<?>> T register(String name, T criterion) {
        return Registry.register(BuiltInRegistries.TRIGGER_TYPES,
                Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name), criterion);
    }

    public static void init() {
    }
}
