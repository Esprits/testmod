package net.esprits.testmod.data;

import net.esprits.testmod.block.ModBlocks;
import net.esprits.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOOD_BLOCK);

        addDrop(ModBlocks.BLOOD_TREE_LOG);
        addDrop(ModBlocks.BLOOD_TREE_WOOD);
        addDrop(ModBlocks.STRIPPED_BLOOD_TREE_LOG);
        addDrop(ModBlocks.STRIPPED_BLOOD_TREE_WOOD);
        addDrop(ModBlocks.BLOOD_TREE_PLANKS);
        addDrop(ModBlocks.BLOOD_TREE_SAPLING);
        addDropWithSilkTouch(ModBlocks.BLOOD_TREE_LEAVES);
    }
}
