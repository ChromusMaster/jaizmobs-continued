package jaiz.jaizmod.mixin;

import jaiz.jaizmod.block.ModBlocks;
//import jaiz.jaizmod.block.blockentities.SquidLightBlockEntity;
//import jaiz.jaizmod.block.blockentities.WaterTickingBlock;
import jaiz.jaizmod.block.blockentities.SquidLightBlockEntity;
import jaiz.jaizmod.block.blockentities.WaterTickingBlock;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.statuseffects.ModStatusEffects;
import jaiz.jaizmod.util.ModGameRules;
import jaiz.jaizmod.util.ModLootTables;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.squid.GlowSquid;
import net.minecraft.world.entity.animal.squid.Squid;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;


@Mixin(GlowSquid.class)
public abstract class GlowSquidMixin extends Squid {

    @Unique
    public int staringcount = 0;
    @Unique
    int hypnotisecooldown = 0;
    @Unique
    int hypnotiseeffectcooldown = 20;


    public GlowSquidMixin(EntityType<? extends Squid> entityType, Level world) {
        super(entityType, world);
    }

    @Unique
    boolean isPlayerStaring(Player player) {
        ItemStack itemStack = player.getItemBySlot(EquipmentSlot.HEAD);
        if (itemStack.is(Blocks.CARVED_PUMPKIN.asItem())) {
            return false;
        } else {
            Vec3 vec3d = player.getViewVector(1.0F).normalize();
            Vec3 vec3d2 = new Vec3(this.getX() - player.getX(), this.getEyeY() - player.getEyeY(), this.getZ() - player.getZ());
            double d = vec3d2.length();
            vec3d2 = vec3d2.normalize();
            double e = vec3d.dot(vec3d2);
            return e > 1.0 - 0.075 / d && player.hasLineOfSight(this);
        }
    }

    public void tick() {
        super.tick();
        if (hypnotisecooldown > 0) {
            hypnotisecooldown--;
        }
        if (this.level().isClientSide()) {
            return;
        }
        Player nearestPlayer = this.level().getNearestPlayer(this, 32);
        if (nearestPlayer == null || hypnotisecooldown > 0 || !isPlayerStaring(nearestPlayer)) {
            staringcount = 0;
            return;
        }
        hypnotiseeffectcooldown++;
        staringcount++;
        if(staringcount >= 60){
            nearestPlayer.lookAt(EntityAnchorArgument.Anchor.EYES, this.position());
            if(hypnotiseeffectcooldown >= 20){
                hypnotiseeffectcooldown = 0;
                nearestPlayer.addEffect(new MobEffectInstance(ModStatusEffects.HYPNO,
                        60, 0, false, true));
            }
        }
    }


    @Inject(at = @At("TAIL"), method = "hurtServer")
    private void init(ServerLevel world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        hypnotisecooldown = 100;

        if(this.level() == null || this.level().isClientSide()) {return;}
        AABB box = (new AABB(this.blockPosition()).inflate(1.25).expandTowards(0.0, 0.0, 0.0));
        List<LivingEntity> list = this.level().getEntitiesOfClass(LivingEntity.class, box);
        for (LivingEntity livingEntity  : list) {
            livingEntity.removeEffect(MobEffects.BLINDNESS);
            livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,
                    120, 0, false, false));
            livingEntity.addEffect(new MobEffectInstance(ModStatusEffects.SHIMMER,
                    120, 0, false, true));
        }

    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.is(Items.GLASS_BOTTLE) && this.entityItemBottleDropper()) {
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        }
        if (itemStack.is(Items.AMETHYST_SHARD) && this.entityItemTorchDropper()) {
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Unique
    public boolean entityItemTorchDropper() {
        if (this.level() instanceof ServerLevel serverWorld) {
            this.spawnAtLocation(serverWorld, new ItemStack(ModItems.WATER_TORCH));
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            this.playSound(SoundEvents.HONEYCOMB_WAX_ON);
        }
        return true;
    }

    @Unique
    public boolean entityItemBottleDropper() {
        if (this.level() instanceof ServerLevel serverWorld) {
            this.spawnAtLocation(serverWorld, new ItemStack(ModItems.BIOLUMINESCENT_BOTTLE));
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            this.playSound(SoundEvents.BOTTLE_FILL);
        }
        return true;
    }


    //Romeo's Code
    @Inject(method = "aiStep", at = @At("HEAD"))
    private void newMobTick(CallbackInfo ci) {
        if(this.level() instanceof ServerLevel serverLevel) {
            if(serverLevel.getServer().getGlobalGameRules().get(ModGameRules.DO_GLOWING_SQUID)){
                boolean waterlogged = SquidLightBlockEntity.waterNeedsUpdate(serverLevel, this.blockPosition());
                BlockState desiredState = ModBlocks.WATER_TEMPORARY_LIGHT.defaultBlockState()
                        .setValue(WaterTickingBlock.WATERLOGGED, waterlogged);
                if (!serverLevel.getBlockState(this.blockPosition()).equals(desiredState)) {
                    serverLevel.setBlockAndUpdate(this.blockPosition(), desiredState);
                }
            }
        }
    }

}
