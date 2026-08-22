package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gamerules.GameRules;

public class FireflyBottleBlock extends LanternBlock {

    public FireflyBottleBlock(Properties settings) {
        super(settings);
    }

    @Override
    public void spawnAfterBreak(BlockState state, ServerLevel world, BlockPos pos, ItemStack tool, boolean dropExperience) {
        super.spawnAfterBreak(state, world, pos, tool, dropExperience);
        if (world.getGameRules().get(GameRules.BLOCK_DROPS)) {
            ModEntities.FIRE_FLY_SWARM.spawn(world, pos, EntitySpawnReason.MOB_SUMMONED);
        }
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        if(random.nextInt(2) == 1){
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        double d = (double)i + random.nextDouble();
        double e = (double)j + 0.7;
        double f = (double)k + random.nextDouble();
        world.addParticle(JaizMod.FIREFLY_PARTICLE, d, e, f, 0.0, 0.0, 0.0);
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        int s = random.nextInt(5);

        for (int l = 0; l < s; l++) {
            mutable.set(i + Mth.nextInt(random, -10, 10), j - random.nextInt(10), k + Mth.nextInt(random, -10, 10));
            BlockState blockState = world.getBlockState(mutable);
            if (!blockState.isCollisionShapeFullBlock(world, mutable)) {
                world.addParticle(
                        JaizMod.FIREFLY_PARTICLE,
                        (double)mutable.getX() + random.nextDouble(),
                        (double)mutable.getY() + random.nextDouble(),
                        (double)mutable.getZ() + random.nextDouble(),
                        0.0,
                        0.0,
                        0.0
                );
            }
        }}
    }

}
