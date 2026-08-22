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

import java.util.HashMap;

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

    public static HashMap<Item, Item> getTeaRecipes() {
        HashMap<Item, Item> recipes = new HashMap<>();
        recipes.put(Items.WITHER_ROSE, ModItems.WITHER_ROSE_TEA);
        recipes.put(Items.CHORUS_FRUIT, ModItems.CHORUS_FRUIT_TEA);
        recipes.put(Items.DANDELION, ModItems.FLOWER_TEA);
        recipes.put(Items.POPPY, ModItems.FLOWER_TEA);
        recipes.put(Items.BLUE_ORCHID, ModItems.FLOWER_TEA);
        recipes.put(Items.ALLIUM, ModItems.FLOWER_TEA);
        recipes.put(Items.AZURE_BLUET, ModItems.FLOWER_TEA);
        recipes.put(Items.RED_TULIP, ModItems.FLOWER_TEA);
        recipes.put(Items.ORANGE_TULIP, ModItems.FLOWER_TEA);
        recipes.put(Items.WHITE_TULIP, ModItems.FLOWER_TEA);
        recipes.put(Items.PINK_TULIP, ModItems.FLOWER_TEA);
        recipes.put(Items.OXEYE_DAISY, ModItems.FLOWER_TEA);
        recipes.put(Items.CORNFLOWER, ModItems.FLOWER_TEA);
        recipes.put(Items.LILAC, ModItems.FLOWER_TEA);
        recipes.put(Items.LILY_OF_THE_VALLEY, ModItems.FLOWER_TEA);
        recipes.put(Items.SUNFLOWER, ModItems.FLOWER_TEA);
        recipes.put(Items.PEONY, ModItems.FLOWER_TEA);
        recipes.put(Items.ROSE_BUSH, ModItems.FLOWER_TEA);
        recipes.put(Items.GLOW_BERRIES, ModItems.GLOW_BERRY_TEA);
        recipes.put(Items.SPORE_BLOSSOM, ModItems.SPORE_BLOSSOM_TEA);
        recipes.put(Items.GUNPOWDER, ModItems.GUNPOWDER_GREEN_TEA);
        recipes.put(Items.FERN, ModItems.HERBAL_TEA);
        recipes.put(Items.RED_MUSHROOM, ModItems.HERBAL_TEA);
        recipes.put(Items.BROWN_MUSHROOM, ModItems.HERBAL_TEA);
        recipes.put(Items.WHEAT, ModItems.KOMBUCHA_TEA);
        recipes.put(Items.KELP, ModItems.KOMBUCHA_TEA);
        recipes.put(Items.WARPED_FUNGUS, ModItems.WARPED_NETHER_FUNGUS_TEA);
        recipes.put(Items.CRIMSON_FUNGUS, ModItems.NETHER_FUNGUS_TEA);
        recipes.put(Items.BOOK, ModItems.NOVEL_TEA);
        recipes.put(Items.PUMPKIN, ModItems.PUMPKIN_SPICE_TEA);
        recipes.put(Items.PITCHER_PLANT, ModItems.PITCHER_PLANT_TEA);
        recipes.put(Items.TORCHFLOWER, ModItems.TORCH_FLOWER_TEA);
        return recipes;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockState blockStatetrue = state.setValue(HAS_CUP, true);
        BlockState blockStatefalse = state.setValue(HAS_CUP, false);

        if ((stack.is(ModItems.TEA_CUP) && !state.getValue(HAS_CUP))) {
            world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                    (double)pos.getZ() + 0.5, SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
            stack.consume(1, player);
            world.setBlock(pos, blockStatetrue, Block.UPDATE_ALL);
            return InteractionResult.SUCCESS;
        }
        else if(state.getValue(HAS_CUP)){
            HashMap<Item, Item> recipes = getTeaRecipes();
            if (recipes.containsKey(stack.getItem())) {
                ItemStack output = recipes.get(stack.getItem()).getDefaultInstance();
                popResource(world, pos, output);
            }
            if ((stack.is(ModTags.Items.TEA_INGREDIENT))) {
            world.setBlock(pos, blockStatefalse, Block.UPDATE_ALL);
            world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5,
                    (double)pos.getZ() + 0.5, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (!player.getAbilities().instabuild) {stack.shrink(1);}}

            return super.useItemOn(stack, state, world, pos, player, hand, hit);
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, HAS_CUP);
    }
    
}
