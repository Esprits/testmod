package net.esprits.testmod.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlockRegistry {
    public static void registerFlammableBlock() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.BLOOD_TREE_LOG, 5, 5);
        registry.add(ModBlocks.BLOOD_TREE_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_BLOOD_TREE_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_BLOOD_TREE_WOOD, 5, 5);

        registry.add(ModBlocks.BLOOD_TREE_LEAVES, 30, 60);
        registry.add(ModBlocks.BLOOD_TREE_PLANKS, 5, 20);
    }
}
