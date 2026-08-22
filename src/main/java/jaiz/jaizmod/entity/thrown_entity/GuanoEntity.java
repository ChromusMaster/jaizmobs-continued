package jaiz.jaizmod.entity.thrown_entity;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import static jaiz.jaizmod.JaizMod.STINK_ITEM_PARTICLE;

public class GuanoEntity extends ThrowableItemProjectile {
    public GuanoEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public GuanoEntity(Level world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.GUANO, owner, world, stack);
    }

    public GuanoEntity(Level world, double x, double y, double z, ItemStack stack) {
        super(ModEntities.GUANO, x, y, z, world, stack);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.GUANO;
    }



    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        if (!this.level().isClientSide()) {
        Entity entity = entityHitResult.getEntity();
        if(entity instanceof LivingEntity) {
            ((LivingEntity) entity).addEffect(new MobEffectInstance(ModStatusEffects.STINKY, 600, 0));
        }
        if(this.isOnFire()){
            entity.hurt(entity.damageSources().thrown(this, this.getOwner()), 8.0F);
            entity.igniteForSeconds(3.0f);
        } else{
            entity.hurt(entity.damageSources().thrown(this, this.getOwner()), 1.0F);
        }
        this.playSound(SoundEvents.SLIME_HURT, 1.0f, 1.0f);
        this.level().broadcastEntityEvent(this,
                EntityEvent.DEATH);
        this.discard();
        super.onHitEntity(entityHitResult);
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        Level world = this.level();
        if (!this.level().isClientSide()) {
            this.playSound(SoundEvents.SLIME_HURT, 1.0f, 1.0f);
            this.level().broadcastEntityEvent(this,
                    EntityEvent.DEATH);
            this.gameEvent(GameEvent.BLOCK_PLACE);
            BlockPos blockPos = this.blockPosition();
            BlockState blockState = ModBlocks.GUANO_PILE.defaultBlockState();
            if(this.getInBlockState().isAir())
            {if(this.level().getBlockState(this.blockPosition().below()).isCollisionShapeFullBlock(world, this.blockPosition().below())) {
            world.setBlock(blockPos, blockState, Block.UPDATE_ALL);
                world.gameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Context.of(this, blockState));}
            } else {
                this.entityItemDropper();
            }
            this.discard();
        }
        super.onHit(hitResult);
    }

    public void entityItemDropper() {
        if (this.level() instanceof ServerLevel serverWorld) {
            this.spawnAtLocation(serverWorld, new ItemStack(ModItems.GUANO));
        }
    }

    private ParticleOptions getParticleParameters() {
        ItemStack itemStack = this.getItem();
        return !itemStack.isEmpty() && !itemStack.is(this.getDefaultItem())
                ? new ItemParticleOption(ParticleTypes.ITEM, itemStack.getItem())
                : STINK_ITEM_PARTICLE;
    }

    @Override
    public void handleEntityEvent(byte status) {
        if (status == EntityEvent.DEATH) {
            ParticleOptions particleEffect = this.getParticleParameters();

            for (int i = 0; i < 2; i++) {
                this.level().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

}
