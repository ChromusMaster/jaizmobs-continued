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

public final class Calcite_Golem extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart calcite_golem;
	private final ModelPart head;

	public Calcite_Golem(ModelPart root) {
		super(root);
		this.calcite_golem = root.getChild("calcite_golem");
		this.head = calcite_golem.getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.CALCITE_GOLEM_WALK.bake(root);
		this.idleAnimation = ModAnimations.CALCITE_GOLEM_IDLE.bake(root);
		this.attackAnimation = ModAnimations.CALCITE_GOLEM_ATTACK.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition calcite_golem = modelPartData.addOrReplaceChild("calcite_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leg_l = calcite_golem.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(0, 27).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -4.0F, -0.5F));

		PartDefinition leg_r = calcite_golem.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.75F, -4.0F, -0.5F));

		PartDefinition body = calcite_golem.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 15).addBox(-3.5F, -7.0F, -2.5F, 7.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -0.5F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -4.0F, -5.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(24, 15).addBox(-2.0F, -0.75F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -5.0F, 0.0F));

		PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(21, 26).addBox(0.0F, -0.75F, -1.5F, 2.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -5.0F, 0.0F));
		return LayerDefinition.create(modelData, 40, 40);
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