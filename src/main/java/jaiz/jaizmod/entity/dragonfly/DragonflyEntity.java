package jaiz.jaizmod.entity.dragonfly;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.butterfly.ButterflyEntity;
import jaiz.jaizmod.entity.butterfly.ButterflyVariant;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.Bottlable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Objects;

public class DragonflyEntity extends Animal implements Bottlable {
    private static final EntityDataAccessor<Boolean> FROM_BOTTLE = SynchedEntityData.defineId(DragonflyEntity.class, EntityDataSerializers.BOOLEAN);

    public DragonflyEntity(EntityType<? extends Animal> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 4;
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.lookControl = new ButterflyLookControl(this);
        this.setPathfindingMalus(PathType.FIRE_IN_NEIGHBOR, -1.0f);
        this.setPathfindingMalus(PathType.WATER, -1.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 16.0f);
        this.setPathfindingMalus(PathType.COCOA, -1.0f);
        this.setPathfindingMalus(PathType.FENCE, -1.0f);
    }

    @Override
    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.isFromBottle();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return Bottlable.tryBottle(player, hand, this).orElse(super.mobInteract(player, hand));
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        if (world.getBlockState(pos).isAir()) {
            return 10.0f;
        }
        return 0.0f;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ItemTags.BEE_FOOD);
    }

    public AnimationState dragonflyAnimationState = new AnimationState();
    private int dragonflyAnimationTimeout = 0;

    private void setupAnimationStates() {
        if (this.onGround() && this.navigation.isDone()) {
            this.dragonflyAnimationState.stop();
        }
        if (this.dragonflyAnimationTimeout <= 0) {
            this.dragonflyAnimationTimeout = 10;
            if (this.onGround() && this.navigation.isDone()) {
                this.dragonflyAnimationState.stop();
            } else {
                this.dragonflyAnimationState.start(this.tickCount);
            }
        } else {
            --this.dragonflyAnimationTimeout;
        }
    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob passiveEntity) {
        return ModEntities.DRAGONFLY.spawn(serverWorld, DragonflyEntity.this.blockPosition(), EntitySpawnReason.MOB_SUMMONED);
    }

    @Override
    protected void registerGoals() {

        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(3, new DragonflyWanderAroundGoal());
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(ItemTags.BEE_FOOD), false));
    }


    public static AttributeSupplier.Builder createDragonflyAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.TEMPT_RANGE, 16)
                .add(Attributes.MAX_HEALTH, 8)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.FOLLOW_RANGE, 10)
                .add(Attributes.SCALE, 1.0f)
                .add(Attributes.FLYING_SPEED, 0.6f);
    }

    @Override
    protected void ageBoundaryReached() {
        if (!this.isBaby() && this.isPassenger() && this.getVehicle() instanceof AbstractBoat abstractBoatEntity && !abstractBoatEntity.hasEnoughSpaceFor(this)) {
            this.stopRiding();
        }
        if(this.isBaby()){
            Objects.requireNonNull(this.getAttribute(Attributes.SCALE)).setBaseValue(0.5);
        } else {
            Objects.requireNonNull(this.getAttribute(Attributes.SCALE)).setBaseValue(1.0);
        }
    }

    @Override
    protected PathNavigation createNavigation(Level world) {
        FlyingPathNavigation birdNavigation = new FlyingPathNavigation(this, world) {

            @Override
            public boolean isStableDestination(BlockPos pos) {
                return !this.level.getBlockState(pos.below()).isAir();
            }

            @Override
            public void tick() {
                super.tick();
            }
        };
        birdNavigation.setCanOpenDoors(false);
        birdNavigation.setCanFloat(false);
        birdNavigation.setCanOpenDoors(true);
        return birdNavigation;
    }

    public boolean isFlying() {
        return !this.onGround();
    }

    public void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putBoolean("FromBottle", this.isFromBottle());
        output.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.setFromBottle(input.getBooleanOr("FromBottle", false));
        this.entityData.set(DATA_ID_TYPE_VARIANT, input.getIntOr("Variant", 0));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FROM_BOTTLE, false);
        builder.define(DATA_ID_TYPE_VARIANT, 0);
    }

    @Override
    protected void checkFallDamage(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
    }

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(DragonflyEntity.class, EntityDataSerializers.INT);

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData entityData) {
        DragonflyVariant variant = Util.getRandom(DragonflyVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
    }

    public Object getVariant() {
        return DragonflyVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(DragonflyVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    private int getDragonflyVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public boolean isFromBottle() {
        return this.entityData.get(FROM_BOTTLE);
    }

    @Override
    public void setFromBottle(boolean fromBottle) {
        this.entityData.set(FROM_BOTTLE, fromBottle);
    }

    @Override
    public ItemStack getBottleItem() {
        return new ItemStack(ModItems.DRAGONFLY_BOTTLE);
    }


    @Override
    public void copyDataToStack(ItemStack stack) {
        Bottlable.copyDataToStack(this, stack);
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack, nbtCompound -> nbtCompound.putInt("BottleVariantTag", this.getDragonflyVariant()));
    }

    @Override
    public void copyDataFromNbt(CompoundTag nbt) {
        Bottlable.copyDataFromNbt(this, nbt);
        if (nbt.contains("BottleVariantTag")) {
            this.setVariant(DragonflyVariant.byId(nbt.getIntOr("BottleVariantTag", 0)));
        }
    }




    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            setupAnimationStates();
        }

        if (this.isInWater()){
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.01, 0.0));
        }

        if (DragonflyEntity.this.random.nextInt(100) == 1 && this.isFlying()){
            this.playSound(SoundEvents.BEE_LOOP, 0.3f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 0.8f);
        }

    }

    static class ButterflyLookControl
            extends LookControl {
        ButterflyLookControl(Mob entity) {
            super(entity);
        }

        @Override
        public void tick() {
            super.tick();
        }

    }


    class DragonflyWanderAroundGoal
            extends Goal {

        DragonflyWanderAroundGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return DragonflyEntity.this.navigation.isDone() && DragonflyEntity.this.random.nextInt(20) == 1;
        }

        @Override
        public boolean canContinueToUse() {
            return DragonflyEntity.this.navigation.isInProgress();
        }

        @Override
        public void start() {
            Vec3 vec3d = this.getRandomLocation();
            if (vec3d != null) {
                DragonflyEntity.this.navigation.moveTo(DragonflyEntity.this.navigation.createPath(BlockPos.containing(vec3d), 1), 1.0);
            }
        }

        @Nullable
        private Vec3 getRandomLocation() {
            Vec3 vec3d2;
            vec3d2 = DragonflyEntity.this.getViewVector(0.0f);
            int i = 8;
            Vec3 vec3d3 = HoverRandomPos.getPos(DragonflyEntity.this, 4, 14, vec3d2.x, vec3d2.z, 1.5707964f, 3, 1);
            if (vec3d3 != null) {
                return vec3d3;
            }return AirAndWaterRandomPos.getPos(DragonflyEntity.this, 4, 8, -2, vec3d2.x, vec3d2.z, 1.5707963705062866);}

    }

}
