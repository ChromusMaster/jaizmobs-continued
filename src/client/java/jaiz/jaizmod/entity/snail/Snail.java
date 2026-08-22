package jaiz.jaizmod.entity.snail;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import jaiz.jaizmod.entity.bandit.BanditEntity;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class Snail extends EntityModel<LivingEntityRenderState> {

	private final ModelPart snail;
	private final KeyframeAnimation idleAnimation;

	public Snail(ModelPart root) {
        super(root);
        this.snail = root.getChild("snail");
        this.idleAnimation = PlantsAndJunkModAnimations.SNAIL_IDLE.bake(root);
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition snail = modelPartData.addOrReplaceChild("snail", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition shell = snail.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(0.5F, -2.5F, -1.5F));

		PartDefinition shell_r1 = shell.addOrReplaceChild("shell_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2577F, 2.9014F, -0.3491F, 0.0F, 0.0F));

		PartDefinition eye_l = snail.addOrReplaceChild("eye_l", CubeListBuilder.create(), PartPose.offset(0.9441F, -1.9744F, -3.75F));

		PartDefinition eye_l_r1 = eye_l.addOrReplaceChild("eye_l_r1", CubeListBuilder.create().texOffs(0, 2).addBox(-0.5F, -1.75F, 0.25F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0559F, -0.0256F, -0.25F, 0.0F, 0.0F, 0.2618F));

		PartDefinition eye_r = snail.addOrReplaceChild("eye_r", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -3.75F));

		PartDefinition eye_r_r1 = eye_r.addOrReplaceChild("eye_r_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -1.75F, 0.25F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.2618F));

		PartDefinition body = snail.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -4.5F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.0F, 0.5F));
		return LayerDefinition.create(modelData, 32, 32);
	}

	@Override
	public void setupAnim(LivingEntityRenderState entity) {
		super.setupAnim(entity);
		this.idleAnimation.applyWalk(entity.walkAnimationPos, entity.walkAnimationSpeed, 3.0F, 5.0F);
	}

	public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		snail.render(matrices, vertexConsumer, light, overlay);
	}

	public ModelPart getPart() {
		return snail;
	}

}
