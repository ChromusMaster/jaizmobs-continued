package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.item.custom.ModItems;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class AeroblobEntity extends Mob implements AnimatedMob {

    public AeroblobEntity(EntityType<? extends AeroblobEntity> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 1;
        this.moveControl = new AeroblobEntity.StarFishMoveControl(this);
    }

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40);
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
        this.goalSelector.addGoal(1, new FlyRandomlyGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
    }

    public static AttributeSupplier.Builder createAeroblobAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.MOVEMENT_SPEED, 0.1f)
                .add(Attributes.FLYING_SPEED, 0.1f);

    }

    static class FlyRandomlyGoal
            extends Goal {
        private final AeroblobEntity aeroblob;

        public FlyRandomlyGoal(AeroblobEntity aeroblob) {
            this.aeroblob = aeroblob;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            double f;
            double e;
            MoveControl moveControl = this.aeroblob.getMoveControl();
            if (!moveControl.hasWanted()) {
                return true;
            }
            double d = moveControl.getWantedX() - this.aeroblob.getX();
            double g = d * d + (e = moveControl.getWantedY() - this.aeroblob.getY()) * e + (f = moveControl.getWantedZ() - this.aeroblob.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void start() {
            RandomSource random = this.aeroblob.getRandom();
            double d = this.aeroblob.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.aeroblob.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.aeroblob.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.aeroblob.getMoveControl().setWantedPosition(d, e, f, 0.035);
        }
    }

    static class StarFishMoveControl
            extends MoveControl<AeroblobEntity> {
        private final AeroblobEntity starfish;
        private int collisionCheckCooldown;

        public StarFishMoveControl(AeroblobEntity starfish) {
            super(starfish);
            this.starfish = starfish;
        }

        @Override
        public void tick() {
            if (this.operation != Operation.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.starfish.getRandom().nextInt(5) + 2;
                Vec3 vec3d = new Vec3(this.wantedX - this.starfish.getX(), this.wantedY - this.starfish.getY(), this.wantedZ - this.starfish.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), Mth.ceil(d))) {
                    this.starfish.setDeltaMovement(this.starfish.getDeltaMovement().add(vec3d.scale(0.1)));
                } else {
                    this.operation = Operation.WAIT;
                }
            }
            LivingEntity target = this.starfish.getTarget();
            if (target == null) {
                Vec3 vec3d = this.starfish.getDeltaMovement();
                this.starfish.setYRot(-((float)Mth.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.starfish.yBodyRot = this.starfish.getYRot();
            } else if (target.distanceToSqr(this.starfish) < 4096.0) {
                    double e = target.getX() - this.starfish.getX();
                    double f = target.getZ() - this.starfish.getZ();
                    this.starfish.setYRot(-((float)Mth.atan2(e, f)) * 57.295776f);
                    this.starfish.yBodyRot = this.starfish.getYRot();
            }
        }

        private boolean willCollide(Vec3 direction, int steps) {
            AABB box = this.starfish.getBoundingBox();
            for (int i = 1; i < steps; ++i) {
                box = box.move(direction);
                if (this.starfish.level().noCollision(this.starfish, box)) continue;
                return false;
            }
            return true;
        }

    }

    public static boolean canSpawn(EntityType<AeroblobEntity> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return AeroblobEntity.checkMobSpawnRules(type, world, spawnReason, pos, random);
    }

    @Override
    protected SoundEvent getAmbientSound() {

        return SoundEvents.BREEZE_IDLE_AIR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.PUFFER_FISH_BLOW_OUT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PUFFER_FISH_BLOW_UP;
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
        if ((entity = this.getFirstPassenger()) instanceof Player && (playerEntity = (Player)entity).isHolding(ModItems.STARFISH_ON_A_STICK)) {
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
        return new Vec3(0.0, -0.175, 1.0);
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
    protected float getRiddenSpeed(Player controllingPlayer) {
        return (float) (this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 2);
    }

    @Override
    public AnimationState idleAnimationState() {
        return this.idleAnimationState;
    }
}
