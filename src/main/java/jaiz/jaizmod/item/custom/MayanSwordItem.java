package jaiz.jaizmod.item.custom;

import jaiz.jaizmod.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;

public class MayanSwordItem extends Item {


    public MayanSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties settings) {
        super(settings.sword(material, attackDamage, attackSpeed));
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.BLOCK;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity user) {
        return 30;
    }


    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        if(!user.getOffhandItem().is(Items.SHIELD)){
            user.getCooldowns().addCooldown(itemStack, 60);
        } else{
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.SHIELD_DRUM, SoundSource.PLAYERS, 1.0f, user.getXRot() * -0.05f + 1f);
        }
        if (!user.getAbilities().instabuild) {
            itemStack.hurtAndBreak(1, user, hand);
        }
        return InteractionResult.CONSUME;
    }
}
