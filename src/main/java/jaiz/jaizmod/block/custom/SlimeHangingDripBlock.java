package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.JaizMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SlimeHangingDripBlock extends HangingRootsBlock {
    public SlimeHangingDripBlock(Properties settings) {
        super(settings);
    }
    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        super.animateTick(state, world, pos, random);
        if (random.nextInt(10) == 0) {
            BlockPos blockPos = pos.below();
            BlockState blockState = world.getBlockState(blockPos);
            if (!isFaceFull(blockState.getCollisionShape(world, blockPos), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(world, pos, random, JaizMod.SLIME_DRIP_PARTICLE);
            }
        }
    }
}
