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

public final class MolotovGolem extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart head;

	public MolotovGolem(ModelPart root) {
		super(root);
		this.head = root.getChild("molotov_golem").getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.MOLOTOV_GOLEM_WALK.bake(root);
		this.idleAnimation = ModAnimations.MOLOTOV_GOLEM_IDLE.bake(root);
		this.attackAnimation = ModAnimations.MOLTOV_GOLEM_ATTACK.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition molotov_golem = modelPartData.addOrReplaceChild("molotov_golem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = molotov_golem.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -15.0F, 0.0F));

		head.addOrReplaceChild("bottom_jaw", CubeListBuilder.create().texOffs(24, 38).addBox(-4.0F, -2.0F, -7.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(34, 28).addBox(-4.0F, -1.0F, -7.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 3.0F));

		head.addOrReplaceChild("top_jaw", CubeListBuilder.create().texOffs(17, 47).addBox(-3.5F, -4.0F, -7.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-4.0F, -4.2F, -7.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 4.0F));

		body.addOrReplaceChild("chest_1", CubeListBuilder.create().texOffs(36, 0).addBox(0.0F, -8.0F, -6.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		body.addOrReplaceChild("chest_2", CubeListBuilder.create().texOffs(0, 30).addBox(0.0F, -8.0F, 0.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		body.addOrReplaceChild("chest_3", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -8.0F, -6.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		body.addOrReplaceChild("chest_4", CubeListBuilder.create().texOffs(18, 15).addBox(-6.0F, -8.0F, 0.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(0, 51).addBox(0.0F, -1.5F, -2.5F, 3.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -13.0F, 0.0F));

		PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create(), PartPose.offset(-6.0F, -13.0F, 0.0F));

		arm_r.addOrReplaceChild("arm_r_r1", CubeListBuilder.create().texOffs(45, 47).addBox(-1.5F, -7.0F, -2.5F, 3.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 5.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		body.addOrReplaceChild("heart", CubeListBuilder.create().texOffs(58, 26).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		molotov_golem.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(56, 38).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -5.0F, 0.0F));

		molotov_golem.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(55, 16).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -5.0F, 0.0F));
		return LayerDefinition.create(modelData, 96, 96);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -20.0f, 20.0f);
		headPitch = Mth.clamp(headPitch, -20.0f, 20.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

	@Override
	public void setupAnim(JaizMobRenderState state) {
		super.setupAnim(state);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks * 1f);
		this.attackAnimation.apply(state.attackAnimationState, state.ageInTicks * 1f);
		this.setHeadAngles(state.yRot, state.xRot);
	}

}