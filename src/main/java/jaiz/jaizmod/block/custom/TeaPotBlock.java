package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.item.ModItems;
import jaiz.jaizmod.util.ModTags;
import net.minecraft.world.level.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class TeaPotBlock extends Block {
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HAS_CUP = ModBlocks.HAS_CUP;

    public static final VoxelShape BOTTOM_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0);
    public static final VoxelShape MIDDLE_SHAPE = Block.box(5.0, 4.0, 5.0, 11.0, 12.0, 11.0);
    public static final VoxelShape BASE_SHAPE = Shapes.or(BOTTOM_SHAPE, MIDDLE_SHAPE);

    public TeaPotBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH).setValue(HAS_CUP, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return BASE_SHAPE;
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        BlockState blockState = this.defaultBlockState();
        LevelReader worldView = ctx.getLevel();
        BlockPos blockPos = ctx.getClickedPos();
        Direction[] directions = ctx.getNearestLookingDirections();

        for (Direction direction : directions) {
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
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }


    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.2;
        double f = (double)pos.getZ() + 0.5;


        world.addParticle(ParticleTypes.FLAME, d, e, f, 0.0, 0.0, 0.0);

        if(state.getValue(FACING) == Direction.NORTH){
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.7, pos.getZ() + 0.1, 0.0, 0.0, 0.0);
        }
        else if(state.getValue(FACING) == Direction.SOUTH){
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.5, pos.getY() + 0.7, pos.getZ() + 0.9, 0.0, 0.0, 0.0);
        }
        else if(state.getValue(FACING) == Direction.WEST){
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.1, pos.getY() + 0.7, pos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }
        else if(state.getValue(FACING) == Direction.EAST){
            world.addParticle(ParticleTypes.SMOKE, pos.getX() + 0.9, pos.getY() + 0.7, pos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }

    }

    public static Map<Item, Item> getTeaRecipes() {
        return TeaRecipes.VALUES;
    }

    private static final class TeaRecipes {
        private static final Map<Item, Item> VALUES = Map.ofEntries(
                Map.entry(Items.WITHER_ROSE, ModItems.WITHER_ROSE_TEA),
                Map.entry(Items.CHORUS_FRUIT, ModItems.CHORUS_FRUIT_TEA),
                Map.entry(Items.DANDELION, ModItems.FLOWER_TEA),
                Map.entry(Items.POPPY, ModItems.FLOWER_TEA),
                Map.entry(Items.BLUE_ORCHID, ModItems.FLOWER_TEA),
                Map.entry(Items.ALLIUM, ModItems.FLOWER_TEA),
                Map.entry(Items.AZURE_BLUET, ModItems.FLOWER_TEA),
                Map.entry(Items.RED_TULIP, ModItems.FLOWER_TEA),
                Map.entry(Items.ORANGE_TULIP, ModItems.FLOWER_TEA),
                Map.entry(Items.WHITE_TULIP, ModItems.FLOWER_TEA),
                Map.entry(Items.PINK_TULIP, ModItems.FLOWER_TEA),
                Map.entry(Items.OXEYE_DAISY, ModItems.FLOWER_TEA),
                Map.entry(Items.CORNFLOWER, ModItems.FLOWER_TEA),
                Map.entry(Items.LILAC, ModItems.FLOWER_TEA),
                Map.entry(Items.LILY_OF_THE_VALLEY, ModItems.FLOWER_TEA),
                Map.entry(Items.SUNFLOWER, ModItems.FLOWER_TEA),
                Map.entry(Items.PEONY, ModItems.FLOWER_TEA),
                Map.entry(Items.ROSE_BUSH, ModItems.FLOWER_TEA),
                Map.entry(Items.GLOW_BERRIES, ModItems.GLOW_BERRY_TEA),
                Map.entry(Items.SPORE_BLOSSOM, ModItems.SPORE_BLOSSOM_TEA),
                Map.entry(Items.GUNPOWDER, ModItems.GUNPOWDER_GREEN_TEA),
                Map.entry(Items.FERN, ModItems.HERBAL_TEA),
                Map.entry(Items.RED_MUSHROOM, ModItems.HERBAL_TEA),
                Map.entry(Items.BROWN_MUSHROOM, ModItems.HERBAL_TEA),
                Map.entry(Items.WHEAT, ModItems.KOMBUCHA_TEA),
                Map.entry(Items.KELP, ModItems.KOMBUCHA_TEA),
                Map.entry(Items.WARPED_FUNGUS, ModItems.WARPED_NETHER_FUNGUS_TEA),
                Map.entry(Items.CRIMSON_FUNGUS, ModItems.NETHER_FUNGUS_TEA),
                Map.entry(Items.BOOK, ModItems.NOVEL_TEA),
                Map.entry(Items.PUMPKIN, ModItems.PUMPKIN_SPICE_TEA),
                Map.entry(Items.PITCHER_PLANT, ModItems.PITCHER_PLANT_TEA),
                Map.entry(Items.TORCHFLOWER, ModItems.TORCH_FLOWER_TEA)
        );
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (stack.is(ModItems.TEA_CUP) && !state.getValue(HAS_CUP)) {
            if (!world.isClientSide()) {
                world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                        (double)pos.getZ() + 0.5, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                stack.consume(1, player);
                world.setBlock(pos, state.setValue(HAS_CUP, true), Block.UPDATE_ALL);
            }
            return InteractionResult.SUCCESS;
        }
        if (state.getValue(HAS_CUP)) {
            Map<Item, Item> recipes = getTeaRecipes();
            Item output = recipes.get(stack.getItem());
            if (output != null && stack.is(ModTags.Items.TEA_INGREDIENT)) {
                if (!world.isClientSide()) {
                    popResource(world, pos, output.getDefaultInstance());
                    world.setBlock(pos, state.setValue(HAS_CUP, false), Block.UPDATE_ALL);
                    world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                            (double)pos.getZ() + 0.5, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
                    if (!player.getAbilities().instabuild) {
                        stack.shrink(1);
                    }
                }
                return InteractionResult.SUCCESS;
            }
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, HAS_CUP);
    }
    
}
