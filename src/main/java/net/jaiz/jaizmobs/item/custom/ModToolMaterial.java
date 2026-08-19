package net.jaiz.jaizmobs.item.custom;

import net.jaiz.jaizmobs.JaizMobs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public final class ModToolMaterial {
    public static final TagKey<Item> REPAIRS_DRIPSTONE_TOOLS = repairTag("repairs_dripstone_tools");
    public static final TagKey<Item> REPAIRS_STRIDER_TOOLS = repairTag("repairs_strider_tools");

    public static final ToolMaterial DRIPSTONE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 3, 0.1F, 4.0F, 12, REPAIRS_DRIPSTONE_TOOLS
    );
    public static final ToolMaterial STRIDER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 748, 0.2F, 6.0F, 10, REPAIRS_STRIDER_TOOLS
    );

    private ModToolMaterial() {
    }

    private static TagKey<Item> repairTag(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, name));
    }
}
