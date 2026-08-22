package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.JaizMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AncientSproutBlock extends FlowerBlock {
    public AncientSproutBlock(Holder<MobEffect> stewEffect, float effectLengthInSeconds, Properties settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        Direction direction = Direction.fromYRot(random.nextDouble());
        double d = (double)pos.getX() + 0.55 - (double)(random.nextFloat() * 0.1F);
        double e = (double)pos.getY() + 0.55 - (double)(random.nextFloat() * 0.1F);
        double f = (double)pos.getZ() + 0.55 - (double)(random.nextFloat() * 0.1F);
        double g = (double)(0.4F - (random.nextFloat() + random.nextFloat()) * 0.4F);
        if (random.nextInt(5) == 0) {
            world.addParticle(
                    JaizMod.SPROUT_PARTICLE,
                    d + (double)direction.getStepX() * g,
                    e + (double)direction.getStepY() * g,
                    f + (double)direction.getStepZ() * g,
                    random.nextGaussian() * 0.001,
                    random.nextGaussian() * 0.001,
                    random.nextGaussian() * 0.001
            );
        }
    }
}
