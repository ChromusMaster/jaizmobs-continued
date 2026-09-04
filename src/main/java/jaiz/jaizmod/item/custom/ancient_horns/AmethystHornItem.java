package jaiz.jaizmod.item.custom.ancient_horns;

import jaiz.jaizmod.advancement.ModCriteria;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.InstrumentItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import java.util.List;
import java.util.function.Consumer;

public class AmethystHornItem extends InstrumentItem {


    public AmethystHornItem(Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag type) {
        super.appendHoverText(stack, context, display, tooltip, type);
        MutableComponent mutableText = Component.translatable(Util.makeDescriptionId("instrument", Identifier.parse("amethyst_horn")));
        tooltip.accept(mutableText.withStyle(ChatFormatting.GRAY));
    }

    @Override
    public InteractionResult use(Level world, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        user.startUsingItem(hand);
        if (!user.getAbilities().instabuild) {
            itemStack.hurtAndBreak(1, user, hand);
        }
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.AMETHYST_HORN, SoundSource.PLAYERS, 15.0f, user.getXRot() * -0.05f + 1f);
        if (user instanceof ServerPlayer player) {
            ModCriteria.HORN_USED.trigger(player);
        }
        int o = user.getRandom().nextInt(12) + 5;

        if(user.isShiftKeyDown()){
            user.getCooldowns().addCooldown(itemStack, 320);
            BlockState blockstate = ModBlocks.AMETHYST_THORN.defaultBlockState();
            BlockPos blockPos1 = user.blockPosition().east();
            BlockPos blockPos2 = user.blockPosition().north();
            BlockPos blockPos3 = user.blockPosition().west();
            BlockPos blockPos4 = user.blockPosition().south();
            BlockPos blockPos5 = user.blockPosition().east().north();
            BlockPos blockPos6 = user.blockPosition().north().west();
            BlockPos blockPos7 = user.blockPosition().west().south();
            BlockPos blockPos8 = user.blockPosition().south().east();

            BlockPos blockPos9 = user.blockPosition().east(2);
            BlockPos blockPos10 = user.blockPosition().north(2);
            BlockPos blockPos11 = user.blockPosition().west(2);
            BlockPos blockPos12 = user.blockPosition().south(2);


            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().east()).is(BlockTags.REPLACEABLE)){
            if(user.level().getBlockState(user.blockPosition().east().below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
            world.setBlockAndUpdate(blockPos1, blockstate);
            }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().north()).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().north().below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos2, blockstate);
                }}}

                if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().west()).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().west().below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos3, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().south()).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().south().below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos4, blockstate);
                }}}



            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().east().north()).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().east().north().below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos5, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().north().west()).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().north().west().below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos6, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().west().south()).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().west().south().below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos7, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().south().east()).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().south().east().below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos8, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().east(2)).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().east(2).below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos9, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().north(2)).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().north(2).below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos10, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().west(2)).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().west(2).below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos11, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.level().getBlockState(user.blockPosition().south(2)).is(BlockTags.REPLACEABLE)){
                if(user.level().getBlockState(user.blockPosition().south(2).below()).isCollisionShapeFullBlock(world, user.blockPosition().below())){
                    world.setBlockAndUpdate(blockPos12, blockstate);
                }}}




        }else{
            user.getCooldowns().addCooldown(itemStack, 120);
            if(user.level().isClientSide()) {
                AABB box = (new AABB(user.blockPosition()).inflate(72.0).expandTowards(0.0, 0.0, 0.0));
                List<LivingEntity> list = user.level().getEntitiesOfClass(LivingEntity.class, box);
                int remainingParticles = 256;
                for (LivingEntity livingEntity  : list) {
                    int particleCount = Math.min(o, remainingParticles);
                    for (int i = 0; i < particleCount; i++) {
                        livingEntity.level().addParticle(JaizMod.AMETHYST_SPARKLE_PARTICLE, livingEntity.getRandomX(1.2), livingEntity.getRandomY(), livingEntity.getRandomZ(1.2), 0.0, 0.0, 0.0);
                    }
                    remainingParticles -= particleCount;
                    if (remainingParticles == 0) {
                        break;
                    }
                }
            }

        }
        return InteractionResult.SUCCESS;
    }
}
