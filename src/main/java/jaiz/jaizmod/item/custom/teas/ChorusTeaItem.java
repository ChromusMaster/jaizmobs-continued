package jaiz.jaizmod.item.custom.teas;


import jaiz.jaizmod.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

public class ChorusTeaItem
        extends TeaItem {
    public ChorusTeaItem(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        if (!world.isClientSide()) {
            for (int i = 0; i < 16; ++i) {
                SoundSource soundCategory;
                SoundEvent soundEvent;
                double d = user.getX() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                double e = Mth.clamp(user.getY() + (double) (user.getRandom().nextInt(16) - 8), (double) world.getMinY(), (double) (world.getMinY() + ((ServerLevel) world).getLogicalHeight() - 1));
                double f = user.getZ() + (user.getRandom().nextDouble() - 0.5) * 16.0;
                if (user.isPassenger()) {
                    user.stopRiding();
                }
                Vec3 vec3d = user.position();
                if (!user.randomTeleport(d, e, f, true)) continue;
                world.gameEvent(GameEvent.TELEPORT, vec3d, GameEvent.Context.of(user));
                if (user instanceof Fox) {
                    soundEvent = SoundEvents.FOX_TELEPORT;
                    soundCategory = SoundSource.NEUTRAL;
                } else {
                    soundEvent = SoundEvents.CHORUS_FRUIT_TELEPORT;
                    soundCategory = SoundSource.PLAYERS;
                }
                world.playSound(null, user.getX(), user.getY(), user.getZ(), soundEvent, soundCategory);
                user.resetFallDistance();
                break;
            }
            if (user instanceof Player) {
                Player playerEntity = (Player) user;
                playerEntity.getCooldowns().addCooldown(stack, 20);
            }

            ItemStack itemStack = super.finishUsingItem(stack, world, user);
            if (user instanceof Player && ((Player) user).getAbilities().instabuild) {
                user.gameEvent(GameEvent.DRINK);
                return itemStack;
            }
            return new ItemStack(ModItems.TEA_CUP);
        }
        return stack;
    }
}
