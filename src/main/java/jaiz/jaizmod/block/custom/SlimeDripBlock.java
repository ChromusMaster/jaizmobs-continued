package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SlimeDripBlock extends Block {
    public SlimeDripBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 1) {
            BlockPos blockPos = pos.below();
            BlockState blockState = world.getBlockState(blockPos);
            BlockState blockStategrowth = ModBlocks.SLIME_DRIP.defaultBlockState();

            if (blockState.is(BlockTags.AIR)) {
                world.setBlockAndUpdate(blockPos, blockStategrowth);
            }
        }
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
