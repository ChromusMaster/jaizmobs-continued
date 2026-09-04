package jaiz.jaizmod.event;

import com.mojang.serialization.Codec;
import java.util.List;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.util.ModGameRules;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.Filterable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.WrittenBookContent;

public final class WelcomeGuide {
    private static final AttachmentType<Boolean> RECEIVED = AttachmentRegistry.create(
            Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "received_welcome_guide"),
            builder -> builder.persistent(Codec.BOOL).copyOnDeath()
    );

    private WelcomeGuide() {
    }

    public static void register() {
        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> giveTo(handler.getPlayer(), server));
    }

    private static void giveTo(ServerPlayer player, MinecraftServer server) {
        if (!server.getGlobalGameRules().get(ModGameRules.GIVE_WELCOME_GUIDE)
                || player.getAttachedOrElse(RECEIVED, false)) {
            return;
        }

        ItemStack guide = createGuide();
        if (!player.addItem(guide)) {
            player.drop(guide, false);
        }
        player.setAttached(RECEIVED, true);
    }

    private static ItemStack createGuide() {
        ItemStack guide = new ItemStack(Items.WRITTEN_BOOK);
        guide.set(DataComponents.CUSTOM_NAME, Component.translatable("guide.jaizmod.welcome.title"));
        List<Filterable<Component>> pages = List.of(
                Filterable.passThrough(Component.translatable("guide.jaizmod.welcome.page_1")),
                Filterable.passThrough(Component.translatable("guide.jaizmod.welcome.page_2")),
                Filterable.passThrough(Component.translatable("guide.jaizmod.welcome.page_3")),
                Filterable.passThrough(Component.translatable("guide.jaizmod.welcome.page_4"))
        );
        guide.set(DataComponents.WRITTEN_BOOK_CONTENT, new WrittenBookContent(
                Filterable.passThrough("JaizMod Field Guide"),
                "JaizMod",
                0,
                pages,
                true
        ));
        return guide;
    }
}
