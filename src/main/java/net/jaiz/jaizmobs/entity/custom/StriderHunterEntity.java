package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.entity.ai.PineGiantAttackGoal;
import net.jaiz.jaizmobs.entity.ai.StriderHunterAttackGoal;
import net.jaiz.jaizmobs.entity.ai.TotemSpiritAttackGoal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.tags.FluidTags;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelReader;

public class StriderHunterEntity extends Monster implements AttackingMob {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(StriderHunterEntity.class, EntityDataSerializers.BOOLEAN);

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public StriderHunterEntity(EntityType<? extends Monster> entityType, Level world) {

        super(entityType, world);
        this.xpReward = 20;
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FIRE_IN_NEIGHBOR, 0.0f);
        this.setPathfindingMalus(PathType.FIRE, 0.0f);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking()  && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 20;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()) {
            attackAnimationState.stop();
        }

    }

    @Override
    public void tick() {
        super.tick();
        this.updateFloating();
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

    private void updateFloating() {
        if (this.isInLava()) {
            if (this.level().getFluidState(this.blockPosition().above()).is(FluidTags.LAVA)) {
                this.setDeltaMovement(this.getDeltaMovement().scale(0.5).add(0.0, 0.05, 0.0));
            } else {
                this.setOnGround(true);
            }
        }
    }

    @Override
    public boolean canStandOnFluid(FluidState state) {
        return state.is(FluidTags.LAVA);
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(1, new StriderHunterAttackGoal(this, 1D, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal (this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal (this, Strider.class, true));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal (this, IronGolem.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal (this, SnowGolem.class, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0, 60));

    }

    public static AttributeSupplier.Builder createStriderHunterAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 60)
                .add(Attributes.MOVEMENT_SPEED, 0.18f)
                .add(Attributes.ARMOR, 0.4f)
                .add(Attributes.ATTACK_DAMAGE, 8)
                .add(Attributes.FOLLOW_RANGE, 40)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2f);

    }

    @Override
    public boolean isSensitiveToWater() {
        return true;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        if (world.getBlockState(pos).getFluidState().is(FluidTags.LAVA)) {
            return 10.0f;
        }
        return this.isInLava() ? Float.NEGATIVE_INFINITY : 0.0f;
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACKING, false);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.STRIDER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.STRIDER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_ROAR;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.STRIDER_STEP_LAVA;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15f, 1.0f);
    }

    @Override
    public AnimationState idleAnimationState() {
        return this.idleAnimationState;
    }

    @Override
    public AnimationState attackAnimationState() {
        return this.attackAnimationState;
    }
}
