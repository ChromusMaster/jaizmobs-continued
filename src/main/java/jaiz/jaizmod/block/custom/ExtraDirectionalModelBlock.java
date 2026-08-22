package jaiz.jaizmod.block.custom;

import net.minecraft.core.Direction;
import net.minecraft.core.FrontAndTop;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ExtraDirectionalModelBlock extends Block {
    public ExtraDirectionalModelBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, FrontAndTop.NORTH_UP));
    }
    private static final EnumProperty<FrontAndTop> FACING = BlockStateProperties.ORIENTATION;


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction direction = ctx.getNearestLookingDirection().getOpposite();

        Direction direction2 = switch (direction) {
            case DOWN -> ctx.getHorizontalDirection().getOpposite();
            case UP -> ctx.getHorizontalDirection();
            case NORTH, SOUTH, WEST, EAST -> Direction.UP;
        };
        return this.defaultBlockState()
                .setValue(FACING, FrontAndTop.fromFrontAndTop(direction, direction2));
    }

    @Override
    protected BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotation().rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(FACING, mirror.rotation().rotate(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
