package jaiz.jaizmod.block.blockentities;

import jaiz.jaizmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.animal.squid.GlowSquid;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class SquidLightBlockEntity extends BlockEntity implements TickableBlockEntity {

    public SquidLightBlockEntity(BlockPos pos, BlockState state) {
        super(CustomBlockEntities.SQUID_LIGHT_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void tick() {
        if (this.level == null || this.level.isClientSide()) {
            return;
        }
        if (Math.floorMod(this.level.getGameTime() + this.worldPosition.asLong(), 10) != 0) {
            return;
        }
        boolean glowSquidNearby = !this.level.getEntitiesOfClass(
                GlowSquid.class,
                new AABB(this.worldPosition).inflate(2.0),
                glowSquid -> glowSquid.distanceToSqr(this.worldPosition.getX(), this.worldPosition.getY(), this.worldPosition.getZ()) <= 9
        ).isEmpty();
        if (!glowSquidNearby) {
            BlockState replacement = waterNeedsUpdate(this.level, this.worldPosition)
                    ? Blocks.WATER.defaultBlockState()
                    : Blocks.AIR.defaultBlockState();
            this.level.setBlockAndUpdate(this.worldPosition, replacement);
        }
    }

    public static boolean waterNeedsUpdate(Level world, BlockPos pos) {
        int waterCount = 0;
        BlockPos[] directions = {pos.above(), pos.north(), pos.east(), pos.south(), pos.west(), pos.below()};
        for (BlockPos direction : directions) {
            BlockState state = world.getBlockState(direction);
            if (state.is(Blocks.WATER)) {
                waterCount++;
            } else if (state.is(ModBlocks.WATER_TEMPORARY_LIGHT)) {
                if (state.getValue(WaterTickingBlock.WATERLOGGED)) {
                    waterCount++;
                }
            }
        }
        return waterCount >= 2;
    }




}


