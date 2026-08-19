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

public final class EmberBeetle extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final ModelPart emberbeetle;
	private final ModelPart head;

	public EmberBeetle(ModelPart root) {
		super(root);
		this.emberbeetle = root.getChild("emberbeetle");
		this.head = emberbeetle.getChild("base").getChild("head");
	
		this.walkAnimation = ModAnimations.EMBERBEETLE_FLY.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition emberbeetle = modelPartData.addOrReplaceChild("emberbeetle", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition base = emberbeetle.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 4).addBox(-1.5F, 0.0F, -0.4167F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 4).addBox(1.5F, 0.0F, -0.4167F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 9).addBox(-1.5F, 0.0F, -1.9167F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 10).addBox(1.5F, 0.0F, -1.9167F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -1.0F, -1.9167F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 2).addBox(-1.0F, -2.0F, -1.9167F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.9167F));

		PartDefinition head = base.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(0.5F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.9167F));

		PartDefinition shell = base.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -1.9167F));

		PartDefinition shell_l = shell.addOrReplaceChild("shell_l", CubeListBuilder.create().texOffs(8, 7).addBox(0.0F, -2.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition shell_r = shell.addOrReplaceChild("shell_r", CubeListBuilder.create().texOffs(0, 5).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wing_l = shell.addOrReplaceChild("wing_l", CubeListBuilder.create().texOffs(6, 0).addBox(0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition wing_r = shell.addOrReplaceChild("wing_r", CubeListBuilder.create().texOffs(4, 5).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));
		return LayerDefinition.create(modelData, 24, 24);
	}

	@Override
	public void setupAnim(JaizMobRenderState state) {
		super.setupAnim(state);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
		this.setHeadAngles(state.yRot, state.xRot);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -10.0f, 10.0f);
		headPitch = Mth.clamp(headPitch, -10.0f, 10.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}