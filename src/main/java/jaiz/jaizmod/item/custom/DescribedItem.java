package jaiz.jaizmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class DescribedItem extends Item {
    private final int nutrition;

    public DescribedItem(Properties properties) {
        this(properties, 0);
    }

    public DescribedItem(Properties properties, int nutrition) {
        super(properties);
        this.nutrition = nutrition;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        tooltip.accept(Component.translatable(Util.makeDescriptionId("tooltip", BuiltInRegistries.ITEM.getKey(this))).withStyle(ChatFormatting.GRAY));
        if (nutrition > 0) {
            String key = nutrition == 1 ? "tooltip.jaizmod.restores_hunger.singular" : "tooltip.jaizmod.restores_hunger.plural";
            tooltip.accept(Component.translatable(key, nutrition).withStyle(ChatFormatting.GOLD));
        }
    }
}
