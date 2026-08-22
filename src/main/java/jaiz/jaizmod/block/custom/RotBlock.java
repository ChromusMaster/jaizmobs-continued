package jaiz.jaizmod.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.worldgen.features.ModConfiguredFeatures;
import net.minecraft.world.level.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import static jaiz.jaizmod.block.custom.RottingLog.ROTTING;

public class RotBlock extends Block implements BonemealableBlock{
    public static final BooleanProperty GROWING = ModBlocks.GROWING;

    public static final MapCodec<RotBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            ResourceKey.codec(Registries.CONFIGURED_FEATURE).fieldOf("feature").forGetter(block -> block.feature), propertiesCodec()
                    )
                    .apply(instance, RotBlock::new)
    );
    private final ResourceKey<ConfiguredFeature<?, ?>> feature;

    @Override
    public MapCodec<RotBlock> codec() {
        return CODEC;
    }



    public RotBlock(ResourceKey<ConfiguredFeature<?, ?>> feature, Properties settings) {
        super(settings);
        this.feature = feature;
        this.defaultBlockState().setValue(GROWING, false);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
            return super.getStateForPlacement(ctx).setValue(GROWING, false);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.above();
        BlockState blockState = world.getBlockState(blockPos);
        BlockState blockState2 = ModBlocks.ROTTEN_LOG.defaultBlockState().setValue(ROTTING, 1);
        int i =random.nextInt(12);

        if (blockState.is(BlockTags.LOGS)) {
            world.setBlockAndUpdate(blockPos, blockState2);
        } else{
            world.registryAccess()
                    .lookup(Registries.CONFIGURED_FEATURE)
                    .flatMap(registry -> registry.get(this.feature))
                    .ifPresent(entry -> ((ConfiguredFeature<?, ?>)entry.value()).place(world, world.getChunkSource().getGenerator(), random, pos.above()));
            if(i >= 10)
            {
                world.registryAccess()
                        .lookup(Registries.CONFIGURED_FEATURE)
                        .flatMap(registry -> registry.get(ModConfiguredFeatures.COLUMBINE_PATCH))
                        .ifPresent(entry -> ((ConfiguredFeature<?, ?>)entry.value()).place(world, world.getChunkSource().getGenerator(), random, pos.above()));

            }
            else if(i == 6) {
            world.registryAccess()
                    .lookup(Registries.CONFIGURED_FEATURE)
                    .flatMap(registry -> registry.get(ModConfiguredFeatures.RED_MUSHROOM))
                    .ifPresent(entry -> ((ConfiguredFeature<?, ?>)entry.value()).place(world, world.getChunkSource().getGenerator(), random, pos.above()));
            }
            else if(i == 5) {
                world.registryAccess()
                        .lookup(Registries.CONFIGURED_FEATURE)
                        .flatMap(registry -> registry.get(ModConfiguredFeatures.BROWN_MUSHROOM))
                        .ifPresent(entry -> ((ConfiguredFeature<?, ?>)entry.value()).place(world, world.getChunkSource().getGenerator(), random, pos.above()));
            }
            else {
                world.registryAccess()
                        .lookup(Registries.CONFIGURED_FEATURE)
                        .flatMap(registry -> registry.get(ModConfiguredFeatures.ROT_ROOTS))
                        .ifPresent(entry -> ((ConfiguredFeature<?, ?>)entry.value()).place(world, world.getChunkSource().getGenerator(), random, pos.above()));
            }



        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 1) {
            return;
        }
        BlockPos blockPos = pos.above();
        BlockState blockState = world.getBlockState(blockPos);
        BlockState blockState2 = ModBlocks.ROTTEN_LOG.defaultBlockState().setValue(ROTTING, 1);
        if (blockState.is(BlockTags.LOGS)) {
            if (!blockState.is(ModBlocks.ROTTEN_LOG)) {
                world.setBlockAndUpdate(blockPos, blockState2);
            }
        }

        BlockState blockStatetrue = state.setValue(GROWING, true);
        BlockState blockStatefalse = state.setValue(GROWING, false);
        BlockPos blockPos2 = pos.above();
        BlockState blockState3 = world.getBlockState(blockPos2);
        if (blockState3.isRedstoneConductor(world, blockPos2)) {
            world.setBlock(pos, blockStatetrue, Block.UPDATE_ALL);
        } else {
            world.setBlock(pos, blockStatefalse, Block.UPDATE_ALL);
        }

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(GROWING);
    }

    @Override
    public BonemealableBlock.Type getType() {
        return BonemealableBlock.Type.NEIGHBOR_SPREADER;
    }




}
