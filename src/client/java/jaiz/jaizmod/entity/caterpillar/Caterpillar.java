// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package jaiz.jaizmod.entity.caterpillar;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import jaiz.jaizmod.entity.animation.DunesAndDroughtAnimations;
import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import jaiz.jaizmod.entity.butterfly.ButterflyEntity;
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

public class Caterpillar extends EntityModel<CaterpillarRenderState> {

	private final ModelPart caterpillar;
	private final KeyframeAnimation walkAnimation;

	public Caterpillar(ModelPart root) {
        super(root);
        this.caterpillar = root.getChild("caterpillar");
        this.walkAnimation = PlantsAndJunkModAnimations.CATERPILLAR_WALK.bake(root);
	}
	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition caterpillar = modelPartData.addOrReplaceChild("caterpillar", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = caterpillar.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.75F, -1.75F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 2).addBox(1.0F, -2.75F, -1.75F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(-1.5F, -0.75F, -0.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(15, 14).addBox(-1.5F, 2.25F, -0.75F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.25F, -7.25F));

		PartDefinition body = caterpillar.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.25F, -3.5F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-2.0F, 0.75F, -3.5F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.75F, -1.5F));

		PartDefinition back = caterpillar.addOrReplaceChild("back", CubeListBuilder.create().texOffs(17, 6).addBox(-1.5F, -2.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(15, 0).addBox(-1.5F, 0.5F, -2.5F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, 4.5F));
		return LayerDefinition.create(modelData, 64, 64);
	}


	public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		caterpillar.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public void setupAnim(CaterpillarRenderState entity) {
		super.setupAnim(entity);
		this.walkAnimation.applyWalk(entity.walkAnimationPos, entity.walkAnimationSpeed, 3.0F, 5.0F);
	}

	public ModelPart getPart() {
		return caterpillar;
	}
}
