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

public final class SoulWader extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final ModelPart soul_wader;
	private final ModelPart head;

	public SoulWader(ModelPart root) {
		super(root);
		this.soul_wader = root.getChild("soul_wader");
		this.head = soul_wader.getChild("body").getChild("neck").getChild("head");
	
		this.walkAnimation = ModAnimations.SOULWADER_WALK.bake(root);
		this.idleAnimation = ModAnimations.SOULWADER_IDLE.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition soul_wader = modelPartData.addOrReplaceChild("soul_wader", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition body = soul_wader.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -13.0F, -23.5F, 16.0F, 13.0F, 31.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(-8.5F, -13.5F, -24.0F, 17.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -58.0F, 8.5F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(66, 44).addBox(-3.0F, -42.5F, -2.5F, 6.0F, 55.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.5F, -23.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(63, 0).addBox(-5.0F, -4.5F, -10.6667F, 10.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(104, 109).addBox(-4.0F, -3.5F, -18.6667F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(100, 53).addBox(-4.0F, -3.5F, -9.1667F, 8.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(124, 19).addBox(-3.0F, -3.25F, -17.1667F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -45.0F, 0.1667F));

		PartDefinition mane = neck.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(0, 76).addBox(-0.5F, -23.0F, -0.5F, 1.0F, 46.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -23.5F, 2.5F));

		PartDefinition beard = neck.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(24, 71).addBox(0.0F, -27.5F, -5.0F, 0.0F, 55.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, -2.5F));

		PartDefinition legs = soul_wader.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -62.0F, -2.0F));

		PartDefinition l_front = legs.addOrReplaceChild("l_front", CubeListBuilder.create().texOffs(34, 106).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -3.0F, -9.0F));

		PartDefinition l_front2 = l_front.addOrReplaceChild("l_front2", CubeListBuilder.create().texOffs(88, 94).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 47.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(50, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition l_back = legs.addOrReplaceChild("l_back", CubeListBuilder.create().texOffs(100, 23).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 2.0F, 11.0F));

		PartDefinition l_back2 = l_back.addOrReplaceChild("l_back2", CubeListBuilder.create().texOffs(63, 104).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 43.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(111, 6).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition r_front = legs.addOrReplaceChild("r_front", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -3.0F, -9.0F));

		PartDefinition r_front2 = r_front.addOrReplaceChild("r_front2", CubeListBuilder.create().texOffs(88, 44).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 47.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition r_back = legs.addOrReplaceChild("r_back", CubeListBuilder.create().texOffs(34, 76).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 2.0F, 11.0F));

		PartDefinition r_back2 = r_back.addOrReplaceChild("r_back2", CubeListBuilder.create().texOffs(100, 71).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 43.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(97, 0).addBox(-2.0F, -1.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 17.0F, 0.0F));
		return LayerDefinition.create(modelData, 156, 156);
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