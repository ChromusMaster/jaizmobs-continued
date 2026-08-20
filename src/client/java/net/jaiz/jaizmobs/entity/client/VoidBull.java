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

public final class VoidBull extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart head;

	public VoidBull(ModelPart root) {
		super(root);
		this.head = root.getChild("voidbull").getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.VOIDBULL_WALK.bake(root);
		this.idleAnimation = ModAnimations.VOIDBULL_IDLE.bake(root);
		this.attackAnimation = ModAnimations.VOIDBULL_ATTACK.bake(root);
	}

	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition voidbull = modelPartData.addOrReplaceChild("voidbull", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body = voidbull.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -7.0F, -9.0F, 14.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -17.0F, 2.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(34, 43).addBox(-4.0F, -2.5F, 0.3333F, 9.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -0.5F, 8.6667F));

		head.addOrReplaceChild("horn_r_r1", CubeListBuilder.create().texOffs(46, 0).addBox(-2.5F, -4.5F, -4.5F, 5.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -1.0F, 5.8333F, -0.3491F, 0.3491F, 0.0F));

		head.addOrReplaceChild("horn_l_r1", CubeListBuilder.create().texOffs(55, 23).addBox(-2.5F, -4.5F, -4.5F, 5.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -1.0F, 5.8333F, -0.3491F, -0.3491F, 0.0F));

		PartDefinition body_2 = body.addOrReplaceChild("body_2", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, -6.0F, -11.5F, 12.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.5F));

		PartDefinition body_3 = body_2.addOrReplaceChild("body_3", CubeListBuilder.create().texOffs(0, 55).addBox(-5.0F, -5.0F, -9.5F, 10.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -11.0F));

		PartDefinition body_4 = body_3.addOrReplaceChild("body_4", CubeListBuilder.create().texOffs(38, 64).addBox(-4.0F, -4.0F, -7.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition body_5 = body_4.addOrReplaceChild("body_5", CubeListBuilder.create().texOffs(74, 21).addBox(-3.0F, -3.0F, -5.5F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -7.0F));

		PartDefinition tail_flukes = body_5.addOrReplaceChild("tail_flukes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -5.0F));

		tail_flukes.addOrReplaceChild("tail_fluke2_r1", CubeListBuilder.create().texOffs(0, 63).addBox(0.0F, -4.0F, -50.0F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 38.5F, 0.0F, 0.0F, -0.7854F));

		tail_flukes.addOrReplaceChild("tail_fluke1_r1", CubeListBuilder.create().texOffs(64, 30).addBox(0.0F, -4.0F, -5.5F, 0.0F, 8.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition legs = voidbull.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		legs.addOrReplaceChild("front_l", CubeListBuilder.create().texOffs(74, 0).addBox(-4.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -16.0F, 5.5F));

		legs.addOrReplaceChild("front_r", CubeListBuilder.create().texOffs(68, 64).addBox(-0.5F, 0.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -16.0F, 5.5F));

		legs.addOrReplaceChild("back_l", CubeListBuilder.create().texOffs(42, 79).addBox(-16.0F, 0.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -14.0F, -10.5F));

		legs.addOrReplaceChild("back_r", CubeListBuilder.create().texOffs(22, 74).addBox(11.0F, 0.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -14.0F, -10.5F));
		return LayerDefinition.create(modelData, 100, 100);
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