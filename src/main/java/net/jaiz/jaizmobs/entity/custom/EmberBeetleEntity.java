package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.pathfinder.PathType;
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

public class EmberBeetleEntity extends Mob implements AnimatedMob {

    public EmberBeetleEntity(EntityType<? extends EmberBeetleEntity> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 1;
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.moveControl = new EmberBeetleEntity.EmberBeetleMoveControl(this);
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
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FlyRandomlyGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
    }

    public static AttributeSupplier.Builder createEmberBeetleAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4)
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.ARMOR, 2.0f);

    }
    static class FlyRandomlyGoal
            extends Goal {
        private final EmberBeetleEntity emberBeetle;

        public FlyRandomlyGoal(EmberBeetleEntity emberbeetle) {
            this.emberBeetle = emberbeetle;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            double f;
            double e;
            MoveControl moveControl = this.emberBeetle.getMoveControl();
            if (!moveControl.hasWanted()) {
                return true;
            }
            double d = moveControl.getWantedX() - this.emberBeetle.getX();
            double g = d * d + (e = moveControl.getWantedY() - this.emberBeetle.getY()) * e + (f = moveControl.getWantedZ() - this.emberBeetle.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void start() {
            RandomSource random = this.emberBeetle.getRandom();
            double d = this.emberBeetle.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.emberBeetle.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.emberBeetle.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.emberBeetle.getMoveControl().setWantedPosition(d, e, f, 0.035);
        }
    }

    static class EmberBeetleMoveControl
            extends MoveControl {
        private final EmberBeetleEntity emberBeetle;
        private int collisionCheckCooldown;

        public EmberBeetleMoveControl(EmberBeetleEntity emberbeetle) {
            super(emberbeetle);
            this.emberBeetle = emberbeetle;
        }

        @Override
        public void tick() {
            if (this.operation != Operation.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.emberBeetle.getRandom().nextInt(5) + 2;
                Vec3 vec3d = new Vec3(this.wantedX - this.emberBeetle.getX(), this.wantedY - this.emberBeetle.getY(), this.wantedZ - this.emberBeetle.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), Mth.ceil(d))) {
                    this.emberBeetle.setDeltaMovement(this.emberBeetle.getDeltaMovement().add(vec3d.scale(0.1)));
                } else {
                    this.operation = Operation.WAIT;
                }
            }
            if (this.emberBeetle.getTarget() == null) {
                Vec3 vec3d = this.emberBeetle.getDeltaMovement();
                this.emberBeetle.setYRot(-((float)Mth.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.emberBeetle.yBodyRot = this.emberBeetle.getYRot();
            } else {
                LivingEntity livingEntity = this.emberBeetle.getTarget();
                double d = 64.0;
                if (livingEntity.distanceToSqr(this.emberBeetle) < 4096.0) {
                    double e = livingEntity.getX() - this.emberBeetle.getX();
                    double f = livingEntity.getZ() - this.emberBeetle.getZ();
                    this.emberBeetle.setYRot(-((float)Mth.atan2(e, f)) * 57.295776f);
                    this.emberBeetle.yBodyRot = this.emberBeetle.getYRot();
                }
            }
        }

        private boolean willCollide(Vec3 direction, int steps) {
            AABB box = this.emberBeetle.getBoundingBox();
            for (int i = 1; i < steps; ++i) {
                box = box.move(direction);
                if (this.emberBeetle.level().noCollision(this.emberBeetle, box)) continue;
                return false;
            }
            return true;
        }

    }

    public static boolean canSpawn(EntityType<EmberBeetleEntity> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return EmberBeetleEntity.checkMobSpawnRules(type, world, spawnReason, pos, random);
    }

    @Override
    protected SoundEvent getAmbientSound() {

        return SoundEvents.BEE_LOOP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BEE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BEE_DEATH;
    }

    @Override
    public AnimationState idleAnimationState() {
        return this.idleAnimationState;
    }
}
