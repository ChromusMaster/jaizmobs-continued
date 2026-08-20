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

public final class SporeTrap extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart head;

	public SporeTrap(ModelPart root) {
		super(root);
		this.head = root.getChild("sporetrap").getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.SPORETRAP_WALK.bake(root);
		this.idleAnimation = ModAnimations.SPORETRAP_IDLE.bake(root);
		this.attackAnimation = ModAnimations.SPORETRAP_ATTACK.bake(root);
	}

	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition sporetrap = modelPartData.addOrReplaceChild("sporetrap", CubeListBuilder.create(), PartPose.offset(-2.0F, 21.0F, 2.0F));

		PartDefinition back_leg_r = sporetrap.addOrReplaceChild("back_leg_r", CubeListBuilder.create().texOffs(22, 23).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		back_leg_r.addOrReplaceChild("back_right_foot", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -1.0F));

		PartDefinition front_leg_l = sporetrap.addOrReplaceChild("front_leg_l", CubeListBuilder.create().texOffs(24, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, -4.0F));

		front_leg_l.addOrReplaceChild("front_left_foot", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -1.0F));

		PartDefinition front_leg_r = sporetrap.addOrReplaceChild("front_leg_r", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		front_leg_r.addOrReplaceChild("front_right_foot", CubeListBuilder.create().texOffs(11, 9).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition back_leg_l = sporetrap.addOrReplaceChild("back_leg_l", CubeListBuilder.create().texOffs(14, 23).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 0.0F, 0.0F));

		back_leg_l.addOrReplaceChild("back_left_foot", CubeListBuilder.create().texOffs(11, 10).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -1.0F));

		PartDefinition body = sporetrap.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -2.0F));

		body.addOrReplaceChild("back_bone", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, -3.0F, 0.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 2.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition top_jaw = head.addOrReplaceChild("top_jaw", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 2.0F));

		PartDefinition top_jaw_L = top_jaw.addOrReplaceChild("top_jaw_L", CubeListBuilder.create().texOffs(12, 9).addBox(-1.0F, -2.0F, -6.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -1.0F, 1.0F));

		top_jaw_L.addOrReplaceChild("front_L", CubeListBuilder.create().texOffs(0, 2).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, -6.0F));

		top_jaw_L.addOrReplaceChild("left", CubeListBuilder.create().texOffs(12, 1).addBox(0.0F, 0.0F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -3.0F));

		PartDefinition top_jaw_R = top_jaw.addOrReplaceChild("top_jaw_R", CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, -2.0F, -6.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 1.0F));

		top_jaw_R.addOrReplaceChild("right", CubeListBuilder.create().texOffs(12, 11).addBox(0.0F, 0.0F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, -3.0F));

		top_jaw_R.addOrReplaceChild("front_R", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, -6.0F));

		top_jaw.addOrReplaceChild("top_jaw_teeth", CubeListBuilder.create(), PartPose.offset(0.0F, 13.0F, -2.0F));

		PartDefinition bottom_jaw = head.addOrReplaceChild("bottom_jaw", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.0F, -6.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		bottom_jaw.addOrReplaceChild("back_bottom_jaw", CubeListBuilder.create().texOffs(18, 0).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		bottom_jaw.addOrReplaceChild("right_bottom_tooth", CubeListBuilder.create().texOffs(16, 15).addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -3.0F, 0.0F, 0.0F, -0.1745F));

		bottom_jaw.addOrReplaceChild("front_bottom_tooth", CubeListBuilder.create().texOffs(18, 2).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -6.0F, 0.1745F, 0.0F, 0.0F));

		bottom_jaw.addOrReplaceChild("left_bottom_tooth", CubeListBuilder.create().texOffs(16, 13).addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, -3.0F, 0.0F, 0.0F, 0.1745F));
		return LayerDefinition.create(modelData, 32, 32);
	}
	@Override
	public void setupAnim(JaizMobRenderState state) {
		super.setupAnim(state);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks * 1f);
		this.attackAnimation.apply(state.attackAnimationState, state.ageInTicks * 1f);
		this.setHeadAngles(state.yRot, state.xRot);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -20.0f, 20.0f);
		headPitch = Mth.clamp(headPitch, -20.0f, 20.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}