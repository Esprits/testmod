package net.esprits.testmod;

import net.esprits.testmod.block.ModBlocks;
import net.esprits.testmod.block.ModFlammableBlockRegistry;
import net.esprits.testmod.data.ModWorldGenerator;
import net.esprits.testmod.item.ModItemGroup;
import net.esprits.testmod.item.ModItems;
import net.esprits.testmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
    public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModWorldGeneration.generateModWorldGen();

        ModFlammableBlockRegistry.registerFlammableBlock();
        StrippableBlockRegistry.register(ModBlocks.BLOOD_TREE_LOG, ModBlocks.STRIPPED_BLOOD_TREE_LOG);
        StrippableBlockRegistry.register(ModBlocks.BLOOD_TREE_WOOD, ModBlocks.STRIPPED_BLOOD_TREE_WOOD);
    }
}
