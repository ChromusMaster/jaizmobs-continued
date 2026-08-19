package net.jaiz.jaizmobs.entity.client;

import net.jaiz.jaizmobs.entity.client.state.JaizMobRenderState;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class GeyserBerry extends EntityModel<JaizMobRenderState> {
	private final ModelPart geyser_berry;
	public GeyserBerry(ModelPart root) {
		super(root);
		this.geyser_berry = root.getChild("geyser_berry");
	}
	public static LayerDefinition getLayerDefinition() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition geyser_berry = modelPartData.addOrReplaceChild("geyser_berry", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -10.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(-2.0F, -10.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(modelData, 32, 32);
	}

	@Override
	public void setupAnim(JaizMobRenderState state) {
		super.setupAnim(state);
	}
}