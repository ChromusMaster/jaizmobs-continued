package net.jaiz.jaizmobs.item.custom;

import java.util.function.Function;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.jaiz.jaizmobs.JaizMobs;
import net.jaiz.jaizmobs.entity.ModEntities;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.equipment.ArmorType;

public final class ModItems {
    private ModItems() {
    }

    private static <T extends Item> T registerItem(String name, Function<Item.Properties, T> factory, Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, name)
        );
        T item = factory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Item registerItem(String name) {
        return registerItem(name, Item::new, new Item.Properties());
    }

    // Food

    public static final Item STAR_FISH = registerItem("star_fish", Item::new,
            new Item.Properties().food(ModFoodComponents.STAR_FISH, ModFoodComponents.STAR_FISH_CONSUMABLE));
    public static final Item STRIDER_HAM = registerItem("strider_ham", Item::new,
            new Item.Properties().food(ModFoodComponents.STRIDER_HAM, ModFoodComponents.STRIDER_HAM_CONSUMABLE).fireResistant());
    public static final Item COOKED_STAR_FISH = registerItem("cooked_star_fish", Item::new,
            new Item.Properties().food(ModFoodComponents.COOKED_STAR_FISH, ModFoodComponents.DEFAULT_CONSUMABLE));
    public static final Item HELIUM_MEMBRANE = registerItem("helium_membrane", Item::new,
            new Item.Properties().food(ModFoodComponents.HELIUM_MEMBRANE, ModFoodComponents.HELIUM_MEMBRANE_CONSUMABLE));
    public static final Item HUNTER_EEL = registerItem("hunter_eel", Item::new,
            new Item.Properties().food(ModFoodComponents.HUNTER_EEL, ModFoodComponents.HUNTER_EEL_CONSUMABLE));
    public static final Item COOKED_HUNTER_EEL = registerItem("cooked_hunter_eel", Item::new,
            new Item.Properties().food(ModFoodComponents.COOKED_HUNTER_EEL, ModFoodComponents.DEFAULT_CONSUMABLE));
    public static final Item EEL_ON_A_STICK = registerItem("eel_on_a_stick", Item::new, new Item.Properties().stacksTo(1));
    public static final Item STARFISH_ON_A_STICK = registerItem("starfish_on_a_stick", Item::new, new Item.Properties().stacksTo(1));
    public static final Item GEYSER_BERRY = registerItem("geyser_berry", Item::new,
            new Item.Properties().food(ModFoodComponents.GEYSER_BERRY, ModFoodComponents.DEFAULT_CONSUMABLE));
    public static final Item COOKED_WARPED_FUNGUS = registerItem("cooked_warped_fungus", Item::new,
            new Item.Properties().food(ModFoodComponents.COOKED_WARPED_FUNGUS, ModFoodComponents.DEFAULT_CONSUMABLE));
    public static final Item COOKED_CRIMSON_FUNGUS = registerItem("cooked_crimson_fungus", Item::new,
            new Item.Properties().food(ModFoodComponents.COOKED_CRIMSON_FUNGUS, ModFoodComponents.DEFAULT_CONSUMABLE));

    // Ingredients

    public static final Item VOID_HUSK = registerItem("void_husk");
    public static final Item TATTERED_WING = registerItem("tattered_wing");
    public static final Item KLEPHTOPOD_SCUTE = registerItem("klephtopod_scute");
    public static final Item DRIPSTONE_SHARD = registerItem("dripstone_shard");
    public static final Item CRACKED_CALCITE_TOTEM = registerItem("cracked_calcite_totem", Item::new, new Item.Properties().stacksTo(16));
    public static final Item SULFURIC_REMNANT = registerItem("sulfuric_remnant");
    public static final Item HARDENED_BONE_FRAGMENT = registerItem("hardened_bone_fragment");
    public static final Item BASALT_MANDIBLE = registerItem("basalt_mandible", Item::new, new Item.Properties().fireResistant());

    // Armour Items

    public static final Item VOID_SCALE_MAIL_HELMET = armor("void_scale_mail_helmet", ModArmourMaterials.VOID_SCALE_MAIL,
            ArmorType.HELMET, ModArmourMaterials.VOID_SCALE_MAIL_DURABILITY);
    public static final Item VOID_SCALE_MAIL_CHESTPLATE = armor("void_scale_mail_chestplate", ModArmourMaterials.VOID_SCALE_MAIL,
            ArmorType.CHESTPLATE, ModArmourMaterials.VOID_SCALE_MAIL_DURABILITY);
    public static final Item VOID_SCALE_MAIL_LEGGINGS = armor("void_scale_mail_leggings", ModArmourMaterials.VOID_SCALE_MAIL,
            ArmorType.LEGGINGS, ModArmourMaterials.VOID_SCALE_MAIL_DURABILITY);
    public static final Item VOID_SCALE_MAIL_BOOTS = armor("void_scale_mail_boots", ModArmourMaterials.VOID_SCALE_MAIL,
            ArmorType.BOOTS, ModArmourMaterials.VOID_SCALE_MAIL_DURABILITY);
    public static final Item KLEPHTOPOD_SHELL = armor("klephtopod_shell", ModArmourMaterials.KLEPHTOPOD_SHELL,
            ArmorType.HELMET, ModArmourMaterials.KLEPHTOPOD_SHELL_DURABILITY);
    public static final Item KLEPHTOPOD_CHESTPLATE = armor("klephtopod_chestplate", ModArmourMaterials.KLEPHTOPOD_SHELL,
            ArmorType.CHESTPLATE, ModArmourMaterials.KLEPHTOPOD_SHELL_DURABILITY);
    public static final Item HARDENED_SKULL = armor("hardened_skull", ModArmourMaterials.HARDENED_BONE,
            ArmorType.HELMET, ModArmourMaterials.HARDENED_BONE_DURABILITY);

    // Tools + Weapons

    public static final Item DRIPSTONE_SHANK = registerItem("dripstone_shank", Item::new,
            new Item.Properties().sword(ModToolMaterial.DRIPSTONE, 13.0F, -3.2F));
    public static final Item MANDIBLE_BLADE = registerItem("mandible_blade", Item::new,
            new Item.Properties().sword(ModToolMaterial.STRIDER, 2.0F, -2.5F).fireResistant());
    public static final Item GLOW_TOOL = registerItem("glow_tool", GlowTool::new, new Item.Properties());

    // Spawn Eggs

    public static final Item TOTEM_SPIRIT_SPAWN_EGG = spawnEgg("totem_spirit_spawn_egg", ModEntities.TOTEM_SPIRIT);
    public static final Item DESERT_TOTEM_SPIRIT_SPAWN_EGG = spawnEgg("desert_totem_spirit_spawn_egg", ModEntities.DESERT_TOTEM_SPIRIT);
    public static final Item JUNGLE_TOTEM_SPIRIT_SPAWN_EGG = spawnEgg("jungle_totem_spirit_spawn_egg", ModEntities.JUNGLE_TOTEM_SPIRIT);
    public static final Item SPORETRAP_SPAWN_EGG = spawnEgg("sporetrap_spawn_egg", ModEntities.SPORETRAP);
    public static final Item VOIDBULL_SPAWN_EGG = spawnEgg("voidbull_spawn_egg", ModEntities.VOIDBULL);
    public static final Item STARFISH_SPAWN_EGG = spawnEgg("starfish_spawn_egg", ModEntities.STARFISH);
    public static final Item STARFISHLEADER_SPAWN_EGG = spawnEgg("starfishleader_spawn_egg", ModEntities.STARFISHLEADER);
    public static final Item PINE_GIANT_SPAWN_EGG = spawnEgg("pine_giant_spawn_egg", ModEntities.PINE_GIANT);
    public static final Item DRIPLET_SPAWN_EGG = spawnEgg("driplet_spawn_egg", ModEntities.DRIPLET);
    public static final Item STALAGTITAN_SPAWN_EGG = spawnEgg("stalagtitan_spawn_egg", ModEntities.STALAGTITAN);
    public static final Item SNAIL_SPAWN_EGG = spawnEgg("snail_spawn_egg", ModEntities.SNAIL);
    public static final Item CALCITE_GOLEM_SPAWN_EGG = spawnEgg("calcite_golem_spawn_egg", ModEntities.CALCITE_GOLEM);
    public static final Item CALCITE_TOTEM = registerItem("calcite_totem", SpawnEggItem::new,
            new Item.Properties().spawnEgg(ModEntities.CALCITE_GOLEM).stacksTo(16));
    public static final Item CULTIVATOR_SPAWN_EGG = spawnEgg("cultivator_spawn_egg", ModEntities.CULTIVATOR);
    public static final Item KLEPHTOPOD_SPAWN_EGG = spawnEgg("klephtopod_spawn_egg", ModEntities.KLEPHTOPOD);
    public static final Item FROSTED_TOTEM_SPIRIT_SPAWN_EGG = spawnEgg("frosted_totem_spirit_spawn_egg", ModEntities.FROSTED_TOTEM_SPIRIT);
    public static final Item HUNTER_EEL_SPAWN_EGG = spawnEgg("hunter_eel_spawn_egg", ModEntities.HUNTER_EEL);
    public static final Item AEROBLOB_SPAWN_EGG = spawnEgg("aeroblob_spawn_egg", ModEntities.AEROBLOB);
    public static final Item ENDERWING_SPAWN_EGG = spawnEgg("enderwing_spawn_egg", ModEntities.ENDERWING);
    public static final Item MOLOTOV_GOLEM_SPAWN_EGG = spawnEgg("molotov_golem_spawn_egg", ModEntities.MOLOTOV_GOLEM);
    public static final Item GEYSER_BERRY_SPAWN_EGG = spawnEgg("geyser_berry_spawn_egg", ModEntities.GEYSER_BERRY);
    public static final Item CRIMSON_TRUFFLER_SPAWN_EGG = spawnEgg("crimson_truffler_spawn_egg", ModEntities.CRIMSON_TRUFFLER);
    public static final Item WARPED_TRUFFLER_SPAWN_EGG = spawnEgg("warped_truffler_spawn_egg", ModEntities.WARPED_TRUFFLER);
    public static final Item EMBERBEETLE_SPAWN_EGG = spawnEgg("emberbeetle_spawn_egg", ModEntities.EMBERBEETLE);
    public static final Item SOULWADER_SPAWN_EGG = spawnEgg("soulwader_spawn_egg", ModEntities.SOULWADER);
    public static final Item STRIDER_HUNTER_SPAWN_EGG = spawnEgg("strider_hunter_spawn_egg", ModEntities.STRIDER_HUNTER);

    // Item group registries

    public static void registerModItems() {
        JaizMobs.LOGGER.info("Registering mod items for {}", JaizMobs.MOD_ID);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output -> accept(output,
                COOKED_STAR_FISH, STAR_FISH, HELIUM_MEMBRANE, HUNTER_EEL, COOKED_HUNTER_EEL, GEYSER_BERRY,
                COOKED_WARPED_FUNGUS, COOKED_CRIMSON_FUNGUS, STRIDER_HAM));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> accept(output,
                VOID_HUSK, TATTERED_WING, KLEPHTOPOD_SCUTE, DRIPSTONE_SHARD, BASALT_MANDIBLE,
                SULFURIC_REMNANT, HARDENED_BONE_FRAGMENT, CRACKED_CALCITE_TOTEM));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> accept(output,
                DRIPSTONE_SHANK, MANDIBLE_BLADE, GLOW_TOOL, EEL_ON_A_STICK, STARFISH_ON_A_STICK,
                CALCITE_TOTEM, KLEPHTOPOD_SHELL, KLEPHTOPOD_CHESTPLATE, HARDENED_SKULL,
                VOID_SCALE_MAIL_HELMET, VOID_SCALE_MAIL_CHESTPLATE, VOID_SCALE_MAIL_LEGGINGS, VOID_SCALE_MAIL_BOOTS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(output -> accept(output,
                TOTEM_SPIRIT_SPAWN_EGG, JUNGLE_TOTEM_SPIRIT_SPAWN_EGG, DESERT_TOTEM_SPIRIT_SPAWN_EGG,
                FROSTED_TOTEM_SPIRIT_SPAWN_EGG, SPORETRAP_SPAWN_EGG, PINE_GIANT_SPAWN_EGG, DRIPLET_SPAWN_EGG,
                STALAGTITAN_SPAWN_EGG, CALCITE_GOLEM_SPAWN_EGG, CULTIVATOR_SPAWN_EGG, KLEPHTOPOD_SPAWN_EGG,
                HUNTER_EEL_SPAWN_EGG, SNAIL_SPAWN_EGG, MOLOTOV_GOLEM_SPAWN_EGG, GEYSER_BERRY_SPAWN_EGG,
                CRIMSON_TRUFFLER_SPAWN_EGG, WARPED_TRUFFLER_SPAWN_EGG, EMBERBEETLE_SPAWN_EGG,
                SOULWADER_SPAWN_EGG, STRIDER_HUNTER_SPAWN_EGG, VOIDBULL_SPAWN_EGG, AEROBLOB_SPAWN_EGG,
                ENDERWING_SPAWN_EGG, STARFISH_SPAWN_EGG, STARFISHLEADER_SPAWN_EGG));
        ModArmourItem.registerEffectHandler();
    }

    private static Item armor(String name, net.minecraft.world.item.equipment.ArmorMaterial material,
                              ArmorType type, int durability) {
        return registerItem(name, Item::new, new Item.Properties()
                .humanoidArmor(material, type)
                .durability(type.getDurability(durability)));
    }

    private static Item spawnEgg(String name, net.minecraft.world.entity.EntityType<?> entityType) {
        return registerItem(name, SpawnEggItem::new, new Item.Properties().spawnEgg(entityType));
    }

    private static void accept(net.minecraft.world.item.CreativeModeTab.Output output, Item... items) {
        for (Item item : items) {
            output.accept(item);
        }
    }
}
