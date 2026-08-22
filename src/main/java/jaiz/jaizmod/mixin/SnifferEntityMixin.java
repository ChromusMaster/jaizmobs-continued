package jaiz.jaizmod.mixin;

import jaiz.jaizmod.entity.sniffer_mixins.SnifferGroupRevengeGoal;
import jaiz.jaizmod.entity.sniffer_mixins.SnifferMixinAccessor;
import jaiz.jaizmod.entity.sniffer_mixins.SnifferRevengeGoal;
import jaiz.jaizmod.entity.sniffer_mixins.SnifferVariant;
import jaiz.jaizmod.util.ModLootTables;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.*;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Objects;

@Mixin(Sniffer.class)
public abstract class SnifferEntityMixin
        extends Animal implements
        SnifferMixinAccessor {

    @Unique
    private static final TargetingConditions.Selector RAM_FILTER = (entity, world)
            -> !(entity instanceof Player playerEntity) || !playerEntity.isCreative();

    @Unique
    private static final TargetingConditions RAM_TARGET_PREDICATE = TargetingConditions.forNonCombat()
            .ignoreInvisibilityTesting()
            .ignoreLineOfSight()
            .selector(RAM_FILTER);

    @Unique
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(SnifferEntityMixin.class, EntityDataSerializers.INT);

    @Shadow @Final public AnimationState sniffingAnimationState;
    @Shadow @Final public AnimationState scentingAnimationState;

    @Unique
    private static final EntityDataAccessor<Boolean> SNOWY =
            SynchedEntityData.defineId(SnifferEntityMixin.class,
                    EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> SADDLED =
            SynchedEntityData.defineId(SnifferEntityMixin.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> MOSSY =
            SynchedEntityData.defineId(SnifferEntityMixin.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> MUDDY =
            SynchedEntityData.defineId(SnifferEntityMixin.class, EntityDataSerializers.BOOLEAN);

    @Unique
    private static final EntityDataAccessor<Boolean> CHERRY_BLOSSOM =
            SynchedEntityData.defineId(SnifferEntityMixin.class, EntityDataSerializers.BOOLEAN);
    @Unique
    private static final EntityDataAccessor<Boolean> BULL =
            SynchedEntityData.defineId(SnifferEntityMixin.class, EntityDataSerializers.BOOLEAN);


    protected SnifferEntityMixin(EntityType<? extends Animal> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 3.0, true));
        this.targetSelector.addGoal(2, new SnifferRevengeGoal(this));
        this.targetSelector.addGoal(3, new SnifferGroupRevengeGoal(this).setAlertOthers());
    }


    @Unique
    private ResourceKey<LootTable> getSnifferCoatLootTable() {
        return ModLootTables.SNIFFER_BRUSH_COAT_GAMEPLAY;
    }
    @Unique
    public List<ItemStack> getSnifferCoatLoot(SnifferEntityMixin sniffer, ServerLevel serverWorld) {
        LootTable lootTable = serverWorld.getServer().reloadableRegistries().getLootTable(getSnifferCoatLootTable());
        LootParams lootContextParameterSet = new LootParams.Builder(serverWorld)
                .withParameter(LootContextParams.ORIGIN, sniffer.position())
                .withParameter(LootContextParams.THIS_ENTITY, sniffer)
                .create(LootContextParamSets.GIFT);
        return lootTable.getRandomItems(lootContextParameterSet);
    }

    @Unique
    private void CoatLootItemDropper(SnifferEntityMixin sniffer, LivingEntity recipient) {
        sniffer.playSound(SoundEvents.BRUSH_GENERIC, 0.7F, (sniffer.getRandom().nextFloat() - sniffer.getRandom().nextFloat()) * 0.2F + 1.0F);
        if (level() instanceof ServerLevel serverWorld) {
            for (ItemStack itemStack : this.getSnifferCoatLoot(sniffer, serverWorld)) {
                BehaviorUtils.throwItem(sniffer, itemStack, recipient.position());
            }

        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.is(Items.BRUSH) && this.brushSniffer(player)) {
            itemStack.hurtAndBreak(4, player, hand);
            return InteractionResult.SUCCESS;
        }
        else if (itemStack.is(Items.SADDLE) && !this.isBaby() && !this.isSaddled() && this.isBull()) {
            if (!player.hasInfiniteMaterials()) {
                itemStack.shrink(1);
            }
            this.setSaddled(true);
            this.playSound(SoundEvents.PIG_SADDLE.value());
            return InteractionResult.SUCCESS;
        }
        else if (itemStack.is(ItemTags.SHOVELS) && this.isSnowy()) {
            itemStack.hurtAndBreak(1, player, hand);
            this.snowItemDropper();
            this.setSnowy(false);
            return InteractionResult.SUCCESS;
        }
        else if (itemStack.is(Items.SNOW) && !this.isSnowy()) {
            if (!player.hasInfiniteMaterials()) {
                itemStack.shrink(1);
            }
            this.playSound(SoundEvents.SNOW_PLACE);
            this.setSnowy(true);
            return InteractionResult.SUCCESS;
        }
        else if (itemStack.is(Items.CHERRY_LEAVES) && !this.isCherryBlossom()) {
            if (!player.hasInfiniteMaterials()) {
                itemStack.shrink(1);
            }
            this.playSound(SoundEvents.SNOW_PLACE);
            this.setCherryBlossom(true);
            return InteractionResult.SUCCESS;
        }
        else if (itemStack.is(Items.MOSS_CARPET) && !this.isMossy()) {
            if (!player.hasInfiniteMaterials()) {
                itemStack.shrink(1);
            }
            this.playSound(SoundEvents.SNOW_PLACE);
            this.setMossy(true);
            return InteractionResult.SUCCESS;
        }
        else if (itemStack.is(Items.MUD) && !this.isMuddy()) {
            if (!player.hasInfiniteMaterials()) {
                itemStack.shrink(1);
            }
            this.playSound(SoundEvents.MUD_PLACE);
            this.setMuddy(true);
            return InteractionResult.SUCCESS;
        }
        else if (itemStack.is(Items.SHEARS) && this.isMossy() || itemStack.is(Items.SHEARS) && this.isCherryBlossom()) {
            this.playSound(SoundEvents.SHEEP_SHEAR);
            itemStack.hurtAndBreak(1, player, hand);
            this.setMossy(false);
            this.setCherryBlossom(false);
            return InteractionResult.SUCCESS;
        }
        else if (itemStack.is(Items.WATER_BUCKET) && this.isMuddy()) {
            this.playSound(SoundEvents.BUCKET_EMPTY);
            this.setMuddy(false);
            return InteractionResult.SUCCESS;
        }
        //has to be at bottom
        else if (!this.isVehicle() && !player.isSecondaryUseActive() && this.isSaddled()) {
            if (!this.level().isClientSide()) {
                player.startRiding(this);
            }
            return InteractionResult.SUCCESS;
        }
        else if(this.isSaddled()){
            this.saddleItemDropper();
            this.setSaddled(false);
            return InteractionResult.SUCCESS;
        }
        else {
            return super.mobInteract(player, hand);
        }
    }

    @Unique
    public boolean brushSniffer(Player player) {
        if (this.isBaby()) {
            return false;
        } else {
            if (this.level() instanceof ServerLevel) {
                this.CoatLootItemDropper(this, player);
                this.gameEvent(GameEvent.ENTITY_INTERACT);
            }

            return true;
        }
    }

    @Unique
    public void snowItemDropper() {
        if (this.level() instanceof ServerLevel serverWorld) {
            this.spawnAtLocation(serverWorld, new ItemStack(Items.SNOWBALL));
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            this.playSound(SoundEvents.SNOW_BREAK);
        }
    }
    @Unique
    public void saddleItemDropper() {
        if (this.level() instanceof ServerLevel serverWorld) {
            this.spawnAtLocation(serverWorld, new ItemStack(Items.SADDLE));
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            this.playSound(SoundEvents.PIG_SADDLE.value());
        }
    }

    @Unique
    public void setBull(boolean bull) {
        this.entityData.set(BULL, bull);
    }
    @Unique
    public boolean isBull() {
        return this.entityData.get(BULL);
    }

    @Unique
    public void setSaddled(boolean saddled) {
        this.entityData.set(SADDLED, saddled);
    }
    @Unique
    public boolean isSaddled() {
        return this.entityData.get(SADDLED);
    }

    @Unique
    public boolean isMossy() {
        return this.entityData.get(MOSSY);
    }
    @Unique
    public void setMossy(boolean mossy) {
        this.entityData.set(MOSSY, mossy);
    }
    @Unique
    public boolean isMuddy() {
        return this.entityData.get(MUDDY);
    }
    @Unique
    public void setMuddy(boolean muddy) {
        this.entityData.set(MUDDY, muddy);
    }
    @Unique
    public boolean isCherryBlossom() {
        return this.entityData.get(CHERRY_BLOSSOM);
    }
    @Unique
    public void setCherryBlossom(boolean cherry_blossom) {
        this.entityData.set(CHERRY_BLOSSOM, cherry_blossom);
    }
    @Unique
    public boolean isSnowy() {
        return this.entityData.get(SNOWY);
    }

    @Unique
    public void setSnowy(boolean snowy) {
        this.entityData.set(SNOWY, snowy);
    }


    /**
     * @author
     * @reason
     */
    @Overwrite
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.MAX_HEALTH, 14.0)
                .add(Attributes.ATTACK_KNOCKBACK, 2.0)
                .add(Attributes.FOLLOW_RANGE, 24.0)
                .add(Attributes.ATTACK_DAMAGE, 2.0);
    }

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void defineSynchedData(SynchedEntityData.Builder builder, CallbackInfo ci){
        builder.define(DATA_ID_TYPE_VARIANT, 0);
        builder.define(BULL, false);
        builder.define(SADDLED, false);
        builder.define(SNOWY, false);
        builder.define(MOSSY, false);
        builder.define(MUDDY, false);
        builder.define(CHERRY_BLOSSOM, false);
    }

    @Override
    public void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putInt("Variant", this.getTypeVariant());
        output.putBoolean("Bull", this.isBull());
        output.putBoolean("Saddled", this.isSaddled());
        output.putBoolean("Snowy", this.isSnowy());
        output.putBoolean("Mossy", this.isMossy());
        output.putBoolean("Muddy", this.isMuddy());
        output.putBoolean("Cherry_Blossom", this.isCherryBlossom());
    }

    @Override
    public void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.entityData.set(DATA_ID_TYPE_VARIANT, input.getIntOr("Variant", 0));
        this.entityData.set(BULL, input.getBooleanOr("Bull", false));
        this.entityData.set(SADDLED, input.getBooleanOr("Saddled", false));
        this.entityData.set(SNOWY, input.getBooleanOr("Snowy", false));
        this.entityData.set(MOSSY, input.getBooleanOr("Mossy", false));
        this.entityData.set(MUDDY, input.getBooleanOr("Muddy", false));
        this.entityData.set(CHERRY_BLOSSOM, input.getBooleanOr("Cherry_Blossom", false));
    }

    @Unique
    private void ram(ServerLevel world, Mob target) {
        this.doHurtTarget(world, target);
        this.playSound(SoundEvents.GOAT_RAM_IMPACT, 1.0F, 1.0F);
    }
    @Unique
    int rammingCooldown = 0;
    @Inject(method = "tick", at = @At("TAIL"))
    public void tick(CallbackInfo ci){
        if(rammingCooldown > 0){
        rammingCooldown--;
        }
        if(rammingCooldown > 100){
            rammingCooldown = 80;
        }
        if (this.getBlockStateOn().is(Blocks.MUD) && !this.isMuddy()) {
            this.setMuddy(true);
        }
        if (this.hasControllingPassenger() && Objects.requireNonNull
                (this.getControllingPassenger()).isSprinting() && rammingCooldown < 30)
        {
            if (this.level() instanceof ServerLevel serverWorld && this.isAlive()) {
                for (Mob mobEntity : this.level()
                        .getEntitiesOfClass(Mob.class, this.getBoundingBox().inflate(0.3),
                                mobEntityx -> RAM_TARGET_PREDICATE.test(serverWorld, this, mobEntityx))) {
                    if (mobEntity.isAlive()) {
                        this.ram(serverWorld, mobEntity);
                        rammingCooldown += 45;
                    }
                }
            }
        }
        if(this.random.nextInt(250) == 1){
            this.heal(1);
        }

        Holder<Biome> registryEntry = this.level().getBiome(this.blockPosition());
        if(this.random.nextInt(10000) == 1 && !this.level().isClientSide()){
            if (registryEntry.is(ModTags.Biomes.SNIFFER_CHERRY) && !this.isCherryBlossom()) {
                this.setCherryBlossom(true);
            }
            if (registryEntry.is(ModTags.Biomes.SNIFFER_MOSSY) && !this.isMossy()) {
                this.setMossy(true);
            }
            if (registryEntry.is(BiomeTags.SPAWNS_SNOW_FOXES) && this.level()
                    .isRaining() && !this.isSnowy()) {
            this.setSnowy(true);
            }
            else if (registryEntry.is(BiomeTags.SPAWNS_WARM_VARIANT_FROGS) && this.isSnowy()) {
            this.setSnowy(false);
            }
        }
        if(this.isSnowy() || this.isMuddy()){
            if (this.getBlockStateOn().is(Blocks.WATER)) {
                this.setMuddy(false);
                this.setSnowy(false);
            }
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData entityData) {
        if (entityData == null) {
            entityData = new AgeableMob.AgeableMobGroupData(true);
        }
        AgeableMob.AgeableMobGroupData passiveData = (AgeableMob.AgeableMobGroupData)entityData;
        if (passiveData.isShouldSpawnBaby() && passiveData.getGroupSize() > 0 && world.getRandom().nextFloat() <= passiveData.getBabySpawnChance()) {
            this.setAge(-24000);
        }
        passiveData.increaseGroupSizeByOne();
        if(this.random.nextInt(50) == 1  && !this.level().isClientSide()){
            this.setBull(true);
            Objects.requireNonNull(this.
                    getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(8.0);
            Objects.requireNonNull(this.
                    getAttribute(Attributes.MAX_HEALTH)).setBaseValue(40.0);
            this.heal(32);
        }
        setTexture();

        return super.finalizeSpawn(world, difficulty, spawnReason, entityData);
    }

    @Unique
    public void setTexture(){
        int i = random.nextInt(100);
        if(i <= 10) {setVariant(SnifferVariant.GREEN);
        }else if(i <= 20) {setVariant(SnifferVariant.LIME);
        }else if(i <= 30) {setVariant(SnifferVariant.DUSK_LIME);
        }else if(i <= 40) {setVariant(SnifferVariant.PALE);
        }else if(i <= 50) {setVariant(SnifferVariant.MUSKY);
        }else if(i <= 53) {setVariant(SnifferVariant.BLUE);
        }else if(i <= 55) {setVariant(SnifferVariant.DANDELION);
        }else if(i <= 57) {setVariant(SnifferVariant.AUTUMN);
        }else if(i <= 60) {setVariant(SnifferVariant.SUNSET);
        }else if(i == 61) {setVariant(SnifferVariant.DUSK);}
        else if(i == 62) {setVariant(SnifferVariant.WHITE);}
        else if(i == 63) {setVariant(SnifferVariant.GREY);}
        else{setVariant(SnifferVariant.DEFAULT);
        }

    }


    @Override
    protected void tickRidden(Player controllingPlayer, Vec3 movementInput) {
        super.tickRidden(controllingPlayer, movementInput);
        Vec2 vec2f = this.getControlledRotation(controllingPlayer);
        this.setRot(vec2f.y, vec2f.x);
        this.sniffingAnimationState.stop();
        this.scentingAnimationState.stop();
        this.yRotO = this.yBodyRot = this.yHeadRot = this.getYRot();
    }

    @Unique
    protected Vec2 getControlledRotation(LivingEntity controllingPassenger) {
        return new Vec2(controllingPassenger.getXRot() * 0.5F, controllingPassenger.getYRot());
    }

    @Override
    protected Vec3 getRiddenInput(Player controllingPlayer, Vec3 movementInput) {
            float f = controllingPlayer.xxa * 0.5F;
            float g = controllingPlayer.zza;
            return new Vec3(f, 0.0, g);
    }

    @Nullable
    @Override
    public LivingEntity getControllingPassenger() {
        Entity var2 = this.getFirstPassenger();
        if(this.isSaddled()){
            if (var2 instanceof Player) {
                return (Player)var2;
            }
        }
        return super.getControllingPassenger();
    }

    @Override
    public boolean canSprint() {
        return true;
    }

    @Override
    protected float getRiddenSpeed(Player controllingPlayer) {
        if(!controllingPlayer.isSprinting()){
            return 0.075f;
        }
        return 0.15f;
    }

    @Unique
    public Object getVariant() {
        return SnifferVariant.byId(this.getTypeVariant() & 255);
    }

    @Unique
    public void setVariant(SnifferVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Unique
    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
}
