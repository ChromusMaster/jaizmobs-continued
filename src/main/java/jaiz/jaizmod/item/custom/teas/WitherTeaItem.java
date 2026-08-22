package jaiz.jaizmod.item.custom.teas;


import jaiz.jaizmod.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class WitherTeaItem
        extends TeaItem {
    public WitherTeaItem(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        ItemStack itemStack = super.finishUsingItem(stack, world, user);
        if (user instanceof Player && ((Player)user).getAbilities().instabuild) {
            user.gameEvent(GameEvent.DRINK);
            return itemStack;
        }
        user.addEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 2, 1));
        user.addEffect(new MobEffectInstance(MobEffects.HUNGER, 120, 255));
        user.addEffect(new MobEffectInstance(MobEffects.WITHER, 600, 255));
        return new ItemStack(ModItems.TEA_CUP);
    }
}
