package net.jaiz.jaizmobs.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
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

public class StarFishLeaderEntity extends Mob implements AnimatedMob {

    public StarFishLeaderEntity(EntityType<? extends StarFishLeaderEntity> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 1;
        this.moveControl = new StarFishLeaderEntity.StarFishLeaderMoveControl(this);
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
                .add(Attributes.MAX_HEALTH, 6)
                .add(Attributes.ARMOR, 0.5f);

    }
    static class FlyRandomlyGoal
            extends Goal {
        private final StarFishLeaderEntity starfishleader;

        public FlyRandomlyGoal(StarFishLeaderEntity starfishleader) {
            this.starfishleader = starfishleader;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            double f;
            double e;
            MoveControl moveControl = this.starfishleader.getMoveControl();
            if (!moveControl.hasWanted()) {
                return true;
            }
            double d = moveControl.getWantedX() - this.starfishleader.getX();
            double g = d * d + (e = moveControl.getWantedY() - this.starfishleader.getY()) * e + (f = moveControl.getWantedZ() - this.starfishleader.getZ()) * f;
            return g < 1.0 || g > 3600.0;
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public void start() {
            RandomSource random = this.starfishleader.getRandom();
            double d = this.starfishleader.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double e = this.starfishleader.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double f = this.starfishleader.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            this.starfishleader.getMoveControl().setWantedPosition(d, e, f, 0.025);
        }
    }

    static class StarFishLeaderMoveControl
            extends MoveControl<StarFishLeaderEntity> {
        private final StarFishLeaderEntity starfishleader;
        private int collisionCheckCooldown;

        public StarFishLeaderMoveControl(StarFishLeaderEntity starfishleader) {
            super(starfishleader);
            this.starfishleader = starfishleader;
        }

        @Override
        public void tick() {
            if (this.starfishleader.getY() >= 150) {
                this.starfishleader.discard();
                return;
            }
            if (this.operation != Operation.MOVE_TO) {
                return;
            }
            if (this.collisionCheckCooldown-- <= 0) {
                this.collisionCheckCooldown += this.starfishleader.getRandom().nextInt(5) + 2;
                Vec3 vec3d = new Vec3(this.wantedX - this.starfishleader.getX(), this.wantedY - this.starfishleader.getY(), this.wantedZ - this.starfishleader.getZ());
                double d = vec3d.length();
                if (this.willCollide(vec3d = vec3d.normalize(), Mth.ceil(d))) {
                    this.starfishleader.setDeltaMovement(this.starfishleader.getDeltaMovement().add(vec3d.scale(0.1)));
                } else {
                    this.operation = Operation.WAIT;
                }
            }
            LivingEntity target = this.starfishleader.getTarget();
            if (target == null) {
                Vec3 vec3d = this.starfishleader.getDeltaMovement();
                this.starfishleader.setYRot(-((float)Mth.atan2(vec3d.x, vec3d.z)) * 57.295776f);
                this.starfishleader.yBodyRot = this.starfishleader.getYRot();
            } else if (target.distanceToSqr(this.starfishleader) < 4096.0) {
                    double e = target.getX() - this.starfishleader.getX();
                    double f = target.getZ() - this.starfishleader.getZ();
                    this.starfishleader.setYRot(-((float)Mth.atan2(e, f)) * 57.295776f);
                    this.starfishleader.yBodyRot = this.starfishleader.getYRot();
            }
        }

        private boolean willCollide(Vec3 direction, int steps) {
            AABB box = this.starfishleader.getBoundingBox();
            for (int i = 1; i < steps; ++i) {
                box = box.move(direction);
                if (this.starfishleader.level().noCollision(this.starfishleader, box)) continue;
                return false;
            }
            return true;
        }

    }

    public static boolean canSpawn(EntityType<StarFishLeaderEntity> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return StarFishLeaderEntity.checkMobSpawnRules(type, world, spawnReason, pos, random);
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
