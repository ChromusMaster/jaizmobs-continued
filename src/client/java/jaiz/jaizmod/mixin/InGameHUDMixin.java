package jaiz.jaizmod.mixin;

import jaiz.jaizmod.statuseffects.HypnoStatusEffect;
import jaiz.jaizmod.statuseffects.ModStatusEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Hud.class)
public abstract class InGameHUDMixin {
    private static final Identifier HYPNOSIS_OUTLINE = Identifier.withDefaultNamespace("textures/misc/hypnosis_outline.png");

    @Mutable
    @Final
    @Shadow
    private final Minecraft minecraft;

    protected InGameHUDMixin(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    private void renderHypnosisOverlay(GuiGraphicsExtractor context, float opacity) {
        int i = ARGB.white(opacity);
        context.blit(
                RenderPipelines.GUI_TEXTURED,
                HYPNOSIS_OUTLINE,
                0,
                0,
                0.0F,
                0.0F,
                context.guiWidth(),
                context.guiHeight(),
                context.guiWidth(),
                context.guiHeight(),
                i
        );
    }

    @Inject(at = @At("TAIL"), method = "extractCameraOverlays")
    private void init(GuiGraphicsExtractor context, DeltaTracker tickCounter, CallbackInfo ci) {

        if (this.minecraft.player != null && this.minecraft.player.hasEffect(ModStatusEffects.HYPNO)) {
            this.renderHypnosisOverlay(context, HypnoStatusEffect.hypnopulse);
        }
    }

}
