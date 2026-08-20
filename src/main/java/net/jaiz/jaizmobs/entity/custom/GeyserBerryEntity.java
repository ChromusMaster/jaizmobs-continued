package net.jaiz.jaizmobs.entity.custom;

import net.jaiz.jaizmobs.entity.ai.GeyserBerryAttackGoal;
import net.jaiz.jaizmobs.item.custom.ModItems;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class GeyserBerryEntity extends Monster implements AttackingMob {

    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(GeyserBerryEntity.class, EntityDataSerializers.BOOLEAN);

    public AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public GeyserBerryEntity(EntityType<? extends Monster> entityType, Level world) {

        super(entityType, world);
        this.xpReward = 0;
    }

    @Override
    public void tick() {
        super.tick();
    }

    public static boolean canSpawn(EntityType<GeyserBerryEntity> type, ServerLevelAccessor world, EntitySpawnReason spawnReason, BlockPos pos, RandomSource random) {
        return world.getBlockState(pos.below()).is(BlockTags.NYLIUM);
    }

    @Override
    protected void registerGoals() {
        this.initCustomGoals();
    }

    protected void initCustomGoals() {
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(1, new GeyserBerryAttackGoal(this, 1, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PathfinderMob.class, true));
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (this.level() instanceof ServerLevel serverLevel) {
            this.spawnAtLocation(serverLevel, ModItems.GEYSER_BERRY_SPAWN_EGG);
            this.discard();
        }
        return InteractionResult.SUCCESS;
    }

    public static AttributeSupplier.Builder createGeyserBerryAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.0f)
                .add(Attributes.ATTACK_DAMAGE, 6)
                .add(Attributes.FOLLOW_RANGE, 20);

    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking()
    {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACKING, false);
    }

    @Override
    public AnimationState attackAnimationState() {
        return this.attackAnimationState;
    }
}
