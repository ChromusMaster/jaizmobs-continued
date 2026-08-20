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

public final class PineGiant extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart head;

	public PineGiant(ModelPart root) {
		super(root);
		this.head = root.getChild("pine_giant").getChild("body").getChild("head");
	
		this.walkAnimation = ModAnimations.PINE_GIANT_WALK.bake(root);
		this.idleAnimation = ModAnimations.PINE_GIANT_IDLE.bake(root);
		this.attackAnimation = ModAnimations.PINE_GIANT_ATTACK.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition pine_giant = modelPartData.addOrReplaceChild("pine_giant", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body = pine_giant.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 37).addBox(-5.0F, -16.5F, -3.0F, 10.0F, 17.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -37.5F, 0.0F));

		body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(13, 80).addBox(-6.0F, -10.0F, -5.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-9.0F, -10.0F, -9.0F, 18.0F, 5.0F, 18.0F, new CubeDeformation(0.0F))
				.texOffs(12, 75).addBox(-1.5F, -11.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.5F, 0.0F));

		PartDefinition arm_r = body.addOrReplaceChild("arm_r", CubeListBuilder.create().texOffs(44, 23).addBox(0.0F, 0.0F, -1.5F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -15.5F, 0.0F));

		PartDefinition mushrooms_r = arm_r.addOrReplaceChild("mushrooms_r", CubeListBuilder.create().texOffs(62, 12).addBox(8.0F, -28.0F, 1.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 53.0F, 0.0F));

		mushrooms_r.addOrReplaceChild("mushroom_r1", CubeListBuilder.create().texOffs(8, 5).addBox(-1.0F, -1.5F, 1.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -50.5F, -2.5F, 0.0F, 0.0F, 0.0F));

		mushrooms_r.addOrReplaceChild("mushroom_r2", CubeListBuilder.create().texOffs(34, 28).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -37.5F, -1.5F, 0.0F, 3.1416F, 0.0F));

		mushrooms_r.addOrReplaceChild("mushroom_r3", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 20.5F, -1.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(34, 23).addBox(-1.0F, 0.5F, -1.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -50.5F, -2.5F, 0.0F, 1.5708F, 0.0F));

		mushrooms_r.addOrReplaceChild("mushroom_r4", CubeListBuilder.create().texOffs(54, 12).addBox(0.0F, 4.5F, 2.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -50.5F, 1.5F, 0.0F, -1.5708F, 0.0F));

		PartDefinition arm_l = body.addOrReplaceChild("arm_l", CubeListBuilder.create().texOffs(32, 37).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -15.5F, 0.0F));

		PartDefinition mushrooms_l = arm_l.addOrReplaceChild("mushrooms_l", CubeListBuilder.create().texOffs(0, 10).addBox(-12.0F, -41.0F, 1.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 5).addBox(-12.0F, -25.0F, 1.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 53.0F, 0.0F));

		mushrooms_l.addOrReplaceChild("mushroom_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -25.5F, -3.5F, 0.0F, -1.5708F, 0.0F));

		mushrooms_l.addOrReplaceChild("mushroom_r6", CubeListBuilder.create().texOffs(0, 23).addBox(1.5F, 13.5F, -1.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -50.5F, 0.0F, 0.0F, 1.5708F, 0.0F));

		mushrooms_l.addOrReplaceChild("mushroom_r7", CubeListBuilder.create().texOffs(8, 10).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -27.5F, 3.5F, 0.0F, 1.5708F, 0.0F));

		mushrooms_l.addOrReplaceChild("mushroom_r8", CubeListBuilder.create().texOffs(0, 28).addBox(-1.0F, 1.5F, -1.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -50.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		pine_giant.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(54, 0).addBox(-2.0F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(56, 23).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -37.0F, 0.0F));

		pine_giant.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 60).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 37.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 60).addBox(-3.0F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -37.0F, 0.0F));
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
		headPitch = Mth.clamp(headPitch, -80.0f, 0.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}