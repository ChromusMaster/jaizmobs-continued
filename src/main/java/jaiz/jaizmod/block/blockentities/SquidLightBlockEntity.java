package jaiz.jaizmod.block.blockentities;

import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.block.blockentities.CustomBlockEntities;
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

        if(this.getLevel() !=null && !getLevel().isClientSide()){

            boolean glowSquidNearby = false;
            for (GlowSquid glowSquid : level.getEntitiesOfClass(GlowSquid.class, new AABB(worldPosition).inflate(2.0))) {
                if (glowSquid.distanceToSqr(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ()) <= 9) {
                    glowSquidNearby = true;
                    if (waterNeedsUpdate(glowSquid.level(), glowSquid.blockPosition())) {
                        level.setBlockAndUpdate(glowSquid.blockPosition(), ModBlocks.WATER_TEMPORARY_LIGHT.defaultBlockState().setValue(WaterTickingBlock.WATERLOGGED, true));
                    } else if(!waterNeedsUpdate(glowSquid.level(), glowSquid.blockPosition())) {
                        level.setBlockAndUpdate(glowSquid.blockPosition(), ModBlocks.WATER_TEMPORARY_LIGHT.defaultBlockState().setValue(WaterTickingBlock.WATERLOGGED, false));
                    }
                }
            }

            if (!glowSquidNearby && waterNeedsUpdate(level, worldPosition)) {
                level.setBlockAndUpdate(worldPosition, Blocks.WATER.defaultBlockState());
            } else if (!glowSquidNearby && !waterNeedsUpdate(level, worldPosition)) {
                level.setBlockAndUpdate(worldPosition, Blocks.AIR.defaultBlockState());
            }

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


