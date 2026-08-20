package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.entity.ai.KlephtopodAttackGoal;
import net.jaiz.jaizmobs.item.custom.ModItems;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.zombie.Drowned;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.fish.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class KlephtopodEntity extends WaterAnimal implements AttackingMob {

    private static final Ingredient ATTRACTING_INGREDIENT = Ingredient.of(ModItems.HUNTER_EEL, ModItems.COOKED_HUNTER_EEL, ModItems.EEL_ON_A_STICK);
    @Nullable
    private TemptGoal temptGoal;

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(KlephtopodEntity.class, EntityDataSerializers.BOOLEAN);

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public KlephtopodEntity(EntityType<? extends WaterAnimal > entityType, Level world) {

        super(entityType, world);
        this.moveControl = new SmoothSwimmingMoveControl<>(this, 85, 10, 0.022f, 0.1f, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.xpReward = 20;
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
        if(this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0, 10));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1.0, 10));
        this.goalSelector.addGoal(1, new KlephtopodAttackGoal(this, 1d, false));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.temptGoal = new TemptGoal(this, 1.4, ATTRACTING_INGREDIENT, false);
        this.goalSelector.addGoal(3, this.temptGoal);
        this.goalSelector.addGoal(6, new FollowPlayerRiddenEntityGoal(this, AbstractBoat.class));
        this.targetSelector.addGoal(5, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, HunterEelEntity.class, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, Drowned.class, true));

    }

    public static AttributeSupplier.Builder createKlephtopodAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40)
                .add(Attributes.TEMPT_RANGE, 10)
                .add(Attributes.MOVEMENT_SPEED, 1.2f)
                .add(Attributes.ARMOR, 2.6f)
                .add(Attributes.ATTACK_DAMAGE, 5)
                .add(Attributes.FOLLOW_RANGE, 40);

    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        return new WaterBoundPathNavigation(this, world);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!player.isSecondaryUseActive()) {
            if (!this.level().isClientSide()) {
                player.startRiding(this);
            }
            return this.level().isClientSide() ? InteractionResult.SUCCESS : InteractionResult.SUCCESS_SERVER;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    public boolean canBeAffected(MobEffectInstance effect) {
        if (effect.getEffect() == MobEffects.POISON) {
            return effect.getEffect() == MobEffects.REGENERATION;
        }
        return super.canBeAffected(effect);
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
        return SoundEvents.TURTLE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.TURTLE_DEATH;
    }

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.DOLPHIN_SWIM;
    }

    public static boolean canSpawn(EntityType<? extends WaterAnimal> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return KlephtopodEntity.checkMobSpawnRules(type, world, spawnReason, pos, random);
    }

    @Override
    public void aiStep() {
        if (!this.isInWater() && this.onGround() && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0f - 0.5f) * 0.05f, 0.4f, (this.random.nextFloat() * 2.0f - 0.5f) * 0.05f));
            this.setOnGround(false);
            this.hurtMarked = true;
            this.playSound(SoundEvents.GENERIC_SMALL_FALL, 0.5f, 1);
        }
        super.aiStep();
    }

    @Override
    public void travel(Vec3 movementInput) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), movementInput);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
    }

    @Override
    @Nullable
    public LivingEntity getControllingPassenger() {
        Player playerEntity;
        Entity entity;
        if ((entity = this.getFirstPassenger()) instanceof Player && (playerEntity = (Player)entity).isHolding(ModItems.EEL_ON_A_STICK)) {
            return playerEntity;

        }
        return super.getControllingPassenger();
    }

    @Override
    protected void tickRidden(Player controllingPlayer, Vec3 movementInput) {
        this.setRot(controllingPlayer.getYRot(), controllingPlayer.getXRot() * 0.5f);
        this.yBodyRot = this.yHeadRot = this.getYRot();
        this.yRotO = this.yHeadRot;
        super.tickRidden(controllingPlayer, movementInput);
    }

    @Override
    protected Vec3 getRiddenInput(Player controllingPlayer, Vec3 movementInput) {
        if (this.isInWater()) {
            this.moveRelative(this.getSpeed(), movementInput);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
        return new Vec3(0.0, controllingPlayer.getXRot() * -10, 10.0);
    }

    @Override
    protected float getRiddenSpeed(Player controllingPlayer) {
        if(isInWater()) {
            return (float) (this.getAttributeValue(Attributes.MOVEMENT_SPEED) / 5);
        } else {
            return (float) (this.getAttributeValue(Attributes.MOVEMENT_SPEED) / 32);
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
