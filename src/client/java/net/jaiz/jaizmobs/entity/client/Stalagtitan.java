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

public final class Stalagtitan extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart head;

	public Stalagtitan(ModelPart root) {
		super(root);
		this.head = root.getChild("stalagtitan").getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.STALAGTITAN_WALK.bake(root);
		this.idleAnimation = ModAnimations.STALAGTITAN_IDLE.bake(root);
		this.attackAnimation = ModAnimations.STALAGTITAN_ATTACK.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition stalagtitan = modelPartData.addOrReplaceChild("stalagtitan", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = stalagtitan.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -15.0F, -2.0F, 8.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -28.0F, -0.5F));

		body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(24, 18).addBox(-3.0F, -2.0F, -2.0F, 3.0F, 27.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 53).addBox(-7.0F, 1.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(24, 48).addBox(-7.0F, 13.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -12.0F, 0.5F));

		PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(36, 15).addBox(0.0F, -2.0F, -2.0F, 3.0F, 27.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(29, 0).addBox(3.0F, 15.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(38, 0).addBox(0.0F, -2.25F, -3.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -12.0F, 0.5F));

		arm_l.addOrReplaceChild("shoulder_spine_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -4.25F, 1.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 0.5F));

		head.addOrReplaceChild("frill_top_r", CubeListBuilder.create().texOffs(36, 45).addBox(-8.0F, -5.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -9.0F, 0.0F));

		head.addOrReplaceChild("frill_top", CubeListBuilder.create().texOffs(48, 36).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -1.0F));

		head.addOrReplaceChild("frill_l", CubeListBuilder.create().texOffs(48, 27).addBox(0.0F, -4.5F, 0.0F, 7.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -4.5F, -1.0F));

		head.addOrReplaceChild("frill_r", CubeListBuilder.create().texOffs(48, 18).addBox(-7.0F, -4.5F, 0.0F, 7.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -4.5F, -1.0F));

		head.addOrReplaceChild("frill_top_l", CubeListBuilder.create().texOffs(45, 10).addBox(-2.0F, -5.0F, 0.0F, 10.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -9.0F, 0.0F));

		stalagtitan.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(12, 38).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 27.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -27.0F, -0.5F));

		stalagtitan.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 27.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -27.0F, 0.0F));
		return LayerDefinition.create(modelData, 68, 68);
	}
	@Override
	public void setupAnim(JaizMobRenderState state) {
		super.setupAnim(state);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks * 1f);
		this.attackAnimation.apply(state.attackAnimationState, state.ageInTicks * 2f);
		this.setHeadAngles(state.yRot, state.xRot);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -30.0f, 30.0f);
		headPitch = Mth.clamp(headPitch, -30.0f, 30.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}