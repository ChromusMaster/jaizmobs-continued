package jaiz.jaizmod.entity.bandit;


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
import net.minecraft.client.model.*;
import net.minecraft.world.entity.HumanoidArm;

public class Bandit extends EntityModel<BanditRenderState> implements ArmedModel<BanditRenderState> {


	private final ModelPart bandit;
	private final ModelPart head;
	private final ModelPart hands;
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation attackAnimation;

	protected Bandit(ModelPart root) {
		super(root);
		this.bandit = root.getChild("bandit");
		this.hands = root.getChild("bandit").getChild("body").getChild("arms").getChild("item");
		this.head = bandit.getChild("body").getChild("head");
		this.walkAnimation = DunesAndDroughtAnimations.BANDIT_WALK.bake(root);
		this.attackAnimation = DunesAndDroughtAnimations.BANDIT_ATTACK.bake(root);
	}


	public static LayerDefinition getTexturedModelData() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition bandit = modelPartData.addOrReplaceChild("bandit", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition leg_l = bandit.addOrReplaceChild("leg_l", CubeListBuilder.create().texOffs(28, 36).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition leg_r = bandit.addOrReplaceChild("leg_r", CubeListBuilder.create().texOffs(44, 36).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition body = bandit.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 36).addBox(-4.0F, -12.0F, -3.0F, 8.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.0F, -12.0F, -3.0F, 8.0F, 20.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 18).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 0).addBox(-4.0F, -9.25F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.51F)), PartPose.offset(0.0F, -12.0F, 0.0F));


		PartDefinition arms = body.addOrReplaceChild("arms", CubeListBuilder.create().texOffs(44, 15).addBox(-4.0F, 2.7F, -2.55F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 52).addBox(-8.0F, -1.3F, -2.55F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(52, 23).addBox(4.0F, -1.3F, -2.55F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.25F, -0.5F, -0.7418F, 0.0F, 0.0F));

		PartDefinition item = arms.addOrReplaceChild("item", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 3.0F, -19.9F, 0.0F, 0.0F));


		return LayerDefinition.create(modelData, 80, 80);
	}

	public void render(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bandit.render(matrices, vertexConsumer, light, overlay);
	}


	@Override
	public void setupAnim(BanditRenderState entity) {
		super.setupAnim(entity);
		this.head.xRot = entity.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = entity.yRot * (float) (Math.PI / 180.0);
		this.walkAnimation.applyWalk(entity.walkAnimationPos, entity.walkAnimationSpeed, 3.0F, 5.0F);
		this.attackAnimation.apply(entity.attackAnimationState, entity.ageInTicks, 1.0F);
		this.attackAnimation.apply(entity.tradeAnimationState, entity.ageInTicks, 1.0F);
	}

	public ModelPart getPart() {
		return bandit;
	}

	@Override
	public void translateToHand(BanditRenderState state, HumanoidArm arm, PoseStack matrices) {
		this.hands.translateAndRotate(matrices);
	}
}
