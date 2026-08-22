package jaiz.jaizmod.entity.firefly;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.ModLootTables;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class FireFlySwarmEntity extends Animal {

    private static final Ingredient FOLLOW_ITEMS = Ingredient.of(Items.TORCH, Items.SHROOMLIGHT, Items.SOUL_TORCH, Items.CAMPFIRE,
            Items.SOUL_LANTERN, Items.LANTERN, Items.REDSTONE_TORCH, Items.SOUL_CAMPFIRE, Items.GLOWSTONE, Items.GLOW_BERRIES);

    public FireFlySwarmEntity(EntityType<? extends Animal> entityType, Level world) {
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

    public AnimationState fireflyAnimationState = new AnimationState();
    private int fireflyAnimationTimeout = 0;

    private void setupAnimationStates() {
        if (this.fireflyAnimationTimeout <= 0) {
            this.fireflyAnimationTimeout = 100;
            this.fireflyAnimationState.start(this.tickCount);
        } else {
            --this.fireflyAnimationTimeout;
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
        if (FireFlySwarmEntity.this.random.nextInt(100) == 1){
            this.playSound(SoundEvents.BEE_LOOP, 0.1f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
        }

        if(this.getRandom().nextInt(50) == 0){
        int i = this.getBlockX();
        int j = this.getBlockY();
        int k = this.getBlockZ();
        double d = (double)i + random.nextDouble();
        double e = (double)j + 0.7;
        double f = (double)k + random.nextDouble();
        this.level().addParticle(JaizMod.FIREFLY_PARTICLE, d, e, f, 0.0, 0.0, 0.0);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
            mutable.set(i + Mth.nextInt(random, -10, 10), j - random.nextInt(10), k + Mth.nextInt(random, -10, 10));
            BlockState blockState = this.level().getBlockState(mutable);
            if (!blockState.isCollisionShapeFullBlock(this.level(), mutable)) {
                this.level().addParticle(
                        JaizMod.FIREFLY_PARTICLE,
                        (double)mutable.getX() + random.nextDouble(),
                        (double)mutable.getY() + random.nextDouble(),
                        (double)mutable.getZ() + random.nextDouble(),
                        0.0,
                        0.0,
                        0.0
                );
        }}
    }



    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new FireflyWanderAroundGoal());
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.5, FOLLOW_ITEMS, false));
    }

    public static AttributeSupplier.Builder createFireflyAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 15)
                .add(Attributes.TEMPT_RANGE, 16)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.FOLLOW_RANGE, 15)
                .add(Attributes.FLYING_SPEED, 0.6f);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.BEE_LOOP;
    }

    @Override
    protected float getSoundVolume() {
        return 0.2f;
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

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    protected void doPush(Entity entity) {
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (this.isFood(itemStack)) {
            int i = this.getAge();
            if (!this.level().isClientSide() && i == 0 && this.canFallInLove()) {
                this.usePlayerItem(player, hand, itemStack);
                this.setInLove(player);
                return InteractionResult.SUCCESS;
            }

            if (this.isBaby()) {
                this.usePlayerItem(player, hand, itemStack);
                this.ageUp(getSpeedUpSecondsWhenFeeding(-i), true);
                return InteractionResult.SUCCESS;
            }

            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            }
        }

        if (itemStack.is(Items.GLASS_BOTTLE) && this.entityItemDropper()) {
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            if (this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            }
            this.discard();
        }

        return super.mobInteract(player, hand);
    }

    public boolean entityItemDropper() {
            if (this.level() instanceof ServerLevel serverWorld) {
                this.spawnAtLocation(serverWorld, new ItemStack(ModItems.FIREFLY_BOTTLE));
                this.gameEvent(GameEvent.ENTITY_INTERACT);
                this.playSound(SoundEvents.BOTTLE_FILL);
            }
            return true;
    }


    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob passiveEntity) {
        return ModEntities.FIRE_FLY_SWARM.spawn(serverWorld, FireFlySwarmEntity.this.blockPosition(), EntitySpawnReason.MOB_SUMMONED);
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


    class FireflyWanderAroundGoal
            extends Goal {

        FireflyWanderAroundGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return FireFlySwarmEntity.this.navigation.isDone() && FireFlySwarmEntity.this.random.nextInt(100) == 1;
        }

        @Override
        public boolean canContinueToUse() {
            return FireFlySwarmEntity.this.navigation.isInProgress();
        }

        @Override
        public void start() {
            Vec3 vec3d = this.getRandomLocation();
            if (vec3d != null) {
                FireFlySwarmEntity.this.navigation.moveTo(FireFlySwarmEntity.this.navigation.createPath(BlockPos.containing(vec3d), 1), 0.75);
            }
        }


        @Nullable
        private Vec3 getRandomLocation() {
            Vec3 vec3d2;
            vec3d2 = FireFlySwarmEntity.this.getViewVector(0.0f);
            int i = 8;
            Vec3 vec3d3 = HoverRandomPos.getPos(FireFlySwarmEntity.this, 4, 14, vec3d2.x, vec3d2.z, 1.5707964f, 3, 1);
            if (vec3d3 != null) {
                return vec3d3;
            }return AirAndWaterRandomPos.getPos(FireFlySwarmEntity.this, 4, 8, -2, vec3d2.x, vec3d2.z, 1.5707963705062866);}

    }
}
