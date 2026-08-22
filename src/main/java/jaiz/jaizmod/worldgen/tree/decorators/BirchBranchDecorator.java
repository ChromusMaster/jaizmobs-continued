package jaiz.jaizmod.worldgen.tree.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import jaiz.jaizmod.worldgen.tree.ModTreeDecorator;
import net.minecraft.world.level.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import java.util.Iterator;
import java.util.List;

public class BirchBranchDecorator extends TreeDecorator {

    public static final MapCodec<BirchBranchDecorator> CODEC = Codec.floatRange(0.0F, 1.0F)
            .fieldOf("probability")
            .xmap(BirchBranchDecorator::new, decorator -> decorator.probability);
    private final float probability;

    public BirchBranchDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    public void place(Context generator) {
        RandomSource random = generator.random();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> list = generator.logs();
            int i = list.getFirst().getY();
            int k = list.getLast().getY();
            list.stream().filter((pos) -> i <= k).forEach((pos)  -> {
                Iterator var3 = Direction.Plane.HORIZONTAL.iterator();
                while(var3.hasNext()) {
                    Direction direction = (Direction)var3.next();
                    if (random.nextFloat() <= 0.035F) {
                        Direction direction2 = direction.getOpposite();
                        BlockPos blockPos = pos.offset(direction2.getStepX(), 3, direction2.getStepZ());
                    if (generator.isAir(blockPos) && pos.getY() >= i && pos.getY() <= k - 3) {
                            generator.setBlock(blockPos, Blocks.BIRCH_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, direction.getAxis()));
                        }
                    }
                }
            });
        }
    }
    protected TreeDecoratorType<?> type() {return ModTreeDecorator.BIRCH_BRANCH;}
}


