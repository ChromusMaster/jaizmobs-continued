package jaiz.jaizmod.worldgen.tree.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.block.custom.ShelfMushroomBlock;
import jaiz.jaizmod.worldgen.tree.ModTreeDecorator;
import java.util.Iterator;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class MushroomDecorator extends TreeDecorator {

    public static final MapCodec<MushroomDecorator> CODEC = Codec.floatRange(0.00F, 1.00F)
            .fieldOf("probability")
            .xmap(MushroomDecorator::new, decorator -> decorator.probability);

    private final float probability;

    public MushroomDecorator(float probability){
        this.probability = probability;
    }


    protected TreeDecoratorType<?> type() {return ModTreeDecorator.SHROOMS;}

    @Override
    public void place(Context generator) {
        RandomSource random = generator.random();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> list = generator.logs();
            int i = list.getFirst().getY();
            int k = list.getLast().getY();
            list.stream().filter((pos) -> i <= k).forEach((pos) -> {
                Iterator var3 = Direction.Plane.HORIZONTAL.iterator();
                while(var3.hasNext()) {
                    Direction direction = (Direction)var3.next();
                    if (random.nextFloat() <= 0.05F) {
                        Direction direction2 = direction.getOpposite();
                        BlockPos blockPos = pos.offset(direction2.getStepX(), 1, direction2.getStepZ());
                        if (generator.isAir(blockPos)  && pos.getY() >= i && pos.getY() <= k - 1) {
                            //HERES THE BLOCK FUTURE ME
                            generator.setBlock(blockPos, ModBlocks.SHELF_MUSHROOM_BLOCK.defaultBlockState()
                                    .setValue(ShelfMushroomBlock.SIZE, random.nextInt(3))
                                    .setValue(ShelfMushroomBlock.FACING, direction.getOpposite()));
                        }
                    }
                }
            });
        }
    }
}



