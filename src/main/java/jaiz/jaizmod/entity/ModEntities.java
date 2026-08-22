package jaiz.jaizmod.entity;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.bandit.BanditEntity;
import jaiz.jaizmod.entity.butterfly.ButterflyEntity;
import jaiz.jaizmod.entity.caterpillar.CaterpillarEntity;
import jaiz.jaizmod.entity.dragonfly.DragonflyEntity;
import jaiz.jaizmod.entity.firefly.FireFlySwarmEntity;
import jaiz.jaizmod.entity.fruit_bat.FruitBatEntity;
import jaiz.jaizmod.entity.mason_mouth.MasonmouthEntity;
import jaiz.jaizmod.entity.snail.SnailEntity;
import jaiz.jaizmod.entity.thrown_entity.DynamiteEntity;
import jaiz.jaizmod.entity.thrown_entity.GlowballEntity;
import jaiz.jaizmod.entity.thrown_entity.GuanoEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    public static final EntityType<MasonmouthEntity> MASON_MOUTH = registerEntityType("mason_mouth",
            EntityType.Builder.of(MasonmouthEntity::new, MobCategory.MISC).sized(0.875f, 1.0f));

    public static final EntityType<BanditEntity> BANDIT = registerEntityType("bandit",
            EntityType.Builder.of(BanditEntity::new, MobCategory.MISC).sized(0.6f, 1.9f));

    public static final EntityType<DynamiteEntity> DYNAMITE = registerEntityType("dynamite",
            EntityType.Builder.<DynamiteEntity>of(DynamiteEntity::new, MobCategory.MISC).sized(0.4f, 0.4f));

    public static final EntityType<GuanoEntity> GUANO = registerEntityType("guano",
            EntityType.Builder.<GuanoEntity>of(GuanoEntity::new, MobCategory.MISC).sized(0.4f, 0.4f));

    public static final EntityType<GlowballEntity> GLOWBALL = registerEntityType("glowball",
            EntityType.Builder.<GlowballEntity>of(GlowballEntity::new, MobCategory.MISC).sized(0.4f, 0.4f));

    public static final EntityType<FruitBatEntity> FRUIT_BAT = registerEntityType("fruit_bat",
            EntityType.Builder.of(FruitBatEntity::new, MobCategory.AMBIENT).sized(0.6f, 1.0f));

    public static final EntityType<ButterflyEntity> BUTTERFLY = registerEntityType("butterfly",
        EntityType.Builder.of(ButterflyEntity::new, MobCategory.CREATURE).sized(0.6f, 0.6f));

    public static final EntityType<FireFlySwarmEntity> FIRE_FLY_SWARM = registerEntityType("fire_fly_swarm",
        EntityType.Builder.of(FireFlySwarmEntity::new, MobCategory.CREATURE).sized(1.0f, 1.0f));

    public static final EntityType<DragonflyEntity> DRAGONFLY = registerEntityType("dragonfly",
        EntityType.Builder.of(DragonflyEntity::new, MobCategory.CREATURE).sized(0.7f, 0.7f));

    public static final EntityType<CaterpillarEntity> CATERPILLAR = registerEntityType("caterpillar",
        EntityType.Builder.of(CaterpillarEntity::new, MobCategory.CREATURE).sized(0.6f, 0.4f));

    public static final EntityType<SnailEntity> SNAIL = registerEntityType("snail",
        EntityType.Builder.of(SnailEntity::new, MobCategory.CREATURE).sized(.4f, .4f));

    public static <T extends Entity> EntityType<T> registerEntityType(String path, EntityType.Builder<T> entityTypeBuilder) {
        Identifier id = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, path);
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, entityTypeBuilder.build(key));
    }
}
