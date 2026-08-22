package jaiz.jaizmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockState;

public class UndergrowthBlock extends CarpetBlock {

    public UndergrowthBlock(Properties settings) {
        super(settings);
    }


    protected boolean canPlantOnTop(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.isCollisionShapeFullBlock(world, pos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockPos blockPos = pos.below();
        return this.canPlantOnTop(world.getBlockState(blockPos), world, blockPos);
    }




}
