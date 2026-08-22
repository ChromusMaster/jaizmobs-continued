package jaiz.jaizmod.entity.bandit;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import java.util.Map;

public class BanditRenderer extends MobRenderer<BanditEntity, BanditRenderState, Bandit> {


    public static final Map<BanditVariant, Identifier> BANDIT_VARIANT =
            Util.make(Maps.newEnumMap(BanditVariant.class), (map) -> {
                map.put(BanditVariant.ORIGINAL, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_1.png"));
                map.put(BanditVariant.RED_MASK, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_2.png"));
                map.put(BanditVariant.GLOVES, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_3.png"));
                map.put(BanditVariant.BROWN_SHIRT, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_4.png"));
                map.put(BanditVariant.HAT, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_5.png"));
                map.put(BanditVariant.PAINTED, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_6.png"));
                map.put(BanditVariant.HAND_PRINT, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_7.png"));
                map.put(BanditVariant.SKI_MASK, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_8.png"));
                map.put(BanditVariant.RED, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_9.png"));
                map.put(BanditVariant.GREEN, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_10.png"));
                map.put(BanditVariant.BLUE, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/bandit/bandit_11.png"));
            });



    public BanditRenderer(EntityRendererProvider.Context context) {
        super(context, new Bandit(context.bakeLayer(ModModelLayers.BANDIT)), 0.35f);
        this.addLayer(new ItemInHandLayer<>(this));
    }

    @Override
    public BanditRenderState createRenderState() {
        return new BanditRenderState();
    }

    @Override
    protected void scale(BanditRenderState state, PoseStack matrixStack) {
        float g = 0.9375F * state.ageScale;
        matrixStack.scale(g, g, g);
    }

    @Override
    public Identifier getTextureLocation(BanditRenderState state) {
        return BANDIT_VARIANT.get(state.texture);
    }

    public void extractRenderState(BanditEntity bandit, BanditRenderState banditstate, float f) {
        super.extractRenderState(bandit, banditstate, f);
        ArmedEntityRenderState.extractArmedEntityRenderState(bandit, banditstate, this.itemModelResolver, f);
        banditstate.tradeAnimationState.copyFrom(bandit.tradeAnimationState);
        banditstate.attackAnimationState.copyFrom(bandit.attackAnimationState);
        banditstate.texture = bandit.getVariant();
    }
}
