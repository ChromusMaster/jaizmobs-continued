package jaiz.jaizmod.item.custom;

import jaiz.jaizmod.util.Bottlable;
import net.minecraft.advancements.triggers.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;


public class EntityBottle extends Item {
    private final EntityType<? extends Mob> entityType;

    public EntityBottle(EntityType<? extends Mob> type, Item.Properties settings) {
        super(settings);
        this.entityType = type;
    }

    public void onEmptied(@Nullable Player player, Level world, ItemStack stack, BlockPos pos) {
        if (world instanceof ServerLevel) {
            this.spawnEntity((ServerLevel)world, stack, pos);
            world.gameEvent(player, GameEvent.ENTITY_PLACE, pos);
        }
    }


    private void spawnEntity(ServerLevel world, ItemStack stack, BlockPos pos) {
        Mob mobEntity = this.entityType.create(world, EntityType.createDefaultStackConfig(world, stack, null), pos, EntitySpawnReason.BUCKET, true, false);
        if (mobEntity instanceof Bottlable bottlable) {
            CustomData nbtComponent = stack.getOrDefault(DataComponents.BUCKET_ENTITY_DATA, CustomData.EMPTY);
            bottlable.copyDataFromNbt(nbtComponent.copyTag());
            bottlable.setFromBottle(true);
        }
        if (mobEntity != null) {
            world.addFreshEntityWithPassengers(mobEntity);
            mobEntity.playAmbientSound();
        }
    }

    public static ItemStack getEmptiedStack(ItemStack stack, Player player) {
        return !player.hasInfiniteMaterials() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }

    /*@Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.ANY);
        BlockPos blockPos = blockHitResult.getBlockPos();
        this.onEmptied(user, world, itemStack, blockPos);
        if (user instanceof ServerPlayerEntity) {
            Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)user, blockPos, itemStack);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, user, getEmptiedStack(itemStack, user));
            return ActionResult.SUCCESS.withNewHandStack(itemStack2);
    }*/

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide()) {
            BlockPos blockPos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockState = world.getBlockState(blockPos);
            BlockPos blockPos2;
            if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                blockPos2 = blockPos;
            } else {
                blockPos2 = blockPos.relative(direction);
            }
            if (context.getPlayer() != null) {
                ItemStack itemStack = context.getPlayer().getItemInHand(context.getHand());
                this.onEmptied(context.getPlayer(), world, itemStack, blockPos2);
                if (context.getPlayer() instanceof ServerPlayer) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) context.getPlayer(), blockPos2, itemStack);
                }
                context.getPlayer().awardStat(Stats.ITEM_USED.get(this));
                ItemStack itemStack2 = getEmptiedStack(itemStack, context.getPlayer());
                if (!context.getPlayer().hasInfiniteMaterials()) {
                    itemStack.shrink(1);
                }
                context.getPlayer().setItemInHand(context.getHand(), itemStack2);
                return InteractionResult.SUCCESS.heldItemTransformedTo(itemStack2);
            }
        }
        return InteractionResult.SUCCESS;
    }

}
