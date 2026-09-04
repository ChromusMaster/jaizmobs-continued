package jaiz.jaizmod.entity.caterpillar;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.entity.butterfly.ButterflyEntity;
import jaiz.jaizmod.entity.butterfly.ButterflyVariant;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.Bottlable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
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
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CaterpillarEntity extends Animal implements Bottlable {
    private static final EntityDataAccessor<Boolean> FROM_BOTTLE = SynchedEntityData.defineId(CaterpillarEntity.class, EntityDataSerializers.BOOLEAN);

    public CaterpillarEntity(EntityType<? extends Animal> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 4;
    }

    public int cocoonTime = this.random.nextInt(9000) + 2000;

    @Override
    public boolean requiresCustomPersistence() {
        return super.requiresCustomPersistence() || this.isFromBottle();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        return Bottlable.tryBottle(player, hand, this).orElse(super.mobInteract(player, hand));
    }

    @Override
    public void tick() {
        if (!this.level().isClientSide() && this.isAlive() && --this.cocoonTime <= 0) {
            if (this.getInBlockState().isAir()) {
                Level world = this.level();
                this.playSound(SoundEvents.TURTLE_EGG_CRACK, 1.0f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
                this.gameEvent(GameEvent.BLOCK_PLACE);
                BlockPos blockPos2 = this.blockPosition();
                BlockState blockState = ModBlocks.COCOON_BLOCK.defaultBlockState();
                world.setBlock(blockPos2, blockState, Block.UPDATE_ALL);
                world.gameEvent(GameEvent.BLOCK_PLACE, blockPos2, GameEvent.Context.of(this, blockState));
                this.discard();
            } else if (this.entityItemDropper()) {
                this.discard();
            }
        }
        super.tick();
    }

    public boolean entityItemDropper() {
        if (this.level() instanceof ServerLevel serverWorld) {
            this.spawnAtLocation(serverWorld, new ItemStack(ModItems.COCOON_BLOCK));
            this.playSound(SoundEvents.TURTLE_EGG_CRACK, 1.0f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.0f);
        }
        return true;
    }

    @Override
    protected void registerGoals() {
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.25));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(ItemTags.BEE_FOOD), false));
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5)
                .add(Attributes.TEMPT_RANGE, 16)
                .add(Attributes.MOVEMENT_SPEED, 0.125f)
                .add(Attributes.FOLLOW_RANGE, 10);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob entity) {
        return null;
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

    private int getCaterpillarVariant() {
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
        return new ItemStack(ModItems.CATERPILLAR_BOTTLE);
    }


    @Override
    public void copyDataToStack(ItemStack stack) {
        Bottlable.copyDataToStack(this, stack);
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack, nbtCompound -> nbtCompound.putInt("BottleVariantTag", this.getCaterpillarVariant()));
    }

    @Override
    public void copyDataFromNbt(CompoundTag nbt) {
        Bottlable.copyDataFromNbt(this, nbt);
        if (nbt.contains("BottleVariantTag")) {
            this.setVariant(CaterpillarVariant.byId(nbt.getIntOr("BottleVariantTag", 0)));
        }
    }



    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(CaterpillarEntity.class, EntityDataSerializers.INT);

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData entityData) {
        CaterpillarVariant variant = Util.getRandom(CaterpillarVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
    }

    public Object getVariant() {
        return CaterpillarVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(CaterpillarVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

}
