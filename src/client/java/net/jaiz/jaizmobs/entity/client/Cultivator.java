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

public final class Cultivator extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final ModelPart head;

	public Cultivator(ModelPart root) {
		super(root);
		this.head = root.getChild("cultivator").getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.CULTIVATOR_WALK.bake(root);
		this.idleAnimation = ModAnimations.CULTIVATOR_IDLE.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition cultivator = modelPartData.addOrReplaceChild("cultivator", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = cultivator.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -7.75F, -14.0F, 18.0F, 13.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(0, 41).addBox(-7.0F, -9.75F, -12.0F, 14.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.25F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 2.25F, -14.0F));

		head.addOrReplaceChild("top_jaw", CubeListBuilder.create().texOffs(66, 62).addBox(-5.0F, -3.0F, -10.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		head.addOrReplaceChild("bottom_jaw", CubeListBuilder.create().texOffs(64, 0).addBox(-6.0F, -0.75F, -10.75F, 12.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, -0.25F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(52, 41).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.25F, 14.0F));

		PartDefinition tail_2 = tail.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(0, 67).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 11.0F));

		PartDefinition pod15 = tail_2.addOrReplaceChild("pod15", CubeListBuilder.create().texOffs(94, 84).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(15, 10).addBox(0.0F, -5.0F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 3.5F));

		pod15.addOrReplaceChild("tiny_plant2_r1", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -0.5F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 4.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod16 = tail_2.addOrReplaceChild("pod16", CubeListBuilder.create().texOffs(15, 13).addBox(0.0F, -3.5F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(15, 41).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 7.5F));

		pod16.addOrReplaceChild("tiny_plant4_r1", CubeListBuilder.create().texOffs(0, 10).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -4.0F, 0.0F, -1.5708F, 0.0F));

		tail_2.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition pod14 = tail.addOrReplaceChild("pod14", CubeListBuilder.create().texOffs(69, 90).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(64, 67).addBox(-1.5F, -9.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 8.5F));

		pod14.addOrReplaceChild("small_plant15_r1", CubeListBuilder.create().texOffs(31, 67).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod13 = tail.addOrReplaceChild("pod13", CubeListBuilder.create().texOffs(0, 57).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 65).addBox(-1.5F, -10.5F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, 3.5F));

		pod13.addOrReplaceChild("small_plant13_r1", CubeListBuilder.create().texOffs(64, 97).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pods = body.addOrReplaceChild("pods", CubeListBuilder.create(), PartPose.offset(0.0F, 12.25F, 0.0F));

		PartDefinition pod1 = pods.addOrReplaceChild("pod1", CubeListBuilder.create().texOffs(32, 94).addBox(-2.0F, -16.75F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -21.0F, 1.0F));

		pod1.addOrReplaceChild("plant2_r1", CubeListBuilder.create().texOffs(56, 92).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.75F, 0.0F, 0.0F, -1.5708F, 0.0F));

		pod1.addOrReplaceChild("pod1_r1", CubeListBuilder.create().texOffs(72, 76).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition pod2 = pods.addOrReplaceChild("pod2", CubeListBuilder.create().texOffs(16, 83).addBox(-2.0F, -8.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(92, 36).addBox(-2.0F, -16.5F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -20.5F, 5.0F));

		pod2.addOrReplaceChild("plant4_r1", CubeListBuilder.create().texOffs(48, 92).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod3 = pods.addOrReplaceChild("pod3", CubeListBuilder.create().texOffs(80, 16).addBox(-2.0F, -7.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(23, 67).addBox(-2.0F, -15.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -21.0F, 9.0F));

		pod3.addOrReplaceChild("plant6_r1", CubeListBuilder.create().texOffs(92, 28).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod4 = pods.addOrReplaceChild("pod4", CubeListBuilder.create().texOffs(52, 41).addBox(-2.0F, -17.5F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 83).addBox(-2.0F, -9.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -19.5F, -6.5F));

		pod4.addOrReplaceChild("plant9_r1", CubeListBuilder.create().texOffs(20, 20).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod5 = pods.addOrReplaceChild("pod5", CubeListBuilder.create().texOffs(64, 16).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-2.0F, -17.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -19.0F, -3.0F));

		pod5.addOrReplaceChild("plant8_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod6 = pods.addOrReplaceChild("pod6", CubeListBuilder.create().texOffs(32, 83).addBox(-2.0F, -6.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 12).addBox(-2.0F, -14.5F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.5F, -9.0F));

		pod6.addOrReplaceChild("plant11_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod7 = pods.addOrReplaceChild("pod7", CubeListBuilder.create().texOffs(88, 76).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 16).addBox(-1.5F, -12.5F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -19.5F, 4.5F));

		pod7.addOrReplaceChild("small_plant4_r1", CubeListBuilder.create().texOffs(18, 96).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod8 = pods.addOrReplaceChild("pod8", CubeListBuilder.create().texOffs(16, 0).addBox(-1.5F, -3.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(96, 57).addBox(-1.5F, -11.5F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -20.0F, -11.5F));

		pod8.addOrReplaceChild("small_plant2_r1", CubeListBuilder.create().texOffs(24, 96).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod9 = pods.addOrReplaceChild("pod9", CubeListBuilder.create().texOffs(52, 67).addBox(-1.5F, -7.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(6, 96).addBox(-1.5F, -15.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -19.0F, -1.5F));

		pod9.addOrReplaceChild("small_plant6_r1", CubeListBuilder.create().texOffs(12, 96).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod10 = pods.addOrReplaceChild("pod10", CubeListBuilder.create().texOffs(85, 87).addBox(-1.5F, -5.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(93, 95).addBox(-1.5F, -13.5F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -19.5F, 11.5F));

		pod10.addOrReplaceChild("small_plant7_r1", CubeListBuilder.create().texOffs(0, 96).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod11 = pods.addOrReplaceChild("pod11", CubeListBuilder.create().texOffs(83, 41).addBox(-1.5F, -5.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(81, 95).addBox(-1.5F, -13.5F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -19.5F, 1.0F));

		pod11.addOrReplaceChild("small_plant9_r1", CubeListBuilder.create().texOffs(87, 95).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition pod12 = pods.addOrReplaceChild("pod12", CubeListBuilder.create().texOffs(40, 94).addBox(-1.5F, -12.5F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -20.5F, -9.5F));

		pod12.addOrReplaceChild("small_plant11_r1", CubeListBuilder.create().texOffs(94, 49).addBox(-1.5F, -4.0F, 0.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		pod12.addOrReplaceChild("pod12_r1", CubeListBuilder.create().texOffs(12, 57).addBox(-1.5F, -4.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition legs = cultivator.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		legs.addOrReplaceChild("front_l", CubeListBuilder.create().texOffs(52, 76).addBox(-1.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, -9.5F, -8.5F));

		legs.addOrReplaceChild("back_l", CubeListBuilder.create().texOffs(32, 67).addBox(-1.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.5F, -9.5F, 8.5F));

		legs.addOrReplaceChild("front_r", CubeListBuilder.create().texOffs(0, 12).addBox(-3.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.5F, -9.5F, -8.5F));

		legs.addOrReplaceChild("back_r", CubeListBuilder.create().texOffs(0, 41).addBox(-3.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.5F, -9.5F, 8.5F));
		return LayerDefinition.create(modelData, 112, 112);
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