package jaiz.jaizmod.item.custom.ancient_horns;

import jaiz.jaizmod.sound.ModSounds;
import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.InstrumentItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import java.util.function.Consumer;


public class AncientHornItem extends InstrumentItem {


    public AncientHornItem(Properties settings) {
        super(settings);
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag type) {
        MutableComponent mutableText = Component.translatable(Util.makeDescriptionId("instrument", Identifier.parse("ancient_horn")));
        tooltip.accept(mutableText.withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        if (!user.getAbilities().instabuild) {
            itemStack.hurtAndBreak(1, user, hand);
        }
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.ANCIENT_HORN, SoundSource.PLAYERS, 15.0f, user.getXRot() * -0.05f + 1f);

        if(user.isShiftKeyDown()){
            user.getCooldowns().addCooldown(itemStack, 320);
            user.removeAllEffects();
            user.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 180, 1, false, true));

        }
        else
        {
            if (world instanceof ServerLevel) {
                BlockState blockState = world.getBlockState(user.blockPosition().below());
                BlockState blockState2 = world.getBlockState(user.blockPosition());
                BlockState blockState3 = world.getBlockState(user.blockPosition().above());
                if (blockState3.getBlock() instanceof BonemealableBlock fertilizable && fertilizable.isValidBonemealTarget(world, user.blockPosition().above(), blockState3)) {
                    if (fertilizable.isBonemealSuccess(world, world.getRandom(), user.blockPosition().above(), blockState3)) {
                        fertilizable.performBonemeal((ServerLevel)world, world.getRandom(), user.blockPosition().above(), blockState3);
                    }
                }
                else if (blockState2.getBlock() instanceof BonemealableBlock fertilizable && fertilizable.isValidBonemealTarget(world, user.blockPosition(), blockState2)) {
                    if (fertilizable.isBonemealSuccess(world, world.getRandom(), user.blockPosition(), blockState2)) {
                        fertilizable.performBonemeal((ServerLevel)world, world.getRandom(), user.blockPosition(), blockState2);
                    }
                }
                else if (blockState.getBlock() instanceof BonemealableBlock fertilizable && fertilizable.isValidBonemealTarget(world, user.blockPosition().below(), blockState)) {
                    if (fertilizable.isBonemealSuccess(world, world.getRandom(), user.blockPosition().below(), blockState)) {
                    fertilizable.performBonemeal((ServerLevel)world, world.getRandom(), user.blockPosition().below(), blockState);
                }
                }
            }
            int o = user.getRandom().nextInt(9) + 3;
            for (int i = 0; i < o; i++) {
                user.level().addParticle(ParticleTypes.HAPPY_VILLAGER, user.getRandomX(1.2), user.getRandomY(), user.getRandomZ(1.2), 0.0, 0.0, 0.0);
            }

            user.getCooldowns().addCooldown(itemStack, 120);
        }

        return InteractionResult.FAIL;
    }
}
