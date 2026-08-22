package jaiz.jaizmod.item.custom.teas;


import jaiz.jaizmod.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class NovelTeaItem
        extends TeaItem {
    public NovelTeaItem(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        ItemStack itemStack = super.finishUsingItem(stack, world, user);
        if (user instanceof Player && ((Player)user).getAbilities().instabuild) {
            user.gameEvent(GameEvent.DRINK);
            return itemStack;
        }
        if (user instanceof Player && !((Player) user).getAbilities().instabuild) {
            user.hurt(world.damageSources().explosion(null), 20.0F);
            user.level().explode(user, user.getX(), user.getY(), user.getZ(), 1, Level.ExplosionInteraction.TNT);
        }
        return new ItemStack(ModItems.TEA_CUP);
    }
}
