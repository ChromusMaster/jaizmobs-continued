package net.jaiz.jaizmobs.item.custom;

import net.jaiz.jaizmobs.JaizMobs;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public final class ModItemIds {
    public static final ResourceKey<Item> VOID_HUSK = create("void_husk");
    public static final ResourceKey<Item> KLEPHTOPOD_SCUTE = create("klephtopod_scute");
    public static final ResourceKey<Item> DRIPSTONE_SHARD = create("dripstone_shard");
    public static final ResourceKey<Item> HARDENED_BONE_FRAGMENT = create("hardened_bone_fragment");
    public static final ResourceKey<Item> BASALT_MANDIBLE = create("basalt_mandible");
    public static final ResourceKey<Item> VOID_SCALE_MAIL_HELMET = create("void_scale_mail_helmet");
    public static final ResourceKey<Item> VOID_SCALE_MAIL_CHESTPLATE = create("void_scale_mail_chestplate");
    public static final ResourceKey<Item> VOID_SCALE_MAIL_LEGGINGS = create("void_scale_mail_leggings");
    public static final ResourceKey<Item> VOID_SCALE_MAIL_BOOTS = create("void_scale_mail_boots");
    public static final ResourceKey<Item> KLEPHTOPOD_SHELL = create("klephtopod_shell");
    public static final ResourceKey<Item> KLEPHTOPOD_CHESTPLATE = create("klephtopod_chestplate");
    public static final ResourceKey<Item> HARDENED_SKULL = create("hardened_skull");

    private ModItemIds() {
    }

    private static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, name));
    }
}
