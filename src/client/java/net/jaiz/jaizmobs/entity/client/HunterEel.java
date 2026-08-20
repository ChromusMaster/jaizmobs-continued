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

public final class HunterEel extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart head;

	public HunterEel(ModelPart root) {
		super(root);
		this.head = root.getChild("hunter_eel").getChild("head");
	
		this.walkAnimation = ModAnimations.HUNTER_EEL_SWIM.bake(root);
		this.idleAnimation = ModAnimations.HUNTER_EEL_IDLE.bake(root);
		this.attackAnimation = ModAnimations.HUNTER_EEL_ATTACK.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition hunter_eel = modelPartData.addOrReplaceChild("hunter_eel", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition head = hunter_eel.addOrReplaceChild("head", CubeListBuilder.create().texOffs(13, 16).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 7.0F));

		PartDefinition bottom_jaw = head.addOrReplaceChild("bottom_jaw", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.2321F, -0.1703F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.2321F, 0.1703F));

		bottom_jaw.addOrReplaceChild("beard_r1", CubeListBuilder.create().texOffs(0, 24).addBox(0.0F, -1.5F, -2.25F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.7679F, 3.8297F, -0.1745F, 0.0F, 0.0F));

		PartDefinition segment1 = hunter_eel.addOrReplaceChild("segment1", CubeListBuilder.create().texOffs(17, 23).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(28, 7).addBox(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(32, 22).addBox(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 7.0F));

		PartDefinition segment2 = segment1.addOrReplaceChild("segment2", CubeListBuilder.create().texOffs(28, 2).addBox(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(32, 12).addBox(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(7, 23).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition segment3 = segment2.addOrReplaceChild("segment3", CubeListBuilder.create().texOffs(27, 17).addBox(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).addBox(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(22, 15).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition segment4 = segment3.addOrReplaceChild("segment4", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(30, 30).addBox(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition segment5 = segment4.addOrReplaceChild("segment5", CubeListBuilder.create().texOffs(26, 25).addBox(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(24, 30).addBox(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 21).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition segment6 = segment5.addOrReplaceChild("segment6", CubeListBuilder.create().texOffs(20, 25).addBox(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 30).addBox(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 10).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition segment7 = segment6.addOrReplaceChild("segment7", CubeListBuilder.create().texOffs(14, 25).addBox(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 5).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 30).addBox(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition segment8 = segment7.addOrReplaceChild("segment8", CubeListBuilder.create().texOffs(8, 25).addBox(0.0F, 1.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(12, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(6, 30).addBox(0.0F, -6.0F, -3.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		segment8.addOrReplaceChild("segment9", CubeListBuilder.create().texOffs(32, 0).addBox(-0.75F, -0.75F, -3.0F, 1.5F, 1.5F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(0.0F, -6.0F, -9.0F, 0.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));
		return LayerDefinition.create(modelData, 42, 42);
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
		headPitch = Mth.clamp(headPitch, -20.0f, 0.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}