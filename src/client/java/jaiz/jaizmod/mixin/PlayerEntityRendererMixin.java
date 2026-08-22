package jaiz.jaizmod.mixin;

import jaiz.jaizmod.item.ModItems;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.world.entity.Avatar;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AvatarRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<Avatar, AvatarRenderState, PlayerModel> {

    public PlayerEntityRendererMixin(EntityRendererProvider.Context ctx, PlayerModel model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    public void extractRenderState(Avatar abstractClientPlayerEntity, AvatarRenderState playerEntityRenderState, float f, CallbackInfo ci){
        if (playerEntityRenderState.isUsingItem) {
            ItemStack itemStack = abstractClientPlayerEntity.getItemInHand(playerEntityRenderState.useItemHand);
            if (itemStack.is(ModItems.GLOWING_SPYGLASS)) {
                this.itemModelResolver
                        .updateForLiving(playerEntityRenderState.heldOnHead, itemStack, ItemDisplayContext.HEAD, abstractClientPlayerEntity);
            }
        }
    }
}
