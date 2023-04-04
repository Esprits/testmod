package net.esprits.testmod.block;

import net.esprits.testmod.TestMod;
import net.esprits.testmod.item.ModItemGroup;
import net.esprits.testmod.item.ModItems;
import net.esprits.testmod.world.tree.BloodTreeSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLOOD_BLOCK = registerBlock("blood_block",
            new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT)
                    .strength(0.5f)), ModItemGroup.ALCHEMY);

    public static final Block BLOOD_TREE_LOG = registerBlock("blood_tree_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_LOG)), ModItemGroup.ALCHEMY);
    public static final Block BLOOD_TREE_WOOD = registerBlock("blood_tree_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_WOOD)), ModItemGroup.ALCHEMY);
    public static final Block STRIPPED_BLOOD_TREE_LOG = registerBlock("stripped_blood_tree_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_MANGROVE_LOG)), ModItemGroup.ALCHEMY);
    public static final Block STRIPPED_BLOOD_TREE_WOOD = registerBlock("stripped_blood_tree_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_MANGROVE_WOOD)), ModItemGroup.ALCHEMY);

    public static final Block BLOOD_TREE_PLANKS = registerBlock("blood_tree_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS)), ModItemGroup.ALCHEMY);
    public static final Block BLOOD_TREE_LEAVES = registerBlock("blood_tree_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_LEAVES)), ModItemGroup.ALCHEMY);

    public static final Block BLOOD_TREE_SAPLING = registerBlock("blood_tree_sapling",
            new SaplingBlock(new BloodTreeSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.ACACIA_SAPLING)), ModItemGroup.ALCHEMY);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering ModBlocks for " + TestMod.MOD_ID);
    }
}
