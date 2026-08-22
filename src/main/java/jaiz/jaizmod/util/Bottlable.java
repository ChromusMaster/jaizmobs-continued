package jaiz.jaizmod.util;

import java.util.Optional;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;

public interface Bottlable {
    boolean isFromBottle();

    void setFromBottle(boolean fromBucket);

    void copyDataToStack(ItemStack stack);

    void copyDataFromNbt(CompoundTag nbt);

    ItemStack getBottleItem();

    @Deprecated
    static void copyDataToStack(Mob entity, ItemStack stack) {
        stack.set(DataComponents.CUSTOM_NAME, entity.getCustomName());
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack, nbtCompound -> {
            if (entity.isNoAi()) {
                nbtCompound.putBoolean("NoAI", entity.isNoAi());
            }

            if (entity.isSilent()) {
                nbtCompound.putBoolean("Silent", entity.isSilent());
            }

            if (entity.isNoGravity()) {
                nbtCompound.putBoolean("NoGravity", entity.isNoGravity());
            }

            if (entity.hasGlowingTag()) {
                nbtCompound.putBoolean("Glowing", entity.hasGlowingTag());
            }

            if (entity.isInvulnerable()) {
                nbtCompound.putBoolean("Invulnerable", entity.isInvulnerable());
            }

            nbtCompound.putFloat("Health", entity.getHealth());
        });
    }

    @Deprecated
    static void copyDataFromNbt(Mob entity, CompoundTag nbt) {
        if (nbt.contains("NoAI")) {
            entity.setNoAi(nbt.getBooleanOr("NoAI", false));
        }

        if (nbt.contains("Silent")) {
            entity.setSilent(nbt.getBooleanOr("Silent", false));
        }

        if (nbt.contains("NoGravity")) {
            entity.setNoGravity(nbt.getBooleanOr("NoGravity", false));
        }

        if (nbt.contains("Glowing")) {
            entity.setGlowingTag(nbt.getBooleanOr("Glowing", false));
        }

        if (nbt.contains("Invulnerable")) {
            entity.setInvulnerable(nbt.getBooleanOr("Invulnerable", false));
        }

        if (nbt.contains("Health")) {
            entity.setHealth(nbt.getFloatOr("Health", entity.getHealth()));
        }
    }

    static <T extends LivingEntity & Bottlable> Optional<InteractionResult> tryBottle(Player player, InteractionHand hand, T entity) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() == Items.GLASS_BOTTLE && entity.isAlive()) {
            entity.playSound(SoundEvents.BOTTLE_FILL, 1.0F, 1.0F);
            ItemStack itemStack2 = entity.getBottleItem();
            entity.copyDataToStack(itemStack2);
            ItemStack itemStack3 = ItemUtils.createFilledResult(itemStack, player, itemStack2, false);
            player.setItemInHand(hand, itemStack3);
            Level world = entity.level();
            if (!world.isClientSide()) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer)player, itemStack2);
            }

            entity.discard();
            return Optional.of(InteractionResult.SUCCESS);
        } else {
            return Optional.empty();
        }
    }
}
