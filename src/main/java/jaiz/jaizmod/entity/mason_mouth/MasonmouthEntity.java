package jaiz.jaizmod.entity.mason_mouth;

import jaiz.jaizmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.golem.AbstractGolem;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.golem.SnowGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileDeflection;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;


public class MasonmouthEntity extends AbstractGolem {

    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(MasonmouthEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CRACKED =
            SynchedEntityData.defineId(MasonmouthEntity.class, EntityDataSerializers.BOOLEAN);

    public AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public MasonmouthEntity(EntityType<? extends AbstractGolem> entityType, Level world) {

        super(entityType, world);
        this.skipDropExperience();
    }


    public int getMaxHeadXRot() {
        return 180;
    }

    public int getMaxHeadYRot() {
        return 180;
    }

    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        this.yBodyRot = 0.0F;
        this.yBodyRotO = 0.0F;
    }

    protected BodyRotationControl createBodyControl() {
        return new MimicBodyControl(this);
    }

    private static class MimicBodyControl extends BodyRotationControl {
        public MimicBodyControl(Mob mobEntity) {
            super(mobEntity);
        }

        public void clientTick() {
        }
    }

    public boolean canBeCollidedWith() {
        return this.isAlive();
    }






    public void setPos(double x, double y, double z) {
        BlockPos blockPos = this.blockPosition();
        if (this.isPassenger()) {
            super.setPos(x, y, z);
        } else {
            super.setPos((double) Mth.floor(x) + 0.5, (double)Mth.floor(y + 0.5), (double)Mth.floor(z) + 0.5);
        }
    }

    public void lerpTo(double x, double y, double z, float yaw, float pitch, int interpolationSteps) {
        this.setPos(x, y, z);
        this.setRot(yaw, pitch);
    }

    protected MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }

    @Override
    public void push(Entity entity) {
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
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 40;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAggressive()  && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 25;
            attackAnimationState.start(this.tickCount);
        } else {
            --this.attackAnimationTimeout;
        }

        if(!this.isAggressive()) {
            attackAnimationState.stop();
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
    public boolean hurtServer(ServerLevel world,
                          DamageSource source, float amount) {
        boolean bl = super.hurtServer(world, source, amount);
        if (bl) {
            this.setCracked(this.getHealth() <= 5);
        }
        return bl;
    }

    @Override
    protected void registerGoals() {
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(2, new MasonMouthAttackGoal(this, 1d, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
    }

    public static AttributeSupplier.Builder createMasonMouthAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 14)
                .add(Attributes.MOVEMENT_SPEED, 0.0f)
                .add(Attributes.ARMOR, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 16)
                .add(Attributes.FOLLOW_RANGE, 2)
                .add(Attributes.KNOCKBACK_RESISTANCE, 5.0f);

    }

    public void setAggressive(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public void setCracked(boolean cracked) {
        this.entityData.set(CRACKED, cracked);
    }

    public boolean isCracked() {
        return this.entityData.get(CRACKED);
    }

    @Override
    public boolean isAggressive() {
        return this.entityData.get(ATTACKING);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE_VARIANT, 0);
        builder.define(ATTACKING, false);
        builder.define(CRACKED, false);
    }

    public void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("Variant", this.getTypeVariant());
        output.putBoolean("Cracked", this.isCracked());
    }

    @Override
    public void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.entityData.set(DATA_ID_TYPE_VARIANT, input.getIntOr("Variant", 0));
        this.entityData.set(CRACKED, input.getBooleanOr("Cracked", false));
    }

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(MasonmouthEntity.class, EntityDataSerializers.INT);

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData entityData) {
        setVariant(MasonMouthVariant.ORIGINAL);
        this.setYRot(0.0F);
        this.yHeadRot = this.getYRot();
        this.setOldPosAndRot();
        return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
    }

    public Object getVariant() {
        return MasonMouthVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(MasonMouthVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SHULKER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.DEEPSLATE_TILES_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SPLASH_POTION_BREAK;
    }

    public static HashMap<Item, MasonMouthVariant> getSherdVariant() {
        HashMap<Item, MasonMouthVariant> sherd_variant = new HashMap<>();
        sherd_variant.put(Items.ANGLER_POTTERY_SHERD, MasonMouthVariant.ANGLER);
        sherd_variant.put(Items.ARCHER_POTTERY_SHERD, MasonMouthVariant.ARCHER);
        sherd_variant.put(Items.ARMS_UP_POTTERY_SHERD, MasonMouthVariant.ARMS_UP);
        sherd_variant.put(Items.BLADE_POTTERY_SHERD, MasonMouthVariant.BLADE);
        sherd_variant.put(Items.BREWER_POTTERY_SHERD, MasonMouthVariant.BREWER);
        sherd_variant.put(Items.BURN_POTTERY_SHERD, MasonMouthVariant.BURN);
        sherd_variant.put(Items.DANGER_POTTERY_SHERD, MasonMouthVariant.DANGER);
        sherd_variant.put(Items.EXPLORER_POTTERY_SHERD, MasonMouthVariant.EXPLORER);
        sherd_variant.put(Items.FLOW_POTTERY_SHERD, MasonMouthVariant.FLOW);
        sherd_variant.put(Items.FRIEND_POTTERY_SHERD, MasonMouthVariant.FRIEND);
        sherd_variant.put(Items.GUSTER_POTTERY_SHERD, MasonMouthVariant.GUSTER);
        sherd_variant.put(Items.HEART_POTTERY_SHERD, MasonMouthVariant.HEART);
        sherd_variant.put(Items.HEARTBREAK_POTTERY_SHERD, MasonMouthVariant.HEARTBREAK);
        sherd_variant.put(Items.HOWL_POTTERY_SHERD, MasonMouthVariant.HOWL);
        sherd_variant.put(Items.MINER_POTTERY_SHERD, MasonMouthVariant.MINER);
        sherd_variant.put(Items.MOURNER_POTTERY_SHERD, MasonMouthVariant.MOURNER);
        sherd_variant.put(Items.PLENTY_POTTERY_SHERD, MasonMouthVariant.PLENTY);
        sherd_variant.put(Items.PRIZE_POTTERY_SHERD, MasonMouthVariant.PRIZE);
        sherd_variant.put(Items.SCRAPE_POTTERY_SHERD, MasonMouthVariant.SCRAPE);
        sherd_variant.put(Items.SHEAF_POTTERY_SHERD, MasonMouthVariant.SHEAF);
        sherd_variant.put(Items.SHELTER_POTTERY_SHERD, MasonMouthVariant.SHELTER);
        sherd_variant.put(Items.SKULL_POTTERY_SHERD, MasonMouthVariant.SKULL);
        sherd_variant.put(Items.SNORT_POTTERY_SHERD, MasonMouthVariant.SNORT);
        sherd_variant.put(Items.GOLD_NUGGET, MasonMouthVariant.GILDED);
        sherd_variant.put(Items.CLAY_BALL, MasonMouthVariant.CLAY);
        return sherd_variant;
    }

    @Override
    public ProjectileDeflection deflection(Projectile projectile) {
            return ProjectileDeflection.REVERSE;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        HashMap<Item, MasonMouthVariant> sherd_variant = getSherdVariant();
        if (itemStack.is(ModTags.Items.MASON_MOUTH_TRANSFORMABLE)){
            if (sherd_variant.containsKey(player.getItemInHand(hand).getItem())) {
                MasonMouthVariant output = sherd_variant.get(player.getItemInHand(hand).getItem());
                this.setVariant(output);
            }
            int o = this.getRandom().nextInt(9) + 3;
            for (int i = 0; i < o; i++) {
                this.level().addParticle(ParticleTypes.SCRAPE, this.getRandomX(1.2), this.getRandomY(), this.getRandomZ(1.2), 0.0, 0.0, 0.0);
            }
            this.level().playSound(null, this.getX() + 0.5, this.getY() + 0.5,
                    this.getZ() + 0.5, SoundEvents.AXE_SCRAPE, SoundSource.HOSTILE, 1.0f, 1.0f);

            if (!player.getAbilities().instabuild) {
                player.getItemInHand(hand).shrink(1);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

}
