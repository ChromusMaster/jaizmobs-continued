package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CultivatorEntity extends Animal implements AnimatedMob {

    public AnimationState idleAnimationState = new AnimationState();
    public int seedDropTime = this.random.nextInt(6000) + 1200;
    public int beetSeedDropTime = this.random.nextInt(6000) + 1200;
    public int melonSeedDropTime = this.random.nextInt(12000) + 1200;
    public int pumpkinSeedDropTime = this.random.nextInt(12000) + 1200;

    private int idleAnimationTimeout = 0;

    public CultivatorEntity(EntityType<? extends Animal> entityType, Level world) {

        super(entityType, world);
        this.xpReward = 20;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0));

    }

    public static AttributeSupplier.Builder createCultivatorAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.ARMOR, 0.4f)
                .add(Attributes.FOLLOW_RANGE, 60)
                .add(Attributes.MOVEMENT_SPEED, 0.16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.1f);

    }

    public static boolean canSpawn(EntityType<CultivatorEntity> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return CultivatorEntity.checkMobSpawnRules(type, world, spawnReason, pos, random);
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!(this.level() instanceof ServerLevel serverLevel) || !this.isAlive() || this.isBaby()) {
            return;
        }
        if (--this.seedDropTime <= 0) {
            this.playSound(SoundEvents.LAVA_POP, 0.7f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.spawnAtLocation(serverLevel, Items.WHEAT_SEEDS);
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.seedDropTime = this.random.nextInt(6000) + 1200;
        }
        if (--this.beetSeedDropTime <= 0) {
            this.playSound(SoundEvents.LAVA_POP, 0.7f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.spawnAtLocation(serverLevel, Items.BEETROOT_SEEDS);
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.beetSeedDropTime = this.random.nextInt(6000) + 1200;
        }
        if (--this.melonSeedDropTime <= 0) {
            this.playSound(SoundEvents.LAVA_POP, 0.7f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.spawnAtLocation(serverLevel, Items.MELON_SEEDS);
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.melonSeedDropTime = this.random.nextInt(12000) + 1200;
        }
        if (--this.pumpkinSeedDropTime <= 0) {
            this.playSound(SoundEvents.LAVA_POP, 0.7f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
            this.spawnAtLocation(serverLevel, Items.PUMPKIN_SEEDS);
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.pumpkinSeedDropTime = this.random.nextInt(12000) + 1200;
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return null;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.STRIDER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SNIFFER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SNIFFER_DEATH;
    }

    @Override
    public AnimationState idleAnimationState() {
        return this.idleAnimationState;
    }
}
