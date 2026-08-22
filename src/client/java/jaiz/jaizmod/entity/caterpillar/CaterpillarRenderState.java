package jaiz.jaizmod.entity.caterpillar;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

@Environment(EnvType.CLIENT)
public class CaterpillarRenderState extends LivingEntityRenderState {
    public Object texture;
}
