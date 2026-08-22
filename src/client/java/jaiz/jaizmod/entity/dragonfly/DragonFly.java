// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package jaiz.jaizmod.entity.dragonfly;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import jaiz.jaizmod.entity.butterfly.ButterflyRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class DragonFly extends EntityModel<DragonflyRenderState> {

	private final ModelPart dragonFly;
	private final KeyframeAnimation flyingAnimation;

	public DragonFly(ModelPart root) {
        super(root);
        this.dragonFly = root.getChild("dragonFly");
        this.flyingAnimation = PlantsAndJunkModAnimations.DRAGONFLY_FLY.bake(root);
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition DragonFly = modelPartData.addOrReplaceChild("dragonFly", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = DragonFly.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 4).mirror().addBox(1.5F, 2.0F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 4).addBox(-1.5F, 2.0F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(15, 9).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, -2.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -1.5F, -3.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -2.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

		PartDefinition left_wings = body.addOrReplaceChild("left_wings", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition l_1 = left_wings.addOrReplaceChild("l_1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 14.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -3.0F, -4.0F));

		PartDefinition l_2 = left_wings.addOrReplaceChild("l_2", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(0.0F, 0.1F, 0.0F, 14.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, -3.0F, -1.0F));

		PartDefinition right_wings = body.addOrReplaceChild("right_wings", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition r_1 = right_wings.addOrReplaceChild("r_1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, 0.0F, 0.0F, 14.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, -3.0F, -4.0F));

		PartDefinition r_2 = right_wings.addOrReplaceChild("r_2", CubeListBuilder.create().texOffs(0, 5).addBox(-14.0F, 0.1F, 0.0F, 14.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.0F, -1.0F));
		return LayerDefinition.create(modelData, 32, 32);
	}


	public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		dragonFly.render(matrices, vertexConsumer, light, overlay);
	}

	public ModelPart getPart() {
		return dragonFly;
	}

	@Override
	public void setupAnim(DragonflyRenderState entity) {
		super.setupAnim(entity);
		this.flyingAnimation.apply(entity.flyingAnimationState, entity.ageInTicks);
	}
}
