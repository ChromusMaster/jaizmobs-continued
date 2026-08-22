package jaiz.jaizmod.item.custom.teas;


import jaiz.jaizmod.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class TeaItem
        extends Item {
    public TeaItem(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        ItemStack itemStack = super.finishUsingItem(stack, world, user);
        if (user instanceof Player && ((Player)user).getAbilities().instabuild) {
            user.gameEvent(GameEvent.DRINK);
            return itemStack;
        }
        return new ItemStack(ModItems.TEA_CUP);
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.DRINK;
    }

}
