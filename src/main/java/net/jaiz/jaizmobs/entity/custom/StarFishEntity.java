package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import java.util.EnumSet;

public class StarFishEntity extends Mob implements AnimatedMob {

    public StarFishEntity(EntityType<? extends StarFishEntity> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 1;
        this.moveControl = new StarFishEntity.StarFishMoveControl(this);
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

    public static AttributeSupplier.Builder createStarFishAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 2)
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.ARMOR, 0.5f);

    }
    static class FlyRandomlyGoal
            extends Goal {
        private final StarFishEntity starfish;

        public FlyRandomlyGoal(StarFishEntity starfish) {
            this.starfish = starfish;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            double f;
            double e;
            MoveControl moveControl = this.starfish.getMoveControl();
            if (!moveControl.hasWanted()) {
                return true;
            }
            double d = moveControl.getWantedX() - this.starfish.getX();
            double g = d * d + (e = moveControl.getWantedY() - this.starfish.getY()) * e + (f = moveControl.getWantedZ() - this.starfish.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void start() {
            RandomSource random = this.starfish.getRandom();
            double d = this.starfish.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.starfish.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.starfish.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.starfish.getMoveControl().setWantedPosition(d, e, f, 0.035);
        }
    }

    static class StarFishMoveControl
            extends MoveControl {
        private final StarFishEntity starfish;
        private int collisionCheckCooldown;

        public StarFishMoveControl(StarFishEntity starfish) {
            super(starfish);
            this.starfish = starfish;
        }

        @Override
        public void tick() {
            if (this.starfish.getY() >= 150) {
                this.starfish.discard();
                return;
            }
            if (this.operation != MoveControl.Operation.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.starfish.getRandom().nextInt(5) + 2;
                Vec3 vec3d = new Vec3(this.wantedX - this.starfish.getX(), this.wantedY - this.starfish.getY(), this.wantedZ - this.starfish.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), Mth.ceil(d))) {
                    this.starfish.setDeltaMovement(this.starfish.getDeltaMovement().add(vec3d.scale(0.1)));
                } else {
                    this.operation = MoveControl.Operation.WAIT;
                }
            }
            if (this.starfish.getTarget() == null) {
                Vec3 vec3d = this.starfish.getDeltaMovement();
                this.starfish.setYRot(-((float)Mth.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.starfish.yBodyRot = this.starfish.getYRot();
            } else {
                LivingEntity livingEntity = this.starfish.getTarget();
                double d = 64.0;
                if (livingEntity.distanceToSqr(this.starfish) < 4096.0) {
                    double e = livingEntity.getX() - this.starfish.getX();
                    double f = livingEntity.getZ() - this.starfish.getZ();
                    this.starfish.setYRot(-((float)Mth.atan2(e, f)) * 57.295776f);
                    this.starfish.yBodyRot = this.starfish.getYRot();
                }
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

    public static boolean canSpawn(EntityType<StarFishEntity> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return StarFishEntity.checkMobSpawnRules(type, world, spawnReason, pos, random);
    }

    @Override
    protected SoundEvent getAmbientSound() {

        return SoundEvents.BUBBLE_COLUMN_BUBBLE_POP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.COD_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public AnimationState idleAnimationState() {
        return this.idleAnimationState;
    }
}
