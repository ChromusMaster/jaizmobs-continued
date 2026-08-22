
package jaiz.jaizmod.entity.firefly;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public class Fireflies extends EntityModel<FireFlyRenderState> {
	private final ModelPart swarm;
	private final KeyframeAnimation flyingAnimation;

	public Fireflies(ModelPart root) {
        super(root);
        this.swarm = root.getChild("swarm");
        this.flyingAnimation = PlantsAndJunkModAnimations.FIRE_FLY_SWARM.bake(root);
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition Swarm = modelPartData.addOrReplaceChild("swarm", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition firefly = Swarm.addOrReplaceChild("firefly", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r1 = firefly.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly2 = Swarm.addOrReplaceChild("firefly2", CubeListBuilder.create().texOffs(4, 8).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r2 = firefly2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly3 = Swarm.addOrReplaceChild("firefly3", CubeListBuilder.create().texOffs(8, 3).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r3 = firefly3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly4 = Swarm.addOrReplaceChild("firefly4", CubeListBuilder.create().texOffs(8, 2).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r4 = firefly4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly5 = Swarm.addOrReplaceChild("firefly5", CubeListBuilder.create().texOffs(8, 1).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r5 = firefly5.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly6 = Swarm.addOrReplaceChild("firefly6", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r6 = firefly6.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly7 = Swarm.addOrReplaceChild("firefly7", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r7 = firefly7.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly8 = Swarm.addOrReplaceChild("firefly8", CubeListBuilder.create().texOffs(4, 7).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r8 = firefly8.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly9 = Swarm.addOrReplaceChild("firefly9", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r9 = firefly9.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly10 = Swarm.addOrReplaceChild("firefly10", CubeListBuilder.create().texOffs(4, 6).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r10 = firefly10.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly11 = Swarm.addOrReplaceChild("firefly11", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r11 = firefly11.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly12 = Swarm.addOrReplaceChild("firefly12", CubeListBuilder.create().texOffs(4, 5).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r12 = firefly12.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly13 = Swarm.addOrReplaceChild("firefly13", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r13 = firefly13.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly14 = Swarm.addOrReplaceChild("firefly14", CubeListBuilder.create().texOffs(4, 4).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r14 = firefly14.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly15 = Swarm.addOrReplaceChild("firefly15", CubeListBuilder.create().texOffs(4, 3).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r15 = firefly15.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly16 = Swarm.addOrReplaceChild("firefly16", CubeListBuilder.create().texOffs(4, 2).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r16 = firefly16.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly17 = Swarm.addOrReplaceChild("firefly17", CubeListBuilder.create().texOffs(4, 1).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r17 = firefly17.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly18 = Swarm.addOrReplaceChild("firefly18", CubeListBuilder.create().texOffs(4, 0).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r18 = firefly18.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly19 = Swarm.addOrReplaceChild("firefly19", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r19 = firefly19.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly20 = Swarm.addOrReplaceChild("firefly20", CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r20 = firefly20.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly21 = Swarm.addOrReplaceChild("firefly21", CubeListBuilder.create().texOffs(0, 2).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r21 = firefly21.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly22 = Swarm.addOrReplaceChild("firefly22", CubeListBuilder.create().texOffs(0, 1).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r22 = firefly22.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		PartDefinition firefly23 = Swarm.addOrReplaceChild("firefly23", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.5F, 0.0F));

		PartDefinition cube_r23 = firefly23.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(8, 4).addBox(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));
		return LayerDefinition.create(modelData, 16, 16);
	}
	public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		swarm.render(matrices, vertexConsumer, light, overlay);
	}

	public ModelPart getPart() {
		return swarm;
	}

	@Override
	public void setupAnim(FireFlyRenderState entity) {
		super.setupAnim(entity);
		this.flyingAnimation.apply(entity.flyingAnimationState, entity.ageInTicks);
	}
}
