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

public final class StriderHunter extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart striderhunter;
	private final ModelPart head;

	public StriderHunter(ModelPart root) {
		super(root);
		this.striderhunter = root.getChild("striderhunter");
		this.head = striderhunter.getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.STRIDER_HUNTER_WALK.bake(root);
		this.idleAnimation = ModAnimations.STRIDER_HUNTER_IDLE.bake(root);
		this.attackAnimation = ModAnimations.STRIDER_HUNTER_ATTACK.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition striderhunter = modelPartData.addOrReplaceChild("striderhunter", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 14.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body = striderhunter.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -4.3846F, 5.6538F, 16.0F, 16.0F, 30.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(0.0F, -12.3846F, 5.6538F, 0.0F, 8.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.6154F, -3.6538F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(88, 37).addBox(-5.0F, -5.0F, -0.0167F, 10.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.6154F, 35.6705F));

		PartDefinition jaw_l = head.addOrReplaceChild("jaw_l", CubeListBuilder.create().texOffs(78, 74).addBox(-5.0F, -2.5F, -1.0167F, 8.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 1.5F, 8.0F));

		PartDefinition jaw_r = head.addOrReplaceChild("jaw_r", CubeListBuilder.create().texOffs(0, 86).addBox(-3.0F, -2.5F, -1.0167F, 8.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.5F, 8.0F));

		PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(40, 80).addBox(0.0F, -14.5F, -14.0F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(46, 46).addBox(-7.0F, -6.5F, -14.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.1154F, 5.6538F));

		PartDefinition body3 = body2.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(78, 77).addBox(0.0F, -13.3846F, -13.9462F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 60).addBox(-6.0F, -5.3846F, -13.9462F, 12.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.1154F, -14.0538F));

		PartDefinition body4 = body3.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -12.3846F, -13.9962F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(62, 0).addBox(-4.5F, -4.3846F, -13.9962F, 9.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -13.95F));

		PartDefinition body5 = body4.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -10.4846F, -13.9962F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(38, 74).addBox(-3.0F, -2.9846F, -13.9962F, 6.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.1F, -14.0F));

		PartDefinition legs = striderhunter.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs_l = legs.addOrReplaceChild("legs_l", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition front_l = legs_l.addOrReplaceChild("front_l", CubeListBuilder.create().texOffs(0, 103).addBox(-1.5F, -1.5F, -2.5F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.5F, -15.5F, 25.5F));

		PartDefinition mid_l = legs_l.addOrReplaceChild("mid_l", CubeListBuilder.create().texOffs(35, 102).addBox(-1.5F, -1.5F, -2.5F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.5F, -15.5F, 10.5F));

		PartDefinition back_l = legs_l.addOrReplaceChild("back_l", CubeListBuilder.create().texOffs(103, 94).addBox(-1.5F, -2.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.5F, -12.0F, -1.5F));

		PartDefinition legs_r = legs.addOrReplaceChild("legs_r", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition front_r = legs_r.addOrReplaceChild("front_r", CubeListBuilder.create().texOffs(63, 97).addBox(-3.5F, -1.5F, -2.5F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(10.5F, -15.5F, 25.5F));

		PartDefinition mid_r = legs_r.addOrReplaceChild("mid_r", CubeListBuilder.create().texOffs(83, 99).addBox(-3.5F, -1.5F, -2.5F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(10.5F, -15.5F, 10.5F));

		PartDefinition back_r = legs_r.addOrReplaceChild("back_r", CubeListBuilder.create().texOffs(103, 18).addBox(-3.5F, -2.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, -12.0F, -1.5F));
		return LayerDefinition.create(modelData, 128, 128);
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