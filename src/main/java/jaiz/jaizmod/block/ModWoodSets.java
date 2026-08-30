package jaiz.jaizmod.block;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.custom.GuaranaBushBlock;
import jaiz.jaizmod.worldgen.features.ModConfiguredFeatures;
import jaiz.jaizmod.worldgen.features.ModPlacedFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TintedParticleLeavesBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.UntintedParticleLeavesBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public final class ModWoodSets {
    public static final WoodSet CUMARU = register("cumaru", false, false);
    public static final WoodSet EBONY = register("ebony", false, false);
    public static final WoodSet FLAMBOYANT = register("flamboyant", false, true);
    public static final WoodSet ATLAS_CEDAR = register("atlas_cedar", false, false);
    public static final WoodSet BISMARCK_PALM = register("bismarck_palm", false, false);
    public static final WoodSet CANNONBALL = register("cannonball", false, false);
    public static final WoodSet SEQUOIA = register("sequoia", true, false);
    public static final List<WoodSet> ALL = List.of(CUMARU, EBONY, FLAMBOYANT, ATLAS_CEDAR, BISMARCK_PALM, CANNONBALL, SEQUOIA);

    public static final Block GUARANA_BUSH = ModBlocks.registerBlock("guarana_bush", GuaranaBushBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH).randomTicks());
    public static final Block THATCH = ModBlocks.registerBlock("thatch", Block::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK).sound(SoundType.GRASS));
    public static final Block THATCH_STAIRS = ModBlocks.registerBlock("thatch_stairs",
            properties -> new StairBlock(THATCH.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).sound(SoundType.GRASS));
    public static final Block THATCH_SLAB = ModBlocks.registerBlock("thatch_slab", SlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).sound(SoundType.GRASS));

    private ModWoodSets() {
    }

    private static WoodSet register(String name, boolean mega, boolean untintedLeaves) {
        ResourceKey<ConfiguredFeature<?, ?>> treeKey = ModConfiguredFeatures.registerKey(name + "_tree");
        ResourceKey<ConfiguredFeature<?, ?>> megaTreeKey = mega ? ModConfiguredFeatures.registerKey("giant_" + name + "_tree") : null;
        ResourceKey<PlacedFeature> placedKey = ModPlacedFeatures.registerKey(name + "_tree_placed");
        TreeGrower treeGrower = new TreeGrower(name,
                Optional.ofNullable(megaTreeKey), Optional.of(treeKey), Optional.empty());

        Block log = ModBlocks.registerBlock(name + "_log", RotatedPillarBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).ignitedByLava());
        Block wood = ModBlocks.registerBlock(name + "_wood", RotatedPillarBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).ignitedByLava());
        Block strippedLog = ModBlocks.registerBlock("stripped_" + name + "_log", RotatedPillarBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).ignitedByLava());
        Block strippedWood = ModBlocks.registerBlock("stripped_" + name + "_wood", RotatedPillarBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).ignitedByLava());
        Block planks = ModBlocks.registerBlock(name + "_planks", Block::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).ignitedByLava());
        Block stairs = ModBlocks.registerBlock(name + "_stairs", properties -> new StairBlock(planks.defaultBlockState(), properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).ignitedByLava());
        Block slab = ModBlocks.registerBlock(name + "_slab", SlabBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).ignitedByLava());
        Block fence = ModBlocks.registerBlock(name + "_fence", FenceBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE).ignitedByLava());
        Block fenceGate = ModBlocks.registerBlock(name + "_fence_gate", properties -> new FenceGateBlock(WoodType.OAK, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE).ignitedByLava());
        Block door = ModBlocks.registerBlock(name + "_door", properties -> new DoorBlock(BlockSetType.OAK, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).noOcclusion().ignitedByLava());
        Block trapdoor = ModBlocks.registerBlock(name + "_trapdoor", properties -> new TrapDoorBlock(BlockSetType.OAK, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).noOcclusion().ignitedByLava());
        Block button = ModBlocks.registerBlock(name + "_button", properties -> new ButtonBlock(BlockSetType.OAK, 10, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON).ignitedByLava());
        Block pressurePlate = ModBlocks.registerBlock(name + "_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.OAK, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE).ignitedByLava());
        Block leaves = untintedLeaves
                ? ModBlocks.registerBlock(name + "_leaves", properties -> new UntintedParticleLeavesBlock(0.02F, JaizMod.DRY_LEAF_PARTICLE, properties), ModBlocks.createLeavesSettings(SoundType.GRASS))
                : ModBlocks.registerBlock(name + "_leaves", properties -> new TintedParticleLeavesBlock(0.01F, properties), ModBlocks.createLeavesSettings(SoundType.GRASS));
        Block sapling = ModBlocks.registerBlock(name + "_sapling", properties -> new SaplingBlock(treeGrower, properties),
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));

        return new WoodSet(name, treeKey, megaTreeKey, placedKey, log, wood, strippedLog, strippedWood, planks,
                stairs, slab, fence, fenceGate, door, trapdoor, button, pressurePlate, leaves, sapling);
    }

    public record WoodSet(String name, ResourceKey<ConfiguredFeature<?, ?>> treeKey,
                          ResourceKey<ConfiguredFeature<?, ?>> megaTreeKey, ResourceKey<PlacedFeature> placedKey,
                          Block log, Block wood, Block strippedLog, Block strippedWood, Block planks,
                          Block stairs, Block slab, Block fence, Block fenceGate, Block door, Block trapdoor,
                          Block button, Block pressurePlate, Block leaves, Block sapling) {
    }
}
