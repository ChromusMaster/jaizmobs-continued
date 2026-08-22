package jaiz.jaizmod.entity.snail;


import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.Bottlable;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SnailEntity extends Animal implements Bottlable {
    private static final EntityDataAccessor<Boolean> FROM_BOTTLE = SynchedEntityData.defineId(SnailEntity.class, EntityDataSerializers.BOOLEAN);


    public SnailEntity(EntityType<? extends Animal> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(ItemTags.BEE_FOOD);
    }


    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FROM_BOTTLE, false);
    }

    @Override
    protected void registerGoals() {
        this.initCustomGoals();
    }
    protected void initCustomGoals() {
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(ItemTags.BEE_FOOD), false));

    }

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob passiveEntity) {
        return ModEntities.SNAIL.spawn(serverWorld, SnailEntity.this.blockPosition(), EntitySpawnReason.MOB_SUMMONED);
    }

    public static AttributeSupplier.Builder createSnailAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.SCALE, 1.0f)
                .add(Attributes.TEMPT_RANGE, 16)
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.MOVEMENT_SPEED, 0.1f);
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
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return Bottlable.tryBottle(player, hand, this).orElse(super.mobInteract(player, hand));
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.SLIME_BLOCK_FALL;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.HONEY_BLOCK_BREAK;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.HONEY_BLOCK_SLIDE;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15f, 1.0f);
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
    public void copyDataToStack(ItemStack stack) {
        Bottlable.copyDataToStack(this, stack);
    }

    @Override
    public void copyDataFromNbt(CompoundTag nbt) {
        Bottlable.copyDataFromNbt(this, nbt);
    }

    @Override
    public ItemStack getBottleItem() {
        return new ItemStack(ModItems.SNAIL_BOTTLE);
    }
}
