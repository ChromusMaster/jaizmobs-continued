package jaiz.jaizmod.entity.thrown_entity;


import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;


public class GlowballEntity extends ThrowableItemProjectile {
    public GlowballEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
        super(entityType, world);
    }


    public GlowballEntity(Level world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.GLOWBALL, owner, world, stack);
    }

    public GlowballEntity(Level world, double x, double y, double z, ItemStack stack) {
        super(ModEntities.GLOWBALL, x, y, z, world, stack);
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.GLOW_BALL;
    }



    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        if (!this.level().isClientSide()) {
        Entity entity = entityHitResult.getEntity();
        if(entity instanceof LivingEntity) {
            ((LivingEntity) entity).addEffect(new MobEffectInstance(ModStatusEffects.SHIMMER, 1200, 0));
        }
        entity.hurt(entity.damageSources().thrown(this, this.getOwner()), 1.0F);
        this.level().broadcastEntityEvent(this, EntityEvent.DEATH);
        this.discard();
        super.onHitEntity(entityHitResult);
        }
    }

    @Override
    protected void onHit(HitResult hitResult) {
        if (!this.level().isClientSide()) {
            this.playSound(SoundEvents.SNOW_BREAK, 1.0f, 1.0f);
            this.level().broadcastEntityEvent(this,
                    EntityEvent.DEATH);
            this.discard();
        }

        super.onHit(hitResult);
    }

    private ParticleOptions getParticleParameters() {
        ItemStack itemStack = this.getItem();
        return !itemStack.isEmpty() && !itemStack.is(this.getDefaultItem())
                ? new ItemParticleOption(ParticleTypes.ITEM, itemStack.getItem())
                : ParticleTypes.GLOW;
    }

    private ParticleOptions getParticleParameters2() {
        ItemStack itemStack = this.getItem();
        return !itemStack.isEmpty() && !itemStack.is(this.getDefaultItem())
                ? new ItemParticleOption(ParticleTypes.ITEM, itemStack.getItem())
                : ParticleTypes.ITEM_SNOWBALL;
    }

    @Override
    public void handleEntityEvent(byte status) {
        if (status == EntityEvent.DEATH) {
            ParticleOptions particleEffect = this.getParticleParameters();
            ParticleOptions particleEffect2 = this.getParticleParameters2();

            for (int i = 0; i < 2; i++) {
                this.level().addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
            for (int i = 0; i < 2; i++) {
                this.level().addParticle(particleEffect2, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

}
