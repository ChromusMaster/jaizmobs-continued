package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.entity.ai.MolotovGolemAttackGoal;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.EnumSet;

public class MolotovGolemEntity extends Monster implements AttackingMob {

    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(MolotovGolemEntity.class, EntityDataSerializers.BOOLEAN);

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public MolotovGolemEntity(EntityType<? extends Monster> entityType, Level world) {

        super(entityType, world);
        this.xpReward = 7;
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
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
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
        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
        super.tick();
    }

    public static boolean canSpawn(EntityType<MolotovGolemEntity> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return MolotovGolemEntity.checkMobSpawnRules(type, world, spawnReason, pos, random);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(7, new MolotovGolemEntity.LookAtTargetGoal(this));
        this.goalSelector.addGoal(1, new MolotovGolemAttackGoal(this, 1, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0));

    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    public static AttributeSupplier.Builder createMoltovGolemAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 26)
                .add(Attributes.MOVEMENT_SPEED, 0.16f)
                .add(Attributes.ARMOR, 0.2f)
                .add(Attributes.ATTACK_DAMAGE, 14)
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2f)
                .add(Attributes.ATTACK_KNOCKBACK, 0.2);

    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking()
    {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACKING, false);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.LAVA_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BASALT_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.BASALT_STEP;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15f, 1.0f);
    }

    static class LookAtTargetGoal
            extends Goal {
        private final MolotovGolemEntity molotov_golem;

        public LookAtTargetGoal(MolotovGolemEntity molotov_golem) {
            this.molotov_golem = molotov_golem;
            this.setFlags(EnumSet.of(Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            LivingEntity target = this.molotov_golem.getTarget();
            if (target == null) {
                Vec3 vec3d = this.molotov_golem.getDeltaMovement();
                this.molotov_golem.setYRot(-((float) Mth.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.molotov_golem.yBodyRot = this.molotov_golem.getYRot();
            } else if (target.distanceToSqr(this.molotov_golem) < 4096.0) {
                    double e = target.getX() - this.molotov_golem.getX();
                    double f = target.getZ() - this.molotov_golem.getZ();
                    this.molotov_golem.setYRot(-((float)Mth.atan2(e, f)) * 57.295776f);
                    this.molotov_golem.yBodyRot = this.molotov_golem.getYRot();
            }
        }
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
