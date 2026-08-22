package jaiz.jaizmod.item.custom.teas;


import jaiz.jaizmod.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class GunPowderTeaItem
        extends TeaItem {
    public GunPowderTeaItem(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (!user.level().isClientSide()) {
            user.gameEvent(GameEvent.DRINK);
            user.level().explode(user, user.getX(), user.getY(),
                    user.getZ(), 3, Level.ExplosionInteraction.TNT);
            if (user instanceof Player && !((Player) user)
                    .getAbilities().instabuild) {
                user.hurt(world.damageSources().explosion(null), 20.0F);
            }
        }
        ItemStack itemStack = super.finishUsingItem(stack, world, user);
        if (user instanceof Player && ((Player) user).getAbilities().instabuild) {
            user.gameEvent(GameEvent.DRINK);
            return itemStack;
        }
        return new ItemStack(ModItems.TEA_CUP);
    }

}
