package jaiz.jaizmod.entity.thrown_entity;
import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.item.ModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;


public class DynamiteEntity extends ThrowableItemProjectile {
    public DynamiteEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
        super(entityType, world);
    }

    public DynamiteEntity(Level world, LivingEntity owner, ItemStack stack) {
        super(ModEntities.DYNAMITE, owner, world, stack);
    }

    public DynamiteEntity(Level world, double x, double y, double z, ItemStack stack) {
        super(ModEntities.DYNAMITE, x, y, z, world, stack);
    }

    public int k = 120;

    @Override
    protected Item getDefaultItem() {
        return ModItems.DYNAMITE;
    }

    private void explode() {
        if (!this.level().isClientSide()) {
            this.level().explode(this, this.getX(), this.getY(),
                    this.getZ(), 1.75f, Level.ExplosionInteraction.TNT);
            this.discard();
        }
    }


    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide()) {
            this.explode();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            this.level().addParticle(ParticleTypes.SMALL_FLAME, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
            if(k == 0) {
                this.explode();
            } else {
                k --;
            }
        }
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

}
