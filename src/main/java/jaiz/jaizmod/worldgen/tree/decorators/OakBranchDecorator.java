package jaiz.jaizmod.worldgen.tree.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import jaiz.jaizmod.worldgen.tree.ModTreeDecorator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class OakBranchDecorator extends TreeDecorator {

    public static final MapCodec<OakBranchDecorator> CODEC = Codec.floatRange(0.0F, 1.0F)
            .fieldOf("probability")
            .xmap(OakBranchDecorator::new, decorator -> decorator.probability);
    private final float probability;

    public OakBranchDecorator(float probability) {
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
                    if (random.nextFloat() <= 0.05F) {
                        Direction direction2 = direction.getOpposite();
                        BlockPos blockPos = pos.offset(direction2.getStepX(), 3, direction2.getStepZ());
                    if (generator.isAir(blockPos) && pos.getY() >= i && pos.getY() <= k - 3) {
                            generator.setBlock(blockPos, Blocks.OAK_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, direction.getAxis()));
                        }
                    }
                }
            });
        }
    }
    protected TreeDecoratorType<?> type() {return ModTreeDecorator.OAK_BRANCH;}
}


