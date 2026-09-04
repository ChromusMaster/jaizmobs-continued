package jaiz.jaizmod.block.custom;


import jaiz.jaizmod.advancement.ModCriteria;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.AABB;

public class CocoonBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(5, 0, 5, 11, 8, 11);
    public static final IntegerProperty COCOON_HATCH = ModBlocks.COCOON_HATCH;

    public CocoonBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(COCOON_HATCH, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COCOON_HATCH);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public int getCOCOON_HATCHStage(BlockState state) {
        return state.getValue(COCOON_HATCH);
    }

    private boolean isReadyToCOCOON_HATCH(BlockState state) {
        return this.getCOCOON_HATCHStage(state) == 2;
    }

    private boolean isBroken(BlockState state) {
        return this.getCOCOON_HATCHStage(state) == 3;
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        Direction direction = Direction.DOWN;
        return Block.canSupportCenter(world, pos.relative(direction), direction.getOpposite());
    }


    @Override
    public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        if (!entity.isSuppressingBounce()) {
            entity.causeFallDamage(fallDistance, 0.0F, world.damageSources().fall());
            world.playSound(null, pos, SoundEvents.TURTLE_EGG_BREAK, SoundSource.BLOCKS, 0.2f, 0.5f);
            world.setBlock(pos, state.setValue(COCOON_HATCH, 3), Block.UPDATE_CLIENTS);
            if (!world.isClientSide()) {
                world.scheduleTick(pos, this, 100);
            }
        }
    }


    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (this.isBroken(state)) {
            world.removeBlock(pos, false);
            return;
        }
        if (!this.isReadyToCOCOON_HATCH(state)) {
            world.playSound(null, pos, SoundEvents.HONEY_BLOCK_STEP, SoundSource.BLOCKS, 0.2f, 0.9f + random.nextFloat() * 0.2f);
            world.setBlock(pos, state.setValue(COCOON_HATCH, this.getCOCOON_HATCHStage(state) + 1), Block.UPDATE_CLIENTS);
            int hatchTime = CocoonBlock.isAboveCOCOON_HATCHBooster(world, pos) ? 2200 : 4400;
            world.scheduleTick(pos, this, hatchTime / 3 + random.nextInt(3000));
            return;
        }
        world.playSound(null, pos, SoundEvents.HONEY_BLOCK_SLIDE, SoundSource.BLOCKS, 0.7f, 0.9f + random.nextFloat() * 0.2f);
        world.setBlock(pos, state.setValue(COCOON_HATCH, 3), Block.UPDATE_CLIENTS);
        world.scheduleTick(pos, this, 100);
        ModEntities.BUTTERFLY.spawn(world, pos, EntitySpawnReason.MOB_SUMMONED);
        for (ServerPlayer player : world.getEntitiesOfClass(ServerPlayer.class, new AABB(pos).inflate(12.0))) {
            ModCriteria.COCOON_HATCHED.trigger(player);
        }
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify) {
        boolean bl = CocoonBlock.isAboveCOCOON_HATCHBooster(world, pos);
        if (!world.isClientSide() && bl) {
            world.levelEvent(LevelEvent.PARTICLES_EGG_CRACK, pos, 0);
        }
        int i = bl ? 2200 : 4400;
        int j = i / 3;
        world.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(state));
        world.scheduleTick(pos, this, j + world.getRandom().nextInt(3000));
    }

    public static boolean isAboveCOCOON_HATCHBooster(BlockGetter world, BlockPos pos) {
        return world.getBlockState(pos.below()).is(BlockTags.LOGS) || world.getBlockState(pos.below()).is(BlockTags.LEAVES);
    }


    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
