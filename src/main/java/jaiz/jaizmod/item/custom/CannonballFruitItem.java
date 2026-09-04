package jaiz.jaizmod.item.custom;

import jaiz.jaizmod.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/*
Reserved for a future use of the Cannonball Fruit.
public final class CannonballFruitItem extends DescribedItem {
    public CannonballFruitItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack fruit = player.getItemInHand(hand);
        if (level instanceof ServerLevel serverLevel) {
            if (!player.getAbilities().instabuild) {
                fruit.shrink(1);
            }
            give(player, new ItemStack(ModItems.CANNONBALL_PULP));
            give(player, new ItemStack(ModItems.CANNONBALL_SHELL, 2));
            player.awardStat(Stats.ITEM_USED.get(this));
            serverLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.7F, 0.8F);
        }
        return InteractionResult.SUCCESS;
    }

    private static void give(Player player, ItemStack stack) {
        if (!player.getInventory().add(stack)) {
            player.drop(stack, false);
        }
    }
}
*/
