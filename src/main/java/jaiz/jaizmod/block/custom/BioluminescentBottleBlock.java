package jaiz.jaizmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BioluminescentBottleBlock extends LanternBlock {

    public BioluminescentBottleBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if(random.nextInt(2) == 1){
            int i = pos.getX();
            int j = pos.getY();
            int k = pos.getZ();
            double d = (double)i + random.nextDouble();
            double e = (double)j + 0.7;
            double f = (double)k + random.nextDouble();
            world.addParticle(ParticleTypes.GLOW, d, e, f, 0.0, 0.0, 0.0);
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
            int s = random.nextInt(15);

            for (int l = 0; l < s; l++) {
                mutable.set(i + Mth.nextInt(random, -10, 10), j - random.nextInt(10), k + Mth.nextInt(random, -10, 10));
                BlockState blockState = world.getBlockState(mutable);
                if (!blockState.isCollisionShapeFullBlock(world, mutable)) {
                    world.addParticle(
                            ParticleTypes.GLOW,
                            (double)mutable.getX() + random.nextDouble(),
                            (double)mutable.getY() + random.nextDouble() + random.nextInt(5),
                            (double)mutable.getZ() + random.nextDouble(),
                            0.0,
                            0.0,
                            0.0
                    );
                }
            }}
    }

}
