package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import static net.minecraft.world.level.block.LeavesBlock.DISTANCE;
import static net.minecraft.world.level.block.LeavesBlock.PERSISTENT;

public class RottingLog extends RotatedPillarBlock {

    public static final IntegerProperty ROTTING = ModBlocks.ROTTING;

    public RottingLog(Properties settings) {
        super(settings);
        this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y).setValue(ROTTING, 0));
    }


    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 1) {
            return;
        }
        BlockPos blockPos = pos.above();
        BlockState blockState = world.getBlockState(blockPos);
        BlockState blockState2 = ModBlocks.ROTTEN_LOG.defaultBlockState().setValue(ROTTING, 1);
        BlockState blockState3 = ModBlocks.DRIED_LEAVES.defaultBlockState().setValue(ROTTING, 1).setValue(DISTANCE, 3);
        if(state.getValue(ROTTING) == 1){
        if (blockState.is(BlockTags.LOGS)) {
            world.setBlockAndUpdate(blockPos, blockState2);
        }
        if (blockState.is(ModTags.Blocks.ROTTABLE_LEAVES)) {
            world.setBlockAndUpdate(blockPos, blockState3);
        }
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS, ROTTING);
    }
}
