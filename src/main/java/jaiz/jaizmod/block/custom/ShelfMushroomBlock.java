package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import net.minecraft.world.level.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ShelfMushroomBlock extends Block{

    public static final IntegerProperty SIZE = ModBlocks.SIZE;

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final VoxelShape NORTH_LARGE_SHELF = Block.box(1, 13, 3, 15, 16, 16);
    private static final VoxelShape NORTH_MEDIUM_SHELVES = Shapes.join(Block.box(5, 9, 9, 13, 11, 16), Block.box(1, 5, 5, 14, 7, 16), BooleanOp.OR);
    private static final VoxelShape NORTH_SMALL_SHELVES = Stream.of(
            Block.box(10, 4, 11, 15, 5, 16),
            Block.box(6, 10, 9, 13, 11, 16),
            Block.box(0, 7, 7, 10, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SOUTH_LARGE_SHELF = Block.box(1, 13, 0, 15, 16, 13);
    private static final VoxelShape SOUTH_MEDIUM_SHELVES = Shapes.join(Block.box(3, 9, 0, 11, 11, 7), Block.box(2, 5, 0, 15, 7, 11), BooleanOp.OR);
    private static final VoxelShape SOUTH_SMALL_SHELVES = Stream.of(
            Block.box(1, 4, 0, 6, 5, 5),
            Block.box(3, 10, 0, 10, 11, 7),
            Block.box(6, 7, 0, 16, 8, 9)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    private static final VoxelShape WEST_LARGE_SHELF = Block.box(3, 13, 1, 16, 16, 15);
    private static final VoxelShape EAST_MEDIUM_SHELVES = Shapes.join(Block.box(0, 9, 5, 7, 11, 13), Block.box(0, 5, 1, 11, 7, 14), BooleanOp.OR);
    private static final VoxelShape EAST_SMALL_SHELVES = Stream.of(
            Block.box(0, 4, 10, 5, 5, 15),
            Block.box(0, 10, 6, 7, 11, 13),
            Block.box(0, 7, 0, 9, 8, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    private static final VoxelShape EAST_LARGE_SHELF = Block.box(0, 13, 1, 13, 16, 15);
    private static final VoxelShape WEST_MEDIUM_SHELVES = Shapes.join(Block.box(9, 9, 3, 16, 11, 11), Block.box(5, 5, 2, 16, 7, 15), BooleanOp.OR);
    private static final VoxelShape WEST_SMALL_SHELVES = Stream.of(
            Block.box(11, 4, 1, 16, 5, 6),
            Block.box(9, 10, 3, 16, 11, 10),
            Block.box(7, 7, 6, 16, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

    public ShelfMushroomBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(SIZE, 2).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }


    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState;
        if (!ctx.replacingClickedOnBlock() && (blockState = ctx.getLevel().getBlockState(ctx.getClickedPos().relative(ctx.getClickedFace().getOpposite()))).is(this) && blockState.getValue(FACING) == ctx.getClickedFace()) {
            return null;
        }
        blockState = this.defaultBlockState();
        Level worldView = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        for (Direction direction : ctx.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction2 = direction.getOpposite();
                blockState = blockState.setValue(FACING, direction2)
                        .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);;
                if (blockState.canSurvive(worldView, blockPos)) {
                    return blockState;
                }
            }
        }
        return null;
    }


    @Override
    public BlockState updateShape(
            BlockState state,
            LevelReader world,
            ScheduledTickAccess tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            RandomSource random
    ) {
        if (direction.getOpposite() == state.getValue(FACING) && !state.canSurvive(world, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        if (state.getValue(WATERLOGGED)) {
            tickView.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }



    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }



    private boolean canPlaceOn(BlockGetter world, BlockPos pos, Direction side) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isFaceSturdy(world, pos, side);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        return this.canPlaceOn(world, pos.relative(direction.getOpposite()), direction);
    }


    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }


    private static boolean shearItem(ItemStack stack) {
        return stack.is(Items.SHEARS);
    }

    private static boolean growItem(ItemStack stack) {
        return stack.is(Items.BONE_MEAL);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (ShelfMushroomBlock.shearItem(itemStack) && ShelfMushroomBlock.shearable(state)) {
            ShelfMushroomBlock.shear(player, world, pos, state);
            if (!player.getAbilities().instabuild) {
                stack.hurtAndBreak(1, player, hand);
            }
        }

        if (ShelfMushroomBlock.growItem(itemStack)) {
            ShelfMushroomBlock.popResource(world, pos, new ItemStack(ModBlocks.SHELF_MUSHROOM_BLOCK));
            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1);
            }
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    private static boolean shearable(BlockState state) {
        return state.getValue(SIZE) > 0;
    }

    public static void shear(@Nullable Entity charger, Level world, BlockPos pos, BlockState state) {
        BlockState blockState = (BlockState)state.setValue(SIZE, state.getValue(SIZE) - 1);
        world.setBlock(pos, blockState, Block.UPDATE_ALL);
        world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(charger, blockState));
        world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BEEHIVE_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    @Override
    public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        if (entity.isSuppressingBounce()) {
            super.fallOn(world, state, pos, entity, fallDistance);
        } else {
            entity.causeFallDamage(fallDistance, 0.0f, world.damageSources().fall());
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case EAST: {
                if (state.getValue(SIZE) == 2) {
                    return EAST_LARGE_SHELF;
                } else if (state.getValue(SIZE) == 1) {
                    return EAST_MEDIUM_SHELVES;
                }
                return EAST_SMALL_SHELVES;
            }
            case SOUTH: {
                if (state.getValue(SIZE) == 2) {
                    return SOUTH_LARGE_SHELF;
                } else if (state.getValue(SIZE) == 1) {
                    return SOUTH_MEDIUM_SHELVES;
                }
                return SOUTH_SMALL_SHELVES;
            }
            case WEST: {
                if (state.getValue(SIZE) == 2) {
                    return WEST_LARGE_SHELF;
                } else if (state.getValue(SIZE) == 1) {
                    return WEST_MEDIUM_SHELVES;
                }
                return WEST_SMALL_SHELVES;
            }
        }
        if (state.getValue(SIZE) == 2) {
            return NORTH_LARGE_SHELF;
        } else if (state.getValue(SIZE) == 1) {
            return NORTH_MEDIUM_SHELVES;
        }
        return NORTH_SMALL_SHELVES;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SIZE, FACING, WATERLOGGED);
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
