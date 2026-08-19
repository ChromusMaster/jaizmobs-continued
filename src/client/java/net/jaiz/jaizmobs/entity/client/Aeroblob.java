package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;
import net.jaiz.jaizmobs.entity.animation.ModAnimations;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public final class Aeroblob extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final ModelPart aeroblob;
	private final ModelPart head;

	public Aeroblob(ModelPart root) {
		super(root);
		this.aeroblob = root.getChild("aeroblob");
		this.head = aeroblob.getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.AEROBLOB_FLY.bake(root);
		this.idleAnimation = ModAnimations.AEROBLOB_IDLE.bake(root);
	}

	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition aeroblob = modelPartData.addOrReplaceChild("aeroblob", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 14.0F, 3.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body = aeroblob.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 1.125F, -4.6667F, 7.0F, 3.0F, 6.0F, new CubeDeformation(1.0F))
				.texOffs(9, 44).addBox(-2.0F, 1.125F, -12.6667F, 4.0F, 1.0F, 3.0F, new CubeDeformation(1.0F))
				.texOffs(0, 9).addBox(-3.0F, 1.125F, -9.6667F, 6.0F, 2.0F, 6.0F, new CubeDeformation(1.0F))
				.texOffs(49, 43).addBox(-5.0F, 1.125F, 3.3333F, 10.0F, 4.0F, 7.0F, new CubeDeformation(1.0F))
				.texOffs(0, 43).addBox(-6.0F, -8.125F, -10.6667F, 12.0F, 9.0F, 25.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-8.0F, -17.875F, -11.6667F, 16.0F, 14.0F, 29.0F, new CubeDeformation(4.0F)), PartPose.offset(0.0F, 3.875F, -5.3333F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 17).addBox(-3.0F, -14.0F, 7.0F, 6.0F, 3.0F, 5.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 15.125F, 5.3333F));

		PartDefinition tentacles = body.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 15.125F, 5.3333F));

		PartDefinition T1 = tentacles.addOrReplaceChild("1", CubeListBuilder.create().texOffs(14, 18).addBox(0.0F, 0.0F, -3.5F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -10.0F, 2.5F));

		PartDefinition T2 = tentacles.addOrReplaceChild("2", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -3.5F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -10.0F, 2.5F));

		PartDefinition T3 = tentacles.addOrReplaceChild("3", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, 0.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -11.0F, -4.0F));

		PartDefinition T4 = tentacles.addOrReplaceChild("4", CubeListBuilder.create().texOffs(17, 11).addBox(0.0F, 0.0F, -3.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -11.0F, -4.0F));
		return LayerDefinition.create(modelData, 128, 128);
	}

	@Override
	public void setupAnim(JaizMobRenderState state) {
		super.setupAnim(state);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks * 1f);
		this.setHeadAngles(state.yRot, state.xRot);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -20.0f, 20.0f);
		headPitch = Mth.clamp(headPitch, -20.0f, 20.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}