package jaiz.jaizmod.item.custom.ancient_horns;

import jaiz.jaizmod.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ExplosionParticleInfo;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.*;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.hurtingprojectile.windcharge.WindCharge;
import net.minecraft.world.item.InstrumentItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import java.util.function.Consumer;

import static net.minecraft.world.entity.projectile.hurtingprojectile.windcharge.AbstractWindCharge.EXPLOSION_DAMAGE_CALCULATOR;

public class AirHornItem extends InstrumentItem {

    private static final WeightedList<ExplosionParticleInfo> EXPLOSION_BLOCK_PARTICLES = WeightedList.<ExplosionParticleInfo>builder()
            .add(new ExplosionParticleInfo(ParticleTypes.POOF, 0.5F, 1.0F))
            .add(new ExplosionParticleInfo(ParticleTypes.SMOKE, 1.0F, 1.0F))
            .build();


    public AirHornItem(Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag type) {
        MutableComponent mutableText = Component.translatable(Util.makeDescriptionId("instrument", Identifier.parse("air_horn")));
        tooltip.accept(mutableText.withStyle(ChatFormatting.GRAY));
    }


    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {

        ItemStack itemStack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        if (!user.getAbilities().instabuild) {
            itemStack.hurtAndBreak(1, user, hand);
        }
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.AIR_HORN, SoundSource.PLAYERS, 15.0f, user.getXRot() * -0.05f + 1f);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.BREEZE_IDLE_GROUND, SoundSource.PLAYERS, 3.0f, user.getXRot() * -0.05f + 1f);


        if(user.isShiftKeyDown()){
            user.getCooldowns().addCooldown(itemStack, 320);
            if(user.level().getBlockState(user.blockPosition().below()).isAir()){
            user.push(0, 1.5, 0);} else{
            WindCharge windChargeEntity = new WindCharge(user, world, user.position().x(), user.getEyePosition().y(), user.position().z());
            windChargeEntity.shootFromRotation(user, 90, 90, 0.0F, 1.5F, 1.0F);
            world.addFreshEntity(windChargeEntity);}
        }else{
            user.setDeltaMovement(user.getDeltaMovement().with(Direction.Axis.Y, 0.01F));
            user.level()
                    .explode(
                            user,
                            null,
                            EXPLOSION_DAMAGE_CALCULATOR,
                            user.getX(),
                            user.getY(),
                            user.getZ(),
                            9.0F,
                            false,
                            Level.ExplosionInteraction.TRIGGER,
                            ParticleTypes.GUST_EMITTER_SMALL,
                            ParticleTypes.GUST_EMITTER_LARGE,
                            EXPLOSION_BLOCK_PARTICLES,
                            SoundEvents.WIND_CHARGE_BURST
                    );
            user.getCooldowns().addCooldown(itemStack, 120);
        }
        return InteractionResult.FAIL;
    }
}
