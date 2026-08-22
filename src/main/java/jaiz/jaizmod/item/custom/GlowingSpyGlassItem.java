package jaiz.jaizmod.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.SpyglassItem;
import net.minecraft.world.level.Level;

public class GlowingSpyGlassItem extends SpyglassItem {

    public GlowingSpyGlassItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        user.getCooldowns().addCooldown(itemStack, 60);
        int o = user.getRandom().nextInt(9) + 3;
        for (int i = 0; i < o; i++) {
            user.level().addParticle(ParticleTypes.GLOW, user.getRandomX(1.2), user.getRandomY(), user.getRandomZ(1.2), 0.0, 0.0, 0.0);
        }
        user.playSound(SoundEvents.GLOW_SQUID_AMBIENT, 1.0F, 1.0F);
        user.playSound(SoundEvents.SPYGLASS_USE, 1.0F, 1.0F);
        if (!user.getAbilities().instabuild) {
            itemStack.hurtAndBreak(1, user, hand);
        }
        return ItemUtils.startUsingInstantly(world, user, hand);
    }

    @Override
    public void onUseTick(Level world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        user.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 3, 0, false, false));
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        this.stopUsing(user);
        return true;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        this.stopUsing(user);
        return stack;
    }

    private void stopUsing(LivingEntity user) {
        user.playSound(SoundEvents.SPYGLASS_STOP_USING, 1.0F, 1.0F);
        user.playSound(SoundEvents.GLOW_SQUID_AMBIENT, 1.0F, 0.7F);
    }

}
