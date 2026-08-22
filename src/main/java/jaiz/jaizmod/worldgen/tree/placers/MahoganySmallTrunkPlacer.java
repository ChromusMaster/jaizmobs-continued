package jaiz.jaizmod.worldgen.tree.placers;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaiz.jaizmod.worldgen.tree.TrunkPlacerTypes;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class MahoganySmallTrunkPlacer extends StraightTrunkPlacer {
    public static final MapCodec<MahoganySmallTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(objectInstance ->
            trunkPlacerParts(objectInstance).apply(objectInstance, MahoganySmallTrunkPlacer::new));


    public MahoganySmallTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return TrunkPlacerTypes.SMALL_MAHOGANY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(
            WorldGenLevel world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config
    ) {
        List<FoliagePlacer.FoliageAttachment> list = Lists.<FoliagePlacer.FoliageAttachment>newArrayList();
        list.addAll(super.placeTrunk(world, replacer, random, height, startPos, config));

        for (int i = height - 4; i < height - 2; i++) {

            //north
            if(random.nextInt(7) == 1) {
                int z = random.nextInt(3);
                if(z <= 1){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i-1).relative(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 2; x2++) {
                            replacer.accept(startPos.above(i-1).relative(Direction.NORTH, 2).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 2).relative(Direction.UP, 2), -4, false));}
                else{
                    for(int x = 0; x < 1; x++) {
                        replacer.accept(startPos.above(i + 1).relative(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }
            }

            //south
            if(random.nextInt(7) == 1) {
                int z = random.nextInt(3);
                if(z <= 1){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i-1).relative(Direction.SOUTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 2; x2++) {
                            replacer.accept(startPos.above(i-1).relative(Direction.SOUTH, 2).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 2).relative(Direction.UP, 2), -4, false));}
                else{
                    for(int x = 0; x < 1; x++) {
                        replacer.accept(startPos.above(i + 1).relative(Direction.SOUTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                    }
                }
            }

            //east
            if(random.nextInt(7) == 1) {
                int z = random.nextInt(3);
                if(z <= 1){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i-1).relative(Direction.EAST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 2; x2++) {
                            replacer.accept(startPos.above(i-1).relative(Direction.EAST, 2).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 2).relative(Direction.UP, 2), -4, false));}
                else{
                    for(int x = 0; x < 1; x++) {
                        replacer.accept(startPos.above(i + 1).relative(Direction.EAST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }

            //west
            if(random.nextInt(7) == 1) {
                int z = random.nextInt(3);
                if(z <= 1){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i-1).relative(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 2; x2++) {
                            replacer.accept(startPos.above(i-1).relative(Direction.WEST, 2).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 2).relative(Direction.UP, 2), -4, false));}
                else{
                    for(int x = 0; x < 1; x++) {
                        replacer.accept(startPos.above(i + 1).relative(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                    }
                }
            }

        }
        return list;
    }

}
