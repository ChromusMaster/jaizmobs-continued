package jaiz.jaizmod.entity.mason_mouth;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import jaiz.jaizmod.entity.animation.DunesAndDroughtAnimations;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Masonmouth extends EntityModel<MasonMouthRenderState> {
	private final ModelPart masonmouth;
	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation attackAnimation;

	public Masonmouth(ModelPart root) {
        super(root);
        this.masonmouth = root.getChild("masonmouth");
        this.idleAnimation = DunesAndDroughtAnimations.MASON_MOUTH_IDLE.bake(root);
        this.attackAnimation = DunesAndDroughtAnimations.MASON_MOUTH_ATTACK.bake(root);
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition MasonMouth = modelPartData.addOrReplaceChild("masonmouth", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition pot = MasonMouth.addOrReplaceChild("pot", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -16.0F, -7.0F, 14.0F, 16.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 41).addBox(-3.5F, -17.0F, -3.5F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-4.0F, -20.0F, -4.0F, 8.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition mouth = MasonMouth.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(32, 30).addBox(-3.0F, -5.5F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.5F, 0.0F));

		PartDefinition jaw_1 = mouth.addOrReplaceChild("jaw_1", CubeListBuilder.create().texOffs(22, 47).addBox(0.0F, -4.0F, -3.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -5.5F, 0.0F));

		PartDefinition tooth_1 = jaw_1.addOrReplaceChild("tooth_1", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition tooth_1_r1 = tooth_1.addOrReplaceChild("tooth_1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition jaw_2 = mouth.addOrReplaceChild("jaw_2", CubeListBuilder.create().texOffs(42, 0).addBox(-3.0F, -4.0F, -3.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -5.5F, 0.0F));

		PartDefinition tooth_2 = jaw_2.addOrReplaceChild("tooth_2", CubeListBuilder.create(), PartPose.offset(0.0057F, -3.9807F, 0.0F));

		PartDefinition tooth_2_r1 = tooth_2.addOrReplaceChild("tooth_2_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0057F, -0.0193F, 0.0F, 0.0F, 0.0F, 0.0873F));
		return LayerDefinition.create(modelData, 64, 64);
	}

	public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		masonmouth.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public void setupAnim(MasonMouthRenderState entity) {
		super.setupAnim(entity);
		this.idleAnimation.apply(entity.idleAnimationState, entity.ageInTicks);
		this.attackAnimation.apply(entity.attackAnimationState, entity.ageInTicks);
	}

	public ModelPart getPart() {
		return masonmouth;
	}

}
