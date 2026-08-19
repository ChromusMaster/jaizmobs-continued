package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class SoulWaderEntity extends Monster implements AnimatedMob {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(SoulWaderEntity.class, EntityDataSerializers.BOOLEAN);

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public SoulWaderEntity(EntityType<? extends Monster> entityType, Level world) {

        super(entityType, world);
        this.xpReward = 25;
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
            }

    @Override
    public void tick() {
        super.tick();
        if(this.level().isClientSide()) {
            if(this.idleAnimationTimeout <= 0) {
                this.level().addParticle(ParticleTypes.SOUL, this.getX(), this.getY() + 4, this.getZ(), 0.0, 0.05, 0.0);
            }
            if(this.idleAnimationTimeout == 40) {
                this.level().addParticle(ParticleTypes.SOUL, this.getX(), this.getY() + 4, this.getZ(), 0.0, 0.05, 0.0);
            }
            setupAnimationStates();
        }
    }

    public static boolean canSpawn(EntityType<SoulWaderEntity> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return world.getBlockState(pos.below()).is(BlockTags.SOUL_SPEED_BLOCKS);
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

    public static AttributeSupplier.Builder createSoulWaderAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 60)
                .add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.ARMOR, 0.6f)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.FOLLOW_RANGE, 40)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0f)
                .add(Attributes.ATTACK_KNOCKBACK, 2);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WARDEN_AGITATED;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.CAMPFIRE_CRACKLE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WARDEN_SONIC_BOOM;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.WARDEN_HEARTBEAT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 4.0f, 1.0f);
    }

    @Override
    public AnimationState idleAnimationState() {
        return this.idleAnimationState;
    }
}
