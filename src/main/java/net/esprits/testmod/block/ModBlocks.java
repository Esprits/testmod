package net.esprits.testmod.block;

import net.esprits.testmod.TestMod;
import net.esprits.testmod.item.ModItemGroup;
import net.esprits.testmod.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.HayBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block BLOOD_BLOCK = registerBlock("blood_block",
            new Block(FabricBlockSettings.of(Material.ORGANIC_PRODUCT)
                    .strength(0.5f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        return item;
    }

    public static void addBlockItemsToItemGroup() {
        ModItems.addToItemGroup(ItemGroups.NATURAL, BLOOD_BLOCK.asItem());
        ModItems.addToItemGroup(ModItemGroup.ALCHEMY, BLOOD_BLOCK.asItem());
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering ModBlocks for " + TestMod.MOD_ID);
        addBlockItemsToItemGroup();
    }
}
