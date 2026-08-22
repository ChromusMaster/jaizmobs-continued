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
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class MahoganyTrunkPlacer extends GiantTrunkPlacer {
    public static final MapCodec<MahoganyTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(objectInstance ->
            trunkPlacerParts(objectInstance).apply(objectInstance, MahoganyTrunkPlacer::new));


    public MahoganyTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return TrunkPlacerTypes.MAHOGANY_TRUNK_PLACER;
    }


    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(
            WorldGenLevel world, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration config
    ) {
        List<FoliagePlacer.FoliageAttachment> list = Lists.<FoliagePlacer.FoliageAttachment>newArrayList();
        list.addAll(super.placeTrunk(world, replacer, random, height, startPos, config));

        for (int i = height - 5; i < height - 3; i++) {

            //north1
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                for(int x = 0; x < 3; x++) {
                    replacer.accept(startPos.above(i).relative(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                            .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                    for(int x2 = 1; x2 < 4; x2++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, 3).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 3).relative(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.NORTH, 2).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 2).relative(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.NORTH, 4).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 4).relative(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, 3).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                        .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 3).relative(Direction.UP, 5), -3, false));}
            }

            //north2
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, x + 1).relative(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.NORTH, 3).relative(Direction.EAST, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 3).relative(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, x + 1).relative(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.NORTH, 2).relative(Direction.EAST, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 2).relative(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, x + 1).relative(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.NORTH, 4).relative(Direction.EAST, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 4).relative(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.NORTH, x + 1).relative(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.NORTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.NORTH, 3).relative(Direction.EAST, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.NORTH, 3).relative(Direction.UP, 5), -3, false));}
            }



            //south1
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.SOUTH, x+ 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.SOUTH, 4).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 4).relative(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.SOUTH, x+ 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.SOUTH, 3).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 3).relative(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.SOUTH, x+ 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.SOUTH, 5).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 5).relative(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.SOUTH, x+ 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.SOUTH, 4).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 4).relative(Direction.UP, 5), -3, false));}
            }

            //south2
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.SOUTH, x + 2).relative(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.SOUTH, 4).relative(Direction.EAST, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 4).relative(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.SOUTH, x + 2).relative(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.SOUTH, 3).relative(Direction.EAST, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 3).relative(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.SOUTH, x+ 2).relative(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.SOUTH, 5).relative(Direction.EAST, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 5).relative(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.SOUTH, x+ 2).relative(Direction.EAST, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.SOUTH, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.SOUTH, 4).relative(Direction.EAST, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.SOUTH, 4).relative(Direction.UP, 5), -3, false));}
            }

            //east
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.EAST, x + 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.EAST, 4).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 4).relative(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.EAST, x + 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.EAST, 3).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 3).relative(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.EAST, x + 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.EAST, 5).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 5).relative(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.EAST, x + 2), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.EAST, 4).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 4).relative(Direction.UP, 5), -3, false));}
            }

            //east2
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.EAST, x + 2).relative(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.EAST, 4).relative(Direction.SOUTH, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 4).relative(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.EAST, x + 2).relative(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.EAST, 3).relative(Direction.SOUTH, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 3).relative(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.EAST, x + 2).relative(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.EAST, 5).relative(Direction.SOUTH, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 5).relative(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.EAST, x + 2).relative(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.EAST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.EAST, 4).relative(Direction.SOUTH, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.EAST, 4).relative(Direction.UP, 5), -3, false));}
            }



            //west
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.WEST, 3).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 3).relative(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.WEST, 2).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 2).relative(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.WEST, 4).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 4).relative(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.WEST, x + 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.WEST, 3).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 3).relative(Direction.UP, 5), -3, false));}
            }

            //west2
            if(random.nextInt(4) == 1) {
                int z = random.nextInt(3);
                if(z == 3){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.WEST, x + 1).relative(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.WEST, 3).relative(Direction.SOUTH, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 3).relative(Direction.UP, 5), -3, false));}
                else if (z == 2){
                    for(int x = 0; x < 2; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.WEST, x + 1).relative(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.WEST, 2).relative(Direction.SOUTH, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 2).relative(Direction.UP, 5), -3, false));}
                else if (z == 1){
                    for(int x = 0; x < 4; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.WEST, x + 1).relative(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.WEST, 4).relative(Direction.SOUTH, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 4).relative(Direction.UP, 5), -3, false));}
                else if (z == 0){
                    for(int x = 0; x < 3; x++) {
                        replacer.accept(startPos.above(i).relative(Direction.WEST, x + 1).relative(Direction.SOUTH, 1), (BlockState) Function.identity().apply(config.trunkProvider
                                .getState(world, random, startPos.above(i).relative(Direction.WEST, x)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X)));
                        for(int x2 = 1; x2 < 4; x2++) {
                            replacer.accept(startPos.above(i).relative(Direction.WEST, 3).relative(Direction.SOUTH, 1).relative(Direction.UP, x2), (BlockState) Function.identity().apply(config.trunkProvider
                                    .getState(world, random, startPos.above(i).relative(Direction.UP, x2)).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y)));}}
                    list.add(new FoliagePlacer.FoliageAttachment(startPos.above(i).relative(Direction.WEST, 3).relative(Direction.UP, 5), -3, false));}
            }

        }
        return list;
    }

}
