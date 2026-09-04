package jaiz.jaizmod.entity.fruit_bat;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.thrown_entity.GuanoEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;


public class FruitBatEntity extends Bat {

    public int poopTime = this.random.nextInt(5000) + 3000;

    public FruitBatEntity(EntityType<? extends Bat> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public boolean canBeLeashed() {
        return true;
    }

    @Override
    public void tick() {
        if (!this.level().isClientSide() && this.isAlive() && --this.poopTime <= 0) {
            GuanoEntity poop = new GuanoEntity(ModEntities.GUANO, this.level());
            this.playSound(SoundEvents.SLIME_SQUISH, 0.5f,
                    (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.5f);
            poop.snapTo(this.getX(),
                    this.getY() - 0.5, this.getZ(), 0.0F, 0.0F);
            this.level().addFreshEntity(poop);
            poopTime = this.random.nextInt(5000) + 3000;
        }
        super.tick();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.is(Items.SWEET_BERRIES) && this.isResting()) {
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EAT, SoundSource.AMBIENT, 15.0f, this.getXRot() * -0.05f + 1f);
            if(!player.isCreative()){
            itemStack.shrink(1);}
            GuanoEntity poop = new GuanoEntity(ModEntities.GUANO, this.level());
            if (this.random.nextInt(4) == 1) {
                this.playSound(SoundEvents.SLIME_SQUISH, 0.5f, (this.random.nextFloat() - this.random.nextFloat()) * 0.2f + 1.5f);
                poop.snapTo(this.getX(), this.getY() - 0.5, this.getZ(), 0.0F, 0.0F);
                this.level().addFreshEntity(poop);
            }
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    public static boolean canSpawn(EntityType<FruitBatEntity> fruitBatEntityEntityType, ServerLevelAccessor serverWorldAccess, EntitySpawnReason spawnReason, BlockPos blockPos, RandomSource random) {
            int i = 1;
            int j = 10;
            return i == random.nextInt(j) && checkMobSpawnRules(fruitBatEntityEntityType, serverWorldAccess, spawnReason, blockPos, random);
        }
}
