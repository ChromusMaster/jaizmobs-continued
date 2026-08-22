package jaiz.jaizmod.entity.fruit_bat;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
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

public class FruitBat extends EntityModel<FruitBatRenderState> {
	private final ModelPart fruitbat;
	private final ModelPart head;
	private final KeyframeAnimation flyingAnimation;
	private final KeyframeAnimation roostingAnimation;

	public FruitBat(ModelPart root) {
        super(root);
        this.fruitbat = root.getChild("fruitbat");
		this.head = fruitbat.getChild("body").getChild("head");
		this.flyingAnimation = FruitBatAnimations.FLY.bake(root);
		this.roostingAnimation = FruitBatAnimations.ROOST.bake(root);
	}


	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition fruitbat = modelPartData.addOrReplaceChild("fruitbat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = fruitbat.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition body_lower = body.addOrReplaceChild("body_lower", CubeListBuilder.create().texOffs(12, 24).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition legs = body_lower.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(16, 29).addBox(0.5F, -2.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 29).mirror().addBox(-1.5F, -2.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.0F, -2.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(8, 29).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ear_l = head.addOrReplaceChild("ear_l", CubeListBuilder.create().texOffs(22, 25).addBox(-1.5F, -3.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -4.0F, 0.0F));

		PartDefinition ear_r = head.addOrReplaceChild("ear_r", CubeListBuilder.create().texOffs(22, 25).mirror().addBox(-1.5F, -3.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -4.0F, 0.0F));

		PartDefinition wing_l = body.addOrReplaceChild("wing_l", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -4.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, 1.5F));

		PartDefinition wing_l2 = wing_l.addOrReplaceChild("wing_l2", CubeListBuilder.create().texOffs(14, 16).addBox(0.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 0.0F, 0.0F));

		PartDefinition wing_r = body.addOrReplaceChild("wing_r", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-6.0F, -4.0F, 0.0F, 6.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 3.0F, 1.5F));

		PartDefinition wing_r2 = wing_r.addOrReplaceChild("wing_r2", CubeListBuilder.create().texOffs(14, 16).mirror().addBox(-8.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.0F, 0.0F, 0.0F));
		return LayerDefinition.create(modelData, 64, 64);
	}

	public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		fruitbat.render(matrices, vertexConsumer, light, overlay);
	}


	public ModelPart getPart() {
		return fruitbat;
	}

	public void setupAnim(FruitBatRenderState FruitBatRenderState) {
		super.setupAnim(FruitBatRenderState);
		if (FruitBatRenderState.roosting) {
			this.setRoostingHeadAngles(FruitBatRenderState.yRot);
		}

		this.flyingAnimation.apply(FruitBatRenderState.flyingAnimationState, FruitBatRenderState.ageInTicks, 1.0F);
		this.roostingAnimation.apply(FruitBatRenderState.roostingAnimationState, FruitBatRenderState.ageInTicks, 1.0F);
	}
	private void setRoostingHeadAngles(float yaw) {
		this.head.yRot = yaw * (float) (Math.PI / 180.0);
	}

}
