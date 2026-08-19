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

public final class TotemSpirit extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;
	private final ModelPart totem_spirit;
	private final ModelPart head;

	public TotemSpirit(ModelPart root) {
		super(root);
		this.totem_spirit = root.getChild("totem_spirit");
		this.head = totem_spirit.getChild("base").getChild("head");
	
		this.walkAnimation = ModAnimations.TOTEM_SPIRIT_WALK.bake(root);
		this.idleAnimation = ModAnimations.TOTEM_SPIRIT_IDLE.bake(root);
		this.attackAnimation = ModAnimations.TOTEM_SPIRIT_ATTACK.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition totem_spirit = modelPartData.addOrReplaceChild("totem_spirit", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition left_leg = totem_spirit.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).addBox(0.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -7.0F, 0.0F));

		PartDefinition right_leg = totem_spirit.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(28, 28).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -7.0F, 0.0F));

		PartDefinition base = totem_spirit.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(16, 32).addBox(-1.0F, -23.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition mid = base.addOrReplaceChild("mid", CubeListBuilder.create().texOffs(25, 9).addBox(-4.0F, -23.0F, -3.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition fist = mid.addOrReplaceChild("fist", CubeListBuilder.create().texOffs(24, 0).addBox(-2.0F, -20.0F, -2.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition doors = mid.addOrReplaceChild("doors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_door = doors.addOrReplaceChild("left_door", CubeListBuilder.create().texOffs(34, 40).addBox(0.0F, -23.0F, -4.0F, 4.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_door = doors.addOrReplaceChild("right_door", CubeListBuilder.create().texOffs(24, 40).addBox(-4.0F, -23.0F, -4.0F, 4.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = base.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-5.0F, -11.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, 0.0F));

		PartDefinition horn_L_r1 = head.addOrReplaceChild("horn_L_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -37.0F, -5.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		return LayerDefinition.create(modelData, 64, 64);
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