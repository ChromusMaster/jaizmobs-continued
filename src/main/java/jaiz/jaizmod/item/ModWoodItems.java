package jaiz.jaizmod.item;

import jaiz.jaizmod.block.ModWoodSets;
import net.minecraft.world.item.BlockItem;

import java.util.List;

public final class ModWoodItems {
    public static final WoodItems CUMARU = register(ModWoodSets.CUMARU);
    public static final WoodItems EBONY = register(ModWoodSets.EBONY);
    public static final WoodItems FLAMBOYANT = register(ModWoodSets.FLAMBOYANT);
    public static final WoodItems ATLAS_CEDAR = register(ModWoodSets.ATLAS_CEDAR);
    public static final WoodItems BISMARCK_PALM = register(ModWoodSets.BISMARCK_PALM);
    public static final WoodItems CANNONBALL = register(ModWoodSets.CANNONBALL);
    public static final WoodItems SEQUOIA = register(ModWoodSets.SEQUOIA);
    public static final List<WoodItems> ALL = List.of(CUMARU, EBONY, FLAMBOYANT, ATLAS_CEDAR, BISMARCK_PALM, CANNONBALL, SEQUOIA);

    public static final BlockItem THATCH = ModItems.registerBlockItem("thatch", ModWoodSets.THATCH);
    public static final BlockItem THATCH_STAIRS = ModItems.registerBlockItem("thatch_stairs", ModWoodSets.THATCH_STAIRS);
    public static final BlockItem THATCH_SLAB = ModItems.registerBlockItem("thatch_slab", ModWoodSets.THATCH_SLAB);

    public static void initialize() {
    }

    private ModWoodItems() {
    }

    private static WoodItems register(ModWoodSets.WoodSet wood) {
        String name = wood.name();
        return new WoodItems(name,
                ModItems.registerBlockItem(name + "_log", wood.log()),
                ModItems.registerBlockItem(name + "_wood", wood.wood()),
                ModItems.registerBlockItem("stripped_" + name + "_log", wood.strippedLog()),
                ModItems.registerBlockItem("stripped_" + name + "_wood", wood.strippedWood()),
                ModItems.registerBlockItem(name + "_planks", wood.planks()),
                ModItems.registerBlockItem(name + "_stairs", wood.stairs()),
                ModItems.registerBlockItem(name + "_slab", wood.slab()),
                ModItems.registerBlockItem(name + "_fence", wood.fence()),
                ModItems.registerBlockItem(name + "_fence_gate", wood.fenceGate()),
                ModItems.registerBlockItem(name + "_door", wood.door()),
                ModItems.registerBlockItem(name + "_trapdoor", wood.trapdoor()),
                ModItems.registerBlockItem(name + "_button", wood.button()),
                ModItems.registerBlockItem(name + "_pressure_plate", wood.pressurePlate()),
                ModItems.registerBlockItem(name + "_leaves", wood.leaves()),
                ModItems.registerBlockItem(name + "_sapling", wood.sapling()));
    }

    public record WoodItems(String name, BlockItem log, BlockItem wood, BlockItem strippedLog,
                            BlockItem strippedWood, BlockItem planks, BlockItem stairs, BlockItem slab,
                            BlockItem fence, BlockItem fenceGate, BlockItem door, BlockItem trapdoor,
                            BlockItem button, BlockItem pressurePlate, BlockItem leaves, BlockItem sapling) {
        public List<BlockItem> all() {
            return List.of(log, wood, strippedLog, strippedWood, planks, stairs, slab, fence, fenceGate,
                    door, trapdoor, button, pressurePlate, leaves, sapling);
        }
    }
}
