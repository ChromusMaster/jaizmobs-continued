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
import net.minecraft.client.model.geom.ModelPart;

public final class Warped_Truffler extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final ModelPart truffler;
	private final ModelPart head;

	public Warped_Truffler(ModelPart root) {
		super(root);
		this.truffler = root.getChild("truffler");
		this.head = truffler.getChild("body");
	
		this.walkAnimation = ModAnimations.TRUFFLER_WALK.bake(root);
		this.idleAnimation = ModAnimations.TRUFFLER_IDLE.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition truffler = modelPartData.addOrReplaceChild("truffler", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.0F));

		PartDefinition body = truffler.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -11.75F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(3, 14).addBox(-2.0F, -7.75F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.25F, 0.0F));

		PartDefinition leg_r = truffler.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, -1.5F));

		PartDefinition leg_r2 = truffler.addOrReplaceChild("leg_r2", CubeListBuilder.create(), PartPose.offset(1.5F, 0.0F, 1.5F));

		PartDefinition leg_l2 = truffler.addOrReplaceChild("leg_l2", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, 0.0F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, -1.75F));

		PartDefinition leg_l3 = truffler.addOrReplaceChild("leg_l3", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, 0.0F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 1.25F));

		PartDefinition leg_r3 = truffler.addOrReplaceChild("leg_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, 1.5F));
		return LayerDefinition.create(modelData, 44, 44);
	}

	@Override
	public void setupAnim(JaizMobRenderState state) {
		super.setupAnim(state);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks * 1f);
		this.setHeadAngles(state.yRot, state.xRot);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -10.0f, 10.0f);
		headPitch = Mth.clamp(headPitch, -10.0f, 10.0f);

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;

	}

}
