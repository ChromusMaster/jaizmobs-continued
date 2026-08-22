package jaiz.jaizmod.block.custom;

import jaiz.jaizmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class BloomingIvyBlock extends VineBlock {

    public static final IntegerProperty STAGE = ModBlocks.STAGE;
    public static final BooleanProperty LOCKED = ModBlocks.LOCKED;

    public BloomingIvyBlock(Properties settings) {
        super(settings);

        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(UP, Boolean.FALSE)
                        .setValue(NORTH, Boolean.FALSE)
                        .setValue(EAST, Boolean.FALSE)
                        .setValue(SOUTH, Boolean.FALSE)
                        .setValue(WEST, Boolean.FALSE)
                        .setValue(STAGE, 1)
                        .setValue(LOCKED, false)
        );
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(LOCKED);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        super.randomTick(state, world, pos, random);
        if (random.nextInt(25) == 1 && !state.getValue(LOCKED) && state.getValue(STAGE) < 3) {
            BlockState blockState = state.setValue(STAGE, state.getValue(STAGE) + 1);
            world.setBlock(pos, blockState, Block.UPDATE_ALL);
        }
    }

    private static boolean shearItem(ItemStack stack) {
        return stack.is(Items.SHEARS);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (BloomingIvyBlock.shearItem(itemStack)) {
            BloomingIvyBlock.shear(player, world, pos, state);
            if (!player.getAbilities().instabuild) {
                stack.hurtAndBreak(1, player, hand);
            }
        }
        return super.useItemOn(stack, state, world, pos, player, hand, hit);
    }

    public static void shear(@Nullable Entity user, Level world, BlockPos pos, BlockState state) {
        BlockState blockState = state.setValue(LOCKED, true);
        world.setBlock(pos, blockState, Block.UPDATE_ALL);
        world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(user, blockState));
        world.playSound(null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BEEHIVE_SHEAR, SoundSource.BLOCKS, 1.0f, 1.0f);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, NORTH, EAST, SOUTH, WEST, STAGE, LOCKED);
    }
}
