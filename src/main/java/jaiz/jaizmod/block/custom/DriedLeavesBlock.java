package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.world.level.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.UntintedParticleLeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class DriedLeavesBlock extends UntintedParticleLeavesBlock {
    public static final IntegerProperty ROTTING = ModBlocks.ROTTING;
    private static final Direction[] ROTTING_DIRECTIONS = {
            Direction.UP,
            Direction.DOWN,
            Direction.EAST,
            Direction.WEST,
            Direction.NORTH,
            Direction.SOUTH
    };

    public DriedLeavesBlock(int chance, ParticleOptions particle, BlockBehaviour.Properties settings) {
        super(1.0f / chance, particle, settings);
        this.registerDefaultState(this.defaultBlockState().setValue(ROTTING, 0).setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return !(Boolean)state.getValue(PERSISTENT);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        super.randomTick(state, world, pos, random);

        if (state.getValue(ROTTING) != 1) {
            return;
        }

        BlockState driedState = ModBlocks.DRIED_LEAVES.defaultBlockState().setValue(ROTTING, 1).setValue(DISTANCE, 3);
        if (random.nextInt(100) == 1) {
            world.setBlockAndUpdate(pos, ModBlocks.DEAD_LEAVES.defaultBlockState().setValue(DISTANCE, 3));
        }

        for (Direction direction : ROTTING_DIRECTIONS) {
            if (random.nextInt(5) != 1) {
                continue;
            }
            BlockPos neighborPos = pos.relative(direction);
            if (world.getBlockState(neighborPos).is(ModTags.Blocks.ROTTABLE_LEAVES)) {
                world.setBlockAndUpdate(neighborPos, driedState);
            }
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT, ROTTING, WATERLOGGED);
    }

}
