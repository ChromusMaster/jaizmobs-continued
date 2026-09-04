package jaiz.jaizmod.entity.bandit;

import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.util.ModLootTables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Util;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BanditEntity extends Monster {


    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(BanditEntity.class, EntityDataSerializers.BOOLEAN);

    private int peacefulTime = 0;

    public int attackAnimationTimeout = 0;

    public int tradeAnimationTimeout = 0;

    public AnimationState tradeAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();

    public BanditEntity(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
        this.xpReward = 16;
    }

    private ResourceKey<LootTable> getBanditLootTable() {
        return ModLootTables.BANDIT_TRADES_GAMEPLAY;
    }

    private List<ItemStack> getBanditTrades(BanditEntity bandit, ServerLevel serverWorld) {
            LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(getBanditLootTable());
            LootParams lootContextParameterSet = new LootParams.Builder(serverWorld)
                    .withParameter(LootContextParams.ORIGIN, bandit.position())
                    .withParameter(LootContextParams.THIS_ENTITY, bandit)
                    .create(LootContextParamSets.GIFT);
            return lootTable.getRandomItems(lootContextParameterSet);
    }

    private void TradingItemDropper(BanditEntity bandit, LivingEntity recipient) {
        for (int i = 0; i < bandit.getRandom().nextInt(9) + 3; i++) {
            bandit.level().addParticle(ParticleTypes.HAPPY_VILLAGER,
                    bandit.getRandomX(1.2),
                    bandit.getRandomY(),
                    bandit.getRandomZ(1.2), 0.0, 0.0, 0.0);
        }
        bandit.playSound(SoundEvents.ITEM_PICKUP, 0.7F, (bandit.getRandom().nextFloat() - bandit.getRandom().nextFloat()) * 0.2F + 1.0F);


        if (level() instanceof ServerLevel serverWorld) {
            for (ItemStack itemStack : this.getBanditTrades(bandit, serverWorld)) {
                BehaviorUtils.throwItem(bandit, itemStack, recipient.position());
            }

        }
    }

    @Override
    public void checkDespawn() {
        if (this.level().getDifficulty() == Difficulty.PEACEFUL && !this.getType().isAllowedInPeaceful()) {
            this.discard();
            return;
        }
        this.noActionTime = 0;
    }

    private void setupAnimationStates() {

        if (this.tradeAnimationTimeout == 0) {
            tradeAnimationState.stop();
        } else {
            --this.tradeAnimationTimeout;
        }

        if(this.isAggressive()  && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 20;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAggressive()) {
            attackAnimationState.stop();
        }

    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if(peacefulTime <= 0){
        if (itemStack.is(ModItems.RARE_SPICES)) {
            peacefulTime =this.random.nextInt(1200) + 900;
            this.tradeAnimationState.start(this.tickCount);
            this.tradeAnimationTimeout = 8;
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
            this.playSound(ModSounds.BANDIT_TRADE,1.0f, 1.0f);
            this.TradingItemDropper(this, player);
            return InteractionResult.SUCCESS;
            }
            else {
            return InteractionResult.FAIL;
            }
        }
        else if (itemStack.is(ModItems.RARE_SPICES)){
            this.playSound(ModSounds.BANDIT_TRADE_FAIL,1.0f, 1.0f);
            for (int i = 0; i < this.getRandom().nextInt(9) + 3; i++) {
                this.level().addParticle(ParticleTypes.ANGRY_VILLAGER,
                        this.getRandomX(1.2),
                        this.getRandomY(),
                        this.getRandomZ(1.2), 0.0, 0.0, 0.0);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void tick() {
        super.tick();
        peacefulTime--;

        if (this.getTarget() != null) {
            if (this.getTarget().isAlwaysTicking() && isPeaceful()) {
                this.setTarget(null);
            }
        }

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new FleeGoal<>(this, Player.class, 12.0F, 1.4, 1.6));
        this.goalSelector.addGoal(2, new BanditAttackGoal(this, 1d, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, AbstractIllager.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Vex.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
    }

    static class FleeGoal<T extends LivingEntity> extends AvoidEntityGoal<T> {
        private final BanditEntity bandit;

        public FleeGoal(BanditEntity bandit, Class<T> fleeFromType, float distance, double slowSpeed, double fastSpeed) {
            super(bandit, fleeFromType, distance, slowSpeed, fastSpeed);
            this.bandit = bandit;
        }

        @Override
        public boolean canUse() {
            if(bandit.getTarget() != null){
            return bandit.getTarget().getMainHandItem().is(ModItems.MACUAHUITL)
                    && bandit.getTarget().isUsingItem()
                    && bandit.getTarget().getOffhandItem().is(Items.SHIELD)
                    && super.canUse();
            }
            return false;
        }
    }


    public static AttributeSupplier.Builder createBanditAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.SCALE, 0.925f)
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.25f)
                .add(Attributes.ARMOR, 0.3f)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.5f)
                .add(Attributes.ATTACK_KNOCKBACK, 2.5);
    }

    public void setAggressive(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAggressive() {
        return this.entityData.get(ATTACKING);
    }

    public boolean isPeaceful() {
        return peacefulTime >= 0;
    }


    public void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.entityData.set(DATA_ID_TYPE_VARIANT, input.getIntOr("Variant", 0));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE_VARIANT, 0);
        builder.define(ATTACKING, false);
    }

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(BanditEntity.class, EntityDataSerializers.INT);

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData entityData) {
        BanditVariant variant = Util.getRandom(BanditVariant.values(), this.random);
        setVariant(variant);
        this.populateDefaultEquipmentSlots(random, difficulty);
        return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
    }

    public Object getVariant() {
        return BanditVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(BanditVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }




    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.BANDIT_IDLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BANDIT_DAMAGE;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BANDIT_DEATH;
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance localDifficulty) {
        super.populateDefaultEquipmentSlots(random, localDifficulty);
        if (random.nextFloat() < (this.level().getDifficulty() == Difficulty.HARD ? 0.09F : 0.05F)) {
            int i = random.nextInt(60);
            if (i < 3) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
            } else if(i < 6) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
            } else if(i < 9) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.OBSIDIAN_DAGGER));
            }else if(i < 12) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
            }else if(i < 15) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.OBSIDIAN_SWORD));
            }else if(i < 18) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SHARP_WEDGE_OBSIDIAN_SWORD));
            }else if(i < 21) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.WEDGE_OBSIDIAN_DAGGER));
            }else if(i < 24) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.WEDGE_OBSIDIAN_SWORD));
            }else if(i < 27) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.WEDGE_REGULAR_OBSIDIAN_SWORD));
            }else if(i < 30) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SHARP_OBSIDIAN_DAGGER));
            }else if(i < 33) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SHARP_OBSIDIAN_SWORD));
            }else if(i < 36) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.SHARP_REGULAR_OBSIDIAN_SWORD));
            }else if(i < 37) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.MACUAHUITL));
            }else if(i < 40) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
            }else if(i < 43) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
            }else if(i < 46) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SHOVEL));
            }else if(i < 48) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.EMERALD));
            }else if(i < 49) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND));
            }else if(i == 50) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.ANCIENT_HORN));
            }else if(i == 51) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.AIR_HORN));
            }else if(i == 52) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.AMETHYST_HORN));
            }else {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ModItems.RARE_SPICES));
            }
        }
    }

    @Override
    protected void dropCustomDeathLoot(ServerLevel world, DamageSource source, boolean causedByPlayer) {
        super.dropCustomDeathLoot(world, source, causedByPlayer);
    }

}
