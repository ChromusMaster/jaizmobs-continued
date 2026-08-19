package net.jaiz.jaizmobs.item.custom;

import java.util.Map;
import net.jaiz.jaizmobs.JaizMobs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public final class ModArmourMaterials {
    public static final int VOID_SCALE_MAIL_DURABILITY = 40;
    public static final int KLEPHTOPOD_SHELL_DURABILITY = 18;
    public static final int HARDENED_BONE_DURABILITY = 12;

    public static final TagKey<Item> REPAIRS_VOID_SCALE_MAIL = repairTag("repairs_void_scale_mail");
    public static final TagKey<Item> REPAIRS_KLEPHTOPOD_SHELL = repairTag("repairs_klephtopod_shell");
    public static final TagKey<Item> REPAIRS_HARDENED_BONE = repairTag("repairs_hardened_bone");

    public static final ArmorMaterial VOID_SCALE_MAIL = create(
            VOID_SCALE_MAIL_DURABILITY,
            Map.of(ArmorType.HELMET, 5, ArmorType.CHESTPLATE, 8, ArmorType.LEGGINGS, 7, ArmorType.BOOTS, 6),
            10, 3.0F, 0.3F, REPAIRS_VOID_SCALE_MAIL, "void_scale_mail"
    );
    public static final ArmorMaterial KLEPHTOPOD_SHELL = create(
            KLEPHTOPOD_SHELL_DURABILITY,
            Map.of(ArmorType.HELMET, 2, ArmorType.CHESTPLATE, 4, ArmorType.LEGGINGS, 4, ArmorType.BOOTS, 2),
            12, 1.0F, 0.0F, REPAIRS_KLEPHTOPOD_SHELL, "klephtopod_shell"
    );
    public static final ArmorMaterial HARDENED_BONE = create(
            HARDENED_BONE_DURABILITY,
            Map.of(ArmorType.HELMET, 7, ArmorType.CHESTPLATE, 1, ArmorType.LEGGINGS, 1, ArmorType.BOOTS, 1),
            17, 1.0F, 0.0F, REPAIRS_HARDENED_BONE, "hardened_bone"
    );

    private ModArmourMaterials() {
    }

    private static ArmorMaterial create(int durability, Map<ArmorType, Integer> defense, int enchantmentValue,
                                        float toughness, float knockbackResistance, TagKey<Item> repairTag, String name) {
        ResourceKey<EquipmentAsset> asset = ResourceKey.create(
                EquipmentAssets.ROOT_ID,
                Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, name)
        );
        return new ArmorMaterial(durability, defense, enchantmentValue, SoundEvents.ARMOR_EQUIP_CHAIN,
                toughness, knockbackResistance, repairTag, asset);
    }

    private static TagKey<Item> repairTag(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, name));
    }
}
