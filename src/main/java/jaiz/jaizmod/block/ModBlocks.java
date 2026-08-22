package jaiz.jaizmod.block;

import jaiz.jaizmod.JaizMod;
//import jaiz.jaizmod.block.blockentities.WaterTickingBlock;
import jaiz.jaizmod.block.blockentities.WaterTickingBlock;
import jaiz.jaizmod.block.custom.*;
import jaiz.jaizmod.worldgen.features.ModConfiguredFeatures;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.world.level.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.GlowLichenBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import java.util.Optional;
import java.util.function.Function;

public class ModBlocks {
    public static final IntegerProperty SIZE = IntegerProperty.create("size", 0, 2);
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 1, 3);
    public static final IntegerProperty ROTTING = IntegerProperty.create("rotting", 0, 1);
    public static final IntegerProperty COCOON_HATCH = IntegerProperty.create("hatch", 0, 3);
    public static final BooleanProperty HAS_CUP = BooleanProperty.create("has_cup");
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");
    public static final BooleanProperty GROWING = BooleanProperty.create("growing");


    public static final Block PLATED_CALCITE = registerBlock("plated_calcite",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));

    public static final Block ANCIENT_SPROUT = registerBlock("ancient_sprout",
            settings -> new AncientSproutBlock(MobEffects.ABSORPTION, 60, settings),
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().instabreak()
                    .sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY));

    public static final Block BLOOMING_IVY_CROP = registerBlock(
            "blooming_ivy_crop",
            CropBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final Block ANCIENT_SPROUT_CROP = registerBlock(
            "ancient_sprout_crop",
            CropBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)
    );


    public static final Block SNIFFER_WOOL = registerBlock("sniffer_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)));

    public static final Block SNIFFER_CARPET = registerBlock("sniffer_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.GREEN)));

    public static final Block CHISELED_PLATED_CALCITE = registerBlock("chiseled_plated_calcite",
            ExtraDirectionalModelBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE));

    public static final Block BLOOMING_IVY = registerBlock("blooming_ivy",
            BloomingIvyBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.VINE).sound(SoundType.VINE).randomTicks());

    public static final Block WHITE_FLORAL_VEIL = registerBlock("white_floral_veil",
            GlowLichenBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).sound(SoundType.GRASS).instabreak().noCollision());
    public static final Block PINK_FLORAL_VEIL = registerBlock("pink_floral_veil",
            GlowLichenBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).sound(SoundType.GRASS).instabreak().noCollision());
    public static final Block YELLOW_FLORAL_VEIL = registerBlock("yellow_floral_veil",
            GlowLichenBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).sound(SoundType.GRASS).instabreak().noCollision());
    public static final Block FROST = registerBlock("frost",
            MultifaceBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.ICE).sound(SoundType.GLASS).instabreak().noCollision());

    public static final Block BIOLUMINESCENT_BOTTLE = registerBlock("bioluminescent_bottle",
            BioluminescentBottleBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(state -> 15));

    public static final Block WATER_TEMPORARY_LIGHT = registerBlock("water_temporary_light", WaterTickingBlock::new,BlockBehaviour.Properties.of()
            .replaceable().noCollision().liquid().strength(-1.0F, 3600000.8F).mapColor(MapColor.NONE).noLootTable()
            .noOcclusion().lightLevel(state -> 7));

    public static final Block TEAPOTBLOCK = registerBlock("tea_pot_block", TeaPotBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).lightLevel(state -> 13).noOcclusion());

    public static final Block AMETHYST_THORN = registerBlock("amethyst_thorn",
            AmethystThornBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER).sound(SoundType.AMETHYST_CLUSTER).randomTicks().noCollision());

    public static final Block FANCY_WHITE_WOOL = registerBlock("fancy_white_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.WHITE)).sound(SoundType.WOOL));
    public static final Block FANCY_BLUE_WOOL = registerBlock("fancy_blue_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLUE)).sound(SoundType.WOOL));
    public static final Block FANCY_CYAN_WOOL = registerBlock("fancy_cyan_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.CYAN)).sound(SoundType.WOOL));
    public static final Block FANCY_LIGHT_BLUE_WOOL = registerBlock("fancy_light_blue_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIGHT_BLUE)).sound(SoundType.WOOL));
    public static final Block FANCY_BROWN_WOOL = registerBlock("fancy_brown_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BROWN)).sound(SoundType.WOOL));
    public static final Block FANCY_PINK_WOOL = registerBlock("fancy_pink_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PINK)).sound(SoundType.WOOL));
    public static final Block FANCY_MAGENTA_WOOL = registerBlock("fancy_magenta_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.MAGENTA)).sound(SoundType.WOOL));
    public static final Block FANCY_PURPLE_WOOL = registerBlock("fancy_purple_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.PURPLE)).sound(SoundType.WOOL));
    public static final Block FANCY_BLACK_WOOL = registerBlock("fancy_black_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.BLACK)).sound(SoundType.WOOL));
    public static final Block FANCY_LIGHT_GRAY_WOOL = registerBlock("fancy_light_gray_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIGHT_GRAY)).sound(SoundType.WOOL));
    public static final Block FANCY_GRAY_WOOL = registerBlock("fancy_gray_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GRAY)).sound(SoundType.WOOL));
    public static final Block FANCY_LIME_WOOL = registerBlock("fancy_lime_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.LIME)).sound(SoundType.WOOL));
    public static final Block FANCY_GREEN_WOOL = registerBlock("fancy_green_wool",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.GREEN)).sound(SoundType.WOOL));
    public static final Block FANCY_ORANGE_WOOL = registerBlock("fancy_orange_wool",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.ORANGE)).sound(SoundType.WOOL));
    public static final Block FANCY_RED_WOOL = registerBlock("fancy_red_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.RED)).sound(SoundType.WOOL));
    public static final Block FANCY_YELLOW_WOOL = registerBlock("fancy_yellow_wool",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.pick(DyeColor.YELLOW)).sound(SoundType.WOOL));

    //Carpets

    public static final Block FANCY_WHITE_CARPET = registerBlock("fancy_white_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.WHITE)).sound(SoundType.WOOL));
    public static final Block FANCY_BLUE_CARPET = registerBlock("fancy_blue_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.BLUE)).sound(SoundType.WOOL));
    public static final Block FANCY_CYAN_CARPET = registerBlock("fancy_cyan_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.CYAN)).sound(SoundType.WOOL));
    public static final Block FANCY_LIGHT_BLUE_CARPET = registerBlock("fancy_light_blue_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.LIGHT_BLUE)).sound(SoundType.WOOL));
    public static final Block FANCY_BROWN_CARPET = registerBlock("fancy_brown_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.BROWN)).sound(SoundType.WOOL));
    public static final Block FANCY_PINK_CARPET = registerBlock("fancy_pink_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.PINK)).sound(SoundType.WOOL));
    public static final Block FANCY_MAGENTA_CARPET = registerBlock("fancy_magenta_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.MAGENTA)).sound(SoundType.WOOL));
    public static final Block FANCY_PURPLE_CARPET = registerBlock("fancy_purple_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.PURPLE)).sound(SoundType.WOOL));
    public static final Block FANCY_BLACK_CARPET = registerBlock("fancy_black_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.BLACK)).sound(SoundType.WOOL));
    public static final Block FANCY_LIGHT_GRAY_CARPET = registerBlock("fancy_light_gray_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.LIGHT_GRAY)).sound(SoundType.WOOL));
    public static final Block FANCY_GRAY_CARPET = registerBlock("fancy_gray_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.GRAY)).sound(SoundType.WOOL));
    public static final Block FANCY_LIME_CARPET = registerBlock("fancy_lime_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.LIME)).sound(SoundType.WOOL));
    public static final Block FANCY_GREEN_CARPET = registerBlock("fancy_green_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.GREEN)).sound(SoundType.WOOL));
    public static final Block FANCY_ORANGE_CARPET = registerBlock("fancy_orange_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.ORANGE)).sound(SoundType.WOOL));
    public static final Block FANCY_RED_CARPET = registerBlock("fancy_red_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.RED)).sound(SoundType.WOOL));
    public static final Block FANCY_YELLOW_CARPET = registerBlock("fancy_yellow_carpet",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.CARPET.pick(DyeColor.YELLOW)).sound(SoundType.WOOL));

    //sandstone

    public static final Block GILDED_SANDSTONE = registerBlock("gilded_sandstone",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE).sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops());
    public static final Block GILDED_CUT_SANDSTONE = registerBlock("gilded_cut_sandstone",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE).sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops());
    public static final Block GILDED_CHISELED_SANDSTONE = registerBlock("gilded_chiseled_sandstone",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE).sound(SoundType.GILDED_BLACKSTONE).requiresCorrectToolForDrops());


    public static final Block DESERT_OAK_LOG = registerBlock("desert_oak_log",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f));

    public static final TreeGrower DESERT_OAK = new TreeGrower("desert_oak",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.DESERT_OAK_KEY),
            Optional.empty());
    public static final Block DESERT_OAK_SAPLING = registerBlock("desert_oak_sapling",
            settings -> new SaplingBlock(DESERT_OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final Block DESERT_OAK_WOOD = registerBlock("desert_oak_wood",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f));

    public static final Block STRIPPED_DESERT_OAK_LOG = registerBlock("stripped_desert_oak_log",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f));

    public static final Block STRIPPED_DESERT_OAK_WOOD = registerBlock("stripped_desert_oak_wood",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f));

    public static final Block DESERT_OAK_PLANKS = registerBlock("desert_oak_planks",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(3f));

    public static final Block DESERT_OAK_BUTTON = registerBlock("desert_oak_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 10, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON));
    public static final Block DESERT_OAK_PRESSURE_PLATE = registerBlock("desert_oak_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));


    public static final Identifier DESERT_OAK_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "entity/signs/desert_oak");
    public static final Identifier DESERT_OAK_HANGING_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "entity/signs/hanging/desert_oak");
    public static final Identifier DESERT_OAK_HANGING_GUI_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/gui/hanging_signs/desert_oak");
    // Fancy Bits for the desert oak
    public static final Block DESERT_OAK_STAIRS = registerBlock("desert_oak_stairs",
            settings -> new StairBlock(ModBlocks.DESERT_OAK_PLANKS.defaultBlockState(), settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final Block DESERT_OAK_SLAB = registerBlock("desert_oak_slab",
            SlabBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));

    public static final Block DESERT_OAK_FENCE = registerBlock("desert_oak_fence",
            FenceBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final Block DESERT_OAK_FENCE_GATE = registerBlock("desert_oak_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));

    public static final Block DESERT_OAK_DOOR = registerBlock("desert_oak_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());
    public static final Block DESERT_OAK_TRAPDOOR = registerBlock("desert_oak_trapdoor",
            settings -> new TrapDoorBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion());




    public static final Block TERRACOTTA_BRICKS = registerBlock("terracotta_bricks",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA).requiresCorrectToolForDrops());

    public static final BlockFamily TERRACOTTA_BRICK_FAMILY = BlockFamilies.familyBuilder(ModBlocks.TERRACOTTA_BRICKS)
            .recipeGroupPrefix("terracotta_group").getFamily();



    public static final Block FOSSIL_SOIL = registerBlock(
            "fossil_soil",
            settings -> new FossilSoilBlock(
                    Blocks.AIR,
                    SoundEvents.BRUSH_GRAVEL,
                    SoundEvents.GRAVEL_BREAK,
                    settings),BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_BROWN)
                            .instrument(NoteBlockInstrument.SNARE)
                            .strength(0.25F)
                            .sound(SoundType.SUSPICIOUS_GRAVEL)
                            .pushReaction(PushReaction.DESTROY)
    );

    public static final Block PETRIFIED_DIRT = registerBlock("petrified_dirt",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.COARSE_DIRT).strength(2f));

    public static final Block TERRACOTTA_BRICK_STAIRS = registerBlock("terracotta_brick_stairs",
            settings -> new StairBlock(ModBlocks.TERRACOTTA_BRICKS.defaultBlockState(), settings),BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops());

    public static final Block TERRACOTTA_BRICK_SLAB = registerBlock("terracotta_brick_slab",
            SlabBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops());

    public static final Block TERRACOTTA_BRICK_WALL= registerBlock("terracotta_brick_wall",
            WallBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops());



    public static final Block SPICE_BARREL = registerBlock("spice_barrel",
            SpiceBarrelBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));


    public static final Block GUANO_PILE = registerBlock("guano_pile",
            CarpetBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_CARPET).noOcclusion()
                    .noCollision().sound(SoundType.HONEY_BLOCK));

    public static final Block GUANO_BLOCK = registerBlock("guano_block",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_BLOCK)
                    .sound(SoundType.HONEY_BLOCK));

    public static final Block PACKED_GUANO = registerBlock("packed_guano",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)
                    .sound(SoundType.PACKED_MUD));
    public static final Block GUANO_BRICKS = registerBlock("guano_bricks",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.PACKED_MUD)
                    .sound(SoundType.PACKED_MUD));

    public static final BlockFamily GUANO_FAMILY = BlockFamilies.familyBuilder(ModBlocks.GUANO_BRICKS)
            .recipeGroupPrefix("guano_group").getFamily();

    public static final Block GUANO_BRICK_STAIRS = registerBlock("guano_brick_stairs",
            settings -> new StairBlock(ModBlocks.GUANO_BRICKS.defaultBlockState(), settings),BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS).requiresCorrectToolForDrops());

    public static final Block GUANO_BRICK_SLAB = registerBlock("guano_brick_slab",
            SlabBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB).requiresCorrectToolForDrops());

    public static final Block GUANO_BRICK_WALL= registerBlock("guano_brick_wall",
            WallBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).requiresCorrectToolForDrops());



    public static final Block SLIME_DRIP = registerBlock("slime_drip",
            SlimeHangingDripBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.HANGING_ROOTS).noOcclusion()
                    .noCollision().sound(SoundType.SLIME_BLOCK));

    public static final Block SLIMEY_STONE = registerBlock("slimey_stone",
            SlimeDripBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).randomTicks());

    public static final Block DEAD_LEAVES = registerBlock(
            "dead_leaves",
            settings -> new UntintedParticleLeavesBlock(1.0f / 50.0f, JaizMod.DEAD_LEAF_PARTICLE, settings),
            createLeavesSettings(SoundType.WET_GRASS).mapColor(MapColor.COLOR_BROWN)
    );


    public static final Block DRIED_LEAVES = registerBlock(
            "dried_leaves",
            settings -> new DriedLeavesBlock(50, JaizMod.DRY_LEAF_PARTICLE, settings),
            createLeavesSettings(SoundType.GRASS).mapColor(MapColor.COLOR_ORANGE)
    );

    public static final Block BLOOMING_IVY_BLOCK = registerBlock(
            "blooming_ivy_block",
            settings -> new DriedLeavesBlock(50, JaizMod.BLOOMING_IVY_PARTICLE, settings),
            createLeavesSettings(SoundType.GRASS).mapColor(MapColor.WARPED_NYLIUM)
    );

    public static final Block SNOWY_LEAVES = registerBlock(
            "snowy_leaves",
            settings -> new UntintedParticleLeavesBlock(1.0f / 50.0f, JaizMod.SNOW_PARTICLE, settings),
            createLeavesSettings(SoundType.SNOW).mapColor(MapColor.QUARTZ)
    );

    public static final Block DESERT_OAK_LEAVES = registerBlock("desert_oak_leaves", settings -> new TintedParticleLeavesBlock(0.01F, settings), createLeavesSettings(SoundType.GRASS));
    public static final Block MAHOGANY_LEAVES = registerBlock("mahogany_leaves", settings -> new TintedParticleLeavesBlock(0.01F, settings), createLeavesSettings(SoundType.GRASS));

    public static BlockBehaviour.Properties createLeavesSettings(SoundType sounds) {
        return BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES).sound(sounds);
    }

    public static final Block MAHOGANY_LOG = registerBlock("mahogany_log",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).ignitedByLava());

    public static final Block MAHOGANY_WOOD = registerBlock("mahogany_wood",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).ignitedByLava());

    public static final Block STRIPPED_MAHOGANY_LOG = registerBlock("stripped_mahogany_log",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).ignitedByLava());

    public static final Block STRIPPED_MAHOGANY_WOOD = registerBlock("stripped_mahogany_wood",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).ignitedByLava());

    public static final Block MAHOGANY_PLANKS = registerBlock("mahogany_planks",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).ignitedByLava());

    public static final Block MAHOGANY_BUTTON = registerBlock("mahogany_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 10, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).ignitedByLava());
    public static final Block MAHOGANY_PRESSURE_PLATE = registerBlock("mahogany_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).ignitedByLava());

    public static final Identifier MAHOGANY_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "entity/signs/mahogany");
    public static final Identifier MAHOGANY_HANGING_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "entity/signs/hanging/mahogany");
    public static final Identifier MAHOGANY_HANGING_GUI_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/gui/hanging_signs/mahogany");


    public static final Block MAHOGANY_STAIRS = registerBlock("mahogany_stairs",
            settings -> new StairBlock(ModBlocks.MAHOGANY_PLANKS.defaultBlockState(), settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).ignitedByLava());
    public static final Block MAHOGANY_SLAB = registerBlock("mahogany_slab",
            SlabBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).ignitedByLava());

    public static final Block MAHOGANY_FENCE = registerBlock("mahogany_fence",
            FenceBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).ignitedByLava());
    public static final Block MAHOGANY_FENCE_GATE = registerBlock("mahogany_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).ignitedByLava());

    public static final Block MAHOGANY_DOOR = registerBlock("mahogany_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion().ignitedByLava());
    public static final Block MAHOGANY_TRAPDOOR = registerBlock("mahogany_trapdoor",
            settings -> new TrapDoorBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_TRAPDOOR).noOcclusion().ignitedByLava());

    public static final TreeGrower MAHOGANY = new TreeGrower("mahogany_tree",
            Optional.of(ModConfiguredFeatures.MAHOGANY_TREE),
            Optional.of(ModConfiguredFeatures.SMALL_MAHOGANY_TREE),
            Optional.empty());
    public static final TreeGrower AUTUMN = new TreeGrower("autumn_tree",
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.AUTUMN_TREE),
            Optional.empty());

    public static final Block MAHOGANY_SAPLING = registerBlock("mahogany_sapling",
            settings -> new SaplingBlock(MAHOGANY, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final Block AUTUMN_SAPLING = registerBlock("autumn_sapling",
            settings -> new SaplingBlock(AUTUMN, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final Block FIREFLY_BOTTLE = registerBlock("firefly_bottle",
            FireflyBottleBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(SoundType.GLASS).lightLevel(state -> 15));

    public static final Block COCOON_BLOCK = registerBlock("cocoon_block",
            CocoonBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.HONEY_BLOCK).sound(SoundType.HONEY_BLOCK));

    public static final Block ROT_BLOCK = registerBlock("rot_block", settings ->
            new RotBlock(ModConfiguredFeatures.ROT_DIRT, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).sound(SoundType.MUD).randomTicks());

    public static final Block IVY = registerBlock("ivy",
            IvyBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.VINE).sound(SoundType.VINE).randomTicks());

    public static final Block UNDERGROWTH = registerBlock("undergrowth",
            UndergrowthBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.MOSS_CARPET).sound(SoundType.WET_GRASS).noCollision().instabreak().replaceable());

    public static final Block SHELF_MUSHROOM_BLOCK = registerBlock("shelf_mushroom",
            ShelfMushroomBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.MUSHROOM_STEM).sound(SoundType.SHROOMLIGHT).bounceRestitution(1.0F));

    public static final Block CALLALILY_WHITE = registerBlock("callalily_white",
            TallFlowerBlock::new,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY));

    public static final Block CALLALILY_PINK = registerBlock("callalily_pink",
            TallFlowerBlock::new,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY));

    public static final Block CALLALILY_YELLOW = registerBlock("callalily_yellow",
            TallFlowerBlock::new,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY));

    public static final Block CALLALILY_LILAC = registerBlock("callalily_lilac",
            TallFlowerBlock::new,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY));

    public static final Block CALLALILY_PURPLE = registerBlock("callalily_purple",
            TallFlowerBlock::new,BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY));

    public static final Block ROT_ROOTS = registerBlock("rot_roots",
            settings -> new FlowerBlock(MobEffects.DARKNESS, 60, settings),BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollision().instabreak().sound(SoundType.MUD).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));

    public static final Block COLUMBINE = registerBlock("columbine",
            settings -> new FlowerBlock(MobEffects.DARKNESS, 60, settings),BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollision().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));

    //Rotten Wood

    public static final Block ROTTEN_LOG = registerBlock("rotten_log",
            RottingLog::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(2f).ignitedByLava().randomTicks());

    public static final Block ROTTEN_WOOD = registerBlock("rotten_wood",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f).ignitedByLava());

    public static final Block STRIPPED_ROTTEN_LOG = registerBlock("stripped_rotten_log",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(2f).ignitedByLava());

    public static final Block STRIPPED_ROTTEN_WOOD = registerBlock("stripped_rotten_wood",
            RotatedPillarBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(2f).ignitedByLava());

    public static final Block ROTTEN_PLANKS = registerBlock("rotten_planks",
            Block::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2f).ignitedByLava());

    public static final Block ROTTEN_BUTTON = registerBlock("rotten_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 10, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).ignitedByLava());
    public static final Block ROTTEN_PRESSURE_PLATE = registerBlock("rotten_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).ignitedByLava());

    public static final Identifier ROTTEN_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "entity/signs/rotten");
    public static final Identifier ROTTEN_HANGING_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "entity/signs/hanging/rotten");
    public static final Identifier ROTTEN_HANGING_GUI_SIGN_TEXTURE = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, "textures/gui/hanging_signs/rotten");

    public static final WoodType ROTTEN_SIGN_TYPE = registerWoodType("rotten");
    public static final WoodType DESERT_OAK_SIGN_TYPE = registerWoodType("desert_oak");
    public static final WoodType MAHOGANY_SIGN_TYPE = registerWoodType("mahogany");

    public static final Block HANGING_ROTTEN_SIGN = registerSignBlock("rotten_hanging_sign", settings -> new CeilingHangingSignBlock(ROTTEN_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN));
    public static final Block WALL_HANGING_ROTTEN_SIGN = registerSignBlock("rotten_wall_hanging_sign", settings -> new WallHangingSignBlock(ROTTEN_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).overrideLootTable(HANGING_ROTTEN_SIGN.getLootTable()));
    public static final Block STANDING_ROTTEN_SIGN = registerSignBlock("rotten_standing_sign", settings -> new StandingSignBlock(ROTTEN_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN));
    public static final Block WALL_ROTTEN_SIGN = registerSignBlock("rotten_wall_sign", settings -> new WallSignBlock(ROTTEN_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)
            .overrideLootTable(STANDING_ROTTEN_SIGN.getLootTable()));

    public static final Block HANGING_DESERT_OAK_SIGN = registerSignBlock("desert_oak_hanging_sign", settings -> new CeilingHangingSignBlock(DESERT_OAK_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN));
    public static final Block WALL_HANGING_DESERT_OAK_SIGN = registerSignBlock("desert_oak_wall_hanging_sign", settings -> new WallHangingSignBlock(DESERT_OAK_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).overrideLootTable(HANGING_DESERT_OAK_SIGN.getLootTable()));
    public static final Block STANDING_DESERT_OAK_SIGN = registerSignBlock("desert_oak_standing_sign", settings -> new StandingSignBlock(DESERT_OAK_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN));
    public static final Block WALL_DESERT_OAK_SIGN = registerSignBlock("desert_oak_wall_sign", settings -> new WallSignBlock(DESERT_OAK_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)
            .overrideLootTable(STANDING_DESERT_OAK_SIGN.getLootTable()));

    public static final Block HANGING_MAHOGANY_SIGN = registerSignBlock("mahogany_hanging_sign", settings -> new CeilingHangingSignBlock(MAHOGANY_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN));
    public static final Block WALL_HANGING_MAHOGANY_SIGN = registerSignBlock("mahogany_wall_hanging_sign", settings -> new WallHangingSignBlock(MAHOGANY_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN).overrideLootTable(HANGING_MAHOGANY_SIGN.getLootTable()));
    public static final Block STANDING_MAHOGANY_SIGN = registerSignBlock("mahogany_standing_sign", settings -> new StandingSignBlock(MAHOGANY_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN));
    public static final Block WALL_MAHOGANY_SIGN = registerSignBlock("mahogany_wall_sign", settings -> new WallSignBlock(MAHOGANY_SIGN_TYPE, settings), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)
            .overrideLootTable(STANDING_MAHOGANY_SIGN.getLootTable()));

    public static final BlockFamily DESERT_OAK_FAMILY = BlockFamilies.familyBuilder(ModBlocks.DESERT_OAK_PLANKS)
            .sign(ModBlocks.STANDING_DESERT_OAK_SIGN, ModBlocks.WALL_DESERT_OAK_SIGN)
            .customHangingSign(ModBlocks.HANGING_DESERT_OAK_SIGN, ModBlocks.WALL_HANGING_DESERT_OAK_SIGN)
           .recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();

    public static final BlockFamily MAHOGANY_FAMILY = BlockFamilies.familyBuilder(ModBlocks.MAHOGANY_PLANKS)
            .sign(ModBlocks.STANDING_MAHOGANY_SIGN, ModBlocks.WALL_MAHOGANY_SIGN)
            .customHangingSign(ModBlocks.HANGING_MAHOGANY_SIGN, ModBlocks.WALL_HANGING_MAHOGANY_SIGN)
            .recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();

    public static final BlockFamily ROTTEN_FAMILY = BlockFamilies.familyBuilder(ModBlocks.ROTTEN_PLANKS)
            .sign(ModBlocks.STANDING_ROTTEN_SIGN, ModBlocks.WALL_ROTTEN_SIGN)
            .customHangingSign(ModBlocks.HANGING_ROTTEN_SIGN, ModBlocks.WALL_HANGING_ROTTEN_SIGN)
            .recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();



    public static final Block ROTTEN_STAIRS = registerBlock("rotten_stairs",
            settings -> new StairBlock(ModBlocks.ROTTEN_PLANKS.defaultBlockState(), settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).ignitedByLava());
    public static final Block ROTTEN_SLAB = registerBlock("rotten_slab",
            SlabBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).ignitedByLava());

    public static final Block ROTTEN_FENCE = registerBlock("rotten_fence",
            FenceBlock::new,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).ignitedByLava());
    public static final Block ROTTEN_FENCE_GATE = registerBlock("rotten_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).ignitedByLava());

    public static final Block ROTTEN_DOOR = registerBlock("rotten_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion().ignitedByLava());

    public static final Block ROTTEN_TRAPDOOR = registerBlock("rotten_trapdoor",
            settings -> new TrapDoorBlock(BlockSetType.OAK, settings),BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion().ignitedByLava());



    public static final Block WATER_TORCH = registerBlock(
            "water_torch",
            settings -> new WaterTorchBlock(
                    ParticleTypes.GLOW,settings),
                    BlockBehaviour.Properties.of().noCollision().instabreak()
                            .lightLevel(state -> WallWaterTorchBlock.isDry(state) ? 3 : 15)
                            .sound(SoundType.AMETHYST)
                            .pushReaction(PushReaction.DESTROY)
    );

    public static final Block WALL_WATER_TORCH = registerBlock(
            "wall_water_torch",
            settings -> new WallWaterTorchBlock(
                    ParticleTypes.GLOW,settings),
                    BlockBehaviour.Properties.of()
                            .noCollision()
                            .instabreak()
                            .lightLevel(state -> WallWaterTorchBlock.isDry(state) ? 3 : 15)
                            .sound(SoundType.AMETHYST)
                            .pushReaction(PushReaction.DESTROY)
    );

    //Main Bits

    public static <B extends Block> B registerBlock(String name, Function<BlockBehaviour.Properties, B> factory, BlockBehaviour.Properties settings) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name));
        B block = factory.apply(settings.setId(key));

        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    public static <B extends SignBlock> B registerSignBlock(String name, Function<BlockBehaviour.Properties, B> factory, BlockBehaviour.Properties settings) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name));
        B block = factory.apply(settings.setId(key));

        if (block instanceof StandingSignBlock || block instanceof WallSignBlock) {
            ((FabricBlockEntityType) (Object) BlockEntityTypes.SIGN).addValidBlock(block);
        } else if (block instanceof CeilingHangingSignBlock || block instanceof WallHangingSignBlock) {
            ((FabricBlockEntityType) (Object) BlockEntityTypes.HANGING_SIGN).addValidBlock(block);
        } else {
            throw new IllegalArgumentException("Unsupported sign block: " + block.getClass().getName());
        }

        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    private static WoodType registerWoodType(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(JaizMod.MOD_ID, name);
        BlockSetType blockSetType = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(id);
        return WoodTypeBuilder.copyOf(WoodType.OAK).register(id, blockSetType);
    }

    public static void registerModBlocks() {
        JaizMod.LOGGER.info("Registering ModBlocks for " + JaizMod.MOD_ID);
    }

}
