package net.jaiz.jaizmobs.item.custom;

import jaiz.jaizmod.advancement.ModCriteria;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;

public final class ModArmourItem {
    private ModArmourItem() {
    }

    public static void registerEffectHandler() {
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (server.getTickCount() % 20 != 0) {
                return;
            }
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                if (hasVoidScaleMail(player)) {
                    player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 1, false, false, false));
                    ModCriteria.VOID_ARMOR_WORN.trigger(player);
                }
                if (hasKlephtopodShell(player)) {
                    ModCriteria.KLEPHTOPOD_ARMOR_WORN.trigger(player);
                }
            }
        });
    }

    private static boolean hasVoidScaleMail(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.VOID_SCALE_MAIL_HELMET)
                && player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.VOID_SCALE_MAIL_CHESTPLATE)
                && player.getItemBySlot(EquipmentSlot.LEGS).is(ModItems.VOID_SCALE_MAIL_LEGGINGS)
                && player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.VOID_SCALE_MAIL_BOOTS);
    }

    private static boolean hasKlephtopodShell(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.KLEPHTOPOD_SHELL)
                && player.getItemBySlot(EquipmentSlot.CHEST).is(ModItems.KLEPHTOPOD_CHESTPLATE);
    }
}
