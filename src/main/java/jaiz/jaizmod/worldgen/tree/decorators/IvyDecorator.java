package jaiz.jaizmod.worldgen.tree.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.block.custom.IvyBlock;
import jaiz.jaizmod.worldgen.tree.ModTreeDecorator;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class IvyDecorator extends TreeDecorator {

    public static final MapCodec<IvyDecorator> CODEC = Codec.floatRange(0.00F, 1.00F)
            .fieldOf("probability")
            .xmap(IvyDecorator::new, decorator -> decorator.probability);

    private final float probability;

    public IvyDecorator(float probability){
        this.probability = probability;
    }

    protected TreeDecoratorType<?> type() {return ModTreeDecorator.IVY;}

    @Override
    public void place(Context generator) {
        RandomSource random = generator.random();
        if (!(random.nextFloat() >= this.probability)) {
            generator.logs().forEach(pos -> {
                BlockPos blockPos;
                if (random.nextInt(3) > 0 && generator.isAir(blockPos = pos.west())) {
                    generator.setBlock(blockPos, ModBlocks.IVY.defaultBlockState().setValue(IvyBlock.EAST, true));
                }
                if (random.nextInt(3) > 0 && generator.isAir(blockPos = pos.east())) {
                    generator.setBlock(blockPos, ModBlocks.IVY.defaultBlockState().setValue(IvyBlock.WEST, true));
                }
                if (random.nextInt(3) > 0 && generator.isAir(blockPos = pos.north())) {
                    generator.setBlock(blockPos, ModBlocks.IVY.defaultBlockState().setValue(IvyBlock.SOUTH, true));
                }
                if (random.nextInt(3) > 0 && generator.isAir(blockPos = pos.south())) {
                    generator.setBlock(blockPos, ModBlocks.IVY.defaultBlockState().setValue(IvyBlock.NORTH, true));
                }
            });
        }
    }
}

