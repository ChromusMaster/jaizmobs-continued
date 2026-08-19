package net.jaiz.jaizmobs.block;

import java.util.function.Function;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.jaiz.jaizmobs.JaizMobs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.util.valueproviders.UniformInt;

public final class ModBlocks {
    public static final Block SULFUR_ORE = register(
            "sulfur_ore",
            properties -> new DropExperienceBlock(UniformInt.of(1, 3), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.BASALT).strength(4.0F).requiresCorrectToolForDrops()
    );

    private ModBlocks() {
    }

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> factory,
                                  BlockBehaviour.Properties properties) {
        Identifier identifier = Identifier.fromNamespaceAndPath(JaizMobs.MOD_ID, name);
        BlockItemId id = BlockItemId.create(identifier, identifier);
        Block block = factory.apply(properties.setId(id.block()));
        Registry.register(BuiltInRegistries.BLOCK, id.block(), block);
        BlockItem item = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), item);
        return block;
    }

    public static void registerModBlocks() {
        JaizMobs.LOGGER.info("Registering mod blocks for {}", JaizMobs.MOD_ID);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS)
                .register(output -> output.accept(SULFUR_ORE));
    }
}
