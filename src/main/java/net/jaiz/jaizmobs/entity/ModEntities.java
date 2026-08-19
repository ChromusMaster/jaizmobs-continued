package net.jaiz.jaizmobs.entity;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public final class ModEntities {
    public static final EntityType<TotemSpiritEntity> TOTEM_SPIRIT = register("totem_spirit", TotemSpiritEntity::new, MobCategory.MONSTER, 0.6f, 2.0f);
    public static final EntityType<TotemSpiritEntity> DESERT_TOTEM_SPIRIT = register("desert_totem_spirit", TotemSpiritEntity::new, MobCategory.MONSTER, 0.6f, 2.0f);
    public static final EntityType<TotemSpiritEntity> JUNGLE_TOTEM_SPIRIT = register("jungle_totem_spirit", TotemSpiritEntity::new, MobCategory.MONSTER, 0.6f, 2.0f);
    public static final EntityType<FrostedTotemSpiritEntity> FROSTED_TOTEM_SPIRIT = register("frosted_totem_spirit", FrostedTotemSpiritEntity::new, MobCategory.MONSTER, 0.6f, 2.0f);
    public static final EntityType<SporeTrapEntity> SPORETRAP = register("sporetrap", SporeTrapEntity::new, MobCategory.MONSTER, 0.4f, 0.8f);
    public static final EntityType<VoidBullEntity> VOIDBULL = register("voidbull", VoidBullEntity::new, MobCategory.MONSTER, 1.5f, 1.6f);
    public static final EntityType<StarFishEntity> STARFISH = register("starfish", StarFishEntity::new, MobCategory.CREATURE, 0.6f, 0.6f);
    public static final EntityType<StarFishLeaderEntity> STARFISHLEADER = register("starfishleader", StarFishLeaderEntity::new, MobCategory.CREATURE, 0.7f, 0.7f);
    public static final EntityType<PineGiantEntity> PINE_GIANT = register("pine_giant", PineGiantEntity::new, MobCategory.MONSTER, 0.9f, 4.0f);
    public static final EntityType<DripletEntity> DRIPLET = register("driplet", DripletEntity::new, MobCategory.MONSTER, 0.5f, 0.8f);
    public static final EntityType<StalagtitanEntity> STALAGTITAN = register("stalagtitan", StalagtitanEntity::new, MobCategory.MONSTER, 0.8f, 3.3f);
    public static final EntityType<SnailEntity> SNAIL = register("snail", SnailEntity::new, MobCategory.CREATURE, 0.4f, 0.4f);
    public static final EntityType<CalciteGolemEntity> CALCITE_GOLEM = register("calcite_golem", CalciteGolemEntity::new, MobCategory.CREATURE, 0.6f, 1.0f);
    public static final EntityType<CultivatorEntity> CULTIVATOR = register("cultivator", CultivatorEntity::new, MobCategory.CREATURE, 1.6f, 1.5f);
    public static final EntityType<KlephtopodEntity> KLEPHTOPOD = register("klephtopod", KlephtopodEntity::new, MobCategory.WATER_CREATURE, 1.0f, 0.7f);
    public static final EntityType<HunterEelEntity> HUNTER_EEL = register("hunter_eel", HunterEelEntity::new, MobCategory.WATER_CREATURE, 0.8f, 0.5f);
    public static final EntityType<AeroblobEntity> AEROBLOB = register("aeroblob", AeroblobEntity::new, MobCategory.MONSTER, 1.7f, 1.8f);
    public static final EntityType<EnderwingEntity> ENDERWING = register("enderwing", EnderwingEntity::new, MobCategory.MONSTER, 1.5f, 0.6f);
    public static final EntityType<MolotovGolemEntity> MOLOTOV_GOLEM = registerFireImmune("molotov_golem", MolotovGolemEntity::new, MobCategory.MONSTER, 0.9f, 1.7f);
    public static final EntityType<GeyserBerryEntity> GEYSER_BERRY = registerFireImmune("geyser_berry", GeyserBerryEntity::new, MobCategory.MONSTER, 0.5f, 0.5f);
    public static final EntityType<WarpedTrufflerEntity> WARPED_TRUFFLER = registerFireImmune("warped_truffler", WarpedTrufflerEntity::new, MobCategory.MONSTER, 0.6f, 0.9f);
    public static final EntityType<CrimsonTrufflerEntity> CRIMSON_TRUFFLER = registerFireImmune("crimson_truffler", CrimsonTrufflerEntity::new, MobCategory.MONSTER, 0.6f, 0.7f);
    public static final EntityType<EmberBeetleEntity> EMBERBEETLE = registerFireImmune("ember_beetle", EmberBeetleEntity::new, MobCategory.MONSTER, 0.6f, 0.6f);
    public static final EntityType<SoulWaderEntity> SOULWADER = registerFireImmune("soulwader", SoulWaderEntity::new, MobCategory.MONSTER, 1.5f, 7.0f);
    public static final EntityType<StriderHunterEntity> STRIDER_HUNTER = registerFireImmune("strider_hunter", StriderHunterEntity::new, MobCategory.MONSTER, 1.8f, 1.6f);

    private ModEntities() {
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height) {
        return register(name, factory, category, width, height, false);
    }

    private static <T extends Entity> EntityType<T> registerFireImmune(String name, EntityType.EntityFactory<T> factory,
                                                                       MobCategory category, float width, float height) {
        return register(name, factory, category, width, height, true);
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType.EntityFactory<T> factory,
                                                             MobCategory category, float width, float height,
                                                             boolean fireImmune) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, name));
        EntityType.Builder<T> builder = EntityType.Builder.of(factory, category).sized(width, height);
        if (fireImmune) {
            builder.fireImmune();
        }
        EntityType<T> entityType = builder.build(key);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, entityType);
    }
}
