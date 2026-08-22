package jaiz.jaizmod.entity.snail;

import com.mojang.blaze3d.vertex.PoseStack;
import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import jaiz.jaizmod.entity.caterpillar.Caterpillar;
import jaiz.jaizmod.entity.caterpillar.CaterpillarEntity;
import jaiz.jaizmod.entity.caterpillar.CaterpillarRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;

public class SnailRenderer extends MobRenderer<SnailEntity, LivingEntityRenderState, Snail> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/entity/snail.png");

    public SnailRenderer(EntityRendererProvider.Context context) {
        super(context, new Snail(context.bakeLayer(ModModelLayers.SNAIL)), 0f);
    }

    @Override
    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    @Override
    protected void scale(LivingEntityRenderState state, PoseStack matrixStack) {
        if(state.isBaby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
    }

    @Override
    public Identifier getTextureLocation(LivingEntityRenderState state) {
        return TEXTURE;
    }
}
