package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.custom.TotemSpiritEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public final class JungleTotemSpiritRenderer extends JaizMobRenderer<TotemSpiritEntity, TotemSpirit> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, "textures/entity/jungle_totem_spirit.png");

    public JungleTotemSpiritRenderer(EntityRendererProvider.Context context) {
        super(context, new TotemSpirit(context.bakeLayer(ModModelLayers.JUNGLE_TOTEM_SPIRIT)), 0.5f, TEXTURE);
    }
}
