package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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

@Environment(value = EnvType.CLIENT)
public final class StarFishLeader extends EntityModel<JaizMobRenderState> {
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation idleAnimation;
	private final ModelPart star_fish_leader;

	public StarFishLeader(ModelPart root) {
		super(root);
		this.star_fish_leader = root.getChild("star_fish_leader");
	
		this.walkAnimation = ModAnimations.STAR_FISH_LEADER_IDLE.bake(root);
		this.idleAnimation = ModAnimations.STAR_FISH_LEADER_SWIM.bake(root);
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition star_fish_leader = modelPartData.addOrReplaceChild("star_fish_leader", CubeListBuilder.create(), PartPose.offset(0.0F, 18.5F, -1.5F));

		PartDefinition body = star_fish_leader.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.5F, -3.5F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(0.0F, -5.5F, -3.5F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 5).addBox(0.0F, 2.5F, -3.5F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.5F));

		PartDefinition left_fin = body.addOrReplaceChild("left_fin", CubeListBuilder.create(), PartPose.offset(1.0F, 1.0F, -1.5F));

		PartDefinition cube_r1 = left_fin.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(11, 0).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition right_fin = body.addOrReplaceChild("right_fin", CubeListBuilder.create(), PartPose.offset(-1.0F, 1.0F, -1.5F));

		PartDefinition cube_r2 = right_fin.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.5F, 0.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0F));
		return LayerDefinition.create(modelData, 24, 24);
	}

	@Override
	public void setupAnim(JaizMobRenderState state) {
		super.setupAnim(state);
		this.walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 2f, 2.5f);
		this.idleAnimation.apply(state.idleAnimationState, state.ageInTicks * 1f);
	}

}