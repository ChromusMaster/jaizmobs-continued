package jaiz.jaizmod.mixin;

import net.minecraft.client.model.*;
import net.minecraft.client.model.animal.sniffer.SnifferModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.SnifferRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
@Mixin(SnifferModel.class)
public abstract class SnifferModelMixin extends EntityModel<SnifferRenderState> {

    protected SnifferModelMixin(ModelPart root) {
        super(root);
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    public static LayerDefinition createBodyLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition modelPartData2 = modelPartData.addOrReplaceChild(PartNames.BONE, CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));
        PartDefinition modelPartData3 = modelPartData2.addOrReplaceChild(
                PartNames.BODY,
                CubeListBuilder.create()
                        .texOffs(62, 68)
                        .addBox(-12.5F, -14.0F, -20.0F, 25.0F, 29.0F, 40.0F, new CubeDeformation(0.0F))
                        .texOffs(62, 0)
                        .addBox(-12.5F, -14.0F, -20.0F, 25.0F, 24.0F, 40.0F, new CubeDeformation(0.5F))
                        .texOffs(87, 68)
                        .addBox(-12.5F, 12.0F, -20.0F, 25.0F, 0.0F, 40.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F)
        );
        modelPartData2.addOrReplaceChild(
                PartNames.RIGHT_FRONT_LEG,
                CubeListBuilder.create().texOffs(32, 87).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-7.5F, 10.0F, -15.0F)
        );
        modelPartData2.addOrReplaceChild(
                PartNames.RIGHT_MID_LEG,
                CubeListBuilder.create().texOffs(32, 105).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-7.5F, 10.0F, 0.0F)
        );
        modelPartData2.addOrReplaceChild(
                PartNames.RIGHT_HIND_LEG,
                CubeListBuilder.create().texOffs(32, 123).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-7.5F, 10.0F, 15.0F)
        );
        modelPartData2.addOrReplaceChild(
                PartNames.LEFT_FRONT_LEG,
                CubeListBuilder.create().texOffs(0, 87).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(7.5F, 10.0F, -15.0F)
        );
        modelPartData2.addOrReplaceChild(
                PartNames.LEFT_MID_LEG,
                CubeListBuilder.create().texOffs(0, 105).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(7.5F, 10.0F, 0.0F)
        );
        modelPartData2.addOrReplaceChild(
                PartNames.LEFT_HIND_LEG,
                CubeListBuilder.create().texOffs(0, 123).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(7.5F, 10.0F, 15.0F)
        );
        PartDefinition modelPartData4 = modelPartData3.addOrReplaceChild(
                PartNames.HEAD,
                CubeListBuilder.create()
                        .texOffs(8, 15)
                        .addBox(-6.5F, -7.5F, -11.5F, 13.0F, 18.0F, 11.0F, new CubeDeformation(0.0F))
                        .texOffs(8, 4)
                        .addBox(-6.5F, 7.5F, -11.5F, 13.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 6.5F, -19.48F)
        );
        modelPartData4.addOrReplaceChild(
                PartNames.LEFT_EAR,
                CubeListBuilder.create().texOffs(2, 0).addBox(0.0F, 0.0F, -3.0F, 1.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(6.51F, -7.5F, -4.51F)
        );
        modelPartData4.addOrReplaceChild(
                PartNames.RIGHT_EAR,
                CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-6.51F, -7.5F, -4.51F)
        );
        modelPartData4.addOrReplaceChild(
                PartNames.NOSE,
                CubeListBuilder.create().texOffs(10, 45).addBox(-6.5F, -2.0F, -9.0F, 13.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -4.5F, -11.5F)
        );
        modelPartData4.addOrReplaceChild(
                "lower_beak",
                CubeListBuilder.create().texOffs(10, 57).addBox(-6.5F, -7.0F, -8.0F, 13.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 2.5F, -12.5F)
        );

        modelPartData4.addOrReplaceChild("horn", CubeListBuilder.create().texOffs(78, 92).addBox(-15.0F, -17.5F, 18.5F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(78, 92).mirror().addBox(-1.0F, -17.5F, 18.5F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, 6.0F, -28.0F));

        return LayerDefinition.create(modelData, 192, 192);
    }
}
