package net.jaiz.jaizmobs.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public final class GlowTool extends Item {

    public GlowTool(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player user, LivingEntity entity, InteractionHand hand) {
        if (!entity.level().isClientSide()) {
            entity.level().playSound(null, entity, SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.PLAYERS, 1.0F, 1.0F);
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 3000, 1));
            stack.consume(1, user);
        }
        return InteractionResult.SUCCESS;
    }
}
