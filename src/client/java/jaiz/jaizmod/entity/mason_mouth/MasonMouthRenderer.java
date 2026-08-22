package jaiz.jaizmod.entity.mason_mouth;

import com.google.common.collect.Maps;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import java.util.Map;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

public class MasonMouthRenderer extends MobRenderer<MasonmouthEntity, MasonMouthRenderState, Masonmouth> {

    public static final Map<MasonMouthVariant, Identifier> MASON_MOUTH_VARIANT =
            Util.make(Maps.newEnumMap(MasonMouthVariant.class), (map) -> {
                map.put(MasonMouthVariant.ORIGINAL, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth.png"));
                map.put(MasonMouthVariant.ANGLER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_angler.png"));
                map.put(MasonMouthVariant.ARCHER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_archer.png"));
                map.put(MasonMouthVariant.ARMS_UP, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_arms_up.png"));
                map.put(MasonMouthVariant.BLADE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_blade.png"));
                map.put(MasonMouthVariant.BREWER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_brewer.png"));
                map.put(MasonMouthVariant.BURN, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_burn.png"));
                map.put(MasonMouthVariant.DANGER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_danger.png"));
                map.put(MasonMouthVariant.EXPLORER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_explorer.png"));
                map.put(MasonMouthVariant.FLOW, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_flow.png"));
                map.put(MasonMouthVariant.FRIEND, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_friend.png"));
                map.put(MasonMouthVariant.GUSTER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_guster.png"));
                map.put(MasonMouthVariant.HEART, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_heart.png"));
                map.put(MasonMouthVariant.HEARTBREAK, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_heartbreak.png"));
                map.put(MasonMouthVariant.HOWL, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_howl.png"));
                map.put(MasonMouthVariant.MINER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_miner.png"));
                map.put(MasonMouthVariant.MOURNER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_mourner.png"));
                map.put(MasonMouthVariant.PLENTY, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_plenty.png"));
                map.put(MasonMouthVariant.PRIZE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_prize.png"));
                map.put(MasonMouthVariant.SCRAPE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_scrape.png"));
                map.put(MasonMouthVariant.SHEAF, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_sheaf.png"));
                map.put(MasonMouthVariant.SHELTER, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_shelter.png"));
                map.put(MasonMouthVariant.SKULL, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_skull.png"));
                map.put(MasonMouthVariant.SNORT, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_snort.png"));
                map.put(MasonMouthVariant.GILDED, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_gilded.png"));
                map.put(MasonMouthVariant.CLAY, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/mason_mouth/mason_mouth_clay.png"));
            });

    public MasonMouthRenderer(EntityRendererProvider.Context context) {
        super(context, new Masonmouth(context.bakeLayer(ModModelLayers.MASON_MOUTH)), 0.35f);
        this.addLayer(new MasonMouthFeatureRenderer(this));
    }

    @Override
    public MasonMouthRenderState createRenderState() {
        return new MasonMouthRenderState();
    }

    @Override
    public Identifier getTextureLocation(MasonMouthRenderState state) {
        return MASON_MOUTH_VARIANT.get(state.texture);
    }

    public void extractRenderState(MasonmouthEntity entity, MasonMouthRenderState state, float f) {
        super.extractRenderState(entity, state, f);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.attackAnimationState.copyFrom(entity.attackAnimationState);
        state.cracked = entity.isCracked();
        state.texture = entity.getVariant();
    }
}
