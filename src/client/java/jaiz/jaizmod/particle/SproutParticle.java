package jaiz.jaizmod.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.ParticleLimit;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import java.util.Optional;

@Environment(EnvType.CLIENT)
public class SproutParticle extends SingleQuadParticle {

    SproutParticle(ClientLevel world, SpriteSet spriteProvider, double x, double y, double z, double velocityX, double velocityY, double velocityZ, RandomSource randomSource) {
        super(world, x, y - 0.125, z, velocityX, velocityY, velocityZ, spriteProvider.get(randomSource));
        this.setSize(0.01F, 0.01F);
        this.quadSize *= 0.5F;
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
        int k = i >> 16 & 0xFF;
        return 240 | k << 16;
    }

    @Environment(EnvType.CLIENT)
    public static class SproutParticleFactory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteProvider;

        public SproutParticleFactory(SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientWorld, double d, double e, double f, double g, double h, double i, RandomSource randomSource) {
            SproutParticle sproutParticle = new SproutParticle(clientWorld, this.spriteProvider, d, e, f, 0.0, -0.65F, 0.0, randomSource) {
                @Override
                public Optional<ParticleLimit> getParticleLimit() {
                    return Optional.of(ParticleLimit.SPORE_BLOSSOM);
                }
            };
            sproutParticle.lifetime = Mth.randomBetweenInclusive(randomSource, 200, 500);
            sproutParticle.gravity = 0.00F;
            return sproutParticle;
        }
    }

}

