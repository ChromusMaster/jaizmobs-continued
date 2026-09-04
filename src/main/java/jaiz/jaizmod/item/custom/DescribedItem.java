package jaiz.jaizmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Util;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class DescribedItem extends Item {
    public DescribedItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, display, tooltip, flag);
        tooltip.accept(Component.translatable(Util.makeDescriptionId("tooltip", BuiltInRegistries.ITEM.getKey(this))).withStyle(ChatFormatting.GRAY));
        FoodProperties food = stack.get(DataComponents.FOOD);
        if (food != null && stack.has(DataComponents.CONSUMABLE) && food.nutrition() > 0) {
            String key = food.nutrition() == 1 ? "tooltip.jaizmod.restores_hunger.singular" : "tooltip.jaizmod.restores_hunger.plural";
            tooltip.accept(Component.translatable(key, food.nutrition()).withStyle(ChatFormatting.GOLD));
        }
    }
}
