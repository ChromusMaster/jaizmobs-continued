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

public final class Enderwing extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart head;

	public Enderwing(ModelPart root) {
		super(root);
		this.head = root.getChild("enderwing").getChild("body");
		this.walkAnimation = ModAnimations.ENDERWING_FLY.bake(root);
		this.idleAnimation = ModAnimations.ENDERWING_FLY.bake(root);
		this.attackAnimation = ModAnimations.ENDERWING_ATTACK.bake(root);
	}

	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition enderwing = modelPartData.addOrReplaceChild("enderwing", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 31.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition body = enderwing.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 50).addBox(-8.0F, -3.0F, -8.0F, 16.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(81, 82).addBox(-3.0F, -3.0F, -11.0F, 6.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -8.0F));

		PartDefinition tail_2 = tail.addOrReplaceChild("tail_2", CubeListBuilder.create().texOffs(89, 0).addBox(-2.0F, -2.0F, -11.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -11.0F));

		tail_2.addOrReplaceChild("tail_3", CubeListBuilder.create().texOffs(89, 15).addBox(-1.0F, -1.0F, -11.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -11.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 77).addBox(-6.0F, -3.0F, -1.0F, 12.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 13.0F));

		head.addOrReplaceChild("bottom_jaw", CubeListBuilder.create().texOffs(46, 80).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -1.0F));

		body.addOrReplaceChild("wing_l", CubeListBuilder.create().texOffs(53, 56).addBox(-11.0F, -1.0F, -8.0F, 11.0F, 3.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(-32.0F, -1.0F, -12.0F, 32.0F, 0.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -2.0F, 0.0F));

		body.addOrReplaceChild("wing_r", CubeListBuilder.create().texOffs(68, 29).addBox(0.0F, -1.0F, -8.0F, 11.0F, 3.0F, 21.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -1.0F, -12.0F, 32.0F, 0.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -2.0F, 0.0F));
		return LayerDefinition.create(modelData, 152, 152);
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
		headYaw = Mth.clamp(headYaw, -60.0f, 60.0f);
		headPitch = Mth.clamp(headPitch, -60.0f, 60.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}