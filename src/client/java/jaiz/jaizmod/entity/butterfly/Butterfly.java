// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package jaiz.jaizmod.entity.butterfly;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import jaiz.jaizmod.entity.animation.DunesAndDroughtAnimations;
import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import jaiz.jaizmod.entity.bandit.BanditRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Butterfly extends EntityModel<ButterflyRenderState> {

	private final ModelPart butterfly;
	private final KeyframeAnimation flyingAnimation;
	private final KeyframeAnimation idleAnimation;

	protected Butterfly(ModelPart root) {
		super(root);
		this.butterfly = root.getChild("butterfly");
		this.flyingAnimation = PlantsAndJunkModAnimations.BUTTERFLY.bake(root);
		this.idleAnimation = PlantsAndJunkModAnimations.BUTTERLY_IDLE.bake(root);
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition Butterfly = modelPartData.addOrReplaceChild("butterfly", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = Butterfly.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 18).addBox(-1.0F, -1.5F, -4.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 0.0F));

		PartDefinition wing_l = body.addOrReplaceChild("wing_l", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, 0.0F, -5.0F, 9.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -1.0F));

		PartDefinition wing_r = body.addOrReplaceChild("wing_r", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 0.0F, -5.0F, 9.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -1.0F));

		PartDefinition legs_l = body.addOrReplaceChild("legs_l", CubeListBuilder.create().texOffs(2, 2).addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 1).addBox(0.0F, 0.0F, -2.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(2, 0).addBox(0.0F, 0.0F, 1.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.5F, 0.5F));

		PartDefinition leg_r = body.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -2.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 1).addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(0.0F, 0.0F, 1.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.5F, 0.5F));

		PartDefinition antenna_r = body.addOrReplaceChild("antenna_r", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.5F, -4.0F));

		PartDefinition antenna_l = body.addOrReplaceChild("antenna_l", CubeListBuilder.create().texOffs(2, 0).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.5F, -4.0F));
		return LayerDefinition.create(modelData, 64, 64);
	}

	public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		butterfly.render(matrices, vertexConsumer, light, overlay);
	}

	public ModelPart getPart() {
		return butterfly;
		}

	@Override
	public void setupAnim(ButterflyRenderState entity) {
		super.setupAnim(entity);
		this.flyingAnimation.apply(entity.flyingAnimationState, entity.ageInTicks);
		this.idleAnimation.apply(entity.idleAnimationState, entity.ageInTicks);
	}

}
