package jaiz.jaizmod.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleLimit;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import java.util.Optional;

@Environment(EnvType.CLIENT)
public class FireFlyParticle extends SingleQuadParticle {

    FireFlyParticle(ClientLevel world, SpriteSet spriteProvider, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y - 0.125, z, velocityX, velocityY, velocityZ, spriteProvider.get(world.getRandom()));
        this.setSize(0.01F, 0.01F);
        this.quadSize = this.quadSize * 0.5f ;
        this.lifetime = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = 0.0F;
    }

    @Override
    protected Layer getLayer() {
        return Layer.OPAQUE;
    }

    @Override
    public int getLightCoords(float tint) {
        int i = super.getLightCoords(tint);
        int j = 240;
        int k = i >> 16 & 0xFF;
        return 240 | k << 16;
    }



    @Environment(EnvType.CLIENT)
    public static class FireFlyParticleFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteProvider;

        public FireFlyParticleFactory(SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientWorld, double d, double e, double f, double g, double h, double i) {
            FireFlyParticle fireflyParticle = new FireFlyParticle(clientWorld, this.spriteProvider, d, e, f, 0.0, -0.8F, 0.0) {
                @Override
                public Optional<ParticleLimit> getParticleLimit() {
                    return Optional.of(ParticleLimit.SPORE_BLOSSOM);
                }
            };
            fireflyParticle.lifetime = Mth.randomBetweenInclusive(clientWorld.getRandom(), 500, 1000);
            fireflyParticle.gravity = 0.00F;
            return fireflyParticle;
        }
    }

}

