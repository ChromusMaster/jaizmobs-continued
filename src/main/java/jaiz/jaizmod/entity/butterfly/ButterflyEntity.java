package jaiz.jaizmod.entity.butterfly;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.Bottlable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
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

public class ButterflyEntity extends Animal implements Bottlable {
    private static final EntityDataAccessor<Boolean> FROM_BOTTLE = SynchedEntityData.defineId(ButterflyEntity.class, EntityDataSerializers.BOOLEAN);

    public ButterflyEntity(EntityType<? extends Animal> entityType, Level world) {
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

    public AnimationState butterflyAnimationState = new AnimationState();
    public AnimationState idlebutterflyAnimationState = new AnimationState();
    private int butterflyAnimationTimeout = 0;

    private void setupAnimationStates() {
                if (this.butterflyAnimationTimeout <= 0) {
            this.butterflyAnimationTimeout = 10;
            if (this.onGround() && this.navigation.isDone()) {
                this.butterflyAnimationState.stop();
                this.idlebutterflyAnimationState.start(this.tickCount);
            } else {
                this.idlebutterflyAnimationState.stop();
                this.butterflyAnimationState.start(this.tickCount);
            }
        } else {
            --this.butterflyAnimationTimeout;
        }
    }


    @Override
    public void tick() {
        super.tick();

        if (this.isInWater()){
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, 0.01, 0.0));
        }

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }


    @Override
    protected void registerGoals() {
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(2, new ButterflyWanderAroundGoal());
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(ItemTags.BEE_FOOD), false));
    }
    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ItemTags.BEE_FOOD);
    }



    public static AttributeSupplier.Builder createButterflyAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.TEMPT_RANGE, 16)
                .add(Attributes.FLYING_SPEED, 0.6f);

    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob passiveEntity) {
        return ModEntities.CATERPILLAR.spawn(serverWorld, ButterflyEntity.this.blockPosition(), EntitySpawnReason.MOB_SUMMONED);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PARROT_FLY;
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

    @Override
    protected void checkFallDamage(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
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

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(ButterflyEntity.class, EntityDataSerializers.INT);

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData entityData) {
        setTexture();
        return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
    }


    public void setTexture(){
        int i = random.nextInt(100)+1;
        if(i >= 1 && i <= 30) {setVariant(ButterflyVariant.MONARCH);}
        if(i >= 31 && i <= 45) {setVariant(ButterflyVariant.WHITE_MONARCH);}
        if(i >= 46 && i <= 60) {setVariant(ButterflyVariant.YELLOW_MONARCH);}
        if(i >= 61 && i <= 70) {setVariant(ButterflyVariant.CABBAGE_MOTH);}
        if(i >= 71 && i <= 80) {setVariant(ButterflyVariant.ULYSSES);}
        if(i >= 81 && i <= 90) {setVariant(ButterflyVariant.CARINS_BIRDWING);}
        if(i >= 91 && i <= 95) {setVariant(ButterflyVariant.LUNA_MOTH);}
        if(i >= 96 && i <= 99) {setVariant(ButterflyVariant.ATLAS_MOTH);}
        if(i == 100) {setVariant(ButterflyVariant.JAMPOTT);}
    }

    public Object getVariant() {
        return ButterflyVariant.byId(this.getTypeVariant() & 255);
    }


    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(ButterflyVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    private int getButterflyVariant() {
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
        return new ItemStack(ModItems.BUTTERFLY_BOTTLE);
    }


    @Override
    public void copyDataToStack(ItemStack stack) {
        Bottlable.copyDataToStack(this, stack);
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack, nbtCompound -> nbtCompound.putInt("BottleVariantTag", this.getButterflyVariant()));
    }

    @Override
    public void copyDataFromNbt(CompoundTag nbt) {
        Bottlable.copyDataFromNbt(this, nbt);
        if (nbt.contains("BottleVariantTag")) {
            this.setVariant(ButterflyVariant.byId(nbt.getIntOr("BottleVariantTag", 0)));
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


    class ButterflyWanderAroundGoal
            extends Goal {

        ButterflyWanderAroundGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return ButterflyEntity.this.navigation.isDone() && ButterflyEntity.this.random.nextInt(10) == 1;
        }

        @Override
        public boolean canContinueToUse() {
            return ButterflyEntity.this.navigation.isInProgress();
        }

        @Override
        public void start() {
            Vec3 vec3d = this.getRandomLocation();
            if (vec3d != null) {
                ButterflyEntity.this.navigation.moveTo(ButterflyEntity.this.navigation.createPath(BlockPos.containing(vec3d), 1), 1.0);
            }
        }

        @Nullable
        private Vec3 getRandomLocation() {
            Vec3 vec3d2;
            vec3d2 = ButterflyEntity.this.getViewVector(0.0f);
            int i = 8;
            Vec3 vec3d3 = HoverRandomPos.getPos(ButterflyEntity.this, 4, 14, vec3d2.x, vec3d2.z, 1.5707964f, 3, 1);
            if (vec3d3 != null) {
                return vec3d3;
            }return AirAndWaterRandomPos.getPos(ButterflyEntity.this, 4, 8, -2, vec3d2.x, vec3d2.z, 1.5707963705062866);}

    }

}
