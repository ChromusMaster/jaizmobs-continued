package jaiz.jaizmod.item.custom;

import jaiz.jaizmod.entity.ModEntities;
import jaiz.jaizmod.entity.thrown_entity.DynamiteEntity;
import jaiz.jaizmod.entity.thrown_entity.GlowballEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

public class GlowBallItem extends Item implements ProjectileItem {

    public GlowBallItem(Item.Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.3f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 0.8f));


        if (world instanceof ServerLevel serverWorld) {
            Projectile.spawnProjectileFromRotation(GlowballEntity::new, serverWorld, itemStack, user, 0.0F, 1.0f, 1.0F);
        }

        user.awardStat(Stats.ITEM_USED.get(this));
        if (!user.getAbilities().instabuild) {
            itemStack.shrink(1);
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public Projectile asProjectile(Level world, Position pos, ItemStack stack, Direction direction) {
        return new GlowballEntity(world, pos.x(), pos.y(), pos.z(), stack);
    }

}
