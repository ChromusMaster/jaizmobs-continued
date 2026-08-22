package jaiz.jaizmod.mixin;

import jaiz.jaizmod.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    public boolean isScoping() {
        return this.isUsingItem() && (this.getUseItem().is(Items.SPYGLASS) || this.getUseItem().is(ModItems.GLOWING_SPYGLASS));
    }

}
