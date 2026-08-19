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

public final class Klephtopod extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart klephtopod;
	private final ModelPart head;

	public Klephtopod(ModelPart root) {
		super(root);
		this.klephtopod = root.getChild("klephtopod");
		this.head = klephtopod.getChild("body").getChild("neck").getChild("head");
	
		this.walkAnimation = ModAnimations.KLEPHTOPOD_SWIM.bake(root);
		this.idleAnimation = ModAnimations.KLEPHTOPOD_IDLE.bake(root);
		this.attackAnimation = ModAnimations.KLEPHTOPOD_ATTACK.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition Klephtopod = modelPartData.addOrReplaceChild("klephtopod", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = Klephtopod.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 27).addBox(-7.0F, 1.25F, -8.0F, 14.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-8.0F, -7.75F, -9.0F, 16.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.25F, 1.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 53).addBox(0.0F, -5.75F, -12.1667F, 0.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 47).addBox(-2.5F, 0.25F, -12.6667F, 5.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(45, 32).addBox(-3.0F, -2.75F, -12.6667F, 6.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -8.8333F, -0.7854F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(63, 58).addBox(-3.0F, -2.375F, -11.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(33, 58).addBox(-4.0F, -3.875F, -7.0F, 8.0F, 7.5F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.375F, -12.1667F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(57, 16).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, 8.0F));

		PartDefinition tail_end = tail.addOrReplaceChild("tail_end", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 8.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 2.75F, 0.0F));

		PartDefinition leg_1_front = legs.addOrReplaceChild("leg_1_front", CubeListBuilder.create().texOffs(47, 50).addBox(-1.0F, 0.75F, -1.5F, 15.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(72, 37).addBox(-1.0F, -2.25F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.75F, -4.5F));

		PartDefinition leg_1_back = legs.addOrReplaceChild("leg_1_back", CubeListBuilder.create().texOffs(72, 31).addBox(-1.0F, -2.25F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(17, 50).addBox(-1.0F, 0.75F, -1.5F, 15.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 0.75F, 4.5F));

		PartDefinition leg_r_front = legs.addOrReplaceChild("leg_r_front", CubeListBuilder.create().texOffs(42, 8).addBox(-14.0F, 0.75F, -1.5F, 15.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 68).addBox(-6.0F, -2.25F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 0.75F, -4.5F));

		PartDefinition leg_r_back = legs.addOrReplaceChild("leg_r_back", CubeListBuilder.create().texOffs(63, 67).addBox(-6.0F, -2.25F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(42, 0).addBox(-14.0F, 0.75F, -1.5F, 15.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 0.75F, 4.5F));
		return LayerDefinition.create(modelData, 96, 96);
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
		headYaw = Mth.clamp(headYaw, -10.0f, 10.0f);
		headPitch = Mth.clamp(headPitch, 50.0f, 110.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}